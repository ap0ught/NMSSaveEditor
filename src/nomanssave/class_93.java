package nomanssave;

import java.io.IOException;
import java.io.StringReader;
import java.util.function.Predicate;

// $VF: renamed from: nomanssave.fi
class class_93 extends StringReader {
   // $VF: renamed from: kF int
   int field_280 = 1;
   // $VF: renamed from: kG int
   int field_281 = 0;

   class_93(String var1) {
      super(var1);
   }

   // $VF: renamed from: bI () int
   public int method_516() {
      int var1;
      while ((var1 = this.read()) >= 0) {
         if (var1 != 32 && var1 != 13 && var1 != 10 && var1 != 9) {
            return var1;
         }
      }

      return -1;
   }

   @Override
   public int read() {
      int var1;
      try {
         var1 = super.read();
      } catch (IOException var3) {
         throw new class_140("stream error", var3, this.field_280, this.field_281);
      }

      if (var1 == 10) {
         this.field_280++;
      }

      this.field_281++;
      return var1;
   }

   // $VF: renamed from: a (java.util.function.Predicate) int
   private int method_517(Predicate var1) {
      try {
         this.mark(1);
         int var2 = super.read();
         if (var2 >= 0 && var1.test(var2)) {
            if (var2 == 10) {
               this.field_280++;
            }

            this.field_281++;
            return var2;
         } else {
            this.reset();
            return -1;
         }
      } catch (IOException var3) {
         throw new class_140("stream error", var3, this.field_280, this.field_281);
      }
   }
}
