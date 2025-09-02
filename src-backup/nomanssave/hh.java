package nomanssave;

public class hh {
   private static final long sx = 255L;
   private static final int sy = 12;
   private static final int sz = 96;
   private static final int sA = 48;
   private static final int sB = 12;
   private static final int sC = 192;
   private static final int sD = 96;
   private static final int sE = 24;
   private static final long sF = -2401053088876216593L;
   private final long sG;
   private final long sH;

   private static long a(byte[] var0, int var1) {
      return ((long)var0[var1 + 7] & 255L) << 56
         | ((long)var0[var1 + 6] & 255L) << 48
         | ((long)var0[var1 + 5] & 255L) << 40
         | ((long)var0[var1 + 4] & 255L) << 32
         | ((long)var0[var1 + 3] & 255L) << 24
         | ((long)var0[var1 + 2] & 255L) << 16
         | ((long)var0[var1 + 1] & 255L) << 8
         | (long)var0[var1] & 255L;
   }

   private static long b(byte[] var0, int var1, int var2) {
      long var3 = 0L;
      switch (var2) {
         case 7:
            var3 += ((long)var0[var1 + 6] & 255L) << 48;
         case 6:
            var3 += ((long)var0[var1 + 5] & 255L) << 40;
         case 5:
            var3 += ((long)var0[var1 + 4] & 255L) << 32;
         case 4:
            var3 += ((long)var0[var1 + 3] & 255L) << 24;
         case 3:
            var3 += ((long)var0[var1 + 2] & 255L) << 16;
         case 2:
            var3 += ((long)var0[var1 + 1] & 255L) << 8;
         case 1:
            var3 += (long)var0[var1] & 255L;
         default:
            return var3;
      }
   }

   private static void a(byte[] var0, int var1, int var2, long[] var3) {
      long var4 = var3[0];
      long var6 = var3[1];
      long var8 = -2401053088876216593L;
      long var10 = -2401053088876216593L;
      int var12 = var2;

      int var13;
      for (var13 = var1; var12 >= 32; var12 -= 32) {
         long var65 = var8 + a(var0, var13);
         var10 += a(var0, var13 + 8);
         long var66 = var65 << 50 | var65 >>> 14;
         long var67 = var66 + var10;
         var4 ^= var67;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 30 | var4 >>> 34;
         var4 += var6;
         long var68 = var67 ^ var4;
         var6 = var6 << 41 | var6 >>> 23;
         var6 += var68;
         var10 ^= var6;
         long var69 = var68 << 54 | var68 >>> 10;
         long var70 = var69 + var10;
         var4 ^= var70;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 38 | var4 >>> 26;
         var4 += var6;
         long var71 = var70 ^ var4;
         var6 = var6 << 37 | var6 >>> 27;
         var6 += var71;
         var10 ^= var6;
         long var72 = var71 << 62 | var71 >>> 2;
         long var73 = var72 + var10;
         var4 ^= var73;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 5 | var4 >>> 59;
         var4 += var6;
         var8 = var73 ^ var4;
         var6 = var6 << 36 | var6 >>> 28;
         var6 += var8;
         var10 ^= var6;
         var4 += a(var0, var13 + 16);
         var6 += a(var0, var13 + 24);
         var13 += 32;
      }

      if (var12 >= 16) {
         long var74 = var8 + a(var0, var13);
         var10 += a(var0, var13 + 8);
         var13 += 16;
         var12 -= 16;
         long var75 = var74 << 50 | var74 >>> 14;
         long var76 = var75 + var10;
         long var23 = var4 ^ var76;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var23;
         long var49 = var6 ^ var10;
         long var24 = var23 << 30 | var23 >>> 34;
         long var25 = var24 + var49;
         long var77 = var76 ^ var25;
         long var50 = var49 << 41 | var49 >>> 23;
         long var51 = var50 + var77;
         var10 ^= var51;
         long var78 = var77 << 54 | var77 >>> 10;
         long var79 = var78 + var10;
         long var26 = var25 ^ var79;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var26;
         long var52 = var51 ^ var10;
         long var27 = var26 << 38 | var26 >>> 26;
         long var28 = var27 + var52;
         long var80 = var79 ^ var28;
         long var53 = var52 << 37 | var52 >>> 27;
         long var54 = var53 + var80;
         var10 ^= var54;
         long var81 = var80 << 62 | var80 >>> 2;
         long var82 = var81 + var10;
         long var29 = var28 ^ var82;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var29;
         long var55 = var54 ^ var10;
         long var30 = var29 << 5 | var29 >>> 59;
         var4 = var30 + var55;
         var8 = var82 ^ var4;
         long var56 = var55 << 36 | var55 >>> 28;
         var6 = var56 + var8;
         var10 ^= var6;
      }

      var10 += (long)var2 << 56;
      if (var12 >= 8) {
         var8 += a(var0, var13);
         var13 += 8;
         var12 -= 8;
         if (var12 > 0) {
            var10 += b(var0, var13, var12);
         }
      } else if (var12 > 0) {
         var8 += b(var0, var13, var12);
      } else {
         var8 += -2401053088876216593L;
         var10 += -2401053088876216593L;
      }

      var10 ^= var8;
      var8 = var8 << 15 | var8 >>> 49;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 52 | var10 >>> 12;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 26 | var4 >>> 38;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 51 | var6 >>> 13;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 28 | var8 >>> 36;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 9 | var10 >>> 55;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 47 | var4 >>> 17;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 54 | var6 >>> 10;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 32 | var8 >>> 32;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 25 | var10 >>> 39;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 63 | var4 >>> 1;
      var6 += var4;
      var3[0] = var4;
      var3[1] = var6;
   }

