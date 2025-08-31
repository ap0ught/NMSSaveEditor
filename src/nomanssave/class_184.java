package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.dF
class class_184 implements ComboBoxModel {
   // $VF: renamed from: hD nomanssave.gE
   private class_77 field_550;

   class_184(class_352 var1) {
      this.field_551 = var1;
      this.field_550 = null;
   }

   @Override
   public int getSize() {
      return class_352.method_1027(this.field_551) == null ? 0 : class_352.method_1027(this.field_551).length;
   }

   // $VF: renamed from: E (int) nomanssave.gE
   public class_77 method_829(int var1) {
      return class_352.method_1027(this.field_551)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_550 = (class_77)var1;
      if (this.field_550 == null) {
         class_352.method_1028(this.field_551).setText("");
         class_352.method_1029(this.field_551).setText("");

         for (int var2 = 0; var2 < class_352.method_1030(this.field_551).length; var2++) {
            class_352.method_1030(this.field_551)[var2].setText("");
         }

         class_352.method_1031(this.field_551).method_1157(new class_76[0]);
      } else {
         class_352.method_1028(this.field_551).setText(this.field_550.getName());
         class_352.method_1029(this.field_551).setText(this.field_550.method_469());

         for (int var3 = 0; var3 < class_352.method_1030(this.field_551).length; var3++) {
            class_352.method_1030(this.field_551)[var3].setText(Integer.toString(this.field_550.method_462(var3)));
         }

         class_352.method_1031(this.field_551).method_1157(this.field_550.method_471());
      }

      class_352.method_1032(this.field_551).revalidate();
   }

   @Override
   public Object getSelectedItem() {
      return this.field_550;
   }
}
