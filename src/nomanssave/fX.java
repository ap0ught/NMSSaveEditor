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

abstract class fX {
   final fT mN;
   final fW mO;
   final File mX;
   final File mY;
   final fS mZ;
   int mode;

   fX(fT var1, fV var2) {
      this.mN = var1;
      int var3 = fT.c(var1).size();

      for (int var4 = 0; var4 < fT.c(var1).size(); var4++) {
         int var5 = ((fW)fT.c(var1).get(var4)).name.compareTo(var2.mO.name);
         if (var5 == 0) {
            fW var6 = (fW)fT.c(var1).remove(var4);
            fT.i(new File(fT.d(var1), var6.mU));
         }

         if (var5 >= 0) {
            var3 = var4;
            break;
         }
      }

      this.mO = new fW(var1, var2.mO);
      File var9 = new File(fT.d(var1), this.mO.mU);
      if (!var9.mkdir()) {
         throw new IOException("Unable to create container path");
      } else {
         this.mX = new File(var9, "container." + this.mO.mT);
         this.mZ = new fS(new File(var9, var2.mP));
         this.mY = new File(var9, var2.mR);
         FileOutputStream var10 = new FileOutputStream(this.mX);

         try {
            var2.a(var10);
         } finally {
            var10.close();
         }

         fT.c(var1).add(var3, this.mO);
      }
   }

   fX(fT var1, String var2) {
      this.mN = var1;
      this.mO = fT.a(var1, var2);
      File var3 = new File(fT.d(var1), this.mO.mU);
      if (!var3.isDirectory()) {
         throw new FileNotFoundException(this.mO.mU);
      } else {
         this.mX = new File(var3, "container." + this.mO.mT);
         hc.info(this.mO.filename);
         File var4 = null;
         File var5 = null;
         FileInputStream var6 = new FileInputStream(this.mX);

         try {
            int var7 = hk.readInt(var6);
            hc.debug("  header: " + Integer.toHexString(var7));
            int var8 = hk.readInt(var6);

            for (int var9 = 0; var9 < var8; var9++) {
               String var10 = gc.d(var6);
               hc.debug("  name: " + var10);
               String var11 = gc.a(var6);
               hc.debug("  filename: " + var11);
               String var12 = gc.a(var6);
               if (!var11.equals(var12)) {
                  hc.debug("  filename2: " + var12);
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
            if (this.mO.mW != var16) {
               throw new IOException("data size mismatch: " + this.mO.mW);
            } else {
               this.mY = var4;
               this.mZ = new fS(var5);
               this.mZ.cn();
            }
         } else {
            throw new FileNotFoundException("data/meta file missing");
         }
      }
   }

   public String K() {
      return this.mO.filename;
   }

   private InputStream getInputStream() {
      InputStream var1 = fT.b(new FileInputStream(this.mY), this.mZ.ch());
      if (var1 instanceof gX) {
         this.mode = fT.cv();
      } else if (var1 instanceof hm) {
         this.mode = fT.cw();
      } else {
         this.mode = fT.cx();
      }

      return var1;
   }

   private OutputStream getOutputStream() {
      FileOutputStream var1 = new FileOutputStream(this.mY);

      try {
         if (this.mode == fT.cv()) {
            return new gZ(var1);
         } else if (this.mode == fT.cw()) {
            var1.write(fT.cy());
            return new ho(var1);
         } else {
            return new hb(var1);
         }
      } catch (IOException var5) {
         try {
            var1.close();
         } catch (IOException var4) {
         }

         throw var5;
      }
   }

   eY a(eG var1) throws IOException {
      ff reader = new ff(this.getInputStream(), 2);
      try {
         return reader.a(var1);
      } finally {
         if (reader != null) {
            reader.close();
         }
      }
   }

   byte[] ah(int var1) throws IOException {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      InputStream inputStream = this.getInputStream();
      
      try {
         byte[] buffer = new byte[4096];
         int bytesRead;
         while ((bytesRead = inputStream.read(buffer)) >= 0) {
            outputStream.write(buffer, 0, bytesRead);
            if (outputStream.size() >= var1) {
               break;
            }
         }
      } finally {
         if (inputStream != null) {
            inputStream.close();
         }
      }
      
      return outputStream.toByteArray();
   }

   void h(eY var1) throws IOException {
      boolean useCompression = this.mode == fT.cw();
      ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
      
      // Write data to stream
      fj writer = new fj(byteStream, useCompression ? 0 : 2);
      try {
         writer.h(var1);
      } finally {
         if (writer != null) {
            writer.close();
         }
      }
      
      byte[] data = byteStream.toByteArray();
      this.mZ.aj(data.length);
      
      // Write to output
      OutputStream outputStream = this.getOutputStream();
      try {
         outputStream.write(data);
         if (useCompression) {
            outputStream.flush();
            outputStream.write(0);
         }
      } finally {
         if (outputStream != null) {
            outputStream.close();
         }
      }
      
      this.mZ.ak((int)this.mY.length());
      this.mZ.write();
      this.mO.timestamp = System.currentTimeMillis();
      this.mO.mW = this.mY.length() + this.mZ.length();
      fT.e(this.mN);
   }

   void a(String var1, fn var2) {
      Properties var3 = new Properties();
      var3.setProperty("MetaFile", this.mZ.getName());
      var3.setProperty("DataFile", this.mY.getName());
      var3.setProperty("ContainerFile", this.mX.getName());
      if (var2 != null) {
         var3.setProperty("GameMode", var2.name());
      }

      var3.setProperty("IndexData", this.mO.cz());
      String var4 = var1 + "." + System.currentTimeMillis() + ".zip";
      File var5 = new File(aH.cG, var4);
      ZipOutputStream var6 = new ZipOutputStream(new FileOutputStream(var5));

      try {
         ZipEntry var8 = new ZipEntry(this.mZ.getName());
         var6.putNextEntry(var8);
         var6.write(this.mZ.co());
         var8 = new ZipEntry(this.mY.getName());
         var6.putNextEntry(var8);
         byte[] var9 = new byte[1024];
         FileInputStream var10 = new FileInputStream(this.mY);

         int var7;
         try {
            while ((var7 = var10.read(var9)) > 0) {
               var6.write(var9, 0, var7);
            }
         } finally {
            var10.close();
         }

         var8 = new ZipEntry(this.mX.getName());
         var6.putNextEntry(var8);
         var10 = new FileInputStream(this.mX);

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

      var5.setLastModified(this.mO.timestamp);
   }
}
