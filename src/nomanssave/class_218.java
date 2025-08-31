package nomanssave;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.text.TextAction;

// $VF: renamed from: nomanssave.cH
class class_218 extends TextAction implements ClipboardOwner {
   public class_218(class_322 var1) {
      super("Paste From Clipboard");
      this.field_598 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = class_322.method_920();
      ((JTextArea)var1.getSource()).replaceSelection(var2);
   }

   @Override
   public void lostOwnership(Clipboard var1, Transferable var2) {
   }
}
