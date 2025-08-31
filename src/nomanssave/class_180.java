package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.dQ
class class_180 implements ActionListener {
   class_180(class_369 var1, Application var2) {
      this.field_542 = var1;
      this.field_543 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int var2 = class_369.method_1265(this.field_542).getSelectedIndex();
      if (var2 >= 0 && var2 < class_369.method_1250(this.field_542).length) {
         if (class_369.method_1250(this.field_542).length == 1) {
            this.field_543.method_1342("You cannot delete the only ship you have!");
         } else if (JOptionPane.showConfirmDialog(
               this.field_542, "Are you sure you want to delete this ship?\nAll items and technology in the ship inventory will be lost!", "Delete", 2
            )
            == 0) {
            this.field_543.method_1369(class_369.method_1250(this.field_542)[var2].getIndex());
         }
      }
   }
}
