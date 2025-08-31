package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

// $VF: renamed from: nomanssave.he
class class_53 extends OutputStream {
   // $VF: renamed from: ss java.io.PrintStream
   final PrintStream field_135;
   // $VF: renamed from: st java.lang.String
   final String field_136;
   // $VF: renamed from: su java.io.ByteArrayOutputStream
   final ByteArrayOutputStream field_137;

   class_53(PrintStream var1, String var2) {
      this.field_135 = var1;
      this.field_136 = var2;
      this.field_137 = new ByteArrayOutputStream();
   }

   @Override
   public void write(int var1) {
      this.field_135.write(var1);
      this.field_137.write(var1);
      if (var1 == 10) {
         if (class_37.method_159() != null) {
            synchronized (class_37.method_159()) {
               class_37.method_159().write(this.field_136.getBytes());
               class_37.method_159().write(this.field_137.toByteArray());
            }
         }

         this.field_137.reset();
      }
   }

   @Override
   public void write(byte[] var1, int var2, int var3) {
      if (this.field_135 != null) {
         this.field_135.write(var1, var2, var3);
      }

      for (int var4 = 0; var4 < var3; var4++) {
         if (var1[var2 + var4] == 10) {
            this.field_137.write(var1, var2, var4 + 1);
            if (class_37.method_159() != null) {
               synchronized (class_37.method_159()) {
                  class_37.method_159().write(this.field_136.getBytes());
                  class_37.method_159().write(this.field_137.toByteArray());
               }
            }

            this.field_137.reset();
            var3 -= var4 + 1;
            var2 = var4 + 1;
            var4 = -1;
         }
      }

      this.field_137.write(var1, var2, var3);
   }

   @Override
   public void flush() {
      if (this.field_137.size() > 0) {
         this.field_137.write(System.lineSeparator().getBytes());
         if (class_37.method_159() != null) {
            synchronized (class_37.method_159()) {
               class_37.method_159().write(this.field_136.getBytes());
               class_37.method_159().write(this.field_137.toByteArray());
            }
         }

         this.field_137.reset();
      }
   }
}
