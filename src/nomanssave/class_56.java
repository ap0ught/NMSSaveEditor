package nomanssave;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

// $VF: renamed from: nomanssave.gZ
public class class_56 extends FilterOutputStream {
   // $VF: renamed from: se net.jpountz.lz4.LZ4Factory
   private static final LZ4Factory field_149 = LZ4Factory.safeInstance();
   // $VF: renamed from: sf net.jpountz.lz4.LZ4Compressor
   private final LZ4Compressor field_150 = field_149.fastCompressor();
   private byte[] buffer = new byte[524288];
   // $VF: renamed from: sg int
   private int field_151 = 0;
   // $VF: renamed from: sh int
   private int field_152 = 0;
   // $VF: renamed from: si int
   private int field_153 = 0;

   public class_56(OutputStream var1) {
      super(var1);
   }

   @Override
   public void write(int var1) {
      if (this.field_151 == this.buffer.length) {
         this.method_328();
      }

      this.buffer[this.field_151++] = (byte)var1;
   }

   @Override
   public void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) {
      if (var3 == this.buffer.length) {
         this.method_328();
      }

      while (var3 >= this.buffer.length - this.field_151) {
         int var4 = this.buffer.length - this.field_151;
         System.arraycopy(var1, var2, this.buffer, this.field_151, var4);
         this.field_151 = this.buffer.length;
         this.method_328();
         var2 += var4;
         var3 -= var4;
      }

      if (var3 > 0) {
         System.arraycopy(var1, var2, this.buffer, this.field_151, var3);
         this.field_151 += var3;
      }
   }

   // $VF: renamed from: ek () void
   private void method_328() {
      int var1 = this.field_150.maxCompressedLength(this.field_151);
      byte[] var2 = new byte[var1];
      int var3 = this.field_150.compress(this.buffer, 0, this.field_151, var2, 0, var1);
      byte[] var4 = new byte[]{
         -27,
         -95,
         -19,
         -2,
         (byte)(0xFF & var3),
         (byte)(0xFF & var3 >> 8),
         (byte)(0xFF & var3 >> 16),
         (byte)(0xFF & var3 >> 24),
         (byte)(0xFF & this.field_151),
         (byte)(0xFF & this.field_151 >> 8),
         (byte)(0xFF & this.field_151 >> 16),
         (byte)(0xFF & this.field_151 >> 24),
         0,
         0,
         0,
         0
      };
      this.out.write(var4);
      this.out.write(var2, 0, var3);
      this.field_152 = this.field_152 + this.field_151;
      this.field_151 = 0;
      this.field_153 += var3 + 16;
   }

   // $VF: renamed from: ch () int
   public int method_329() {
      return this.field_152;
   }

   // $VF: renamed from: ci () int
   public int method_330() {
      return this.field_153;
   }

   @Override
   public void flush() {
      if (this.field_151 > 0) {
         this.method_328();
      }

      this.out.flush();
   }

   @Override
   public void close() {
      try {
         if (this.field_151 > 0) {
            this.method_328();
         }
      } finally {
         this.out.close();
      }
   }
}
