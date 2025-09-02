package nomanssave;

class w implements Runnable {
   w(boolean var1) {
      this.ba = var1;
   }

   @Override
   public void run() {
      try {
         Application.g(new Application(this.ba, null));
         Application.h(Application.H()).setVisible(true);
      } catch (Exception var2) {
         var2.printStackTrace();
         System.exit(1);
      }
   }
}
