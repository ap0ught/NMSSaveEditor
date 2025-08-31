package nomanssave;

// $VF: renamed from: nomanssave.gu
public class class_41 implements class_12 {
   // $VF: renamed from: qD nomanssave.eY
   private final class_137 field_112;

   private class_41(class_70 var1, class_137 var2) {
      this.field_113 = var1;
      this.field_112 = var2;
   }

   @Override
   public String getType() {
      return this.field_112.getValueAsString("Type.InventoryType");
   }

   // $VF: renamed from: dz () java.lang.Object
   @Override
   public Object method_40() {
      return this.field_112.getValue("Id");
   }

   // $VF: renamed from: m (java.lang.Object) void
   @Override
   public void method_42(Object var1) {
      this.field_112.method_713("Id", var1);
   }

   // $VF: renamed from: dA () int
   @Override
   public int method_43() {
      return this.field_112.method_705("Amount");
   }

   // $VF: renamed from: aA (int) void
   @Override
   public void method_44(int var1) {
      this.field_112.method_713("Amount", new Integer(var1));
   }

   // $VF: renamed from: dB () int
   @Override
   public int method_45() {
      return this.field_112.method_705("MaxAmount");
   }

   // $VF: renamed from: dC () double
   public double method_218() {
      return this.field_112.method_709("DamageFactor");
   }

   // $VF: renamed from: c (double) void
   public void method_219(double var1) {
      this.field_112.method_713("DamageFactor", new Double(var1));
   }

   // $VF: renamed from: dD () boolean
   public boolean method_220() {
      return this.field_112.method_711("FullyInstalled");
   }

   // $VF: renamed from: e (boolean) void
   public void method_221(boolean var1) {
      this.field_112.method_713("FullyInstalled", new Boolean(var1));
   }
}
