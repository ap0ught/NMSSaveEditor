package nomanssave;

class bi extends G {
   bi(bd var1) {
      this.dP = var1;
   }

   @Override
   protected String g(String var1) {
      if (bd.a(this.dP) == null) {
         return "";
      } else {
         double var2 = bd.a(this.dP).cY();

         try {
            double var4 = hf.a(var1, 0.0, 1000.0);
            if (var4 != var2) {
               bd.a(this.dP).b(var4);
            }

            return Double.toString(var4);
         } catch (RuntimeException var6) {
            return Double.toString(var2);
         }
      }
   }
}
