package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;

// $VF: renamed from: nomanssave.bc
class class_233 implements PropertyChangeListener {
   class_233(class_358 var1, JButton var2, class_374 var3) {
      this.field_620 = var1;
      this.field_621 = var2;
      this.field_622 = var3;
   }

   @Override
   public void propertyChange(PropertyChangeEvent var1) {
      this.field_621.setEnabled(this.field_622.isEnabled());
   }
}
