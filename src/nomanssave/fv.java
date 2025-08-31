package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

class fv implements fr {
   final fw lI;

   fv(fu var1, fw var2) {
      this.lJ = var1;
      this.lI = var2;
   }

   @Override
   public String K() {
      return "accountdata";
   }

   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public eY M() {
      byte[] var1 = this.lI.ca();
      Throwable var2 = null;
      Object var3 = null;

      try {
         ff var4 = new ff(new ByteArrayInputStream(var1), 2);

         Throwable var10000;
         label125: {
            try {
               var17 = var4.a(eG.jW);
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

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public void k(eY var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      Throwable var3 = null;
      Object var4 = null;

      try {
         fj var5 = new fj(var2, 2);

         try {
            var5.h(var1);
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

      this.lI.d(var2.toByteArray());
   }
}
