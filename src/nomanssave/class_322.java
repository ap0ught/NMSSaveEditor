package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

// $VF: renamed from: nomanssave.cy
public class class_322 extends JDialog implements TreeSelectionListener {
   // $VF: renamed from: fS java.lang.String
   private String field_1027;
   // $VF: renamed from: fT nomanssave.eY
   private class_137 field_1028;
   // $VF: renamed from: fU javax.swing.JButton
   private JButton field_1029;
   // $VF: renamed from: fV javax.swing.JTree
   private JTree field_1030;
   // $VF: renamed from: fW javax.swing.JScrollPane
   private JScrollPane field_1031;
   // $VF: renamed from: fX javax.swing.JTextArea
   private JTextArea field_1032;
   // $VF: renamed from: fY javax.swing.JScrollPane
   private JScrollPane field_1033;
   // $VF: renamed from: fZ nomanssave.cJ
   private class_216 field_1034;
   // $VF: renamed from: ga boolean
   private boolean field_1035;
   // $VF: renamed from: gb boolean
   private boolean field_1036;
   // $VF: renamed from: gc java.lang.String
   private static final String field_1037 = "0123456789ABCDEFabcdef";
   // $VF: renamed from: gd nomanssave.cy
   private static class_322 field_1038 = null;
   // $VF: renamed from: ge boolean
   private boolean field_1039 = true;
   // $VF: renamed from: gf java.lang.String
   private String field_1040 = "";

   private class_322(Application var1) {
      super((Frame)var1.method_1327());
      this.field_1028 = null;
      Rectangle var2 = new Rectangle(100, 100, 1000, 700);
      Point var3 = var1.method_1327().getLocation();
      var2.x = class_300.method_859("JSONEditor.X", var3.x + 10);
      var2.y = class_300.method_859("JSONEditor.Y", var3.y + 10);
      var2.width = class_300.method_859("JSONEditor.Width", 1000);
      var2.height = class_300.method_859("JSONEditor.Height", 700);
      this.setBounds(var2);
      this.setDefaultCloseOperation(0);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("JSON Editor (Advanced Users Only)");
      this.setModal(true);
      this.addComponentListener(new class_426(this));
      this.field_1030 = new JTree();
      this.field_1030.setModel(new class_217(this, null));
      this.field_1030.setCellRenderer(new class_343(this));
      this.field_1030.addTreeSelectionListener(this);
      this.field_1031 = new JScrollPane();
      this.field_1031.setViewportView(this.field_1030);
      this.field_1032 = new JTextArea();
      this.field_1032.putClientProperty("FlatLaf.styleClass", "monospaced");
      this.field_1032.setEditable(false);
      this.field_1032.setTabSize(4);
      this.field_1032.getActionMap().put("copy-to-clipboard", new class_219(this));
      this.field_1032.getActionMap().put("paste-from-clipboard", new class_218(this));
      this.field_1032.getDocument().addDocumentListener(new class_223(this));
      this.field_1033 = new JScrollPane();
      this.field_1033.setRowHeaderView(new class_353(this.field_1032));
      this.field_1033.setViewportView(this.field_1032);
      JPanel var4 = new JPanel();
      var4.setLayout(new BorderLayout());
      this.field_1029 = new JButton("Validate");
      this.field_1029.addActionListener(new class_222(this));
      var4.add(this.field_1029, "North");
      var4.add(this.field_1031, "Center");
      JSplitPane var5 = new JSplitPane(1, var4, this.field_1033);
      var5.setDividerLocation(class_300.method_859("JSONEditor.Divider", 280));
      var5.addPropertyChangeListener("dividerLocation", new class_221(this));
      this.setContentPane(var5);
      this.addWindowListener(new class_429(this));
      class_220 var6 = new class_220(this);
      this.field_1030.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
      this.field_1030.getActionMap().put("find", var6);
      this.field_1032.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
      this.field_1032.getActionMap().put("find", var6);
   }

   // $VF: renamed from: a (java.lang.String, nomanssave.eY) boolean
   private boolean method_914(String var1, class_137 var2) {
      this.setTitle("JSON Editor (Advanced Users Only)");
      this.field_1027 = var1;
      this.field_1028 = var2;
      this.field_1032.setText("");
      this.field_1035 = false;
      this.field_1034 = null;
      this.field_1030.updateUI();
      int var3 = 0;
      int var4 = 0;

      for (String var5 : var2.names()) {
         var4++;
         if (var2.method_694(var5) instanceof class_137) {
            var3 = var4;
            break;
         }
      }

      this.field_1030.setSelectionRow(var3);
      this.field_1036 = false;
      this.field_1030.setVisible(true);
      this.field_1029.setVisible(false);
      this.setVisible(true);
      return this.field_1036;
   }

