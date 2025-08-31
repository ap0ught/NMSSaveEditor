package nomanssave;

import java.io.File;
import java.io.IOException;

// $VF: renamed from: nomanssave.fl
public class class_91 {
   private static final Object lock = new Object();
   // $VF: renamed from: lj nomanssave.fm
   private static class_90 field_273;

   // $VF: renamed from: a (nomanssave.fq, java.io.File) void
   public static void method_502(class_7 var0, File var1) {
      synchronized (lock) {
         try {
            if (field_273 == null) {
               field_273 = new class_90();
            }

            field_273.method_500(var0, var1);
         } catch (IOException var4) {
            class_37.method_156("Unable to register storage", var4);
         }
      }
   }

   // $VF: renamed from: b (nomanssave.fq) void
   public static void method_503(class_7 var0) {
      synchronized (lock) {
         try {
            if (field_273 != null) {
               field_273.method_501(var0);
            }
         } catch (IOException var3) {
            class_37.method_156("Unable to unregister storage", var3);
         }
      }
   }
}
