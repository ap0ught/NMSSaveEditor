package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.bT
class class_243 implements ActionListener {
   class_243(class_356 var1, int var2, int var3) {
      this.field_644 = var1;
      this.field_645 = var2;
      this.field_646 = var3;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (class_357.method_1114(class_356.method_1100(this.field_644)).method_411() || class_130.method_681()) {
         if (class_356.method_1092(this.field_644).isSelected()) {
            class_357.method_1114(class_356.method_1100(this.field_644)).method_408(this.field_645, this.field_646);
         } else {
            if (class_357.method_1114(class_356.method_1100(this.field_644)).method_399(this.field_645, this.field_646) != null) {
               class_356.method_1092(this.field_644).setSelected(true);
               class_357.method_1115(class_356.method_1100(this.field_644)).method_1342("Cannot disable slots that are in use!");
               return;
            }

            class_357.method_1114(class_356.method_1100(this.field_644)).method_409(this.field_645, this.field_646);
         }

         class_356.method_1093(this.field_644);
      }
   }
}
