package nomanssave;

class aP extends G {
   aP(aJ var1) {
      this.dj = var1;
   }

   @Override
   protected String g(String var1) {
      if (aJ.a(this.dj) == null) {
         return "";
      } else {
         long var2 = aJ.a(this.dj).dL();

         try {
            long var4 = hf.a(var1, 0L, 4294967295L);
            if (var4 != var2) {
               aJ.a(this.dj).g(var4);
            }

            return Long.toString(var4);
         } catch (RuntimeException var6) {
            return Long.toString(var2);
         }
      }
   }
}
