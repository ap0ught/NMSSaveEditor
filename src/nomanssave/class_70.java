package nomanssave;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.function.Function;

// $VF: renamed from: nomanssave.gt
public class class_70 {
   // $VF: renamed from: pW int
   public static final int field_182 = 1;
   // $VF: renamed from: pX int
   public static final int field_183 = 2;
   // $VF: renamed from: pY int
   public static final int field_184 = 4;
   // $VF: renamed from: pZ int
   public static final int field_185 = 8;
   // $VF: renamed from: qa int
   public static final int field_186 = 16;
   // $VF: renamed from: qb int
   public static final int field_187 = 32;
   // $VF: renamed from: qc int
   public static final int field_188 = 64;
   // $VF: renamed from: qd int
   public static final int field_189 = 128;
   // $VF: renamed from: qe int
   public static final int field_190 = 256;
   // $VF: renamed from: qf int
   public static final int field_191 = 324;
   // $VF: renamed from: qg int
   public static final int field_192 = 176;
   // $VF: renamed from: qh int
   public static final int field_193 = 260;
   // $VF: renamed from: qi int
   public static final int field_194 = 511;
   // $VF: renamed from: qj int
   public static final int field_195 = 512;
   // $VF: renamed from: qk int
   public static final int field_196 = 1024;
   // $VF: renamed from: ql int
   public static final int field_197 = 2048;
   // $VF: renamed from: qm int
   public static final int field_198 = 3584;
   // $VF: renamed from: qn int
   public static final int field_199 = 8192;
   // $VF: renamed from: qo int
   public static final int field_200 = 16384;
   // $VF: renamed from: qp int
   public static final int field_201 = 32768;
   // $VF: renamed from: qq int
   public static final int field_202 = 8;
   // $VF: renamed from: qr int
   public static final int field_203 = 6;
   // $VF: renamed from: qs java.util.function.Function
   private final Function field_204;
   // $VF: renamed from: qt nomanssave.eY
   private final class_137 field_205;
   // $VF: renamed from: r int
   private final int field_206;
   // $VF: renamed from: qu boolean
   private final boolean field_207;
   // $VF: renamed from: qv boolean
   private final boolean field_208;
   // $VF: renamed from: qw boolean
   private final boolean field_209;
   // $VF: renamed from: qx boolean
   private final boolean field_210;
   private int width;
   private int height;
   // $VF: renamed from: bE int
   private int field_211;
   // $VF: renamed from: bF int
   private int field_212;
   // $VF: renamed from: qy nomanssave.eY[][]
   private class_137[][] field_213;
   // $VF: renamed from: qz boolean[][]
   private boolean[][] field_214;

   // $VF: renamed from: a (nomanssave.ex) int
   public static int method_384(class_295 var0) {
      switch (method_428()[var0.ordinal()]) {
         case 18:
            return 3584;
         case 19:
         case 25:
         default:
            return 1536;
         case 20:
            return 4;
         case 21:
         case 22:
            return 2;
         case 23:
         case 24:
            return 1;
         case 26:
         case 27:
            return 8;
         case 28:
         case 29:
            return 16;
         case 30:
         case 31:
            return 32;
         case 32:
         case 33:
            return 64;
         case 34:
            return 324;
         case 35:
            return 176;
         case 36:
            return 256;
         case 37:
         case 38:
            return 260;
         case 39:
         case 40:
            return 128;
      }
   }

   class_70(Function var1, class_137 var2, int var3, int var4, int var5, boolean var6, boolean var7) {
      this(var1, var2, var3, var4, var5, var6, var7, true, true);
   }

