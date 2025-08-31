package nomanssave;

import java.util.ArrayList;

// $VF: renamed from: nomanssave.fy
class class_83 implements class_10 {
   // $VF: renamed from: lT int
   final int field_241;

   class_83(class_87 var1, int var2) {
      this.field_242 = var1;
      this.field_241 = var2;
   }

   @Override
   public int getIndex() {
      return this.field_241;
   }

   @Override
   public boolean isEmpty() {
      return class_87.method_493(this.field_242)[this.field_241 * 2] == null && class_87.method_493(this.field_242)[this.field_241 * 2 + 1] == null;
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_37() {
      long var1 = Long.MIN_VALUE;
      class_294 var3 = null;
      if (class_87.method_493(this.field_242)[this.field_241 * 2] != null) {
         var3 = class_87.method_493(this.field_242)[this.field_241 * 2].method_34();
         var1 = class_87.method_493(this.field_242)[this.field_241 * 2].lastModified();
      }

      if (class_87.method_493(this.field_242)[this.field_241 * 2 + 1] != null) {
         long var4 = class_87.method_493(this.field_242)[this.field_241 * 2 + 1].lastModified();
         if (var4 > var1) {
            var3 = class_87.method_493(this.field_242)[this.field_241 * 2 + 1].method_34();
         }
      }

      return var3;
   }

   // $VF: renamed from: bX () nomanssave.fs[]
   @Override
   public class_9[] method_38() {
      class_37.info("Loading saves for Slot " + (this.field_241 + 1) + "...");
      ArrayList var1 = new ArrayList();
      if (class_87.method_493(this.field_242)[this.field_241 * 2] != null) {
         var1.add(class_87.method_493(this.field_242)[this.field_241 * 2]);
      }

      if (class_87.method_493(this.field_242)[this.field_241 * 2 + 1] != null) {
         var1.add(class_87.method_493(this.field_242)[this.field_241 * 2 + 1]);
      }

      var1.sort(new class_82(this));
      return var1.toArray(new class_9[0]);
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Slot " + (this.field_241 + 1) + " - ");
      long var2 = Long.MIN_VALUE;
      class_294 var4 = null;
      if (class_87.method_493(this.field_242)[this.field_241 * 2] != null) {
         var4 = class_87.method_493(this.field_242)[this.field_241 * 2].method_34();
         var2 = class_87.method_493(this.field_242)[this.field_241 * 2].lastModified();
      }

      if (class_87.method_493(this.field_242)[this.field_241 * 2 + 1] != null) {
         long var5 = class_87.method_493(this.field_242)[this.field_241 * 2 + 1].lastModified();
         if (var5 > var2) {
            var4 = class_87.method_493(this.field_242)[this.field_241 * 2 + 1].method_34();
            var2 = var5;
         }
      }

      if (var4 != null) {
         var1.append(var4.toString());
         var1.append(" - " + Application.method_1321(var2));
      } else {
         var1.append("[EMPTY]");
      }

      return var1.toString();
   }
}
