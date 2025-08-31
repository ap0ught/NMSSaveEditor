package nomanssave;

import java.awt.EventQueue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// $VF: renamed from: nomanssave.bt
class class_227 implements ListSelectionListener {
   class_227(class_355 var1, Application var2) {
      this.field_609 = var1;
      this.field_610 = var2;
   }

   @Override
   public void valueChanged(ListSelectionEvent var1) {
      EventQueue.invokeLater(new class_226(this, this.field_610));
   }
}
