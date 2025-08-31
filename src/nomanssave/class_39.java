package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gv
public class class_39 {
   private final int index;
   // $VF: renamed from: qF nomanssave.eY
   private final class_137 field_109;
   // $VF: renamed from: qG nomanssave.gt
   private final class_70 field_110;

   // $VF: renamed from: v (nomanssave.eY) nomanssave.gv[]
   public static class_39[] method_195(class_137 var0) {
      class_142 var1 = var0.method_703("Multitools");
      if (var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < var1.size(); var3++) {
            class_137 var4 = var1.method_736(var3);
            if (var4.method_703("Seed").method_742(0)) {
               var2.add(new class_39(var3, var4, var4.method_702("Store")));
            }
         }

         return var2.toArray(new class_39[0]);
      } else {
         return new class_39[]{new class_40(var0, var0.method_702("WeaponInventory"))};
      }
   }

   // $VF: renamed from: b (nomanssave.eY, java.io.File) nomanssave.gv
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static class_39 method_196(class_137 var0, File var1) {
      class_142 var2 = var0.method_703("Multitools");
      if (var2 != null && var2.size() != 0) {
         int var3 = -1;

         for (int var4 = 0; var4 < var2.size(); var4++) {
            class_137 var5 = var2.method_736(var4);
            if (!var5.method_703("Seed").method_742(0)) {
               var3 = var4;
               break;
            }
         }

         if (var3 < 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
         } else {
            class_137 var14 = class_67.method_367("multitool");
            Throwable var15 = null;
            Object var6 = null;

            try {
               class_96 var7 = new class_96(new FileInputStream(var1));

               try {
                  if (var14 == null) {
                     var14 = var7.method_558();
                  } else {
                     var14.method_697(var7.method_558());
                  }
               } finally {
                  if (var7 != null) {
                     var7.close();
                  }
               }
            } catch (Throwable var13) {
               if (var15 == null) {
                  var15 = var13;
               } else if (var15 != var13) {
                  var15.addSuppressed(var13);
               }

               throw var15;
            }

            var2.method_743(var3, var14);
            class_137 var16 = var14.method_702("Store");
            if (var16 == null) {
               throw new RuntimeException("Invalid weapon data");
            } else {
               var6 = var14.method_703("Seed");
               if (var6 != null && ((class_142)var6).method_742(0)) {
                  return new class_39(var3, var14, var16);
               } else {
                  throw new RuntimeException("Invalid weapon data");
               }
            }
         }
      } else {
         throw new RuntimeException("Weapon cannot be imported to current file!");
      }
   }

   // $VF: renamed from: b (nomanssave.gv) java.util.function.Function
   private static Function method_197(class_39 var0) {
      return gv::a;
   }

   class_39(int var1, class_137 var2, class_137 var3) {
      this.index = var1;
      this.field_109 = var2;
      byte var4 = 8;
      byte var5 = 6;
      if (Application.method_1323().method_1365()) {
         var4 = 10;
         var5 = 10;
      }

      this.field_110 = new class_70(method_197(this), var3, 2, var4, var5, true, true);
   }

   // $VF: renamed from: j (java.io.File) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_198(File var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(new FileOutputStream(var1));

         try {
            class_137 var5 = this.field_109.method_693();
            var4.method_511(var5);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var11) {
         if (var2 == null) {
            var2 = var11;
         } else if (var2 != var11) {
            var2.addSuppressed(var11);
         }

         throw var2;
      }
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.field_109.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.field_109.method_713("Name", var1);
   }

   // $VF: renamed from: cT () java.lang.String
   public String method_199() {
      return this.field_109.getValueAsString("Resource.Filename");
   }

   // $VF: renamed from: ag (java.lang.String) void
   public void method_200(String var1) {
      this.field_109.method_713("Resource.Filename", var1);
   }

   // $VF: renamed from: cK () java.lang.String
   public String method_201() {
      return this.field_109.method_703("Seed").method_738(1);
   }

   // $VF: renamed from: aa (java.lang.String) void
   public void method_202(String var1) {
      this.field_109.method_703("Seed").method_743(1, var1);
   }

   // $VF: renamed from: cW () java.lang.String
   public String method_203() {
      return this.field_109.getValueAsString("Store.Class.InventoryClass");
   }

   // $VF: renamed from: aj (java.lang.String) void
   public void method_204(String var1) {
      this.field_109.method_713("Store.Class.InventoryClass", var1);
   }

   // $VF: renamed from: dE () nomanssave.gt
   public class_70 method_205() {
      return this.field_110;
   }

   // $VF: renamed from: ak (java.lang.String) double
   private double method_206(String var1) {
      return this.field_110.method_389(var1);
   }

   // $VF: renamed from: d (java.lang.String, double) void
   private void method_207(String var1, double var2) {
      this.field_110.method_390(var1, var2);
   }

   // $VF: renamed from: dF () double
   public double method_208() {
      return this.method_206("^WEAPON_DAMAGE");
   }

   // $VF: renamed from: d (double) void
   public void method_209(double var1) {
      this.method_207("^WEAPON_DAMAGE", var1);
   }

   // $VF: renamed from: dG () double
   public double method_210() {
      return this.method_206("^WEAPON_MINING");
   }

   // $VF: renamed from: e (double) void
   public void method_211(double var1) {
      this.method_207("^WEAPON_MINING", var1);
   }

   // $VF: renamed from: dH () double
   public double method_212() {
      return this.method_206("^WEAPON_SCAN");
   }

   // $VF: renamed from: f (double) void
   public void method_213(double var1) {
      this.method_207("^WEAPON_SCAN", var1);
   }

   // $VF: renamed from: cm () void
   public void method_214() {
      this.field_109.method_713("Seed", new class_142(Boolean.FALSE, "0x0"));
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Multitool [" + this.index + "]";
   }
}
