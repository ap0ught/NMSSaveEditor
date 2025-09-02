package nomanssave;

class bg extends G {
   bg(bd var1) {
      this.dP = var1;
   }

   @Override
   protected String g(String var1) {
      if (bd.a(this.dP) == null) {
         return "";
      } else {
         try {
            var1 = hg.aB(var1).toString();
            if (!var1.equals(bd.a(this.dP).cV())) {
               bd.a(this.dP).ai(var1);
            }

            return var1;
         } catch (RuntimeException var3) {
            return bd.a(this.dP).cV();
         }
      }
   }
}
