package nomanssave;

import java.math.BigDecimal;
import java.math.RoundingMode;

// $VF: renamed from: nomanssave.gT
public class class_65 {
   // $VF: renamed from: rT int
   static final int field_170 = 12;
   // $VF: renamed from: rU double
   private static final double field_171 = 0.1;
   // $VF: renamed from: rV double[]
   private final double[] field_172;
   // $VF: renamed from: rW double[]
   private final double[] field_173;
   // $VF: renamed from: rX double[]
   private final double[] field_174;

   // $VF: renamed from: b (double[]) double[]
   private static double[] method_346(double[] var0) {
      double var1 = Math.sqrt(var0[0] * var0[0] + var0[1] * var0[1] + var0[2] * var0[2]);
      if (var1 < 0.1) {
         throw new RuntimeException("vector cannot be normalized");
      } else {
         return new double[]{var0[0] / var1, var0[1] / var1, var0[2] / var1};
      }
   }

   public class_65() {
      this.field_174 = new double[]{0.0, 0.0, 1.0};
      this.field_173 = new double[]{0.0, 1.0, 0.0};
      this.field_172 = new double[]{1.0, 0.0, 0.0};
   }

   public class_65(double[] var1, double[] var2) {
      double var3 = Math.sqrt(var1[0] * var1[0] + var1[1] * var1[1] + var1[2] * var1[2]);
      if (var3 < 0.1) {
         if (var2[0] != 0.0 || var2[1] != 0.0 || var2[2] != 1.0) {
            throw new RuntimeException("Unable to calculate base structures");
         }

         this.field_174 = new double[]{0.0, 0.0, 1.0};
         this.field_173 = new double[]{0.0, 1.0, 0.0};
         this.field_172 = new double[]{1.0, 0.0, 0.0};
      } else {
         var1 = new double[]{var1[0] / var3, var1[1] / var3, var1[2] / var3};
         var2 = method_346(var2);
         double var5 = var2[0] * var1[0] + var2[1] * var1[1] + var2[2] * var1[2];
         this.field_174 = var2;
         this.field_173 = method_346(new double[]{var1[0] - var5 * var2[0], var1[1] - var5 * var2[1], var1[2] - var5 * var2[2]});
         this.field_172 = method_346(
            new double[]{
               this.field_173[1] * var2[2] - this.field_173[2] * var2[1],
               this.field_173[2] * var2[0] - this.field_173[0] * var2[2],
               this.field_173[0] * var2[1] - this.field_173[1] * var2[0]
            }
         );
      }
   }

   // $VF: renamed from: a (double, double[], double[]) double[]
   private static double[] method_347(double var0, double[] var2, double[] var3) {
      double var4 = Math.cos(var0);
      double var6 = -Math.sin(var0);
      double var8 = var3[0];
      double var10 = var3[1];
      double var12 = var3[2];
      double[][] var14 = new double[3][3];
      var14[0][0] = var8 * var8 * (1.0 - var4) + var4;
      var14[0][1] = var8 * var10 * (1.0 - var4) + var12 * var6;
      var14[0][2] = var8 * var12 * (1.0 - var4) - var10 * var6;
      var14[1][0] = var8 * var10 * (1.0 - var4) - var12 * var6;
      var14[1][1] = var10 * var10 * (1.0 - var4) + var4;
      var14[1][2] = var10 * var12 * (1.0 - var4) + var8 * var6;
      var14[2][0] = var8 * var12 * (1.0 - var4) + var10 * var6;
      var14[2][1] = var10 * var12 * (1.0 - var4) - var8 * var6;
      var14[2][2] = var12 * var12 * (1.0 - var4) + var4;
      double var15 = var2[0] * var14[0][0] + var2[1] * var14[1][0] + var2[2] * var14[2][0];
      double var17 = var2[0] * var14[0][1] + var2[1] * var14[1][1] + var2[2] * var14[2][1];
      double var19 = var2[0] * var14[0][2] + var2[1] * var14[1][2] + var2[2] * var14[2][2];
      double var21 = Math.sqrt(var15 * var15 + var17 * var17 + var19 * var19);
      return new double[]{var15 / var21, var17 / var21, var19 / var21};
   }

   // $VF: renamed from: a (nomanssave.gU) double[]
   public double[] method_348(class_64 var1) {
      if (var1.field_168.equals("fr")) {
         return method_347(var1.field_169, this.field_174, this.field_172);
      } else if (var1.field_168.equals("fu")) {
         return method_347(var1.field_169, this.field_174, this.field_173);
      } else if (var1.field_168.equals("ur")) {
         return method_347(var1.field_169, this.field_173, this.field_172);
      } else if (var1.field_168.equals("uf")) {
         return method_347(var1.field_169, this.field_173, this.field_174);
      } else if (var1.field_168.equals("ru")) {
         return method_347(var1.field_169, this.field_172, this.field_173);
      } else if (var1.field_168.equals("rf")) {
         return method_347(var1.field_169, this.field_172, this.field_174);
      } else {
         throw new RuntimeException("Unsupported rotation axis");
      }
   }

