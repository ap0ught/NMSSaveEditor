package nomanssave;

import java.awt.EventQueue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class bt implements ListSelectionListener {
   bt(bl var1, Application var2) {
      this.er = var1;
      this.bv = var2;
   }

   @Override
   public void valueChanged(ListSelectionEvent var1) {
      EventQueue.invokeLater(new bu(this, this.bv));
   }
}
