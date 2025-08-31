// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import java.awt.event.FocusEvent;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.Paint;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.plaf.UIResource;
import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import java.awt.event.FocusListener;
import javax.swing.UIManager;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class FlatSpinnerUI extends BasicSpinnerUI implements FlatStylingSupport.StyleableUI
{
    private Handler handler;
    @FlatStylingSupport.Styleable
    protected int minimumWidth;
    @FlatStylingSupport.Styleable
    protected String buttonStyle;
    @FlatStylingSupport.Styleable
    protected String arrowType;
    protected boolean isIntelliJTheme;
    @FlatStylingSupport.Styleable
    protected Color disabledBackground;
    @FlatStylingSupport.Styleable
    protected Color disabledForeground;
    @FlatStylingSupport.Styleable
    protected Color focusedBackground;
    @FlatStylingSupport.Styleable
    protected Color buttonBackground;
    @FlatStylingSupport.Styleable
    protected float buttonSeparatorWidth;
    @FlatStylingSupport.Styleable
    protected Color buttonSeparatorColor;
    @FlatStylingSupport.Styleable
    protected Color buttonDisabledSeparatorColor;
    @FlatStylingSupport.Styleable
    protected Color buttonArrowColor;
    @FlatStylingSupport.Styleable
    protected Color buttonDisabledArrowColor;
    @FlatStylingSupport.Styleable
    protected Color buttonHoverArrowColor;
    @FlatStylingSupport.Styleable
    protected Color buttonPressedArrowColor;
    @FlatStylingSupport.Styleable
    protected Insets padding;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    private static final int MAC_STEPPER_WIDTH = 15;
    private static final int MAC_STEPPER_GAP = 3;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatSpinnerUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.installProperty(this.spinner, "opaque", false);
        this.minimumWidth = UIManager.getInt("Component.minimumWidth");
        this.buttonStyle = UIManager.getString("Spinner.buttonStyle");
        this.arrowType = UIManager.getString("Component.arrowType");
        this.isIntelliJTheme = UIManager.getBoolean("Component.isIntelliJTheme");
        this.disabledBackground = UIManager.getColor("Spinner.disabledBackground");
        this.disabledForeground = UIManager.getColor("Spinner.disabledForeground");
        this.focusedBackground = UIManager.getColor("Spinner.focusedBackground");
        this.buttonBackground = UIManager.getColor("Spinner.buttonBackground");
        this.buttonSeparatorWidth = FlatUIUtils.getUIFloat("Spinner.buttonSeparatorWidth", FlatUIUtils.getUIFloat("Component.borderWidth", 1.0f));
        this.buttonSeparatorColor = UIManager.getColor("Spinner.buttonSeparatorColor");
        this.buttonDisabledSeparatorColor = UIManager.getColor("Spinner.buttonDisabledSeparatorColor");
        this.buttonArrowColor = UIManager.getColor("Spinner.buttonArrowColor");
        this.buttonDisabledArrowColor = UIManager.getColor("Spinner.buttonDisabledArrowColor");
        this.buttonHoverArrowColor = UIManager.getColor("Spinner.buttonHoverArrowColor");
        this.buttonPressedArrowColor = UIManager.getColor("Spinner.buttonPressedArrowColor");
        this.padding = UIManager.getInsets("Spinner.padding");
        MigLayoutVisualPadding.install(this.spinner);
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.disabledBackground = null;
        this.disabledForeground = null;
        this.focusedBackground = null;
        this.buttonBackground = null;
        this.buttonSeparatorColor = null;
        this.buttonDisabledSeparatorColor = null;
        this.buttonArrowColor = null;
        this.buttonDisabledArrowColor = null;
        this.buttonHoverArrowColor = null;
        this.buttonPressedArrowColor = null;
        this.padding = null;
        this.oldStyleValues = null;
        this.borderShared = null;
        MigLayoutVisualPadding.uninstall(this.spinner);
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.addEditorFocusListener(this.spinner.getEditor());
        this.spinner.addFocusListener(this.getHandler());
        this.spinner.addPropertyChangeListener(this.getHandler());
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.removeEditorFocusListener(this.spinner.getEditor());
        this.spinner.removeFocusListener(this.getHandler());
        this.spinner.removePropertyChangeListener(this.getHandler());
        this.handler = null;
    }
    
    private Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler();
        }
        return this.handler;
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.spinner, "Spinner"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        this.updateEditorPadding();
        this.updateArrowButtonsStyle();
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (this.borderShared == null) {
            this.borderShared = new AtomicBoolean(true);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.spinner, this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.spinner.getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.spinner.getBorder(), key);
    }
    
    @Override
    protected JComponent createEditor() {
        final JComponent editor = super.createEditor();
        this.configureEditor(editor);
        return editor;
    }
    
    @Override
    protected void replaceEditor(final JComponent oldEditor, final JComponent newEditor) {
        super.replaceEditor(oldEditor, newEditor);
        this.configureEditor(newEditor);
        this.removeEditorFocusListener(oldEditor);
        this.addEditorFocusListener(newEditor);
    }
    
    protected void configureEditor(final JComponent editor) {
        editor.setOpaque(false);
        final JTextField textField = getEditorTextField(editor);
        if (textField != null) {
            textField.setOpaque(false);
        }
        this.updateEditorPadding();
        this.updateEditorColors();
    }
    
    private void addEditorFocusListener(final JComponent editor) {
        final JTextField textField = getEditorTextField(editor);
        if (textField != null) {
            textField.addFocusListener(this.getHandler());
        }
    }
    
    private void removeEditorFocusListener(final JComponent editor) {
        final JTextField textField = getEditorTextField(editor);
        if (textField != null) {
            textField.removeFocusListener(this.getHandler());
        }
    }
    
    private void updateEditorPadding() {
        final JTextField textField = getEditorTextField(this.spinner.getEditor());
        if (textField != null) {
            textField.putClientProperty("JTextField.padding", this.padding);
        }
    }
    
    private void updateEditorColors() {
        final JTextField textField = getEditorTextField(this.spinner.getEditor());
        if (textField != null) {
            textField.setForeground(FlatUIUtils.nonUIResource(this.getForeground(true)));
            textField.setDisabledTextColor(FlatUIUtils.nonUIResource(this.getForeground(false)));
        }
    }
    
    private static JTextField getEditorTextField(final JComponent editor) {
        return (editor instanceof JSpinner.DefaultEditor) ? ((JSpinner.DefaultEditor)editor).getTextField() : null;
    }
    
    public static boolean isPermanentFocusOwner(final JSpinner spinner) {
        if (FlatUIUtils.isPermanentFocusOwner(spinner)) {
            return true;
        }
        final JTextField textField = getEditorTextField(spinner.getEditor());
        return textField != null && FlatUIUtils.isPermanentFocusOwner(textField);
    }
    
    protected Color getBackground(final boolean enabled) {
        if (!enabled) {
            return this.isIntelliJTheme ? FlatUIUtils.getParentBackground(this.spinner) : this.disabledBackground;
        }
        final Color background = this.spinner.getBackground();
        if (!(background instanceof UIResource)) {
            return background;
        }
        if (this.focusedBackground != null && isPermanentFocusOwner(this.spinner)) {
            return this.focusedBackground;
        }
        return background;
    }
    
    protected Color getForeground(final boolean enabled) {
        return enabled ? this.spinner.getForeground() : this.disabledForeground;
    }
    
    @Override
    protected LayoutManager createLayout() {
        return this.getHandler();
    }
    
    @Override
    protected Component createNextButton() {
        return this.createArrowButton(1, "Spinner.nextButton");
    }
    
    @Override
    protected Component createPreviousButton() {
        return this.createArrowButton(5, "Spinner.previousButton");
    }
    
    private Component createArrowButton(final int direction, final String name) {
        final FlatArrowButton button = new FlatArrowButton(direction, this.arrowType, this.buttonArrowColor, this.buttonDisabledArrowColor, this.buttonHoverArrowColor, null, this.buttonPressedArrowColor, null) {
            @Override
            public int getArrowWidth() {
                return FlatSpinnerUI.this.isMacStyle() ? 7 : super.getArrowWidth();
            }
            
            @Override
            public float getArrowThickness() {
                return FlatSpinnerUI.this.isMacStyle() ? 1.5f : super.getArrowThickness();
            }
            
            @Override
            public float getYOffset() {
                return FlatSpinnerUI.this.isMacStyle() ? 0.0f : super.getYOffset();
            }
            
            @Override
            public boolean isRoundBorderAutoXOffset() {
                return !FlatSpinnerUI.this.isMacStyle() && super.isRoundBorderAutoXOffset();
            }
        };
        button.setName(name);
        button.setYOffset((direction == 1) ? 1.25f : -1.25f);
        if (direction == 1) {
            this.installNextButtonListeners(button);
        }
        else {
            this.installPreviousButtonListeners(button);
        }
        return button;
    }
    
    private void updateArrowButtonsStyle() {
        for (final Component c : this.spinner.getComponents()) {
            if (c instanceof FlatArrowButton) {
                ((FlatArrowButton)c).updateStyle(this.arrowType, this.buttonArrowColor, this.buttonDisabledArrowColor, this.buttonHoverArrowColor, null, this.buttonPressedArrowColor, null);
            }
        }
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        final float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
        final float arc = FlatUIUtils.getBorderArc(c);
        if (c.isOpaque() && (focusWidth > 0.0f || arc > 0.0f)) {
            FlatUIUtils.paintParentBackground(g, c);
        }
        final Graphics2D g2 = (Graphics2D)g;
        final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g2);
        final int width = c.getWidth();
        final int height = c.getHeight();
        final boolean enabled = this.spinner.isEnabled();
        final boolean ltr = this.spinner.getComponentOrientation().isLeftToRight();
        final boolean isMacStyle = this.isMacStyle();
        final int macStyleButtonsWidth = isMacStyle ? this.getMacStyleButtonsWidth() : 0;
        g2.setColor(this.getBackground(enabled));
        FlatUIUtils.paintComponentBackground(g2, ltr ? 0 : macStyleButtonsWidth, 0, width - macStyleButtonsWidth, height, focusWidth, arc);
        final boolean paintButton = !"none".equals(this.buttonStyle);
        final Handler handler = this.getHandler();
        if (paintButton && (handler.nextButton != null || handler.previousButton != null)) {
            final Component button = (handler.nextButton != null) ? handler.nextButton : handler.previousButton;
            final int arrowX = button.getX();
            final int arrowWidth = button.getWidth();
            final Color separatorColor = enabled ? this.buttonSeparatorColor : this.buttonDisabledSeparatorColor;
            if (isMacStyle) {
                final Insets insets = this.spinner.getInsets();
                final int lineWidth = Math.round(FlatUIUtils.getBorderLineWidth(this.spinner));
                final int bx = arrowX;
                final int by = insets.top - lineWidth;
                final int bw = arrowWidth;
                final int bh = height - insets.top - insets.bottom + lineWidth * 2;
                final float lw = UIScale.scale(this.buttonSeparatorWidth);
                FlatUIUtils.paintOutlinedComponent(g2, bx, by, bw, bh, 0.0f, 0.0f, 0.0f, lw, (float)UIScale.scale(12), null, separatorColor, this.buttonBackground);
                if (separatorColor != null) {
                    final int thickness = UIScale.scale(1);
                    g2.setColor(separatorColor);
                    g2.fill(new Rectangle2D.Float(bx + lw, by + (bh - thickness) / 2.0f, bw - lw * 2.0f, (float)thickness));
                }
            }
            else {
                if (enabled && this.buttonBackground != null) {
                    g2.setColor(this.buttonBackground);
                    final Shape oldClip = g2.getClip();
                    if (ltr) {
                        g2.clipRect(arrowX, 0, width - arrowX, height);
                    }
                    else {
                        g2.clipRect(0, 0, arrowX + arrowWidth, height);
                    }
                    FlatUIUtils.paintComponentBackground(g2, 0, 0, width, height, focusWidth, arc);
                    g2.setClip(oldClip);
                }
                if (separatorColor != null && this.buttonSeparatorWidth > 0.0f) {
                    g2.setColor(separatorColor);
                    final float lw2 = UIScale.scale(this.buttonSeparatorWidth);
                    final float lx = ltr ? ((float)arrowX) : (arrowX + arrowWidth - lw2);
                    g2.fill(new Rectangle2D.Float(lx, focusWidth, lw2, height - 1 - focusWidth * 2.0f));
                }
            }
        }
        this.paint(g, c);
        FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
    }
    
    boolean isMacStyle() {
        return "mac".equals(this.buttonStyle);
    }
    
    int getMacStyleButtonsWidth() {
        return (this.handler.nextButton != null || this.handler.previousButton != null) ? (UIScale.scale(3) + UIScale.scale(15)) : 0;
    }
    
    private class Handler implements LayoutManager, FocusListener, PropertyChangeListener
    {
        private Component editor;
        private Component nextButton;
        private Component previousButton;
        
        private Handler() {
            this.editor = null;
        }
        
        @Override
        public void addLayoutComponent(final String name, final Component c) {
            switch (name) {
                case "Editor": {
                    this.editor = c;
                    break;
                }
                case "Next": {
                    this.nextButton = c;
                    break;
                }
                case "Previous": {
                    this.previousButton = c;
                    break;
                }
            }
        }
        
        @Override
        public void removeLayoutComponent(final Component c) {
            if (c == this.editor) {
                this.editor = null;
            }
            else if (c == this.nextButton) {
                this.nextButton = null;
            }
            else if (c == this.previousButton) {
                this.previousButton = null;
            }
        }
        
        @Override
        public Dimension preferredLayoutSize(final Container parent) {
            final Insets insets = parent.getInsets();
            final Insets padding = UIScale.scale(FlatSpinnerUI.this.padding);
            final Dimension editorSize = (this.editor != null) ? this.editor.getPreferredSize() : new Dimension(0, 0);
            final int minimumWidth = FlatUIUtils.minimumWidth(FlatSpinnerUI.this.spinner, FlatSpinnerUI.this.minimumWidth);
            final int innerHeight = editorSize.height + padding.top + padding.bottom;
            final float focusWidth = FlatUIUtils.getBorderFocusWidth(FlatSpinnerUI.this.spinner);
            return new Dimension(Math.max(insets.left + insets.right + editorSize.width + padding.left + padding.right + innerHeight, UIScale.scale(minimumWidth) + Math.round(focusWidth * 2.0f)), insets.top + insets.bottom + innerHeight);
        }
        
        @Override
        public Dimension minimumLayoutSize(final Container parent) {
            return this.preferredLayoutSize(parent);
        }
        
        @Override
        public void layoutContainer(final Container parent) {
            final Dimension size = parent.getSize();
            final Insets insets = parent.getInsets();
            final Rectangle r = FlatUIUtils.subtractInsets(new Rectangle(size), insets);
            if (this.nextButton == null && this.previousButton == null) {
                if (this.editor != null) {
                    this.editor.setBounds(r);
                }
                return;
            }
            final Rectangle editorRect = new Rectangle(r);
            final Rectangle buttonsRect = new Rectangle(r);
            final FontMetrics fm = FlatSpinnerUI.this.spinner.getFontMetrics(FlatSpinnerUI.this.spinner.getFont());
            final int maxButtonWidth = fm.getHeight() + UIScale.scale(FlatSpinnerUI.this.padding.top) + UIScale.scale(FlatSpinnerUI.this.padding.bottom);
            final int minButtonWidth = maxButtonWidth * 3 / 4;
            final boolean isMacStyle = FlatSpinnerUI.this.isMacStyle();
            final int buttonsGap = isMacStyle ? UIScale.scale(3) : 0;
            final int prefButtonWidth = isMacStyle ? UIScale.scale(15) : buttonsRect.height;
            final int buttonsWidth = Math.min(Math.max(prefButtonWidth, minButtonWidth), maxButtonWidth);
            buttonsRect.width = buttonsWidth;
            final Rectangle rectangle = editorRect;
            rectangle.width -= buttonsWidth + buttonsGap;
            final boolean ltr = parent.getComponentOrientation().isLeftToRight();
            if (ltr) {
                final Rectangle rectangle2 = buttonsRect;
                rectangle2.x += editorRect.width + buttonsGap;
            }
            else {
                final Rectangle rectangle3 = editorRect;
                rectangle3.x += buttonsWidth + buttonsGap;
            }
            if (isMacStyle) {
                final int lineWidth = Math.round(FlatUIUtils.getBorderLineWidth(FlatSpinnerUI.this.spinner));
                if (lineWidth > 0) {
                    final Rectangle rectangle4 = buttonsRect;
                    rectangle4.x += (ltr ? lineWidth : (-lineWidth));
                    final Rectangle rectangle5 = buttonsRect;
                    rectangle5.y -= lineWidth;
                    final Rectangle rectangle6 = buttonsRect;
                    rectangle6.height += lineWidth * 2;
                }
            }
            if (this.editor != null) {
                this.editor.setBounds(editorRect);
            }
            final int nextHeight = buttonsRect.height / 2 + buttonsRect.height % 2;
            if (this.nextButton != null) {
                this.nextButton.setBounds(buttonsRect.x, buttonsRect.y, buttonsRect.width, nextHeight);
            }
            if (this.previousButton != null) {
                final int previousY = buttonsRect.y + buttonsRect.height - nextHeight;
                this.previousButton.setBounds(buttonsRect.x, previousY, buttonsRect.width, nextHeight);
            }
        }
        
        @Override
        public void focusGained(final FocusEvent e) {
            FlatSpinnerUI.this.spinner.repaint();
            if (e.getComponent() == FlatSpinnerUI.this.spinner) {
                final JTextField textField = getEditorTextField(FlatSpinnerUI.this.spinner.getEditor());
                if (textField != null) {
                    textField.requestFocusInWindow();
                }
            }
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            FlatSpinnerUI.this.spinner.repaint();
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String propertyName = e.getPropertyName();
            switch (propertyName) {
                case "foreground":
                case "enabled": {
                    FlatSpinnerUI.this.updateEditorColors();
                    break;
                }
                case "JComponent.roundRect":
                case "JComponent.outline": {
                    FlatSpinnerUI.this.spinner.repaint();
                    break;
                }
                case "JComponent.minimumWidth": {
                    FlatSpinnerUI.this.spinner.revalidate();
                    break;
                }
                case "FlatLaf.style":
                case "FlatLaf.styleClass": {
                    FlatSpinnerUI.this.installStyle();
                    FlatSpinnerUI.this.spinner.revalidate();
                    FlatSpinnerUI.this.spinner.repaint();
                    break;
                }
            }
        }
    }
}