   class_70(Function var1, class_137 var2, int var3, int var4, int var5, boolean var6, boolean var7, boolean var8, boolean var9) {
      this.field_204 = var1;
      this.field_205 = var2;
      this.field_206 = var3;
      this.field_207 = var6;
      this.field_208 = var7;
      this.field_209 = var8;
      this.field_210 = var9;
      this.width = var2.method_705("Width");
      this.height = var2.method_705("Height");
      class_124 var10 = class_125.method_666(Application.method_1323().method_1366(), var2.getValueAsString("StackSizeGroup.InventoryStackSizeGroup"));
      if (var10 != null) {
         this.field_211 = var10.method_664();
         this.field_212 = var10.method_665();
      } else {
         switch (method_429()[Application.method_1323().method_1367().ordinal()]) {
            case 1:
            case 3:
            case 4:
            default:
               this.field_211 = 9999;
               this.field_212 = var2.method_706("ProductMaxStorageMultiplier", 10);
               break;
            case 2:
            case 5:
               this.field_211 = 250 * var2.method_706("SubstanceMaxStorageMultiplier", 2);
               this.field_212 = var2.method_706("ProductMaxStorageMultiplier", 10);
         }
      }

      int var11 = Math.max(this.height, var5);
      int var12 = Math.max(this.width, var4);
      this.field_213 = new class_137[var11][];
      this.field_214 = new boolean[var11][];

      for (int var13 = 0; var13 < var11; var13++) {
         this.field_213[var13] = new class_137[var12];
         this.field_214[var13] = new boolean[var12];
      }

      class_142 var19 = var2.method_703("ValidSlotIndices");

      for (int var14 = 0; var14 < var19.size(); var14++) {
         class_137 var15 = var19.method_736(var14);
         int var16 = var15.method_705("X");
         int var17 = var15.method_705("Y");
         if (var16 >= 0 && var16 < var12 && var17 >= 0 && var17 < var11) {
            this.field_214[var17][var16] = true;
         }
      }

      class_142 var20 = var2.method_703("Slots");

      for (int var21 = 0; var21 < var20.size(); var21++) {
         class_137 var22 = var20.method_736(var21);
         int var23 = var22.method_705("Index.X");
         int var18 = var22.method_705("Index.Y");
         if (var23 >= 0 && var23 < var12 && var18 >= 0 && var18 < var11) {
            this.field_213[var18][var23] = var22;
         }
      }
   }

   public String getSimpleName() {
      String[] var1 = (String[])this.field_204.apply(this);
      if (var1.length == 0) {
         return "Unknown";
      } else {
         return var1.length == 1 ? var1[0] : var1[1];
      }
   }

   public String getFullName() {
      String[] var1 = (String[])this.field_204.apply(this);
      if (var1.length == 0) {
         return "Unknown";
      } else {
         return var1.length == 1 ? var1[0] : var1[0] + " - " + var1[1];
      }
   }

   public String getName() {
      return this.field_205.getValueAsString("Name");
   }

   public void setName(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.field_205.method_713("Name", var1);
   }

   // $VF: renamed from: dj () int
   public int method_385() {
      return this.field_206;
   }

   // $VF: renamed from: ay (int) boolean
   public boolean method_386(int var1) {
      return (this.method_385() & var1) != 0;
   }

   // $VF: renamed from: dk () boolean
   public boolean method_387() {
      return this.field_208;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   // $VF: renamed from: ao (java.lang.String) boolean
   boolean method_388(String var1) {
      class_142 var2 = this.field_205.method_703("BaseStatValues");
      if (var2 == null) {
         return false;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            class_137 var4 = var2.method_736(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               return true;
            }
         }

         return false;
      }
   }

