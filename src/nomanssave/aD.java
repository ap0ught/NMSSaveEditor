package nomanssave;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class aD extends JDialog {
   private JComboBox cw;
   private JTextField cx;
   private boolean cy;
   public static aD cz = null;

   private aD(Frame var1) {
      super(var1);
      this.setMinimumSize(new Dimension(400, 10));
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Editor Settings");
      this.setModal(true);
      ba var2 = new ba();
      this.cw = new JComboBox();
      this.cw.setModel(new aE(this));
      var2.a("Look & Feel", this.cw);
      this.cx = new JTextField();
      var2.a("Inventory Scale", this.cx);
      var2.Y();
      JPanel var3 = new JPanel();
      var2.a(var3);
      JButton var4 = new JButton("Apply");
      var4.addActionListener(new aF(this));
      var3.add(var4);
      JButton var5 = new JButton("Cancel");
      var5.addActionListener(new aG(this));
      var3.add(var5);
      this.setContentPane(var2);
      this.pack();
   }

   private boolean S() {
      String var1 = aH.getProperty("LookAndFeel");
      aI var2 = Stream.of(aI.values()).filter(var1x -> var1x.name().equalsIgnoreCase(var1)).findFirst().orElse(aI.cN);
      this.cw.setSelectedItem(var2);
      this.cx.setText(Double.toString(aH.a("InventoryScaling", 1.0)));
      this.setLocationRelativeTo(this.getParent());
      this.cy = false;
      this.setVisible(true);
      return this.cy;
   }

   public static boolean d(Container var0) {
      if (cz == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         cz = new aD(var1);
      }

      return cz.S();
   }
}
