package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.ComponentFactory;
import com.jgoodies.forms.factories.ComponentFactory2;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Color;
import java.awt.Component;
import java.lang.ref.WeakReference;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class PanelBuilder extends AbstractFormBuilder {
   private static final String LABELED_BY_PROPERTY = "labeledBy";
   private static boolean labelForFeatureEnabledDefault = false;
   private ComponentFactory componentFactory;
   private boolean labelForFeatureEnabled;
   private WeakReference mostRecentlyAddedLabelReference = null;

   public PanelBuilder(FormLayout layout) {
      this(layout, new JPanel(null));
   }

   public PanelBuilder(FormLayout layout, JPanel panel) {
      super(layout, panel);
      this.labelForFeatureEnabled = labelForFeatureEnabledDefault;
   }

   public static boolean getLabelForFeatureEnabledDefault() {
      return labelForFeatureEnabledDefault;
   }

   public static void setLabelForFeatureEnabledDefault(boolean b) {
      labelForFeatureEnabledDefault = b;
   }

   public boolean isLabelForFeatureEnabled() {
      return this.labelForFeatureEnabled;
   }

   public void setLabelForFeatureEnabled(boolean b) {
      this.labelForFeatureEnabled = b;
   }

   public final JPanel getPanel() {
      return (JPanel)this.getContainer();
   }

   public final void setBackground(Color background) {
      this.getPanel().setBackground(background);
   }

   public final void setBorder(Border border) {
      this.getPanel().setBorder(border);
   }

   public final void setDefaultDialogBorder() {
      this.setBorder(Borders.DIALOG_BORDER);
   }

   public final void setOpaque(boolean b) {
      this.getPanel().setOpaque(b);
   }

   public final JLabel addLabel(String textWithMnemonic) {
      return this.addLabel(textWithMnemonic, this.cellConstraints());
   }

   public final JLabel addLabel(String textWithMnemonic, CellConstraints constraints) {
      JLabel label = this.getComponentFactory().createLabel(textWithMnemonic);
      this.method_87(label, constraints);
      return label;
   }

   public final JLabel addLabel(String textWithMnemonic, String encodedConstraints) {
      return this.addLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
   }

   public final JLabel addLabel(String textWithMnemonic, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints) {
      if (labelConstraints == componentConstraints) {
         throw new IllegalArgumentException(
            "You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details."
         );
      } else {
         JLabel label = this.addLabel(textWithMnemonic, labelConstraints);
         this.method_87(component, componentConstraints);
         label.setLabelFor(component);
         return label;
      }
   }

   public final JLabel addROLabel(String textWithMnemonic) {
      return this.addROLabel(textWithMnemonic, this.cellConstraints());
   }

   public final JLabel addROLabel(String textWithMnemonic, CellConstraints constraints) {
      ComponentFactory factory = this.getComponentFactory();
      ComponentFactory2 factory2;
      if (factory instanceof ComponentFactory2) {
         factory2 = (ComponentFactory2)factory;
      } else {
         factory2 = DefaultComponentFactory.getInstance();
      }

      JLabel label = factory2.createReadOnlyLabel(textWithMnemonic);
      this.method_87(label, constraints);
      return label;
   }

   public final JLabel addROLabel(String textWithMnemonic, String encodedConstraints) {
      return this.addROLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
   }

   public final JLabel addROLabel(String textWithMnemonic, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints) {
      if (labelConstraints == componentConstraints) {
         throw new IllegalArgumentException(
            "You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details."
         );
      } else {
         JLabel label = this.addROLabel(textWithMnemonic, labelConstraints);
         this.method_87(component, componentConstraints);
         label.setLabelFor(component);
         return label;
      }
   }

   public final JLabel addTitle(String textWithMnemonic) {
      return this.addTitle(textWithMnemonic, this.cellConstraints());
   }

   public final JLabel addTitle(String textWithMnemonic, CellConstraints constraints) {
      JLabel titleLabel = this.getComponentFactory().createTitle(textWithMnemonic);
      this.method_87(titleLabel, constraints);
      return titleLabel;
   }

   public final JLabel addTitle(String textWithMnemonic, String encodedConstraints) {
      return this.addTitle(textWithMnemonic, new CellConstraints(encodedConstraints));
   }

   public final JComponent addSeparator(String textWithMnemonic) {
      return this.addSeparator(textWithMnemonic, this.getLayout().getColumnCount());
   }

   public final JComponent addSeparator(String textWithMnemonic, CellConstraints constraints) {
      int titleAlignment = this.isLeftToRight() ? 2 : 4;
      JComponent titledSeparator = this.getComponentFactory().createSeparator(textWithMnemonic, titleAlignment);
      this.method_87(titledSeparator, constraints);
      return titledSeparator;
   }

   public final JComponent addSeparator(String textWithMnemonic, String encodedConstraints) {
      return this.addSeparator(textWithMnemonic, new CellConstraints(encodedConstraints));
   }

   public final JComponent addSeparator(String textWithMnemonic, int columnSpan) {
      return this.addSeparator(textWithMnemonic, this.createLeftAdjustedConstraints(columnSpan));
   }

   // $VF: renamed from: add (javax.swing.JLabel, com.jgoodies.forms.layout.CellConstraints, java.awt.Component, com.jgoodies.forms.layout.CellConstraints) javax.swing.JLabel
   public final JLabel method_90(JLabel label, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints) {
      if (labelConstraints == componentConstraints) {
         throw new IllegalArgumentException(
            "You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details."
         );
      } else {
         this.method_87(label, labelConstraints);
         this.method_87(component, componentConstraints);
         label.setLabelFor(component);
         return label;
      }
   }

   public final ComponentFactory getComponentFactory() {
      if (this.componentFactory == null) {
         this.componentFactory = DefaultComponentFactory.getInstance();
      }

      return this.componentFactory;
   }

   public final void setComponentFactory(ComponentFactory newFactory) {
      this.componentFactory = newFactory;
   }

   // $VF: renamed from: add (java.awt.Component, com.jgoodies.forms.layout.CellConstraints) java.awt.Component
   public Component method_87(Component component, CellConstraints cellConstraints) {
      Component result = super.method_87(component, cellConstraints);
      if (!this.isLabelForFeatureEnabled()) {
         return result;
      } else {
         JLabel mostRecentlyAddedLabel = this.getMostRecentlyAddedLabel();
         if (mostRecentlyAddedLabel != null && this.isLabelForApplicable(mostRecentlyAddedLabel, component)) {
            this.setLabelFor(mostRecentlyAddedLabel, component);
            this.clearMostRecentlyAddedLabel();
         }

         if (component instanceof JLabel) {
            this.setMostRecentlyAddedLabel((JLabel)component);
         }

         return result;
      }
   }

   protected boolean isLabelForApplicable(JLabel label, Component component) {
      if (label.getLabelFor() != null) {
         return false;
      } else if (!component.isFocusable()) {
         return false;
      } else if (!(component instanceof JComponent)) {
         return true;
      } else {
         JComponent c = (JComponent)component;
         return c.getClientProperty("labeledBy") == null;
      }
   }

   protected void setLabelFor(JLabel label, Component component) {
      Component labeledComponent;
      if (component instanceof JScrollPane) {
         JScrollPane scrollPane = (JScrollPane)component;
         labeledComponent = scrollPane.getViewport().getView();
      } else {
         labeledComponent = component;
      }

      label.setLabelFor(labeledComponent);
   }

   private JLabel getMostRecentlyAddedLabel() {
      if (this.mostRecentlyAddedLabelReference == null) {
         return null;
      } else {
         JLabel label = (JLabel)this.mostRecentlyAddedLabelReference.get();
         return label == null ? null : label;
      }
   }

   private void setMostRecentlyAddedLabel(JLabel label) {
      this.mostRecentlyAddedLabelReference = new WeakReference<>(label);
   }

   private void clearMostRecentlyAddedLabel() {
      this.mostRecentlyAddedLabelReference = null;
   }
}
