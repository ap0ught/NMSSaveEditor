package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// $VF: renamed from: nomanssave.fS
public class class_105 {
   // $VF: renamed from: mh java.io.File
   private final File field_349;
   // $VF: renamed from: lL int
   private int field_350;
   private int version;
   // $VF: renamed from: my long
   private long field_351;
   // $VF: renamed from: mz int
   private int field_352;
   // $VF: renamed from: mA int
   private int field_353;
   // $VF: renamed from: mB byte[]
   private byte[] field_354;
   private String name;
   private String description;
   // $VF: renamed from: lM int
   private int field_355;

   class_105(File var1) {
      this.field_349 = var1;
   }

   // $VF: renamed from: cn () void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void method_601() {
      Throwable var1 = null;
      Object var2 = null;

      try {
         FileInputStream var3 = new FileInputStream(this.field_349);

         try {
            this.read(var3);
         } finally {
            if (var3 != null) {
               var3.close();
            }
         }
      } catch (Throwable var9) {
         if (var1 == null) {
            var1 = var9;
         } else if (var1 != var9) {
            var1.addSuppressed(var9);
         }

         throw var1;
      }
   }

   void read(InputStream var1) {
      this.field_350 = class_31.readInt(var1);
      if (this.field_350 != 0) {
         class_37.debug("  unknown1: " + Integer.toHexString(this.field_350));
      }

      this.version = class_31.readInt(var1);
      if (this.version != 0) {
         class_37.info("  version: " + this.version);
      }

      this.field_351 = class_31.method_119(var1);
      if (this.field_351 != 0L) {
         class_37.info("  totalPlayTime: " + class_7.method_13(this.field_351));
      }

      if (this.field_350 == 1) {
         this.field_352 = class_31.readInt(var1);
         if (this.field_352 != 0) {
            class_37.debug("  decompressed: " + this.field_352);
         }

         this.field_353 = 0;
         this.field_354 = new byte[128];
         class_31.readFully(var1, this.field_354);
      } else {
         this.field_352 = 0;
         this.field_353 = class_31.readInt(var1);
         if (this.field_353 != 0) {
            class_37.debug("  compressed: " + this.field_353);
         }

         this.field_354 = null;
         this.name = class_50.method_319(var1);
         if (this.name.length() != 0) {
            class_37.debug("  name: " + this.name);
         }

         this.description = class_50.method_319(var1);
         if (this.description.length() != 0) {
            class_37.debug("  description: " + this.description);
         }
      }

      this.field_355 = class_31.readInt(var1);
      if (this.field_355 != 0) {
         class_37.debug("  unknown2: " + Integer.toHexString(this.field_355));
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void write() {
      Throwable var1 = null;
      Object var2 = null;

      try {
         FileOutputStream var3 = new FileOutputStream(this.field_349);

         try {
            this.write(var3);
         } finally {
            if (var3 != null) {
               var3.close();
            }
         }
      } catch (Throwable var9) {
         if (var1 == null) {
            var1 = var9;
         } else if (var1 != var9) {
            var1.addSuppressed(var9);
         }

         throw var1;
      }
   }

   void write(OutputStream var1) {
      class_31.method_118(var1, this.field_350);
      class_31.method_118(var1, this.version);
      class_31.method_120(var1, this.field_351);
      if (this.field_354 != null) {
         class_31.method_118(var1, this.field_352);
         var1.write(this.field_354);
      } else {
         class_31.method_118(var1, this.field_353);
         class_50.method_320(var1, this.name);
         class_50.method_320(var1, this.description);
      }

      class_31.method_118(var1, this.field_355);
   }

   // $VF: renamed from: co () byte[]
   byte[] method_602() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      this.write(var1);
      return var1.toByteArray();
   }

   // $VF: renamed from: cp () boolean
   boolean method_603() {
      return this.field_354 == null;
   }

   int getVersion() {
      return this.version;
   }

   void setVersion(int var1) {
      this.version = var1;
   }

   // $VF: renamed from: ch () int
   int method_604() {
      return this.field_352;
   }

   // $VF: renamed from: aj (int) void
   void method_605(int var1) {
      if (this.field_354 != null) {
         this.field_352 = var1;
      }
   }

   // $VF: renamed from: ci () int
   int method_606() {
      return this.field_353;
   }

   // $VF: renamed from: ak (int) void
   void method_607(int var1) {
      if (this.field_354 == null) {
         this.field_353 = var1;
      }
   }

   // $VF: renamed from: ck () java.lang.String
   String method_608() {
      return this.name;
   }

   // $VF: renamed from: Y (java.lang.String) void
   void method_609(String var1) {
      this.name = var1;
   }

   String getDescription() {
      return this.description;
   }

   // $VF: renamed from: cq () long
   long method_610() {
      return this.field_351;
   }

   // $VF: renamed from: d (long) void
   void method_611(long var1) {
      this.field_351 = var1;
   }

   String getName() {
      return this.field_349.getName();
   }

   long length() {
      return this.field_349.length();
   }

   // $VF: renamed from: a (nomanssave.fS) void
   void method_612(class_105 var1) {
      this.field_350 = var1.field_350;
      this.version = var1.version;
      this.field_351 = var1.field_351;
      this.field_353 = var1.field_353;
      this.field_352 = var1.field_352;
      this.field_354 = var1.field_354;
      this.name = var1.name;
      this.description = var1.description;
      this.field_355 = var1.field_355;
   }
}
