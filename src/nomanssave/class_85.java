package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

// $VF: renamed from: nomanssave.fw
class class_85 {
   // $VF: renamed from: be nomanssave.fn
   public class_294 field_245;
   // $VF: renamed from: lK byte[]
   final byte[] field_246;
   // $VF: renamed from: lL int
   final int field_247;
   // $VF: renamed from: lM int
   final int field_248;
   // $VF: renamed from: lN int
   final int field_249;
   // $VF: renamed from: lO int
   final int field_250;
   // $VF: renamed from: bd long
   long field_251;
   long length;
   // $VF: renamed from: lP long
   long field_252;
   // $VF: renamed from: lQ int
   final int field_253;
   // $VF: renamed from: lR int
   final int field_254;
   // $VF: renamed from: lS int
   final int field_255;

   class_85(class_87 var1, InputStream var2) {
      this.field_256 = var1;
      this.field_246 = new byte[8];
      class_31.readFully(var2, this.field_246);
      this.field_247 = class_31.readInt(var2);
      this.field_248 = class_31.readInt(var2);
      this.field_249 = class_31.readInt(var2);
      this.field_250 = class_31.readInt(var2);
      this.field_251 = 1000L * (long)class_31.readInt(var2);
      this.length = 4294967295L & (long)class_31.readInt(var2);
      this.field_252 = 4294967295L & (long)class_31.readInt(var2);
      this.field_253 = class_31.readInt(var2);
      this.field_254 = class_31.readInt(var2);
      this.field_255 = class_31.readInt(var2);
   }

   boolean isValid() {
      return class_87.method_495(this.field_246, class_87.method_494()) && this.field_250 >= 0;
   }

   // $VF: renamed from: a (java.io.OutputStream) int
   int method_487(OutputStream var1) {
      var1.write(this.field_246);
      class_31.method_118(var1, this.field_247);
      class_31.method_118(var1, this.field_248);
      class_31.method_118(var1, this.field_249);
      class_31.method_118(var1, this.field_250);
      class_31.method_118(var1, (int)(this.field_251 / 1000L));
      class_31.method_118(var1, (int)this.length);
      class_31.method_118(var1, (int)this.field_252);
      class_31.method_118(var1, this.field_253);
      class_31.method_118(var1, this.field_254);
      class_31.method_118(var1, this.field_255);
      return 48;
   }

   // $VF: renamed from: bZ () void
   void method_488() {
      System.out.println("  unknown1 = " + this.field_247 + " 0x" + Integer.toHexString(this.field_247) + " " + Integer.toBinaryString(this.field_247));
      System.out.println("  unknown2 = " + this.field_248 + " 0x" + Integer.toHexString(this.field_248) + " " + Integer.toBinaryString(this.field_248));
      System.out.println("  fileType = " + this.field_249 + " 0x" + Integer.toHexString(this.field_249) + " " + Integer.toBinaryString(this.field_249));
      System.out.println("  archiveNumber = " + this.field_250 + " 0x" + Integer.toHexString(this.field_250) + " " + Integer.toBinaryString(this.field_250));
      System.out.println("  modified = " + new Date(this.field_251));
      System.out.println("  length = " + this.length);
      System.out.println("  startPos = 0x" + Long.toHexString(this.field_252));
      System.out.println("  valid = " + this.field_253);
      if (this.field_254 != 0) {
         System.out
            .println(
               "  unknown3 = "
                  + this.field_254
                  + " 0x"
                  + Integer.toHexString(this.field_254)
                  + " "
                  + Integer.toBinaryString(this.field_254)
                  + " date:"
                  + new Date(1000L * (long)this.field_254)
            );
      }

      if (this.field_255 != 0) {
         System.out
            .println(
               "  unknown4 = "
                  + this.field_255
                  + " 0x"
                  + Integer.toHexString(this.field_255)
                  + " "
                  + Integer.toBinaryString(this.field_255)
                  + " len:"
                  + (4294967295L & (long)this.field_255)
            );
      }
   }

