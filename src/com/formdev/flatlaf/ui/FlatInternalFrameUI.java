// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.Shape;
import java.awt.Graphics2D;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Graphics;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.LookAndFeel;
import javax.swing.JInternalFrame;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class FlatInternalFrameUI extends BasicInternalFrameUI implements FlatStylingSupport.StyleableUI
{
    protected FlatWindowResizer windowResizer;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatInternalFrameUI((JInternalFrame)c);
    }
    
    public FlatInternalFrameUI(final JInternalFrame b) {
        super(b);
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        LookAndFeel.installProperty(this.frame, "opaque", false);
        this.windowResizer = this.createWindowResizer();
        this.installStyle();
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        if (this.windowResizer != null) {
            this.windowResizer.uninstall();
            this.windowResizer = null;
        }
        this.oldStyleValues = null;
        this.borderShared = null;
    }
    
    @Override
    protected JComponent createNorthPane(final JInternalFrame w) {
        return new FlatInternalFrameTitlePane(w);
    }
    
    protected FlatWindowResizer createWindowResizer() {
        return new FlatWindowResizer.InternalFrameResizer(this.frame, this::getDesktopManager);
    }
    
    @Override
    protected MouseInputAdapter createBorderListener(final JInternalFrame w) {
        return new FlatBorderListener();
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        return FlatStylingSupport.createPropertyChangeListener(this.frame, this::installStyle, super.createPropertyChangeListener());
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.frame, "InternalFrame"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (this.borderShared == null) {
            this.borderShared = new AtomicBoolean(true);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.frame, this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.frame.getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.frame.getBorder(), key);
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        if (!c.isOpaque() && !FlatUIUtils.hasOpaqueBeenExplicitlySet(c)) {
            final Insets insets = c.getInsets();
            g.setColor(c.getBackground());
            g.fillRect(insets.left, insets.top, c.getWidth() - insets.left - insets.right, c.getHeight() - insets.top - insets.bottom);
        }
        super.update(g, c);
    }
    
    public static class FlatInternalFrameBorder extends FlatEmptyBorder implements FlatStylingSupport.StyleableBorder
    {
        @FlatStylingSupport.Styleable
        protected Color activeBorderColor;
        @FlatStylingSupport.Styleable
        protected Color inactiveBorderColor;
        @FlatStylingSupport.Styleable
        protected int borderLineWidth;
        @FlatStylingSupport.Styleable
        protected boolean dropShadowPainted;
        private final FlatDropShadowBorder activeDropShadowBorder;
        private final FlatDropShadowBorder inactiveDropShadowBorder;
        
        public FlatInternalFrameBorder() {
            super(UIManager.getInsets("InternalFrame.borderMargins"));
            this.activeBorderColor = UIManager.getColor("InternalFrame.activeBorderColor");
            this.inactiveBorderColor = UIManager.getColor("InternalFrame.inactiveBorderColor");
            this.borderLineWidth = FlatUIUtils.getUIInt("InternalFrame.borderLineWidth", 1);
            this.dropShadowPainted = UIManager.getBoolean("InternalFrame.dropShadowPainted");
            this.activeDropShadowBorder = new FlatDropShadowBorder(UIManager.getColor("InternalFrame.activeDropShadowColor"), UIManager.getInsets("InternalFrame.activeDropShadowInsets"), FlatUIUtils.getUIFloat("InternalFrame.activeDropShadowOpacity", 0.5f));
            this.inactiveDropShadowBorder = new FlatDropShadowBorder(UIManager.getColor("InternalFrame.inactiveDropShadowColor"), UIManager.getInsets("InternalFrame.inactiveDropShadowInsets"), FlatUIUtils.getUIFloat("InternalFrame.inactiveDropShadowOpacity", 0.5f));
        }
        
        @Override
        public Object applyStyleProperty(final String key, final Object value) {
            switch (key) {
                case "borderMargins": {
                    return this.applyStyleProperty((Insets)value);
                }
                case "activeDropShadowColor": {
                    return this.activeDropShadowBorder.applyStyleProperty("shadowColor", value);
                }
                case "activeDropShadowInsets": {
                    return this.activeDropShadowBorder.applyStyleProperty("shadowInsets", value);
                }
                case "activeDropShadowOpacity": {
                    return this.activeDropShadowBorder.applyStyleProperty("shadowOpacity", value);
                }
                case "inactiveDropShadowColor": {
                    return this.inactiveDropShadowBorder.applyStyleProperty("shadowColor", value);
                }
                case "inactiveDropShadowInsets": {
                    return this.inactiveDropShadowBorder.applyStyleProperty("shadowInsets", value);
                }
                case "inactiveDropShadowOpacity": {
                    return this.inactiveDropShadowBorder.applyStyleProperty("shadowOpacity", value);
                }
                default: {
                    return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
                }
            }
        }
        
        @Override
        public Map<String, Class<?>> getStyleableInfos() {
            final Map<String, Class<?>> infos = new FlatStylingSupport.StyleableInfosMap<String, Class<?>>();
            FlatStylingSupport.collectAnnotatedStyleableInfos(this, infos);
            infos.put("borderMargins", Insets.class);
            infos.put("activeDropShadowColor", Color.class);
            infos.put("activeDropShadowInsets", Insets.class);
            infos.put("activeDropShadowOpacity", Float.TYPE);
            infos.put("inactiveDropShadowColor", Color.class);
            infos.put("inactiveDropShadowInsets", Insets.class);
            infos.put("inactiveDropShadowOpacity", Float.TYPE);
            return infos;
        }
        
        @Override
        public Object getStyleableValue(final String key) {
            switch (key) {
                case "borderMargins": {
                    return this.getStyleableValue();
                }
                case "activeDropShadowColor": {
                    return this.activeDropShadowBorder.getStyleableValue("shadowColor");
                }
                case "activeDropShadowInsets": {
                    return this.activeDropShadowBorder.getStyleableValue("shadowInsets");
                }
                case "activeDropShadowOpacity": {
                    return this.activeDropShadowBorder.getStyleableValue("shadowOpacity");
                }
                case "inactiveDropShadowColor": {
                    return this.inactiveDropShadowBorder.getStyleableValue("shadowColor");
                }
                case "inactiveDropShadowInsets": {
                    return this.inactiveDropShadowBorder.getStyleableValue("shadowInsets");
                }
                case "inactiveDropShadowOpacity": {
                    return this.inactiveDropShadowBorder.getStyleableValue("shadowOpacity");
                }
                default: {
                    return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
                }
            }
        }
        
        @Override
        public Insets getBorderInsets(final Component c, final Insets insets) {
            if (c instanceof JInternalFrame && ((JInternalFrame)c).isMaximum()) {
                insets.left = UIScale.scale(Math.min(this.borderLineWidth, this.left));
                insets.top = UIScale.scale(Math.min(this.borderLineWidth, this.top));
                insets.right = UIScale.scale(Math.min(this.borderLineWidth, this.right));
                insets.bottom = UIScale.scale(Math.min(this.borderLineWidth, this.bottom));
                return insets;
            }
            return super.getBorderInsets(c, insets);
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            final JInternalFrame f = (JInternalFrame)c;
            final Insets insets = this.getBorderInsets(c);
            final float lineWidth = UIScale.scale((float)this.borderLineWidth);
            final float rx = x + insets.left - lineWidth;
            final float ry = y + insets.top - lineWidth;
            final float rwidth = width - insets.left - insets.right + lineWidth * 2.0f;
            final float rheight = height - insets.top - insets.bottom + lineWidth * 2.0f;
            final Graphics2D g2 = (Graphics2D)g.create();
            try {
                FlatUIUtils.setRenderingHints(g2);
                g2.setColor(f.isSelected() ? this.activeBorderColor : this.inactiveBorderColor);
                if (this.dropShadowPainted) {
                    final FlatDropShadowBorder dropShadowBorder = f.isSelected() ? this.activeDropShadowBorder : this.inactiveDropShadowBorder;
                    final Insets dropShadowInsets = dropShadowBorder.getBorderInsets();
                    dropShadowBorder.paintBorder(c, g2, (int)rx - dropShadowInsets.left, (int)ry - dropShadowInsets.top, (int)rwidth + dropShadowInsets.left + dropShadowInsets.right, (int)rheight + dropShadowInsets.top + dropShadowInsets.bottom);
                }
                g2.fill(FlatUIUtils.createRectangle(rx, ry, rwidth, rheight, lineWidth));
            }
            finally {
                g2.dispose();
            }
        }
    }
    
    protected class FlatBorderListener extends BorderListener
    {
        @Override
        public void mouseClicked(final MouseEvent e) {
            if (e.getClickCount() == 2 && !FlatInternalFrameUI.this.frame.isIcon() && e.getSource() instanceof FlatInternalFrameTitlePane) {
                final Rectangle iconBounds = ((FlatInternalFrameTitlePane)e.getSource()).getFrameIconBounds();
                if (iconBounds != null && iconBounds.contains(e.getX(), e.getY())) {
                    if (FlatInternalFrameUI.this.frame.isClosable()) {
                        FlatInternalFrameUI.this.frame.doDefaultCloseAction();
                    }
                    return;
                }
            }
            super.mouseClicked(e);
        }
    }
}
