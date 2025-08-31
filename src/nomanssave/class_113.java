package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.fJ
public class class_113 implements class_7 {
   // $VF: renamed from: lV java.util.regex.Pattern
   private static final Pattern field_374 = Pattern.compile("save(\\d*)\\.hg");
   // $VF: renamed from: lW java.util.regex.Pattern
   private static final Pattern field_375 = Pattern.compile("backup(\\d*)\\.\\d*\\.zip");
   // $VF: renamed from: lX java.io.File
   private final File field_376;
   // $VF: renamed from: lE nomanssave.fR
   private final class_3 field_377;
   // $VF: renamed from: mr nomanssave.fK
   private class_112 field_378;
   // $VF: renamed from: ms nomanssave.fM[]
   private class_111[] field_379;

   class_113(File var1, class_3 var2) {
      this.field_376 = var1;
      this.field_377 = var2;

      try {
         this.field_378 = new class_112(this);
      } catch (FileNotFoundException var5) {
      } catch (IOException var6) {
         class_37.method_156("cannot read file metadata: mf_accountdata.hg", var6);
      }

      this.field_379 = new class_111[30];

      for (int var3 = 0; var3 < this.field_379.length; var3++) {
         try {
            this.field_379[var3] = new class_111(this, var3);
         } catch (FileNotFoundException var7) {
         } catch (IOException var8) {
            class_37.method_156("cannot read file metadata: mf_save" + (var3 == 0 ? "" : Integer.toString(var3 + 1)) + ".hg", var8);
         }
      }

      class_91.method_502(this, var1);
   }

   @Override
   protected void finalize() {
      class_91.method_503(this);
   }

   // $VF: renamed from: X (java.lang.String) void
   @Override
   public void method_24(String var1) {
      if (var1.equals("accountdata.hg")) {
         try {
            this.field_378 = new class_112(this);
            class_37.info("Account data reloaded from storage.");
         } catch (FileNotFoundException var5) {
            this.field_378 = null;
            class_37.info("Account data deleted from storage.");
         } catch (IOException var6) {
            this.field_378 = null;
            class_37.method_156("cannot read file metadata: mf_accountdata.hg", var6);
         }

         this.field_377.method_3(this);
      }

      Matcher var2 = field_374.matcher(var1);
      if (var2.matches()) {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;

         try {
            this.field_379[var3] = new class_111(this, var3);
            class_37.info("Save file reloaded from storage: " + var1);
         } catch (FileNotFoundException var7) {
            this.field_379[var3] = null;
            class_37.info("Save file deleted from storage: " + var1);
         } catch (IOException var8) {
            this.field_379[var3] = null;
            class_37.method_156("cannot read file metadata: mf_save" + (var3 == 0 ? "" : Integer.toString(var3 + 1)) + ".hg", var8);
         }

         this.field_377.method_4(this, var3 / 2, var1);
      }
   }

   // $VF: renamed from: bS () java.io.File
   @Override
   public File method_17() {
      return this.field_376;
   }

   // $VF: renamed from: bT () nomanssave.fr
   @Override
   public class_8 method_18() {
      return this.field_378;
   }

   // $VF: renamed from: bU () nomanssave.ft[]
   @Override
   public class_10[] method_19() {
      class_10[] var1 = new class_10[15];

      for (int var2 = 0; var2 < 15; var2++) {
         var1[var2] = new class_108(this, var2);
      }

      return var1;
   }

   // $VF: renamed from: W (java.lang.String) int
   @Override
   public int method_21(String var1) {
      Matcher var2 = field_374.matcher(var1);
      if (!var2.matches()) {
         return -1;
      } else {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;
         return var3 / 2;
      }
   }

   // $VF: renamed from: bW () boolean
   @Override
   public boolean method_22() {
      return true;
   }

   // $VF: renamed from: a (int, nomanssave.eY) java.lang.String
   @Override
   public String method_23(int var1, class_137 var2) {
      if (this.field_379[var1 * 2] != null) {
         this.field_379[var1 * 2].method_620();
         this.field_379[var1 * 2] = null;
      }

      if (this.field_379[var1 * 2 + 1] != null) {
         this.field_379[var1 * 2 + 1].method_620();
         this.field_379[var1 * 2 + 1] = null;
      }

      this.field_379[var1 * 2] = new class_111(this, var1 * 2, var2);
      return this.field_379[var1 * 2].filename;
   }

   // $VF: renamed from: a (long[], int, int) byte[]
   private static byte[] method_621(long[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2 * 4];

      for (int var4 = 0; var4 < var2; var4++) {
         var3[var4 * 4] = (byte)((int)(var0[var1 + var4] & 255L));
         var3[var4 * 4 + 1] = (byte)((int)(var0[var1 + var4] >> 8 & 255L));
         var3[var4 * 4 + 2] = (byte)((int)(var0[var1 + var4] >> 16 & 255L));
         var3[var4 * 4 + 3] = (byte)((int)(var0[var1 + var4] >> 24 & 255L));
      }

      return var3;
   }

   // $VF: renamed from: c (byte[], byte[]) byte[]
   private static byte[] method_622(byte[] var0, byte[] var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      var2.write(var0, 0, var0.length);
      var2.write(var1, 0, var1.length);
      long[] var3 = new long[]{96176015842230784L, -8446744073709551617L};
      class_33.method_138(var2.toByteArray(), var3);
      long[] var4 = new long[]{var3[0] & 4294967295L, var3[0] >>> 32 & 4294967295L, var3[1] & 4294967295L, var3[1] >>> 32 & 4294967295L};
      return method_621(var4, 0, 4);
   }
}
