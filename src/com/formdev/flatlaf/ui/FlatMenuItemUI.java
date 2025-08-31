// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.Icon;
import java.lang.invoke.MethodHandles;
import javax.swing.JMenuItem;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import java.awt.Component;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import javax.swing.plaf.basic.BasicMenuItemUI;

@FlatStylingSupport.StyleableFields({ @FlatStylingSupport.StyleableField(cls = BasicMenuItemUI.class, key = "selectionBackground"), @FlatStylingSupport.StyleableField(cls = BasicMenuItemUI.class, key = "selectionForeground"), @FlatStylingSupport.StyleableField(cls = BasicMenuItemUI.class, key = "disabledForeground"), @FlatStylingSupport.StyleableField(cls = BasicMenuItemUI.class, key = "acceleratorForeground"), @FlatStylingSupport.StyleableField(cls = BasicMenuItemUI.class, key = "acceleratorSelectionForeground") })
public class FlatMenuItemUI extends BasicMenuItemUI implements FlatStylingSupport.StyleableUI, FlatStylingSupport.StyleableLookupProvider
{
    private FlatMenuItemRenderer renderer;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatMenuItemUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.installProperty(this.menuItem, "iconTextGap", FlatUIUtils.getUIInt("MenuItem.iconTextGap", 4));
        this.renderer = this.createRenderer();
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        FlatMenuItemRenderer.clearClientProperties(this.menuItem.getParent());
        this.renderer = null;
        this.oldStyleValues = null;
    }
    
    protected FlatMenuItemRenderer createRenderer() {
        return new FlatMenuItemRenderer(this.menuItem, this.checkIcon, this.arrowIcon, this.acceleratorFont, this.acceleratorDelimiter);
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener(final JComponent c) {
        return FlatStylingSupport.createPropertyChangeListener(c, this::installStyle, super.createPropertyChangeListener(c));
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.menuItem, "MenuItem"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return applyStyleProperty(this.menuItem, this, this.renderer, key, value);
    }
    
    static Object applyStyleProperty(final JMenuItem menuItem, final BasicMenuItemUI ui, final FlatMenuItemRenderer renderer, final String key, final Object value) {
        try {
            return renderer.applyStyleProperty(key, value);
        }
        catch (final FlatStylingSupport.UnknownStyleException ex) {
            return FlatStylingSupport.applyToAnnotatedObjectOrComponent(ui, menuItem, key, value);
        }
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return getStyleableInfos(this, this.renderer);
    }
    
    static Map<String, Class<?>> getStyleableInfos(final BasicMenuItemUI ui, final FlatMenuItemRenderer renderer) {
        final Map<String, Class<?>> infos = FlatStylingSupport.getAnnotatedStyleableInfos(ui);
        infos.putAll(renderer.getStyleableInfos());
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return getStyleableValue(this, this.renderer, key);
    }
    
    static Object getStyleableValue(final BasicMenuItemUI ui, final FlatMenuItemRenderer renderer, final String key) {
        Object value = renderer.getStyleableValue(key);
        if (value == null) {
            value = FlatStylingSupport.getAnnotatedStyleableValue(ui, key);
        }
        return value;
    }
    
    @Override
    public MethodHandles.Lookup getLookupForStyling() {
        return MethodHandles.lookup();
    }
    
    @Override
    protected Dimension getPreferredMenuItemSize(final JComponent c, final Icon checkIcon, final Icon arrowIcon, final int defaultTextIconGap) {
        return this.renderer.getPreferredMenuItemSize();
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        this.renderer.paintMenuItem(g, this.selectionBackground, this.selectionForeground, this.disabledForeground, this.acceleratorForeground, this.acceleratorSelectionForeground);
    }
}
