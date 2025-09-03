package nomanssave;

class cS implements gD {
   final String filename;
   final int index;

   cS(cN var1, String var2) {
      this.gt = var1;
      this.filename = var2;
      this.index = cN.a(var1).size() + 1;
   }

   @Override
   public String K() {
      return this.filename;
   }

   @Override
   public String toString() {
      return "Unknown " + this.index;
   }
}
