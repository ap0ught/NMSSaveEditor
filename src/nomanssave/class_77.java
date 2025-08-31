package nomanssave;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// $VF: renamed from: nomanssave.gE
public class class_77 {
   private final int index;
   // $VF: renamed from: bf nomanssave.eY
   private final class_137 field_232;

   // $VF: renamed from: z (nomanssave.eY) nomanssave.gE[]
   public static class_77[] method_461(class_137 var0) {
      class_142 var1 = var0.method_703("TeleportEndpoints");
      List var2 = var1.method_747().filter(gE::A).map(gE::B).collect(Collectors.toList());
      class_142 var3 = var0.method_703("SettlementStatesV2");
      if (var3 != null && var3.size() != 0) {
         ArrayList var4 = new ArrayList();

         for (int var5 = 0; var5 < var3.size(); var5++) {
            class_137 var6 = var3.method_736(var5);
            class_30 var7 = class_30.method_99(var6.getValue("UniverseAddress"));
            if (var2.contains(var7)) {
               var4.add(new class_77(var5, var6));
            }
         }

         return var4.toArray(new class_77[0]);
      } else {
         return new class_77[0];
      }
   }

   private class_77(int var1, class_137 var2) {
      this.index = var1;
      this.field_232 = var2;
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.field_232.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.field_232.method_713("Name", var1);
   }

   // $VF: renamed from: aq (int) int
   public int method_462(int var1) {
      return this.field_232.method_703("Stats").method_739(var1);
   }

   // $VF: renamed from: e (int, int) void
   public void method_463(int var1, int var2) {
      this.field_232.method_703("Stats").method_743(var1, var2);
   }

   // $VF: renamed from: a (nomanssave.gG) int
   public int method_464(class_293 var1) {
      return this.field_232.method_703("Stats").method_739(var1.ordinal());
   }

   // $VF: renamed from: a (nomanssave.gG, int) void
   public void method_465(class_293 var1, int var2) {
      this.field_232.method_703("Stats").method_743(var1.ordinal(), var2);
   }

   // $VF: renamed from: dW () int
   public int method_466() {
      return this.field_232.method_703("Perks").size();
   }

   // $VF: renamed from: aH (int) java.lang.String
   public String method_467(int var1) {
      return this.field_232.method_703("Perks").method_738(var1);
   }

   // $VF: renamed from: c (int, java.lang.String) void
   public void method_468(int var1, String var2) {
      this.field_232.method_703("Perks").method_743(var1, var2);
   }

   // $VF: renamed from: cK () java.lang.String
   public String method_469() {
      return this.field_232.method_704("SeedValue");
   }

   // $VF: renamed from: aa (java.lang.String) void
   public void method_470(String var1) {
      this.field_232.method_713("SeedValue", var1);
   }

   // $VF: renamed from: dX () nomanssave.gF[]
   public class_76[] method_471() {
      class_142 var1 = this.field_232.method_703("ProductionState");
      if (var1 == null) {
         return new class_76[0];
      } else {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < var1.size(); var3++) {
            class_137 var4 = var1.method_736(var3);
            var2.add(new class_76(this, var4, null));
         }

         return var2.toArray(new class_76[0]);
      }
   }

   @Override
   public String toString() {
      return this.getName();
   }
}
