package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gO
public class class_68 {
   private final int index;
   // $VF: renamed from: rO nomanssave.eY
   private final class_137 field_178;
   // $VF: renamed from: gT java.util.List
   private final List field_179;

   // $VF: renamed from: E (nomanssave.eY) nomanssave.gO[]
   public static class_68[] method_368(class_137 var0) {
      class_142 var1 = var0.method_703("VehicleOwnership");
      if (var1 != null && var1.size() != 0) {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < var1.size(); var3++) {
            class_137 var4 = var1.method_736(var3);
            if (var3 != 4) {
               var2.add(new class_68(var3, var4, var4.method_702("Inventory"), var4.method_702("Inventory_TechOnly")));
            }
         }

         class_137 var5 = var0.method_702("FishPlatformLayout");
         class_137 var6 = var0.method_702("FishPlatformInventory");
         if (var5 != null && var6 != null) {
            var2.add(new class_68(var5, var6));
         }

         return var2.toArray(new class_68[0]);
      } else {
         return new class_68[0];
      }
   }

   // $VF: renamed from: a (nomanssave.gO, java.lang.String) java.util.function.Function
   private static Function method_369(class_68 var0, String var1) {
      return gO::a;
   }

   private class_68(int var1, class_137 var2, class_137 var3, class_137 var4) {
      this.index = var1;
      this.field_178 = var2;
      short var5;
      if (var1 == 5) {
         var5 = 32;
      } else if (var1 == 6) {
         var5 = 128;
      } else {
         var5 = 16;
      }

      boolean var6 = Application.method_1323().method_1365();
      byte var7 = 8;
      byte var8 = 6;
      byte var9 = 8;
      byte var10 = 6;
      String var11;
      if (var6) {
         var7 = 10;
         var8 = 5;
         var9 = 10;
         var10 = 3;
         var11 = "Cargo";
      } else {
         var11 = "General";
      }

      ArrayList var12 = new ArrayList();
      var12.add(new class_71(this, method_369(this, var11), var3, 0, var7, var8, false, false, false, false, var6, var5));
      if (var4 != null) {
         var12.add(new class_70(method_369(this, "Technology"), var4, var5, var9, var10, true, false, false, false));
      }

      this.field_179 = Collections.unmodifiableList(var12);
   }

   private class_68(class_137 var1, class_137 var2) {
      this.index = 1000;
      this.field_178 = var1;
      var2.method_699(gO::a);
      byte var3 = 8;
      byte var4 = 6;
      ArrayList var5 = new ArrayList();
      var5.add(new class_70(method_369(this, "Cold Storage"), var2, 2048, var3, var4, false, false, true, false));
      this.field_179 = Collections.unmodifiableList(var5);
   }

   public String getType() {
      if (this.index == 0) {
         return "Roamer";
      } else if (this.index == 1) {
         return "Nomad";
      } else if (this.index == 2) {
         return "Colossus";
      } else if (this.index == 3) {
         return "Pilgrim";
      } else if (this.index == 5) {
         return "Nautilon";
      } else if (this.index == 6) {
         return "Minotaur";
      } else {
         return this.index == 1000 ? "Skiff" : "Vehicle " + this.index;
      }
   }

   // $VF: renamed from: cC () java.util.List
   public List method_370() {
      return this.field_179;
   }

   @Override
   public String toString() {
      return this.getType();
   }
}
