package nomanssave;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class fL implements fs {
   final fJ mt;
   final int mb;
   final File mc;
   final String mu;
   final String md;
   final fn be;
   final String mv;
   final String description;

   fL(fJ var1, String var2, int var3) {
      this.mt = var1;
      this.mb = var3;
      this.mc = new File(aH.cG, var2);
      ZipFile var4 = new ZipFile(this.mc);

      try {
         ZipEntry var5 = var4.getEntry("saveinfo.txt");
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         Properties var6 = new Properties();
         var6.load(var4.getInputStream(var5));
         this.mu = var6.getProperty("ManifestFile");
         this.md = var6.getProperty("StorageFile");
         if (this.mu == null || this.md == null) {
            throw new IOException("Invalid backup file");
         }

         String var7 = var6.getProperty("GameMode");
         this.be = var7 == null ? null : fn.valueOf(var7);
         this.mv = var6.getProperty("SaveName");
         this.description = var6.getProperty("Description");
      } catch (NumberFormatException var11) {
         throw new IOException("Invalid backup file");
      } finally {
         var4.close();
      }
   }

   @Override
   public fn L() {
      return this.be;
   }

   @Override
   public String K() {
      return this.mc.getName();
   }

   @Override
   public long lastModified() {
      return this.mc.lastModified();
   }

   @Override
   public String getName() {
      return this.mv;
   }

   @Override
   public String getDescription() {
      return this.description;
   }

   @Override
   public eY M() {
      ZipFile zipFile = new ZipFile(this.mc);
      try {
         ZipEntry entry = zipFile.getEntry(this.md);
         if (entry == null) {
            throw new IOException("Invalid backup file");
         }
         
         InputStream inputStream = new BufferedInputStream(
            zipFile.getInputStream(entry)
         );
         
         try {
            // Check for compression signature
            byte[] header = new byte[16];
            inputStream.mark(header.length);
            hk.readFully(inputStream, header);
            
            // Check magic bytes for compression: 0xE5, 0xA1, 0xED, 0xFE
            if ((header[0] & 0xFF) == 0xE5 && 
                (header[1] & 0xFF) == 0xA1 && 
                (header[2] & 0xFF) == 0xED && 
                (header[3] & 0xFF) == 0xFE) {
               inputStream = new gX(inputStream, header);
            } else {
               inputStream.reset();
            }
            
            // Create stream reader
            ff reader = new ff(inputStream, this.mb);
            try {
               return reader.bK();
            } finally {
               reader.close();
            }
         } finally {
            inputStream.close();
         }
      } finally {
         zipFile.close();
      }
      // 071: sipush 237
      // 074: if_icmpne 095
      // 077: sipush 255
      // 07a: aload 6
      // 07c: bipush 3
      // 07d: baload
      // 07e: iand
      // 07f: sipush 254
      // 082: if_icmpne 095
      // 085: new nomanssave/gX
      // 088: dup
      // 089: aload 5
      // 08b: aload 6
      // 08d: invokespecial nomanssave/gX.<init> (Ljava/io/InputStream;[B)V
      // 090: astore 5
      // 092: goto 09a
      // 095: aload 5
      // 097: invokevirtual java/io/InputStream.reset ()V
      // 09a: aconst_null
      // 09b: astore 7
      // 09d: aconst_null
      // 09e: astore 8
      // 0a0: new nomanssave/ff
      // 0a3: dup
      // 0a4: aload 5
      // 0a6: bipush 6
      // 0a8: invokespecial nomanssave/ff.<init> (Ljava/io/InputStream;I)V
      // 0ab: astore 9
      // 0ad: aload 9
      // 0af: getstatic nomanssave/eG.jV Lnomanssave/eG;
      // 0b2: invokevirtual nomanssave/ff.a (Lnomanssave/eG;)Lnomanssave/eY;
      // 0b5: astore 11
      // 0b7: aload 9
      // 0b9: ifnull 0c1
      // 0bc: aload 9
      // 0be: invokevirtual nomanssave/ff.close ()V
      // 0c1: aload 5
      // 0c3: invokevirtual java/io/InputStream.close ()V
      // 0c6: aload 3
      // 0c7: ifnull 0ce
      // 0ca: aload 3
      // 0cb: invokevirtual java/util/zip/ZipFile.close ()V
      // 0ce: aload 11
      // 0d0: areturn
      // 0d1: astore 7
      // 0d3: aload 9
      // 0d5: ifnull 0dd
      // 0d8: aload 9
      // 0da: invokevirtual nomanssave/ff.close ()V
      // 0dd: aload 7
      // 0df: athrow
      // 0e0: astore 8
      // 0e2: aload 7
      // 0e4: ifnonnull 0ee
      // 0e7: aload 8
      // 0e9: astore 7
      // 0eb: goto 0fc
      // 0ee: aload 7
      // 0f0: aload 8
      // 0f2: if_acmpeq 0fc
      // 0f5: aload 7
      // 0f7: aload 8
      // 0f9: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0fc: aload 7
      // 0fe: athrow
      // 0ff: astore 10
      // 101: aload 5
      // 103: invokevirtual java/io/InputStream.close ()V
      // 106: aload 10
      // 108: athrow
      // 109: astore 1
      // 10a: aload 3
      // 10b: ifnull 112
      // 10e: aload 3
      // 10f: invokevirtual java/util/zip/ZipFile.close ()V
      // 112: aload 1
      // 113: athrow
      // 114: astore 2
      // 115: aload 1
      // 116: ifnonnull 11e
      // 119: aload 2
      // 11a: astore 1
      // 11b: goto 128
      // 11e: aload 1
      // 11f: aload 2
      // 120: if_acmpeq 128
      // 123: aload 1
      // 124: aload 2
      // 125: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 128: aload 1
      // 129: athrow
   }

   @Override
   public String b(eY var1) {
      hc.info("Writing new save file...");
      String var2;
      if (fJ.b(this.mt)[this.mb] != null) {
         var2 = fJ.b(this.mt)[this.mb].b(var1);
      } else {
         fJ.b(this.mt)[this.mb] = new fM(this.mt, this.mb, var1);
         var2 = fJ.b(this.mt)[this.mb].filename;
      }

      hc.info("Finished.");
      return var2;
   }

   @Override
   public String toString() {
      return this.mc.getName();
   }
}
