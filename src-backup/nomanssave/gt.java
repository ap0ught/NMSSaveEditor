package nomanssave;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.function.Function;

public class gt {
   public static final int pW = 1;
   public static final int pX = 2;
   public static final int pY = 4;
   public static final int pZ = 8;
   public static final int qa = 16;
   public static final int qb = 32;
   public static final int qc = 64;
   public static final int qd = 128;
   public static final int qe = 256;
   public static final int qf = 324;
   public static final int qg = 176;
   public static final int qh = 260;
   public static final int qi = 511;
   public static final int qj = 512;
   public static final int qk = 1024;
   public static final int ql = 2048;
   public static final int qm = 3584;
   public static final int qn = 8192;
   public static final int qo = 16384;
   public static final int qp = 32768;
   public static final int qq = 8;
   public static final int qr = 6;
   private final Function qs;
   private final eY qt;
   private final int r;
   private final boolean qu;
   private final boolean qv;
   private final boolean qw;
   private final boolean qx;
   private int width;
   private int height;
   private int bE;
   private int bF;
   private eY[][] qy;
   private boolean[][] qz;

   public static int a(ex var0) {
      switch (dw()[var0.ordinal()]) {
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

   gt(Function var1, eY var2, int var3, int var4, int var5, boolean var6, boolean var7) {
      this(var1, var2, var3, var4, var5, var6, var7, true, true);
   }

   gt(Function var1, eY var2, int var3, int var4, int var5, boolean var6, boolean var7, boolean var8, boolean var9) {
      this.qs = var1;
      this.qt = var2;
      this.r = var3;
      this.qu = var6;
      this.qv = var7;
      this.qw = var8;
      this.qx = var9;
      this.width = var2.J("Width");
      this.height = var2.J("Height");
      ew var10 = eu.b(Application.e().E(), var2.getValueAsString("StackSizeGroup.InventoryStackSizeGroup"));
      if (var10 != null) {
         this.bE = var10.aX();
         this.bF = var10.aY();
      } else {
         switch (dx()[Application.e().F().ordinal()]) {
            case 1:
            case 3:
            case 4:
            default:
               this.bE = 9999;
               this.bF = var2.c("ProductMaxStorageMultiplier", 10);
               break;
            case 2:
            case 5:
               this.bE = 250 * var2.c("SubstanceMaxStorageMultiplier", 2);
               this.bF = var2.c("ProductMaxStorageMultiplier", 10);
         }
      }

      int var11 = Math.max(this.height, var5);
      int var12 = Math.max(this.width, var4);
      this.qy = new eY[var11][];
      this.qz = new boolean[var11][];

      for (int var13 = 0; var13 < var11; var13++) {
         this.qy[var13] = new eY[var12];
         this.qz[var13] = new boolean[var12];
      }

      eV var19 = var2.d("ValidSlotIndices");

      for (int var14 = 0; var14 < var19.size(); var14++) {
         eY var15 = var19.V(var14);
         int var16 = var15.J("X");
         int var17 = var15.J("Y");
         if (var16 >= 0 && var16 < var12 && var17 >= 0 && var17 < var11) {
            this.qz[var17][var16] = true;
         }
      }

      eV var20 = var2.d("Slots");

      for (int var21 = 0; var21 < var20.size(); var21++) {
         eY var22 = var20.V(var21);
         int var23 = var22.J("Index.X");
         int var18 = var22.J("Index.Y");
         if (var23 >= 0 && var23 < var12 && var18 >= 0 && var18 < var11) {
            this.qy[var18][var23] = var22;
         }
      }
   }

   public String getSimpleName() {
      String[] var1 = (String[])this.qs.apply(this);
      if (var1.length == 0) {
         return "Unknown";
      } else {
         return var1.length == 1 ? var1[0] : var1[1];
      }
   }

   public String getFullName() {
      String[] var1 = (String[])this.qs.apply(this);
      if (var1.length == 0) {
         return "Unknown";
      } else {
         return var1.length == 1 ? var1[0] : var1[0] + " - " + var1[1];
      }
   }

   public String getName() {
      return this.qt.getValueAsString("Name");
   }

   public void setName(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.qt.b("Name", var1);
   }

   public int dj() {
      return this.r;
   }

   public boolean ay(int var1) {
      return (this.dj() & var1) != 0;
   }

   public boolean dk() {
      return this.qv;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   boolean ao(String var1) {
      eV var2 = this.qt.d("BaseStatValues");
      if (var2 == null) {
         return false;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            eY var4 = var2.V(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               return true;
            }
         }

         return false;
      }
   }

   double ak(String var1) {
      eV var2 = this.qt.d("BaseStatValues");
      if (var2 == null) {
         return 0.0;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            eY var4 = var2.V(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               return var4.L("Value");
            }
         }

         return 0.0;
      }
   }

   void d(String var1, double var2) {
      eV var4 = this.qt.d("BaseStatValues");
      if (var4 == null) {
         throw new RuntimeException("Could not set base stat");
      } else {
         boolean var5 = false;

         for (int var6 = 0; var6 < var4.size(); var6++) {
            eY var7 = var4.V(var6);
            if (var7.getValueAsString("BaseStatID").equals(var1)) {
               var7.b("Value", var2);
               var5 = true;
               break;
            }
         }

         if (!var5) {
            eY var9 = new eY();
            var9.b("BaseStatID", var1);
            var9.b("Value", var2);
            var4.f(var9);
            var5 = true;
         }
      }
   }

   boolean ap(String var1) {
      eV var2 = this.qt.d("BaseStatValues");
      if (var2 == null) {
         return false;
      } else {
         for (int var3 = 0; var3 < var2.size(); var3++) {
            eY var4 = var2.V(var3);
            if (var4.getValueAsString("BaseStatID").equals(var1)) {
               var2.ac(var3);
               return true;
            }
         }

         return false;
      }
   }

   public Dimension getSize() {
      return new Dimension(this.width, this.height);
   }

   public boolean a(Dimension var1) {
      int var2 = 1;
      int var3 = 1;

      for (int var4 = 0; var4 < this.qy.length; var4++) {
         for (int var5 = 0; var5 < this.qy[var4].length; var5++) {
            if (this.qz[var4][var5]) {
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
         if (en.aS()) {
            if (var1.width > this.qz[0].length) {
               for (int var7 = 0; var7 < this.qy.length; var7++) {
                  eY[] var10 = new eY[var1.width];
                  boolean[] var6 = new boolean[var1.width];
                  System.arraycopy(this.qy[var7], 0, var10, 0, this.qz[var7].length);
                  System.arraycopy(this.qz[var7], 0, var6, 0, this.qz[var7].length);
                  this.qy[var7] = var10;
                  this.qz[var7] = var6;
               }
            }

            if (var1.height > this.qz.length) {
               eY[][] var8 = new eY[var1.height][];
               boolean[][] var11 = new boolean[var1.height][];
               System.arraycopy(this.qy, 0, var8, 0, this.qz.length);
               System.arraycopy(this.qz, 0, var11, 0, this.qz.length);

               for (int var12 = this.qz.length; var12 < var1.height; var12++) {
                  var8[var12] = new eY[var1.width];
                  var11[var12] = new boolean[var1.width];
               }

               this.qy = var8;
               this.qz = var11;
            }
         } else {
            if (var1.width > this.qz[0].length) {
               throw new RuntimeException("Cannot resize width greater than " + this.qz[0].length);
            }

            if (var1.height > this.qz.length) {
               throw new RuntimeException("Cannot resize height greater than " + this.qz.length);
            }
         }

         boolean var9 = false;
         if (this.width != var1.width) {
            this.width = var1.width;
            this.qt.b("Width", new Integer(this.width));
            var9 = true;
         }

         if (this.height != var1.height) {
            this.height = var1.height;
            this.qt.b("Height", new Integer(this.height));
            var9 = true;
         }

         return var9;
      }
   }

   public boolean dl() {
      boolean var1 = false;
      if (this.width < this.qz[0].length) {
         this.width = this.qz[0].length;
         this.qt.b("Width", new Integer(this.width));
         var1 = true;
      }

      if (this.height < this.qz.length) {
         this.height = this.qz.length;
         this.qt.b("Height", new Integer(this.height));
         var1 = true;
      }

      return var1;
   }

   public Dimension dm() {
      int var1 = 1;
      int var2 = 1;

      for (int var3 = 0; var3 < this.qy.length; var3++) {
         for (int var4 = 0; var4 < this.qy[var3].length; var4++) {
            if (this.qz[var3][var4]) {
               var1 = Math.max(var1, var4 + 1);
               var2 = Math.max(var2, var3 + 1);
            }
         }
      }

      return new Dimension(var1, var2);
   }

   public Dimension dn() {
      return new Dimension(this.qz[0].length, this.qz.length);
   }

   public void a(int var1, int var2, int var3, int var4) {
      if (!this.qz[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.qz[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         eV var5 = this.qt.d("Slots");
         if (this.qy[var4][var3] != null) {
            var5.g(this.qy[var4][var3]);
         }

         if (this.qy[var2][var1] == null) {
            this.qy[var4][var3] = null;
         } else {
            eY var6 = this.qy[var2][var1].bE();
            var6.b("Index.X", var3);
            var6.b("Index.Y", var4);
            var5.f(var6);
            this.qy[var4][var3] = var6;
         }
      }
   }

   public void b(int var1, int var2, int var3, int var4) {
      if (!this.qz[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.qz[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         eY var5 = this.qy[var2][var1];
         eY var6 = this.qy[var4][var3];
         if (var5 != null && var6 != null && var5.getValue("Id").equals(var6.getValue("Id"))) {
            int var7 = var6.J("MaxAmount");
            int var8 = var5.J("Amount") + var6.J("Amount");
            if (var8 <= var7) {
               var6.b("Amount", var8);
               this.g(var1, var2);
            } else {
               var6.b("Amount", var7);
               var5.b("Amount", var8 - var7);
            }
         } else {
            if (var5 != null) {
               var5.b("Index", new fa().d("X", var3).d("Y", var4).bH());
            }

            this.qy[var4][var3] = var5;
            if (var6 != null) {
               var6.b("Index", new fa().d("X", var1).d("Y", var2).bH());
            }

            this.qy[var2][var1] = var6;
         }
      }
   }

   public void c(int var1, int var2, int var3, int var4) {
      if (!this.qz[var2][var1]) {
         throw new RuntimeException("Old slot not enabled");
      } else if (!this.qz[var4][var3]) {
         throw new RuntimeException("New slot not enabled");
      } else {
         eY var5 = this.qy[var2][var1];
         eY var6 = this.qy[var4][var3];
         if (var5 != null) {
            var5.b("Index", new fa().d("X", var3).d("Y", var4).bH());
         }

         this.qy[var4][var3] = var5;
         if (var6 != null) {
            var6.b("Index", new fa().d("X", var1).d("Y", var2).bH());
         }

         this.qy[var2][var1] = var6;
      }
   }

   public gu f(int var1, int var2) {
      return this.qy[var2][var1] == null ? null : new gu(this, this.qy[var2][var1], null);
   }

   public void az(int var1) {
      eV var2 = this.qt.d("Slots");

      for (int var3 = 0; var3 < var2.size(); var3++) {
         eY var4 = var2.V(var3);
         if (var4.getValueAsString("Type.InventoryType").equals("Technology")) {
            ey var5 = ey.d(var4.getValue("Id"));
            if (var5 == null || (a(var5.bc()) & var1) == 0) {
               int var6 = var4.J("Index.X");
               int var7 = var4.J("Index.Y");
               if (var7 < this.qy.length && var6 < this.qy[var7].length) {
                  this.qy[var7][var6] = null;
               }

               var2.ac(var3--);
            }
         }
      }
   }

   public boolean g(int var1, int var2) {
      if (this.qy[var2][var1] == null) {
         return false;
      } else {
         eV var3 = this.qt.d("Slots");

         for (int var4 = 0; var4 < var3.size(); var4++) {
            eY var5 = var3.V(var4);
            if (var1 == var5.J("Index.X") && var2 == var5.J("Index.Y")) {
               var3.ac(var4);
            }
         }

         this.qy[var2][var1] = null;
         return true;
      }
   }

   public boolean a(int var1, int var2, gt var3) {
      if (this.qy[var2][var1] == null) {
         return false;
      } else {
         String var4 = this.qy[var2][var1].getValueAsString("Type.InventoryType");
         Object var5 = this.qy[var2][var1].getValue("Id");
         int var6 = this.qy[var2][var1].J("Amount");
         double var7 = this.qy[var2][var1].L("DamageFactor");
         boolean var9 = this.qy[var2][var1].M("FullyInstalled");
         boolean var10 = false;
         if (var4.equals("Technology")) {
            int var11 = this.qy[var2][var1].J("MaxAmount");

            for (int var12 = 0; var12 < var3.qy.length; var12++) {
               for (int var13 = 0; var13 < var3.qy[var12].length; var13++) {
                  if (var3.qy[var12][var13] == null && var3.qz[var12][var13] && !var3.l(var13, var12)) {
                     var3.a(var13, var12, var4, var5, var6, var11, var7, var9);
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
            for (int var16 = 0; var16 < var3.qy.length; var16++) {
               for (int var19 = 0; var19 < var3.qy[var16].length; var19++) {
                  if (var3.qy[var16][var19] != null
                     && var4.equals(var3.qy[var16][var19].getValueAsString("Type.InventoryType"))
                     && var5.equals(var3.qy[var16][var19].getValue("Id"))) {
                     int var22 = var3.qy[var16][var19].J("Amount");
                     int var14 = var3.qy[var16][var19].J("MaxAmount");
                     if (var22 < var14) {
                        int var15 = var6 > var14 - var22 ? var14 - var22 : var6;
                        hc.info("  added to existing stack: " + var15);
                        var3.qy[var16][var19].b("Amount", new Integer(var22 + var15));
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
            ey var17 = ey.d(this.qy[var2][var1].getValue("Id"));
            int var20;
            if (var4.equals("Technology")) {
               var20 = this.qy[var2][var1].J("MaxAmount");
            } else if (var4.equals("Substance")) {
               if (var17 == null) {
                  var20 = var3.bE;
               } else {
                  var20 = Math.max(1, var3.bE * var17.bj());
               }
            } else if (var4.equals("Product")) {
               if (var17 == null) {
                  var20 = var3.bF;
               } else {
                  var20 = Math.max(1, var3.bF * var17.bj());
               }
            } else {
               var20 = 1;
            }

            for (int var23 = 0; var23 < var3.qy.length; var23++) {
               for (int var25 = 0; var25 < var3.qy[var23].length; var25++) {
                  if (var3.qy[var23][var25] == null && var3.qz[var23][var25] && !var3.l(var25, var23)) {
                     int var26 = var6 > var20 ? var20 : var6;
                     hc.info("  new stack: " + var26);
                     var3.a(var25, var23, var4, var5, var26, var20, var7, var9);
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
               eV var18 = this.qt.d("Slots");

               for (int var21 = 0; var21 < var18.size(); var21++) {
                  eY var24 = var18.V(var21);
                  if (var1 == var24.J("Index.X") && var2 == var24.J("Index.Y")) {
                     var18.ac(var21);
                  }
               }

               this.qy[var2][var1] = null;
            } else {
               hc.info("  remainder: " + var6);
               this.qy[var2][var1].b("Amount", new Integer(var6));
            }

            return true;
         }
      }
   }

   public int a(ey var1, int var2) {
      int var3;
      String var4;
      switch (dy()[var1.ba().ordinal()]) {
         case 1:
            return var2;
         case 2:
            var3 = Math.max(1, this.bF * var1.bj());
            var4 = "Product";
            break;
         case 3:
            var3 = Math.max(1, this.bE * var1.bj());
            var4 = "Substance";
            break;
         case 4:
            var3 = Math.max(1, this.bF * var1.bj());
            var4 = "Techbox";
            break;
         default:
            return var2;
      }

      if (var2 > 0) {
         for (int var5 = 0; var5 < this.qy.length; var5++) {
            for (int var6 = 0; var6 < this.qy[var5].length; var6++) {
               if (this.qy[var5][var6] != null
                  && var4.equals(this.qy[var5][var6].getValueAsString("Type.InventoryType"))
                  && var1.getID().equals(this.qy[var5][var6].getValue("Id"))) {
                  int var7 = this.qy[var5][var6].J("Amount");
                  int var8 = this.qy[var5][var6].J("MaxAmount");
                  if (var7 < var8) {
                     int var9 = var2 > var8 - var7 ? var8 - var7 : var2;
                     hc.info("  added to existing stack: " + var9);
                     this.qy[var5][var6].b("Amount", new Integer(var7 + var9));
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
         Object var10 = var1.aZ();

         for (int var11 = 0; var11 < this.qy.length; var11++) {
            for (int var12 = 0; var12 < this.qy[var11].length; var12++) {
               if (this.qy[var11][var12] == null && this.qz[var11][var12] && !this.l(var12, var11)) {
                  int var13 = var2 > var3 ? var3 : var2;
                  hc.info("  new stack: " + var13);
                  this.a(var12, var11, var4, var10, var13, var3, 0.0, true);
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

   public boolean a(int var1, int var2, ey var3) {
      if (this.qy[var2][var1] != null) {
         return false;
      } else {
         int var4;
         int var5;
         switch (dy()[var3.ba().ordinal()]) {
            case 1:
               Integer var6 = var3.bf();
               if (var6 == null) {
                  var4 = -1;
                  var5 = 1;
               } else {
                  var4 = var6;
                  var5 = var6;
               }
               break;
            case 2:
               var5 = Math.max(1, this.bF * var3.bj());
               var4 = var5;
               break;
            case 3:
               var5 = Math.max(1, this.bE * var3.bj());
               var4 = var5;
               break;
            case 4:
               var5 = Math.max(1, this.bF * var3.bj());
               var4 = var5;
               break;
            default:
               return false;
         }

         Object var7 = var3.aZ();
         this.a(var1, var2, var3.ba().toString(), var7, var4, var5, 0.0, true);
         return true;
      }
   }

   private void a(int var1, int var2, String var3, Object var4, int var5, int var6, double var7, boolean var9) {
      eV var10 = this.qt.d("Slots");
      eY var11 = gR.az("slot");
      var11.b("Type.InventoryType", var3);
      var11.b("Id", var4);
      var11.b("Amount", new Integer(var5));
      var11.b("MaxAmount", new Integer(var6));
      var11.b("DamageFactor", new Double(var7));
      var11.b("FullyInstalled", new Boolean(var9));
      var11.b("Index.X", var1);
      var11.b("Index.Y", var2);
      var10.f(var11);
      this.qy[var2][var1] = var11;
   }

   public boolean aq(String var1) {
      for (int var2 = 0; var2 < this.qy.length; var2++) {
         for (int var3 = 0; var3 < this.qy[var2].length; var3++) {
            if (this.qy[var2][var3] != null && var1.equals(this.qy[var2][var3].getValue("Type"))) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean h(int var1, int var2) {
      return this.qz[var2][var1];
   }

   public void i(int var1, int var2) {
      if (!this.qz[var2][var1]) {
         eY var3 = new eY();
         var3.b("X", var1);
         var3.b("Y", var2);
         this.qt.d("ValidSlotIndices").f(var3);
         this.qz[var2][var1] = true;
      }
   }

   public void j(int var1, int var2) {
      if (this.qz[var2][var1]) {
         if (this.qy[var2][var1] != null) {
            throw new RuntimeException("Cannot disable slot in use");
         }

         eV var3 = this.qt.d("ValidSlotIndices");

         for (int var4 = 0; var4 < var3.size(); var4++) {
            eY var5 = var3.V(var4);
            if (var1 == var5.J("X") && var2 == var5.J("Y")) {
               var3.ac(var4);
            }
         }

         this.qz[var2][var1] = false;
      }
   }

   public boolean doMethod() {
      return this.qu;
   }

   public boolean dp() {
      return this.qw;
   }

   public boolean dq() {
      return this.qx;
   }

   public boolean k(int var1, int var2) {
      eV var3 = this.qt.d("SpecialSlots");

      for (int var4 = 0; var4 < var3.size(); var4++) {
         eY var5 = var3.V(var4);
         if (var5.J("Index.X") == var1 && var5.J("Index.Y") == var2) {
            return "TechBonus".equals(var5.getValueAsString("Type.InventorySpecialSlotType"));
         }
      }

      return false;
   }

   public void a(int var1, int var2, boolean var3) {
      eV var4 = this.qt.d("SpecialSlots");

      for (int var5 = 0; var5 < var4.size(); var5++) {
         eY var6 = var4.V(var5);
         if (var6.J("Index.X") == var1 && var6.J("Index.Y") == var2) {
            if (!var3) {
               var4.ac(var5);
            } else {
               var6.b("Type.InventorySpecialSlotType", "TechBonus");
            }

            return;
         }
      }

      if (var3) {
         eY var7 = gR.az("specialSlot");
         var7.b("Type.InventorySpecialSlotType", "TechBonus");
         var7.b("Index.X", var1);
         var7.b("Index.Y", var2);
         var4.f(var7);
      }
   }

   public boolean dr() {
      boolean[][] var1 = new boolean[this.height][this.width];
      eV var2 = this.qt.d("SpecialSlots");

      for (int var3 = 0; var3 < var2.size(); var3++) {
         eY var4 = var2.V(var3);
         int var5 = var4.J("Index.X");
         int var6 = var4.J("Index.Y");
         if (var5 < this.width && var6 < this.height) {
            var1[var6][var5] = "TechBonus".equals(var4.getValueAsString("Type.InventorySpecialSlotType"));
         }
      }

      boolean var7 = false;

      for (int var8 = 0; var8 < this.height; var8++) {
         for (int var9 = 0; var9 < this.width; var9++) {
            if (!var1[var8][var9]) {
               eY var10 = gR.az("specialSlot");
               var10.b("Type.InventorySpecialSlotType", "TechBonus");
               var10.b("Index.X", var9);
               var10.b("Index.Y", var8);
               var2.f(var10);
               var7 = true;
            }
         }
      }

      return var7;
   }

   public boolean l(int var1, int var2) {
      eV var3 = this.qt.d("SpecialSlots");

      for (int var5 = 0; var5 < var3.size(); var5++) {
         eY var6 = var3.V(var5);
         if ("Broken".equals(var6.getValueAsString("Type.InventorySpecialSlotType")) && var1 == var6.J("Index.X") && var2 == var6.J("Index.Y")) {
            return true;
         }

         if ("BlockedByBrokenTech".equals(var6.getValueAsString("Type.InventorySpecialSlotType")) && var1 == var6.J("Index.X") && var2 == var6.J("Index.Y")) {
            gu var4;
            if ((var4 = this.f(var1, var2)) != null && var4.dC() != 0.0) {
               return true;
            }

            hc.info(this.getFullName() + " slot[" + var1 + "," + var2 + "] appears to be broken, ignoring");
            return false;
         }
      }

      return false;
   }

   public void m(int var1, int var2) {
      eV var3 = this.qt.d("SpecialSlots");

      for (int var5 = 0; var5 < var3.size(); var5++) {
         eY var6 = var3.V(var5);
         if ("Broken".equals(var6.getValueAsString("Type.InventorySpecialSlotType")) && var1 == var6.J("Index.X") && var2 == var6.J("Index.Y")) {
            var3.ac(var5);
         }

         if ("BlockedByBrokenTech".equals(var6.getValueAsString("Type.InventorySpecialSlotType")) && var1 == var6.J("Index.X") && var2 == var6.J("Index.Y")) {
            gu var4;
            if ((var4 = this.f(var1, var2)) != null && var4.dC() != 0.0) {
               this.g(var1, var2);
            }

            var3.ac(var5);
         }
      }
   }

   public boolean ds() {
      boolean var1 = false;
      eV var3 = this.qt.d("SpecialSlots");

      for (int var4 = 0; var4 < var3.size(); var4++) {
         eY var5 = var3.V(var4);
         if ("Broken".equals(var5.getValueAsString("Type.InventorySpecialSlotType"))) {
            var3.ac(var4--);
            var1 = true;
         }

         if ("BlockedByBrokenTech".equals(var5.getValueAsString("Type.InventorySpecialSlotType"))) {
            gu var2;
            if ((var2 = this.f(var5.J("Index.X"), var5.J("Index.Y"))) != null && var2.dC() != 0.0) {
               this.g(var5.J("Index.X"), var5.J("Index.Y"));
            }

            var3.ac(var4--);
            var1 = true;
         }
      }

      for (int var6 = 0; var6 < this.qy.length; var6++) {
         for (int var7 = 0; var7 < this.qy[var6].length; var7++) {
            if (this.qy[var6][var7] != null && this.qy[var6][var7].L("DamageFactor") != 0.0) {
               this.qy[var6][var7].b("DamageFactor", new Double(0.0));
               this.qy[var6][var7].b("FullyInstalled", new Boolean(true));
               var1 = true;
            }
         }
      }

      return var1;
   }

   private static String l(Object var0) {
      StringBuffer var1 = new StringBuffer();
      var1.append(' ');
      if (var0 instanceof fg) {
         var1.append(((fg)var0).bP());
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

   public void a(PrintStream var1) {
      var1.print("\t|");

      for (int var2 = 0; var2 < this.qy[0].length; var2++) {
         var1.print("-----------|");
      }

      var1.println();

      for (int var5 = 0; var5 < this.qy.length; var5++) {
         var1.print("\t|");

         for (int var3 = 0; var3 < this.qy[0].length; var3++) {
            if (!this.qz[var5][var3]) {
               var1.print("###########|");
            } else if (this.qy[var5][var3] != null) {
               var1.print(l(r(this.qy[var5][var3])) + "|");
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var6 = 0; var6 < this.qy[var5].length; var6++) {
            if (!this.qz[var5][var6]) {
               var1.print("###########|");
            } else if (this.qy[var5][var6] != null) {
               var1.print(l(s(this.qy[var5][var6])) + "|");
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var7 = 0; var7 < this.qy[0].length; var7++) {
            if (!this.qz[var5][var7]) {
               var1.print("###########|");
            } else if (this.qy[var5][var7] != null) {
               int var4 = t(this.qy[var5][var7]);
               if (var4 < 0) {
                  var1.print("           |");
               } else {
                  var1.print(l(Integer.toString(var4) + "/" + Integer.toString(u(this.qy[var5][var7]))) + "|");
               }
            } else {
               var1.print("           |");
            }
         }

         var1.println();
         var1.print("\t|");

         for (int var8 = 0; var8 < this.qy[0].length; var8++) {
            var1.print("-----------|");
         }

         var1.println();
      }
   }

   private static String r(eY var0) {
      return var0.getValueAsString("Type.InventoryType");
   }

   private static Object s(eY var0) {
      return var0.getValue("Id");
   }

   private static int t(eY var0) {
      return var0.J("Amount");
   }

   private static int u(eY var0) {
      return var0.J("MaxAmount");
   }

   public boolean dt() {
      boolean var2 = false;

      for (int var3 = 0; var3 < this.qy.length; var3++) {
         for (int var4 = 0; var4 < this.qy[var3].length; var4++) {
            int var1;
            if (this.qy[var3][var4] != null
               && "Technology".equals(this.qy[var3][var4].getValueAsString("Type.InventoryType"))
               && this.qy[var3][var4].J("Amount") >= 0
               && (var1 = this.qy[var3][var4].J("MaxAmount")) > 0) {
               this.qy[var3][var4].b("Amount", new Integer(var1));
               var2 = true;
            }
         }
      }

      return var2;
   }

   public boolean du() {
      boolean var2 = false;

      for (int var3 = 0; var3 < this.qy.length; var3++) {
         for (int var4 = 0; var4 < this.qy[var3].length; var4++) {
            int var1;
            if (this.qy[var3][var4] != null
               && !"Technology".equals(this.qy[var3][var4].getValueAsString("Type.InventoryType"))
               && (var1 = this.qy[var3][var4].J("MaxAmount")) > 1) {
               this.qy[var3][var4].b("Amount", new Integer(var1));
               var2 = true;
            }
         }
      }

      return var2;
   }

   public boolean dv() {
      boolean var1 = false;

      for (int var2 = 0; var2 < this.height; var2++) {
         for (int var3 = 0; var3 < this.width; var3++) {
            if (!this.qz[var2][var3]) {
               eY var4 = new eY();
               var4.b("X", var3);
               var4.b("Y", var2);
               this.qt.d("ValidSlotIndices").f(var4);
               this.qz[var2][var3] = true;
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
