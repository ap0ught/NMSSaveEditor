package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

// $VF: renamed from: nomanssave.gc
public class class_50 {
   // $VF: renamed from: nc long
   private static final long field_131 = -11644473600000L;

   // $VF: renamed from: a (java.io.InputStream) java.lang.String
   public static String method_309(InputStream var0) {
      byte[] var1 = new byte[16];
      class_31.readFully(var0, var1);
      return method_311(var1);
   }

   // $VF: renamed from: cA () java.lang.String
   public static String method_310() {
      byte[] var0 = new byte[16];
      new SecureRandom().nextBytes(var0);
      return method_311(var0);
   }

   // $VF: renamed from: h (byte[]) java.lang.String
   private static String method_311(byte[] var0) {
      StringBuilder var1 = new StringBuilder();
      method_312(var0[3], var1);
      method_312(var0[2], var1);
      method_312(var0[1], var1);
      method_312(var0[0], var1);
      method_312(var0[5], var1);
      method_312(var0[4], var1);
      method_312(var0[7], var1);
      method_312(var0[6], var1);
      method_312(var0[8], var1);
      method_312(var0[9], var1);
      method_312(var0[10], var1);
      method_312(var0[11], var1);
      method_312(var0[12], var1);
      method_312(var0[13], var1);
      method_312(var0[14], var1);
      method_312(var0[15], var1);
      return var1.toString();
   }

   // $VF: renamed from: a (byte, java.lang.StringBuilder) void
   private static void method_312(byte var0, StringBuilder var1) {
      int var2 = (240 & var0) >> 4;
      int var3 = 15 & var0;
      var1.append("0123456789ABCDEF".charAt(var2));
      var1.append("0123456789ABCDEF".charAt(var3));
   }

   // $VF: renamed from: a (java.io.OutputStream, java.lang.String) void
   public static void method_313(OutputStream var0, String var1) {
      if (var1.length() > 32) {
         throw new IOException("invalid container path");
      } else {
         while (var1.length() < 32) {
            var1 = "0" + var1;
         }

         var1 = var1.toLowerCase();
         byte[] var2 = new byte[16];
         var2[3] = (byte)Integer.parseInt(var1.substring(0, 2), 16);
         var2[2] = (byte)Integer.parseInt(var1.substring(2, 4), 16);
         var2[1] = (byte)Integer.parseInt(var1.substring(4, 6), 16);
         var2[0] = (byte)Integer.parseInt(var1.substring(6, 8), 16);
         var2[5] = (byte)Integer.parseInt(var1.substring(8, 10), 16);
         var2[4] = (byte)Integer.parseInt(var1.substring(10, 12), 16);
         var2[7] = (byte)Integer.parseInt(var1.substring(12, 14), 16);
         var2[6] = (byte)Integer.parseInt(var1.substring(14, 16), 16);
         var2[8] = (byte)Integer.parseInt(var1.substring(16, 18), 16);
         var2[9] = (byte)Integer.parseInt(var1.substring(18, 20), 16);
         var2[10] = (byte)Integer.parseInt(var1.substring(20, 22), 16);
         var2[11] = (byte)Integer.parseInt(var1.substring(22, 24), 16);
         var2[12] = (byte)Integer.parseInt(var1.substring(24, 26), 16);
         var2[13] = (byte)Integer.parseInt(var1.substring(26, 28), 16);
         var2[14] = (byte)Integer.parseInt(var1.substring(28, 30), 16);
         var2[15] = (byte)Integer.parseInt(var1.substring(30, 32), 16);
         var0.write(var2);
      }
   }

   // $VF: renamed from: b (java.io.InputStream) long
   public static long method_314(InputStream var0) {
      return class_31.method_119(var0) / 10000L + -11644473600000L;
   }

   // $VF: renamed from: a (java.io.OutputStream, long) void
   public static void method_315(OutputStream var0, long var1) {
      class_31.method_120(var0, (var1 - -11644473600000L) * 10000L);
   }

   // $VF: renamed from: c (java.io.InputStream) java.lang.String
   public static String method_316(InputStream var0) {
      int var1 = class_31.readInt(var0);
      if (var1 < 0) {
         throw new IOException("negative length");
      } else {
         byte[] var2 = new byte[var1 * 2];
         class_31.readFully(var0, var2);
         return new String(var2, "UTF-16LE");
      }
   }

   // $VF: renamed from: b (java.io.OutputStream, java.lang.String) void
   public static void method_317(OutputStream var0, String var1) {
      class_31.method_118(var0, var1.length());
      var0.write(var1.getBytes("UTF-16LE"));
   }

   // $VF: renamed from: d (java.io.InputStream) java.lang.String
   public static String method_318(InputStream var0) {
      byte[] var1 = new byte[128];
      class_31.readFully(var0, var1);
      byte var2 = 0;

      while (var2 < var1.length && (var1[var2] != 0 || var1[var2 + 1] != 0)) {
         var2 += 2;
      }

      return new String(var1, 0, var2, "UTF-16LE");
   }

   // $VF: renamed from: e (java.io.InputStream) java.lang.String
   public static String method_319(InputStream var0) {
      byte[] var1 = new byte[128];
      class_31.readFully(var0, var1);
      int var2 = 0;

      while (var2 < var1.length && var1[var2] != 0) {
         var2++;
      }

      return new String(var1, 0, var2, "UTF-8");
   }

   // $VF: renamed from: c (java.io.OutputStream, java.lang.String) void
   public static void method_320(OutputStream var0, String var1) {
      byte[] var2 = var1.getBytes("UTF-8");
      if (var2.length < 128) {
         byte[] var3 = new byte[128];
         System.arraycopy(var2, 0, var3, 0, var2.length);
         var3[var2.length] = 0;
         var2 = var3;
      }

      var0.write(var2, 0, 128);
   }
}
