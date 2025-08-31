package nomanssave;

// $VF: renamed from: nomanssave.bJ
class class_408 extends class_374 {
   // $VF: renamed from: ez nomanssave.gs
   final class_283 field_1396;
   final int type;

   class_408(class_362 var1, class_283 var2, boolean var3) {
      this.field_1397 = var1;
      this.field_1396 = var2;
      switch (method_1317()[var2.ordinal()]) {
         case 24:
            this.type = 1;
            break;
         default:
            this.type = 0;
      }

      this.setEnabled(var3);
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   @Override
   protected String method_1315(String var1) {
      if (class_362.method_1172(this.field_1397) == null) {
         return "";
      } else {
         String var2;
         switch (this.type) {
            case 0:
               var2 = Integer.toString(class_362.method_1172(this.field_1397).method_188(this.field_1396));
               break;
            case 1:
               var2 = Double.toString(class_362.method_1172(this.field_1397).method_190(this.field_1396));
               break;
            default:
               return "";
         }

         if (var1.equals(var2)) {
            return var1;
         } else {
            try {
               switch (this.type) {
                  case 0:
                     int var3 = class_35.method_149(var1, 0, Integer.MAX_VALUE);
                     class_362.method_1172(this.field_1397).method_189(this.field_1396, var3);
                     var1 = Integer.toString(var3);
                     break;
                  case 1:
                     double var4 = Double.parseDouble(var1);
                     class_362.method_1172(this.field_1397).method_191(this.field_1396, var4);
                     var1 = Double.toString(var4);
               }

               class_362.method_1173(this.field_1397, this.field_1396, var1);
               if (this.field_1396 == class_283.field_736 || this.field_1396 == class_283.field_737) {
                  int var7 = class_362.method_1172(this.field_1397).method_188(class_283.field_736)
                     + class_362.method_1172(this.field_1397).method_188(class_283.field_737);
                  class_362.method_1172(this.field_1397).method_189(class_283.field_742, var7);
                  class_362.method_1173(this.field_1397, class_283.field_742, Integer.toString(var7));
               }

               if (this.field_1396 == class_283.field_733 || this.field_1396 == class_283.field_735 || this.field_1396 == class_283.field_734) {
                  int var8 = class_362.method_1172(this.field_1397).method_188(class_283.field_733)
                     + class_362.method_1172(this.field_1397).method_188(class_283.field_735)
                     + class_362.method_1172(this.field_1397).method_188(class_283.field_734);
                  class_362.method_1172(this.field_1397).method_189(class_283.field_743, var8);
                  class_362.method_1173(this.field_1397, class_283.field_743, Integer.toString(var8));
               }

               return var1;
            } catch (RuntimeException var6) {
               return var2;
            }
         }
      }
   }

   // $VF: renamed from: ac () void
   void method_1316() {
      String var1;
      if (class_362.method_1172(this.field_1397) == null) {
         var1 = "";
      } else {
         switch (this.type) {
            case 0:
               var1 = Integer.toString(class_362.method_1172(this.field_1397).method_188(this.field_1396));
               break;
            case 1:
               var1 = Double.toString(class_362.method_1172(this.field_1397).method_190(this.field_1396));
               break;
            default:
               var1 = "";
         }
      }

      this.setText(var1);
   }
}