   public static long b(byte[] var0, int var1, int var2, long[] var3) {
      if (var2 < 192) {
         a(var0, var1, var2, var3);
         return var3[0];
      } else {
         long var10;
         long var16;
         long var22;
         long var4 = var10 = var16 = var22 = var3[0];
         long var12;
         long var18;
         long var24;
         long var6 = var12 = var18 = var24 = var3[1];
         long var26 = -2401053088876216593L;
         long var20 = -2401053088876216593L;
         long var14 = -2401053088876216593L;
         long var8 = -2401053088876216593L;
         int var28 = var2;

         int var29;
         for (var29 = var1; var28 >= 96; var29 += 96) {
            long var34 = var4 + a(var0, var29);
            long var46 = var8 ^ var24;
            var26 ^= var34;
            long var35 = var34 << 11 | var34 >>> 53;
            var26 += var6;
            var6 += a(var0, var29 + 8);
            long var52 = var10 ^ var26;
            long var36 = var35 ^ var6;
            var6 = var6 << 32 | var6 >>> 32;
            long var37 = var36 + var46;
            long var47 = var46 + a(var0, var29 + 16);
            long var58 = var12 ^ var37;
            var6 ^= var47;
            long var48 = var47 << 43 | var47 >>> 21;
            var6 += var52;
            long var53 = var52 + a(var0, var29 + 24);
            long var64 = var14 ^ var6;
            long var49 = var48 ^ var53;
            long var54 = var53 << 31 | var53 >>> 33;
            var8 = var49 + var58;
            long var59 = var58 + a(var0, var29 + 32);
            long var70 = var16 ^ var8;
            long var55 = var54 ^ var59;
            long var60 = var59 << 17 | var59 >>> 47;
            var10 = var55 + var64;
            long var65 = var64 + a(var0, var29 + 40);
            long var76 = var18 ^ var10;
            long var61 = var60 ^ var65;
            long var66 = var65 << 28 | var65 >>> 36;
            var12 = var61 + var70;
            long var71 = var70 + a(var0, var29 + 48);
            long var82 = var20 ^ var12;
            long var67 = var66 ^ var71;
            long var72 = var71 << 39 | var71 >>> 25;
            var14 = var67 + var76;
            long var77 = var76 + a(var0, var29 + 56);
            long var88 = var22 ^ var14;
            long var73 = var72 ^ var77;
            long var78 = var77 << 57 | var77 >>> 7;
            var16 = var73 + var82;
            long var83 = var82 + a(var0, var29 + 64);
            var24 ^= var16;
            long var79 = var78 ^ var83;
            long var84 = var83 << 55 | var83 >>> 9;
            var18 = var79 + var88;
            long var89 = var88 + a(var0, var29 + 72);
            var26 ^= var18;
            long var85 = var84 ^ var89;
            long var90 = var89 << 54 | var89 >>> 10;
            var20 = var85 + var24;
            var24 += a(var0, var29 + 80);
            var4 = var37 ^ var20;
            long var91 = var90 ^ var24;
            var24 = var24 << 22 | var24 >>> 42;
            var22 = var91 + var26;
            var26 += a(var0, var29 + 88);
            var6 ^= var22;
            var24 ^= var26;
            var26 = var26 << 46 | var26 >>> 18;
            var24 += var4;
            var28 -= 96;
         }

         int var30 = var28 & 7;
         int var31 = var28 >>> 3;
         if (var30 > 0) {
            long var32 = b(var0, var29 + (var31 << 3), var30);
            switch (var31) {
               case 0:
                  var4 += var32;
                  break;
               case 1:
                  var6 += var32;
                  break;
               case 2:
                  var8 += var32;
                  break;
               case 3:
                  var10 += var32;
                  break;
               case 4:
                  var12 += var32;
                  break;
               case 5:
                  var14 += var32;
                  break;
               case 6:
                  var16 += var32;
                  break;
               case 7:
                  var18 += var32;
                  break;
               case 8:
                  var20 += var32;
                  break;
               case 9:
                  var22 += var32;
                  break;
               case 10:
                  var24 += var32;
                  break;
               case 11:
                  var26 += var32;
            }
         }

         switch (var31) {
            case 11:
               var24 += a(var0, var29 + 80);
            case 10:
               var22 += a(var0, var29 + 72);
            case 9:
               var20 += a(var0, var29 + 64);
            case 8:
               var18 += a(var0, var29 + 56);
            case 7:
               var16 += a(var0, var29 + 48);
            case 6:
               var14 += a(var0, var29 + 40);
            case 5:
               var12 += a(var0, var29 + 32);
            case 4:
               var10 += a(var0, var29 + 24);
            case 3:
               var8 += a(var0, var29 + 16);
            case 2:
               var6 += a(var0, var29 + 8);
            case 1:
               var4 += a(var0, var29);
            default:
               var26 += (long)var28 << 56;

               for (int var107 = 0; var107 < 3; var107++) {
                  var26 += var6;
                  long var50 = var8 ^ var26;
                  var6 = var6 << 44 | var6 >>> 20;
                  var4 += var50;
                  long var56 = var10 ^ var4;
                  long var51 = var50 << 15 | var50 >>> 49;
                  var6 += var56;
                  long var62 = var12 ^ var6;
                  long var57 = var56 << 34 | var56 >>> 30;
                  var8 = var51 + var62;
                  long var68 = var14 ^ var8;
                  long var63 = var62 << 21 | var62 >>> 43;
                  var10 = var57 + var68;
                  long var74 = var16 ^ var10;
                  long var69 = var68 << 38 | var68 >>> 26;
                  var12 = var63 + var74;
                  long var80 = var18 ^ var12;
                  long var75 = var74 << 33 | var74 >>> 31;
                  var14 = var69 + var80;
                  long var86 = var20 ^ var14;
                  long var81 = var80 << 10 | var80 >>> 54;
                  var16 = var75 + var86;
                  long var92 = var22 ^ var16;
                  long var87 = var86 << 13 | var86 >>> 51;
                  var18 = var81 + var92;
                  long var98 = var24 ^ var18;
                  long var93 = var92 << 38 | var92 >>> 26;
                  var20 = var87 + var98;
                  var26 ^= var20;
                  long var99 = var98 << 53 | var98 >>> 11;
                  var22 = var93 + var26;
                  var4 ^= var22;
                  var26 = var26 << 42 | var26 >>> 22;
                  var24 = var99 + var4;
                  var6 ^= var24;
                  var4 = var4 << 54 | var4 >>> 10;
               }

               var3[0] = var4;
               var3[1] = var6;
               return var4;
         }
      }
   }

