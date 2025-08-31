package com.formdev.flatlaf.ui;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class FlatCheckBoxUI extends FlatRadioButtonUI {
   public static ComponentUI createUI(JComponent c) {
      return (ComponentUI)(FlatUIUtils.canUseSharedUI(c) && !FlatUIUtils.needsLightAWTPeer(c)
         ? FlatUIUtils.createSharedUI(FlatCheckBoxUI.class, () -> new FlatCheckBoxUI(true))
         : new FlatCheckBoxUI(false));
   }

   protected FlatCheckBoxUI(boolean shared) {
      super(shared);
   }

   @Override
   public String getPropertyPrefix() {
      return "CheckBox.";
   }

   @Override
   String getStyleType() {
      return "CheckBox";
   }
}
