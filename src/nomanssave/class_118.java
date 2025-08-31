package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// $VF: renamed from: nomanssave.fC
class class_118 implements class_9 {
   // $VF: renamed from: mb int
   final int field_395;
   // $VF: renamed from: mc java.io.File
   final File field_396;
   // $VF: renamed from: md java.lang.String
   final String field_397;
   // $VF: renamed from: lK byte[]
   final byte[] field_398;
   // $VF: renamed from: be nomanssave.fn
   final class_294 field_399;

   class_118(class_122 var1, String var2, int var3) {
      this.field_400 = var1;
      this.field_395 = var3;
      this.field_396 = new File(class_300.field_969, var2);
      ZipFile var4 = new ZipFile(this.field_396);

      try {
         ZipEntry var5 = var4.getEntry("saveinfo.txt");
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         Properties var6 = new Properties();
         var6.load(var4.getInputStream(var5));
         this.field_397 = var6.getProperty("StorageFile");
         if (this.field_397 == null) {
            throw new IOException("Invalid backup file");
         }

         String var7 = var6.getProperty("GameMode");
         this.field_399 = var7 == null ? null : class_294.valueOf(var7);
         var5 = var4.getEntry(this.field_397);
         InputStream var8 = var4.getInputStream(var5);

         try {
            this.field_398 = new byte[112];
            class_31.readFully(var8, this.field_398);

            for (int var9 = 0; var9 < class_122.method_658().length; var9++) {
               if (this.field_398[var9] != class_122.method_658()[var9]) {
                  throw new IOException("Invalid header");
               }
            }
         } finally {
            var8.close();
         }
      } catch (NumberFormatException var19) {
         throw new IOException("Invalid backup file");
      } finally {
         var4.close();
      }
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_34() {
      return this.field_399;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_33() {
      return this.field_396.getName();
   }

   @Override
   public long lastModified() {
      return this.field_396.lastModified();
   }

   // $VF: renamed from: M () nomanssave.eY
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public class_137 method_35() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         ZipFile var4 = new ZipFile(this.field_396);

         try {
            ZipEntry var5 = var4.getEntry(this.field_397);
            if (var5 == null) {
               throw new IOException("Invalid backup file");
            }

            InputStream var6 = var4.getInputStream(var5);

            try {
               var6.skip(112L);
               byte[] var7 = new byte[4096];

               int var8;
               while ((var8 = var6.read(var7)) >= 0) {
                  var1.write(var7, 0, var8);
               }
            } finally {
               var6.close();
            }
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var21) {
         if (var2 == null) {
            var2 = var21;
         } else if (var2 != var21) {
            var2.addSuppressed(var21);
         }

         throw var2;
      }

      return class_122.method_659(var1.toByteArray(), class_297.field_949);
   }

   // $VF: renamed from: b (nomanssave.eY) java.lang.String
   @Override
   public String method_36(class_137 var1) {
      class_37.info("Writing new save file...");
      String var2;
      if (class_122.method_661(this.field_400)[this.field_395] != null) {
         var2 = class_122.method_661(this.field_400)[this.field_395].method_36(var1);
      } else {
         class_122.method_661(this.field_400)[this.field_395] = new class_120(this.field_400, this.field_395, this.field_398, var1);
         var2 = class_122.method_661(this.field_400)[this.field_395].K();
      }

      class_37.info("Finished.");
      return var2;
   }

   @Override
   public String toString() {
      return this.field_396.getName();
   }
}
