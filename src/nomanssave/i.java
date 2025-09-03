package nomanssave;

import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class I extends em {
   private JComboBox bh = new JComboBox();
   private JTextField bi;
   private G bj;
   private JComboBox bk;
   private G bl;
   private JTextField bm;
   private JButton bn;
   private JButton bo;
   private JButton bp;
   private bO bq;
   private ge br;

   I(Application var1) {
      this.bh.setModel(new J(this));
      this.a("Base NPC", true, this.bh);
      this.bi = new JTextField();
      this.bi.setEnabled(false);
      this.a("Race", this.bi);
      this.bj = new K(this);
      this.bj.setEnabled(false);
      this.a("Seed", this.bj);
      this.Y();
      this.bk = new JComboBox();
      this.bk.setModel(new L(this));
      this.a("Base Info", true, this.bk);
      this.bl = new M(this);
      this.a("Name", (JComponent)this.bl);
      this.bm = new JTextField();
      this.bm.setEnabled(false);
      this.a("Items", this.bm);
      JPanel var2 = new JPanel();
      this.bn = new JButton("Backup");
      this.bn.addActionListener(new N(this, var1));
      var2.add(this.bn);
      this.bo = new JButton("Restore");
      this.bo.addActionListener(new O(this, var1));
      var2.add(this.bo);
      this.bp = new JButton("Move Base Computer");
      this.bp.addActionListener(new P(this, var1));
      var2.add(this.bp);
      this.a(var2);
      this.bq = new bO(var1);
      this.b(this.bq);
   }

   void w() {
      this.bq.w();
   }

   void x() {
      this.bq.x();
   }

   void y() {
      this.bq.y();
   }

   void A() {
      this.bq.A();
   }

   void a(gt var1) {
      this.bq.a(var1);
   }

   ge O() {
      return this.br;
   }

   void a(ge var1) {
      this.br = var1;
      List var2;
      if (var1 == null) {
         var2 = Collections.emptyList();
         this.bh.setSelectedIndex(-1);
         this.bk.setSelectedIndex(-1);
      } else {
         var2 = var1.cC();
         this.bh.setSelectedIndex(var1.cD().size() == 0 ? -1 : 0);
         this.bk.setSelectedIndex(var1.cE().size() == 0 ? -1 : 0);
      }

      this.bh.updateUI();
      this.bk.updateUI();
      this.bq.a(var2);
   }
}
