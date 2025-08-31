package nomanssave;

// $VF: renamed from: nomanssave.cS
class class_198 implements class_11 {
   final String filename;
   final int index;

   class_198(class_333 var1, String var2) {
      this.field_574 = var1;
      this.filename = var2;
      this.index = class_333.method_987(var1).size() + 1;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_39() {
      return this.filename;
   }

   @Override
   public String toString() {
      return "Unknown " + this.index;
   }
}
