// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JViewport;
import com.formdev.flatlaf.util.DerivedColor;
import javax.swing.JComponent;
import java.awt.Paint;
import javax.swing.JScrollPane;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.plaf.basic.BasicBorders;

public class FlatBorder extends BasicBorders.MarginBorder implements FlatStylingSupport.StyleableBorder
{
    @FlatStylingSupport.Styleable
    protected int focusWidth;
    @FlatStylingSupport.Styleable
    protected float innerFocusWidth;
    @FlatStylingSupport.Styleable
    protected float innerOutlineWidth;
    @FlatStylingSupport.Styleable
    protected float borderWidth;
    @FlatStylingSupport.Styleable
    protected Color focusColor;
    @FlatStylingSupport.Styleable
    protected Color borderColor;
    @FlatStylingSupport.Styleable
    protected Color disabledBorderColor;
    @FlatStylingSupport.Styleable
    protected Color focusedBorderColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color errorBorderColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color errorFocusedBorderColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color warningBorderColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color warningFocusedBorderColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color customBorderColor;
    @FlatStylingSupport.Styleable
    protected String outline;
    @FlatStylingSupport.Styleable
    protected Color outlineColor;
    @FlatStylingSupport.Styleable
    protected Color outlineFocusedColor;
    
    public FlatBorder() {
        this.focusWidth = UIManager.getInt("Component.focusWidth");
        this.innerFocusWidth = FlatUIUtils.getUIFloat("Component.innerFocusWidth", 0.0f);
        this.innerOutlineWidth = FlatUIUtils.getUIFloat("Component.innerOutlineWidth", 0.0f);
        this.borderWidth = FlatUIUtils.getUIFloat("Component.borderWidth", 1.0f);
        this.focusColor = UIManager.getColor("Component.focusColor");
        this.borderColor = UIManager.getColor("Component.borderColor");
        this.disabledBorderColor = UIManager.getColor("Component.disabledBorderColor");
        this.focusedBorderColor = UIManager.getColor("Component.focusedBorderColor");
        this.errorBorderColor = UIManager.getColor("Component.error.borderColor");
        this.errorFocusedBorderColor = UIManager.getColor("Component.error.focusedBorderColor");
        this.warningBorderColor = UIManager.getColor("Component.warning.borderColor");
        this.warningFocusedBorderColor = UIManager.getColor("Component.warning.focusedBorderColor");
        this.customBorderColor = UIManager.getColor("Component.custom.borderColor");
    }
    
