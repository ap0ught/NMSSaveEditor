// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Container;
import java.awt.event.MouseEvent;
import javax.swing.ToolTipManager;
import java.awt.Cursor;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import com.formdev.flatlaf.util.UIScale;
import java.awt.LayoutManager;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class FlatSplitPaneUI extends BasicSplitPaneUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected String arrowType;
    @FlatStylingSupport.Styleable
    protected Color oneTouchArrowColor;
    @FlatStylingSupport.Styleable
    protected Color oneTouchHoverArrowColor;
    @FlatStylingSupport.Styleable
    protected Color oneTouchPressedArrowColor;
    private PropertyChangeListener propertyChangeListener;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatSplitPaneUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        this.arrowType = UIManager.getString("Component.arrowType");
        this.oneTouchArrowColor = UIManager.getColor("SplitPaneDivider.oneTouchArrowColor");
        this.oneTouchHoverArrowColor = UIManager.getColor("SplitPaneDivider.oneTouchHoverArrowColor");
        this.oneTouchPressedArrowColor = UIManager.getColor("SplitPaneDivider.oneTouchPressedArrowColor");
        super.installDefaults();
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.oneTouchArrowColor = null;
        this.oneTouchHoverArrowColor = null;
        this.oneTouchPressedArrowColor = null;
        this.oldStyleValues = null;
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.propertyChangeListener = FlatStylingSupport.createPropertyChangeListener(this.splitPane, this::installStyle, null);
        this.splitPane.addPropertyChangeListener(this.propertyChangeListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.splitPane.removePropertyChangeListener(this.propertyChangeListener);
        this.propertyChangeListener = null;
    }
    
    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new FlatSplitPaneDivider(this);
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.splitPane, "SplitPane"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        if (this.divider instanceof FlatSplitPaneDivider) {
            ((FlatSplitPaneDivider)this.divider).updateStyle();
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        try {
            if (this.divider instanceof FlatSplitPaneDivider) {
                return ((FlatSplitPaneDivider)this.divider).applyStyleProperty(key, value);
            }
        }
        catch (final FlatStylingSupport.UnknownStyleException ex) {}
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.splitPane, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final Map<String, Class<?>> infos = FlatStylingSupport.getAnnotatedStyleableInfos(this);
        if (this.divider instanceof FlatSplitPaneDivider) {
            infos.putAll(((FlatSplitPaneDivider)this.divider).getStyleableInfos());
        }
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        if (this.divider instanceof FlatSplitPaneDivider) {
            final Object value = ((FlatSplitPaneDivider)this.divider).getStyleableValue(key);
            if (value != null) {
                return value;
            }
        }
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    protected class FlatSplitPaneDivider extends BasicSplitPaneDivider
    {
        @FlatStylingSupport.Styleable
        protected String style;
        @FlatStylingSupport.Styleable
        protected Color gripColor;
        @FlatStylingSupport.Styleable
        protected int gripDotCount;
        @FlatStylingSupport.Styleable
        protected int gripDotSize;
        @FlatStylingSupport.Styleable
        protected int gripGap;
        final /* synthetic */ FlatSplitPaneUI this$0;
        
        protected FlatSplitPaneDivider(final BasicSplitPaneUI ui) {
            super(ui);
            this.style = UIManager.getString("SplitPaneDivider.style");
            this.gripColor = UIManager.getColor("SplitPaneDivider.gripColor");
            this.gripDotCount = FlatUIUtils.getUIInt("SplitPaneDivider.gripDotCount", 3);
            this.gripDotSize = FlatUIUtils.getUIInt("SplitPaneDivider.gripDotSize", 3);
            this.gripGap = FlatUIUtils.getUIInt("SplitPaneDivider.gripGap", 2);
            this.setLayout(new FlatDividerLayout());
        }
        
        protected Object applyStyleProperty(final String key, final Object value) {
            return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
        }
        
        public Map<String, Class<?>> getStyleableInfos() {
            return FlatStylingSupport.getAnnotatedStyleableInfos(this);
        }
        
        public Object getStyleableValue(final String key) {
            return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
        }
        
        void updateStyle() {
            if (this.leftButton instanceof FlatOneTouchButton) {
                ((FlatOneTouchButton)this.leftButton).updateStyle();
            }
            if (this.rightButton instanceof FlatOneTouchButton) {
                ((FlatOneTouchButton)this.rightButton).updateStyle();
            }
        }
        
        @Override
        public void setDividerSize(final int newSize) {
            super.setDividerSize(UIScale.scale(newSize));
        }
        
        @Override
        protected JButton createLeftOneTouchButton() {
            return new FlatOneTouchButton(true);
        }
        
        @Override
        protected JButton createRightOneTouchButton() {
            return new FlatOneTouchButton(false);
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            super.propertyChange(e);
            final String propertyName = e.getPropertyName();
            switch (propertyName) {
                case "dividerLocation": {
                    this.doLayout();
                    break;
                }
            }
        }
        
        @Override
        public void paint(final Graphics g) {
            super.paint(g);
            if ("plain".equals(this.style)) {
                return;
            }
            final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
            g.setColor(this.gripColor);
            this.paintGrip(g, 0, 0, this.getWidth(), this.getHeight());
            FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
        }
        
        protected void paintGrip(final Graphics g, final int x, final int y, final int width, final int height) {
            FlatUIUtils.paintGrip(g, x, y, width, height, this.splitPane.getOrientation() == 0, this.gripDotCount, this.gripDotSize, this.gripGap, true);
        }
        
        protected boolean isLeftCollapsed() {
            final int location = this.splitPane.getDividerLocation();
            final Insets insets = this.splitPane.getInsets();
            return (this.orientation == 0) ? (location == insets.top) : (location == insets.left);
        }
        
        protected boolean isRightCollapsed() {
            final int location = this.splitPane.getDividerLocation();
            final Insets insets = this.splitPane.getInsets();
            return (this.orientation == 0) ? (location == this.splitPane.getHeight() - this.getHeight() - insets.bottom) : (location == this.splitPane.getWidth() - this.getWidth() - insets.right);
        }
        
        protected class FlatOneTouchButton extends FlatArrowButton
        {
            protected final boolean left;
            
            protected FlatOneTouchButton(final boolean left) {
                super(1, FlatSplitPaneDivider.this.this$0.arrowType, FlatSplitPaneDivider.this.this$0.oneTouchArrowColor, null, FlatSplitPaneDivider.this.this$0.oneTouchHoverArrowColor, null, FlatSplitPaneDivider.this.this$0.oneTouchPressedArrowColor, null);
                this.setCursor(Cursor.getPredefinedCursor(0));
                ToolTipManager.sharedInstance().registerComponent(this);
                this.left = left;
            }
            
            protected void updateStyle() {
                this.updateStyle(FlatSplitPaneUI.this.arrowType, FlatSplitPaneUI.this.oneTouchArrowColor, null, FlatSplitPaneUI.this.oneTouchHoverArrowColor, null, FlatSplitPaneUI.this.oneTouchPressedArrowColor, null);
            }
            
            @Override
            public int getDirection() {
                return (FlatSplitPaneDivider.this.orientation == 0) ? (this.left ? 1 : 5) : (this.left ? 7 : 3);
            }
            
            @Override
            public String getToolTipText(final MouseEvent e) {
                final String key = (FlatSplitPaneDivider.this.orientation == 0) ? (this.left ? (FlatSplitPaneDivider.this.isRightCollapsed() ? "SplitPaneDivider.expandBottomToolTipText" : "SplitPaneDivider.collapseTopToolTipText") : (FlatSplitPaneDivider.this.isLeftCollapsed() ? "SplitPaneDivider.expandTopToolTipText" : "SplitPaneDivider.collapseBottomToolTipText")) : (this.left ? (FlatSplitPaneDivider.this.isRightCollapsed() ? "SplitPaneDivider.expandRightToolTipText" : "SplitPaneDivider.collapseLeftToolTipText") : (FlatSplitPaneDivider.this.isLeftCollapsed() ? "SplitPaneDivider.expandLeftToolTipText" : "SplitPaneDivider.collapseRightToolTipText"));
                final Object value = FlatSplitPaneDivider.this.splitPane.getClientProperty(key);
                if (value instanceof String) {
                    return (String)value;
                }
                return UIManager.getString(key, this.getLocale());
            }
        }
        
        protected class FlatDividerLayout extends DividerLayout
        {
            @Override
            public void layoutContainer(final Container c) {
                super.layoutContainer(c);
                if (FlatSplitPaneDivider.this.leftButton == null || FlatSplitPaneDivider.this.rightButton == null || !FlatSplitPaneDivider.this.splitPane.isOneTouchExpandable()) {
                    return;
                }
                final int extraSize = UIScale.scale(4);
                if (FlatSplitPaneDivider.this.orientation == 0) {
                    FlatSplitPaneDivider.this.leftButton.setSize(FlatSplitPaneDivider.this.leftButton.getWidth() + extraSize, FlatSplitPaneDivider.this.leftButton.getHeight());
                    FlatSplitPaneDivider.this.rightButton.setBounds(FlatSplitPaneDivider.this.leftButton.getX() + FlatSplitPaneDivider.this.leftButton.getWidth(), FlatSplitPaneDivider.this.rightButton.getY(), FlatSplitPaneDivider.this.rightButton.getWidth() + extraSize, FlatSplitPaneDivider.this.rightButton.getHeight());
                }
                else {
                    FlatSplitPaneDivider.this.leftButton.setSize(FlatSplitPaneDivider.this.leftButton.getWidth(), FlatSplitPaneDivider.this.leftButton.getHeight() + extraSize);
                    FlatSplitPaneDivider.this.rightButton.setBounds(FlatSplitPaneDivider.this.rightButton.getX(), FlatSplitPaneDivider.this.leftButton.getY() + FlatSplitPaneDivider.this.leftButton.getHeight(), FlatSplitPaneDivider.this.rightButton.getWidth(), FlatSplitPaneDivider.this.rightButton.getHeight() + extraSize);
                }
                final boolean leftCollapsed = FlatSplitPaneDivider.this.isLeftCollapsed();
                final boolean rightCollapsed = FlatSplitPaneDivider.this.isRightCollapsed();
                if (leftCollapsed || rightCollapsed) {
                    FlatSplitPaneDivider.this.leftButton.setVisible(!leftCollapsed);
                    FlatSplitPaneDivider.this.rightButton.setVisible(!rightCollapsed);
                }
                else {
                    final Object expandableSide = FlatSplitPaneDivider.this.splitPane.getClientProperty("JSplitPane.expandableSide");
                    FlatSplitPaneDivider.this.leftButton.setVisible(expandableSide == null || !"left".equals(expandableSide));
                    FlatSplitPaneDivider.this.rightButton.setVisible(expandableSide == null || !"right".equals(expandableSide));
                }
                if (!FlatSplitPaneDivider.this.leftButton.isVisible()) {
                    FlatSplitPaneDivider.this.rightButton.setLocation(FlatSplitPaneDivider.this.leftButton.getLocation());
                }
            }
        }
    }
}
