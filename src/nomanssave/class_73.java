package nomanssave;

import java.util.function.Function;

// $VF: renamed from: nomanssave.gJ
class class_73 extends class_70 {
   class_73(class_75 var1, Function var2, class_137 var3, int var4, int var5, int var6, boolean var7, boolean var8, int var9) {
      super(var2, var3, var4, var5, var6, var7, var8);
      this.field_223 = var1;
      this.field_224 = var9;
   }

   // $VF: renamed from: dj () int
   @Override
   public int method_385() {
      return class_75.method_456(this.field_223);
   }

   @Override
   public String toString() {
      return this.field_223.method_435() ? "Ship " + this.field_224 + " - Organ Chamber" : super.toString();
   }
}
