package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// $VF: renamed from: nomanssave.ge
public class class_49 {
   // $VF: renamed from: gT java.util.List
   private final List field_128;
   // $VF: renamed from: nh java.util.List
   private final List field_129;
   // $VF: renamed from: ni java.util.List
   private final List field_130;

   // $VF: renamed from: m (nomanssave.eY) nomanssave.ge
   public static class_49 method_301(class_137 var0) {
      return new class_49(var0);
   }

   // $VF: renamed from: ap (int) java.util.function.Function
   private static Function method_302(int var0) {
      return ge::f;
   }

   // $VF: renamed from: cB () java.util.function.Function
   private static Function method_303() {
      return ge::h;
   }

   private class_49(class_137 var1) {
      byte var2 = 8;
      byte var3 = 6;
      if (Application.method_1323().method_1365()) {
         var2 = 10;
         var3 = 8;
      }

      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < 10; var5++) {
         var4.add(new class_70(method_302(var5), var1.method_702("Chest" + (var5 + 1) + "Inventory"), 3584, var2, var3, false, false));
      }

      class_137 var14 = var1.method_702("CookingIngredientsInventory");
      if (var14 != null) {
         var4.add(new class_70(method_303(), var14, 36352, var2, var3, false, false));
      }

      this.field_128 = Collections.unmodifiableList(var4);
      ArrayList var6 = new ArrayList();
      class_142 var7 = var1.method_703("NPCWorkers");
      String var8 = "";

      for (int var10 = 0; var10 < var7.size() && var10 < 5; var10++) {
         class_137 var9 = var7.method_736(var10);
         if (var9.method_711("HiredWorker")) {
            switch (var10) {
               case 0:
                  var8 = "Armorer";
                  break;
               case 1:
                  var8 = "Farmer";
                  break;
               case 2:
                  var8 = "Overseer";
                  break;
               case 3:
                  var8 = "Technician";
                  break;
               case 4:
                  var8 = "Scientist";
            }

            var6.add(new class_46(this, var8, var9, null));
         }
      }

      this.field_129 = Collections.unmodifiableList(var6);
      ArrayList var15 = new ArrayList();
      class_142 var11 = var1.method_703("PersistentPlayerBases");

      for (int var13 = 0; var13 < var11.size(); var13++) {
         class_137 var12 = var11.method_736(var13);
         if ("HomePlanetBase".equals(var12.getValueAsString("BaseType.PersistentBaseTypes")) && var12.method_705("BaseVersion") >= 3) {
            var15.add(new class_48(this, var12, null));
         }
      }

      this.field_130 = Collections.unmodifiableList(var15);
   }

   // $VF: renamed from: cC () java.util.List
   public List method_304() {
      return this.field_128;
   }

   // $VF: renamed from: cD () java.util.List
   public List method_305() {
      return this.field_129;
   }

   // $VF: renamed from: cE () java.util.List
   public List method_306() {
      return this.field_130;
   }
}
