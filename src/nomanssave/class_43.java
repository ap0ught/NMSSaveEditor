package nomanssave;

// $VF: renamed from: nomanssave.gn
public class class_43 {
   // $VF: renamed from: nj nomanssave.eY
   final class_137 field_115;

   private class_43(class_44 var1, class_137 var2) {
      this.field_116 = var1;
      this.field_115 = var2;
   }

   // $VF: renamed from: cF () java.lang.String
   public String method_249() {
      Object var1 = this.field_115.getValue("GalacticAddress");
      if (var1 instanceof String) {
         return (String)var1;
      } else {
         return var1 instanceof Number ? "0x" + Long.toHexString(((Number)var1).longValue()) : null;
      }
   }

   public String getName() {
      return this.field_115.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.field_115.method_713("Name", var1);
   }

   // $VF: renamed from: cG () int
   public int method_250() {
      return this.field_115.method_703("Objects").size();
   }

   // $VF: renamed from: cH () nomanssave.eY
   public class_137 method_251() {
      return this.field_115;
   }

   @Override
   public String toString() {
      return this.field_115.getValueAsString("Name");
   }
}
