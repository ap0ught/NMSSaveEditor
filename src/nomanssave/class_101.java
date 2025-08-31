package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// $VF: renamed from: nomanssave.fX
abstract class class_101 {
   // $VF: renamed from: mO nomanssave.fW
   final class_99 field_319;
   // $VF: renamed from: mX java.io.File
   final File field_320;
   // $VF: renamed from: mY java.io.File
   final File field_321;
   // $VF: renamed from: mZ nomanssave.fS
   final class_105 field_322;
   int mode;

   class_101(class_104 var1, class_100 var2) {
      this.field_323 = var1;
      int var3 = class_104.method_591(var1).size();

      for (int var4 = 0; var4 < class_104.method_591(var1).size(); var4++) {
         int var5 = ((class_99)class_104.method_591(var1).get(var4)).name.compareTo(var2.field_310.name);
         if (var5 == 0) {
            class_99 var6 = (class_99)class_104.method_591(var1).remove(var4);
            class_104.method_593(new File(class_104.method_592(var1), var6.field_306));
         }

         if (var5 >= 0) {
            var3 = var4;
            break;
         }
      }

      this.field_319 = new class_99(var1, var2.field_310);
      File var9 = new File(class_104.method_592(var1), this.field_319.field_306);
      if (!var9.mkdir()) {
         throw new IOException("Unable to create container path");
      } else {
         this.field_320 = new File(var9, "container." + this.field_319.field_304);
         this.field_322 = new class_105(new File(var9, var2.field_313));
         this.field_321 = new File(var9, var2.field_315);
         FileOutputStream var10 = new FileOutputStream(this.field_320);

         try {
            var2.method_573(var10);
         } finally {
            var10.close();
         }

         class_104.method_591(var1).add(var3, this.field_319);
      }
   }

   class_101(class_104 var1, String var2) {
      this.field_323 = var1;
      this.field_319 = class_104.method_594(var1, var2);
      File var3 = new File(class_104.method_592(var1), this.field_319.field_306);
      if (!var3.isDirectory()) {
         throw new FileNotFoundException(this.field_319.field_306);
      } else {
         this.field_320 = new File(var3, "container." + this.field_319.field_304);
         class_37.info(this.field_319.filename);
         File var4 = null;
         File var5 = null;
         FileInputStream var6 = new FileInputStream(this.field_320);

         try {
            int var7 = class_31.readInt(var6);
            class_37.debug("  header: " + Integer.toHexString(var7));
            int var8 = class_31.readInt(var6);

            for (int var9 = 0; var9 < var8; var9++) {
               String var10 = class_50.method_318(var6);
               class_37.debug("  name: " + var10);
               String var11 = class_50.method_309(var6);
               class_37.debug("  filename: " + var11);
               String var12 = class_50.method_309(var6);
               if (!var11.equals(var12)) {
                  class_37.debug("  filename2: " + var12);
               }

               if (var10.equals("data")) {
                  var4 = new File(var3, var11);
                  if (!var4.exists()) {
                     var4 = new File(var3, var12);
                  }
               }

               if (var10.equals("meta")) {
                  var5 = new File(var3, var11);
                  if (!var5.exists()) {
                     var5 = new File(var3, var12);
                  }
               }
            }
         } finally {
            var6.close();
         }

         if (var4 != null && var5 != null) {
            long var16 = var5.length() + var4.length();
            if (this.field_319.field_308 != var16) {
               throw new IOException("data size mismatch: " + this.field_319.field_308);
            } else {
               this.field_321 = var4;
               this.field_322 = new class_105(var5);
               this.field_322.method_601();
            }
         } else {
            throw new FileNotFoundException("data/meta file missing");
         }
      }
   }

   // $VF: renamed from: K () java.lang.String
   public String method_574() {
      return this.field_319.filename;
   }

   private InputStream getInputStream() {
      InputStream var1 = class_104.method_595(new FileInputStream(this.field_321), this.field_322.method_604());
      if (var1 instanceof class_61) {
         this.mode = class_104.method_596();
      } else if (var1 instanceof class_59) {
         this.mode = class_104.method_597();
      } else {
         this.mode = class_104.method_598();
      }

      return var1;
   }

   private OutputStream getOutputStream() {
      FileOutputStream var1 = new FileOutputStream(this.field_321);

      try {
         if (this.mode == class_104.method_596()) {
            return new class_56(var1);
         } else if (this.mode == class_104.method_597()) {
            var1.write(class_104.method_599());
            return new class_54(var1);
         } else {
            return new class_55(var1);
         }
      } catch (IOException var5) {
         try {
            var1.close();
         } catch (IOException var4) {
         }

         throw var5;
      }
   }

