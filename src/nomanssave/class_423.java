package nomanssave;

import java.io.IOException;

// $VF: renamed from: nomanssave.F
class class_423 implements class_9 {
   final String filename;
   // $VF: renamed from: bd long
   final long field_1414;
   // $VF: renamed from: be nomanssave.fn
   final class_294 field_1415;
   // $VF: renamed from: bf nomanssave.eY
   final class_137 field_1416;

   public class_423(Application var1, String var2, long var3, class_294 var5, class_137 var6) {
      this.field_1417 = var1;
      this.filename = var2;
      this.field_1414 = var3;
      this.field_1415 = var5;
      this.field_1416 = var6;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_33() {
      return this.filename;
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_34() {
      return this.field_1415;
   }

   @Override
   public long lastModified() {
      return this.field_1414;
   }

   // $VF: renamed from: M () nomanssave.eY
   @Override
   public class_137 method_35() {
      return this.field_1416;
   }

   // $VF: renamed from: b (nomanssave.eY) java.lang.String
   @Override
   public String method_36(class_137 var1) {
      throw new IOException("Save not supported!");
   }

   @Override
   public String toString() {
      return this.filename;
   }
}
