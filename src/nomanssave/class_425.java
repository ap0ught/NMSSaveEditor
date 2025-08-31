package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.D
class class_425 implements ComboBoxModel {
   class_425(Application var1) {
      this.field_1419 = var1;
   }

   @Override
   public int getSize() {
      return Application.method_1381(this.field_1419).length;
   }

   // $VF: renamed from: m (int) nomanssave.ft
   public class_10 method_1319(int var1) {
      return Application.method_1381(this.field_1419)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      if (Application.method_1390(this.field_1419)) {
         Application.method_1396(this.field_1419).hidePopup();
         int var2 = JOptionPane.showConfirmDialog(Application.method_1388(this.field_1419), "Save data before switching slots?", "Save", 1);
         if (var2 == 0) {
            Application.method_1392(this.field_1419);
         } else {
            if (var2 == 2) {
               return;
            }

            Application.method_1397(this.field_1419, false);
         }
      }

      int var6 = -1;
      synchronized (Application.method_1396(this.field_1419)) {
         for (int var4 = 0; var4 < Application.method_1381(this.field_1419).length; var4++) {
            if (Application.method_1381(this.field_1419)[var4] == var1) {
               var6 = var4;
               break;
            }
         }
      }

      Application.method_1398(this.field_1419, var6);
   }

   @Override
   public Object getSelectedItem() {
      return Application.method_1380(this.field_1419) < 0 ? null : Application.method_1381(this.field_1419)[Application.method_1380(this.field_1419)];
   }
}
