// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.text.Caret;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.event.FocusListener;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicTextPaneUI;

public class FlatTextPaneUI extends BasicTextPaneUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected int minimumWidth;
    protected boolean isIntelliJTheme;
    private Color background;
    @FlatStylingSupport.Styleable
    protected Color disabledBackground;
    @FlatStylingSupport.Styleable
    protected Color inactiveBackground;
    @FlatStylingSupport.Styleable
    protected Color focusedBackground;
    private Color oldDisabledBackground;
    private Color oldInactiveBackground;
    private Insets defaultMargin;
    private Object oldHonorDisplayProperties;
    private FocusListener focusListener;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatTextPaneUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        final String prefix = this.getPropertyPrefix();
        this.minimumWidth = UIManager.getInt("Component.minimumWidth");
        this.isIntelliJTheme = UIManager.getBoolean("Component.isIntelliJTheme");
        this.background = UIManager.getColor(prefix + ".background");
        this.disabledBackground = UIManager.getColor(prefix + ".disabledBackground");
        this.inactiveBackground = UIManager.getColor(prefix + ".inactiveBackground");
        this.focusedBackground = UIManager.getColor(prefix + ".focusedBackground");
        this.defaultMargin = UIManager.getInsets(prefix + ".margin");
        this.oldHonorDisplayProperties = this.getComponent().getClientProperty("JEditorPane.honorDisplayProperties");
        this.getComponent().putClientProperty("JEditorPane.honorDisplayProperties", true);
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.background = null;
        this.disabledBackground = null;
        this.inactiveBackground = null;
        this.focusedBackground = null;
        this.oldDisabledBackground = null;
        this.oldInactiveBackground = null;
        this.oldStyleValues = null;
        this.getComponent().putClientProperty("JEditorPane.honorDisplayProperties", this.oldHonorDisplayProperties);
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.focusListener = new FlatUIUtils.RepaintFocusListener(this.getComponent(), c -> this.focusedBackground != null);
        this.getComponent().addFocusListener(this.focusListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.getComponent().removeFocusListener(this.focusListener);
        this.focusListener = null;
    }
    
    @Override
    protected Caret createCaret() {
        return new FlatCaret(null, false);
    }
    
    @Override
    protected void propertyChange(final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        if ("editable".equals(propertyName) || "enabled".equals(propertyName)) {
            this.updateBackground();
        }
        super.propertyChange(e);
        FlatEditorPaneUI.propertyChange(this.getComponent(), e, this::installStyle);
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.getComponent(), "TextPane"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldDisabledBackground = this.disabledBackground;
        this.oldInactiveBackground = this.inactiveBackground;
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        this.updateBackground();
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.getComponent(), key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    private void updateBackground() {
        FlatTextFieldUI.updateBackground(this.getComponent(), this.background, this.disabledBackground, this.inactiveBackground, this.oldDisabledBackground, this.oldInactiveBackground);
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return FlatEditorPaneUI.applyMinimumWidth(c, super.getPreferredSize(c), this.minimumWidth, this.defaultMargin);
    }
    
    @Override
    public Dimension getMinimumSize(final JComponent c) {
        return FlatEditorPaneUI.applyMinimumWidth(c, super.getMinimumSize(c), this.minimumWidth, this.defaultMargin);
    }
    
    @Override
    protected void paintSafely(final Graphics g) {
        super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
    }
    
    @Override
    protected void paintBackground(final Graphics g) {
        FlatEditorPaneUI.paintBackground(g, this.getComponent(), this.isIntelliJTheme, this.focusedBackground);
    }
}
