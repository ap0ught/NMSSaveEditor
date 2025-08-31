package nomanssave;

// $VF: renamed from: nomanssave.fa
public class class_97 {
   // $VF: renamed from: kM nomanssave.eY
   final class_137 field_300 = new class_137();

   // $VF: renamed from: d (java.lang.String, java.lang.Object) nomanssave.fa
   public class_97 method_569(String var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!class_137.method_720().matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else if (var2 != null && !class_94.method_519(var2.getClass())) {
         throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
      } else {
         this.field_300.method_691(var1, var2);
         return this;
      }
   }

   // $VF: renamed from: bH () nomanssave.eY
   public class_137 method_570() {
      return this.field_300;
   }
}
