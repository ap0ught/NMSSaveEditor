package nomanssave;

class bH implements bK {
   bE ey;
   bH(bE var1) {
      this.ey = var1;
   }

   @Override
   public String getID() {
      return "TWordsLearnt";
   }

   @Override
   public boolean isSpecial() {
      return true;
   }

   @Override
   public String ab() {
      return Integer.toString(bE.a(this.ey).b(eU.ks));
   }

   @Override
   public void l(String var1) {
      throw new RuntimeException("Cannot set words learnt");
   }
}
