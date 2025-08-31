// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.JMenu;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.MenuElement;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.MenuSelectionManager;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.JMenuBar;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.UIManager;
import javax.swing.JRootPane;
import java.awt.Window;
import java.awt.Component;
import java.awt.Graphics;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.ActionMap;
import javax.swing.Action;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.SwingUtilities;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.plaf.UIResource;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class FlatMenuBarUI extends BasicMenuBarUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected Insets itemMargins;
    @FlatStylingSupport.Styleable
    protected Insets selectionInsets;
    @FlatStylingSupport.Styleable
    protected Insets selectionEmbeddedInsets;
    @FlatStylingSupport.Styleable
    protected int selectionArc;
    @FlatStylingSupport.Styleable
    protected Color hoverBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionForeground;
    @FlatStylingSupport.Styleable
    protected Color underlineSelectionBackground;
    @FlatStylingSupport.Styleable
    protected Color underlineSelectionColor;
    @FlatStylingSupport.Styleable
    protected int underlineSelectionHeight;
    private PropertyChangeListener propertyChangeListener;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    
    public FlatMenuBarUI() {
        this.selectionArc = -1;
        this.underlineSelectionHeight = -1;
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatMenuBarUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.installProperty(this.menuBar, "opaque", false);
        final LayoutManager layout = this.menuBar.getLayout();
        if (layout == null || layout instanceof UIResource) {
            this.menuBar.setLayout(new FlatMenuBarLayout(this.menuBar));
        }
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.oldStyleValues = null;
        this.borderShared = null;
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.propertyChangeListener = FlatStylingSupport.createPropertyChangeListener(this.menuBar, this::installStyle, null);
        this.menuBar.addPropertyChangeListener(this.propertyChangeListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.menuBar.removePropertyChangeListener(this.propertyChangeListener);
        this.propertyChangeListener = null;
    }
    
    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
        ActionMap map = SwingUtilities.getUIActionMap(this.menuBar);
        if (map == null) {
            map = new ActionMapUIResource();
            SwingUtilities.replaceUIActionMap(this.menuBar, map);
        }
        map.put("takeFocus", new TakeFocus());
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.menuBar, "MenuBar"));
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
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.menuBar, this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.menuBar.getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.menuBar.getBorder(), key);
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        final Color background = this.getBackground(c);
        if (background != null) {
            g.setColor(background);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        this.paint(g, c);
    }
    
    protected Color getBackground(final JComponent c) {
        Color background = c.getBackground();
        if (c.isOpaque()) {
            return background;
        }
        if (!(background instanceof UIResource)) {
            return null;
        }
        final JRootPane rootPane = SwingUtilities.getRootPane(c);
        if (rootPane == null || !(rootPane.getParent() instanceof Window) || rootPane.getJMenuBar() != c) {
            return background;
        }
        if (useUnifiedBackground(c)) {
            background = FlatUIUtils.getParentBackground(c);
        }
        if (FlatUIUtils.isFullScreen(rootPane)) {
            return background;
        }
        return FlatRootPaneUI.isMenuBarEmbedded(rootPane) ? null : background;
    }
    
    static boolean useUnifiedBackground(final Component c) {
        final JRootPane rootPane;
        return UIManager.getBoolean("TitlePane.unifiedBackground") && (rootPane = SwingUtilities.getRootPane(c)) != null && rootPane.getParent() instanceof Window && rootPane.getJMenuBar() == c && rootPane.getWindowDecorationStyle() != 0;
    }
    
    protected static class FlatMenuBarLayout extends DefaultMenuLayout
    {
        public FlatMenuBarLayout(final Container target) {
            super(target, 2);
        }
        
        @Override
        public void layoutContainer(final Container target) {
            super.layoutContainer(target);
            final JRootPane rootPane = SwingUtilities.getRootPane(target);
            if (rootPane == null || rootPane.getJMenuBar() != target) {
                return;
            }
            final FlatTitlePane titlePane = FlatRootPaneUI.getTitlePane(rootPane);
            if (titlePane == null || !titlePane.isMenuBarEmbedded()) {
                return;
            }
            final Component horizontalGlue = titlePane.findHorizontalGlue((JMenuBar)target);
            final int minTitleWidth = UIScale.scale(titlePane.titleMinimumWidth);
            if (horizontalGlue != null && horizontalGlue.getWidth() < minTitleWidth) {
                int glueIndex = -1;
                final Component[] components = target.getComponents();
                for (int i = components.length - 1; i >= 0; --i) {
                    if (components[i] == horizontalGlue) {
                        glueIndex = i;
                        break;
                    }
                }
                if (glueIndex < 0) {
                    return;
                }
                if (target.getComponentOrientation().isLeftToRight()) {
                    int offset = minTitleWidth - horizontalGlue.getWidth();
                    horizontalGlue.setSize(minTitleWidth, horizontalGlue.getHeight());
                    final int minGlueX = target.getWidth() - target.getInsets().right - minTitleWidth;
                    if (minGlueX < horizontalGlue.getX()) {
                        offset -= horizontalGlue.getX() - minGlueX;
                        horizontalGlue.setLocation(minGlueX, horizontalGlue.getY());
                        for (int j = glueIndex - 1; j >= 0; --j) {
                            final Component c = components[j];
                            if (c.getX() <= minGlueX) {
                                c.setSize(minGlueX - c.getX(), c.getHeight());
                                break;
                            }
                            c.setBounds(minGlueX, c.getY(), 0, c.getHeight());
                        }
                    }
                    for (int j = glueIndex + 1; j < components.length; ++j) {
                        final Component c = components[j];
                        c.setLocation(c.getX() + offset, c.getY());
                    }
                }
                else {
                    int offset = minTitleWidth - horizontalGlue.getWidth();
                    horizontalGlue.setBounds(horizontalGlue.getX() - offset, horizontalGlue.getY(), minTitleWidth, horizontalGlue.getHeight());
                    final int minGlueX = target.getInsets().left;
                    if (minGlueX > horizontalGlue.getX()) {
                        offset -= horizontalGlue.getX() - minGlueX;
                        horizontalGlue.setLocation(minGlueX, horizontalGlue.getY());
                        final int x = horizontalGlue.getX() + horizontalGlue.getWidth();
                        for (int k = glueIndex - 1; k >= 0; --k) {
                            final Component c2 = components[k];
                            if (c2.getX() + c2.getWidth() >= x) {
                                c2.setBounds(x, c2.getY(), c2.getWidth() - (x - c2.getX()), c2.getHeight());
                                break;
                            }
                            c2.setBounds(x, c2.getY(), 0, c2.getHeight());
                        }
                    }
                    for (int j = glueIndex + 1; j < components.length; ++j) {
                        final Component c = components[j];
                        c.setLocation(c.getX() - offset, c.getY());
                    }
                }
            }
        }
    }
    
    private static class TakeFocus extends AbstractAction
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            final JMenuBar menuBar = (JMenuBar)e.getSource();
            final JMenu menu = menuBar.getMenu(0);
            if (menu != null) {
                MenuSelectionManager.defaultManager().setSelectedPath(SystemInfo.isWindows ? new MenuElement[] { menuBar, menu } : new MenuElement[] { menuBar, menu, menu.getPopupMenu() });
                FlatLaf.showMnemonics(menuBar);
            }
        }
    }
}
