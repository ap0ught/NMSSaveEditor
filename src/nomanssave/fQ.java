package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class fQ {
   final String filename;
   final int lO;
   fI mx;
   fJ mt;

   fQ(fJ var1, String var2, int var3, boolean var4) {
      this.mt = var1;
      this.filename = var2;
      this.lO = var3;
      if (var4) {
         FileInputStream var5 = new FileInputStream(new File(fJ.a(var1), "mf_" + var2));

         try {
            hc.info("Reading metadata for " + var2);
            byte[] var6 = new byte[1024];
            int var7 = var5.read(var6);
            this.mx = fI.a(var3, var6, 0, var7);
         } finally {
            var5.close();
         }

         int var11 = this.mx.ch();
         if (var11 != 0) {
            hc.debug("  DecompressedSize: " + var11);
         }

         int var12 = this.mx.ci();
         if (var12 != 0) {
            hc.debug("  CompressedSize: " + var12);
         }

         int var8 = this.mx.cj();
         if (var8 != 0) {
            hc.info("  TotalPlayTime: " + fq.c((long)var8));
         }
      } else {
         hc.info("Creating new metadata for " + var2);
         this.mx = fI.am(var3);
      }
   }

   public String K() {
      return this.filename;
   }

   public long lastModified() {
      return new File(fJ.a(this.mt), "mf_" + this.filename).lastModified();
   }

   eY a(eG param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/io/BufferedInputStream
      // 03: dup
      // 04: new java/io/FileInputStream
      // 07: dup
      // 08: new java/io/File
      // 0b: dup
      // 0c: aload 0
      // 0d: getfield nomanssave/fQ.mt Lnomanssave/fJ;
      // 10: invokestatic nomanssave/fJ.a (Lnomanssave/fJ;)Ljava/io/File;
      // 13: aload 0
      // 14: getfield nomanssave/fQ.filename Ljava/lang/String;
      // 17: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 1a: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 1d: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 20: astore 2
      // 21: bipush 16
      // 23: newarray 8
      // 25: astore 3
      // 26: aload 2
      // 27: aload 3
      // 28: arraylength
      // 29: invokevirtual java/io/InputStream.mark (I)V
      // 2c: aload 2
      // 2d: aload 3
      // 2e: invokestatic nomanssave/hk.readFully (Ljava/io/InputStream;[B)V
      // 31: sipush 255
      // 34: aload 3
      // 35: bipush 0
      // 36: baload
      // 37: iand
      // 38: sipush 229
      // 3b: if_icmpne 72
      // 3e: sipush 255
      // 41: aload 3
      // 42: bipush 1
      // 43: baload
      // 44: iand
      // 45: sipush 161
      // 48: if_icmpne 72
      // 4b: sipush 255
      // 4e: aload 3
      // 4f: bipush 2
      // 50: baload
      // 51: iand
      // 52: sipush 237
      // 55: if_icmpne 72
      // 58: sipush 255
      // 5b: aload 3
      // 5c: bipush 3
      // 5d: baload
      // 5e: iand
      // 5f: sipush 254
      // 62: if_icmpne 72
      // 65: new nomanssave/gX
      // 68: dup
      // 69: aload 2
      // 6a: aload 3
      // 6b: invokespecial nomanssave/gX.<init> (Ljava/io/InputStream;[B)V
      // 6e: astore 2
      // 6f: goto 76
      // 72: aload 2
      // 73: invokevirtual java/io/InputStream.reset ()V
      // 76: aconst_null
      // 77: astore 4
      // 79: aconst_null
      // 7a: astore 5
      // 7c: new nomanssave/ff
      // 7f: dup
      // 80: aload 2
      // 81: bipush 6
      // 83: invokespecial nomanssave/ff.<init> (Ljava/io/InputStream;I)V
      // 86: astore 6
      // 88: aload 6
      // 8a: aload 1
      // 8b: invokevirtual nomanssave/ff.a (Lnomanssave/eG;)Lnomanssave/eY;
      // 8e: astore 8
      // 90: aload 6
      // 92: ifnull 9a
      // 95: aload 6
      // 97: invokevirtual nomanssave/ff.close ()V
      // 9a: aload 2
      // 9b: invokevirtual java/io/InputStream.close ()V
      // 9e: aload 8
      // a0: areturn
      // a1: astore 4
      // a3: aload 6
      // a5: ifnull ad
      // a8: aload 6
      // aa: invokevirtual nomanssave/ff.close ()V
      // ad: aload 4
      // af: athrow
      // b0: astore 5
      // b2: aload 4
      // b4: ifnonnull be
      // b7: aload 5
      // b9: astore 4
      // bb: goto cc
      // be: aload 4
      // c0: aload 5
      // c2: if_acmpeq cc
      // c5: aload 4
      // c7: aload 5
      // c9: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // cc: aload 4
      // ce: athrow
      // cf: astore 7
      // d1: aload 2
      // d2: invokevirtual java/io/InputStream.close ()V
      // d5: aload 7
      // d7: athrow
   }

   byte[] ah(int var1) {
      InputStream var2 = new FileInputStream(new File(fJ.a(this.mt), this.filename));

      byte[] var7;
      try {
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         byte[] var4 = new byte[1024];
         hk.readFully((InputStream)var2, var4, 0, 16);
         if ((255 & var4[0]) == 229 && (255 & var4[1]) == 161 && (255 & var4[2]) == 237 && (255 & var4[3]) == 254) {
            var2 = new gX((InputStream)var2, var4);
         } else {
            var3.write(var4, 0, 16);
         }

         int var5;
         while ((var5 = var2.read(var4)) >= 0) {
            var3.write(var4, 0, var5);
            if (var3.size() >= var1) {
               break;
            }
         }

         var7 = var3.toByteArray();
      } finally {
         var2.close();
      }

      return var7;
   }

   void a(String var1, fn var2, String var3, String var4) {
      File var5 = new File(fJ.a(this.mt), "mf_" + this.filename);
      File var6 = new File(fJ.a(this.mt), this.filename);
      Properties var7 = new Properties();
      var7.setProperty("ArchiveNumber", Integer.toString(this.lO));
      var7.setProperty("ManifestFile", "mf_" + this.filename);
      var7.setProperty("StorageFile", this.filename);
      var7.setProperty("LastModified", Long.toString(var5.lastModified()));
      if (var2 != null) {
         var7.setProperty("GameMode", var2.name());
      }

      if (var3 != null) {
         var7.setProperty("SaveName", var3);
      }

      if (var4 != null) {
         var7.setProperty("Description", var4);
      }

      String var8 = var1 + "." + System.currentTimeMillis() + ".zip";
      File var9 = new File(aH.cG, var8);
      ZipOutputStream var10 = new ZipOutputStream(new FileOutputStream(var9));

      try {
         byte[] var12 = new byte[1024];
         ZipEntry var13 = new ZipEntry(var5.getName());
         var10.putNextEntry(var13);
         FileInputStream var14 = new FileInputStream(var5);

         int var11;
         try {
            while ((var11 = var14.read(var12)) >= 0) {
               var10.write(var12, 0, var11);
            }
         } finally {
            var14.close();
         }

         var13 = new ZipEntry(var6.getName());
         var10.putNextEntry(var13);
         FileInputStream var15 = new FileInputStream(var6);

         try {
            while ((var11 = var15.read(var12)) >= 0) {
               var10.write(var12, 0, var11);
            }
         } finally {
            var15.close();
         }

         var13 = new ZipEntry("saveinfo.txt");
         var10.putNextEntry(var13);
         var7.store(var10, "");
      } finally {
         var10.close();
      }

      var9.setLastModified(var5.lastModified());
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void a(eY var1, boolean var2) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Throwable var4 = null;
      Object var5 = null;

      try {
         fj var6 = new fj(var3, 2);

         try {
            var6.h(var1);
         } finally {
            if (var6 != null) {
               var6.close();
            }
         }
      } catch (Throwable var33) {
         if (var4 == null) {
            var4 = var33;
         } else if (var4 != var33) {
            var4.addSuppressed(var33);
         }

         throw var4;
      }

      byte[] var35 = var3.toByteArray();
      int var36 = 0;
      OutputStream var37 = new FileOutputStream(new File(fJ.a(this.mt), this.filename));

      try {
         if (var2) {
            var37 = new gZ(var37);
         }

         var37.write(var35);
         if (var2) {
            var36 = ((gZ)var37).ci();
         }
      } finally {
         var37.close();
      }

      if (!this.mx.ce()) {
         hc.warn("Metadata version could not be upgraded");
      }

      byte[] var7 = new byte[32];
      byte[] var8 = new byte[16];
      if (!var2) {
         try {
            MessageDigest var9 = MessageDigest.getInstance("SHA-256");
            var7 = var9.digest(var35);
            var8 = fJ.d(var7, var35);
         } catch (NoSuchAlgorithmException var31) {
            hc.a("Error generating SHA-256 hash", var31);
         }
      }

      this.mx.e(var7);
      this.mx.f(var8);
      this.mx.ak(var36);
      this.mx.aj(var35.length);
      var37 = new FileOutputStream(new File(fJ.a(this.mt), "mf_" + this.filename));

      try {
         var37.write(this.mx.encode());
      } finally {
         var37.close();
      }
   }
}
