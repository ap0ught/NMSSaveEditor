package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
class Z implements ActionListener {
   Z(X var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      gj var2 = (gj)X.k(this.bV).getSelectedItem();
      if (var2 != null) {
         this.bv.a(var2);
      }
=======
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
>>>>>>> origin
   }
}
