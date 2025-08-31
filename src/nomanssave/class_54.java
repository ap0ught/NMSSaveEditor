package nomanssave;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

// $VF: renamed from: nomanssave.ho
public class class_54 extends FilterOutputStream {
   // $VF: renamed from: se net.jpountz.lz4.LZ4Factory
   private static final LZ4Factory field_139 = LZ4Factory.safeInstance();
   // $VF: renamed from: sf net.jpountz.lz4.LZ4Compressor
   private final LZ4Compressor field_140 = field_139.fastCompressor();
   private byte[] buffer = new byte[1048576];
   // $VF: renamed from: sg int
   private int field_141 = 0;
   // $VF: renamed from: sh int
   private int field_142 = 0;
   // $VF: renamed from: si int
   private int field_143 = 0;

   public class_54(OutputStream var1) {
      super(var1);
   }

   @Override
   public void write(int var1) {
      if (this.field_141 == this.buffer.length) {
         this.method_322();
      }

      this.buffer[this.field_141++] = (byte)var1;
   }

   @Override
   public void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) {
      if (var3 == this.buffer.length) {
         this.method_322();
      }

      while (var3 >= this.buffer.length - this.field_141) {
         int var4 = this.buffer.length - this.field_141;
         System.arraycopy(var1, var2, this.buffer, this.field_141, var4);
         this.field_141 = this.buffer.length;
         this.method_322();
         var2 += var4;
         var3 -= var4;
      }

      if (var3 > 0) {
         System.arraycopy(var1, var2, this.buffer, this.field_141, var3);
         this.field_141 += var3;
      }
   }

   // $VF: renamed from: ek () void
   private void method_322() {
      int var1 = this.field_140.maxCompressedLength(this.field_141);
      byte[] var2 = new byte[var1];
      int var3 = this.field_140.compress(this.buffer, 0, this.field_141, var2, 0, var1);
      byte[] var4 = new byte[]{
         (byte)(0xFF & this.field_141),
         (byte)(0xFF & this.field_141 >> 8),
         (byte)(0xFF & this.field_141 >> 16),
         (byte)(0xFF & this.field_141 >> 24),
         (byte)(0xFF & var3),
         (byte)(0xFF & var3 >> 8),
         (byte)(0xFF & var3 >> 16),
         (byte)(0xFF & var3 >> 24)
      };
      this.out.write(var4);
      this.out.write(var2, 0, var3);
      this.field_142 = this.field_142 + this.field_141;
      this.field_141 = 0;
      this.field_143 += var3 + 8;
   }

   // $VF: renamed from: ch () int
   public int method_323() {
      return this.field_142;
   }

   // $VF: renamed from: ci () int
   public int method_324() {
      return this.field_143;
   }

   @Override
   public void flush() {
      if (this.field_141 > 0) {
         this.method_322();
      }

      this.out.flush();
   }

   @Override
   public void close() {
      try {
         if (this.field_141 > 0) {
            this.method_322();
         }
      } finally {
         this.out.close();
      }
   }
}
