package nomanssave;

import java.util.ArrayList;
import java.util.List;

// $VF: renamed from: nomanssave.en
public class class_130 {
   // $VF: renamed from: iu boolean
   private static boolean field_432 = false;
   // $VF: renamed from: iv java.util.List
   private static List field_433 = new ArrayList();

   // $VF: renamed from: a (nomanssave.eo) void
   public static void method_680(class_2 var0) {
      field_433.add(var0);
   }

   // $VF: renamed from: aS () boolean
   public static boolean method_681() {
      return field_432;
   }

   // $VF: renamed from: c (boolean) void
   public static void method_682(boolean var0) {
      field_432 = var0;

      for (class_2 var1 : field_433) {
         var1.method_2(var0);
      }
   }
}