   // $VF: renamed from: ay () java.lang.String
   private static String method_915() {
      String var0;
      try {
         var0 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
      } catch (IOException | UnsupportedFlavorException var4) {
         class_37.error("Could not retrieve clipboard contents", var4);
         return "";
      }

      StringBuffer var1 = new StringBuffer();
      char[] var2 = var0.toCharArray();

      for (int var3 = 0; var3 < var2.length; var3++) {
         if (var2[var3] == '\r' || var2[var3] == '\n' || var2[var3] == '\t') {
            var1.append(var2[var3]);
         } else if (var2[var3] == '\f') {
            var1.append("\\f");
         } else if (var2[var3] == '\b') {
            var1.append("\\b");
         } else if (var2[var3] == 11) {
            var1.append("\\v");
         } else if (var2[var3] == 0) {
            var1.append("\\0");
         } else if (var2[var3] >= ' ' && var2[var3] < 128) {
            var1.append(var2[var3]);
         } else {
            var1.append("\\u");
            var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> '\f' & 15));
            var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> '\b' & 15));
            var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> 4 & 15));
            var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] & 15));
         }
      }

      return var1.toString();
   }

   // $VF: renamed from: a (char) int
   private static int method_916(char var0) {
      int var1 = "0123456789ABCDEFabcdef".indexOf(var0);
      if (var1 < 0) {
         throw new RuntimeException("Error decoding hex");
      } else {
         if (var1 >= 16) {
            var1 -= 6;
         }

         return var1;
      }
   }

   // $VF: renamed from: a (java.lang.String, java.awt.datatransfer.ClipboardOwner) void
   private static void method_917(String var0, ClipboardOwner var1) {
      StringBuffer var2 = new StringBuffer();
      char[] var3 = var0.toCharArray();

      for (int var5 = 0; var5 < var3.length; var5++) {
         if (var3[var5] == '\\' && var5 + 5 < var3.length && var3[var5 + 1] == 'u') {
            try {
               int var4 = method_916(var3[var5 + 2]) << 12 | method_916(var3[var5 + 3]) << 8 | method_916(var3[var5 + 4]) << 4 | method_916(var3[var5 + 5]);
               if (var4 < 32) {
                  var2.append(var3[var5]);
                  var2.append(var3[var5 + 1]);
                  var2.append(var3[var5 + 2]);
                  var2.append(var3[var5 + 3]);
                  var2.append(var3[var5 + 4]);
                  var2.append(var3[var5 + 5]);
               } else {
                  var2.append((char)var4);
               }

               var5 += 5;
            } catch (RuntimeException var7) {
            }
         } else {
            var2.append(var3[var5]);
         }
      }

      StringSelection var8 = new StringSelection(var2.toString());
      Clipboard var6 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var6.setContents(var8, var1);
   }

   // $VF: renamed from: a (nomanssave.Application, java.lang.String, nomanssave.eY) boolean
   public static boolean method_918(Application var0, String var1, class_137 var2) {
      if (field_1038 == null) {
         field_1038 = new class_322(var0);
      }

      return field_1038.method_914(var1, var2);
   }

   @Override
   public void valueChanged(TreeSelectionEvent var1) {
      if (this.field_1039) {
         if (this.field_1035 && this.field_1034 != null) {
            try {
               String var2 = this.field_1032.getText().trim();
               if (var2.length() == 0
                  && JOptionPane.showConfirmDialog(
                        this, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.getTitle(), 0
                     )
                     == 0) {
                  this.field_1034.remove();
                  ((class_217)this.field_1030.getModel()).method_835(this.field_1034.field_593);
               } else if (JOptionPane.showConfirmDialog(
                     this, "The JSON data has changed, do you wish to apply these changes to the save file?", this.getTitle(), 0
                  )
                  == 0) {
                  this.field_1034.setText(var2);
                  ((class_217)this.field_1030.getModel()).method_835(this.field_1034);
               }
            } catch (class_140 var3) {
               JOptionPane.showOptionDialog(
                  this, "Error on line #" + var3.getLineNumber() + ": " + var3.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null
               );
               this.field_1032.setCaretPosition(var3.method_723());
               this.field_1032.requestFocus();
               return;
            }
         }

         this.field_1034 = (class_216)this.field_1030.getLastSelectedPathComponent();
         if (this.field_1034 == null) {
            this.field_1032.setText("");
            this.field_1032.setEditable(false);
         } else {
            this.field_1032.setText(this.field_1034.getText());
            this.field_1032.setEditable(true);
         }

         this.field_1035 = false;
         this.field_1032.setCaretPosition(0);
         this.field_1032.requestFocus();
      }
   }

   // $VF: renamed from: a (java.lang.String, boolean, boolean, boolean) void
   void method_919(String var1, boolean var2, boolean var3, boolean var4) {
      String var5 = this.field_1032.getText();
      if (!this.field_1040.equals(var1)) {
         Highlighter var6 = this.field_1032.getHighlighter();
         var6.removeAllHighlights();
         Color var7 = UIManager.getColor("JSONEditor.hiliteColor");
         DefaultHighlightPainter var8 = new DefaultHighlightPainter(var7);
         int var9 = -1;

         while ((var9 = var5.indexOf(var1, var9 + 1)) >= 0) {
            try {
               var6.addHighlight(var9, var9 + var1.length(), var8);
            } catch (BadLocationException var11) {
            }
         }
      }

      if (!var3) {
         var5 = var5.toUpperCase();
         var1 = var1.toUpperCase();
      }

      int var12 = this.field_1032.getCaretPosition();
      int var13 = -1;
      if (var2) {
         if (var12 > var1.length()) {
            var13 = var5.lastIndexOf(var1, var12 - var1.length() - 1);
         }

         if (var13 < 0 && var4) {
            var13 = var5.lastIndexOf(var1);
         }
      } else {
         if (var12 < var5.length() - 1) {
            var13 = var5.indexOf(var1, var12 + 1);
         }

         if (var13 < 0 && var4) {
            var13 = var5.indexOf(var1);
         }
      }

      if (var13 < 0) {
         JOptionPane.showMessageDialog(this, "Text not found!");
      } else {
         this.field_1032.setCaretPosition(var13);
         this.field_1032.setSelectionStart(var13);
         this.field_1032.setSelectionEnd(var13 + var1.length());
      }
   }
}
