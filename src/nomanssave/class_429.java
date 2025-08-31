package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

// $VF: renamed from: nomanssave.cE
class class_429 extends WindowAdapter {
   class_429(class_322 var1) {
      this.field_1423 = var1;
   }

   @Override
   public void windowClosing(WindowEvent var1) {
      boolean var2 = true;
      if (class_322.method_930(this.field_1423) && class_322.method_927(this.field_1423) != null) {
         try {
            String var3 = class_322.method_926(this.field_1423).getText().trim();
            if (var3.length() == 0
               && JOptionPane.showConfirmDialog(
                     this.field_1423, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.field_1423.getTitle(), 0
                  )
                  == 0) {
               class_322.method_927(this.field_1423).remove();
            } else if (JOptionPane.showConfirmDialog(
                  this.field_1423, "The JSON data has changed, do you wish to apply these changes to the save file?", this.field_1423.getTitle(), 0
               )
               == 0) {
               class_322.method_927(this.field_1423).setText(var3);
            }
         } catch (class_140 var4) {
            JOptionPane.showOptionDialog(
               this.field_1423, "Error on line #" + var4.getLineNumber() + ": " + var4.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null
            );
            class_322.method_926(this.field_1423).setCaretPosition(var4.method_723());
            class_322.method_926(this.field_1423).requestFocus();
            var2 = false;
         }
      }

      if (var2) {
         this.field_1423.setVisible(false);
      }
   }
}
