package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// $VF: renamed from: nomanssave.gR
public class class_67 {
   // $VF: renamed from: rR java.util.Map
   private static Map field_177 = new HashMap();

   // $VF: renamed from: az (java.lang.String) nomanssave.eY
   public static class_137 method_367(String var0) {
      class_137 var1 = null;
      if (field_177.containsKey(var0)) {
         var1 = (class_137)field_177.get(var0);
      } else {
         InputStream var2 = Application.class.getResourceAsStream("templates/" + var0 + ".json");
         if (var2 != null) {
            try {
               byte[] var3 = class_31.method_122(var2);
               var1 = class_96.method_553(var3);
            } catch (IOException var4) {
               class_37.method_156("Cannot load template: " + var0, var4);
            }
         }

         field_177.put(var0, var1);
      }

      return var1 == null ? null : var1.method_693();
   }
}
