package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

class B extends WindowAdapter {
   B(Application var1) {
      this.aZ = var1;
   }

   @Override
   public void windowClosing(WindowEvent var1) {
      if (Application.i(this.aZ) || Application.j(this.aZ)) {
         int var2 = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Save data before closing?", "Save", 0);
         if (var2 == 0) {
            if (Application.i(this.aZ)) {
               Application.k(this.aZ);
            }

            if (Application.j(this.aZ)) {
               Application.l(this.aZ);
            }
         }
      }

      if (aH.T()) {
         aH.U();
      }

      Application.h(this.aZ).dispose();
   }

   @Override
   public void windowDeactivated(WindowEvent var1) {
      Application.e(this.aZ, true);
   }

   @Override
   public void windowActivated(WindowEvent var1) {
      Application.e(this.aZ, false);
      Application.m(this.aZ);
   }
}
