package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

// $VF: renamed from: nomanssave.C
class class_427 extends ComponentAdapter {
   class_427(Application var1) {
      this.field_1421 = var1;
   }

   @Override
   public void componentMoved(ComponentEvent var1) {
      Point var2 = Application.method_1388(this.field_1421).getBounds().getLocation();
      class_300.method_860("MainFrame.X", var2.x);
      class_300.method_860("MainFrame.Y", var2.y);
   }

   @Override
   public void componentResized(ComponentEvent var1) {
      Dimension var2 = Application.method_1388(this.field_1421).getBounds().getSize();
      class_300.method_860("MainFrame.Width", var2.width);
      class_300.method_860("MainFrame.Height", var2.height);
   }
}
