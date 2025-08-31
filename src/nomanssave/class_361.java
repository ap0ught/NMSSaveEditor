package nomanssave;

// $VF: renamed from: nomanssave.bN
class class_361 extends class_358 {
   class_361(class_362 var1) {
      super(class_300.field_972, 0);
      this.field_1241 = var1;
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.gs) void
   void method_1163(String var1, class_283 var2) {
      this.method_1164(var1, var2, true, null);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.gs, boolean, java.lang.String) void
   void method_1164(String var1, class_283 var2, boolean var3, String var4) {
      class_408 var5 = new class_408(this.field_1241, var2, var3);
      if (var4 != null) {
         var5.setToolTipText(var4);
      }

      this.a(var1, var5);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.bK) void
   void method_1165(String var1, class_0 var2) {
      this.method_1166(var1, var2, true, null);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.bK, boolean, java.lang.String) void
   void method_1166(String var1, class_0 var2, boolean var3, String var4) {
      class_373 var5 = new class_373(this.field_1241, var2, var3);
      if (var4 != null) {
         var5.setToolTipText(var4);
      }

      this.a(var1, var5);
   }
}