   // $VF: renamed from: ca () byte[]
   byte[] method_489() {
      if (!this.isValid()) {
         return null;
      } else {
         FileInputStream var1 = new FileInputStream(class_87.method_496(this.field_256));

         byte[] var8;
         try {
            var1.skip(this.field_252);
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            byte[] var3 = new byte[4096];
            long var4 = this.length;

            int var6;
            while (var4 > 0L && (var6 = var1.read(var3, 0, (int)Math.min((long)var3.length, var4))) > 0) {
               var4 -= (long)var6;
               var2.write(var3, 0, var6);
            }

            if (var4 > 0L) {
               throw new IOException("short read");
            }

            var8 = var2.toByteArray();
         } finally {
            var1.close();
         }

         return var8;
      }
   }

   // $VF: renamed from: d (byte[]) void
   void method_490(byte[] var1) {
      if (!this.isValid()) {
         throw new IOException("header not valid");
      } else {
         int var2 = -1;

         for (int var3 = 0; var3 < class_87.method_497(this.field_256).length; var3++) {
            if (class_87.method_497(this.field_256)[var3] == this) {
               var2 = var3;
               break;
            }
         }

         if (var2 < 0) {
            throw new IOException("header not valid");
         } else {
            long var25 = System.currentTimeMillis();
            File var5 = new File(class_87.method_496(this.field_256).getParentFile(), "~" + class_87.method_496(this.field_256).getName());
            FileOutputStream var6 = new FileOutputStream(var5);

            try {
               FileInputStream var7 = new FileInputStream(class_87.method_496(this.field_256));

               try {
                  System.out.println("Reading header");
                  byte[] var8 = new byte[64];
                  class_31.readFully(var7, var8);
                  var6.write(var8);
                  long var9 = (long)var1.length - class_87.method_497(this.field_256)[var2].length;
                  long var11 = 64L;

                  for (int var13 = 0; var13 < var2; var13++) {
                     if (class_87.method_497(this.field_256)[var13].field_252 < class_87.method_497(this.field_256)[var2].field_252) {
                        class_87.method_497(this.field_256)[var13].field_252 += var9;
                     }

                     var11 += (long)class_87.method_497(this.field_256)[var13].method_487(var6);
                  }

                  var6.write(class_87.method_494());
                  class_87.method_497(this.field_256)[var2].length = (long)var1.length;
                  class_87.method_497(this.field_256)[var2].field_251 = var25;
                  var11 += (long)class_87.method_497(this.field_256)[var2].method_487(var6);

                  for (int var28 = var2 + 1; var28 < class_87.method_497(this.field_256).length; var28++) {
                     if (class_87.method_497(this.field_256)[var28].field_252 < class_87.method_497(this.field_256)[var2].field_252) {
                        class_87.method_497(this.field_256)[var28].field_252 += var9;
                     }

                     var11 += (long)class_87.method_497(this.field_256)[var28].method_487(var6);
                  }

                  long var29 = class_87.method_497(this.field_256)[var2].field_252 - var11;
                  byte[] var15 = new byte[4096];

                  int var16;
                  while (var29 > 0L && (var16 = var7.read(var15, 0, (int)Math.min((long)var15.length, var29))) > 0) {
                     var6.write(var15, 0, var16);
                     var11 += (long)var16;
                     var29 -= (long)var16;
                  }

                  if (var29 > 0L) {
                     throw new IOException("short read");
                  }

                  var6.write(var1);
                  var11 += (long)var1.length;
                  var29 = (long)var1.length - var9;

                  while (var29 > 0L && (var16 = var7.read(var15, 0, (int)Math.min((long)var15.length, var29))) > 0) {
                     var29 -= (long)var16;
                  }

                  if (var29 > 0L) {
                     throw new IOException("short read");
                  }

                  while ((var16 = var7.read(var15)) > 0) {
                     var6.write(var15, 0, var16);
                  }
               } finally {
                  var7.close();
               }
            } finally {
               var6.close();
            }
         }
      }
   }
}
