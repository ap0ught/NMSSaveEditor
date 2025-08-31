// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.AWTEvent;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import java.awt.Container;
import javax.swing.CellRendererPane;
import java.awt.Rectangle;
import java.util.Objects;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Iterator;
import com.formdev.flatlaf.icons.FlatCheckBoxIcon;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.plaf.basic.BasicButtonListener;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import java.awt.Component;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Insets;
import java.util.Map;
import java.awt.Color;
import javax.swing.plaf.basic.BasicRadioButtonUI;

public class FlatRadioButtonUI extends BasicRadioButtonUI implements FlatStylingSupport.StyleableUI
{
    protected int iconTextGap;
    @FlatStylingSupport.Styleable
    protected Color disabledText;
    private Color defaultBackground;
    private final boolean shared;
    private boolean iconShared;
    private boolean defaults_initialized;
    private Map<String, Object> oldStyleValues;
    private static final Insets tempInsets;
    
    public static ComponentUI createUI(final JComponent c) {
        return (FlatUIUtils.canUseSharedUI(c) && !FlatUIUtils.needsLightAWTPeer(c)) ? FlatUIUtils.createSharedUI((Object)FlatRadioButtonUI.class, () -> new FlatRadioButtonUI(true)) : new FlatRadioButtonUI(false);
    }
    
    protected FlatRadioButtonUI(final boolean shared) {
        this.iconShared = true;
        this.defaults_initialized = false;
        this.shared = shared;
    }
    
    @Override
    public void installUI(final JComponent c) {
        if (FlatUIUtils.needsLightAWTPeer(c)) {
            FlatUIUtils.runWithLightAWTPeerUIDefaults(() -> this.installUIImpl(c));
        }
        else {
            this.installUIImpl(c);
        }
    }
    
    private void installUIImpl(final JComponent c) {
        super.installUI(c);
        if (FlatUIUtils.isAWTPeer(c)) {
            AWTPeerMouseExitedFix.install(c);
        }
        this.installStyle((AbstractButton)c);
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        if (FlatUIUtils.isAWTPeer(c)) {
            AWTPeerMouseExitedFix.uninstall(c);
        }
    }
    
    public void installDefaults(final AbstractButton b) {
        super.installDefaults(b);
        if (!this.defaults_initialized) {
            final String prefix = this.getPropertyPrefix();
            this.iconTextGap = FlatUIUtils.getUIInt(prefix + "iconTextGap", 4);
            this.disabledText = UIManager.getColor(prefix + "disabledText");
            this.defaultBackground = UIManager.getColor(prefix + "background");
            this.iconShared = true;
            this.defaults_initialized = true;
        }
        LookAndFeel.installProperty(b, "opaque", false);
        LookAndFeel.installProperty(b, "iconTextGap", UIScale.scale(this.iconTextGap));
        MigLayoutVisualPadding.install(b, null);
    }
    
    @Override
    protected void uninstallDefaults(final AbstractButton b) {
        super.uninstallDefaults(b);
        this.oldStyleValues = null;
        MigLayoutVisualPadding.uninstall(b);
        this.defaults_initialized = false;
    }
    
    @Override
    protected BasicButtonListener createButtonListener(final AbstractButton b) {
        return new FlatRadioButtonListener(b);
    }
    
