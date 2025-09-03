package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class bm implements ActionListener {
   bm(bl var1, Application var2) {
      this.er = var1;
      this.bv = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      if (bl.b(this.er) >= 0) {
         if (JOptionPane.showConfirmDialog(this.er, "Are you sure you want to delete this frigate?", "Delete", 2) == 0) {
            bl.a(this.er, this.bv.k(bl.c(this.er)[bl.b(this.er)].getIndex()));
            if (bl.c(this.er).length > 0) {
               bl.e(this.er).setRowSelectionInterval(0, 0);
            } else {
               bl.e(this.er).clearSelection();
            }

            bl.e(this.er).updateUI();
         }
      }
   }
}
