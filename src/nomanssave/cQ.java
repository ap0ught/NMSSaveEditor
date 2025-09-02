package nomanssave;

class cQ {
   final String value;

   cQ(cN var1, String var2) {
      this.gt = var1;
      this.value = var2;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return this.value.equals(var1);
      } else {
         return var1 instanceof cS ? this.value.equals(((cS)var1).filename) : super.equals(var1);
      }
   }
}
