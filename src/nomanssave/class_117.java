package nomanssave;

import java.util.ArrayList;

// $VF: renamed from: nomanssave.fE
class class_117 implements class_10 {
   // $VF: renamed from: lT int
   final int field_393;

   class_117(class_122 var1, int var2) {
      this.field_394 = var1;
      this.field_393 = var2;
   }

   @Override
   public int getIndex() {
      return this.field_393;
   }

   @Override
   public boolean isEmpty() {
      return class_122.method_661(this.field_394)[this.field_393 * 2] == null && class_122.method_661(this.field_394)[this.field_393 * 2 + 1] == null;
   }

   // $VF: renamed from: bX () nomanssave.fs[]
   @Override
   public class_9[] method_38() {
      class_37.info("Loading saves for Slot " + (this.field_393 + 1) + "...");
      ArrayList var1 = new ArrayList();
      if (class_122.method_661(this.field_394)[this.field_393 * 2] != null) {
         var1.add(class_122.method_661(this.field_394)[this.field_393 * 2]);
      }

      if (class_122.method_661(this.field_394)[this.field_393 * 2 + 1] != null) {
         var1.add(class_122.method_661(this.field_394)[this.field_393 * 2 + 1]);
      }

      class_300.field_969.listFiles(new class_116(this, var1));
      var1.sort(new class_115(this));
      return var1.toArray(new class_9[0]);
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_37() {
      long var1 = Long.MIN_VALUE;
      class_294 var3 = null;
      if (class_122.method_661(this.field_394)[this.field_393 * 2] != null) {
         var3 = class_122.method_661(this.field_394)[this.field_393 * 2].method_34();
         var1 = class_122.method_661(this.field_394)[this.field_393 * 2].lastModified();
      }

      if (class_122.method_661(this.field_394)[this.field_393 * 2 + 1] != null) {
         long var4 = class_122.method_661(this.field_394)[this.field_393 * 2 + 1].lastModified();
         if (var4 > var1) {
            var3 = class_122.method_661(this.field_394)[this.field_393 * 2 + 1].method_34();
         }
      }

      return var3;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Slot " + (this.field_393 + 1) + " - ");
      long var2 = Long.MIN_VALUE;
      class_294 var4 = null;
      if (class_122.method_661(this.field_394)[this.field_393 * 2] != null) {
         var4 = class_122.method_661(this.field_394)[this.field_393 * 2].method_34();
         var2 = class_122.method_661(this.field_394)[this.field_393 * 2].lastModified();
      }

      if (class_122.method_661(this.field_394)[this.field_393 * 2 + 1] != null) {
         long var5 = class_122.method_661(this.field_394)[this.field_393 * 2 + 1].lastModified();
         if (var5 > var2) {
            var4 = class_122.method_661(this.field_394)[this.field_393 * 2 + 1].method_34();
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
