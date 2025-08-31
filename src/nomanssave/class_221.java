package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// $VF: renamed from: nomanssave.cD
class class_221 implements PropertyChangeListener {
   class_221(class_322 var1) {
      this.field_601 = var1;
   }

   @Override
   public void propertyChange(PropertyChangeEvent var1) {
      class_300.method_860("JSONEditor.Divider", (Integer)var1.getNewValue());
   }
}
