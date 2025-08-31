package nomanssave;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// $VF: renamed from: nomanssave.ha
public class class_60 extends FilterInputStream {
   // $VF: renamed from: sj boolean
   private boolean field_161;
   private byte[] buffer;
   // $VF: renamed from: sk int
   private int field_162;
   // $VF: renamed from: sg int
   private int field_163;
   // $VF: renamed from: sl int
   private int field_164;
   // $VF: renamed from: eof boolean
   private boolean field_165;

   public class_60(InputStream var1, int var2) {
      super(var1);
      if (var2 == 0) {
         this.field_161 = true;
         this.buffer = new byte[1048576];
      } else {
         this.field_161 = false;
         this.buffer = new byte[var2];
      }

      this.field_163 = 0;
      this.field_162 = 0;
      this.field_165 = false;
   }

   // $VF: renamed from: aJ (int) void
   private void method_333(int var1) {
      if (this.field_163 + var1 > this.buffer.length) {
         if (!this.field_161) {
            throw new IOException("buffer exceeded");
         }

         int var2 = this.buffer.length;

         do {
            var2 += 1048576;
         } while (this.field_163 + var1 > var2);

         byte[] var3 = new byte[var2];
         System.arraycopy(this.buffer, 0, var3, 0, this.field_163);
         this.buffer = var3;
      }
   }

   // $VF: renamed from: el () boolean
   private boolean method_334() {
      if (this.field_165) {
         return false;
      } else {
         int var1 = super.read();
         if (var1 < 0) {
            if (this.field_161) {
               this.field_165 = true;
               return false;
            } else {
               throw new EOFException("Unexpected end of stream");
            }
         } else {
            int var2 = var1 >> 4;
            int var3 = var1 & 15;
            if (var2 == 15) {
               do {
                  var1 = super.read();
                  if (var1 < 0) {
                     throw new EOFException("Unexpected end of literal length");
                  }

                  var2 += var1;
               } while (var1 == 255);
            }

            if (var2 > 0) {
               int var4 = var2;
               this.method_333(var2);

               while ((var1 = super.read(this.buffer, this.field_163, var4)) > 0) {
                  this.field_163 += var1;
                  var4 -= var1;
                  if (var4 == 0) {
                     break;
                  }
               }

               if (var4 > 0) {
                  throw new EOFException("Unexpected end of literal value");
               }
            }

            if (this.field_163 == this.buffer.length && !this.field_161) {
               this.field_165 = true;
               return true;
            } else {
               int var11 = super.read();
               if (var11 < 0) {
                  if (this.field_161) {
                     this.field_165 = true;
                     return true;
                  } else {
                     throw new EOFException("Unexpected end of offset");
                  }
               } else {
                  int var5 = super.read();
                  if (var5 < 0) {
                     throw new EOFException("Unexpected end of offset");
                  } else {
                     var11 |= var5 << 8;
                     if (var3 == 15) {
                        do {
                           var1 = super.read();
                           if (var1 < 0) {
                              throw new EOFException("Unexpected end of literal length");
                           }

                           var3 += var1;
                        } while (var1 == 255);
                     }

                     var3 += 4;
                     if (var11 == 0) {
                        throw new EOFException("Offset is zero!");
                     } else if (var11 > this.field_163) {
                        throw new EOFException("Buffer too small");
                     } else {
                        this.method_333(var3);
                        if (var3 > var11) {
                           int var6 = this.field_163 - var11;

                           do {
                              System.arraycopy(this.buffer, var6, this.buffer, this.field_163, var11);
                              var3 -= var11;
                              this.field_163 += var11;
                           } while (var3 > var11);

                           System.arraycopy(this.buffer, var6, this.buffer, this.field_163, var3);
                           this.field_163 += var3;
                        } else {
                           System.arraycopy(this.buffer, this.field_163 - var11, this.buffer, this.field_163, var3);
                           this.field_163 += var3;
                        }

                        this.field_164 = Math.max(this.field_164, var11);
                        return true;
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public int available() {
      return this.field_162 == this.field_163 && !this.method_334() ? 0 : this.field_163 - this.field_162;
   }

   @Override
   public int read() {
      return this.field_162 == this.field_163 && !this.method_334() ? -1 : 0xFF & this.buffer[this.field_162++];
   }

   @Override
   public int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      if (this.field_162 == this.field_163 && !this.method_334()) {
         return -1;
      } else {
         int var4 = Math.min(var3 - var2, this.field_163 - this.field_162);
         System.arraycopy(this.buffer, this.field_162, var1, var2, var4);
         this.field_162 += var4;
         return var4;
      }
   }
}
