package nomanssave;

import java.util.ArrayList;

// $VF: renamed from: nomanssave.gp
public class class_42 {
   private final int index;
   // $VF: renamed from: oR nomanssave.eY
   private final class_137 field_114;

   // $VF: renamed from: q (nomanssave.eY) nomanssave.gp[]
   public static class_42[] method_222(class_137 var0) {
      class_142 var1 = var0.method_703("FleetFrigates");
      return var1 == null ? new class_42[0] : method_223(var1);
   }

   // $VF: renamed from: d (nomanssave.eV) nomanssave.gp[]
   public static class_42[] method_223(class_142 var0) {
      if (var0.size() == 0) {
         return new class_42[0];
      } else {
         ArrayList var1 = new ArrayList();
         class_42[] var2 = new class_42[var0 == null ? 0 : var0.size()];

         for (int var3 = 0; var3 < var2.length; var3++) {
            class_137 var4 = var0.method_736(var3);
            var1.add(new class_42(var3, var4));
         }

         return var1.toArray(new class_42[0]);
      }
   }

   private class_42(int var1, class_137 var2) {
      this.index = var1;
      this.field_114 = var2;
   }

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.field_114.getValueAsString("CustomName");
   }

   public void setName(String var1) {
      this.field_114.method_713("CustomName", var1);
   }

   // $VF: renamed from: da () nomanssave.gr
   public class_284 method_224() {
      return class_284.method_848(this.field_114.getValueAsString("FrigateClass.FrigateClass"));
   }

   // $VF: renamed from: c (nomanssave.gr) void
   public void method_225(class_284 var1) {
      this.field_114.method_713("FrigateClass.FrigateClass", var1.toString());
   }

   // $VF: renamed from: cW () java.lang.String
   public String method_226() {
      int var1 = -2;
      class_142 var2 = this.field_114.method_703("TraitIDs");

      for (int var3 = 0; var3 < var2.size(); var3++) {
         String var4 = var2.method_738(var3);
         class_128 var5 = class_128.method_674(var4);
         if (var5 != null && var5.method_671()) {
            var1++;
         }
      }

      if (var1 < 0) {
         var1 = 0;
      }

      if (var1 > 3) {
         var1 = 3;
      }

      return class_291.values()[var1].name();
   }

   // $VF: renamed from: cU () java.lang.String
   public String method_227() {
      return this.field_114.method_703("HomeSystemSeed").method_738(1);
   }

   // $VF: renamed from: ah (java.lang.String) void
   public void method_228(String var1) {
      this.field_114.method_703("HomeSystemSeed").method_743(1, var1);
   }

   // $VF: renamed from: cV () java.lang.String
   public String method_229() {
      return this.field_114.method_703("ResourceSeed").method_738(1);
   }

   // $VF: renamed from: ai (java.lang.String) void
   public void method_230(String var1) {
      this.field_114.method_703("ResourceSeed").method_743(1, var1);
   }

   // $VF: renamed from: db () java.lang.String
   public String method_231() {
      return this.field_114.getValueAsString("Race.AlienRace");
   }

   // $VF: renamed from: am (java.lang.String) void
   public void method_232(String var1) {
      this.field_114.method_713("Race.AlienRace", var1);
   }

   // $VF: renamed from: aq (int) int
   public int method_233(int var1) {
      class_142 var2 = this.field_114.method_703("Stats");
      return var2.size() <= var1 ? 0 : var2.method_739(var1);
   }

   // $VF: renamed from: e (int, int) void
   public void method_234(int var1, int var2) {
      class_142 var3 = this.field_114.method_703("Stats");

      while (var3.size() <= var1) {
         var3.method_744(0);
      }

      var3.method_743(var1, new Integer(var2));
   }

   // $VF: renamed from: ar (int) nomanssave.er
   public class_128 method_235(int var1) {
      class_142 var2 = this.field_114.method_703("TraitIDs");
      if (var1 < var2.size()) {
         String var3 = var2.method_738(var1);
         return class_128.method_674(var3);
      } else {
         return null;
      }
   }

   // $VF: renamed from: a (int, nomanssave.er) void
   public void method_236(int var1, class_128 var2) {
      class_142 var3 = this.field_114.method_703("TraitIDs");
      if (var1 < var3.size()) {
         var3.method_743(var1, var2 == null ? "^" : var2.getID());
      }
   }

   // $VF: renamed from: dc () int
   public int method_237() {
      return this.field_114.method_705("TotalNumberOfExpeditions");
   }

   // $VF: renamed from: as (int) void
   public void method_238(int var1) {
      this.field_114.method_713("TotalNumberOfExpeditions", new Integer(var1));
   }

   // $VF: renamed from: dd () int
   public int method_239() {
      return this.field_114.method_705("TotalNumberOfSuccessfulEvents");
   }

   // $VF: renamed from: at (int) void
   public void method_240(int var1) {
      this.field_114.method_713("TotalNumberOfSuccessfulEvents", new Integer(var1));
   }

   // $VF: renamed from: de () int
   public int method_241() {
      return this.field_114.method_705("TotalNumberOfFailedEvents");
   }

   // $VF: renamed from: au (int) void
   public void method_242(int var1) {
      this.field_114.method_713("TotalNumberOfFailedEvents", new Integer(var1));
   }

   // $VF: renamed from: df () int
   public int method_243() {
      return this.field_114.method_705("NumberOfTimesDamaged");
   }

   // $VF: renamed from: av (int) void
   public void method_244(int var1) {
      this.field_114.method_713("NumberOfTimesDamaged", new Integer(var1));
   }

   // $VF: renamed from: dg () int
   public int method_245() {
      return this.field_114.method_705("RepairsMade");
   }

   // $VF: renamed from: aw (int) void
   public void method_246(int var1) {
      this.field_114.method_713("RepairsMade", new Integer(var1));
   }

   // $VF: renamed from: dh () int
   public int method_247() {
      return this.field_114.method_705("DamageTaken");
   }

   // $VF: renamed from: ax (int) void
   public void method_248(int var1) {
      this.field_114.method_713("DamageTaken", new Integer(var1));
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      if (var1 != null && var1.length() != 0) {
         return var1;
      } else {
         class_284 var2 = this.method_224();
         return var2 == null ? "Unknown [" + this.index + "]" : var2 + " [" + this.index + "]";
      }
   }
}