   private static long a(CharSequence var0, int var1) {
      return (long)var0.charAt(var1 + 3) << 48 | (long)var0.charAt(var1 + 2) << 32 | (long)var0.charAt(var1 + 1) << 16 | (long)var0.charAt(var1);
   }

   private static long a(CharSequence var0, int var1, int var2) {
      long var3 = 0L;
      switch (var2) {
         case 3:
            var3 += (long)var0.charAt(var1 + 2) << 32;
         case 2:
            var3 += (long)var0.charAt(var1 + 1) << 16;
         case 1:
            var3 += (long)var0.charAt(var1);
         default:
            return var3;
      }
   }

   private static void a(CharSequence var0, int var1, int var2, long[] var3) {
      long var4 = var3[0];
      long var6 = var3[1];
      long var8 = -2401053088876216593L;
      long var10 = -2401053088876216593L;
      int var12 = var2;

      int var13;
      for (var13 = var1; var12 >= 16; var12 -= 16) {
         long var65 = var8 + a(var0, var13);
         var10 += a(var0, var13 + 4);
         long var66 = var65 << 50 | var65 >>> 14;
         long var67 = var66 + var10;
         var4 ^= var67;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 30 | var4 >>> 34;
         var4 += var6;
         long var68 = var67 ^ var4;
         var6 = var6 << 41 | var6 >>> 23;
         var6 += var68;
         var10 ^= var6;
         long var69 = var68 << 54 | var68 >>> 10;
         long var70 = var69 + var10;
         var4 ^= var70;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 38 | var4 >>> 26;
         var4 += var6;
         long var71 = var70 ^ var4;
         var6 = var6 << 37 | var6 >>> 27;
         var6 += var71;
         var10 ^= var6;
         long var72 = var71 << 62 | var71 >>> 2;
         long var73 = var72 + var10;
         var4 ^= var73;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 5 | var4 >>> 59;
         var4 += var6;
         var8 = var73 ^ var4;
         var6 = var6 << 36 | var6 >>> 28;
         var6 += var8;
         var10 ^= var6;
         var4 += a(var0, var13 + 8);
         var6 += a(var0, var13 + 12);
         var13 += 16;
      }

      if (var12 >= 8) {
         long var74 = var8 + a(var0, var13);
         var10 += a(var0, var13 + 4);
         var13 += 8;
         var12 -= 8;
         long var75 = var74 << 50 | var74 >>> 14;
         long var76 = var75 + var10;
         long var23 = var4 ^ var76;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var23;
         long var49 = var6 ^ var10;
         long var24 = var23 << 30 | var23 >>> 34;
         long var25 = var24 + var49;
         long var77 = var76 ^ var25;
         long var50 = var49 << 41 | var49 >>> 23;
         long var51 = var50 + var77;
         var10 ^= var51;
         long var78 = var77 << 54 | var77 >>> 10;
         long var79 = var78 + var10;
         long var26 = var25 ^ var79;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var26;
         long var52 = var51 ^ var10;
         long var27 = var26 << 38 | var26 >>> 26;
         long var28 = var27 + var52;
         long var80 = var79 ^ var28;
         long var53 = var52 << 37 | var52 >>> 27;
         long var54 = var53 + var80;
         var10 ^= var54;
         long var81 = var80 << 62 | var80 >>> 2;
         long var82 = var81 + var10;
         long var29 = var28 ^ var82;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var29;
         long var55 = var54 ^ var10;
         long var30 = var29 << 5 | var29 >>> 59;
         var4 = var30 + var55;
         var8 = var82 ^ var4;
         long var56 = var55 << 36 | var55 >>> 28;
         var6 = var56 + var8;
         var10 ^= var6;
      }

      var10 += (long)(var2 << 1) << 56;
      if (var12 >= 4) {
         var8 += a(var0, var13);
         var13 += 4;
         var12 -= 4;
         if (var12 > 0) {
            var10 += a(var0, var13, var12);
         }
      } else if (var12 > 0) {
         var8 += a(var0, var13, var12);
      } else {
         var8 += -2401053088876216593L;
         var10 += -2401053088876216593L;
      }

      var10 ^= var8;
      var8 = var8 << 15 | var8 >>> 49;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 52 | var10 >>> 12;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 26 | var4 >>> 38;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 51 | var6 >>> 13;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 28 | var8 >>> 36;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 9 | var10 >>> 55;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 47 | var4 >>> 17;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 54 | var6 >>> 10;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 32 | var8 >>> 32;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 25 | var10 >>> 39;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 63 | var4 >>> 1;
      var6 += var4;
      var3[0] = var4;
      var3[1] = var6;
   }

