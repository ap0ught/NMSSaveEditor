package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fA implements fq {
   private static final byte[] lA = "NOMANSKY".getBytes();
   private static final Pattern lV = Pattern.compile("savedata(\\d{2})\\.hg", 2);
   private static final Pattern lW = Pattern.compile("ps4_backup(\\d*)\\.\\d*\\.zip", 2);
   private final File lX;
   private final fR lE;
   private fB lY;
   private fD[] lZ;

   fA(File var1, fR var2) {
      this.lX = var1;
      this.lE = var2;

      try {
         this.lY = new fB(this);
      } catch (FileNotFoundException var7) {
      } catch (IOException var8) {
         hc.a("cannot read file metadata: savedata00.hg", var8);
      }

      this.lZ = new fD[30];

      for (int var3 = 0; var3 < this.lZ.length; var3++) {
         try {
            this.lZ[var3] = new fD(this, var3);
         } catch (FileNotFoundException var9) {
         } catch (IOException var10) {
            int var5 = var3 + 2;
            String var6 = "savedata" + (var5 < 10 ? "0" : "") + Integer.toString(var5) + ".hg";
            hc.a("cannot read file metadata: " + var6, var10);
         }
      }

      fl.a(this, var1);
   }

   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static eY a(byte[] var0, eG var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         ff var4 = new ff(new ByteArrayInputStream(var0), 2);

         Throwable var10000;
         label125: {
            try {
               var17 = var4.a(var1);
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

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static byte[] g(eY var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         fj var4 = new fj(var1, 2);

         try {
            var4.h(var0);
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

   @Override
   public File bS() {
      return this.lX;
   }

   @Override
   public fr bT() {
      return this.lY;
   }

   @Override
   public ft[] bU() {
      ft[] var1 = new ft[15];

      for (int var2 = 0; var2 < 15; var2++) {
         var1[var2] = new fE(this, var2);
      }

      return var1;
   }

   @Override
   public int W(String var1) {
      Matcher var2 = lV.matcher(var1);
      if (!var2.matches()) {
         return -1;
      } else {
         int var3 = Integer.parseInt(var2.group(1)) - 2;
         return var3 >= 0 ? var3 / 2 : -1;
      }
   }

   @Override
   public void X(String var1) {
      Matcher var2 = lV.matcher(var1);
      if (var2.matches()) {
         int var3 = Integer.parseInt(var2.group(1)) - 2;
         if (var3 == -2) {
            try {
               this.lY = new fB(this);
               hc.info("Account data reloaded from storage.");
            } catch (FileNotFoundException var7) {
               this.lY = null;
               hc.info("Account data deleted from storage.");
            } catch (IOException var8) {
               this.lY = null;
               hc.a("cannot read file metadata: " + var1, var8);
            }

            this.lE.a(this);
         } else if (var3 >= 0) {
            try {
               this.lZ[var3] = new fD(this, var3);
               hc.info("Save file reloaded from storage: " + var1);
            } catch (FileNotFoundException var5) {
               this.lZ[var3] = null;
               hc.info("Save file deleted from storage: " + var1);
            } catch (IOException var6) {
               this.lZ[var3] = null;
               hc.a("cannot read file metadata: " + var1, var6);
            }

            this.lE.a(this, var3 / 2, var1);
         }
      }
   }
}