   // $VF: renamed from: c (double[]) double[]
   public double[] method_349(double[] var1) {
      double var2 = var1[0] * this.field_172[0] + var1[1] * this.field_173[0] + var1[2] * this.field_174[0];
      double var4 = var1[0] * this.field_172[1] + var1[1] * this.field_173[1] + var1[2] * this.field_174[1];
      double var6 = var1[0] * this.field_172[2] + var1[1] * this.field_173[2] + var1[2] * this.field_174[2];
      return new double[]{var2, var4, var6};
   }

   // $VF: renamed from: d (double[]) double[]
   public double[] method_350(double[] var1) {
      double var2 = var1[0] * this.field_172[0] + var1[1] * this.field_172[1] + var1[2] * this.field_172[2];
      double var4 = var1[0] * this.field_173[0] + var1[1] * this.field_173[1] + var1[2] * this.field_173[2];
      double var6 = var1[0] * this.field_174[0] + var1[1] * this.field_174[1] + var1[2] * this.field_174[2];
      return new double[]{var2, var4, var6};
   }

   // $VF: renamed from: a (double[], java.lang.StringBuffer, java.lang.StringBuffer, java.lang.StringBuffer, int) void
   private void method_351(double[] var1, StringBuffer var2, StringBuffer var3, StringBuffer var4, int var5) {
      int var6 = var2.length();
      var2.append(method_357(var1[0], var5));
      var3.append(method_357(var1[1], var5));
      var4.append(method_357(var1[2], var5));
      int var7 = Math.max(Math.max(var2.length(), var3.length()), var4.length());

      while (var2.length() < var7) {
         var2.insert(var6, ' ');
      }

      while (var3.length() < var7) {
         var3.insert(var6, ' ');
      }

      while (var4.length() < var7) {
         var4.insert(var6, ' ');
      }
   }

   // $VF: renamed from: a (java.lang.StringBuffer, java.lang.StringBuffer, java.lang.StringBuffer, int) void
   private void method_352(StringBuffer var1, StringBuffer var2, StringBuffer var3, int var4) {
      int var5 = Math.max(Math.max(var1.length(), var2.length()), var3.length());

      while (var1.length() < var5) {
         var1.append(' ');
      }

      while (var2.length() < var5) {
         var2.append(' ');
      }

      while (var3.length() < var5) {
         var3.append(' ');
      }

      var1.append("| ");
      var2.append("| ");
      var3.append("| ");
      this.method_351(this.field_172, var1, var2, var3, var4);
      var1.append(' ');
      var2.append(' ');
      var3.append(' ');
      this.method_351(this.field_173, var1, var2, var3, var4);
      var1.append(' ');
      var2.append(' ');
      var3.append(' ');
      this.method_351(this.field_174, var1, var2, var3, var4);
      var1.append(" |");
      var2.append(" |");
      var3.append(" |");
   }

   @Override
   public String toString() {
      return this.toString(12);
   }

   public String toString(int var1) {
      StringBuffer var2 = new StringBuffer();
      StringBuffer var3 = new StringBuffer();
      StringBuffer var4 = new StringBuffer();
      this.method_352(var2, var3, var4, var1);
      StringBuffer var5 = new StringBuffer();
      var5.append(var2).append("\n");
      var5.append(var3).append("\n");
      var5.append(var4).append("\n");
      return var5.toString();
   }

   // $VF: renamed from: e (double[]) java.lang.String
   static String method_353(double[] var0) {
      return method_354(var0, 12);
   }

   // $VF: renamed from: a (double[], int) java.lang.String
   static String method_354(double[] var0, int var1) {
      return "[ " + method_358(var0[0], var1) + " , " + method_358(var0[1], var1) + " , " + method_358(var0[2], var1) + " ]";
   }

   // $VF: renamed from: f (double[]) java.lang.String
   static String method_355(double[] var0) {
      return method_356(var0, 12);
   }

   // $VF: renamed from: b (double[], int) java.lang.String
   static String method_356(double[] var0, int var1) {
      return "[ "
         + method_358(var0[0], var1)
         + " , "
         + method_358(var0[1], var1)
         + " , "
         + method_358(var0[2], var1)
         + " , "
         + method_358(var0[3], var1)
         + " ]";
   }

   // $VF: renamed from: a (double, int) java.lang.String
   static String method_357(double var0, int var2) {
      if (Double.isInfinite(var0)) {
         return "Infinite";
      } else if (Double.isNaN(var0)) {
         return "NaN";
      } else {
         BigDecimal var3 = new BigDecimal(var0);
         var3 = var3.setScale(var2, RoundingMode.HALF_UP);
         return var3.toPlainString();
      }
   }

   // $VF: renamed from: b (double, int) java.lang.String
   static String method_358(double var0, int var2) {
      if (Double.isInfinite(var0)) {
         return "Infinite";
      } else if (Double.isNaN(var0)) {
         return "NaN";
      } else {
         BigDecimal var3 = new BigDecimal(var0);
         var3 = var3.setScale(var2, RoundingMode.HALF_UP);
         String var4 = var3.toPlainString();
         if (var2 <= 0) {
            return var4;
         } else {
            while (var4.endsWith("0") && !var4.endsWith(".0")) {
               var4 = var4.substring(0, var4.length() - 1);
            }

            return var4;
         }
      }
   }
}
