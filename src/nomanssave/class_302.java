package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

// $VF: renamed from: nomanssave.aF
class class_302 implements ActionListener {
   class_302(class_328 var1) {
      this.field_977 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = class_300.getProperty("LookAndFeel");
      class_299 var3 = Stream.of(class_299.values()).filter(aF::a).findFirst().orElse(class_299.field_957);
      class_299 var4 = (class_299)class_328.method_971(this.field_977).getSelectedItem();
      class_328.method_972(this.field_977, false);
      if (var4 == null) {
         if (var3 != null) {
            class_300.setProperty("LookAndFeel", null);
            class_328.method_972(this.field_977, true);
         }
      } else if (var3 == null || var3 != var4) {
         class_300.setProperty("LookAndFeel", var4.name());
         class_328.method_972(this.field_977, true);
      }

      double var5 = Double.parseDouble(class_328.method_973(this.field_977).getText());
      if (var5 != class_300.method_861("InventoryScaling", 1.0)) {
         class_300.method_862("InventoryScaling", var5);
         class_328.method_972(this.field_977, true);
      }

      this.field_977.setVisible(false);
   }
}
