package nomanssave;

// $VF: renamed from: nomanssave.w
class class_16 implements Runnable {
   class_16(boolean var1) {
      this.field_58 = var1;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      try {
         Application.method_1386(new Application(this.field_58, null));
         Application.method_1388(Application.method_1387()).setVisible(true);
      } catch (Exception var2) {
         var2.printStackTrace();
         System.exit(1);
      }
   }
}
