package nomanssave;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

// $VF: renamed from: nomanssave.cN
public class class_333 extends JComboBox {
   // $VF: renamed from: gm boolean
   private final boolean field_1103;
   // $VF: renamed from: gn java.lang.Enum[]
   private final Enum[] field_1104;
   // $VF: renamed from: go java.util.List
   private final List field_1105;
   // $VF: renamed from: gp nomanssave.cR
   private class_1 field_1106;
   // $VF: renamed from: gq java.lang.Object
   private Object field_1107;
   // $VF: renamed from: gr java.awt.Color
   private static final Color field_1108 = Color.RED;
   // $VF: renamed from: gs java.awt.Color
   private static final Color field_1109 = new Color(255, 100, 100);

   public class_333(Class var1) {
      this.field_1103 = gD.class.isAssignableFrom(var1);
      this.field_1104 = (Enum[])var1.getEnumConstants();
      this.field_1105 = new ArrayList();
      this.setModel(new class_200(this, var1));
      this.setRenderer(new class_345(this));
   }

   // $VF: renamed from: m (java.lang.String) void
   public void method_985(String var1) {
      Object var2 = null;
      if (var1 != null) {
         for (Enum var3 : this.field_1104) {
            if (this.field_1103) {
               if (((class_11)var3).method_39().equals(var1)) {
                  var2 = var3;
                  break;
               }
            } else if (var3.name().equals(var1)) {
               var2 = var3;
               break;
            }
         }

         if (var2 == null) {
            int var7 = this.field_1105.indexOf(new class_199(this, var1));
            if (var7 >= 0) {
               var2 = this.field_1105.get(var7);
            } else {
               var2 = this.field_1103 ? new class_198(this, var1) : var1;
               this.field_1105.add(var2);
            }
         }
      }

      this.field_1107 = var2;
      this.selectedItemChanged();
      this.updateUI();
   }

   // $VF: renamed from: a (nomanssave.cR) void
   public void method_986(class_1 var1) {
      this.field_1106 = var1;
   }
}
