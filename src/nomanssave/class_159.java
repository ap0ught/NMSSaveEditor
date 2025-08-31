package nomanssave;

import java.util.ArrayList;

// $VF: renamed from: nomanssave.eE
class class_159 extends ArrayList {
   private class_159() {
   }

   // $VF: renamed from: add (java.lang.String, java.lang.String) boolean
   public boolean method_809(String var1, String var2) {
      return this.add(new class_157(var1, var2));
   }

   // $VF: renamed from: s (java.lang.String) boolean
   public boolean method_810(String var1) {
      if (this.size() == 0) {
         return false;
      } else {
         class_157 var2 = (class_157)this.get(0);
         return var2.field_508.equals(var1) || var2.name.equals(var1);
      }
   }

   // $VF: renamed from: t (java.lang.String) nomanssave.eF
   public class_157 method_811(String var1) {
      for (class_157 var2 : this) {
         if (var2.field_508.equals(var1)) {
            return var2;
         }
      }

      return null;
   }

   // $VF: renamed from: u (java.lang.String) nomanssave.eF
   public class_157 method_812(String var1) {
      for (class_157 var2 : this) {
         if (var2.name.equals(var1)) {
            return var2;
         }
      }

      return null;
   }

   // $VF: renamed from: v (java.lang.String) nomanssave.eF
   public class_157 method_813(String var1) {
      for (class_157 var2 : this) {
         if (var2.name.equalsIgnoreCase(var1)) {
            return var2;
         }
      }

      return null;
   }
}
