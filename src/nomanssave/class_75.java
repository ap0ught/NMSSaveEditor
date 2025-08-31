package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gH
public class class_75 {
   private final int index;
   // $VF: renamed from: rp nomanssave.eY
   private final class_137 field_228;
   // $VF: renamed from: gT java.util.List
   private final List field_229;

   // $VF: renamed from: C (nomanssave.eY) nomanssave.gH[]
   public static class_75[] method_431(class_137 var0) {
      class_142 var1 = var0.method_703("ShipOwnership");
      if (var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < var1.size(); var3++) {
            class_137 var4 = var1.method_736(var3);
            if (var4.method_703("Resource.Seed").method_742(0)) {
               var2.add(new class_75(var3, var4, var4.method_702("Inventory"), var4.method_702("Inventory_TechOnly"), var4.method_702("Inventory_Cargo")));
            }
         }

         return var2.toArray(new class_75[0]);
      } else {
         return new class_75[0];
      }
   }

   // $VF: renamed from: c (nomanssave.eY, java.io.File) nomanssave.gH
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static class_75 method_432(class_137 var0, File var1) {
      class_142 var2 = var0.method_703("ShipOwnership");
      if (var2 != null && var2.size() != 0) {
         int var3 = -1;

         for (int var4 = 0; var4 < var2.size(); var4++) {
            class_137 var5 = var2.method_736(var4);
            if (!var5.method_703("Resource.Seed").method_742(0)) {
               var3 = var4;
               break;
            }
         }

         if (var3 < 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
         } else {
            class_137 var14 = class_67.method_367("ship");
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

            class_137 var16 = var14.method_702("Inventory");
            if (var16 == null) {
               throw new RuntimeException("Invalid ship data");
            } else {
               var6 = var14.method_703("Resource.Seed");
               if (var6 != null && ((class_142)var6).method_742(0)) {
                  var2.method_743(var3, var14);
                  return new class_75(var3, var14, var16, var14.method_702("Inventory_TechOnly"), var14.method_702("Inventory_Cargo"));
               } else {
                  throw new RuntimeException("Invalid ship data");
               }
            }
         }
      } else {
         throw new RuntimeException("Ship cannot be imported to current file!");
      }
   }

   // $VF: renamed from: a (nomanssave.gH, java.lang.String[]) java.util.function.Function
   private static Function method_433(class_75 var0, String[] var1) {
      return gH::a;
   }

   private class_75(int var1, class_137 var2, class_137 var3, class_137 var4, class_137 var5) {
      this.index = var1;
      this.field_228 = var2;
      String[] var7 = new String[]{"Technology", "Organ Chamber"};
      short var9 = 0;
      byte var10 = 8;
      byte var11 = 6;
      byte var12 = 8;
      byte var13 = 6;
      boolean var14 = Application.method_1323().method_1365();
      String[] var6;
      String[] var8;
      if (var14) {
         var10 = 10;
         var11 = 12;
         var12 = 10;
         var13 = 6;
         var6 = new String[]{"Cargo", "Storage Sacs"};
         var8 = new String[]{"Unused", "Unused"};
         var5 = null;
      } else {
         var9 = 3584;
         var6 = new String[]{"General", "Storage Sacs"};
         var8 = new String[]{"Cargo", "Inflated Sacs"};
      }

      ArrayList var15 = new ArrayList();
      var15.add(new class_74(this, method_433(this, var6), var3, 0, var10, var11, false, true, var14, var1));
      if (var4 != null) {
         var15.add(new class_73(this, method_433(this, var7), var4, 0, var12, var13, true, true, var1));
      }

      if (var5 != null) {
         var15.add(new class_72(this, method_433(this, var8), var5, var9, 8, 6, false, true, var1));
      }

      this.field_229 = Collections.unmodifiableList(var15);
   }

   // $VF: renamed from: a (java.io.File, boolean) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_434(File var1, boolean var2) {
      Throwable var3 = null;
      Object var4 = null;

      try {
         class_92 var5 = new class_92(new FileOutputStream(var1));

         try {
            class_137 var6 = this.field_228.method_693();
            if (!var2) {
               class_142 var7 = var6.method_703("Inventory.Slots");

               for (int var8 = 0; var8 < var7.size(); var8++) {
                  class_137 var9 = var7.method_736(var8);
                  if (!var9.getValueAsString("Type.InventoryType").equals("Technology")) {
                     var7.method_745(var8--);
                  }
               }

               var7 = var6.method_703("Inventory_Cargo.Slots");

               for (int var17 = 0; var17 < var7.size(); var17++) {
                  class_137 var18 = var7.method_736(var17);
                  if (!var18.getValueAsString("Type.InventoryType").equals("Technology")) {
                     var7.method_745(var17--);
                  }
               }
            }

            var5.method_511(var6);
         } finally {
            if (var5 != null) {
               var5.close();
            }
         }
      } catch (Throwable var15) {
         if (var3 == null) {
            var3 = var15;
         } else if (var3 != var15) {
            var3.addSuppressed(var15);
         }

         throw var3;
      }
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.field_228.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.field_228.method_713("Name", var1);
   }

   // $VF: renamed from: dZ () boolean
   public boolean method_435() {
      return class_292.method_852(this.method_437()) == class_292.field_863;
   }

   // $VF: renamed from: ea () int
   private int method_436() {
      class_292 var1 = class_292.method_852(this.method_437());
      return var1 == null ? 4 : var1.method_851();
   }

   // $VF: renamed from: cT () java.lang.String
   public String method_437() {
      return this.field_228.getValueAsString("Resource.Filename");
   }

   // $VF: renamed from: ag (java.lang.String) void
   public void method_438(String var1) {
      this.field_228.method_713("Resource.Filename", var1);
      class_292 var2 = class_292.method_852(var1);
      this.field_229.stream().forEach(gH::a);
      if (var2 == class_292.field_863) {
         this.method_446("^ALIEN_SHIP", 1.0);
         this.method_447("^ROBOT_SHIP");
      } else if (var2 == class_292.field_868) {
         this.method_447("^ALIEN_SHIP");
         this.method_446("^ROBOT_SHIP", 1.0);
      } else {
         this.method_447("^ALIEN_SHIP");
         this.method_447("^ROBOT_SHIP");
      }
   }

   // $VF: renamed from: cK () java.lang.String
   public String method_439() {
      return this.field_228.method_703("Resource.Seed").method_738(1);
   }

   // $VF: renamed from: aa (java.lang.String) void
   public void method_440(String var1) {
      this.field_228.method_703("Resource.Seed").method_743(1, var1);
   }

   // $VF: renamed from: cm () void
   public void method_441() {
      this.field_228.method_713("Resource.Filename", "");
      this.field_228.method_703("Resource.Seed").method_743(0, Boolean.FALSE);
      this.field_228.method_703("Resource.Seed").method_743(1, "0x0");
   }

   // $VF: renamed from: cW () java.lang.String
   public String method_442() {
      return this.field_228.getValueAsString("Inventory.Class.InventoryClass");
   }

   // $VF: renamed from: aj (java.lang.String) void
   public void method_443(String var1) {
      this.field_228.method_713("Inventory.Class.InventoryClass", var1);
      class_137 var2 = this.field_228.method_702("Inventory_TechOnly.Class");
      if (var2 != null) {
         var2.method_713("InventoryClass", var1);
      }

      var2 = this.field_228.method_702("Inventory_Cargo.Class");
      if (var2 != null) {
         var2.method_713("InventoryClass", var1);
      }
   }

   // $VF: renamed from: cC () java.util.List
   public List method_444() {
      return this.field_229;
   }

   // $VF: renamed from: ak (java.lang.String) double
   private double method_445(String var1) {
      return ((class_70)this.field_229.get(0)).method_389(var1);
   }

   // $VF: renamed from: d (java.lang.String, double) void
   private void method_446(String var1, double var2) {
      this.field_229.stream().forEach(gH::b);
   }

   // $VF: renamed from: av (java.lang.String) void
   private void method_447(String var1) {
      this.field_229.stream().forEach(gH::b);
   }

   // $VF: renamed from: dF () double
   public double method_448() {
      return this.method_445("^SHIP_DAMAGE");
   }

   // $VF: renamed from: d (double) void
   public void method_449(double var1) {
      this.method_446("^SHIP_DAMAGE", var1);
   }

   // $VF: renamed from: eb () double
   public double method_450() {
      return this.method_445("^SHIP_SHIELD");
   }

   // $VF: renamed from: h (double) void
   public void method_451(double var1) {
      this.method_446("^SHIP_SHIELD", var1);
   }

   // $VF: renamed from: cX () double
   public double method_452() {
      return this.method_445("^SHIP_HYPERDRIVE");
   }

   // $VF: renamed from: a (double) void
   public void method_453(double var1) {
      this.method_446("^SHIP_HYPERDRIVE", var1);
   }

   // $VF: renamed from: ec () double
   public double method_454() {
      return this.method_445("^SHIP_AGILE");
   }

   // $VF: renamed from: i (double) void
   public void method_455(double var1) {
      this.method_446("^SHIP_AGILE", var1);
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      if (var1 != null && var1.length() != 0) {
         return var1;
      } else {
         class_292 var2 = class_292.method_852(this.method_437());
         return var2 == null ? "Unknown [" + this.index + "]" : var2 + " [" + this.index + "]";
      }
   }
}
