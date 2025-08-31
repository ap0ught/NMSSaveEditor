// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import com.formdev.flatlaf.ui.FlatButtonUI;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import com.formdev.flatlaf.ui.FlatUIUtils;
import javax.swing.UIManager;
import java.awt.Color;
import com.formdev.flatlaf.ui.FlatStylingSupport;

public class FlatHelpButtonIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected int focusWidth;
    @FlatStylingSupport.Styleable
    protected Color focusColor;
    @FlatStylingSupport.Styleable
    protected float innerFocusWidth;
    @FlatStylingSupport.Styleable
    protected int borderWidth;
    @FlatStylingSupport.Styleable
    protected Color borderColor;
    @FlatStylingSupport.Styleable
    protected Color disabledBorderColor;
    @FlatStylingSupport.Styleable
    protected Color focusedBorderColor;
    @FlatStylingSupport.Styleable
    protected Color hoverBorderColor;
    @FlatStylingSupport.Styleable
    protected Color background;
    @FlatStylingSupport.Styleable
    protected Color disabledBackground;
    @FlatStylingSupport.Styleable
    protected Color focusedBackground;
    @FlatStylingSupport.Styleable
    protected Color hoverBackground;
    @FlatStylingSupport.Styleable
    protected Color pressedBackground;
    @FlatStylingSupport.Styleable
    protected Color questionMarkColor;
    @FlatStylingSupport.Styleable
    protected Color disabledQuestionMarkColor;
    
    public FlatHelpButtonIcon() {
        super(0, 0, null);
        this.focusWidth = UIManager.getInt("Component.focusWidth");
        this.focusColor = UIManager.getColor("Component.focusColor");
        this.innerFocusWidth = FlatUIUtils.getUIFloat("HelpButton.innerFocusWidth", FlatUIUtils.getUIFloat("Component.innerFocusWidth", 0.0f));
        this.borderWidth = FlatUIUtils.getUIInt("HelpButton.borderWidth", 1);
        this.borderColor = UIManager.getColor("HelpButton.borderColor");
        this.disabledBorderColor = UIManager.getColor("HelpButton.disabledBorderColor");
        this.focusedBorderColor = UIManager.getColor("HelpButton.focusedBorderColor");
        this.hoverBorderColor = UIManager.getColor("HelpButton.hoverBorderColor");
        this.background = UIManager.getColor("HelpButton.background");
        this.disabledBackground = UIManager.getColor("HelpButton.disabledBackground");
        this.focusedBackground = UIManager.getColor("HelpButton.focusedBackground");
        this.hoverBackground = UIManager.getColor("HelpButton.hoverBackground");
        this.pressedBackground = UIManager.getColor("HelpButton.pressedBackground");
        this.questionMarkColor = UIManager.getColor("HelpButton.questionMarkColor");
        this.disabledQuestionMarkColor = UIManager.getColor("HelpButton.disabledQuestionMarkColor");
    }
    
    public Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    public Map<String, Class<?>> getStyleableInfos() {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    public Object getStyleableValue(final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g2) {
        final boolean enabled = c == null || c.isEnabled();
        final boolean focused = c != null && FlatUIUtils.isPermanentFocusOwner(c);
        float xy = 0.5f;
        float wh = (float)(this.iconSize() - 1);
        if (focused && FlatButtonUI.isFocusPainted(c)) {
            g2.setColor(this.focusColor);
            g2.fill(new Ellipse2D.Float(xy, xy, wh, wh));
        }
        xy += this.focusWidth;
        wh -= this.focusWidth * 2;
        g2.setColor(FlatButtonUI.buttonStateColor(c, this.borderColor, this.disabledBorderColor, this.focusedBorderColor, this.hoverBorderColor, null));
        g2.fill(new Ellipse2D.Float(xy, xy, wh, wh));
        xy += this.borderWidth;
        wh -= this.borderWidth * 2;
        if (this.innerFocusWidth > 0.0f && focused && FlatButtonUI.isFocusPainted(c)) {
            g2.setColor(this.focusColor);
            g2.fill(new Ellipse2D.Float(xy, xy, wh, wh));
            xy += this.innerFocusWidth;
            wh -= this.innerFocusWidth * 2.0f;
        }
        g2.setColor(FlatUIUtils.deriveColor(FlatButtonUI.buttonStateColor(c, this.background, this.disabledBackground, this.focusedBackground, this.hoverBackground, this.pressedBackground), this.background));
        g2.fill(new Ellipse2D.Float(xy, xy, wh, wh));
        final Path2D q = new Path2D.Float(1, 10);
        q.moveTo(8.0, 8.5);
        q.curveTo(8.25, 7.0, 9.66585007, 6.0, 11.0, 6.0);
        q.curveTo(12.5, 6.0, 14.0, 7.0, 14.0, 8.5);
        q.curveTo(14.0, 10.5, 11.0, 11.0, 11.0, 13.0);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setStroke(new BasicStroke(2.0f, 1, 1));
        g2.translate(this.focusWidth, this.focusWidth);
        g2.setColor(enabled ? this.questionMarkColor : this.disabledQuestionMarkColor);
        g2.draw(q);
        g2.fill(new Ellipse2D.Float(9.8f, 14.8f, 2.4f, 2.4f));
    }
    
    @Override
    public int getIconWidth() {
        return UIScale.scale(this.iconSize());
    }
    
    @Override
    public int getIconHeight() {
        return UIScale.scale(this.iconSize());
    }
    
    private int iconSize() {
        return 22 + this.focusWidth * 2;
    }
}
