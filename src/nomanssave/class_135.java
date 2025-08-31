package nomanssave;

// $VF: renamed from: nomanssave.fb
class class_135 extends class_134 {
   final String name;

   class_135(class_137 var1, String var2, class_134 var3) {
      super(var1, var3);
      this.field_442 = var1;
      this.name = var2;
   }

   // $VF: renamed from: a (java.lang.Class, boolean) java.lang.Object
   @Override
   Object method_685(Class var1, boolean var2) {
      class_137 var3;
      if (this.kN == null) {
         var3 = this.field_442;
      } else {
         var3 = (class_137)this.kN.method_685(eY.class, var2);
      }

      int var4 = var3.indexOf(this.name);
      if (var4 < 0) {
         if (!var2) {
            throw new class_139(null);
         } else {
            Object var5;
            try {
               var5 = var1.newInstance();
            } catch (IllegalAccessException | InstantiationException var7) {
               throw new RuntimeException("Unexpected error", var7);
            }

            var3.method_695(this.name, var5);
            return var5;
         }
      } else if (var1.isInstance(var3.values[var4])) {
         return var1.cast(var3.values[var4]);
      } else {
         throw new RuntimeException("Unexpected path");
      }
   }

   @Override
   Object getValue() {
      class_137 var1;
      if (this.kN == null) {
         var1 = this.field_442;
      } else {
         var1 = (class_137)this.kN.method_685(eY.class, false);
      }

      return var1.method_694(this.name);
   }

   // $VF: renamed from: a (java.lang.Object, boolean) java.lang.Object
   @Override
   Object method_686(Object var1, boolean var2) {
      class_137 var3;
      if (this.kN == null) {
         var3 = this.field_442;
      } else {
         var3 = (class_137)this.kN.method_685(eY.class, var2);
      }

      return var3.method_695(this.name, var1);
   }

   // $VF: renamed from: bG () java.lang.Object
   @Override
   Object method_687() {
      class_137 var1;
      if (this.kN == null) {
         var1 = this.field_442;
      } else {
         var1 = (class_137)this.kN.method_685(eY.class, false);
      }

      return var1.method_696(this.name);
   }

   // $VF: renamed from: e (nomanssave.eY) nomanssave.eY
   @Override
   class_137 method_688(class_137 var1) {
      class_137 var2;
      if (this.kN == null) {
         var2 = this.field_442;
      } else {
         var2 = (class_137)this.kN.method_685(eY.class, false);
      }

      Object var3 = var2.method_694(this.name);
      if (var3 == null) {
         var2.method_695(this.name, var1);
         return null;
      } else if (var3 instanceof class_137) {
         ((class_137)var3).method_697(var1);
         return (class_137)var3;
      } else {
         throw new RuntimeException("Unsupported type: " + var3.getClass().getSimpleName());
      }
   }
}
