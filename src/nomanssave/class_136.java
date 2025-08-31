package nomanssave;

// $VF: renamed from: nomanssave.eZ
class class_136 extends class_134 {
   final int index;

   class_136(class_137 var1, int var2, class_134 var3) {
      super(var1, var3);
      this.field_443 = var1;
      this.index = var2;
   }

   // $VF: renamed from: a (java.lang.Class, boolean) java.lang.Object
   @Override
   Object method_685(Class var1, boolean var2) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         class_142 var3 = (class_142)this.kN.method_685(eV.class, var2);
         if (this.index < 0 || this.index > var3.length) {
            throw new RuntimeException("Array index out of bounds");
         } else if (this.index == var3.length) {
            if (!var2) {
               throw new class_139(null);
            } else {
               Object var4;
               try {
                  var4 = var1.newInstance();
               } catch (IllegalAccessException | InstantiationException var6) {
                  throw new RuntimeException("Unexpected error", var6);
               }

               var3.method_733(var4);
               return var4;
            }
         } else if (var1.isInstance(var3.values[this.index])) {
            return var1.cast(var3.values[this.index]);
         } else {
            throw new RuntimeException("Unexpected path");
         }
      }
   }

   @Override
   Object getValue() {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         class_142 var1 = (class_142)this.kN.method_685(eV.class, false);
         return var1.method_731(this.index);
      }
   }

   // $VF: renamed from: a (java.lang.Object, boolean) java.lang.Object
   @Override
   Object method_686(Object var1, boolean var2) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         class_142 var3 = (class_142)this.kN.method_685(eV.class, var2);
         if (this.index == var3.length) {
            var3.method_733(var1);
            return null;
         } else {
            return var3.method_732(this.index, var1);
         }
      }
   }

   // $VF: renamed from: bG () java.lang.Object
   @Override
   Object method_687() {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         class_142 var1 = (class_142)this.kN.method_685(eV.class, false);
         return var1.remove(this.index);
      }
   }

   // $VF: renamed from: e (nomanssave.eY) nomanssave.eY
   @Override
   class_137 method_688(class_137 var1) {
      if (this.kN == null) {
         throw new RuntimeException("Unexpected path");
      } else {
         class_142 var2 = (class_142)this.kN.method_685(eV.class, false);
         Object var3 = var2.method_731(this.index);
         if (var3 == null) {
            var2.method_732(this.index, var1);
            return null;
         } else if (var3 instanceof class_137) {
            ((class_137)var3).method_697(var1);
            return (class_137)var3;
         } else {
            throw new RuntimeException("Unsupported type: " + var3.getClass().getSimpleName());
         }
      }
   }
}
