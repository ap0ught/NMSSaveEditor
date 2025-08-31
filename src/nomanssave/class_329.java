package nomanssave;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

// $VF: renamed from: nomanssave.a
public class class_329 extends JDialog {
   // $VF: renamed from: a nomanssave.a
   private static class_329 field_1091 = null;

   private class_329(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("About Save Editor");
      this.setModal(true);
      JTextPane var2 = new JTextPane();
      var2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var2.setOpaque(false);

      try {
         StyledDocument var3 = (StyledDocument)var2.getDocument();
         SimpleAttributeSet var4 = new SimpleAttributeSet();
         StyleConstants.setBold(var4, true);
         SimpleAttributeSet var5 = new SimpleAttributeSet();
         var3.insertString(var3.getLength(), "No Man's Sky Save Editor\n\n", var4);
         var3.insertString(var3.getLength(), "Version: 1.19.0\n", var5);
         var3.insertString(var3.getLength(), "by GoatFungus\n\n", var5);
         var3.insertString(var3.getLength(), "For further information visit:\n", var5);
         var3.insertString(var3.getLength(), "https://github.com/goatfungus/NMSSaveEditor", var5);
      } catch (BadLocationException var6) {
         var2.setText(
            "No Man's Sky Save Editor\r\n\r\nVersion: 1.19.0\r\nby GoatFungus\r\n\r\nFor further information visit:\r\nhttps://github.com/goatfungus/NMSSaveEditor"
         );
      }

      var2.setEditable(false);
      this.getContentPane().add(var2, "Center");
      this.getRootPane().registerKeyboardAction(new class_253(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: a (java.awt.Container) void
   public static void method_975(Container var0) {
      if (field_1091 == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         field_1091 = new class_329(var1);
      }

      field_1091.setLocationRelativeTo(field_1091.getParent());
      field_1091.setVisible(true);
   }
}
