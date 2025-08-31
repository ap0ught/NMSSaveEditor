package nomanssave;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fT
public class class_104 implements class_7 {
   // $VF: renamed from: lA byte[]
   private static final byte[] field_329 = "HGSAVEV2\u0000".getBytes();
   // $VF: renamed from: lV java.util.regex.Pattern
   private static final Pattern field_330 = Pattern.compile("Slot(\\d+)((Auto)|(Manual))");
   // $VF: renamed from: lW java.util.regex.Pattern
   private static final Pattern field_331 = Pattern.compile("wgsbackup(\\d*)\\.\\d*\\.zip");
   // $VF: renamed from: mC java.lang.String
   static final String field_332 = "containers.index";
   // $VF: renamed from: lX java.io.File
   private final File field_333;
   // $VF: renamed from: lE nomanssave.fR
   private final class_3 field_334;
   // $VF: renamed from: mD nomanssave.fU
   private class_103 field_335;
   // $VF: renamed from: mE nomanssave.fY[]
   private class_102[] field_336;
   private int header;
   // $VF: renamed from: lL int
   private int field_337;
   private String name;
   // $VF: renamed from: lM int
   private int field_338;
   // $VF: renamed from: lR int
   private int field_339;
   // $VF: renamed from: lS int
   private int field_340;
   // $VF: renamed from: mF java.lang.String
   private String field_341;
   // $VF: renamed from: mG int
   private int field_342;
   // $VF: renamed from: mH int
   private int field_343;
   // $VF: renamed from: mI java.util.List
   private List field_344;
   // $VF: renamed from: mJ java.util.regex.Pattern
   private static final Pattern field_345 = Pattern.compile("\"((?:<h0)|(?:CommonStateData))\":\\{\"((?:Pk4)|(?:SaveName))\":\"([^\"]+)\"");
   // $VF: renamed from: mK int
   private static int field_346 = 1;
   // $VF: renamed from: mL int
   private static int field_347 = 2;
   // $VF: renamed from: mM int
   private static int field_348 = 3;

   class_104(File var1, class_3 var2) {
      this.field_333 = var1.isDirectory() ? var1 : var1.getParentFile();
      this.field_334 = var2;
      this.method_579();

      try {
         this.field_335 = new class_103(this);
      } catch (FileNotFoundException var7) {
      } catch (IOException var8) {
         class_37.method_156("Cannot read account data", var8);
      }

      this.field_336 = new class_102[30];

      for (int var3 = 0; var3 < this.field_336.length; var3++) {
         try {
            this.field_336[var3] = new class_102(this, var3);
         } catch (FileNotFoundException var5) {
         } catch (IOException var6) {
            class_37.method_156("Cannot read file data", var6);
         }
      }

      class_91.method_502(this, this.field_333);
   }

   @Override
   protected void finalize() {
      class_91.method_503(this);
   }

   // $VF: renamed from: X (java.lang.String) void
   @Override
   public void method_24(String var1) {
      var1.equals("containers.index");
   }

   // $VF: renamed from: bS () java.io.File
   @Override
   public File method_17() {
      return this.field_333;
   }

   // $VF: renamed from: cr () void
   private void method_579() {
      class_37.info("Reading Container Index");
      FileInputStream var1 = new FileInputStream(new File(this.field_333, "containers.index"));

      try {
         this.header = class_31.readInt(var1);
         class_37.debug("  header: " + this.header);
         int var2 = class_31.readInt(var1);
         class_37.debug("  count: " + var2);
         this.field_337 = class_31.readInt(var1);
         if (this.field_337 != 0) {
            class_37.debug("  unknown1: " + this.field_337);
         }

         this.name = class_50.method_316(var1);
         class_37.debug("  name: " + this.name);
         this.field_338 = class_31.readInt(var1);
         if (this.field_338 != 0) {
            class_37.debug("  unknown2: " + this.field_338);
         }

         this.field_339 = class_31.readInt(var1);
         if (this.field_339 != 0) {
            class_37.debug("  unknown3: " + this.field_339);
         }

         this.field_340 = class_31.readInt(var1);
         if (this.field_340 != 0) {
            class_37.debug("  unknown4: " + this.field_340);
         }

         this.field_341 = class_50.method_316(var1);
         class_37.debug("  appid: " + this.field_341);
         this.field_342 = class_31.readInt(var1);
         if (this.field_342 != 0) {
            class_37.debug("  unknown5: " + this.field_342);
         }

         this.field_343 = class_31.readInt(var1);
         if (this.field_343 != 0) {
            class_37.debug("  unknown6: " + this.field_343);
         }

         this.field_344 = new ArrayList();

         for (int var3 = 0; var3 < var2; var3++) {
            this.field_344.add(new class_99(this, var1));
         }

         if (var1.read() >= 0) {
            throw new IOException("Invalid footer");
         }
      } finally {
         var1.close();
      }
   }

