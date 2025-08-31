package nomanssave;

import java.util.ArrayList;

// $VF: renamed from: nomanssave.fN
class class_108 implements class_10 {
   // $VF: renamed from: lT int
   final int field_359;

   class_108(class_113 var1, int var2) {
      this.field_360 = var1;
      this.field_359 = var2;
   }

   @Override
   public int getIndex() {
      return this.field_359;
   }

   @Override
   public boolean isEmpty() {
      return class_113.method_625(this.field_360)[this.field_359 * 2] == null && class_113.method_625(this.field_360)[this.field_359 * 2 + 1] == null;
   }

   // $VF: renamed from: bX () nomanssave.fs[]
   @Override
   public class_9[] method_38() {
      class_37.info("Loading saves for Slot " + (this.field_359 + 1) + "...");
      ArrayList var1 = new ArrayList();
      if (class_113.method_625(this.field_360)[this.field_359 * 2] != null) {
         var1.add(class_113.method_625(this.field_360)[this.field_359 * 2]);
      }

      if (class_113.method_625(this.field_360)[this.field_359 * 2 + 1] != null) {
         var1.add(class_113.method_625(this.field_360)[this.field_359 * 2 + 1]);
      }

      class_300.field_969.listFiles(new class_107(this, var1));
      var1.sort(new class_106(this));
      return var1.toArray(new class_9[0]);
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_37() {
      long var1 = Long.MIN_VALUE;
      class_294 var3 = null;
      if (class_113.method_625(this.field_360)[this.field_359 * 2] != null) {
         var3 = class_113.method_625(this.field_360)[this.field_359 * 2].method_34();
         var1 = class_113.method_625(this.field_360)[this.field_359 * 2].lastModified();
      }

      if (class_113.method_625(this.field_360)[this.field_359 * 2 + 1] != null) {
         long var4 = class_113.method_625(this.field_360)[this.field_359 * 2 + 1].lastModified();
         if (var4 > var1) {
            var3 = class_113.method_625(this.field_360)[this.field_359 * 2 + 1].method_34();
         }
      }

      return var3;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Slot " + (this.field_359 + 1) + " - ");
      long var2 = Long.MIN_VALUE;
      String var4 = null;
      class_294 var5 = null;
      if (class_113.method_625(this.field_360)[this.field_359 * 2] != null) {
         var5 = class_113.method_625(this.field_360)[this.field_359 * 2].method_34();
         var2 = class_113.method_625(this.field_360)[this.field_359 * 2].lastModified();
         var4 = class_113.method_625(this.field_360)[this.field_359 * 2].getName();
      }

      if (class_113.method_625(this.field_360)[this.field_359 * 2 + 1] != null) {
         long var6 = class_113.method_625(this.field_360)[this.field_359 * 2 + 1].lastModified();
         if (var6 > var2) {
            var5 = class_113.method_625(this.field_360)[this.field_359 * 2 + 1].method_34();
            var2 = var6;
            var4 = class_113.method_625(this.field_360)[this.field_359 * 2 + 1].getName();
         }
      }

      if (var5 != null) {
         var1.append(var5.toString());
         if (var4 != null) {
            var1.append(" - " + var4);
         } else {
            var1.append(" - " + Application.method_1321(var2));
         }
      } else {
         var1.append("[EMPTY]");
      }

      return var1.toString();
   }
}
