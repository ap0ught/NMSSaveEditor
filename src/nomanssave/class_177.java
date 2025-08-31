package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $VF: renamed from: nomanssave.dV
class class_177 implements ActionListener {
   class_177(class_369 var1, Application var2) {
      this.field_536 = var1;
      this.field_537 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_75 var2 = (class_75)class_369.method_1265(this.field_536).getSelectedItem();
      if (var2 != null) {
         class_142 var3 = this.field_537.method_1364("PlayerStateData.ShipUsesLegacyColours");
         if (var3 != null) {
            if (class_369.method_1255(this.field_536).isSelected() ^ var3.method_742(var2.getIndex())) {
               var3.method_743(var2.getIndex(), class_369.method_1255(this.field_536).isSelected());
            }
         }
      }
   }
}
