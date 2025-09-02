package nomanssave;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class fV implements fs {
   final fT mN;
   final fW mO;
   final int mb;
   final File mc;
   final String mP;
   final fS mQ;
   final String mR;
   final String mS;
   final fn be;

   fV(fT var1, String var2, int var3) {
      this.mN = var1;
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
         this.mP = var6.getProperty("MetaFile");
         this.mR = var6.getProperty("DataFile");
         this.mS = var6.getProperty("ContainerFile");
         String var7 = var6.getProperty("IndexData");
         if (this.mP == null || this.mR == null || this.mS == null || var7 == null) {
            throw new IOException("Invalid backup file");
         }

         String var8 = var6.getProperty("GameMode");
         this.be = var8 == null ? null : fn.valueOf(var8);
         this.mO = new fW(var1, var7);
         var5 = var4.getEntry(this.mP);
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         this.mQ = new fS(null);
         this.mQ.read(var4.getInputStream(var5));
      } catch (NumberFormatException var12) {
         throw new IOException("Invalid backup file");
      } finally {
         var4.close();
      }
   }

   void a(FileOutputStream var1) {
      ZipFile var2 = new ZipFile(this.mc);

      try {
         ZipEntry var3 = var2.getEntry(this.mS);
         if (var3 == null) {
            throw new IOException("Invalid backup file");
         }

         InputStream var4 = var2.getInputStream(var3);

         try {
            byte[] var5 = new byte[1024];

            int var6;
            while ((var6 = var4.read(var5)) > 0) {
               var1.write(var5, 0, var6);
            }
         } finally {
            var4.close();
         }
      } finally {
         var2.close();
      }
   }

   @Override
   public String K() {
      return this.mO.filename;
   }

   @Override
   public fn L() {
      return this.be;
   }

   @Override
   public eY M() {
      ZipFile zipFile = new ZipFile(this.mc);
      try {
         ZipEntry entry = zipFile.getEntry(this.mR);
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
      // 1c: ifnonnull 29
      // 1f: new java/io/IOException
      // 22: dup
      // 23: ldc "Invalid backup file"
      // 25: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 28: athrow
      // 29: aconst_null
      // 2a: astore 5
      // 2c: aconst_null
      // 2d: astore 6
      // 2f: new nomanssave/ff
      // 32: dup
      // 33: aload 3
      // 34: aload 4
      // 36: invokevirtual java/util/zip/ZipFile.getInputStream (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      // 39: aload 0
      // 3a: getfield nomanssave/fV.mQ Lnomanssave/fS;
      // 3d: invokevirtual nomanssave/fS.ch ()I
      // 40: invokestatic nomanssave/fT.b (Ljava/io/InputStream;I)Ljava/io/InputStream;
      // 43: bipush 2
      // 44: invokespecial nomanssave/ff.<init> (Ljava/io/InputStream;I)V
      // 47: astore 7
      // 49: aload 7
      // 4b: getstatic nomanssave/eG.jV Lnomanssave/eG;
      // 4e: invokevirtual nomanssave/ff.a (Lnomanssave/eG;)Lnomanssave/eY;
      // 51: aload 7
      // 53: ifnull 5b
      // 56: aload 7
      // 58: invokevirtual nomanssave/ff.close ()V
      // 5b: aload 3
      // 5c: ifnull 63
      // 5f: aload 3
      // 60: invokevirtual java/util/zip/ZipFile.close ()V
      // 63: areturn
      // 64: astore 5
      // 66: aload 7
      // 68: ifnull 70
      // 6b: aload 7
      // 6d: invokevirtual nomanssave/ff.close ()V
      // 70: aload 5
      // 72: athrow
      // 73: astore 6
      // 75: aload 5
      // 77: ifnonnull 81
      // 7a: aload 6
      // 7c: astore 5
      // 7e: goto 8f
      // 81: aload 5
      // 83: aload 6
      // 85: if_acmpeq 8f
      // 88: aload 5
      // 8a: aload 6
      // 8c: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 8f: aload 5
      // 91: athrow
      // 92: astore 1
      // 93: aload 3
      // 94: ifnull 9b
      // 97: aload 3
      // 98: invokevirtual java/util/zip/ZipFile.close ()V
      // 9b: aload 1
      // 9c: athrow
      // 9d: astore 2
      // 9e: aload 1
      // 9f: ifnonnull a7
      // a2: aload 2
      // a3: astore 1
      // a4: goto b1
      // a7: aload 1
      // a8: aload 2
      // a9: if_acmpeq b1
      // ac: aload 1
      // ad: aload 2
      // ae: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // b1: aload 1
      // b2: athrow
   }

   @Override
   public String b(eY var1) {
      hc.info("Writing new save file...");
      String var2;
      if (fT.b(this.mN)[this.mb] != null) {
         fT.b(this.mN)[this.mb].mZ.a(this.mQ);
         var2 = fT.b(this.mN)[this.mb].b(var1);
      } else {
         fT.b(this.mN)[this.mb] = new fY(this.mN, this, var1);
         var2 = fT.b(this.mN)[this.mb].K();
      }

      hc.info("Finished.");
      return var2;
   }

   @Override
   public long lastModified() {
      return this.mO.timestamp;
   }

   @Override
   public String toString() {
      return this.mc.getName();
   }

   @Override
   public String getName() {
      return this.mQ.getName();
   }

   @Override
   public String getDescription() {
      return this.mQ.getDescription();
   }
}
