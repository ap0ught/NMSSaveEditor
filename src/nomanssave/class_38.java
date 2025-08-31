package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gz
public class class_38 {
   // $VF: renamed from: oI nomanssave.eY
   private final class_137 field_105;
   // $VF: renamed from: rb nomanssave.eV
   private final class_142 field_106;
   // $VF: renamed from: rc nomanssave.eV
   private final class_142 field_107;
   // $VF: renamed from: gT java.util.List
   private final List field_108;

   // $VF: renamed from: w (nomanssave.eY) nomanssave.gz
   public static class_38 method_161(class_137 var0) {
      class_142 var1 = null;
      class_142 var2 = var0.method_703("Stats");
      if (var2 != null) {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            class_137 var4 = var2.method_736(var3);
            if ("^GLOBAL_STATS".equals(var4.getValueAsString("GroupId"))) {
               var1 = var4.method_703("Stats");
               break;
            }
         }
      }

      return new class_38(var0, var1, var0.method_702("Inventory"), var0.method_702("Inventory_TechOnly"), var0.method_702("Inventory_Cargo"));
   }

   // $VF: renamed from: au (java.lang.String) java.util.function.Function
   private static Function method_162(String var0) {
      return gz::a;
   }

   private class_38(class_137 var1, class_142 var2, class_137 var3, class_137 var4, class_137 var5) {
      this.field_105 = var1;
      this.field_106 = var2;
      class_142 var6 = var1.method_703("KnownWords");
      class_142 var7 = var1.method_703("KnownWordGroups");
      if (var7 == null) {
         var7 = new class_142();
         var1.method_713("KnownWordGroups", var7);
      }

      if (var6.size() > 0) {
         int var8 = 0;

         while (var8 < var6.size()) {
            class_137 var9 = var6.method_736(var8);
            class_144 var10 = class_144.method_752(var9.getValueAsString("id"));
            if (var10 == null) {
               class_37.warn("Could not build word groups: " + var9.getValueAsString("id"));
               var8++;
            } else {
               for (String var11 : var10.method_749()) {
                  class_296 var13 = var10.method_750(var11);
                  if (var13 != null) {
                     class_137 var14 = new class_137();
                     var14.method_713("Group", var11);
                     class_142 var15 = new class_142(
                        Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
                     );
                     var15.method_743(var13.ordinal(), Boolean.TRUE);
                     var14.method_713("Races", var15);
                     var7.method_744(var14);
                     class_37.debug("Creating word: " + var11 + "[" + var13.ordinal() + "] = true");
                  }
               }

               var6.method_745(var8);
               class_37.debug("Removed old word: " + var9.getValueAsString("id"));
            }
         }
      }

      this.field_107 = var7;
      short var20 = 0;
      byte var22 = 0;
      short var24 = 0;
      byte var25 = 8;
      byte var26 = 6;
      byte var27 = 7;
      byte var16 = 2;
      String var18;
      String var19;
      if (Application.method_1323().method_1365()) {
         var20 = 3584;
         var22 = 1;
         var25 = 10;
         var26 = 12;
         var27 = 10;
         var16 = 6;
         var18 = "Cargo";
         var19 = "Unused";
         var5 = null;
      } else {
         var20 = 3585;
         var22 = 1;
         var24 = 3584;
         var18 = "General";
         var19 = "Cargo";
      }

      ArrayList var17 = new ArrayList();
      var17.add(new class_70(method_162(var18), var3, var20, var25, var26, false, true));
      if (var4 != null) {
         var17.add(new class_70(method_162("Technology"), var4, var22, var27, var16, true, true));
      }

      if (var5 != null) {
         var17.add(new class_70(method_162(var19), var5, var24, 8, 6, false, true));
      }

      this.field_108 = Collections.unmodifiableList(var17);
   }

   // $VF: renamed from: dJ () long
   public long method_163() {
      return this.field_105.method_707("Units") & 4294967295L;
   }

   // $VF: renamed from: e (long) void
   public void method_164(long var1) {
      this.field_105.method_713("Units", new Integer((int)var1));
   }

   // $VF: renamed from: dK () long
   public long method_165() {
      return this.field_105.method_707("Nanites") & 4294967295L;
   }

   // $VF: renamed from: f (long) void
   public void method_166(long var1) {
      this.field_105.method_713("Nanites", new Integer((int)var1));
   }

   // $VF: renamed from: dL () long
   public long method_167() {
      return this.field_105.method_707("Specials") & 4294967295L;
   }

   // $VF: renamed from: g (long) void
   public void method_168(long var1) {
      this.field_105.method_713("Specials", new Integer((int)var1));
   }

   // $VF: renamed from: dM () int
   public int method_169() {
      return this.field_105.method_705("Health");
   }

   // $VF: renamed from: aB (int) void
   public void method_170(int var1) {
      this.field_105.method_713("Health", new Integer(var1));
   }

   // $VF: renamed from: dN () int
   public int method_171() {
      return this.field_105.method_705("Shield");
   }

   // $VF: renamed from: aC (int) void
   public void method_172(int var1) {
      this.field_105.method_713("Shield", new Integer(var1));
   }

   // $VF: renamed from: dO () int
   public int method_173() {
      return this.field_105.method_705("Energy");
   }

   // $VF: renamed from: aD (int) void
   public void method_174(int var1) {
      this.field_105.method_713("Energy", new Integer(var1));
   }

   // $VF: renamed from: cC () java.util.List
   public List method_175() {
      return this.field_108;
   }

   // $VF: renamed from: dP () int
   public int method_176() {
      return this.field_105.method_705("KnownPortalRunes");
   }

   // $VF: renamed from: aE (int) void
   public void method_177(int var1) {
      this.field_105.method_713("KnownPortalRunes", new Integer(var1));
   }

   // $VF: renamed from: dQ () nomanssave.eV
   public class_142 method_178() {
      return this.field_105.method_703("KnownTech");
   }

   // $VF: renamed from: dR () nomanssave.eV
   public class_142 method_179() {
      return this.field_105.method_703("KnownProducts");
   }

   // $VF: renamed from: dS () nomanssave.eV
   public class_142 method_180() {
      return this.field_105.method_703("KnownSpecials");
   }

   // $VF: renamed from: bx () int
   public int method_181() {
      byte var1 = 0;
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < this.field_107.size(); var4++) {
         class_137 var2 = this.field_107.method_736(var4);
         class_144 var5 = class_144.method_753(var2.getValueAsString("Group"));
         if (var5 != null && !var3.contains(var5.getID())) {
            var3.add(var5.getID());
         }
      }

      return var1;
   }

   // $VF: renamed from: b (nomanssave.eU) int
   public int method_182(class_296 var1) {
      int var2 = 0;

      for (int var4 = 0; var4 < this.field_107.size(); var4++) {
         class_137 var3 = this.field_107.method_736(var4);
         if (var3.method_703("Races").method_742(var1.ordinal())) {
            var2++;
         }
      }

      return var2;
   }

   // $VF: renamed from: a (nomanssave.eS) nomanssave.gA
   public class_80 method_183(class_144 var1) {
      return new class_80(this, var1, null);
   }

   // $VF: renamed from: d (java.lang.String, int) boolean
   private boolean method_184(String var1, int var2) {
      for (int var3 = 0; var3 < this.field_107.size(); var3++) {
         class_137 var4 = this.field_107.method_736(var3);
         if (var1.equals(var4.getValueAsString("Group"))) {
            return var4.method_703("Races").method_742(var2);
         }
      }

      return false;
   }

   // $VF: renamed from: a (java.lang.String, int, boolean) void
   private void method_185(String var1, int var2, boolean var3) {
      for (int var5 = 0; var5 < this.field_107.size(); var5++) {
         class_137 var4 = this.field_107.method_736(var5);
         if (var1.equals(var4.getValueAsString("Group"))) {
            class_37.debug("Updating word: " + var1 + "[" + var2 + "] = " + var3);
            class_142 var6 = var4.method_703("Races");

            while (var6.size() < class_296.values().length) {
               var6.method_733(Boolean.FALSE);
            }

            var6.method_743(var2, new Boolean(var3));

            for (int var7 = 0; var7 < var6.size(); var7++) {
               var3 |= var6.method_742(var7);
            }

            if (!var3) {
               class_37.debug("Removing word: " + var1);
               this.field_107.method_745(var5);
            }

            return;
         }
      }

      if (var3) {
         class_37.debug("Creating word: " + var1 + "[" + var2 + "] = " + var3);
         class_137 var8 = new class_137();
         var8.method_713("Group", var1);
         class_142 var9 = new class_142();

         while (var9.size() < class_296.values().length) {
            var9.method_733(Boolean.FALSE);
         }

         var9.method_743(var2, new Boolean(var3));
         var8.method_713("Races", var9);
         this.field_107.method_744(var8);
      }
   }

   // $VF: renamed from: dT () double
   public double method_186() {
      return new Double((double)Math.round((double)this.field_105.method_705("HazardTimeAlive") / 90.0) / 10.0);
   }

   // $VF: renamed from: g (double) void
   public void method_187(double var1) {
      long var3 = Math.round(var1 * 900.0);
      if (var3 >= 0L && var3 <= 2147483647L) {
         this.field_105.method_713("HazardTimeAlive", new Integer((int)var3));
      } else {
         throw new RuntimeException("Stat value out of range");
      }
   }

   // $VF: renamed from: a (nomanssave.gs) int
   public int method_188(class_283 var1) {
      for (int var3 = 0; var3 < this.field_106.size(); var3++) {
         class_137 var2 = this.field_106.method_736(var3);
         if (var2.getValueAsString("Id").equals(var1.field_746)) {
            return var2.method_705("Value.IntValue");
         }
      }

      return 0;
   }

   // $VF: renamed from: a (nomanssave.gs, int) void
   public void method_189(class_283 var1, int var2) {
      if (var2 < 0) {
         throw new RuntimeException("Stat value out of range");
      } else {
         for (int var4 = 0; var4 < this.field_106.size(); var4++) {
            class_137 var3 = this.field_106.method_736(var4);
            if (var3.getValueAsString("Id").equals(var1.field_746)) {
               var3.method_713("Value.IntValue", new Integer(var2));
               return;
            }
         }

         class_137 var5 = new class_137();
         var5.method_713("Id", var1.field_746);
         class_137 var6 = new class_137();
         var6.method_713("IntValue", new Integer(var2));
         var6.method_713("FloatValue", new Double(0.0));
         var6.method_713("Denominator", new Double(0.0));
         var5.method_713("Value", var6);
         this.field_106.method_744(var5);
      }
   }

   // $VF: renamed from: b (nomanssave.gs) double
   public double method_190(class_283 var1) {
      for (int var3 = 0; var3 < this.field_106.size(); var3++) {
         class_137 var2 = this.field_106.method_736(var3);
         if (var2.getValueAsString("Id").equals(var1.field_746)) {
            return var2.method_709("Value.FloatValue");
         }
      }

      return 0.0;
   }

   // $VF: renamed from: a (nomanssave.gs, double) void
   public void method_191(class_283 var1, double var2) {
      if (var2 < 0.0) {
         throw new RuntimeException("Stat value out of range");
      } else {
         for (int var5 = 0; var5 < this.field_106.size(); var5++) {
            class_137 var4 = this.field_106.method_736(var5);
            if (var4.getValueAsString("Id").equals(var1.field_746)) {
               var4.method_713("Value.FloatValue", new Double(var2));
               return;
            }
         }

         class_137 var6 = new class_137();
         var6.method_713("Id", var1.field_746);
         class_137 var7 = new class_137();
         var7.method_713("IntValue", new Integer(0));
         var7.method_713("FloatValue", new Double(var2));
         var7.method_713("Denominator", new Double(0.0));
         var6.method_713("Value", var7);
         this.field_106.method_744(var6);
      }
   }
}
