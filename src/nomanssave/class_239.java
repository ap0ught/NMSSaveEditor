package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.bX
class class_239 extends MouseAdapter {
   class_239(class_356 var1, int var2, int var3) {
      this.field_632 = var1;
      this.field_633 = var2;
      this.field_634 = var3;
   }

   @Override
   public void mouseReleased(MouseEvent var1) {
      if (class_357.method_1114(class_356.method_1100(this.field_632)).method_407(this.field_633, this.field_634)
         && !class_357.method_1114(class_356.method_1100(this.field_632)).method_416(this.field_633, this.field_634)) {
         int var2 = UIManager.getInt("Inventory.gridSize");
         int var3 = this.field_633 + (int)Math.floor((double)var1.getX() / (double)var2);
         int var4 = this.field_634 + (int)Math.floor((double)var1.getY() / (double)var2);
         if (var3 >= 0 && var3 < class_357.method_1114(class_356.method_1100(this.field_632)).getWidth()) {
            if (var4 >= 0 && var4 < class_357.method_1114(class_356.method_1100(this.field_632)).getHeight()) {
               if (var3 != this.field_633 || var4 != this.field_634) {
                  class_356 var5 = class_357.method_1119(class_356.method_1100(this.field_632), var3, var4);
                  if (var5 != null && class_356.method_1095(var5) && !class_356.method_1096(var5)) {
                     if (var1.isControlDown()) {
                        class_357.method_1114(class_356.method_1100(this.field_632)).method_396(this.field_633, this.field_634, var3, var4);
                     } else {
                        class_357.method_1114(class_356.method_1100(this.field_632)).method_397(this.field_633, this.field_634, var3, var4);
                     }

                     class_356.method_1093(this.field_632);
                     class_356.method_1093(var5);
                  }
               }
            }
         }
      }
   }

   @Override
   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2) {
         class_41 var2 = class_357.method_1114(class_356.method_1100(this.field_632)).method_399(this.field_633, this.field_634);
         if (var2 != null) {
            class_323.method_932(class_356.method_1100(this.field_632), var2);
            class_356.method_1093(this.field_632);
         }
      }
   }
}
