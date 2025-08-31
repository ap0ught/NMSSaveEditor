// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import com.formdev.flatlaf.ui.FlatButtonUI;
import java.awt.Graphics2D;
import java.awt.Component;
import java.util.Map;
import javax.swing.UIManager;
import java.awt.geom.Area;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import java.awt.Color;

public class FlatSearchIcon extends FlatAbstractIcon
{
    @FlatStylingSupport.Styleable
    protected Color searchIconColor;
    @FlatStylingSupport.Styleable
    protected Color searchIconHoverColor;
    @FlatStylingSupport.Styleable
    protected Color searchIconPressedColor;
    private final boolean ignoreButtonState;
    private Area area;
    
    public FlatSearchIcon() {
        this(false);
    }
    
    public FlatSearchIcon(final boolean ignoreButtonState) {
        super(16, 16, null);
        this.searchIconColor = UIManager.getColor("SearchField.searchIconColor");
        this.searchIconHoverColor = UIManager.getColor("SearchField.searchIconHoverColor");
        this.searchIconPressedColor = UIManager.getColor("SearchField.searchIconPressedColor");
        this.ignoreButtonState = ignoreButtonState;
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
    protected void paintIcon(final Component c, final Graphics2D g) {
        g.setColor(this.ignoreButtonState ? this.searchIconColor : FlatButtonUI.buttonStateColor(c, this.searchIconColor, this.searchIconColor, null, this.searchIconHoverColor, this.searchIconPressedColor));
        if (this.area == null) {
            (this.area = new Area(new Ellipse2D.Float(2.0f, 2.0f, 10.0f, 10.0f))).subtract(new Area(new Ellipse2D.Float(3.0f, 3.0f, 8.0f, 8.0f)));
            this.area.add(new Area(FlatUIUtils.createPath(10.813, 9.75, 14.0, 12.938, 12.938, 14.0, 9.75, 10.813)));
        }
        g.fill(this.area);
    }
}
