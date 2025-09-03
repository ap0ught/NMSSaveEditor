package nomanssave;

class bG implements bK {
   bG(bE var1) {
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
      return Integer.toString(bE.a(this.ey).b(eU.kr));
   }

   @Override
   public void l(String var1) {
      throw new RuntimeException("Cannot set words learnt");
   }
}
