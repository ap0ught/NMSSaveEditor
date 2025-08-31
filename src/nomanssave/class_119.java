package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// $VF: renamed from: nomanssave.fH
class class_119 {
   // $VF: renamed from: mh java.io.File
   final File field_401;
   // $VF: renamed from: lK byte[]
   byte[] field_402;

   class_119(class_122 var1, String var2, boolean var3) {
      this.field_403 = var1;
      this.field_401 = new File(class_122.method_657(var1), var2);
      if (var3) {
         FileInputStream var4 = new FileInputStream(this.field_401);

         try {
            this.field_402 = new byte[112];
            class_31.readFully(var4, this.field_402);

            for (int var5 = 0; var5 < class_122.method_658().length; var5++) {
               if (this.field_402[var5] != class_122.method_658()[var5]) {
                  throw new IOException("Invalid header");
               }
            }
         } finally {
            var4.close();
         }
      }
   }

   byte[] readBytes() {
      long var1 = (255L & (long)this.field_402[95]) << 24
         | (255L & (long)this.field_402[94]) << 16
         | (255L & (long)this.field_402[93]) << 8
         | 255L & (long)this.field_402[92];
      FileInputStream var3 = new FileInputStream(new File(class_122.method_657(this.field_403), this.method_654()));

      byte[] var6;
      try {
         byte[] var4 = new byte[(int)var1];
         var3.skip(112L);
         class_31.readFully(var3, var4);
         var6 = var4;
      } finally {
         var3.close();
      }

      return var6;
   }

   // $VF: renamed from: ah (int) byte[]
   byte[] method_652(int var1) {
      long var2 = (255L & (long)this.field_402[95]) << 24
         | (255L & (long)this.field_402[94]) << 16
         | (255L & (long)this.field_402[93]) << 8
         | 255L & (long)this.field_402[92];
      FileInputStream var4 = new FileInputStream(new File(class_122.method_657(this.field_403), this.method_654()));

      byte[] var7;
      try {
         var1 = (int)Math.min((long)var1, var2);
         byte[] var5 = new byte[var1];
         var4.skip(112L);
         class_31.readFully(var4, var5);
         var7 = var5;
      } finally {
         var4.close();
      }

      return var7;
   }

   void writeBytes(byte[] var1) {
      this.field_402[92] = (byte)var1.length;
      this.field_402[93] = (byte)(var1.length >> 8);
      this.field_402[94] = (byte)(var1.length >> 16);
      this.field_402[95] = (byte)(var1.length >> 24);
      FileOutputStream var2 = new FileOutputStream(new File(class_122.method_657(this.field_403), this.method_654()));

      try {
         var2.write(this.field_402);
         var2.write(var1);
      } finally {
         var2.close();
      }
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.fn, java.lang.String, java.lang.String) void
   void method_653(String var1, class_294 var2, String var3, String var4) {
      Properties var5 = new Properties();
      var5.setProperty("StorageFile", this.field_401.getName());
      var5.setProperty("LastModified", Long.toString(this.field_401.lastModified()));
      if (var2 != null) {
         var5.setProperty("GameMode", var2.name());
      }

      if (var3 != null) {
         var5.setProperty("SaveName", var3);
      }

      if (var4 != null) {
         var5.setProperty("Description", var4);
      }

      String var6 = var1 + "." + System.currentTimeMillis() + ".zip";
      File var7 = new File(class_300.field_969, var6);
      ZipOutputStream var8 = new ZipOutputStream(new FileOutputStream(var7));

      try {
         byte[] var10 = new byte[4096];
         ZipEntry var11 = new ZipEntry(this.field_401.getName());
         var8.putNextEntry(var11);
         FileInputStream var12 = new FileInputStream(this.field_401);

         int var9;
         try {
            while ((var9 = var12.read(var10)) >= 0) {
               var8.write(var10, 0, var9);
            }
         } finally {
            var12.close();
         }

         var11 = new ZipEntry("saveinfo.txt");
         var8.putNextEntry(var11);
         var5.store(var8, "");
      } finally {
         var8.close();
      }

      var7.setLastModified(this.field_401.lastModified());
   }

   // $VF: renamed from: K () java.lang.String
   public String method_654() {
      return this.field_401.getName();
   }
}
