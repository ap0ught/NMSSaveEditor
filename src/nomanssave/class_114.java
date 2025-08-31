package nomanssave;

import java.io.IOException;

// $VF: renamed from: nomanssave.fI
public class class_114 {
   // $VF: renamed from: mi int
   private static final int field_380 = 2001;
   // $VF: renamed from: mj int
   private static final int field_381 = 2002;
   // $VF: renamed from: mk int
   private static final int field_382 = 2003;
   // $VF: renamed from: ml int
   private static final int field_383 = 2004;
   // $VF: renamed from: mm int
   private static final int field_384 = 6;
   // $VF: renamed from: mn int
   private static final int field_385 = 2004;
   // $VF: renamed from: mo int
   private static final int field_386 = 384;
   // $VF: renamed from: mp int
   private final int field_387;
   // $VF: renamed from: lO int
   private final int field_388;
   // $VF: renamed from: mq int
   private int field_389;
   private byte[] data;

   // $VF: renamed from: ai (int) boolean
   private static final boolean method_627(int var0) {
      return var0 == 2001 || var0 == 2002 || var0 == 2003 || var0 == 2004;
   }

   private class_114(int var1, int var2, int var3, byte[] var4) {
      this.field_387 = var1;
      this.field_388 = var2;
      this.field_389 = var3;
      this.data = var4;
   }

   // $VF: renamed from: cc () int
   public int method_628() {
      return this.field_388;
   }

   // $VF: renamed from: cd () int
   public int method_629() {
      return this.field_389;
   }

   // $VF: renamed from: ce () boolean
   public boolean method_630() {
      if (this.field_389 == 2001) {
         return false;
      } else {
         if (this.data.length < 376) {
            byte[] var1 = new byte[376];
            System.arraycopy(this.data, 0, var1, 0, this.data.length);
            this.data = var1;
         }

         this.field_389 = 2004;
         return true;
      }
   }

   // $VF: renamed from: cf () byte[]
   public byte[] method_631() {
      return this.method_646(24, 32);
   }

   // $VF: renamed from: e (byte[]) void
   public void method_632(byte[] var1) {
      if (var1.length != 32) {
         throw new IllegalArgumentException("SHA-256 must be 32 bytes");
      } else {
         this.setBytes(24, var1);
      }
   }

   // $VF: renamed from: cg () byte[]
   public byte[] method_633() {
      return this.method_646(8, 16);
   }

   // $VF: renamed from: f (byte[]) void
   public void method_634(byte[] var1) {
      if (var1.length != 16) {
         throw new IllegalArgumentException("SpookyHash must be 16 bytes");
      } else {
         this.setBytes(8, var1);
      }
   }

   // $VF: renamed from: ch () int
   public int method_635() {
      return this.getInt(56);
   }

   // $VF: renamed from: aj (int) void
   public void method_636(int var1) {
      this.setInt(56, var1);
   }

   // $VF: renamed from: ci () int
   public int method_637() {
      return this.getInt(60);
   }

   // $VF: renamed from: ak (int) void
   public void method_638(int var1) {
      this.setInt(60, var1);
   }

   // $VF: renamed from: cj () int
   public int method_639() {
      return this.getInt(76);
   }

   // $VF: renamed from: al (int) void
   public void method_640(int var1) {
      this.setInt(76, var1);
   }

   // $VF: renamed from: ck () java.lang.String
   public String method_641() {
      switch (this.field_389) {
         case 2002:
         case 2003:
         case 2004:
            return this.getString(88);
         default:
            return null;
      }
   }

   // $VF: renamed from: Y (java.lang.String) void
   public void method_642(String var1) {
      switch (this.field_389) {
         case 2002:
         case 2003:
         case 2004:
            this.setString(216, var1);
            return;
      }
   }

   public String getDescription() {
      switch (this.field_389) {
         case 2002:
         case 2003:
         case 2004:
            return this.getString(88);
         default:
            return null;
      }
   }

   public void setDescription(String var1) {
      switch (this.field_389) {
         case 2002:
         case 2003:
         case 2004:
            this.setString(216, var1);
            return;
      }
   }

   // $VF: renamed from: am (int) nomanssave.fI
   public static class_114 method_643(int var0) {
      return new class_114(6, var0, 2004, new byte[376]);
   }

   // $VF: renamed from: a (int, byte[]) nomanssave.fI
   public static class_114 method_644(int var0, byte[] var1) {
      return method_645(var0, var1, 0, var1.length);
   }

