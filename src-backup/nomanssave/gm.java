package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class gm {
   private final eY oI;
   private final List gT;
   private final gn oJ;

   public static gm p(eY var0) {
      return var0.d("CurrentFreighter.Seed").ab(0) && !isEmpty(var0.getValueAsString("CurrentFreighter.Filename"))
         ? new gm(var0, var0.H("FreighterInventory"), var0.H("FreighterInventory_TechOnly"), var0.H("FreighterInventory_Cargo"))
         : null;
   }

   private static boolean isEmpty(String var0) {
      return var0 == null || var0.length() == 0;
   }

   private static Function a(gm var0, String var1) {
      return var1x -> new String[]{"Freighter", var1};
   }

   private gm(eY var1, eY var2, eY var3, eY var4) {
      this.oI = var1;
      short var7 = 0;
      byte var8 = 0;
      short var9 = 0;
      byte var10 = 8;
      byte var11 = 6;
      byte var12 = 7;
      byte var13 = 2;
      String var5;
      String var6;
      if (Application.e().D()) {
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
      var14.add(new gt(a(this, var5), var2, var7, var10, var11, false, true));
      if (var3 != null) {
         var14.add(new gt(a(this, "Technology"), var3, var8, var12, var13, true, true));
      }

      if (var4 != null) {
         var14.add(new gt(a(this, var6), var4, var9, 8, 6, false, true));
      }

      this.gT = Collections.unmodifiableList(var14);
      eV var15 = var1.d("PersistentPlayerBases");
      eY var17 = null;

      for (int var18 = 0; var18 < var15.size(); var18++) {
         eY var16 = var15.V(var18);
         if ("FreighterBase".equals(var16.getValueAsString("BaseType.PersistentBaseTypes")) && var16.J("BaseVersion") >= 3) {
            var17 = var16;
            break;
         }
      }

      this.oJ = var17 == null ? null : new gn(this, var17, null);
   }

   public String getName() {
      return this.oI.getValueAsString("PlayerFreighterName");
   }

   public void setName(String var1) {
      this.oI.b("PlayerFreighterName", var1);
   }

   public String cT() {
      return this.oI.getValueAsString("CurrentFreighter.Filename");
   }

   public void ag(String var1) {
      this.oI.b("CurrentFreighter.Filename", var1);
   }

   public String cU() {
      eV var1 = this.oI.d("CurrentFreighterHomeSystemSeed");
      if (var1 != null && var1.ab(0)) {
         String var2 = var1.X(1);
         return "0x0".equals(var2) ? "" : var2;
      } else {
         return "";
      }
   }

   public void ah(String var1) {
      eV var2 = this.oI.d("CurrentFreighterHomeSystemSeed");
      if (var2 == null) {
         var2 = new eV(Boolean.FALSE, "0x0");
         this.oI.b("CurrentFreighterHomeSystemSeed", var2);
      }

      var2.a(0, Boolean.TRUE);
      var2.a(1, var1.length() == 0 ? "0x0" : var1);
   }

   public String cV() {
      return this.oI.d("CurrentFreighter.Seed").X(1);
   }

   public void ai(String var1) {
      this.oI.d("CurrentFreighter.Seed").a(1, var1);
   }

   public String cW() {
      return this.oI.getValueAsString("FreighterInventory.Class.InventoryClass");
   }

   public void aj(String var1) {
      this.oI.b("FreighterInventory.Class.InventoryClass", var1);
      eY var2 = this.oI.H("FreighterInventory_TechOnly.Class");
      if (var2 != null) {
         var2.b("InventoryClass", var1);
      }

      var2 = this.oI.H("FreighterInventory_Cargo.Class");
      if (var2 != null) {
         var2.b("InventoryClass", var1);
      }
   }

   public List cC() {
      return this.gT;
   }

   private double ak(String var1) {
      return ((gt)this.gT.get(0)).ak(var1);
   }

   private void d(String var1, double var2) {
      this.gT.stream().forEach(var3 -> var3.d(var1, var2));
   }

   public double cX() {
      return this.ak("^FREI_HYPERDRIVE");
   }

   public void a(double var1) {
      this.d("^FREI_HYPERDRIVE", var1);
   }

   public double cY() {
      return this.ak("^FREI_FLEET");
   }

   public void b(double var1) {
      this.d("^FREI_FLEET", var1);
   }

   public gn cZ() {
      return this.oJ;
   }

   @Override
   public String toString() {
      String var1 = this.getName();
      return var1 != null && var1.length() != 0 ? var1 : "Freighter";
   }
}
