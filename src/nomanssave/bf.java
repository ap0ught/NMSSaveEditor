package nomanssave;

class bF implements bK {
   bF(bE var1) {
      this.ey = var1;
   }

   @Override
   public String getID() {
      return "ExtremeSurvival";
   }

   @Override
   public boolean isSpecial() {
      return false;
   }

   @Override
   public String ab() {
      return Double.toString(bE.a(this.ey).dT());
   }

   @Override
   public void l(String var1) {
      double var2 = Double.parseDouble(var1);
      bE.a(this.ey).g(var2);
   }
}