   // $VF: renamed from: a (int, byte[], int, int) nomanssave.fI
   public static class_114 method_645(int var0, byte[] var1, int var2, int var3) {
      if (var3 >= 8 && var3 % 4 == 0) {
         int var4 = var3 == 104 ? 8 : 6;
         long[] var5 = method_649(var1, var2, var3);
         long var6 = 0L;

         for (int var8 = 0; var8 < var4; var8++) {
            var6 += 2654435769L;
            var6 &= 4294967295L;
         }

         int var22 = var5.length - 1;
         long var9 = (long)(var0 + 2) ^ 337824652L;
         byte[] var11 = "NAESEVADNAYRTNRG".getBytes("US-ASCII");
         long[] var12 = method_648(var11);
         var12[0] = rotateLeft(var9, 13) * 5L + 3864292196L & 4294967295L;

         for (int var13 = 0; var13 < var4; var13++) {
            int var14 = (int)(var6 >>> 2 & 3L);
            long var15 = var5[0];
            int var17 = var22;
            long var18 = 0L;

            for (int var20 = var22; var20 > 0; var20--) {
               var18 = var15 >> 3 ^ (var5[var17 - 1] & 268435455L) << 4;
               var18 += var15 * 4L & 4294967295L ^ var5[var17 - 1] >> 5;
               var18 ^= (var5[var17 - 1] ^ var12[var20 & 3 ^ var14]) + (var15 ^ var6);
               var5[var17] = var5[var17] - var18 & 4294967295L;
               var15 = var5[var17--];
            }

            var18 = var15 >> 3 ^ (var5[var22] & 268435455L) << 4;
            var18 += var15 * 4L & 4294967295L ^ var5[var22] >> 5;
            var18 ^= (var5[var22] ^ var12[var14]) + (var15 ^ var6);
            var5[0] = var5[0] - var18 & 4294967295L;
            var6 += 1640531527L;
         }

         if (var5[0] != 4008636094L) {
            throw new IOException("Invalid metadata header: " + Long.toHexString(var5[0]));
         } else {
            int var23 = (int)var5[1];
            if (!method_627(var23)) {
               throw new IOException("Invalid or unsupported format in metadata header: " + Integer.toHexString(var23));
            } else {
               byte[] var24 = method_647(var5, 2, var5.length - 2);
               return new class_114(var4, var0, var23, var24);
            }
         }
      } else {
         throw new IOException("Invalid metadata length: " + var3);
      }
   }

   public byte[] encode() {
      long var1 = (long)(this.field_388 + 2) ^ 337824652L;
      byte[] var3 = "NAESEVADNAYRTNRG".getBytes("US-ASCII");
      long[] var4 = method_648(var3);
      var4[0] = rotateLeft(var1, 13) * 5L + 3864292196L & 4294967295L;
      long[] var5 = method_648(this.data);
      long[] var6 = new long[2 + var5.length];
      var6[0] = 4008636094L;
      var6[1] = (long)this.field_389;
      System.arraycopy(var5, 0, var6, 2, var5.length);
      int var7 = var6.length - 1;
      long var8 = 0L;
      long var10 = 0L;

      for (int var12 = 0; var12 < this.field_387; var12++) {
         var8 += -1640531527L;
         int var13 = (int)(var8 >> 2 & 3L);
         int var14 = 0;
         long var15 = 0L;

         for (int var17 = 0; var17 < var7; var14++) {
            var15 = var6[var14 + 1] >> 3 ^ (var10 & 268435455L) << 4;
            var15 += var6[var14 + 1] * 4L & 4294967295L ^ var10 >> 5;
            var15 ^= (var10 ^ var4[var17 & 3 ^ var13]) + (var6[var14 + 1] ^ var8);
            var6[var14] = var6[var14] + var15 & 4294967295L;
            var10 = var6[var14];
            var17++;
         }

         var15 = var6[0] >> 3 ^ (var10 & 268435455L) << 4;
         var15 += var6[0] * 4L & 4294967295L ^ var10 >> 5;
         var15 ^= (var10 ^ var4[var7 & 3 ^ var13]) + (var6[0] ^ var8);
         var6[var7] = var6[var7] + var15 & 4294967295L;
         var10 = var6[var7];
      }

      return method_647(var6, 0, var6.length);
   }

   private int getInt(int var1) {
      if (var1 >= 8 && var1 % 4 == 0) {
         var1 -= 8;
         return this.data[var1] & 0xFF | (this.data[var1 + 1] & 0xFF) << 8 | (this.data[var1 + 2] & 0xFF) << 16 | (this.data[var1 + 3] & 0xFF) << 24;
      } else {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      }
   }

   private void setInt(int var1, int var2) {
      if (var1 >= 8 && var1 % 4 == 0) {
         var1 -= 8;
         this.data[var1] = (byte)(var2 & 0xFF);
         this.data[var1 + 1] = (byte)(var2 >> 8 & 0xFF);
         this.data[var1 + 2] = (byte)(var2 >> 16 & 0xFF);
         this.data[var1 + 3] = (byte)(var2 >> 24 & 0xFF);
      } else {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      }
   }

