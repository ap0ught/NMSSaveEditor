package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.Y
class class_305 implements ComboBoxModel {
   // $VF: renamed from: bU nomanssave.gj
   private class_45 field_982;

   class_305(class_364 var1) {
      this.field_983 = var1;
      this.field_982 = null;
   }

   @Override
   public int getSize() {
      return class_364.method_1188(this.field_983) == null ? 0 : class_364.method_1188(this.field_983).length;
   }

   // $VF: renamed from: q (int) nomanssave.gj
   public class_45 method_872(int var1) {
      return class_364.method_1188(this.field_983)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_982 = (class_45)var1;
      if (this.field_982 == null) {
         class_364.method_1189(this.field_983).setSelectedIndex(-1);
         class_364.method_1190(this.field_983).setText("");
         class_364.method_1190(this.field_983).setEnabled(false);
         class_364.method_1191(this.field_983).setText("");
         class_364.method_1191(this.field_983).setEnabled(false);
         class_364.method_1192(this.field_983).setText("");
         class_364.method_1192(this.field_983).setEnabled(false);
         class_364.method_1193(this.field_983).setText("");
         class_364.method_1193(this.field_983).setEnabled(false);
         class_364.method_1194(this.field_983).setText("");
         class_364.method_1194(this.field_983).setEnabled(false);
         class_364.method_1195(this.field_983).setSelected(false);
         class_364.method_1195(this.field_983).setEnabled(false);
         class_364.method_1196(this.field_983).setSelectedIndex(-1);
         class_364.method_1196(this.field_983).setEnabled(false);
         class_364.method_1197(this.field_983).setSelectedIndex(-1);
         class_364.method_1197(this.field_983).setEnabled(false);
      } else {
         class_364.method_1189(this.field_983).setSelectedIndex(this.field_982.method_277().ordinal());
         class_364.method_1190(this.field_983).setText(this.field_982.getName());
         class_364.method_1190(this.field_983).setEnabled(true);
         class_364.method_1191(this.field_983).setText(this.field_982.method_279());
         class_364.method_1191(this.field_983).setEnabled(true);
         class_364.method_1192(this.field_983).setText(this.field_982.method_281());
         class_364.method_1192(this.field_983).setEnabled(true);
         class_364.method_1193(this.field_983).setText(this.field_982.method_283());
         class_364.method_1193(this.field_983).setEnabled(true);
         class_364.method_1194(this.field_983).setText(this.field_982.method_285());
         class_364.method_1194(this.field_983).setEnabled(true);
         class_364.method_1195(this.field_983).setSelected(this.field_982.method_287());
         class_364.method_1195(this.field_983).setEnabled(true);
         class_364.method_1196(this.field_983).method_985(this.field_982.method_289());
         class_364.method_1196(this.field_983).setEnabled(true);
         class_364.method_1197(this.field_983).method_985(this.field_982.method_291());
         class_364.method_1197(this.field_983).setEnabled(true);
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_982;
   }
}
