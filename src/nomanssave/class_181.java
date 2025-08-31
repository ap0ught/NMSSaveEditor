package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.dO
class class_181 implements ComboBoxModel {
   // $VF: renamed from: hZ nomanssave.gH
   private class_75 field_544;

   class_181(class_369 var1, Application var2) {
      this.field_545 = var1;
      this.field_546 = var2;
      this.field_544 = null;
   }

   @Override
   public int getSize() {
      return class_369.method_1250(this.field_545) == null ? 0 : class_369.method_1250(this.field_545).length;
   }

   // $VF: renamed from: G (int) nomanssave.gH
   public class_75 method_827(int var1) {
      return class_369.method_1250(this.field_545)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.field_544 = (class_75)var1;
      if (this.field_544 == null) {
         class_369.method_1251(this.field_545).setText("");
         class_369.method_1252(this.field_545).setSelectedIndex(-1);
         class_369.method_1253(this.field_545).setSelectedIndex(-1);
         class_369.method_1254(this.field_545).setText("");
         class_369.method_1255(this.field_545).setSelected(false);
         class_369.method_1255(this.field_545).setEnabled(false);
         class_369.method_1256(this.field_545).setEnabled(false);
         class_369.method_1257(this.field_545).setText("");
         class_369.method_1258(this.field_545).setText("");
         class_369.method_1259(this.field_545).setText("");
         class_369.method_1260(this.field_545).setText("");
         class_369.method_1261(this.field_545).method_1109(Collections.emptyList());
      } else {
         class_369.method_1251(this.field_545).setText(this.field_544.getName());
         class_369.method_1252(this.field_545).method_985(this.field_544.method_437());
         class_369.method_1253(this.field_545).method_985(this.field_544.method_442());
         class_369.method_1254(this.field_545).setText(this.field_544.method_439());
         class_142 var2 = this.field_546.method_1364("PlayerStateData.ShipUsesLegacyColours");
         class_369.method_1255(this.field_545).setSelected(var2 != null && var2.method_742(this.field_544.getIndex()));
         class_369.method_1255(this.field_545).setEnabled(true);
         class_369.method_1256(this.field_545).setEnabled(true);
         class_369.method_1257(this.field_545).setText(Double.toString(this.field_544.method_448()));
         class_369.method_1258(this.field_545).setText(Double.toString(this.field_544.method_450()));
         class_369.method_1259(this.field_545).setText(Double.toString(this.field_544.method_452()));
         class_369.method_1260(this.field_545).setText(Double.toString(this.field_544.method_454()));
         class_369.method_1261(this.field_545).method_1109(this.field_544.method_444());
         class_369.method_1262(this.field_545).setEnabled(false);
         class_369.method_1263(this.field_545).setEnabled(false);
         if (class_369.method_1264(this.field_545) != null) {
            for (int var3 = 0; var3 < class_369.method_1250(this.field_545).length; var3++) {
               if (this.field_544 == class_369.method_1250(this.field_545)[var3] && var3 == class_369.method_1264(this.field_545).method_475()) {
                  class_369.method_1262(this.field_545).setEnabled(true);
                  class_369.method_1263(this.field_545).setEnabled(true);
               }
            }
         }
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.field_544;
   }
}