   private String getString(int var1) {
      if (var1 >= 8 && var1 % 4 == 0) {
         var1 -= 8;

         for (int var2 = var1; var2 < this.data.length; var2++) {
            if (this.data[var2] == 0) {
               return new String(this.data, var1, var2 - var1);
            }
         }

         return "";
      } else {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      }
   }

   private void setString(int var1, String var2) {
      if (var1 >= 8 && var1 % 4 == 0) {
         var1 -= 8;
         byte[] var3 = var2.getBytes();
         System.arraycopy(var3, 0, this.data, var1, var3.length);
         var1 += var3.length;

         for (int var4 = 4 - var3.length % 4; var4 > 0; var4--) {
            this.data[var1++] = 0;
         }
      } else {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      }
   }

   // $VF: renamed from: d (int, int) byte[]
   private byte[] method_646(int var1, int var2) {
      if (var1 < 8 || var1 % 4 != 0) {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      } else if (var2 % 4 != 0) {
         throw new IllegalArgumentException("Invalid length: " + var2);
      } else {
         var1 -= 8;
         byte[] var3 = new byte[var2];
         System.arraycopy(this.data, var1, var3, 0, var2);
         return var3;
      }
   }

   private void setBytes(int var1, byte[] var2) {
      if (var1 >= 8 && var1 % 4 == 0) {
         if (var2.length % 4 != 0) {
            throw new IllegalArgumentException("Invalid length: " + var2.length);
         } else {
            var1 -= 8;
            System.arraycopy(var2, 0, this.data, var1, var2.length);
         }
      } else {
         throw new IllegalArgumentException("Invalid offset: " + var1);
      }
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("00000000    ");
      var1.append("## ## ## ## ## ## ## ## ");
      StringBuilder var2 = new StringBuilder();
      var2.append("########");
      byte var3 = 8;

      for (int var4 = 0; var4 < this.data.length; var4++) {
         if ((var4 + var3) % 16 == 0) {
            var1.append(System.lineSeparator());
            String var5 = Integer.toString((var4 + 1 + var3) / 16, 16) + "0";

            while (var5.length() < 8) {
               var5 = "0" + var5;
            }

            var1.append(var5 + "    ");
         }

         var1.append(Integer.toString((this.data[var4] & 240) >> 4, 16));
         var1.append(Integer.toString(this.data[var4] & 15, 16));
         var1.append(' ');
         if (this.data[var4] == 32) {
            var2.append('.');
         } else if (this.data[var4] >= 32 && this.data[var4] < 127) {
            var2.append((char)(this.data[var4] & 255));
         } else {
            var2.append('?');
         }

         if ((var4 + var3) % 16 == 15) {
            var1.append("   ");
            var1.append((CharSequence)var2);
            var2 = new StringBuilder();
         }
      }

      if (var2.length() > 0) {
         while (var2.length() < 16) {
            var1.append("   ");
            var2.append(" ");
         }

         var1.append("   ");
         var1.append((CharSequence)var2);
      }

      return var1.toString();
   }

   private static long rotateLeft(long var0, int var2) {
      long var3 = (long)Math.pow(2.0, (double)(32 - var2)) - 1L;
      return (var0 & var3) << var2 | var0 >>> 32 - var2;
   }

   // $VF: renamed from: a (long[], int, int) byte[]
   private static byte[] method_647(long[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2 * 4];

      for (int var4 = 0; var4 < var2; var4++) {
         var3[var4 * 4] = (byte)((int)(var0[var1 + var4] & 255L));
         var3[var4 * 4 + 1] = (byte)((int)(var0[var1 + var4] >> 8 & 255L));
         var3[var4 * 4 + 2] = (byte)((int)(var0[var1 + var4] >> 16 & 255L));
         var3[var4 * 4 + 3] = (byte)((int)(var0[var1 + var4] >> 24 & 255L));
      }

      return var3;
   }

   // $VF: renamed from: g (byte[]) long[]
   private static long[] method_648(byte[] var0) {
      return method_649(var0, 0, var0.length);
   }

   // $VF: renamed from: a (byte[], int, int) long[]
   private static long[] method_649(byte[] var0, int var1, int var2) {
      long[] var3 = new long[var2 / 4];

      for (byte var4 = 0; var4 < var2; var4 += 4) {
         var3[var4 / 4] = (long)var0[var1 + var4] & 255L
            | ((long)var0[var1 + var4 + 1] & 255L) << 8
            | ((long)var0[var1 + var4 + 2] & 255L) << 16
            | ((long)var0[var1 + var4 + 3] & 255L) << 24;
      }

      return var3;
   }
}
