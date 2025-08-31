package nomanssave;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// $VF: renamed from: nomanssave.gX
public class class_61 extends FilterInputStream {
   // $VF: renamed from: sa nomanssave.ha
   private class_60 field_166;
   // $VF: renamed from: sb int
   private int field_167;

   public class_61(InputStream var1, byte[] var2) {
      super(var1);
      int var3 = 255 & var2[4] | (255 & var2[5]) << 8 | (255 & var2[6]) << 16 | (255 & var2[7]) << 24;
      int var4 = 255 & var2[8] | (255 & var2[9]) << 8 | (255 & var2[10]) << 16 | (255 & var2[11]) << 24;
      this.field_166 = new class_60(new class_58(this, var3, null), var4);
      this.field_167 = 1;
   }

   public int getFrameCount() {
      return this.field_167;
   }

   // $VF: renamed from: ej () boolean
   private boolean method_335() {
      byte[] var1 = new byte[16];
      int var2 = this.in.read(var1, 0, 16);
      if (var2 < 0) {
         this.field_166 = null;
         return false;
      } else if (var2 < 16) {
         throw new IOException("Short read " + var2);
      } else if ((255 & var1[0]) == 229 && (255 & var1[1]) == 161 && (255 & var1[2]) == 237 && (255 & var1[3]) == 254) {
         int var3 = 255 & var1[4] | (255 & var1[5]) << 8 | (255 & var1[6]) << 16 | (255 & var1[7]) << 24;
         int var4 = 255 & var1[8] | (255 & var1[9]) << 8 | (255 & var1[10]) << 16 | (255 & var1[11]) << 24;
         this.field_166 = new class_60(new class_58(this, var3, null), var4);
         this.field_167++;
         return true;
      } else {
         throw new IOException("Invalid header");
      }
   }

   @Override
   public int read() {
      return this.field_166 != null && (this.field_166.available() != 0 || this.method_335()) ? this.field_166.read() : -1;
   }

   @Override
   public int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      return this.field_166 != null && (this.field_166.available() != 0 || this.method_335()) ? this.field_166.read(var1, var2, var3) : -1;
   }
}