   // $VF: renamed from: a (nomanssave.eG) nomanssave.eY
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   class_137 method_575(class_297 var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_96 var4 = new class_96(this.getInputStream(), 2);

         Throwable var10000;
         label125: {
            try {
               var17 = var4.method_559(var1);
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var10001 = false;
               break label125;
            }

            if (var4 != null) {
               var4.close();
            }

            label114:
            try {
               return var17;
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var18 = false;
               break label114;
            }
         }

         var2 = var10000;
         if (var4 != null) {
            var4.close();
         }

         throw var2;
      } catch (Throwable var16) {
         if (var2 == null) {
            var2 = var16;
         } else if (var2 != var16) {
            var2.addSuppressed(var16);
         }

         throw var2;
      }
   }

   // $VF: renamed from: ah (int) byte[]
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   byte[] method_576(int var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      Throwable var3 = null;
      Object var4 = null;

      try {
         InputStream var5 = this.getInputStream();

         try {
            byte[] var6 = new byte[4096];

            int var7;
            while ((var7 = var5.read(var6)) >= 0) {
               var2.write(var6, 0, var7);
               if (var2.size() >= var1) {
                  break;
               }
            }
         } finally {
            if (var5 != null) {
               var5.close();
            }
         }
      } catch (Throwable var13) {
         if (var3 == null) {
            var3 = var13;
         } else if (var3 != var13) {
            var3.addSuppressed(var13);
         }

         throw var3;
      }

      return var2.toByteArray();
   }

   // $VF: renamed from: h (nomanssave.eY) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void method_577(class_137 var1) {
      boolean var2 = this.mode == class_104.method_597();
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Throwable var4 = null;
      Throwable var5 = null;

      try {
         class_92 var6 = new class_92(var3, var2 ? 0 : 2);

         try {
            var6.method_511(var1);
         } finally {
            if (var6 != null) {
               var6.close();
            }
         }
      } catch (Throwable var25) {
         if (var4 == null) {
            var4 = var25;
         } else if (var4 != var25) {
            var4.addSuppressed(var25);
         }

         throw var4;
      }

      byte[] var28 = var3.toByteArray();
      this.field_322.method_605(var28.length);
      var5 = null;
      Object var30 = null;

      try {
         OutputStream var7 = this.getOutputStream();

         try {
            var7.write(var28);
            if (var2) {
               var7.flush();
               var7.write(0);
            }
         } finally {
            if (var7 != null) {
               var7.close();
            }
         }
      } catch (Throwable var27) {
         if (var5 == null) {
            var5 = var27;
         } else if (var5 != var27) {
            var5.addSuppressed(var27);
         }

         throw var5;
      }

      this.field_322.method_607((int)this.field_321.length());
      this.field_322.write();
      this.field_319.timestamp = System.currentTimeMillis();
      this.field_319.field_308 = this.field_321.length() + this.field_322.length();
      class_104.method_600(this.field_323);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.fn) void
   void method_578(String var1, class_294 var2) {
      Properties var3 = new Properties();
      var3.setProperty("MetaFile", this.field_322.getName());
      var3.setProperty("DataFile", this.field_321.getName());
      var3.setProperty("ContainerFile", this.field_320.getName());
      if (var2 != null) {
         var3.setProperty("GameMode", var2.name());
      }

      var3.setProperty("IndexData", this.field_319.method_572());
      String var4 = var1 + "." + System.currentTimeMillis() + ".zip";
      File var5 = new File(class_300.field_969, var4);
      ZipOutputStream var6 = new ZipOutputStream(new FileOutputStream(var5));

      try {
         ZipEntry var8 = new ZipEntry(this.field_322.getName());
         var6.putNextEntry(var8);
         var6.write(this.field_322.method_602());
         var8 = new ZipEntry(this.field_321.getName());
         var6.putNextEntry(var8);
         byte[] var9 = new byte[1024];
         FileInputStream var10 = new FileInputStream(this.field_321);

         int var7;
         try {
            while ((var7 = var10.read(var9)) > 0) {
               var6.write(var9, 0, var7);
            }
         } finally {
            var10.close();
         }

         var8 = new ZipEntry(this.field_320.getName());
         var6.putNextEntry(var8);
         var10 = new FileInputStream(this.field_320);

         try {
            while ((var7 = var10.read(var9)) > 0) {
               var6.write(var9, 0, var7);
            }
         } finally {
            var10.close();
         }

         var8 = new ZipEntry("saveinfo.txt");
         var6.putNextEntry(var8);
         var3.store(var6, "");
      } finally {
         var6.close();
      }

      var5.setLastModified(this.field_319.timestamp);
   }
}
