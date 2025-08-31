package nomanssave;

import java.util.function.Function;

// $VF: renamed from: nomanssave.gI
class class_74 extends class_70 {
   class_74(class_75 var1, Function var2, class_137 var3, int var4, int var5, int var6, boolean var7, boolean var8, boolean var9, int var10) {
      super(var2, var3, var4, var5, var6, var7, var8);
      this.field_225 = var1;
      this.field_226 = var9;
      this.field_227 = var10;
   }

   // $VF: renamed from: dj () int
   @Override
   public int method_385() {
      return this.field_226 ? 3584 : 3584 | class_75.method_456(this.field_225);
   }

   @Override
   public String toString() {
      return this.field_225.method_435() ? "Ship " + this.field_227 + " - Storage Sacs" : super.toString();
   }
}
