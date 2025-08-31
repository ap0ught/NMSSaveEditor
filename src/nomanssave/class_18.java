package nomanssave;

// $VF: renamed from: nomanssave.u
class class_18 implements class_3 {
   class_18(Application var1) {
      this.field_60 = var1;
   }

   // $VF: renamed from: a (nomanssave.fq) void
   @Override
   public void method_3(class_7 var1) {
      if (Application.method_1376(this.field_60) && Application.method_1377(this.field_60) == var1) {
         Application.method_1378(this.field_60, true);
      }
   }

   // $VF: renamed from: a (nomanssave.fq, int, java.lang.String) void
   @Override
   public void method_4(class_7 var1, int var2, String var3) {
      if (Application.method_1376(this.field_60) && Application.method_1377(this.field_60) == var1) {
         Application.method_1379(this.field_60, true);
         if (Application.method_1380(this.field_60) >= 0 && Application.method_1381(this.field_60)[Application.method_1380(this.field_60)].getIndex() == var2) {
            Application.method_1382(this.field_60, true);
            if (Application.method_1383(this.field_60) >= 0
               && Application.method_1384(this.field_60)[Application.method_1383(this.field_60)].method_33().equals(var3)) {
               Application.method_1385(this.field_60, true);
            }
         }
      }
   }
}
