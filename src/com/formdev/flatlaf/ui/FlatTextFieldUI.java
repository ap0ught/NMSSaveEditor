// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import java.util.function.Consumer;
import java.awt.Cursor;
import javax.swing.JButton;
import java.util.Objects;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Dimension;
import com.formdev.flatlaf.util.UIScale;
import java.awt.FontMetrics;
import com.formdev.flatlaf.util.JavaCompatibility;
import java.awt.Container;
import javax.swing.JComboBox;
import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import javax.swing.plaf.UIResource;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.event.DocumentEvent;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import java.beans.PropertyChangeEvent;
import javax.swing.text.Caret;
import java.util.function.Predicate;
import java.awt.Component;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.plaf.ComponentUI;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusListener;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class FlatTextFieldUI extends BasicTextFieldUI implements FlatStylingSupport.StyleableUI
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
    protected Color placeholderForeground;
    @FlatStylingSupport.Styleable
    protected Color focusedBackground;
    @FlatStylingSupport.Styleable
    protected int iconTextGap;
    @FlatStylingSupport.Styleable
    protected Icon leadingIcon;
    @FlatStylingSupport.Styleable
    protected Icon trailingIcon;
    protected JComponent leadingComponent;
    protected JComponent trailingComponent;
    protected JComponent clearButton;
    @FlatStylingSupport.Styleable
    protected boolean showClearButton;
    private Color oldDisabledBackground;
    private Color oldInactiveBackground;
    private Insets defaultMargin;
    private FocusListener focusListener;
    private DocumentListener documentListener;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatTextFieldUI();
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
        this.leadingIcon = FlatClientProperties.clientProperty(c, "JTextField.leadingIcon", null, Icon.class);
        this.trailingIcon = FlatClientProperties.clientProperty(c, "JTextField.trailingIcon", null, Icon.class);
        this.installLeadingComponent();
        this.installTrailingComponent();
        this.installClearButton();
        this.installStyle();
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        this.uninstallLeadingComponent();
        this.uninstallTrailingComponent();
        this.uninstallClearButton();
        super.uninstallUI(c);
        this.leadingIcon = null;
        this.trailingIcon = null;
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
        this.placeholderForeground = UIManager.getColor(prefix + ".placeholderForeground");
        this.focusedBackground = UIManager.getColor(prefix + ".focusedBackground");
        this.iconTextGap = FlatUIUtils.getUIInt(prefix + ".iconTextGap", 4);
        this.defaultMargin = UIManager.getInsets(prefix + ".margin");
        LookAndFeel.installProperty(this.getComponent(), "opaque", false);
        MigLayoutVisualPadding.install(this.getComponent());
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.background = null;
        this.disabledBackground = null;
        this.inactiveBackground = null;
        this.placeholderForeground = null;
        this.focusedBackground = null;
        this.oldDisabledBackground = null;
        this.oldInactiveBackground = null;
        this.oldStyleValues = null;
        this.borderShared = null;
        MigLayoutVisualPadding.uninstall(this.getComponent());
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.focusListener = new FlatUIUtils.RepaintFocusListener(this.getComponent(), null);
        this.getComponent().addFocusListener(this.focusListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.getComponent().removeFocusListener(this.focusListener);
        this.focusListener = null;
        if (this.documentListener != null) {
            this.getComponent().getDocument().removeDocumentListener(this.documentListener);
            this.documentListener = null;
        }
    }
    
    @Override
    protected Caret createCaret() {
        return new FlatCaret(UIManager.getString("TextComponent.selectAllOnFocusPolicy"), UIManager.getBoolean("TextComponent.selectAllOnMouseClick"));
    }
    
    @Override
    protected void propertyChange(final PropertyChangeEvent e) {
        final String propertyName = e.getPropertyName();
        if ("editable".equals(propertyName) || "enabled".equals(propertyName)) {
            this.updateBackground();
        }
        else {
            super.propertyChange(e);
        }
        final JTextComponent c = this.getComponent();
        final String propertyName2 = e.getPropertyName();
        switch (propertyName2) {
            case "JTextField.placeholderText":
            case "JComponent.roundRect":
            case "JComponent.outline":
            case "JTextField.padding": {
                c.repaint();
                break;
            }
            case "JComponent.minimumWidth": {
                c.revalidate();
                break;
            }
            case "FlatLaf.style":
            case "FlatLaf.styleClass": {
                this.installStyle();
                c.revalidate();
                c.repaint();
                break;
            }
            case "JTextField.leadingIcon": {
                this.leadingIcon = ((e.getNewValue() instanceof Icon) ? ((Icon)e.getNewValue()) : null);
                c.repaint();
                break;
            }
            case "JTextField.trailingIcon": {
                this.trailingIcon = ((e.getNewValue() instanceof Icon) ? ((Icon)e.getNewValue()) : null);
                c.repaint();
                break;
            }
            case "JTextField.leadingComponent": {
                this.uninstallLeadingComponent();
                this.installLeadingComponent();
                c.revalidate();
                c.repaint();
                break;
            }
            case "JTextField.trailingComponent": {
                this.uninstallTrailingComponent();
                this.installTrailingComponent();
                c.revalidate();
                c.repaint();
                break;
            }
            case "JTextField.showClearButton": {
                this.uninstallClearButton();
                this.installClearButton();
                c.revalidate();
                c.repaint();
                break;
            }
            case "enabled":
            case "editable": {
                this.updateClearButton();
                break;
            }
            case "document": {
                if (this.documentListener != null) {
                    if (e.getOldValue() instanceof Document) {
                        ((Document)e.getOldValue()).removeDocumentListener(this.documentListener);
                    }
                    if (e.getNewValue() instanceof Document) {
                        ((Document)e.getNewValue()).addDocumentListener(this.documentListener);
                    }
                    this.updateClearButton();
                    break;
                }
                break;
            }
        }
    }
    
    protected void installDocumentListener() {
        if (this.documentListener != null) {
            return;
        }
        this.documentListener = new FlatDocumentListener();
        this.getComponent().getDocument().addDocumentListener(this.documentListener);
    }
    
    protected void documentChanged(final DocumentEvent e) {
        if (this.clearButton != null) {
            this.updateClearButton();
        }
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.getComponent(), this.getStyleType()));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    String getStyleType() {
        return "TextField";
    }
    
    protected void applyStyle(final Object style) {
        this.oldDisabledBackground = this.disabledBackground;
        this.oldInactiveBackground = this.inactiveBackground;
        final boolean oldShowClearButton = this.showClearButton;
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        this.updateBackground();
        if (this.showClearButton != oldShowClearButton) {
            this.uninstallClearButton();
            this.installClearButton();
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (this.borderShared == null) {
            this.borderShared = new AtomicBoolean(true);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.getComponent(), this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.getComponent().getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.getComponent().getBorder(), key);
    }
    
    private void updateBackground() {
        updateBackground(this.getComponent(), this.background, this.disabledBackground, this.inactiveBackground, this.oldDisabledBackground, this.oldInactiveBackground);
    }
    
    static void updateBackground(final JTextComponent c, final Color background, final Color disabledBackground, final Color inactiveBackground, final Color oldDisabledBackground, final Color oldInactiveBackground) {
        final Color oldBackground = c.getBackground();
        if (!(oldBackground instanceof UIResource)) {
            return;
        }
        if (oldBackground != background && oldBackground != disabledBackground && oldBackground != inactiveBackground && oldBackground != oldDisabledBackground && oldBackground != oldInactiveBackground) {
            return;
        }
        final Color newBackground = c.isEnabled() ? (c.isEditable() ? background : inactiveBackground) : disabledBackground;
        if (newBackground != oldBackground) {
            c.setBackground(newBackground);
        }
    }
    
    @Override
    protected void paintSafely(final Graphics g) {
        paintBackground(g, this.getComponent(), this.isIntelliJTheme, this.focusedBackground);
        this.paintPlaceholder(g);
        if (this.hasLeadingIcon() || this.hasTrailingIcon()) {
            this.paintIcons(g, new Rectangle(this.getIconsRect()));
        }
        super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
    }
    
    @Override
    protected void paintBackground(final Graphics g) {
    }
    
    static void paintBackground(final Graphics g, final JTextComponent c, final boolean isIntelliJTheme, final Color focusedBackground) {
        if (!c.isOpaque() && FlatUIUtils.getOutsideFlatBorder(c) == null && FlatUIUtils.hasOpaqueBeenExplicitlySet(c)) {
            return;
        }
        final float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
        final float arc = FlatUIUtils.getBorderArc(c);
        if (c.isOpaque() && (focusWidth > 0.0f || arc > 0.0f)) {
            FlatUIUtils.paintParentBackground(g, c);
        }
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(getBackground(c, isIntelliJTheme, focusedBackground));
            FlatUIUtils.paintComponentBackground(g2, 0, 0, c.getWidth(), c.getHeight(), focusWidth, arc);
        }
        finally {
            g2.dispose();
        }
    }
    
    static Color getBackground(final JTextComponent c, final boolean isIntelliJTheme, final Color focusedBackground) {
        final Color background = c.getBackground();
        if (!(background instanceof UIResource)) {
            return background;
        }
        if (focusedBackground != null && FlatUIUtils.isPermanentFocusOwner(c)) {
            return focusedBackground;
        }
        if (isIntelliJTheme && (!c.isEnabled() || !c.isEditable())) {
            return FlatUIUtils.getParentBackground(c);
        }
        return background;
    }
    
    protected void paintPlaceholder(final Graphics g) {
        final JTextComponent c = this.getComponent();
        if (c.getDocument().getLength() > 0) {
            return;
        }
        final Container parent = c.getParent();
        final JComponent jc = (JComponent)((parent instanceof JComboBox) ? parent : c);
        final String placeholder = FlatClientProperties.clientProperty(jc, "JTextField.placeholderText", null, String.class);
        if (placeholder == null) {
            return;
        }
        final Rectangle r = this.getVisibleEditorRect();
        final FontMetrics fm = c.getFontMetrics(c.getFont());
        final String clippedPlaceholder = JavaCompatibility.getClippedString(c, fm, placeholder, r.width);
        final int x = r.x + (this.isLeftToRight() ? 0 : (r.width - fm.stringWidth(clippedPlaceholder)));
        final int y = r.y + fm.getAscent() + (r.height - fm.getHeight()) / 2;
        g.setColor(this.placeholderForeground);
        FlatUIUtils.drawString(c, g, clippedPlaceholder, x, y);
    }
    
    protected void paintIcons(final Graphics g, final Rectangle r) {
        final boolean ltr = this.isLeftToRight();
        final Icon leftIcon = ltr ? this.leadingIcon : this.trailingIcon;
        final Icon rightIcon = ltr ? this.trailingIcon : this.leadingIcon;
        if (leftIcon != null) {
            final int x = r.x;
            final int y = r.y + Math.round((r.height - leftIcon.getIconHeight()) / 2.0f);
            leftIcon.paintIcon(this.getComponent(), g, x, y);
            final int w = leftIcon.getIconWidth() + UIScale.scale(this.iconTextGap);
            r.x += w;
            r.width -= w;
        }
        if (rightIcon != null) {
            final int iconWidth = rightIcon.getIconWidth();
            final int x2 = r.x + r.width - iconWidth;
            final int y2 = r.y + Math.round((r.height - rightIcon.getIconHeight()) / 2.0f);
            rightIcon.paintIcon(this.getComponent(), g, x2, y2);
            r.width -= iconWidth + UIScale.scale(this.iconTextGap);
        }
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return this.applyMinimumWidth(c, this.applyExtraSize(super.getPreferredSize(c)), this.minimumWidth);
    }
    
    @Override
    public Dimension getMinimumSize(final JComponent c) {
        return this.applyMinimumWidth(c, this.applyExtraSize(super.getMinimumSize(c)), this.minimumWidth);
    }
    
    private Dimension applyExtraSize(final Dimension size) {
        size.width += this.getLeadingIconWidth() + this.getTrailingIconWidth();
        for (final JComponent comp : this.getLeadingComponents()) {
            if (comp != null && comp.isVisible()) {
                size.width += comp.getPreferredSize().width;
            }
        }
        for (final JComponent comp : this.getTrailingComponents()) {
            if (comp != null && comp.isVisible()) {
                size.width += comp.getPreferredSize().width;
            }
        }
        return size;
    }
    
    private Dimension applyMinimumWidth(final JComponent c, final Dimension size, int minimumWidth) {
        if (c instanceof JTextField && ((JTextField)c).getColumns() > 0) {
            return size;
        }
        if (!hasDefaultMargins(c, this.defaultMargin)) {
            return size;
        }
        final Container parent = c.getParent();
        if (parent instanceof JComboBox || parent instanceof JSpinner || (parent != null && parent.getParent() instanceof JSpinner)) {
            return size;
        }
        minimumWidth = FlatUIUtils.minimumWidth(c, minimumWidth);
        final float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
        size.width = Math.max(size.width, UIScale.scale(minimumWidth) + Math.round(focusWidth * 2.0f));
        return size;
    }
    
    static boolean hasDefaultMargins(final JComponent c, final Insets defaultMargin) {
        final Insets margin = ((JTextComponent)c).getMargin();
        return margin instanceof UIResource && Objects.equals(margin, defaultMargin);
    }
    
    @Override
    protected Rectangle getVisibleEditorRect() {
        Rectangle r = this.getIconsRect();
        if (r == null) {
            return null;
        }
        final int leading = this.getLeadingIconWidth();
        final int trailing = this.getTrailingIconWidth();
        if (leading != 0 || trailing != 0) {
            final boolean ltr = this.isLeftToRight();
            final int left = ltr ? leading : trailing;
            final int right = ltr ? trailing : leading;
            final Rectangle rectangle = r;
            rectangle.x += left;
            final Rectangle rectangle2 = r;
            rectangle2.width -= left + right;
        }
        final Insets padding = this.getPadding();
        if (padding != null) {
            r = FlatUIUtils.subtractInsets(r, padding);
        }
        r.width = Math.max(r.width, 0);
        r.height = Math.max(r.height, 0);
        return r;
    }
    
    protected Rectangle getIconsRect() {
        final Rectangle r = super.getVisibleEditorRect();
        if (r == null) {
            return null;
        }
        final boolean ltr = this.isLeftToRight();
        final JComponent[] leftComponents = ltr ? this.getLeadingComponents() : this.getTrailingComponents();
        final JComponent[] rightComponents = ltr ? this.getTrailingComponents() : this.getLeadingComponents();
        boolean leftVisible = false;
        boolean rightVisible = false;
        for (final JComponent leftComponent : leftComponents) {
            if (leftComponent != null && leftComponent.isVisible()) {
                final int w = leftComponent.getPreferredSize().width;
                final Rectangle rectangle = r;
                rectangle.x += w;
                final Rectangle rectangle2 = r;
                rectangle2.width -= w;
                leftVisible = true;
            }
        }
        for (final JComponent rightComponent : rightComponents) {
            if (rightComponent != null && rightComponent.isVisible()) {
                final Rectangle rectangle3 = r;
                rectangle3.width -= rightComponent.getPreferredSize().width;
                rightVisible = true;
            }
        }
        Label_0294: {
            if (!leftVisible) {
                if (ltr) {
                    if (!this.hasLeadingIcon()) {
                        break Label_0294;
                    }
                }
                else if (!this.hasTrailingIcon()) {
                    break Label_0294;
                }
            }
            final Insets margin = this.getComponent().getMargin();
            final int newLeftMargin = Math.min(margin.left, margin.top);
            if (newLeftMargin < margin.left) {
                final int diff = UIScale.scale(margin.left - newLeftMargin);
                final Rectangle rectangle4 = r;
                rectangle4.x -= diff;
                final Rectangle rectangle5 = r;
                rectangle5.width += diff;
            }
        }
        Label_0374: {
            if (!rightVisible) {
                if (ltr) {
                    if (!this.hasTrailingIcon()) {
                        break Label_0374;
                    }
                }
                else if (!this.hasLeadingIcon()) {
                    break Label_0374;
                }
            }
            final Insets margin = this.getComponent().getMargin();
            final int newRightMargin = Math.min(margin.right, margin.top);
            if (newRightMargin < margin.left) {
                final Rectangle rectangle6 = r;
                rectangle6.width += UIScale.scale(margin.right - newRightMargin);
            }
        }
        r.width = Math.max(r.width, 0);
        r.height = Math.max(r.height, 0);
        return r;
    }
    
    protected boolean hasLeadingIcon() {
        return this.leadingIcon != null;
    }
    
    protected boolean hasTrailingIcon() {
        return this.trailingIcon != null;
    }
    
    protected int getLeadingIconWidth() {
        return (this.leadingIcon != null) ? (this.leadingIcon.getIconWidth() + UIScale.scale(this.iconTextGap)) : 0;
    }
    
    protected int getTrailingIconWidth() {
        return (this.trailingIcon != null) ? (this.trailingIcon.getIconWidth() + UIScale.scale(this.iconTextGap)) : 0;
    }
    
    boolean isLeftToRight() {
        return this.getComponent().getComponentOrientation().isLeftToRight();
    }
    
    protected Insets getPadding() {
        return UIScale.scale(FlatClientProperties.clientProperty(this.getComponent(), "JTextField.padding", null, Insets.class));
    }
    
    protected void scrollCaretToVisible() {
        final Caret caret = this.getComponent().getCaret();
        if (caret instanceof FlatCaret) {
            ((FlatCaret)caret).scrollCaretToVisible();
        }
    }
    
    protected void installLeadingComponent() {
        final JTextComponent c = this.getComponent();
        this.leadingComponent = FlatClientProperties.clientProperty(c, "JTextField.leadingComponent", null, JComponent.class);
        if (this.leadingComponent != null) {
            this.prepareLeadingOrTrailingComponent(this.leadingComponent);
            this.installLayout();
            c.add(this.leadingComponent);
        }
    }
    
    protected void installTrailingComponent() {
        final JTextComponent c = this.getComponent();
        this.trailingComponent = FlatClientProperties.clientProperty(c, "JTextField.trailingComponent", null, JComponent.class);
        if (this.trailingComponent != null) {
            this.prepareLeadingOrTrailingComponent(this.trailingComponent);
            this.installLayout();
            c.add(this.trailingComponent);
        }
    }
    
    protected void uninstallLeadingComponent() {
        if (this.leadingComponent != null) {
            this.getComponent().remove(this.leadingComponent);
            this.leadingComponent = null;
        }
    }
    
    protected void uninstallTrailingComponent() {
        if (this.trailingComponent != null) {
            this.getComponent().remove(this.trailingComponent);
            this.trailingComponent = null;
        }
    }
    
    protected void installClearButton() {
        final JTextComponent c = this.getComponent();
        if (FlatClientProperties.clientPropertyBoolean(c, "JTextField.showClearButton", this.showClearButton)) {
            this.clearButton = this.createClearButton();
            this.updateClearButton();
            this.installDocumentListener();
            this.installLayout();
            c.add(this.clearButton);
        }
    }
    
    protected void uninstallClearButton() {
        if (this.clearButton != null) {
            this.getComponent().remove(this.clearButton);
            this.clearButton = null;
        }
    }
    
    protected JComponent createClearButton() {
        final JButton button = new JButton();
        button.setName("TextField.clearButton");
        button.putClientProperty("FlatLaf.styleClass", "clearButton");
        button.putClientProperty("JButton.buttonType", "toolBarButton");
        button.setCursor(Cursor.getDefaultCursor());
        button.addActionListener(e -> this.clearButtonClicked());
        return button;
    }
    
    protected void clearButtonClicked() {
        final JTextComponent c = this.getComponent();
        final Object callback = c.getClientProperty("JTextField.clearCallback");
        if (callback instanceof Runnable) {
            ((Runnable)callback).run();
        }
        else if (callback instanceof Consumer) {
            ((Consumer)callback).accept(c);
        }
        else {
            c.setText("");
        }
    }
    
    protected void updateClearButton() {
        if (this.clearButton == null) {
            return;
        }
        final JTextComponent c = this.getComponent();
        final boolean visible = c.isEnabled() && c.isEditable() && c.getDocument().getLength() > 0;
        if (visible != this.clearButton.isVisible()) {
            this.clearButton.setVisible(visible);
            c.revalidate();
            c.repaint();
        }
    }
    
    protected JComponent[] getLeadingComponents() {
        return new JComponent[] { this.leadingComponent };
    }
    
    protected JComponent[] getTrailingComponents() {
        return new JComponent[] { this.trailingComponent, this.clearButton };
    }
    
    protected void prepareLeadingOrTrailingComponent(final JComponent c) {
        c.putClientProperty("FlatLaf.styleClass", "inTextField");
        if (c instanceof JButton || c instanceof JToggleButton) {
            c.putClientProperty("JButton.buttonType", "toolBarButton");
            if (!c.isCursorSet()) {
                c.setCursor(Cursor.getDefaultCursor());
            }
        }
        else if (c instanceof JToolBar) {
            for (final Component child : c.getComponents()) {
                if (child instanceof JComponent) {
                    ((JComponent)child).putClientProperty("FlatLaf.styleClass", "inTextField");
                }
            }
            if (!c.isCursorSet()) {
                c.setCursor(Cursor.getDefaultCursor());
            }
        }
    }
    
    protected void installLayout() {
        final JTextComponent c = this.getComponent();
        final LayoutManager oldLayout = c.getLayout();
        if (!(oldLayout instanceof FlatTextFieldLayout)) {
            c.setLayout(new FlatTextFieldLayout(oldLayout));
        }
    }
    
    private class FlatTextFieldLayout implements LayoutManager2, UIResource
    {
        private final LayoutManager delegate;
        
        FlatTextFieldLayout(final LayoutManager delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public void addLayoutComponent(final String name, final Component comp) {
            if (this.delegate != null) {
                this.delegate.addLayoutComponent(name, comp);
            }
        }
        
        @Override
        public void removeLayoutComponent(final Component comp) {
            if (this.delegate != null) {
                this.delegate.removeLayoutComponent(comp);
            }
        }
        
        @Override
        public Dimension preferredLayoutSize(final Container parent) {
            return (this.delegate != null) ? this.delegate.preferredLayoutSize(parent) : null;
        }
        
        @Override
        public Dimension minimumLayoutSize(final Container parent) {
            return (this.delegate != null) ? this.delegate.minimumLayoutSize(parent) : null;
        }
        
        @Override
        public void layoutContainer(final Container parent) {
            if (this.delegate != null) {
                this.delegate.layoutContainer(parent);
            }
            final int ow = FlatUIUtils.getBorderFocusAndLineWidth(BasicTextUI.this.getComponent());
            final int h = parent.getHeight() - ow - ow;
            final boolean ltr = FlatTextFieldUI.this.isLeftToRight();
            final JComponent[] leftComponents = ltr ? FlatTextFieldUI.this.getLeadingComponents() : FlatTextFieldUI.this.getTrailingComponents();
            final JComponent[] rightComponents = ltr ? FlatTextFieldUI.this.getTrailingComponents() : FlatTextFieldUI.this.getLeadingComponents();
            int x = ow;
            for (final JComponent leftComponent : leftComponents) {
                if (leftComponent != null && leftComponent.isVisible()) {
                    final int cw = leftComponent.getPreferredSize().width;
                    leftComponent.setBounds(x, ow, cw, h);
                    x += cw;
                }
            }
            x = parent.getWidth() - ow;
            for (final JComponent rightComponent : rightComponents) {
                if (rightComponent != null && rightComponent.isVisible()) {
                    final int cw = rightComponent.getPreferredSize().width;
                    x -= cw;
                    rightComponent.setBounds(x, ow, cw, h);
                }
            }
        }
        
        @Override
        public void addLayoutComponent(final Component comp, final Object constraints) {
            if (this.delegate instanceof LayoutManager2) {
                ((LayoutManager2)this.delegate).addLayoutComponent(comp, constraints);
            }
        }
        
        @Override
        public Dimension maximumLayoutSize(final Container target) {
            return (this.delegate instanceof LayoutManager2) ? ((LayoutManager2)this.delegate).maximumLayoutSize(target) : null;
        }
        
        @Override
        public float getLayoutAlignmentX(final Container target) {
            return (this.delegate instanceof LayoutManager2) ? ((LayoutManager2)this.delegate).getLayoutAlignmentX(target) : 0.5f;
        }
        
        @Override
        public float getLayoutAlignmentY(final Container target) {
            return (this.delegate instanceof LayoutManager2) ? ((LayoutManager2)this.delegate).getLayoutAlignmentY(target) : 0.5f;
        }
        
        @Override
        public void invalidateLayout(final Container target) {
            if (this.delegate instanceof LayoutManager2) {
                ((LayoutManager2)this.delegate).invalidateLayout(target);
            }
        }
    }
    
    private class FlatDocumentListener implements DocumentListener
    {
        @Override
        public void insertUpdate(final DocumentEvent e) {
            FlatTextFieldUI.this.documentChanged(e);
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            FlatTextFieldUI.this.documentChanged(e);
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
            FlatTextFieldUI.this.documentChanged(e);
        }
    }
}
