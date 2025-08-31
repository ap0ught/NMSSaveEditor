package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fu
public class class_87 implements class_7 {
   // $VF: renamed from: lA byte[]
   private static final byte[] field_259 = "NOMANSKY".getBytes();
   // $VF: renamed from: lB byte[]
   private static final byte[] field_260 = new byte[]{126, -25, 85, -54, -47, 7, 0, 0};
   // $VF: renamed from: lC java.util.regex.Pattern
   private static final Pattern field_261 = Pattern.compile("\\{\"Version\":(\\d*),.*");
   // $VF: renamed from: lD java.io.File
   private final File field_262;
   // $VF: renamed from: lE nomanssave.fR
   private class_3 field_263;
   // $VF: renamed from: lF nomanssave.fw[]
   private class_85[] field_264;
   // $VF: renamed from: lG nomanssave.fv
   private class_86 field_265;
   // $VF: renamed from: lH nomanssave.fx[]
   private class_84[] field_266;

   // $VF: renamed from: ag (int) nomanssave.fn
   public static class_294 method_491(int var0) {
      int var1 = (3584 & var0) >> 9;
      if (var1 <= 0 && var1 > class_294.values().length) {
         throw new RuntimeException("Unsupported version: " + var0);
      } else {
         return class_294.values()[var1 - 1];
      }
   }

   class_87(File var1, class_3 var2) {
      this.field_262 = var1.isFile() ? var1 : new File(var1, "memory.dat");
      this.field_263 = var2;
      System.out.println(this.field_262.getAbsolutePath());
      FileInputStream var3 = new FileInputStream(this.field_262);

      try {
         long var4 = 0L;
         System.out.println("Reading header");
         byte[] var6 = new byte[8];
         class_31.readFully(var3, var6);
         var4 += (long)var6.length;
         if (!method_492(var6, field_259)) {
            throw new IOException("Invalid header");
         }

         int[] var7 = new int[14];

         for (int var8 = 0; var8 < var7.length; var8++) {
            var7[var8] = class_31.readInt(var3);
            var4 += 4L;
            if (var7[var8] != 0) {
               System.out.println("  ints[" + var8 + "] = " + var7[var8] + " 0x" + Integer.toHexString(var7[var8]) + " " + Integer.toBinaryString(var7[var8]));
            }
         }

         System.out.println("Reading files");
         this.field_264 = new class_85[32];

         for (int var22 = 0; var22 < this.field_264.length; var22++) {
            this.field_264[var22] = new class_85(this, var3);
            if (this.field_264[var22].isValid()) {
               System.out.println("file[" + var22 + "]");
               this.field_264[var22].method_488();
            }

            var4 += 48L;
         }

         for (int var23 = 0; var23 < this.field_264.length; var23++) {
            if (this.field_264[var23].isValid()) {
               var3.skip(this.field_264[var23].field_252 - var4);
               var4 = this.field_264[var23].field_252;
               byte[] var9 = new byte[20];
               int var10 = var3.read(var9);
               String var11 = new String(var9, 0, var10, "ISO-8859-1");
               Matcher var12 = field_261.matcher(var11);
               if (var12.matches()) {
                  try {
                     this.field_264[var23].field_245 = method_491(Integer.parseInt(var12.group(1)));
                  } catch (RuntimeException var17) {
                  }
               }

               var4 += (long)var10;
            }
         }
      } finally {
         var3.close();
      }

      this.field_265 = null;
      this.field_266 = new class_84[30];

      for (int var21 = 0; var21 < this.field_264.length; var21++) {
         if (this.field_264[var21].isValid()) {
            if (this.field_264[var21].field_249 == 262144 && this.field_265 == null) {
               this.field_265 = new class_86(this, this.field_264[var21]);
            }

            if (this.field_264[var21].field_249 == 3145728 && this.field_264[var21].field_250 >= 2) {
               this.field_266[this.field_264[var21].field_250 - 2] = new class_84(this, this.field_264[var21]);
            }
         }
      }

      class_91.method_502(this, this.field_262.getParentFile());
   }

   // $VF: renamed from: bS () java.io.File
   @Override
   public File method_17() {
      return this.field_262;
   }

   // $VF: renamed from: bT () nomanssave.fr
   @Override
   public class_8 method_18() {
      return this.field_265;
   }

   // $VF: renamed from: bU () nomanssave.ft[]
   @Override
   public class_10[] method_19() {
      class_10[] var1 = new class_10[15];

      for (int var2 = 0; var2 < 15; var2++) {
         var1[var2] = new class_83(this, var2);
      }

      return var1;
   }

   // $VF: renamed from: W (java.lang.String) int
   @Override
   public int method_21(String var1) {
      return -1;
   }

   // $VF: renamed from: X (java.lang.String) void
   @Override
   public void method_24(String var1) {
      var1.equals(this.field_262.getName());
   }

   public static void main(String[] var0) {
      new class_87(new File("D:\\Temp\\PS4_NEW"), null);
   }

   // $VF: renamed from: a (byte[], byte[]) boolean
   private static boolean method_492(byte[] var0, byte[] var1) {
      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var0[var2] != var1[var2]) {
            return false;
         }
      }

      return true;
   }
}
