package nomanssave;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

// $VF: renamed from: nomanssave.hb
public class class_55 extends FilterOutputStream {
   // $VF: renamed from: se net.jpountz.lz4.LZ4Factory
   private static final LZ4Factory field_144 = LZ4Factory.safeInstance();
   // $VF: renamed from: sm int
   private static final int field_145 = 65536;
   // $VF: renamed from: sf net.jpountz.lz4.LZ4Compressor
   private final LZ4Compressor field_146 = field_144.fastCompressor();
   private byte[] buffer = new byte[65536];
   // $VF: renamed from: sg int
   private int field_147 = 0;
   // $VF: renamed from: si int
   private int field_148 = 0;

   public class_55(OutputStream var1) {
      super(var1);
   }

   // $VF: renamed from: aK (int) void
   private void method_325(int var1) {
      if (this.field_147 + var1 > this.buffer.length) {
         var1 = this.buffer.length + var1;
         int var2 = (this.buffer.length + var1) / 65536;
         if ((this.buffer.length + var1) % 65536 > 0) {
            var2++;
         }

         var2 *= 65536;
         byte[] var3 = new byte[var2];
         System.arraycopy(this.buffer, 0, var3, 0, this.field_147);
         this.buffer = var3;
      }
   }

   @Override
   public void write(int var1) {
      this.method_325(1);
      this.buffer[this.field_147++] = (byte)var1;
   }

   @Override
   public void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) {
      this.method_325(var3);
      System.arraycopy(var1, var2, this.buffer, this.field_147, var3);
      this.field_147 += var3;
   }

   // $VF: renamed from: ch () int
   public int method_326() {
      return this.field_147;
   }

   // $VF: renamed from: ci () int
   public int method_327() {
      return this.field_148;
   }

   @Override
   public void flush() {
      this.out.flush();
   }

   @Override
   public void close() {
      try {
         if (this.field_147 > 0) {
            int var1 = this.field_146.maxCompressedLength(this.field_147);
            byte[] var2 = new byte[var1];
            this.field_148 = this.field_146.compress(this.buffer, 0, this.field_147, var2, 0, var1);
            this.out.write(var2, 0, this.field_148);
         }
      } finally {
         this.out.close();
      }
   }
}
