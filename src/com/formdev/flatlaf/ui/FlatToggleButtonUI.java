// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Graphics;
import javax.swing.JToggleButton;
import java.awt.Component;
import java.util.Map;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Color;

public class FlatToggleButtonUI extends FlatButtonUI
{
    @FlatStylingSupport.Styleable(dot = true)
    protected int tabUnderlineHeight;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabUnderlineColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabDisabledUnderlineColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabSelectedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabSelectedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabHoverBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabHoverForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabFocusBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color tabFocusForeground;
    private boolean defaults_initialized;
    
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatToggleButtonUI.class, () -> new FlatToggleButtonUI(true)) : new FlatToggleButtonUI(false);
    }
    
    protected FlatToggleButtonUI(final boolean shared) {
        super(shared);
        this.defaults_initialized = false;
    }
    
    @Override
    String getStyleType() {
        return "ToggleButton";
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "ToggleButton.";
    }
    
    @Override
    protected void installDefaults(final AbstractButton b) {
        super.installDefaults(b);
        if (!this.defaults_initialized) {
            this.tabUnderlineHeight = UIManager.getInt("ToggleButton.tab.underlineHeight");
            this.tabUnderlineColor = UIManager.getColor("ToggleButton.tab.underlineColor");
            this.tabDisabledUnderlineColor = UIManager.getColor("ToggleButton.tab.disabledUnderlineColor");
            this.tabSelectedBackground = UIManager.getColor("ToggleButton.tab.selectedBackground");
            this.tabSelectedForeground = UIManager.getColor("ToggleButton.tab.selectedForeground");
            this.tabHoverBackground = UIManager.getColor("ToggleButton.tab.hoverBackground");
            this.tabHoverForeground = UIManager.getColor("ToggleButton.tab.hoverForeground");
            this.tabFocusBackground = UIManager.getColor("ToggleButton.tab.focusBackground");
            this.tabFocusForeground = UIManager.getColor("ToggleButton.tab.focusForeground");
            this.defaults_initialized = true;
        }
    }
    
    @Override
    protected void uninstallDefaults(final AbstractButton b) {
        super.uninstallDefaults(b);
        this.defaults_initialized = false;
    }
    
    @Override
    protected void propertyChange(final AbstractButton b, final PropertyChangeEvent e) {
        super.propertyChange(b, e);
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "JButton.buttonType": {
                if ("tab".equals(e.getOldValue()) || "tab".equals(e.getNewValue())) {
                    MigLayoutVisualPadding.uninstall(b);
                    MigLayoutVisualPadding.install(b);
                    b.revalidate();
                }
                b.repaint();
                break;
            }
            case "JToggleButton.tab.underlinePlacement":
            case "JToggleButton.tab.underlineHeight":
            case "JToggleButton.tab.underlineColor":
            case "JToggleButton.tab.selectedBackground": {
                b.repaint();
                break;
            }
        }
    }
    
    @Override
    protected Object applyStyleProperty(final AbstractButton b, final String key, final Object value) {
        if (key.startsWith("help.")) {
            throw new FlatStylingSupport.UnknownStyleException(key);
        }
        return super.applyStyleProperty(b, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final Map<String, Class<?>> infos = super.getStyleableInfos(c);
        infos.keySet().removeIf(s -> s.startsWith("help."));
        return infos;
    }
    
    static boolean isTabButton(final Component c) {
        return c instanceof JToggleButton && "tab".equals(FlatButtonUI.getButtonTypeStr((AbstractButton)c));
    }
    
    @Override
    protected void paintBackground(final Graphics g, final JComponent c) {
        if (isTabButton(c)) {
            final int height = c.getHeight();
            final int width = c.getWidth();
            final boolean selected = ((AbstractButton)c).isSelected();
            Color enabledColor = selected ? FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.selectedBackground", this.tabSelectedBackground) : null;
            if (enabledColor == null) {
                final Color bg = c.getBackground();
                if (this.isCustomBackground(bg)) {
                    enabledColor = bg;
                }
            }
            final Color background = FlatButtonUI.buttonStateColor(c, enabledColor, null, this.tabFocusBackground, this.tabHoverBackground, null);
            if (background != null) {
                g.setColor(background);
                g.fillRect(0, 0, width, height);
            }
            if (selected) {
                final int underlineThickness = UIScale.scale(FlatClientProperties.clientPropertyInt(c, "JToggleButton.tab.underlineHeight", this.tabUnderlineHeight));
                g.setColor(c.isEnabled() ? FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.underlineColor", this.tabUnderlineColor) : this.tabDisabledUnderlineColor);
                final int placement = FlatClientProperties.clientPropertyInt(c, "JToggleButton.tab.underlinePlacement", 3);
                switch (placement) {
                    case 1: {
                        g.fillRect(0, 0, width, underlineThickness);
                        break;
                    }
                    case 2: {
                        g.fillRect(0, 0, underlineThickness, height);
                        break;
                    }
                    case 4: {
                        g.fillRect(width - underlineThickness, 0, underlineThickness, height);
                        break;
                    }
                    default: {
                        g.fillRect(0, height - underlineThickness, width, underlineThickness);
                        break;
                    }
                }
            }
        }
        else {
            super.paintBackground(g, c);
        }
    }
    
    @Override
    protected Color getForeground(final JComponent c) {
        if (!isTabButton(c)) {
            return super.getForeground(c);
        }
        if (!c.isEnabled()) {
            return this.disabledText;
        }
        if (this.tabSelectedForeground != null && ((AbstractButton)c).isSelected()) {
            return this.tabSelectedForeground;
        }
        return FlatButtonUI.buttonStateColor(c, c.getForeground(), this.disabledText, this.tabFocusForeground, this.tabHoverForeground, null);
    }
}
