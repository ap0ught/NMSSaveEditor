package nomanssave;

class v implements Runnable {
   v(Application var1) {
      this.aZ = var1;
   }

   @Override
   public void run() {
      Application.p(this.aZ);
   }
}
