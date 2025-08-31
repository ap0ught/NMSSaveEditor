// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.SwingUtilities;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import javax.swing.Icon;
import java.awt.FontMetrics;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import javax.swing.plaf.basic.BasicHTML;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Set;
import java.util.Map;
import java.awt.Color;
import javax.swing.plaf.basic.BasicLabelUI;

public class FlatLabelUI extends BasicLabelUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected Color disabledForeground;
    private final boolean shared;
    private boolean defaults_initialized;
    private Map<String, Object> oldStyleValues;
    private static Set<String> tagsUseFontSizeSet;
    
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.canUseSharedUI(c) ? FlatUIUtils.createSharedUI((Object)FlatLabelUI.class, () -> new FlatLabelUI(true)) : new FlatLabelUI(false);
    }
    
    protected FlatLabelUI(final boolean shared) {
        this.defaults_initialized = false;
        this.shared = shared;
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle((JLabel)c);
    }
    
    @Override
    protected void installDefaults(final JLabel c) {
        super.installDefaults(c);
        if (!this.defaults_initialized) {
            this.disabledForeground = UIManager.getColor("Label.disabledForeground");
            this.defaults_initialized = true;
        }
    }
    
    @Override
    protected void uninstallDefaults(final JLabel c) {
        super.uninstallDefaults(c);
        this.defaults_initialized = false;
        this.oldStyleValues = null;
    }
    
    @Override
    protected void installComponents(final JLabel c) {
        super.installComponents(c);
        updateHTMLRenderer(c, c.getText(), false);
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        final String name = e.getPropertyName();
        if (name == "text" || name == "font" || name == "foreground") {
            final JLabel label = (JLabel)e.getSource();
            updateHTMLRenderer(label, label.getText(), true);
        }
        else if (name.equals("FlatLaf.style") || name.equals("FlatLaf.styleClass")) {
            final JLabel label = (JLabel)e.getSource();
            if (this.shared && FlatStylingSupport.hasStyleProperty(label)) {
                label.updateUI();
            }
            else {
                this.installStyle(label);
            }
            label.revalidate();
            label.repaint();
        }
        else {
            super.propertyChange(e);
        }
    }
    
    protected void installStyle(final JLabel c) {
        try {
            this.applyStyle(c, FlatStylingSupport.getResolvedStyle(c, "Label"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final JLabel c, final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, (key, value) -> this.applyStyleProperty(c, key, value));
    }
    
    protected Object applyStyleProperty(final JLabel c, final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, c, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    static void updateHTMLRenderer(final JComponent c, String text, final boolean always) {
        if (BasicHTML.isHTMLString(text) && c.getClientProperty("html.disable") != Boolean.TRUE && needsFontBaseSize(text)) {
            String style = "<style>BASE_SIZE " + c.getFont().getSize() + "</style>";
            final String lowerText = text.toLowerCase();
            final int headIndex;
            int insertIndex;
            if ((headIndex = lowerText.indexOf("<head>")) >= 0) {
                insertIndex = headIndex + "<head>".length();
            }
            else {
                final int styleIndex;
                if ((styleIndex = lowerText.indexOf("<style>")) >= 0) {
                    insertIndex = styleIndex;
                }
                else {
                    style = "<head>" + style + "</head>";
                    insertIndex = "<html>".length();
                }
            }
            text = text.substring(0, insertIndex) + style + text.substring(insertIndex);
        }
        else if (!always) {
            return;
        }
        BasicHTML.updateRenderer(c, text);
    }
    
    private static boolean needsFontBaseSize(final String text) {
        if (FlatLabelUI.tagsUseFontSizeSet == null) {
            FlatLabelUI.tagsUseFontSizeSet = new HashSet<String>(Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "code", "kbd", "big", "small", "samp"));
        }
        for (int textLength = text.length(), i = 6; i < textLength - 1; ++i) {
            if (text.charAt(i) == '<') {
                switch (text.charAt(i + 1)) {
                    case 'B':
                    case 'C':
                    case 'H':
                    case 'K':
                    case 'S':
                    case 'b':
                    case 'c':
                    case 'h':
                    case 'k':
                    case 's': {
                        final int tagBegin = i + 1;
                        i += 2;
                        while (i < textLength) {
                            if (!Character.isLetterOrDigit(text.charAt(i))) {
                                final String tag = text.substring(tagBegin, i).toLowerCase();
                                if (FlatLabelUI.tagsUseFontSizeSet.contains(tag)) {
                                    return true;
                                }
                                break;
                            }
                            else {
                                ++i;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
    
    static Graphics createGraphicsHTMLTextYCorrection(final Graphics g, final JComponent c) {
        return (c.getClientProperty("html") != null) ? HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g) : g;
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        super.paint(createGraphicsHTMLTextYCorrection(g, c), c);
    }
    
    @Override
    protected void paintEnabledText(final JLabel l, final Graphics g, final String s, final int textX, final int textY) {
        final int mnemIndex = FlatLaf.isShowMnemonics() ? l.getDisplayedMnemonicIndex() : -1;
        g.setColor(l.getForeground());
        FlatUIUtils.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
    }
    
    @Override
    protected void paintDisabledText(final JLabel l, final Graphics g, final String s, final int textX, final int textY) {
        final int mnemIndex = FlatLaf.isShowMnemonics() ? l.getDisplayedMnemonicIndex() : -1;
        g.setColor(this.disabledForeground);
        FlatUIUtils.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
    }
    
    @Override
    protected String layoutCL(final JLabel label, final FontMetrics fontMetrics, final String text, final Icon icon, final Rectangle viewR, final Rectangle iconR, final Rectangle textR) {
        return SwingUtilities.layoutCompoundLabel(label, fontMetrics, text, icon, label.getVerticalAlignment(), label.getHorizontalAlignment(), label.getVerticalTextPosition(), label.getHorizontalTextPosition(), viewR, iconR, textR, UIScale.scale(label.getIconTextGap()));
    }
}