   // $VF: renamed from: ak (java.lang.String) double
   double method_389(String var1) {
      class_142 var2 = this.field_205.method_703("BaseStatValues");
      if (var2 == null) {
         return 0.0;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            class_137 var4 = var2.method_736(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               return var4.method_709("Value");
            }
         }

         return 0.0;
      }
   }

   // $VF: renamed from: d (java.lang.String, double) void
   void method_390(String var1, double var2) {
      class_142 var4 = this.field_205.method_703("BaseStatValues");
      if (var4 == null) {
         throw new RuntimeException("Could not set base stat");
      } else {
         boolean var5 = false;

         for (int var6 = 0; var6 < var4.size(); var6++) {
            class_137 var7 = var4.method_736(var6);
            if (var7.getValueAsString("BaseStatID").equals(var1)) {
               var7.method_713("Value", var2);
               var5 = true;
               break;
            }
         }

         if (!var5) {
            class_137 var9 = new class_137();
            var9.method_713("BaseStatID", var1);
            var9.method_713("Value", var2);
            var4.method_744(var9);
            var5 = true;
         }
      }
   }

   // $VF: renamed from: ap (java.lang.String) boolean
   boolean method_391(String var1) {
      class_142 var2 = this.field_205.method_703("BaseStatValues");
      if (var2 == null) {
         return false;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            class_137 var4 = var2.method_736(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               var2.method_745(var3);
               return true;
            }
         }

         return false;
      }
   }

   public Dimension getSize() {
      return new Dimension(this.width, this.height);
   }

   // $VF: renamed from: a (java.awt.Dimension) boolean
   public boolean method_392(Dimension var1) {
      int var2 = 1;
      int var3 = 1;

      for (int var4 = 0; var4 < this.field_213.length; var4++) {
         for (int var5 = 0; var5 < this.field_213[var4].length; var5++) {
            if (this.field_214[var4][var5]) {
               var2 = Math.max(var2, var5 + 1);
               var3 = Math.max(var3, var4 + 1);
            }
         }
      }

      if (var1.width < var2) {
         throw new RuntimeException("Cannot resize less than min width");
      } else if (var1.height < var3) {
         throw new RuntimeException("Cannot resize less than min height");
      } else {
         if (class_130.method_681()) {
            if (var1.width > this.field_214[0].length) {
               for (int var7 = 0; var7 < this.field_213.length; var7++) {
                  class_137[] var10 = new class_137[var1.width];
                  boolean[] var6 = new boolean[var1.width];
                  System.arraycopy(this.field_213[var7], 0, var10, 0, this.field_214[var7].length);
                  System.arraycopy(this.field_214[var7], 0, var6, 0, this.field_214[var7].length);
                  this.field_213[var7] = var10;
                  this.field_214[var7] = var6;
               }
            }

            if (var1.height > this.field_214.length) {
               class_137[][] var8 = new class_137[var1.height][];
               boolean[][] var11 = new boolean[var1.height][];
               System.arraycopy(this.field_213, 0, var8, 0, this.field_214.length);
               System.arraycopy(this.field_214, 0, var11, 0, this.field_214.length);

               for (int var12 = this.field_214.length; var12 < var1.height; var12++) {
                  var8[var12] = new class_137[var1.width];
                  var11[var12] = new boolean[var1.width];
               }

               this.field_213 = var8;
               this.field_214 = var11;
            }
         } else {
            if (var1.width > this.field_214[0].length) {
               throw new RuntimeException("Cannot resize width greater than " + this.field_214[0].length);
            }

            if (var1.height > this.field_214.length) {
               throw new RuntimeException("Cannot resize height greater than " + this.field_214.length);
            }
         }

         boolean var9 = false;
         if (this.width != var1.width) {
            this.width = var1.width;
            this.field_205.method_713("Width", new Integer(this.width));
            var9 = true;
         }

         if (this.height != var1.height) {
            this.height = var1.height;
            this.field_205.method_713("Height", new Integer(this.height));
            var9 = true;
         }

         return var9;
      }
   }

   // $VF: renamed from: dl () boolean
   public boolean method_393() {
      boolean var1 = false;
      if (this.width < this.field_214[0].length) {
         this.width = this.field_214[0].length;
         this.field_205.method_713("Width", new Integer(this.width));
         var1 = true;
      }

      if (this.height < this.field_214.length) {
         this.height = this.field_214.length;
         this.field_205.method_713("Height", new Integer(this.height));
         var1 = true;
      }

      return var1;
   }

   // $VF: renamed from: dm () java.awt.Dimension
   public Dimension method_394() {
      int var1 = 1;
      int var2 = 1;

      for (int var3 = 0; var3 < this.field_213.length; var3++) {
         for (int var4 = 0; var4 < this.field_213[var3].length; var4++) {
            if (this.field_214[var3][var4]) {
               var1 = Math.max(var1, var4 + 1);
               var2 = Math.max(var2, var3 + 1);
            }
         }
      }

      return new Dimension(var1, var2);
   }

   // $VF: renamed from: dn () java.awt.Dimension
   public Dimension method_395() {
      return new Dimension(this.field_214[0].length, this.field_214.length);
   }

   // $VF: renamed from: a (int, int, int, int) void
   public void method_396(int var1, int var2, int var3, int var4) {
      if (!this.field_214[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.field_214[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         class_142 var5 = this.field_205.method_703("Slots");
         if (this.field_213[var4][var3] != null) {
            var5.method_746(this.field_213[var4][var3]);
         }

         if (this.field_213[var2][var1] == null) {
            this.field_213[var4][var3] = null;
         } else {
            class_137 var6 = this.field_213[var2][var1].method_693();
            var6.method_713("Index.X", var3);
            var6.method_713("Index.Y", var4);
            var5.method_744(var6);
            this.field_213[var4][var3] = var6;
         }
      }
   }

   // $VF: renamed from: b (int, int, int, int) void
   public void method_397(int var1, int var2, int var3, int var4) {
      if (!this.field_214[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.field_214[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         class_137 var5 = this.field_213[var2][var1];
         class_137 var6 = this.field_213[var4][var3];
         if (var5 != null && var6 != null && var5.getValue("Id").equals(var6.getValue("Id"))) {
            int var7 = var6.method_705("MaxAmount");
            int var8 = var5.method_705("Amount") + var6.method_705("Amount");
            if (var8 <= var7) {
               var6.method_713("Amount", var8);
               this.method_401(var1, var2);
            } else {
               var6.method_713("Amount", var7);
               var5.method_713("Amount", var8 - var7);
            }
         } else {
            if (var5 != null) {
               var5.method_716("Index", new class_97().method_569("X", var3).method_569("Y", var4).method_570());
            }

            this.field_213[var4][var3] = var5;
            if (var6 != null) {
               var6.method_716("Index", new class_97().method_569("X", var1).method_569("Y", var2).method_570());
            }

            this.field_213[var2][var1] = var6;
         }
      }
   }

   // $VF: renamed from: c (int, int, int, int) void
   public void method_398(int var1, int var2, int var3, int var4) {
      if (!this.field_214[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.field_214[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         class_137 var5 = this.field_213[var2][var1];
         class_137 var6 = this.field_213[var4][var3];
         if (var5 != null) {
            var5.method_716("Index", new class_97().method_569("X", var3).method_569("Y", var4).method_570());
         }

         this.field_213[var4][var3] = var5;
         if (var6 != null) {
            var6.method_716("Index", new class_97().method_569("X", var1).method_569("Y", var2).method_570());
         }

         this.field_213[var2][var1] = var6;
      }
   }

   // $VF: renamed from: f (int, int) nomanssave.gu
   public class_41 method_399(int var1, int var2) {
      return this.field_213[var2][var1] == null ? null : new class_41(this, this.field_213[var2][var1], null);
   }

   // $VF: renamed from: az (int) void
   public void method_400(int var1) {
      class_142 var2 = this.field_205.method_703("Slots");

      for (int var3 = 0; var3 < var2.size(); var3++) {
         class_137 var4 = var2.method_736(var3);
         if (var4.getValueAsString("Type.InventoryType").equals("Technology")) {
            class_152 var5 = class_152.method_795(var4.getValue("Id"));
            if (var5 == null || (method_384(var5.method_779()) & var1) == 0) {
               int var6 = var4.method_705("Index.X");
               int var7 = var4.method_705("Index.Y");
               if (var7 < this.field_213.length && var6 < this.field_213[var7].length) {
                  this.field_213[var7][var6] = null;
               }

               var2.method_745(var3--);
            }
         }
      }
   }

   // $VF: renamed from: g (int, int) boolean
   public boolean method_401(int var1, int var2) {
      if (this.field_213[var2][var1] == null) {
         return false;
      } else {
         class_142 var3 = this.field_205.method_703("Slots");

         for (int var4 = 0; var4 < var3.size(); var4++) {
            class_137 var5 = var3.method_736(var4);
            if (var1 == var5.method_705("Index.X") && var2 == var5.method_705("Index.Y")) {
               var3.method_745(var4);
            }
         }

         this.field_213[var2][var1] = null;
         return true;
      }
   }

   // $VF: renamed from: a (int, int, nomanssave.gt) boolean
   public boolean method_402(int var1, int var2, class_70 var3) {
      if (this.field_213[var2][var1] == null) {
         return false;
      } else {
         String var4 = this.field_213[var2][var1].getValueAsString("Type.InventoryType");
         Object var5 = this.field_213[var2][var1].getValue("Id");
         int var6 = this.field_213[var2][var1].method_705("Amount");
         double var7 = this.field_213[var2][var1].method_709("DamageFactor");
         boolean var9 = this.field_213[var2][var1].method_711("FullyInstalled");
         boolean var10 = false;
         if (var4.equals("Technology")) {
            int var11 = this.field_213[var2][var1].method_705("MaxAmount");

            for (int var12 = 0; var12 < var3.field_213.length; var12++) {
               for (int var13 = 0; var13 < var3.field_213[var12].length; var13++) {
                  if (var3.field_213[var12][var13] == null && var3.field_214[var12][var13] && !var3.method_416(var13, var12)) {
                     var3.method_405(var13, var12, var4, var5, var6, var11, var7, var9);
                     var6 = 0;
                     var10 = true;
                     break;
                  }
               }

               if (var6 == 0) {
                  break;
               }
            }
         }

         if (var6 > 0 && !var4.equals("Technology")) {
            for (int var16 = 0; var16 < var3.field_213.length; var16++) {
               for (int var19 = 0; var19 < var3.field_213[var16].length; var19++) {
                  if (var3.field_213[var16][var19] != null
                     && var4.equals(var3.field_213[var16][var19].getValueAsString("Type.InventoryType"))
                     && var5.equals(var3.field_213[var16][var19].getValue("Id"))) {
                     int var22 = var3.field_213[var16][var19].method_705("Amount");
                     int var14 = var3.field_213[var16][var19].method_705("MaxAmount");
                     if (var22 < var14) {
                        int var15 = var6 > var14 - var22 ? var14 - var22 : var6;
                        class_37.info("  added to existing stack: " + var15);
                        var3.field_213[var16][var19].method_713("Amount", new Integer(var22 + var15));
                        var6 -= var15;
                        var10 = true;
                        if (var6 == 0) {
                           break;
                        }
                     }
                  }
               }

               if (var6 == 0) {
                  break;
               }
            }
         }

         if (var6 > 0 && !var4.equals("Technology")) {
            class_152 var17 = class_152.method_795(this.field_213[var2][var1].getValue("Id"));
            int var20;
            if (var4.equals("Technology")) {
               var20 = this.field_213[var2][var1].method_705("MaxAmount");
            } else if (var4.equals("Substance")) {
               if (var17 == null) {
                  var20 = var3.field_211;
               } else {
                  var20 = Math.max(1, var3.field_211 * var17.method_788());
               }
            } else if (var4.equals("Product")) {
               if (var17 == null) {
                  var20 = var3.field_212;
               } else {
                  var20 = Math.max(1, var3.field_212 * var17.method_788());
               }
            } else {
               var20 = 1;
            }

            for (int var23 = 0; var23 < var3.field_213.length; var23++) {
               for (int var25 = 0; var25 < var3.field_213[var23].length; var25++) {
                  if (var3.field_213[var23][var25] == null && var3.field_214[var23][var25] && !var3.method_416(var25, var23)) {
                     int var26 = var6 > var20 ? var20 : var6;
                     class_37.info("  new stack: " + var26);
                     var3.method_405(var25, var23, var4, var5, var26, var20, var7, var9);
                     var6 -= var26;
                     var10 = true;
                     if (var6 == 0) {
                        break;
                     }
                  }
               }

               if (var6 == 0) {
                  break;
               }
            }
         }

         if (!var10) {
            return false;
         } else {
            if (var6 == 0) {
               class_142 var18 = this.field_205.method_703("Slots");

               for (int var21 = 0; var21 < var18.size(); var21++) {
                  class_137 var24 = var18.method_736(var21);
                  if (var1 == var24.method_705("Index.X") && var2 == var24.method_705("Index.Y")) {
                     var18.method_745(var21);
                  }
               }

               this.field_213[var2][var1] = null;
            } else {
               class_37.info("  remainder: " + var6);
               this.field_213[var2][var1].method_713("Amount", new Integer(var6));
            }

            return true;
         }
      }
   }

   // $VF: renamed from: a (nomanssave.ey, int) int
   public int method_403(class_152 var1, int var2) {
      int var3;
      String var4;
      switch (method_430()[var1.method_777().ordinal()]) {
         case 1:
            return var2;
         case 2:
            var3 = Math.max(1, this.field_212 * var1.method_788());
            var4 = "Product";
            break;
         case 3:
            var3 = Math.max(1, this.field_211 * var1.method_788());
            var4 = "Substance";
            break;
         case 4:
            var3 = Math.max(1, this.field_212 * var1.method_788());
            var4 = "Techbox";
            break;
         default:
            return var2;
      }

      if (var2 > 0) {
         for (int var5 = 0; var5 < this.field_213.length; var5++) {
            for (int var6 = 0; var6 < this.field_213[var5].length; var6++) {
               if (this.field_213[var5][var6] != null
                  && var4.equals(this.field_213[var5][var6].getValueAsString("Type.InventoryType"))
                  && var1.getID().equals(this.field_213[var5][var6].getValue("Id"))) {
                  int var7 = this.field_213[var5][var6].method_705("Amount");
                  int var8 = this.field_213[var5][var6].method_705("MaxAmount");
                  if (var7 < var8) {
                     int var9 = var2 > var8 - var7 ? var8 - var7 : var2;
                     class_37.info("  added to existing stack: " + var9);
                     this.field_213[var5][var6].method_713("Amount", new Integer(var7 + var9));
                     var2 -= var9;
                     if (var2 == 0) {
                        break;
                     }
                  }
               }
            }

            if (var2 == 0) {
               break;
            }
         }
      }

      if (var2 > 0) {
         Object var10 = var1.method_775();

         for (int var11 = 0; var11 < this.field_213.length; var11++) {
            for (int var12 = 0; var12 < this.field_213[var11].length; var12++) {
               if (this.field_213[var11][var12] == null && this.field_214[var11][var12] && !this.method_416(var12, var11)) {
                  int var13 = var2 > var3 ? var3 : var2;
                  class_37.info("  new stack: " + var13);
                  this.method_405(var12, var11, var4, var10, var13, var3, 0.0, true);
                  var2 -= var13;
                  if (var2 == 0) {
                     break;
                  }
               }
            }

            if (var2 == 0) {
               break;
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: a (int, int, nomanssave.ey) boolean
   public boolean method_404(int var1, int var2, class_152 var3) {
      if (this.field_213[var2][var1] != null) {
         return false;
      } else {
         int var4;
         int var5;
         switch (method_430()[var3.method_777().ordinal()]) {
            case 1:
               Integer var6 = var3.method_782();
               if (var6 == null) {
                  var4 = -1;
                  var5 = 1;
               } else {
                  var4 = var6;
                  var5 = var6;
               }
               break;
            case 2:
               var5 = Math.max(1, this.field_212 * var3.method_788());
               var4 = var5;
               break;
            case 3:
               var5 = Math.max(1, this.field_211 * var3.method_788());
               var4 = var5;
               break;
            case 4:
               var5 = Math.max(1, this.field_212 * var3.method_788());
               var4 = var5;
               break;
            default:
               return false;
         }

         Object var7 = var3.method_775();
         this.method_405(var1, var2, var3.method_777().toString(), var7, var4, var5, 0.0, true);
         return true;
      }
   }

   // $VF: renamed from: a (int, int, java.lang.String, java.lang.Object, int, int, double, boolean) void
   private void method_405(int var1, int var2, String var3, Object var4, int var5, int var6, double var7, boolean var9) {
      class_142 var10 = this.field_205.method_703("Slots");
      class_137 var11 = class_67.method_367("slot");
      var11.method_713("Type.InventoryType", var3);
      var11.method_713("Id", var4);
      var11.method_713("Amount", new Integer(var5));
      var11.method_713("MaxAmount", new Integer(var6));
      var11.method_713("DamageFactor", new Double(var7));
      var11.method_713("FullyInstalled", new Boolean(var9));
      var11.method_713("Index.X", var1);
      var11.method_713("Index.Y", var2);
      var10.method_744(var11);
      this.field_213[var2][var1] = var11;
   }

   // $VF: renamed from: aq (java.lang.String) boolean
   public boolean method_406(String var1) {
      for (int var2 = 0; var2 < this.field_213.length; var2++) {
         for (int var3 = 0; var3 < this.field_213[var2].length; var3++) {
            if (this.field_213[var2][var3] != null && var1.equals(this.field_213[var2][var3].getValue("Type"))) {
               return true;
            }
         }
      }

      return false;
   }

   // $VF: renamed from: h (int, int) boolean
   public boolean method_407(int var1, int var2) {
      return this.field_214[var2][var1];
   }

   // $VF: renamed from: i (int, int) void
   public void method_408(int var1, int var2) {
      if (!this.field_214[var2][var1]) {
         class_137 var3 = new class_137();
         var3.method_713("X", var1);
         var3.method_713("Y", var2);
         this.field_205.method_703("ValidSlotIndices").method_744(var3);
         this.field_214[var2][var1] = true;
      }
   }

   // $VF: renamed from: j (int, int) void
   public void method_409(int var1, int var2) {
      if (this.field_214[var2][var1]) {
         if (this.field_213[var2][var1] != null) {
            throw new RuntimeException("Cannot disable slot in use");
         }

         class_142 var3 = this.field_205.method_703("ValidSlotIndices");

         for (int var4 = 0; var4 < var3.size(); var4++) {
            class_137 var5 = var3.method_736(var4);
            if (var1 == var5.method_705("X") && var2 == var5.method_705("Y")) {
               var3.method_745(var4);
            }
         }

         this.field_214[var2][var1] = false;
      }
   }

   // $VF: renamed from: do () boolean
   public boolean method_410() {
      return this.field_207;
   }

   // $VF: renamed from: dp () boolean
   public boolean method_411() {
      return this.field_209;
   }

   // $VF: renamed from: dq () boolean
   public boolean method_412() {
      return this.field_210;
   }

   // $VF: renamed from: k (int, int) boolean
   public boolean method_413(int var1, int var2) {
      class_142 var3 = this.field_205.method_703("SpecialSlots");

      for (int var4 = 0; var4 < var3.size(); var4++) {
         class_137 var5 = var3.method_736(var4);
         if (var5.method_705("Index.X") == var1 && var5.method_705("Index.Y") == var2) {
            return "TechBonus".equals(var5.getValueAsString("Type.InventorySpecialSlotType"));
         }
      }

      return false;
   }

   // $VF: renamed from: a (int, int, boolean) void
   public void method_414(int var1, int var2, boolean var3) {
      class_142 var4 = this.field_205.method_703("SpecialSlots");

      for (int var5 = 0; var5 < var4.size(); var5++) {
         class_137 var6 = var4.method_736(var5);
         if (var6.method_705("Index.X") == var1 && var6.method_705("Index.Y") == var2) {
            if (!var3) {
               var4.method_745(var5);
            } else {
               var6.method_713("Type.InventorySpecialSlotType", "TechBonus");
            }

            return;
         }
      }

      if (var3) {
         class_137 var7 = class_67.method_367("specialSlot");
         var7.method_713("Type.InventorySpecialSlotType", "TechBonus");
         var7.method_713("Index.X", var1);
         var7.method_713("Index.Y", var2);
         var4.method_744(var7);
      }
   }

   // $VF: renamed from: dr () boolean
   public boolean method_415() {
      boolean[][] var1 = new boolean[this.height][this.width];
      class_142 var2 = this.field_205.method_703("SpecialSlots");

      for (int var3 = 0; var3 < var2.size(); var3++) {
         class_137 var4 = var2.method_736(var3);
         int var5 = var4.method_705("Index.X");
         int var6 = var4.method_705("Index.Y");
         if (var5 < this.width && var6 < this.height) {
            var1[var6][var5] = "TechBonus".equals(var4.getValueAsString("Type.InventorySpecialSlotType"));
         }
      }

      boolean var7 = false;

      for (int var8 = 0; var8 < this.height; var8++) {
         for (int var9 = 0; var9 < this.width; var9++) {
            if (!var1[var8][var9]) {
               class_137 var10 = class_67.method_367("specialSlot");
               var10.method_713("Type.InventorySpecialSlotType", "TechBonus");
               var10.method_713("Index.X", var9);
               var10.method_713("Index.Y", var8);
               var2.method_744(var10);
               var7 = true;
            }
         }
      }

      return var7;
   }

   // $VF: renamed from: l (int, int) boolean
   public boolean method_416(int var1, int var2) {
      class_142 var3 = this.field_205.method_703("SpecialSlots");

      for (int var5 = 0; var5 < var3.size(); var5++) {
         class_137 var6 = var3.method_736(var5);
         if ("Broken".equals(var6.getValueAsString("Type.InventorySpecialSlotType"))
            && var1 == var6.method_705("Index.X")
            && var2 == var6.method_705("Index.Y")) {
            return true;
         }

         if ("BlockedByBrokenTech".equals(var6.getValueAsString("Type.InventorySpecialSlotType"))
            && var1 == var6.method_705("Index.X")
            && var2 == var6.method_705("Index.Y")) {
            class_41 var4;
            if ((var4 = this.method_399(var1, var2)) != null && var4.method_218() != 0.0) {
               return true;
            }

            class_37.info(this.getFullName() + " slot[" + var1 + "," + var2 + "] appears to be broken, ignoring");
            return false;
         }
      }

      return false;
   }

   // $VF: renamed from: m (int, int) void
   public void method_417(int var1, int var2) {
      class_142 var3 = this.field_205.method_703("SpecialSlots");

      for (int var5 = 0; var5 < var3.size(); var5++) {
         class_137 var6 = var3.method_736(var5);
         if ("Broken".equals(var6.getValueAsString("Type.InventorySpecialSlotType"))
            && var1 == var6.method_705("Index.X")
            && var2 == var6.method_705("Index.Y")) {
            var3.method_745(var5);
         }

         if ("BlockedByBrokenTech".equals(var6.getValueAsString("Type.InventorySpecialSlotType"))
            && var1 == var6.method_705("Index.X")
            && var2 == var6.method_705("Index.Y")) {
            class_41 var4;
            if ((var4 = this.method_399(var1, var2)) != null && var4.method_218() != 0.0) {
               this.method_401(var1, var2);
            }

            var3.method_745(var5);
         }
      }
   }

   // $VF: renamed from: ds () boolean
   public boolean method_418() {
      boolean var1 = false;
      class_142 var3 = this.field_205.method_703("SpecialSlots");

      for (int var4 = 0; var4 < var3.size(); var4++) {
         class_137 var5 = var3.method_736(var4);
         if ("Broken".equals(var5.getValueAsString("Type.InventorySpecialSlotType"))) {
            var3.method_745(var4--);
            var1 = true;
         }

         if ("BlockedByBrokenTech".equals(var5.getValueAsString("Type.InventorySpecialSlotType"))) {
            class_41 var2;
            if ((var2 = this.method_399(var5.method_705("Index.X"), var5.method_705("Index.Y"))) != null && var2.method_218() != 0.0) {
               this.method_401(var5.method_705("Index.X"), var5.method_705("Index.Y"));
            }

            var3.method_745(var4--);
            var1 = true;
         }
      }

      for (int var6 = 0; var6 < this.field_213.length; var6++) {
         for (int var7 = 0; var7 < this.field_213[var6].length; var7++) {
            if (this.field_213[var6][var7] != null && this.field_213[var6][var7].method_709("DamageFactor") != 0.0) {
               this.field_213[var6][var7].method_713("DamageFactor", new Double(0.0));
               this.field_213[var6][var7].method_713("FullyInstalled", new Boolean(true));
               var1 = true;
            }
         }
      }

      return var1;
   }

   // $VF: renamed from: l (java.lang.Object) java.lang.String
   private static String method_419(Object var0) {
      StringBuffer var1 = new StringBuffer();
      var1.append(' ');
      if (var0 instanceof class_95) {
         var1.append(((class_95)var0).method_551());
      } else if (var0 != null) {
         var1.append(var0.toString());
      }

      if (var1.length() > 10) {
         var1.delete(10, var1.length());
      }

      while (var1.length() < 11) {
         var1.append(' ');
      }

      return var1.toString();
   }

   // $VF: renamed from: a (java.io.PrintStream) void
   public void method_420(PrintStream var1) {
      var1.print("\t|");

      for (int var2 = 0; var2 < this.field_213[0].length; var2++) {
         var1.print("-----------|");
      }

      var1.println();

      for (int var5 = 0; var5 < this.field_213.length; var5++) {
         var1.print("\t|");

         for (int var3 = 0; var3 < this.field_213[0].length; var3++) {
            if (!this.field_214[var5][var3]) {
               var1.print("###########|");
            } else if (this.field_213[var5][var3] != null) {
               var1.print(method_419(method_421(this.field_213[var5][var3])) + "|");
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var6 = 0; var6 < this.field_213[var5].length; var6++) {
            if (!this.field_214[var5][var6]) {
               var1.print("###########|");
            } else if (this.field_213[var5][var6] != null) {
               var1.print(method_419(method_422(this.field_213[var5][var6])) + "|");
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var7 = 0; var7 < this.field_213[0].length; var7++) {
            if (!this.field_214[var5][var7]) {
               var1.print("###########|");
            } else if (this.field_213[var5][var7] != null) {
               int var4 = method_423(this.field_213[var5][var7]);
               if (var4 < 0) {
                  var1.print("           |");
               } else {
                  var1.print(method_419(Integer.toString(var4) + "/" + Integer.toString(method_424(this.field_213[var5][var7]))) + "|");
               }
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var8 = 0; var8 < this.field_213[0].length; var8++) {
            var1.print("-----------|");
         }

         var1.println();
      }
   }

   // $VF: renamed from: r (nomanssave.eY) java.lang.String
   private static String method_421(class_137 var0) {
      return var0.getValueAsString("Type.InventoryType");
   }

   // $VF: renamed from: s (nomanssave.eY) java.lang.Object
   private static Object method_422(class_137 var0) {
      return var0.getValue("Id");
   }

   // $VF: renamed from: t (nomanssave.eY) int
   private static int method_423(class_137 var0) {
      return var0.method_705("Amount");
   }

   // $VF: renamed from: u (nomanssave.eY) int
   private static int method_424(class_137 var0) {
      return var0.method_705("MaxAmount");
   }

   // $VF: renamed from: dt () boolean
   public boolean method_425() {
      boolean var2 = false;

      for (int var3 = 0; var3 < this.field_213.length; var3++) {
         for (int var4 = 0; var4 < this.field_213[var3].length; var4++) {
            int var1;
            if (this.field_213[var3][var4] != null
               && "Technology".equals(this.field_213[var3][var4].getValueAsString("Type.InventoryType"))
               && this.field_213[var3][var4].method_705("Amount") >= 0
               && (var1 = this.field_213[var3][var4].method_705("MaxAmount")) > 0) {
               this.field_213[var3][var4].method_713("Amount", new Integer(var1));
               var2 = true;
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: du () boolean
   public boolean method_426() {
      boolean var2 = false;

      for (int var3 = 0; var3 < this.field_213.length; var3++) {
         for (int var4 = 0; var4 < this.field_213[var3].length; var4++) {
            int var1;
            if (this.field_213[var3][var4] != null
               && !"Technology".equals(this.field_213[var3][var4].getValueAsString("Type.InventoryType"))
               && (var1 = this.field_213[var3][var4].method_705("MaxAmount")) > 1) {
               this.field_213[var3][var4].method_713("Amount", new Integer(var1));
               var2 = true;
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: dv () boolean
   public boolean method_427() {
      boolean var1 = false;

      for (int var2 = 0; var2 < this.height; var2++) {
         for (int var3 = 0; var3 < this.width; var3++) {
            if (!this.field_214[var2][var3]) {
               class_137 var4 = new class_137();
               var4.method_713("X", var3);
               var4.method_713("Y", var2);
               this.field_205.method_703("ValidSlotIndices").method_744(var4);
               this.field_214[var2][var3] = true;
               var1 = true;
            }
         }
      }

      return var1;
   }

   @Override
   public String toString() {
      return this.getFullName();
   }
}
