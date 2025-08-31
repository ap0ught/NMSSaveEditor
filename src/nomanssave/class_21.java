package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// $VF: renamed from: nomanssave.r
class class_21 implements ActionListener {
   class_21(class_318 var1) {
      this.field_63 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      int[] var2 = class_318.method_879(this.field_63).getSelectedRows();
      class_318.method_880(this.field_63, new ArrayList());

      for (int var4 = 0; var4 < var2.length; var4++) {
         int var3 = class_318.method_879(this.field_63).convertRowIndexToModel(var2[var4]);
         class_318.method_881(this.field_63).add((String)class_318.method_879(this.field_63).getModel().getValueAt(var3, 3));
      }

      this.field_63.setVisible(false);
   }
}
