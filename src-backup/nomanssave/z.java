package nomanssave;

import javax.swing.JOptionPane;

class z implements Runnable {
   private Application aZ;
   private String bc;

   z(Application var1, String var2) {
      this.aZ = var1;
      this.bc = var2;
   }

   @Override
   public void run() {
      JOptionPane.showOptionDialog(this.aZ.h(0), this.bc, "Error", 0, 0, null, new Object[]{"Cancel"}, null);
   }
}
