package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.JavaCompatibility;
import com.formdev.flatlaf.util.LoggingFacade;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class FlatTextFieldUI extends BasicTextFieldUI implements FlatStylingSupport.StyleableUI {
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

   public static ComponentUI createUI(JComponent c) {
      return new FlatTextFieldUI();
   }

   @Override
   public void installUI(JComponent c) {
      if (FlatUIUtils.needsLightAWTPeer(c)) {
         FlatUIUtils.runWithLightAWTPeerUIDefaults(() -> this.installUIImpl(c));
      } else {
         this.installUIImpl(c);
      }
   }

   private void installUIImpl(JComponent c) {
      super.installUI(c);
      this.leadingIcon = FlatClientProperties.clientProperty(c, "JTextField.leadingIcon", null, Icon.class);
      this.trailingIcon = FlatClientProperties.clientProperty(c, "JTextField.trailingIcon", null, Icon.class);
      this.installLeadingComponent();
      this.installTrailingComponent();
      this.installClearButton();
      this.installStyle();
   }

   @Override
   public void uninstallUI(JComponent c) {
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
      String prefix = this.getPropertyPrefix();
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
   protected void propertyChange(PropertyChangeEvent e) {
      String propertyName = e.getPropertyName();
      if (!"editable".equals(propertyName) && !"enabled".equals(propertyName)) {
         super.propertyChange(e);
      } else {
         this.updateBackground();
      }

      JTextComponent c = this.getComponent();
      String var4 = e.getPropertyName();
      switch (var4) {
         case "JTextField.placeholderText":
         case "JComponent.roundRect":
         case "JComponent.outline":
         case "JTextField.padding":
            c.repaint();
            break;
         case "JComponent.minimumWidth":
            c.revalidate();
            break;
         case "FlatLaf.style":
         case "FlatLaf.styleClass":
            this.installStyle();
            c.revalidate();
            c.repaint();
            break;
         case "JTextField.leadingIcon":
            this.leadingIcon = e.getNewValue() instanceof Icon ? (Icon)e.getNewValue() : null;
            c.repaint();
            break;
         case "JTextField.trailingIcon":
            this.trailingIcon = e.getNewValue() instanceof Icon ? (Icon)e.getNewValue() : null;
            c.repaint();
            break;
         case "JTextField.leadingComponent":
            this.uninstallLeadingComponent();
            this.installLeadingComponent();
            c.revalidate();
            c.repaint();
            break;
         case "JTextField.trailingComponent":
            this.uninstallTrailingComponent();
            this.installTrailingComponent();
            c.revalidate();
            c.repaint();
            break;
         case "JTextField.showClearButton":
            this.uninstallClearButton();
            this.installClearButton();
            c.revalidate();
            c.repaint();
            break;
         case "enabled":
         case "editable":
            this.updateClearButton();
            break;
         case "document":
            if (this.documentListener != null) {
               if (e.getOldValue() instanceof Document) {
                  ((Document)e.getOldValue()).removeDocumentListener(this.documentListener);
               }

               if (e.getNewValue() instanceof Document) {
                  ((Document)e.getNewValue()).addDocumentListener(this.documentListener);
               }

               this.updateClearButton();
            }
      }
   }

   protected void installDocumentListener() {
      if (this.documentListener == null) {
         this.documentListener = new FlatTextFieldUI.FlatDocumentListener();
         this.getComponent().getDocument().addDocumentListener(this.documentListener);
      }
   }

   protected void documentChanged(DocumentEvent e) {
      if (this.clearButton != null) {
         this.updateClearButton();
      }
   }

   protected void installStyle() {
      try {
         this.applyStyle(FlatStylingSupport.getResolvedStyle(this.getComponent(), this.getStyleType()));
      } catch (RuntimeException var2) {
         LoggingFacade.INSTANCE.logSevere(null, var2);
      }
   }

   String getStyleType() {
      return "TextField";
   }

   protected void applyStyle(Object style) {
      this.oldDisabledBackground = this.disabledBackground;
      this.oldInactiveBackground = this.inactiveBackground;
      boolean oldShowClearButton = this.showClearButton;
      this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
      this.updateBackground();
      if (this.showClearButton != oldShowClearButton) {
         this.uninstallClearButton();
         this.installClearButton();
      }
   }

   protected Object applyStyleProperty(String key, Object value) {
      if (this.borderShared == null) {
         this.borderShared = new AtomicBoolean(true);
      }

      return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.getComponent(), this.borderShared);
   }

   @Override
   public Map<String, Class<?>> getStyleableInfos(JComponent c) {
      return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.getComponent().getBorder());
   }

   @Override
   public Object getStyleableValue(JComponent c, String key) {
      return FlatStylingSupport.getAnnotatedStyleableValue(this, this.getComponent().getBorder(), key);
   }

   private void updateBackground() {
      updateBackground(
         this.getComponent(), this.background, this.disabledBackground, this.inactiveBackground, this.oldDisabledBackground, this.oldInactiveBackground
      );
   }

   static void updateBackground(
      JTextComponent c, Color background, Color disabledBackground, Color inactiveBackground, Color oldDisabledBackground, Color oldInactiveBackground
   ) {
      Color oldBackground = c.getBackground();
      if (oldBackground instanceof UIResource) {
         if (oldBackground == background
            || oldBackground == disabledBackground
            || oldBackground == inactiveBackground
            || oldBackground == oldDisabledBackground
            || oldBackground == oldInactiveBackground) {
            Color newBackground = !c.isEnabled() ? disabledBackground : (!c.isEditable() ? inactiveBackground : background);
            if (newBackground != oldBackground) {
               c.setBackground(newBackground);
            }
         }
      }
   }

   @Override
   protected void paintSafely(Graphics g) {
      paintBackground(g, this.getComponent(), this.isIntelliJTheme, this.focusedBackground);
      this.paintPlaceholder(g);
      if (this.hasLeadingIcon() || this.hasTrailingIcon()) {
         this.paintIcons(g, new Rectangle(this.getIconsRect()));
      }

      super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
   }

   @Override
   protected void paintBackground(Graphics g) {
   }

   static void paintBackground(Graphics g, JTextComponent c, boolean isIntelliJTheme, Color focusedBackground) {
      if (c.isOpaque() || FlatUIUtils.getOutsideFlatBorder(c) != null || !FlatUIUtils.hasOpaqueBeenExplicitlySet(c)) {
         float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
         float arc = FlatUIUtils.getBorderArc(c);
         if (c.isOpaque() && (focusWidth > 0.0F || arc > 0.0F)) {
            FlatUIUtils.paintParentBackground(g, c);
         }

         Graphics2D g2 = (Graphics2D)g.create();

         try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(getBackground(c, isIntelliJTheme, focusedBackground));
            FlatUIUtils.paintComponentBackground(g2, 0, 0, c.getWidth(), c.getHeight(), focusWidth, arc);
         } finally {
            g2.dispose();
         }
      }
   }

   static Color getBackground(JTextComponent c, boolean isIntelliJTheme, Color focusedBackground) {
      Color background = c.getBackground();
      if (!(background instanceof UIResource)) {
         return background;
      } else if (focusedBackground != null && FlatUIUtils.isPermanentFocusOwner(c)) {
         return focusedBackground;
      } else {
         return !isIntelliJTheme || c.isEnabled() && c.isEditable() ? background : FlatUIUtils.getParentBackground(c);
      }
   }

   protected void paintPlaceholder(Graphics g) {
      JTextComponent c = this.getComponent();
      if (c.getDocument().getLength() <= 0) {
         Container parent = c.getParent();
         JComponent jc = (JComponent)(parent instanceof JComboBox ? (JComboBox)parent : c);
         String placeholder = FlatClientProperties.clientProperty(jc, "JTextField.placeholderText", null, String.class);
         if (placeholder != null) {
            Rectangle r = this.getVisibleEditorRect();
            FontMetrics fm = c.getFontMetrics(c.getFont());
            String clippedPlaceholder = JavaCompatibility.getClippedString(c, fm, placeholder, r.width);
            int x = r.x + (this.isLeftToRight() ? 0 : r.width - fm.stringWidth(clippedPlaceholder));
            int y = r.y + fm.getAscent() + (r.height - fm.getHeight()) / 2;
            g.setColor(this.placeholderForeground);
            FlatUIUtils.drawString(c, g, clippedPlaceholder, x, y);
         }
      }
   }

   protected void paintIcons(Graphics g, Rectangle r) {
      boolean ltr = this.isLeftToRight();
      Icon leftIcon = ltr ? this.leadingIcon : this.trailingIcon;
      Icon rightIcon = ltr ? this.trailingIcon : this.leadingIcon;
      if (leftIcon != null) {
         int x = r.x;
         int y = r.y + Math.round((float)(r.height - leftIcon.getIconHeight()) / 2.0F);
         leftIcon.paintIcon(this.getComponent(), g, x, y);
         int w = leftIcon.getIconWidth() + UIScale.scale(this.iconTextGap);
         r.x += w;
         r.width -= w;
      }

      if (rightIcon != null) {
         int iconWidth = rightIcon.getIconWidth();
         int x = r.x + r.width - iconWidth;
         int y = r.y + Math.round((float)(r.height - rightIcon.getIconHeight()) / 2.0F);
         rightIcon.paintIcon(this.getComponent(), g, x, y);
         r.width = r.width - (iconWidth + UIScale.scale(this.iconTextGap));
      }
   }

   @Override
   public Dimension getPreferredSize(JComponent c) {
      return this.applyMinimumWidth(c, this.applyExtraSize(super.getPreferredSize(c)), this.minimumWidth);
   }

   @Override
   public Dimension getMinimumSize(JComponent c) {
      return this.applyMinimumWidth(c, this.applyExtraSize(super.getMinimumSize(c)), this.minimumWidth);
   }

   private Dimension applyExtraSize(Dimension size) {
      size.width = size.width + this.getLeadingIconWidth() + this.getTrailingIconWidth();

      for (JComponent comp : this.getLeadingComponents()) {
         if (comp != null && comp.isVisible()) {
            size.width = size.width + comp.getPreferredSize().width;
         }
      }

      for (JComponent compx : this.getTrailingComponents()) {
         if (compx != null && compx.isVisible()) {
            size.width = size.width + compx.getPreferredSize().width;
         }
      }

      return size;
   }

   private Dimension applyMinimumWidth(JComponent c, Dimension size, int minimumWidth) {
      if (c instanceof JTextField && ((JTextField)c).getColumns() > 0) {
         return size;
      } else if (!hasDefaultMargins(c, this.defaultMargin)) {
         return size;
      } else {
         Container parent = c.getParent();
         if (!(parent instanceof JComboBox) && !(parent instanceof JSpinner) && (parent == null || !(parent.getParent() instanceof JSpinner))) {
            minimumWidth = FlatUIUtils.minimumWidth(c, minimumWidth);
            float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
            size.width = Math.max(size.width, UIScale.scale(minimumWidth) + Math.round(focusWidth * 2.0F));
            return size;
         } else {
            return size;
         }
      }
   }

   static boolean hasDefaultMargins(JComponent c, Insets defaultMargin) {
      Insets margin = ((JTextComponent)c).getMargin();
      return margin instanceof UIResource && Objects.equals(margin, defaultMargin);
   }

   @Override
   protected Rectangle getVisibleEditorRect() {
      Rectangle r = this.getIconsRect();
      if (r == null) {
         return null;
      } else {
         int leading = this.getLeadingIconWidth();
         int trailing = this.getTrailingIconWidth();
         if (leading != 0 || trailing != 0) {
            boolean ltr = this.isLeftToRight();
            int left = ltr ? leading : trailing;
            int right = ltr ? trailing : leading;
            r.x += left;
            r.width -= left + right;
         }

         Insets padding = this.getPadding();
         if (padding != null) {
            r = FlatUIUtils.subtractInsets(r, padding);
         }

         r.width = Math.max(r.width, 0);
         r.height = Math.max(r.height, 0);
         return r;
      }
   }

   protected Rectangle getIconsRect() {
      Rectangle r = super.getVisibleEditorRect();
      if (r == null) {
         return null;
      } else {
         boolean ltr = this.isLeftToRight();
         JComponent[] leftComponents = ltr ? this.getLeadingComponents() : this.getTrailingComponents();
         JComponent[] rightComponents = ltr ? this.getTrailingComponents() : this.getLeadingComponents();
         boolean leftVisible = false;
         boolean rightVisible = false;

         for (JComponent leftComponent : leftComponents) {
            if (leftComponent != null && leftComponent.isVisible()) {
               int w = leftComponent.getPreferredSize().width;
               r.x += w;
               r.width -= w;
               leftVisible = true;
            }
         }

         for (JComponent rightComponent : rightComponents) {
            if (rightComponent != null && rightComponent.isVisible()) {
               r.width = r.width - rightComponent.getPreferredSize().width;
               rightVisible = true;
            }
         }

         if (leftVisible || (ltr ? this.hasLeadingIcon() : this.hasTrailingIcon())) {
            Insets margin = this.getComponent().getMargin();
            int newLeftMargin = Math.min(margin.left, margin.top);
            if (newLeftMargin < margin.left) {
               int diff = UIScale.scale(margin.left - newLeftMargin);
               r.x -= diff;
               r.width += diff;
            }
         }

         if (rightVisible || (ltr ? this.hasTrailingIcon() : this.hasLeadingIcon())) {
            Insets margin = this.getComponent().getMargin();
            int newRightMargin = Math.min(margin.right, margin.top);
            if (newRightMargin < margin.left) {
               r.width = r.width + UIScale.scale(margin.right - newRightMargin);
            }
         }

         r.width = Math.max(r.width, 0);
         r.height = Math.max(r.height, 0);
         return r;
      }
   }

   protected boolean hasLeadingIcon() {
      return this.leadingIcon != null;
   }

   protected boolean hasTrailingIcon() {
      return this.trailingIcon != null;
   }

   protected int getLeadingIconWidth() {
      return this.leadingIcon != null ? this.leadingIcon.getIconWidth() + UIScale.scale(this.iconTextGap) : 0;
   }

   protected int getTrailingIconWidth() {
      return this.trailingIcon != null ? this.trailingIcon.getIconWidth() + UIScale.scale(this.iconTextGap) : 0;
   }

   boolean isLeftToRight() {
      return this.getComponent().getComponentOrientation().isLeftToRight();
   }

   protected Insets getPadding() {
      return UIScale.scale(FlatClientProperties.clientProperty(this.getComponent(), "JTextField.padding", null, Insets.class));
   }

   protected void scrollCaretToVisible() {
      Caret caret = this.getComponent().getCaret();
      if (caret instanceof FlatCaret) {
         ((FlatCaret)caret).scrollCaretToVisible();
      }
   }

   protected void installLeadingComponent() {
      JTextComponent c = this.getComponent();
      this.leadingComponent = FlatClientProperties.clientProperty(c, "JTextField.leadingComponent", null, JComponent.class);
      if (this.leadingComponent != null) {
         this.prepareLeadingOrTrailingComponent(this.leadingComponent);
         this.installLayout();
         c.add(this.leadingComponent);
      }
   }

   protected void installTrailingComponent() {
      JTextComponent c = this.getComponent();
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
      JTextComponent c = this.getComponent();
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
      JButton button = new JButton();
      button.setName("TextField.clearButton");
      button.putClientProperty("FlatLaf.styleClass", "clearButton");
      button.putClientProperty("JButton.buttonType", "toolBarButton");
      button.setCursor(Cursor.getDefaultCursor());
      button.addActionListener(e -> this.clearButtonClicked());
      return button;
   }

   protected void clearButtonClicked() {
      JTextComponent c = this.getComponent();
      Object callback = c.getClientProperty("JTextField.clearCallback");
      if (callback instanceof Runnable) {
         ((Runnable)callback).run();
      } else if (callback instanceof Consumer) {
         ((Consumer)callback).accept(c);
      } else {
         c.setText("");
      }
   }

   protected void updateClearButton() {
      if (this.clearButton != null) {
         JTextComponent c = this.getComponent();
         boolean visible = c.isEnabled() && c.isEditable() && c.getDocument().getLength() > 0;
         if (visible != this.clearButton.isVisible()) {
            this.clearButton.setVisible(visible);
            c.revalidate();
            c.repaint();
         }
      }
   }

   protected JComponent[] getLeadingComponents() {
      return new JComponent[]{this.leadingComponent};
   }

   protected JComponent[] getTrailingComponents() {
      return new JComponent[]{this.trailingComponent, this.clearButton};
   }

   protected void prepareLeadingOrTrailingComponent(JComponent c) {
      c.putClientProperty("FlatLaf.styleClass", "inTextField");
      if (c instanceof JButton || c instanceof JToggleButton) {
         c.putClientProperty("JButton.buttonType", "toolBarButton");
         if (!c.isCursorSet()) {
            c.setCursor(Cursor.getDefaultCursor());
         }
      } else if (c instanceof JToolBar) {
         for (Component child : c.getComponents()) {
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
      JTextComponent c = this.getComponent();
      LayoutManager oldLayout = c.getLayout();
      if (!(oldLayout instanceof FlatTextFieldUI.FlatTextFieldLayout)) {
         c.setLayout(new FlatTextFieldUI.FlatTextFieldLayout(oldLayout));
      }
   }

   private class FlatDocumentListener implements DocumentListener {
      private FlatDocumentListener() {
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
         FlatTextFieldUI.this.documentChanged(e);
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
         FlatTextFieldUI.this.documentChanged(e);
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
         FlatTextFieldUI.this.documentChanged(e);
      }
   }

   private class FlatTextFieldLayout implements LayoutManager2, UIResource {
      private final LayoutManager delegate;

      FlatTextFieldLayout(LayoutManager delegate) {
         this.delegate = delegate;
      }

      @Override
      public void addLayoutComponent(String name, Component comp) {
         if (this.delegate != null) {
            this.delegate.addLayoutComponent(name, comp);
         }
      }

      @Override
      public void removeLayoutComponent(Component comp) {
         if (this.delegate != null) {
            this.delegate.removeLayoutComponent(comp);
         }
      }

      @Override
      public Dimension preferredLayoutSize(Container parent) {
         return this.delegate != null ? this.delegate.preferredLayoutSize(parent) : null;
      }

      @Override
      public Dimension minimumLayoutSize(Container parent) {
         return this.delegate != null ? this.delegate.minimumLayoutSize(parent) : null;
      }

      @Override
      public void layoutContainer(Container parent) {
         if (this.delegate != null) {
            this.delegate.layoutContainer(parent);
         }

         int ow = FlatUIUtils.getBorderFocusAndLineWidth(FlatTextFieldUI.this.getComponent());
         int h = parent.getHeight() - ow - ow;
         boolean ltr = FlatTextFieldUI.this.isLeftToRight();
         JComponent[] leftComponents = ltr ? FlatTextFieldUI.this.getLeadingComponents() : FlatTextFieldUI.this.getTrailingComponents();
         JComponent[] rightComponents = ltr ? FlatTextFieldUI.this.getTrailingComponents() : FlatTextFieldUI.this.getLeadingComponents();
         int x = ow;

         for (JComponent leftComponent : leftComponents) {
            if (leftComponent != null && leftComponent.isVisible()) {
               int cw = leftComponent.getPreferredSize().width;
               leftComponent.setBounds(x, ow, cw, h);
               x += cw;
            }
         }

         x = parent.getWidth() - ow;

         for (JComponent rightComponent : rightComponents) {
            if (rightComponent != null && rightComponent.isVisible()) {
               int cw = rightComponent.getPreferredSize().width;
               x -= cw;
               rightComponent.setBounds(x, ow, cw, h);
            }
         }
      }

      @Override
      public void addLayoutComponent(Component comp, Object constraints) {
         if (this.delegate instanceof LayoutManager2) {
            ((LayoutManager2)this.delegate).addLayoutComponent(comp, constraints);
         }
      }

      @Override
      public Dimension maximumLayoutSize(Container target) {
         return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).maximumLayoutSize(target) : null;
      }

      @Override
      public float getLayoutAlignmentX(Container target) {
         return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).getLayoutAlignmentX(target) : 0.5F;
      }

      @Override
      public float getLayoutAlignmentY(Container target) {
         return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).getLayoutAlignmentY(target) : 0.5F;
      }

      @Override
      public void invalidateLayout(Container target) {
         if (this.delegate instanceof LayoutManager2) {
            ((LayoutManager2)this.delegate).invalidateLayout(target);
         }
      }
   }
}
