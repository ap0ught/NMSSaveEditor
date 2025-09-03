package nomanssave;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class a extends JDialog {
   private static a a = null;

   private a(Frame var1) {
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
      this.getRootPane().registerKeyboardAction(new b(this), KeyStroke.getKeyStroke(27, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
      this.pack();
   }

   public a(Container var0) {
      if (a == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         a = new a(var1);
      }

      a.setLocationRelativeTo(a.getParent());
      a.setVisible(true);
   }
}