   // $VF: renamed from: cs () void
   private void method_580() {
      FileOutputStream var1 = new FileOutputStream(new File(this.field_333, "containers.index"));

      try {
         class_31.method_118(var1, this.header);
         class_31.method_118(var1, this.field_344.size());
         class_31.method_118(var1, this.field_337);
         class_50.method_317(var1, this.name);
         class_31.method_118(var1, this.field_338);
         class_31.method_118(var1, this.field_339);
         class_31.method_118(var1, this.field_340);
         class_50.method_317(var1, this.field_341);
         class_31.method_118(var1, this.field_342);
         class_31.method_118(var1, this.field_343);

         for (class_99 var2 : this.field_344) {
            var2.write(var1);
         }
      } finally {
         var1.close();
      }
   }

   // $VF: renamed from: Z (java.lang.String) nomanssave.fW
   private class_99 method_581(String var1) {
      for (class_99 var2 : this.field_344) {
         if (var2.name.equals(var1)) {
            return var2;
         }
      }

      throw new FileNotFoundException(var1);
   }

   // $VF: renamed from: ct () java.lang.String
   private String method_582() {
      File var2;
      String var3;
      boolean var6;
      do {
         var6 = true;
         var3 = class_50.method_310();

         for (class_99 var4 : this.field_344) {
            var6 &= var4.field_306.equals(var3);
         }

         var2 = new File(this.field_333, var3);
         var6 &= var2.exists();
      } while (!var6);

      if (!var2.mkdir()) {
         throw new FileNotFoundException(var3);
      } else {
         return var3;
      }
   }

   // $VF: renamed from: bT () nomanssave.fr
   @Override
   public class_8 method_18() {
      return this.field_335;
   }

   // $VF: renamed from: bU () nomanssave.ft[]
   @Override
   public class_10[] method_19() {
      class_10[] var1 = new class_10[15];

      for (int var2 = 0; var2 < 15; var2++) {
         var1[var2] = new class_98(this, var2);
      }

      return var1;
   }

   // $VF: renamed from: W (java.lang.String) int
   @Override
   public int method_21(String var1) {
      Matcher var2 = field_330.matcher(var1);
      return !var2.matches() ? -1 : Integer.parseInt(var2.group(1));
   }

   // $VF: renamed from: an (int) int
   private static int method_583(int var0) {
      return 2147418112 & var0 | (3584 & var0) >> 9;
   }

   // $VF: renamed from: h (java.io.File) boolean
   private static boolean method_584(File var0) {
      File[] var1 = var0.listFiles();
      if (var1 != null) {
         for (File var2 : var1) {
            method_584(var2);
         }
      }

      return var0.delete();
   }

   // $VF: renamed from: a (java.io.InputStream, int) java.io.InputStream
   private static InputStream method_585(InputStream var0, int var1) {
      try {
         boolean var2 = true;
         if (!var0.markSupported()) {
            var0 = new BufferedInputStream((InputStream)var0);
         }

         var0.mark(field_329.length);
         byte[] var3 = new byte[field_329.length];
         class_31.readFully((InputStream)var0, var3);

         for (int var4 = 0; var4 < field_329.length; var4++) {
            if (var3[var4] != field_329[var4]) {
               var2 = false;
               break;
            }
         }

         if (var2) {
            return new class_59((InputStream)var0);
         } else {
            var0.reset();
            byte[] var7 = new byte[16];
            var0.mark(var7.length);
            class_31.readFully((InputStream)var0, var7);
            if ((255 & var7[0]) == 229 && (255 & var7[1]) == 161 && (255 & var7[2]) == 237 && (255 & var7[3]) == 254) {
               return new class_61((InputStream)var0, var7);
            } else {
               var0.reset();
               return new class_60((InputStream)var0, var1);
            }
         }
      } catch (IOException var6) {
         try {
            var0.close();
         } catch (IOException var5) {
         }

         throw var6;
      }
   }
}
