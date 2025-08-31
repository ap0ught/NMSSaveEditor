// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.plaf.ToolBarUI;
import java.awt.Container;
import javax.swing.event.ChangeEvent;
import java.util.Objects;
import java.awt.Dimension;
import javax.swing.ButtonModel;
import java.awt.FontMetrics;
import com.formdev.flatlaf.FlatLaf;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.ButtonUI;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Component;
import com.formdev.flatlaf.icons.FlatHelpButtonIcon;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeEvent;
import javax.swing.plaf.basic.BasicButtonListener;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.LookAndFeel;
import javax.swing.plaf.UIResource;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import java.awt.Insets;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.plaf.basic.BasicButtonUI;

public class FlatButtonUI extends BasicButtonUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected int minimumWidth;
    protected int iconTextGap;
    protected Color background;
    protected Color foreground;
    protected Color startBackground;
    protected Color endBackground;
    @FlatStylingSupport.Styleable
    protected Color focusedBackground;
    @FlatStylingSupport.Styleable
    protected Color focusedForeground;
    @FlatStylingSupport.Styleable
    protected Color hoverBackground;
    @FlatStylingSupport.Styleable
    protected Color hoverForeground;
    @FlatStylingSupport.Styleable
    protected Color pressedBackground;
    @FlatStylingSupport.Styleable
    protected Color pressedForeground;
    @FlatStylingSupport.Styleable
    protected Color selectedBackground;
    @FlatStylingSupport.Styleable
    protected Color selectedForeground;
    @FlatStylingSupport.Styleable
    protected Color disabledBackground;
    @FlatStylingSupport.Styleable
    protected Color disabledText;
    @FlatStylingSupport.Styleable
    protected Color disabledSelectedBackground;
    @FlatStylingSupport.Styleable
    protected Color disabledSelectedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultBackground;
    protected Color defaultEndBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultFocusedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultFocusedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultHoverBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultHoverForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultPressedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultPressedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected boolean defaultBoldText;
    @FlatStylingSupport.Styleable
    protected boolean paintShadow;
    @FlatStylingSupport.Styleable
    protected int shadowWidth;
    @FlatStylingSupport.Styleable
    protected Color shadowColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color defaultShadowColor;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarHoverBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarHoverForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarPressedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarPressedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarSelectedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarSelectedForeground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarDisabledSelectedBackground;
    @FlatStylingSupport.Styleable(dot = true)
    protected Color toolbarDisabledSelectedForeground;
    @FlatStylingSupport.Styleable
    protected String buttonType;
    @FlatStylingSupport.Styleable
    protected boolean squareSize;
    @FlatStylingSupport.Styleable
    protected int minimumHeight;
    private Icon helpButtonIcon;
    private Insets defaultMargin;
    private final boolean shared;
    private boolean helpButtonIconShared;
    private boolean defaults_initialized;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    static final int TYPE_OTHER = -1;
    static final int TYPE_SQUARE = 0;
    static final int TYPE_ROUND_RECT = 1;
    
    public static ComponentUI createUI(final JComponent c) {
        return (FlatUIUtils.canUseSharedUI(c) && !FlatUIUtils.needsLightAWTPeer(c)) ? FlatUIUtils.createSharedUI((Object)FlatButtonUI.class, () -> new FlatButtonUI(true)) : new FlatButtonUI(false);
    }
    
    protected FlatButtonUI(final boolean shared) {
        this.helpButtonIconShared = true;
        this.defaults_initialized = false;
        this.shared = shared;
    }
    
    @Override
    public void installUI(final JComponent c) {
        if (FlatUIUtils.needsLightAWTPeer(c)) {
            FlatUIUtils.runWithLightAWTPeerUIDefaults(() -> this.installUIImpl(c));
        }
        else {
            this.installUIImpl(c);
        }
    }
    
    private void installUIImpl(final JComponent c) {
        super.installUI(c);
        this.installStyle((AbstractButton)c);
    }
    
    @Override
    protected void installDefaults(final AbstractButton b) {
        super.installDefaults(b);
        if (!this.defaults_initialized) {
            final String prefix = this.getPropertyPrefix();
            this.minimumWidth = UIManager.getInt(prefix + "minimumWidth");
            this.iconTextGap = FlatUIUtils.getUIInt(prefix + "iconTextGap", 4);
            this.background = UIManager.getColor(prefix + "background");
            this.foreground = UIManager.getColor(prefix + "foreground");
            this.startBackground = UIManager.getColor(prefix + "startBackground");
            this.endBackground = UIManager.getColor(prefix + "endBackground");
            this.focusedBackground = UIManager.getColor(prefix + "focusedBackground");
            this.focusedForeground = UIManager.getColor(prefix + "focusedForeground");
            this.hoverBackground = UIManager.getColor(prefix + "hoverBackground");
            this.hoverForeground = UIManager.getColor(prefix + "hoverForeground");
            this.pressedBackground = UIManager.getColor(prefix + "pressedBackground");
            this.pressedForeground = UIManager.getColor(prefix + "pressedForeground");
            this.selectedBackground = UIManager.getColor(prefix + "selectedBackground");
            this.selectedForeground = UIManager.getColor(prefix + "selectedForeground");
            this.disabledBackground = UIManager.getColor(prefix + "disabledBackground");
            this.disabledText = UIManager.getColor(prefix + "disabledText");
            this.disabledSelectedBackground = UIManager.getColor(prefix + "disabledSelectedBackground");
            this.disabledSelectedForeground = UIManager.getColor(prefix + "disabledSelectedForeground");
            this.defaultBackground = FlatUIUtils.getUIColor("Button.default.startBackground", "Button.default.background");
            this.defaultEndBackground = UIManager.getColor("Button.default.endBackground");
            this.defaultForeground = UIManager.getColor("Button.default.foreground");
            this.defaultFocusedBackground = UIManager.getColor("Button.default.focusedBackground");
            this.defaultFocusedForeground = UIManager.getColor("Button.default.focusedForeground");
            this.defaultHoverBackground = UIManager.getColor("Button.default.hoverBackground");
            this.defaultHoverForeground = UIManager.getColor("Button.default.hoverForeground");
            this.defaultPressedBackground = UIManager.getColor("Button.default.pressedBackground");
            this.defaultPressedForeground = UIManager.getColor("Button.default.pressedForeground");
            this.defaultBoldText = UIManager.getBoolean("Button.default.boldText");
            this.paintShadow = UIManager.getBoolean("Button.paintShadow");
            this.shadowWidth = FlatUIUtils.getUIInt("Button.shadowWidth", 2);
            this.shadowColor = UIManager.getColor("Button.shadowColor");
            this.defaultShadowColor = UIManager.getColor("Button.default.shadowColor");
            this.toolbarHoverBackground = UIManager.getColor(prefix + "toolbar.hoverBackground");
            this.toolbarHoverForeground = UIManager.getColor(prefix + "toolbar.hoverForeground");
            this.toolbarPressedBackground = UIManager.getColor(prefix + "toolbar.pressedBackground");
            this.toolbarPressedForeground = UIManager.getColor(prefix + "toolbar.pressedForeground");
            this.toolbarSelectedBackground = UIManager.getColor(prefix + "toolbar.selectedBackground");
            this.toolbarSelectedForeground = UIManager.getColor(prefix + "toolbar.selectedForeground");
            this.toolbarDisabledSelectedBackground = UIManager.getColor(prefix + "toolbar.disabledSelectedBackground");
            this.toolbarDisabledSelectedForeground = UIManager.getColor(prefix + "toolbar.disabledSelectedForeground");
            this.helpButtonIcon = UIManager.getIcon("HelpButton.icon");
            this.defaultMargin = UIManager.getInsets(prefix + "margin");
            this.helpButtonIconShared = true;
            this.defaults_initialized = true;
        }
        if (this.startBackground != null) {
            final Color bg = b.getBackground();
            if (bg == null || bg instanceof UIResource) {
                b.setBackground(this.startBackground);
            }
        }
        LookAndFeel.installProperty(b, "opaque", false);
        LookAndFeel.installProperty(b, "iconTextGap", UIScale.scale(this.iconTextGap));
        MigLayoutVisualPadding.install(b);
    }
    
    @Override
    protected void uninstallDefaults(final AbstractButton b) {
        super.uninstallDefaults(b);
        this.oldStyleValues = null;
        this.borderShared = null;
        MigLayoutVisualPadding.uninstall(b);
        this.defaults_initialized = false;
    }
    
    @Override
    protected BasicButtonListener createButtonListener(final AbstractButton b) {
        return new FlatButtonListener(b);
    }
    
    protected void propertyChange(final AbstractButton b, final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "JButton.squareSize":
            case "JComponent.minimumWidth":
            case "JComponent.minimumHeight": {
                b.revalidate();
                break;
            }
            case "JButton.buttonType": {
                b.revalidate();
                b.repaint();
                break;
            }
            case "JComponent.outline": {
                b.repaint();
                break;
            }
            case "FlatLaf.style":
            case "FlatLaf.styleClass": {
                if (this.shared && FlatStylingSupport.hasStyleProperty(b)) {
                    b.updateUI();
                }
                else {
                    this.installStyle(b);
                }
                b.revalidate();
                b.repaint();
                break;
            }
        }
    }
    
    protected void installStyle(final AbstractButton b) {
        try {
            this.applyStyle(b, FlatStylingSupport.getResolvedStyle(b, this.getStyleType()));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    String getStyleType() {
        return "Button";
    }
    
    protected void applyStyle(final AbstractButton b, final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, (key, value) -> this.applyStyleProperty(b, key, value));
    }
    
    protected Object applyStyleProperty(final AbstractButton b, String key, final Object value) {
        if (!key.startsWith("help.")) {
            if (this.borderShared == null) {
                this.borderShared = new AtomicBoolean(true);
            }
            return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, b, this.borderShared);
        }
        if (!(this.helpButtonIcon instanceof FlatHelpButtonIcon)) {
            return new FlatStylingSupport.UnknownStyleException(key);
        }
        if (this.helpButtonIconShared) {
            this.helpButtonIcon = FlatStylingSupport.cloneIcon(this.helpButtonIcon);
            this.helpButtonIconShared = false;
        }
        key = key.substring("help.".length());
        return ((FlatHelpButtonIcon)this.helpButtonIcon).applyStyleProperty(key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final Map<String, Class<?>> infos = FlatStylingSupport.getAnnotatedStyleableInfos(this, c.getBorder());
        if (this.helpButtonIcon instanceof FlatHelpButtonIcon) {
            FlatStylingSupport.putAllPrefixKey(infos, "help.", ((FlatHelpButtonIcon)this.helpButtonIcon).getStyleableInfos());
        }
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        if (key.startsWith("help.")) {
            return (this.helpButtonIcon instanceof FlatHelpButtonIcon) ? ((FlatHelpButtonIcon)this.helpButtonIcon).getStyleableValue(key.substring("help.".length())) : null;
        }
        return FlatStylingSupport.getAnnotatedStyleableValue(this, c.getBorder(), key);
    }
    
    static boolean isContentAreaFilled(final Component c) {
        return !(c instanceof AbstractButton) || ((AbstractButton)c).isContentAreaFilled();
    }
    
    public static boolean isFocusPainted(final Component c) {
        return !(c instanceof AbstractButton) || ((AbstractButton)c).isFocusPainted();
    }
    
    static boolean isDefaultButton(final Component c) {
        return c instanceof JButton && ((JButton)c).isDefaultButton();
    }
    
    static boolean isIconOnlyOrSingleCharacterButton(final Component c) {
        if (!(c instanceof JButton) && !(c instanceof JToggleButton)) {
            return false;
        }
        final Icon icon = ((AbstractButton)c).getIcon();
        final String text = ((AbstractButton)c).getText();
        return (icon != null && (text == null || text.isEmpty())) || (icon == null && text != null && ("...".equals(text) || text.length() == 1 || (text.length() == 2 && Character.isSurrogatePair(text.charAt(0), text.charAt(1)))));
    }
    
    static int getButtonType(final Component c) {
        if (!(c instanceof AbstractButton)) {
            return -1;
        }
        final String value = getButtonTypeStr((AbstractButton)c);
        if (value == null) {
            return -1;
        }
        final String s = value;
        switch (s) {
            case "square": {
                return 0;
            }
            case "roundRect": {
                return 1;
            }
            default: {
                return -1;
            }
        }
    }
    
    static boolean isHelpButton(final Component c) {
        return c instanceof JButton && "help".equals(getButtonTypeStr((AbstractButton)c));
    }
    
    static boolean isToolBarButton(final Component c) {
        return c.getParent() instanceof JToolBar || (c instanceof AbstractButton && "toolBarButton".equals(getButtonTypeStr((AbstractButton)c)));
    }
    
    static boolean isBorderlessButton(final Component c) {
        return c instanceof AbstractButton && "borderless".equals(getButtonTypeStr((AbstractButton)c));
    }
    
    static String getButtonTypeStr(final AbstractButton c) {
        final Object value = c.getClientProperty("JButton.buttonType");
        if (value instanceof String) {
            return (String)value;
        }
        final ButtonUI ui = c.getUI();
        return (ui instanceof FlatButtonUI) ? ((FlatButtonUI)ui).buttonType : null;
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        if (c.isOpaque()) {
            FlatUIUtils.paintParentBackground(g, c);
        }
        if (isHelpButton(c)) {
            this.helpButtonIcon.paintIcon(c, g, 0, 0);
            return;
        }
        if (isContentAreaFilled(c)) {
            this.paintBackground(g, c);
        }
        this.paint(g, c);
    }
    
    protected void paintBackground(final Graphics g, final JComponent c) {
        final Color background = this.getBackground(c);
        if (background == null) {
            return;
        }
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            final boolean def = isDefaultButton(c);
            final boolean isToolBarButton = isToolBarButton(c);
            final float focusWidth = isToolBarButton ? 0.0f : FlatUIUtils.getBorderFocusWidth(c);
            float arc = FlatUIUtils.getBorderArc(c);
            float textFieldArc = 0.0f;
            if (isToolBarButton && FlatClientProperties.clientProperty(c, "FlatLaf.styleClass", "", String.class).contains("inTextField")) {
                final JTextField textField = (JTextField)SwingUtilities.getAncestorOfClass(JTextField.class, c);
                if (textField != null) {
                    textFieldArc = FlatUIUtils.getBorderArc(textField);
                }
            }
            int x = 0;
            int y = 0;
            int width = c.getWidth();
            int height = c.getHeight();
            if (isToolBarButton && c.getBorder() instanceof FlatButtonBorder) {
                final Insets spacing = UIScale.scale(((FlatButtonBorder)c.getBorder()).toolbarSpacingInsets);
                x += spacing.left;
                y += spacing.top;
                width -= spacing.left + spacing.right;
                height -= spacing.top + spacing.bottom;
                textFieldArc -= spacing.top + spacing.bottom;
            }
            if (arc < textFieldArc) {
                arc = textFieldArc;
            }
            final Color shadowColor = def ? this.defaultShadowColor : this.shadowColor;
            if (this.paintShadow && shadowColor != null && this.shadowWidth > 0 && focusWidth > 0.0f && c.isEnabled() && !isToolBarButton && !isBorderlessButton(c) && (!isFocusPainted(c) || !FlatUIUtils.isPermanentFocusOwner(c))) {
                g2.setColor(shadowColor);
                g2.fill(new RoundRectangle2D.Float(focusWidth, focusWidth + UIScale.scale((float)this.shadowWidth), width - focusWidth * 2.0f, height - focusWidth * 2.0f, arc, arc));
            }
            final Color startBg = def ? this.defaultBackground : this.startBackground;
            final Color endBg = def ? this.defaultEndBackground : this.endBackground;
            if (background == startBg && endBg != null && !startBg.equals(endBg)) {
                g2.setPaint(new GradientPaint(0.0f, 0.0f, startBg, 0.0f, (float)height, endBg));
            }
            else {
                g2.setColor(FlatUIUtils.deriveColor(background, this.getBackgroundBase(c, def)));
            }
            FlatUIUtils.paintComponentBackground(g2, x, y, width, height, focusWidth, arc);
        }
        finally {
            g2.dispose();
        }
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        super.paint(FlatLabelUI.createGraphicsHTMLTextYCorrection(g, c), c);
    }
    
    @Override
    protected void paintIcon(final Graphics g, final JComponent c, final Rectangle iconRect) {
        final int xOffset = this.defaultBoldPlainWidthDiff(c) / 2;
        if (xOffset > 0) {
            final boolean ltr = c.getComponentOrientation().isLeftToRight();
            switch (((AbstractButton)c).getHorizontalTextPosition()) {
                case 4: {
                    iconRect.x -= xOffset;
                    break;
                }
                case 2: {
                    iconRect.x += xOffset;
                    break;
                }
                case 11: {
                    iconRect.x -= (ltr ? xOffset : (-xOffset));
                    break;
                }
                case 10: {
                    iconRect.x += (ltr ? xOffset : (-xOffset));
                    break;
                }
            }
        }
        super.paintIcon(g, c, iconRect);
    }
    
    @Override
    protected void paintText(final Graphics g, final AbstractButton b, final Rectangle textRect, final String text) {
        if (isHelpButton(b)) {
            return;
        }
        if (this.defaultBoldText && isDefaultButton(b) && b.getFont() instanceof UIResource) {
            final Font boldFont = g.getFont().deriveFont(1);
            g.setFont(boldFont);
            final int boldWidth = b.getFontMetrics(boldFont).stringWidth(text);
            if (boldWidth > textRect.width) {
                textRect.x -= (boldWidth - textRect.width) / 2;
                textRect.width = boldWidth;
            }
        }
        paintText(g, b, textRect, text, this.getForeground(b));
    }
    
    public static void paintText(final Graphics g, final AbstractButton b, final Rectangle textRect, final String text, Color foreground) {
        if (foreground == null) {
            foreground = Color.red;
        }
        final FontMetrics fm = b.getFontMetrics(b.getFont());
        final int mnemonicIndex = FlatLaf.isShowMnemonics() ? b.getDisplayedMnemonicIndex() : -1;
        g.setColor(foreground);
        FlatUIUtils.drawStringUnderlineCharAt(b, g, text, mnemonicIndex, textRect.x, textRect.y + fm.getAscent());
    }
    
    protected Color getBackground(final JComponent c) {
        final boolean toolBarButton = isToolBarButton(c) || isBorderlessButton(c);
        if (((AbstractButton)c).isSelected()) {
            return buttonStateColor(c, toolBarButton ? this.toolbarSelectedBackground : this.selectedBackground, toolBarButton ? ((this.toolbarDisabledSelectedBackground != null) ? this.toolbarDisabledSelectedBackground : this.toolbarSelectedBackground) : this.disabledSelectedBackground, null, null, toolBarButton ? this.toolbarPressedBackground : this.pressedBackground);
        }
        if (toolBarButton) {
            final Color bg = c.getBackground();
            return buttonStateColor(c, this.isCustomBackground(bg) ? bg : null, null, null, this.toolbarHoverBackground, this.toolbarPressedBackground);
        }
        final boolean def = isDefaultButton(c);
        return buttonStateColor(c, this.getBackgroundBase(c, def), this.disabledBackground, this.isCustomBackground(c.getBackground()) ? null : (def ? this.defaultFocusedBackground : this.focusedBackground), def ? this.defaultHoverBackground : this.hoverBackground, def ? this.defaultPressedBackground : this.pressedBackground);
    }
    
    protected Color getBackgroundBase(final JComponent c, final boolean def) {
        if (FlatUIUtils.isAWTPeer(c)) {
            return this.background;
        }
        final Color bg = c.getBackground();
        if (this.isCustomBackground(bg)) {
            return bg;
        }
        return def ? this.defaultBackground : bg;
    }
    
    protected boolean isCustomBackground(final Color bg) {
        return bg != this.background && (this.startBackground == null || bg != this.startBackground);
    }
    
    public static Color buttonStateColor(final Component c, final Color enabledColor, final Color disabledColor, final Color focusedColor, final Color hoverColor, final Color pressedColor) {
        if (c == null) {
            return enabledColor;
        }
        if (!c.isEnabled()) {
            return disabledColor;
        }
        if (c instanceof AbstractButton) {
            final ButtonModel model = ((AbstractButton)c).getModel();
            if (pressedColor != null && model.isPressed()) {
                return pressedColor;
            }
            if (hoverColor != null && model.isRollover()) {
                return hoverColor;
            }
        }
        if (focusedColor != null && isFocusPainted(c) && FlatUIUtils.isPermanentFocusOwner(c)) {
            return focusedColor;
        }
        return enabledColor;
    }
    
    protected Color getForeground(final JComponent c) {
        final boolean toolBarButton = isToolBarButton(c) || isBorderlessButton(c);
        if (((AbstractButton)c).isSelected()) {
            return buttonStateColor(c, toolBarButton ? ((this.toolbarSelectedForeground != null) ? this.toolbarSelectedForeground : c.getForeground()) : this.selectedForeground, toolBarButton ? ((this.toolbarDisabledSelectedForeground != null) ? this.toolbarDisabledSelectedForeground : this.disabledText) : ((this.disabledSelectedForeground != null) ? this.disabledSelectedForeground : this.disabledText), null, null, toolBarButton ? this.toolbarPressedForeground : this.pressedForeground);
        }
        if (toolBarButton) {
            return buttonStateColor(c, c.getForeground(), this.disabledText, null, this.toolbarHoverForeground, this.toolbarPressedForeground);
        }
        final boolean def = isDefaultButton(c);
        return buttonStateColor(c, this.getForegroundBase(c, def), this.disabledText, this.isCustomForeground(c.getForeground()) ? null : (def ? this.defaultFocusedForeground : this.focusedForeground), def ? this.defaultHoverForeground : this.hoverForeground, def ? this.defaultPressedForeground : this.pressedForeground);
    }
    
    protected Color getForegroundBase(final JComponent c, final boolean def) {
        final Color fg = c.getForeground();
        if (this.isCustomForeground(fg)) {
            return fg;
        }
        return def ? this.defaultForeground : fg;
    }
    
    protected boolean isCustomForeground(final Color fg) {
        return fg != this.foreground;
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        if (isHelpButton(c)) {
            return new Dimension(this.helpButtonIcon.getIconWidth(), this.helpButtonIcon.getIconHeight());
        }
        final Dimension prefSize = super.getPreferredSize(c);
        if (prefSize == null) {
            return null;
        }
        final Dimension dimension = prefSize;
        dimension.width += this.defaultBoldPlainWidthDiff(c);
        final boolean isIconOnlyOrSingleCharacter = isIconOnlyOrSingleCharacterButton(c);
        if (FlatClientProperties.clientPropertyBoolean(c, "JButton.squareSize", this.squareSize)) {
            final Dimension dimension2 = prefSize;
            final Dimension dimension3 = prefSize;
            final int max = Math.max(prefSize.width, prefSize.height);
            dimension3.height = max;
            dimension2.width = max;
        }
        else if (isIconOnlyOrSingleCharacter && ((AbstractButton)c).getIcon() == null) {
            prefSize.width = Math.max(prefSize.width, prefSize.height);
        }
        else if (!isIconOnlyOrSingleCharacter && !isToolBarButton(c) && c.getBorder() instanceof FlatButtonBorder && this.hasDefaultMargins(c)) {
            final int fw = Math.round(FlatUIUtils.getBorderFocusWidth(c) * 2.0f);
            prefSize.width = Math.max(prefSize.width, UIScale.scale(FlatUIUtils.minimumWidth(c, this.minimumWidth)) + fw);
            prefSize.height = Math.max(prefSize.height, UIScale.scale(FlatUIUtils.minimumHeight(c, this.minimumHeight)) + fw);
        }
        return prefSize;
    }
    
    private int defaultBoldPlainWidthDiff(final JComponent c) {
        if (this.defaultBoldText && isDefaultButton(c) && c.getFont() instanceof UIResource) {
            final String text = ((AbstractButton)c).getText();
            if (text == null || text.isEmpty()) {
                return 0;
            }
            final Font font = c.getFont();
            final Font boldFont = font.deriveFont(1);
            final int boldWidth = c.getFontMetrics(boldFont).stringWidth(text);
            final int plainWidth = c.getFontMetrics(font).stringWidth(text);
            if (boldWidth > plainWidth) {
                return boldWidth - plainWidth;
            }
        }
        return 0;
    }
    
    private boolean hasDefaultMargins(final JComponent c) {
        final Insets margin = ((AbstractButton)c).getMargin();
        return margin instanceof UIResource && Objects.equals(margin, this.defaultMargin);
    }
    
    protected class FlatButtonListener extends BasicButtonListener
    {
        private final AbstractButton b;
        
        protected FlatButtonListener(final AbstractButton b) {
            super(b);
            this.b = b;
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            super.propertyChange(e);
            FlatButtonUI.this.propertyChange(this.b, e);
        }
        
        @Override
        public void stateChanged(final ChangeEvent e) {
            super.stateChanged(e);
            final AbstractButton b = (AbstractButton)e.getSource();
            final Container parent = b.getParent();
            if (parent instanceof JToolBar) {
                final JToolBar toolBar = (JToolBar)parent;
                final ToolBarUI ui = toolBar.getUI();
                if (ui instanceof FlatToolBarUI) {
                    ((FlatToolBarUI)ui).repaintButtonGroup(b);
                }
            }
        }
    }
}