   public static long b(CharSequence var0, int var1, int var2, long[] var3) {
      if (var2 < 96) {
         a(var0, var1, var2, var3);
         return var3[0];
      } else {
         long var10;
         long var16;
         long var22;
         long var4 = var10 = var16 = var22 = var3[0];
         long var12;
         long var18;
         long var24;
         long var6 = var12 = var18 = var24 = var3[1];
         long var26 = -2401053088876216593L;
         long var20 = -2401053088876216593L;
         long var14 = -2401053088876216593L;
         long var8 = -2401053088876216593L;
         int var28 = var2;

         int var29;
         for (var29 = var1; var28 >= 48; var29 += 48) {
            long var34 = var4 + a(var0, var29);
            long var46 = var8 ^ var24;
            var26 ^= var34;
            long var35 = var34 << 11 | var34 >>> 53;
            var26 += var6;
            var6 += a(var0, var29 + 4);
            long var52 = var10 ^ var26;
            long var36 = var35 ^ var6;
            var6 = var6 << 32 | var6 >>> 32;
            long var37 = var36 + var46;
            long var47 = var46 + a(var0, var29 + 8);
            long var58 = var12 ^ var37;
            var6 ^= var47;
            long var48 = var47 << 43 | var47 >>> 21;
            var6 += var52;
            long var53 = var52 + a(var0, var29 + 12);
            long var64 = var14 ^ var6;
            long var49 = var48 ^ var53;
            long var54 = var53 << 31 | var53 >>> 33;
            var8 = var49 + var58;
            long var59 = var58 + a(var0, var29 + 16);
            long var70 = var16 ^ var8;
            long var55 = var54 ^ var59;
            long var60 = var59 << 17 | var59 >>> 47;
            var10 = var55 + var64;
            long var65 = var64 + a(var0, var29 + 20);
            long var76 = var18 ^ var10;
            long var61 = var60 ^ var65;
            long var66 = var65 << 28 | var65 >>> 36;
            var12 = var61 + var70;
            long var71 = var70 + a(var0, var29 + 24);
            long var82 = var20 ^ var12;
            long var67 = var66 ^ var71;
            long var72 = var71 << 39 | var71 >>> 25;
            var14 = var67 + var76;
            long var77 = var76 + a(var0, var29 + 28);
            long var88 = var22 ^ var14;
            long var73 = var72 ^ var77;
            long var78 = var77 << 57 | var77 >>> 7;
            var16 = var73 + var82;
            long var83 = var82 + a(var0, var29 + 32);
            var24 ^= var16;
            long var79 = var78 ^ var83;
            long var84 = var83 << 55 | var83 >>> 9;
            var18 = var79 + var88;
            long var89 = var88 + a(var0, var29 + 36);
            var26 ^= var18;
            long var85 = var84 ^ var89;
            long var90 = var89 << 54 | var89 >>> 10;
            var20 = var85 + var24;
            var24 += a(var0, var29 + 40);
            var4 = var37 ^ var20;
            long var91 = var90 ^ var24;
            var24 = var24 << 22 | var24 >>> 42;
            var22 = var91 + var26;
            var26 += a(var0, var29 + 44);
            var6 ^= var22;
            var24 ^= var26;
            var26 = var26 << 46 | var26 >>> 18;
            var24 += var4;
            var28 -= 48;
         }

         int var30 = var28 & 3;
         int var31 = var28 >> 2;
         if (var30 > 0) {
            long var32 = a(var0, var29 + (var31 << 2), var30);
            switch (var31) {
               case 0:
                  var4 += var32;
                  break;
               case 1:
                  var6 += var32;
                  break;
               case 2:
                  var8 += var32;
                  break;
               case 3:
                  var10 += var32;
                  break;
               case 4:
                  var12 += var32;
                  break;
               case 5:
                  var14 += var32;
                  break;
               case 6:
                  var16 += var32;
                  break;
               case 7:
                  var18 += var32;
                  break;
               case 8:
                  var20 += var32;
                  break;
               case 9:
                  var22 += var32;
                  break;
               case 10:
                  var24 += var32;
                  break;
               case 11:
                  var26 += var32;
            }
         }

         switch (var31) {
            case 11:
               var24 += a(var0, var29 + 40);
            case 10:
               var22 += a(var0, var29 + 36);
            case 9:
               var20 += a(var0, var29 + 32);
            case 8:
               var18 += a(var0, var29 + 28);
            case 7:
               var16 += a(var0, var29 + 24);
            case 6:
               var14 += a(var0, var29 + 20);
            case 5:
               var12 += a(var0, var29 + 16);
            case 4:
               var10 += a(var0, var29 + 12);
            case 3:
               var8 += a(var0, var29 + 8);
            case 2:
               var6 += a(var0, var29 + 4);
            case 1:
               var4 += a(var0, var29);
            default:
               var26 += (long)var28 << 1 << 56;

               for (int var107 = 0; var107 < 3; var107++) {
                  var26 += var6;
                  long var50 = var8 ^ var26;
                  var6 = var6 << 44 | var6 >>> 20;
                  var4 += var50;
                  long var56 = var10 ^ var4;
                  long var51 = var50 << 15 | var50 >>> 49;
                  var6 += var56;
                  long var62 = var12 ^ var6;
                  long var57 = var56 << 34 | var56 >>> 30;
                  var8 = var51 + var62;
                  long var68 = var14 ^ var8;
                  long var63 = var62 << 21 | var62 >>> 43;
                  var10 = var57 + var68;
                  long var74 = var16 ^ var10;
                  long var69 = var68 << 38 | var68 >>> 26;
                  var12 = var63 + var74;
                  long var80 = var18 ^ var12;
                  long var75 = var74 << 33 | var74 >>> 31;
                  var14 = var69 + var80;
                  long var86 = var20 ^ var14;
                  long var81 = var80 << 10 | var80 >>> 54;
                  var16 = var75 + var86;
                  long var92 = var22 ^ var16;
                  long var87 = var86 << 13 | var86 >>> 51;
                  var18 = var81 + var92;
                  long var98 = var24 ^ var18;
                  long var93 = var92 << 38 | var92 >>> 26;
                  var20 = var87 + var98;
                  var26 ^= var20;
                  long var99 = var98 << 53 | var98 >>> 11;
                  var22 = var93 + var26;
                  var4 ^= var22;
                  var26 = var26 << 42 | var26 >>> 22;
                  var24 = var99 + var4;
                  var6 ^= var24;
                  var4 = var4 << 54 | var4 >>> 10;
               }

               var3[0] = var4;
               var3[1] = var6;
               return var4;
         }
      }
   }

