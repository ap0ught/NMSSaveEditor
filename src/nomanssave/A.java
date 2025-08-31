package nomanssave;

import javax.swing.JOptionPane;

class A implements Runnable {
   A(Application var1, String var2) {
      this.aZ = var1;
      this.bc = var2;
   }

   @Override
   public void run() {
      JOptionPane.showOptionDialog(Application.h(this.aZ), this.bc, "Warning", 0, 2, null, new Object[]{"OK"}, null);
   }
}
