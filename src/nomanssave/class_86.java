package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// $VF: renamed from: nomanssave.fv
class class_86 implements class_8 {
   // $VF: renamed from: lI nomanssave.fw
   final class_85 field_257;

   class_86(class_87 var1, class_85 var2) {
      this.field_258 = var1;
      this.field_257 = var2;
   }

   // $VF: renamed from: K () java.lang.String
   @Override
   public String method_30() {
      return "accountdata";
   }

   // $VF: renamed from: M () nomanssave.eY
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public class_137 method_31() {
      byte[] var1 = this.field_257.method_489();
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_96 var4 = new class_96(new ByteArrayInputStream(var1), 2);

         Throwable var10000;
         label125: {
            try {
               var17 = var4.method_559(class_297.field_950);
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var10001 = false;
               break label125;
            }

            if (var4 != null) {
               var4.close();
            }

            label114:
            try {
               return var17;
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var18 = false;
               break label114;
            }
         }

         var2 = var10000;
         if (var4 != null) {
            var4.close();
         }

         throw var2;
      } catch (Throwable var16) {
         if (var2 == null) {
            var2 = var16;
         } else if (var2 != var16) {
            var2.addSuppressed(var16);
         }

         throw var2;
      }
   }

   // $VF: renamed from: k (nomanssave.eY) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void method_32(class_137 var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      Throwable var3 = null;
      Object var4 = null;

      try {
         class_92 var5 = new class_92(var2, 2);

         try {
            var5.method_511(var1);
         } finally {
            if (var5 != null) {
               var5.close();
            }
         }
      } catch (Throwable var11) {
         if (var3 == null) {
            var3 = var11;
         } else if (var3 != var11) {
            var3.addSuppressed(var11);
         }

         throw var3;
      }

      this.field_257.method_490(var2.toByteArray());
   }
}