   private static void a(long[] var0, int var1, int var2, long[] var3) {
      long var4 = var3[0];
      long var6 = var3[1];
      long var8 = -2401053088876216593L;
      long var10 = -2401053088876216593L;
      int var12 = var2;

      int var13;
      for (var13 = var1; var12 >= 4; var12 -= 4) {
         long var65 = var8 + var0[var13];
         var10 += var0[var13 + 1];
         long var66 = var65 << 50 | var65 >>> 14;
         long var67 = var66 + var10;
         var4 ^= var67;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 30 | var4 >>> 34;
         var4 += var6;
         long var68 = var67 ^ var4;
         var6 = var6 << 41 | var6 >>> 23;
         var6 += var68;
         var10 ^= var6;
         long var69 = var68 << 54 | var68 >>> 10;
         long var70 = var69 + var10;
         var4 ^= var70;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 38 | var4 >>> 26;
         var4 += var6;
         long var71 = var70 ^ var4;
         var6 = var6 << 37 | var6 >>> 27;
         var6 += var71;
         var10 ^= var6;
         long var72 = var71 << 62 | var71 >>> 2;
         long var73 = var72 + var10;
         var4 ^= var73;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var4;
         var6 ^= var10;
         var4 = var4 << 5 | var4 >>> 59;
         var4 += var6;
         var8 = var73 ^ var4;
         var6 = var6 << 36 | var6 >>> 28;
         var6 += var8;
         var10 ^= var6;
         var4 += var0[var13 + 2];
         var6 += var0[var13 + 3];
         var13 += 4;
      }

      if (var12 >= 2) {
         long var74 = var8 + var0[var13];
         var10 += var0[var13 + 1];
         var13 += 2;
         var12 -= 2;
         long var75 = var74 << 50 | var74 >>> 14;
         long var76 = var75 + var10;
         long var23 = var4 ^ var76;
         var10 = var10 << 52 | var10 >>> 12;
         var10 += var23;
         long var49 = var6 ^ var10;
         long var24 = var23 << 30 | var23 >>> 34;
         long var25 = var24 + var49;
         long var77 = var76 ^ var25;
         long var50 = var49 << 41 | var49 >>> 23;
         long var51 = var50 + var77;
         var10 ^= var51;
         long var78 = var77 << 54 | var77 >>> 10;
         long var79 = var78 + var10;
         long var26 = var25 ^ var79;
         var10 = var10 << 48 | var10 >>> 16;
         var10 += var26;
         long var52 = var51 ^ var10;
         long var27 = var26 << 38 | var26 >>> 26;
         long var28 = var27 + var52;
         long var80 = var79 ^ var28;
         long var53 = var52 << 37 | var52 >>> 27;
         long var54 = var53 + var80;
         var10 ^= var54;
         long var81 = var80 << 62 | var80 >>> 2;
         long var82 = var81 + var10;
         long var29 = var28 ^ var82;
         var10 = var10 << 34 | var10 >>> 30;
         var10 += var29;
         long var55 = var54 ^ var10;
         long var30 = var29 << 5 | var29 >>> 59;
         var4 = var30 + var55;
         var8 = var82 ^ var4;
         long var56 = var55 << 36 | var55 >>> 28;
         var6 = var56 + var8;
         var10 ^= var6;
      }

      var10 += (long)(var2 << 3) << 56;
      if (var12 > 0) {
         var8 += var0[var13];
      } else {
         var8 += -2401053088876216593L;
         var10 += -2401053088876216593L;
      }

      var10 ^= var8;
      var8 = var8 << 15 | var8 >>> 49;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 52 | var10 >>> 12;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 26 | var4 >>> 38;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 51 | var6 >>> 13;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 28 | var8 >>> 36;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 9 | var10 >>> 55;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 47 | var4 >>> 17;
      var6 += var4;
      var8 ^= var6;
      var6 = var6 << 54 | var6 >>> 10;
      var8 += var6;
      var10 ^= var8;
      var8 = var8 << 32 | var8 >>> 32;
      var10 += var8;
      var4 ^= var10;
      var10 = var10 << 25 | var10 >>> 39;
      var4 += var10;
      var6 ^= var4;
      var4 = var4 << 63 | var4 >>> 1;
      var6 += var4;
      var3[0] = var4;
      var3[1] = var6;
   }

