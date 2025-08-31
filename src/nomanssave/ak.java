package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class ak implements ActionListener {
   ak(aj var1) {
      this.cg = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      try {
         aj.a(this.cg, hl.e(aj.a(this.cg).getText().trim(), aj.b(this.cg).getSelectedIndex()));
         aj.c(this.cg);
      } catch (RuntimeException var3) {
         JOptionPane.showOptionDialog(this.cg, "Invalid address value, please try again.", "Error", 0, 0, null, new Object[]{"Cancel"}, null);
      }
   }
}