    @Override
    public Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos() {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            final float focusWidth = UIScale.scale((float)this.getFocusWidth(c));
            float focusInnerWidth = 0.0f;
            final float borderWidth = UIScale.scale(this.getBorderWidth(c));
            final float arc = UIScale.scale((float)this.getArc(c));
            final Color outlineColor = this.getOutlineColor(c);
            Color focusColor = null;
            if (outlineColor != null || this.isFocused(c)) {
                final float innerWidth = (!this.isCellEditor(c) && !(c instanceof JScrollPane)) ? ((outlineColor != null) ? this.innerOutlineWidth : this.getInnerFocusWidth(c)) : 0.0f;
                if (focusWidth > 0.0f || innerWidth > 0.0f) {
                    focusColor = ((outlineColor != null) ? outlineColor : this.getFocusColor(c));
                    focusInnerWidth = borderWidth + UIScale.scale(innerWidth);
                }
            }
            final Paint borderColor = (outlineColor != null) ? outlineColor : this.getBorderColor(c);
            FlatUIUtils.paintOutlinedComponent(g2, x, y, width, height, focusWidth, 1.0f, focusInnerWidth, borderWidth, arc, focusColor, borderColor, null);
        }
        finally {
            g2.dispose();
        }
    }
    
    protected Color getOutlineColor(final Component c) {
        if (!(c instanceof JComponent)) {
            return null;
        }
        Object outline = ((JComponent)c).getClientProperty("JComponent.outline");
        if (outline == null) {
            outline = this.outline;
        }
        if (outline == null) {
            if (this.outlineColor != null && this.outlineFocusedColor != null) {
                outline = new Color[] { this.outlineFocusedColor, this.outlineColor };
            }
            else if (this.outlineColor != null) {
                outline = this.outlineColor;
            }
            else if (this.outlineFocusedColor != null) {
                outline = this.outlineFocusedColor;
            }
        }
        if (outline instanceof String) {
            final String s = (String)outline;
            switch (s) {
                case "error": {
                    return this.isFocused(c) ? this.errorFocusedBorderColor : this.errorBorderColor;
                }
                case "warning": {
                    return this.isFocused(c) ? this.warningFocusedBorderColor : this.warningBorderColor;
                }
            }
        }
        else {
            if (outline instanceof Color) {
                Color color = (Color)outline;
                if (!this.isFocused(c) && this.customBorderColor instanceof DerivedColor) {
                    color = ((DerivedColor)this.customBorderColor).derive(color);
                }
                return color;
            }
            if (outline instanceof Color[] && ((Color[])outline).length >= 2) {
                return ((Color[])outline)[!this.isFocused(c)];
            }
        }
        return null;
    }
    
    protected Color getFocusColor(final Component c) {
        return this.focusColor;
    }
    
    protected Paint getBorderColor(final Component c) {
        return this.isEnabled(c) ? (this.isFocused(c) ? this.focusedBorderColor : this.borderColor) : this.disabledBorderColor;
    }
    
    protected boolean isEnabled(final Component c) {
        if (c instanceof JScrollPane) {
            final JViewport viewport = ((JScrollPane)c).getViewport();
            final Component view = (viewport != null) ? viewport.getView() : null;
            if (view != null && !this.isEnabled(view)) {
                return false;
            }
        }
        return c.isEnabled();
    }
    
    protected boolean isFocused(final Component c) {
        if (c instanceof JScrollPane) {
            return FlatScrollPaneUI.isPermanentFocusOwner((JScrollPane)c);
        }
        if (c instanceof JComboBox) {
            return FlatComboBoxUI.isPermanentFocusOwner((JComboBox<?>)c);
        }
        if (c instanceof JSpinner) {
            return FlatSpinnerUI.isPermanentFocusOwner((JSpinner)c);
        }
        return FlatUIUtils.isPermanentFocusOwner(c);
    }
    
    protected boolean isCellEditor(final Component c) {
        return FlatUIUtils.isCellEditor(c);
    }
    
    @Override
    public Insets getBorderInsets(final Component c, Insets insets) {
        final float focusWidth = UIScale.scale((float)this.getFocusWidth(c));
        final int ow = Math.round(focusWidth + UIScale.scale((float)this.getLineWidth(c)));
        insets = super.getBorderInsets(c, insets);
        insets.top = UIScale.scale(insets.top) + ow;
        insets.left = UIScale.scale(insets.left) + ow;
        insets.bottom = UIScale.scale(insets.bottom) + ow;
        insets.right = UIScale.scale(insets.right) + ow;
        if (this.isCellEditor(c)) {
            final Insets insets2 = insets;
            final Insets insets3 = insets;
            final int n = 0;
            insets3.bottom = n;
            insets2.top = n;
            if (c.getComponentOrientation().isLeftToRight()) {
                insets.right = 0;
            }
            else {
                insets.left = 0;
            }
        }
        return insets;
    }
    
    protected int getFocusWidth(final Component c) {
        if (this.isCellEditor(c)) {
            return 0;
        }
        return this.focusWidth;
    }
    
    protected float getInnerFocusWidth(final Component c) {
        return this.innerFocusWidth;
    }
    
    protected int getLineWidth(final Component c) {
        return 1;
    }
    
    protected float getBorderWidth(final Component c) {
        return this.borderWidth;
    }
    
    protected int getArc(final Component c) {
        return 0;
    }
}