   public static long b(long[] var0, int var1, int var2, long[] var3) {
      if (var2 < 24) {
         a(var0, var1, var2, var3);
         return var3[0];
      } else {
         long var10;
         long var16;
         long var22;
         long var4 = var10 = var16 = var22 = var3[0];
         long var12;
         long var18;
         long var24;
         long var6 = var12 = var18 = var24 = var3[1];
         long var26 = -2401053088876216593L;
         long var20 = -2401053088876216593L;
         long var14 = -2401053088876216593L;
         long var8 = -2401053088876216593L;
         int var28 = var1;

         int var29;
         for (var29 = var2; var29 >= 12; var29 -= 12) {
            long var31 = var4 + var0[var28];
            long var43 = var8 ^ var24;
            var26 ^= var31;
            long var32 = var31 << 11 | var31 >>> 53;
            var26 += var6;
            var6 += var0[var28 + 1];
            long var49 = var10 ^ var26;
            long var33 = var32 ^ var6;
            var6 = var6 << 32 | var6 >>> 32;
            long var34 = var33 + var43;
            long var44 = var43 + var0[var28 + 2];
            long var55 = var12 ^ var34;
            var6 ^= var44;
            long var45 = var44 << 43 | var44 >>> 21;
            var6 += var49;
            long var50 = var49 + var0[var28 + 3];
            long var61 = var14 ^ var6;
            long var46 = var45 ^ var50;
            long var51 = var50 << 31 | var50 >>> 33;
            var8 = var46 + var55;
            long var56 = var55 + var0[var28 + 4];
            long var67 = var16 ^ var8;
            long var52 = var51 ^ var56;
            long var57 = var56 << 17 | var56 >>> 47;
            var10 = var52 + var61;
            long var62 = var61 + var0[var28 + 5];
            long var73 = var18 ^ var10;
            long var58 = var57 ^ var62;
            long var63 = var62 << 28 | var62 >>> 36;
            var12 = var58 + var67;
            long var68 = var67 + var0[var28 + 6];
            long var79 = var20 ^ var12;
            long var64 = var63 ^ var68;
            long var69 = var68 << 39 | var68 >>> 25;
            var14 = var64 + var73;
            long var74 = var73 + var0[var28 + 7];
            long var85 = var22 ^ var14;
            long var70 = var69 ^ var74;
            long var75 = var74 << 57 | var74 >>> 7;
            var16 = var70 + var79;
            long var80 = var79 + var0[var28 + 8];
            var24 ^= var16;
            long var76 = var75 ^ var80;
            long var81 = var80 << 55 | var80 >>> 9;
            var18 = var76 + var85;
            long var86 = var85 + var0[var28 + 9];
            var26 ^= var18;
            long var82 = var81 ^ var86;
            long var87 = var86 << 54 | var86 >>> 10;
            var20 = var82 + var24;
            var24 += var0[var28 + 10];
            var4 = var34 ^ var20;
            long var88 = var87 ^ var24;
            var24 = var24 << 22 | var24 >>> 42;
            var22 = var88 + var26;
            var26 += var0[var28 + 11];
            var6 ^= var22;
            var24 ^= var26;
            var26 = var26 << 46 | var26 >>> 18;
            var24 += var4;
            var28 += 12;
         }

         switch (var29) {
            case 11:
               var24 += var0[var28 + 10];
            case 10:
               var22 += var0[var28 + 9];
            case 9:
               var20 += var0[var28 + 8];
            case 8:
               var18 += var0[var28 + 7];
            case 7:
               var16 += var0[var28 + 6];
            case 6:
               var14 += var0[var28 + 5];
            case 5:
               var12 += var0[var28 + 4];
            case 4:
               var10 += var0[var28 + 3];
            case 3:
               var8 += var0[var28 + 2];
            case 2:
               var6 += var0[var28 + 1];
            case 1:
               var4 += var0[var28];
            default:
               var26 += (long)(var29 << 3) << 56;

               for (int var30 = 0; var30 < 3; var30++) {
                  var26 += var6;
                  long var47 = var8 ^ var26;
                  var6 = var6 << 44 | var6 >>> 20;
                  var4 += var47;
                  long var53 = var10 ^ var4;
                  long var48 = var47 << 15 | var47 >>> 49;
                  var6 += var53;
                  long var59 = var12 ^ var6;
                  long var54 = var53 << 34 | var53 >>> 30;
                  var8 = var48 + var59;
                  long var65 = var14 ^ var8;
                  long var60 = var59 << 21 | var59 >>> 43;
                  var10 = var54 + var65;
                  long var71 = var16 ^ var10;
                  long var66 = var65 << 38 | var65 >>> 26;
                  var12 = var60 + var71;
                  long var77 = var18 ^ var12;
                  long var72 = var71 << 33 | var71 >>> 31;
                  var14 = var66 + var77;
                  long var83 = var20 ^ var14;
                  long var78 = var77 << 10 | var77 >>> 54;
                  var16 = var72 + var83;
                  long var89 = var22 ^ var16;
                  long var84 = var83 << 13 | var83 >>> 51;
                  var18 = var78 + var89;
                  long var95 = var24 ^ var18;
                  long var90 = var89 << 38 | var89 >>> 26;
                  var20 = var84 + var95;
                  var26 ^= var20;
                  long var96 = var95 << 53 | var95 >>> 11;
                  var22 = var90 + var26;
                  var4 ^= var22;
                  var26 = var26 << 42 | var26 >>> 22;
                  var24 = var96 + var4;
                  var6 ^= var24;
                  var4 = var4 << 54 | var4 >>> 10;
               }

               var3[0] = var4;
               var3[1] = var6;
               return var4;
         }
      }
   }

