package nomanssave;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.text.TextAction;

// $VF: renamed from: nomanssave.cG
class class_219 extends TextAction implements ClipboardOwner {
   public class_219(class_322 var1) {
      super("Copy From Clipboard");
      this.field_599 = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      String var2 = ((JTextArea)var1.getSource()).getSelectedText();
      if (var2 != null) {
         class_322.method_921(var2, this);
      }
   }

   @Override
   public void lostOwnership(Clipboard var1, Transferable var2) {
   }
}
