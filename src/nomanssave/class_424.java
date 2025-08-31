package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.E
class class_424 implements ComboBoxModel {
   class_424(Application var1) {
      this.field_1418 = var1;
   }

   @Override
   public int getSize() {
      return Application.method_1384(this.field_1418).length;
   }

   // $VF: renamed from: n (int) nomanssave.fs
   public class_9 method_1318(int var1) {
      return Application.method_1384(this.field_1418)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      if (Application.method_1390(this.field_1418)) {
         Application.method_1399(this.field_1418).hidePopup();
         int var2 = JOptionPane.showConfirmDialog(
            Application.method_1388(this.field_1418), "Are you sure you want to load a different file and lose current changes?", "Save", 2
         );
         if (var2 != 0) {
            return;
         }

         Application.method_1397(this.field_1418, false);
      }

      int var7 = -1;
      synchronized (Application.method_1396(this.field_1418)) {
         int var4 = 0;

         for (int var5 = 0; var5 < Application.method_1384(this.field_1418).length; var5++) {
            if (Application.method_1384(this.field_1418)[var5] == var1) {
               var7 = var4;
               Application.method_1384(this.field_1418)[var4++] = Application.method_1384(this.field_1418)[var5];
            } else if (!(Application.method_1384(this.field_1418)[var5] instanceof class_423)) {
               Application.method_1384(this.field_1418)[var4++] = Application.method_1384(this.field_1418)[var5];
            }
         }

         if (var4 < Application.method_1384(this.field_1418).length) {
            class_9[] var8 = new class_9[var4];
            System.arraycopy(Application.method_1384(this.field_1418), 0, var8, 0, var4);
            Application.method_1400(this.field_1418, var8);
         }
      }

      Application.method_1401(this.field_1418, var7);
   }

   @Override
   public Object getSelectedItem() {
      return Application.method_1383(this.field_1418) < 0 ? null : Application.method_1384(this.field_1418)[Application.method_1383(this.field_1418)];
   }
}
