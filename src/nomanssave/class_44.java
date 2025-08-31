package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gm
public class class_44 {
   // $VF: renamed from: oI nomanssave.eY
   private final class_137 field_117;
   // $VF: renamed from: gT java.util.List
   private final List field_118;
   // $VF: renamed from: oJ nomanssave.gn
   private final class_43 field_119;

   // $VF: renamed from: p (nomanssave.eY) nomanssave.gm
   public static class_44 method_252(class_137 var0) {
      return var0.method_703("CurrentFreighter.Seed").method_742(0) && !isEmpty(var0.getValueAsString("CurrentFreighter.Filename"))
         ? new class_44(
            var0, var0.method_702("FreighterInventory"), var0.method_702("FreighterInventory_TechOnly"), var0.method_702("FreighterInventory_Cargo")
         )
         : null;
   }

   private static boolean isEmpty(String var0) {
      return var0 == null || var0.length() == 0;
   }

   // $VF: renamed from: a (nomanssave.gm, java.lang.String) java.util.function.Function
   private static Function method_253(class_44 var0, String var1) {
      return gm::a;
   }

   private class_44(class_137 var1, class_137 var2, class_137 var3, class_137 var4) {
      this.field_117 = var1;
      short var7 = 0;
      byte var8 = 0;
      short var9 = 0;
      byte var10 = 8;
      byte var11 = 6;
      byte var12 = 7;
      byte var13 = 2;
      String var5;
      String var6;
      if (Application.method_1323().method_1365()) {
         var7 = 3584;
         var8 = 8;
         var10 = 10;
         var11 = 12;
         var12 = 10;
         var13 = 6;
         var5 = "Cargo";
         var6 = "Unused";
         var4 = null;
      } else {
         var7 = 3592;
         var8 = 8;
         var9 = 3584;
         var5 = "General";
         var6 = "Cargo";
      }

      ArrayList var14 = new ArrayList();
      var14.add(new class_70(method_253(this, var5), var2, var7, var10, var11, false, true));
      if (var3 != null) {
         var14.add(new class_70(method_253(this, "Technology"), var3, var8, var12, var13, true, true));
      }

      if (var4 != null) {
         var14.add(new class_70(method_253(this, var6), var4, var9, 8, 6, false, true));
      }

      this.field_118 = Collections.unmodifiableList(var14);
      class_142 var15 = var1.method_703("PersistentPlayerBases");
      class_137 var17 = null;

      for (int var18 = 0; var18 < var15.size(); var18++) {
         class_137 var16 = var15.method_736(var18);
         if ("FreighterBase".equals(var16.getValueAsString("BaseType.PersistentBaseTypes")) && var16.method_705("BaseVersion") >= 3) {
            var17 = var16;
            break;
         }
      }

      this.field_119 = var17 == null ? null : new class_43(this, var17, null);
   }

   public String getName() {
      return this.field_117.getValueAsString("PlayerFreighterName");
   }

   public void setName(String var1) {
      this.field_117.method_713("PlayerFreighterName", var1);
   }

   // $VF: renamed from: cT () java.lang.String
   public String method_254() {
      return this.field_117.getValueAsString("CurrentFreighter.Filename");
   }

   // $VF: renamed from: ag (java.lang.String) void
   public void method_255(String var1) {
      this.field_117.method_713("CurrentFreighter.Filename", var1);
   }

   // $VF: renamed from: cU () java.lang.String
   public String method_256() {
      class_142 var1 = this.field_117.method_703("CurrentFreighterHomeSystemSeed");
      if (var1 != null && var1.method_742(0)) {
         String var2 = var1.method_738(1);
         return "0x0".equals(var2) ? "" : var2;
      } else {
         return "";
      }
   }

   // $VF: renamed from: ah (java.lang.String) void
   public void method_257(String var1) {
      class_142 var2 = this.field_117.method_703("CurrentFreighterHomeSystemSeed");
      if (var2 == null) {
         var2 = new class_142(Boolean.FALSE, "0x0");
         this.field_117.method_713("CurrentFreighterHomeSystemSeed", var2);
      }

      var2.method_743(0, Boolean.TRUE);
      var2.method_743(1, var1.length() == 0 ? "0x0" : var1);
   }

   // $VF: renamed from: cV () java.lang.String
   public String method_258() {
      return this.field_117.method_703("CurrentFreighter.Seed").method_738(1);
   }

   // $VF: renamed from: ai (java.lang.String) void
   public void method_259(String var1) {
      this.field_117.method_703("CurrentFreighter.Seed").method_743(1, var1);
   }

   // $VF: renamed from: cW () java.lang.String
   public String method_260() {
      return this.field_117.getValueAsString("FreighterInventory.Class.InventoryClass");
   }

   // $VF: renamed from: aj (java.lang.String) void
   public void method_261(String var1) {
      this.field_117.method_713("FreighterInventory.Class.InventoryClass", var1);
      class_137 var2 = this.field_117.method_702("FreighterInventory_TechOnly.Class");
      if (var2 != null) {
         var2.method_713("InventoryClass", var1);
      }

      var2 = this.field_117.method_702("FreighterInventory_Cargo.Class");
      if (var2 != null) {
         var2.method_713("InventoryClass", var1);
      }
   }

   // $VF: renamed from: cC () java.util.List
   public List method_262() {
      return this.field_118;
   }

   // $VF: renamed from: ak (java.lang.String) double
   private double method_263(String var1) {
      return ((class_70)this.field_118.get(0)).method_389(var1);
   }

   // $VF: renamed from: d (java.lang.String, double) void
   private void method_264(String var1, double var2) {
      this.field_118.stream().forEach(gm::a);
   }

   // $VF: renamed from: cX () double
   public double method_265() {
      return this.method_263("^FREI_HYPERDRIVE");
   }

   // $VF: renamed from: a (double) void
   public void method_266(double var1) {
      this.method_264("^FREI_HYPERDRIVE", var1);
   }

   // $VF: renamed from: cY () double
   public double method_267() {
      return this.method_263("^FREI_FLEET");
   }

   // $VF: renamed from: b (double) void
   public void method_268(double var1) {
      this.method_264("^FREI_FLEET", var1);
   }

   // $VF: renamed from: cZ () nomanssave.gn
   public class_43 method_269() {
      return this.field_119;
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Freighter";
   }
}