    protected void propertyChange(final AbstractButton b, final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "FlatLaf.style":
            case "FlatLaf.styleClass": {
                if (this.shared && FlatStylingSupport.hasStyleProperty(b)) {
                    b.updateUI();
                }
                else {
                    this.installStyle(b);
                }
                b.revalidate();
                b.repaint();
                break;
            }
        }
    }
    
    protected void installStyle(final AbstractButton b) {
        try {
            this.applyStyle(b, FlatStylingSupport.getResolvedStyle(b, this.getStyleType()));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    String getStyleType() {
        return "RadioButton";
    }
    
    protected void applyStyle(final AbstractButton b, final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, (key, value) -> this.applyStyleProperty(b, key, value));
    }
    
    protected Object applyStyleProperty(final AbstractButton b, String key, final Object value) {
        if (!key.startsWith("icon.")) {
            return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, b, key, value);
        }
        if (!(this.icon instanceof FlatCheckBoxIcon)) {
            return new FlatStylingSupport.UnknownStyleException(key);
        }
        if (this.iconShared) {
            this.icon = FlatStylingSupport.cloneIcon(this.icon);
            this.iconShared = false;
        }
        key = key.substring("icon.".length());
        return ((FlatCheckBoxIcon)this.icon).applyStyleProperty(key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final Map<String, Class<?>> infos = FlatStylingSupport.getAnnotatedStyleableInfos(this);
        if (this.icon instanceof FlatCheckBoxIcon) {
            for (final Map.Entry<String, Class<?>> e : ((FlatCheckBoxIcon)this.icon).getStyleableInfos().entrySet()) {
                infos.put("icon.".concat(e.getKey()), e.getValue());
            }
        }
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        if (key.startsWith("icon.")) {
            return (this.icon instanceof FlatCheckBoxIcon) ? ((FlatCheckBoxIcon)this.icon).getStyleableValue(key.substring("icon.".length())) : null;
        }
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        final Dimension size = super.getPreferredSize(c);
        if (size == null) {
            return null;
        }
        final int focusWidth = this.getIconFocusWidth(c);
        if (focusWidth > 0) {
            final Insets insets = c.getInsets(FlatRadioButtonUI.tempInsets);
            final Dimension dimension = size;
            dimension.width += Math.max(focusWidth - insets.left, 0) + Math.max(focusWidth - insets.right, 0);
            final Dimension dimension2 = size;
            dimension2.height += Math.max(focusWidth - insets.top, 0) + Math.max(focusWidth - insets.bottom, 0);
        }
        return size;
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        if (!c.isOpaque() && ((AbstractButton)c).isContentAreaFilled() && !Objects.equals(c.getBackground(), this.getDefaultBackground(c))) {
            g.setColor(c.getBackground());
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        final int focusWidth = this.getIconFocusWidth(c);
        if (focusWidth > 0) {
            final boolean ltr = c.getComponentOrientation().isLeftToRight();
            final Insets insets = c.getInsets(FlatRadioButtonUI.tempInsets);
            final int leftOrRightInset = ltr ? insets.left : insets.right;
            if (focusWidth > leftOrRightInset) {
                int offset = focusWidth - leftOrRightInset;
                if (!ltr) {
                    offset = -offset;
                }
                g.translate(offset, 0);
                super.paint(g, c);
                g.translate(-offset, 0);
                return;
            }
        }
        super.paint(FlatLabelUI.createGraphicsHTMLTextYCorrection(g, c), c);
    }
    
    @Override
    protected void paintText(final Graphics g, final AbstractButton b, final Rectangle textRect, final String text) {
        FlatButtonUI.paintText(g, b, textRect, text, b.isEnabled() ? b.getForeground() : this.disabledText);
    }
    
    private Color getDefaultBackground(final JComponent c) {
        final Container parent = c.getParent();
        return (parent instanceof CellRendererPane && parent.getParent() != null) ? parent.getParent().getBackground() : this.defaultBackground;
    }
    
    private int getIconFocusWidth(final JComponent c) {
        final AbstractButton b = (AbstractButton)c;
        Icon icon = b.getIcon();
        if (icon == null) {
            icon = this.getDefaultIcon();
        }
        return (icon instanceof FlatCheckBoxIcon) ? Math.round(UIScale.scale(((FlatCheckBoxIcon)icon).getFocusWidth())) : 0;
    }
    
    static {
        tempInsets = new Insets(0, 0, 0, 0);
    }
    
    protected class FlatRadioButtonListener extends BasicButtonListener
    {
        private final AbstractButton b;
        
        protected FlatRadioButtonListener(final AbstractButton b) {
            super(b);
            this.b = b;
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            super.propertyChange(e);
            FlatRadioButtonUI.this.propertyChange(this.b, e);
        }
    }
    
    private static class AWTPeerMouseExitedFix extends MouseAdapter implements PropertyChangeListener
    {
        private final JComponent button;
        
        static void install(final JComponent button) {
            final AWTPeerMouseExitedFix l = new AWTPeerMouseExitedFix(button);
            button.addPropertyChangeListener("ancestor", l);
            final Container parent = button.getParent();
            if (parent != null) {
                parent.addMouseListener(l);
            }
        }
        
        static void uninstall(final JComponent button) {
            final PropertyChangeListener[] propertyChangeListeners = button.getPropertyChangeListeners("ancestor");
            final int length = propertyChangeListeners.length;
            int i = 0;
            while (i < length) {
                final PropertyChangeListener l = propertyChangeListeners[i];
                if (l instanceof AWTPeerMouseExitedFix) {
                    button.removePropertyChangeListener("ancestor", l);
                    final Container parent = button.getParent();
                    if (parent != null) {
                        parent.removeMouseListener((MouseListener)l);
                        break;
                    }
                    break;
                }
                else {
                    ++i;
                }
            }
        }
        
        AWTPeerMouseExitedFix(final JComponent button) {
            this.button = button;
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            if (e.getOldValue() instanceof Component) {
                ((Component)e.getOldValue()).removeMouseListener(this);
            }
            if (e.getNewValue() instanceof Component) {
                ((Component)e.getNewValue()).removeMouseListener(this);
                ((Component)e.getNewValue()).addMouseListener(this);
            }
        }
        
        @Override
        public void mouseExited(final MouseEvent e) {
            this.button.dispatchEvent(SwingUtilities.convertMouseEvent(e.getComponent(), e, this.button));
        }
    }
}
