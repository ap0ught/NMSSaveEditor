package com.formdev.flatlaf.ui;

import java.awt.Component;
import javax.swing.UIManager;

public class FlatTextBorder extends FlatBorder {
   // $VF: renamed from: arc int
   @FlatStylingSupport.Styleable
   protected int field_50 = UIManager.getInt("TextComponent.arc");
   @FlatStylingSupport.Styleable
   protected Boolean roundRect;

   @Override
   protected int getArc(Component c) {
      if (this.isCellEditor(c)) {
         return 0;
      } else {
         Boolean roundRect = FlatUIUtils.isRoundRect(c);
         if (roundRect == null) {
            roundRect = this.roundRect;
         }

         return roundRect != null ? (roundRect ? 32767 : 0) : this.field_50;
      }
   }
}