   public hh() {
      this(0L, 0L);
   }

   public hh(long var1, long var3) {
      this.sG = var1;
      this.sH = var3;
   }

   public static long a(byte[] var0, long[] var1) {
      return b(var0, 0, var0.length, var1);
   }

   public long[] c(byte[] var1, int var2, int var3) {
      long[] var4 = new long[]{this.sG, this.sH};
      b(var1, var2, var3, var4);
      return var4;
   }

   public long[] j(byte[] var1) {
      return this.c(var1, 0, var1.length);
   }

   public static long a(CharSequence var0, long[] var1) {
      return b(var0, 0, var0.length(), var1);
   }

   public long[] b(CharSequence var1, int var2, int var3) {
      long[] var4 = new long[]{this.sG, this.sH};
      b(var1, var2, var3, var4);
      return var4;
   }

   public long[] a(CharSequence var1) {
      return this.b(var1, 0, var1.length());
   }

   public static long a(long[] var0, long[] var1) {
      return b(var0, 0, var0.length, var1);
   }

   public long[] b(long[] var1, int var2, int var3) {
      long[] var4 = new long[]{this.sG, this.sH};
      b(var1, var2, var3, var4);
      return var4;
   }

   public long[] b(long[] var1) {
      return this.b(var1, 0, var1.length);
   }
}
