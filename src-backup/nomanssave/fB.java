package nomanssave;

class fB extends fH implements fr {
   fB(fA var1) {
      super(var1, "savedata00.hg", true);
      this.ma = var1;
   }

   @Override
   public eY M() {
      return fA.b(this.readBytes(), eG.jW);
   }

   @Override
   public void k(eY var1) {
      this.a("ps4_accountdata", null, null, null);
      this.writeBytes(fA.l(var1));
   }
}
