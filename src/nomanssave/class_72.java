package nomanssave;

import java.util.function.Function;

// $VF: renamed from: nomanssave.gK
class class_72 extends class_70 {
   class_72(class_75 var1, Function var2, class_137 var3, int var4, int var5, int var6, boolean var7, boolean var8, int var9) {
      super(var2, var3, var4, var5, var6, var7, var8);
      this.field_221 = var1;
      this.field_222 = var9;
   }

   @Override
   public String toString() {
      return this.field_221.method_435() ? "Ship " + this.field_222 + " - Inflated Sacs" : super.toString();
   }
}
