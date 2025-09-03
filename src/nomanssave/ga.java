package nomanssave;

public class gA {
   private final eS rd;

   private gA(gz var1, eS var2) {
      this.re = var1;
      this.rd = var2;
   }

   public String getID() {
      return this.rd.getID();
   }

   public boolean c(eU var1) {
      for (String var2 : this.rd.bw()) {
         if (this.rd.z(var2) == var1) {
            return gz.a(this.re, var2, var1.ordinal());
         }
      }

      return false;
   }

   public void a(eU var1, boolean var2) {
      for (String var3 : this.rd.bw()) {
         if (this.rd.z(var3) == var1) {
            gz.a(this.re, var3, var1.ordinal(), var2);
         }
      }
   }
}
