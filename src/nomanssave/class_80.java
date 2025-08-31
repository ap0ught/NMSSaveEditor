package nomanssave;

// $VF: renamed from: nomanssave.gA
public class class_80 {
   // $VF: renamed from: rd nomanssave.eS
   private final class_144 field_235;

   private class_80(class_38 var1, class_144 var2) {
      this.field_236 = var1;
      this.field_235 = var2;
   }

   public String getID() {
      return this.field_235.getID();
   }

   // $VF: renamed from: c (nomanssave.eU) boolean
   public boolean method_484(class_296 var1) {
      for (String var2 : this.field_235.method_749()) {
         if (this.field_235.method_750(var2) == var1) {
            return class_38.method_192(this.field_236, var2, var1.ordinal());
         }
      }

      return false;
   }

   // $VF: renamed from: a (nomanssave.eU, boolean) void
   public void method_485(class_296 var1, boolean var2) {
      for (String var3 : this.field_235.method_749()) {
         if (this.field_235.method_750(var3) == var1) {
            class_38.method_193(this.field_236, var3, var1.ordinal(), var2);
         }
      }
   }
}
