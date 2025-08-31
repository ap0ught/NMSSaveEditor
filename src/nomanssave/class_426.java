package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

// $VF: renamed from: nomanssave.cz
class class_426 extends ComponentAdapter {
   class_426(class_322 var1) {
      this.field_1420 = var1;
   }

   @Override
   public void componentMoved(ComponentEvent var1) {
      Point var2 = this.field_1420.getBounds().getLocation();
      class_300.method_860("JSONEditor.X", var2.x);
      class_300.method_860("JSONEditor.Y", var2.y);
   }

   @Override
   public void componentResized(ComponentEvent var1) {
      Dimension var2 = this.field_1420.getBounds().getSize();
      class_300.method_860("JSONEditor.Width", var2.width);
      class_300.method_860("JSONEditor.Height", var2.height);
   }
}
