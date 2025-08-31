package nomanssave;

// $VF: renamed from: nomanssave.eW
public class class_141 {
   // $VF: renamed from: kE nomanssave.eV
   final class_142 field_454 = new class_142();

   // $VF: renamed from: h (java.lang.Object) nomanssave.eW
   public class_141 method_724(Object var1) {
      if (var1 != null && !class_94.method_519(var1.getClass())) {
         throw new RuntimeException("Unsupported type: " + var1.getClass().getSimpleName());
      } else {
         this.field_454.method_727(var1);
         return this;
      }
   }

   // $VF: renamed from: bC () nomanssave.eV
   public class_142 method_725() {
      return this.field_454;
   }
}
