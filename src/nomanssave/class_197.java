package nomanssave;

import java.awt.Rectangle;
import javax.swing.text.BadLocationException;

// $VF: renamed from: nomanssave.cX
class class_197 implements Runnable {
   class_197(class_353 var1) {
      this.field_573 = var1;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      try {
         int var1 = class_353.method_1049(this.field_573).getDocument().getLength();
         Rectangle var2 = class_353.method_1049(this.field_573).modelToView(var1);
         if (var2 != null && var2.y != class_353.method_1050(this.field_573)) {
            class_353.method_1051(this.field_573);
            this.field_573.repaint();
            class_353.method_1052(this.field_573, var2.y);
         }
      } catch (BadLocationException var3) {
      }
   }
}
