package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fA
public class class_122 implements class_7 {
   // $VF: renamed from: lA byte[]
   private static final byte[] field_408 = "NOMANSKY".getBytes();
   // $VF: renamed from: lV java.util.regex.Pattern
   private static final Pattern field_409 = Pattern.compile("savedata(\\d{2})\\.hg", 2);
   // $VF: renamed from: lW java.util.regex.Pattern
   private static final Pattern field_410 = Pattern.compile("ps4_backup(\\d*)\\.\\d*\\.zip", 2);
   // $VF: renamed from: lX java.io.File
   private final File field_411;
   // $VF: renamed from: lE nomanssave.fR
   private final class_3 field_412;
   // $VF: renamed from: lY nomanssave.fB
   private class_121 field_413;
   // $VF: renamed from: lZ nomanssave.fD[]
   private class_120[] field_414;

   class_122(File var1, class_3 var2) {
      this.field_411 = var1;
      this.field_412 = var2;

      try {
         this.field_413 = new class_121(this);
      } catch (FileNotFoundException var7) {
      } catch (IOException var8) {
         class_37.method_156("cannot read file metadata: savedata00.hg", var8);
      }

      this.field_414 = new class_120[30];

      for (int var3 = 0; var3 < this.field_414.length; var3++) {
         try {
            this.field_414[var3] = new class_120(this, var3);
         } catch (FileNotFoundException var9) {
         } catch (IOException var10) {
            int var5 = var3 + 2;
            String var6 = "savedata" + (var5 < 10 ? "0" : "") + Integer.toString(var5) + ".hg";
            class_37.method_156("cannot read file metadata: " + var6, var10);
         }
      }

      class_91.method_502(this, var1);
   }

   // $VF: renamed from: a (byte[], nomanssave.eG) nomanssave.eY
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static class_137 method_655(byte[] var0, class_297 var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_96 var4 = new class_96(new ByteArrayInputStream(var0), 2);

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

   // $VF: renamed from: g (nomanssave.eY) byte[]
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static byte[] method_656(class_137 var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(var1, 2);

         try {
            var4.method_511(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   // $VF: renamed from: bS () java.io.File
   @Override
   public File method_17() {
      return this.field_411;
   }

   // $VF: renamed from: bT () nomanssave.fr
   @Override
   public class_8 method_18() {
      return this.field_413;
   }

   // $VF: renamed from: bU () nomanssave.ft[]
   @Override
   public class_10[] method_19() {
      class_10[] var1 = new class_10[15];

      for (int var2 = 0; var2 < 15; var2++) {
         var1[var2] = new class_117(this, var2);
      }

      return var1;
   }

   // $VF: renamed from: W (java.lang.String) int
   @Override
   public int method_21(String var1) {
      Matcher var2 = field_409.matcher(var1);
      if (!var2.matches()) {
         return -1;
      } else {
         int var3 = Integer.parseInt(var2.group(1)) - 2;
         return var3 >= 0 ? var3 / 2 : -1;
      }
   }

   // $VF: renamed from: X (java.lang.String) void
   @Override
   public void method_24(String var1) {
      Matcher var2 = field_409.matcher(var1);
      if (var2.matches()) {
         int var3 = Integer.parseInt(var2.group(1)) - 2;
         if (var3 == -2) {
            try {
               this.field_413 = new class_121(this);
               class_37.info("Account data reloaded from storage.");
            } catch (FileNotFoundException var7) {
               this.field_413 = null;
               class_37.info("Account data deleted from storage.");
            } catch (IOException var8) {
               this.field_413 = null;
               class_37.method_156("cannot read file metadata: " + var1, var8);
            }

            this.field_412.method_3(this);
         } else if (var3 >= 0) {
            try {
               this.field_414[var3] = new class_120(this, var3);
               class_37.info("Save file reloaded from storage: " + var1);
            } catch (FileNotFoundException var5) {
               this.field_414[var3] = null;
               class_37.info("Save file deleted from storage: " + var1);
            } catch (IOException var6) {
               this.field_414[var3] = null;
               class_37.method_156("cannot read file metadata: " + var1, var6);
            }

            this.field_412.method_4(this, var3 / 2, var1);
         }
      }
   }
}
