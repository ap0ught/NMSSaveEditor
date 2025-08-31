package nomanssave;

import java.io.FilterInputStream;
import java.io.InputStream;

// $VF: renamed from: nomanssave.hm
public class class_59 extends FilterInputStream {
   // $VF: renamed from: sa nomanssave.ha
   private class_60 field_159;
   // $VF: renamed from: sb int
   private int field_160;

   public class_59(InputStream var1) {
      super(var1);
      byte[] var2 = new byte[8];
      class_31.readFully(var1, var2);
      int var3 = 255 & var2[0] | (255 & var2[1]) << 8 | (255 & var2[2]) << 16 | (255 & var2[3]) << 24;
      int var4 = 255 & var2[4] | (255 & var2[5]) << 8 | (255 & var2[6]) << 16 | (255 & var2[7]) << 24;
      this.field_159 = new class_60(new class_57(this, var4, null), var3);
      this.field_160 = 1;
   }

   public int getFrameCount() {
      return this.field_160;
   }

   // $VF: renamed from: ej () boolean
   private boolean method_331() {
      byte[] var1 = new byte[8];
      class_31.readFully(this.in, var1);
      int var2 = 255 & var1[0] | (255 & var1[1]) << 8 | (255 & var1[2]) << 16 | (255 & var1[3]) << 24;
      int var3 = 255 & var1[4] | (255 & var1[5]) << 8 | (255 & var1[6]) << 16 | (255 & var1[7]) << 24;
      this.field_159 = new class_60(new class_57(this, var3, null), var2);
      this.field_160++;
      return true;
   }

   @Override
   public int read() {
      return this.field_159 != null && (this.field_159.available() != 0 || this.method_331()) ? this.field_159.read() : -1;
   }

   @Override
   public int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      return this.field_159 != null && (this.field_159.available() != 0 || this.method_331()) ? this.field_159.read(var1, var2, var3) : -1;
   }
}
