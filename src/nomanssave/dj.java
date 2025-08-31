package nomanssave;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class dj extends em {
   private static final double gX = 1000.0;
   private static final double gY = 1000.0;
   private static final double gZ = 1000.0;
   private JComboBox ha = new JComboBox();
   private G hb;
   private cN hc;
   private cN hd;
   private G he;
   private G hf;
   private G hg;
   private G hh;
   private JButton bQ;
   private JButton bR;
   private JButton bS;
   private bO hi;
   private gv[] hj;

   dj(Application var1) {
      this.ha.setModel(new dk(this));
      this.a("Multitool", true, this.ha);
      this.hb = new dl(this);
      this.a("Name", (JComponent)this.hb);
      this.hc = new cN(gx.class);
      this.hc.a(var1x -> {
         gv var2x = (gv)this.ha.getSelectedItem();
         if (var2x != null) {
            var2x.ag(var1x);
         }
      });
      this.a("Type", this.hc);
      this.hd = new cN(gN.class);
      this.hd.a(var1x -> {
         gv var2x = (gv)this.ha.getSelectedItem();
         if (var2x != null) {
            var2x.aj(var1x);
         }
      });
      this.a("Class", this.hd);
      this.he = new dm(this);
      this.a("Seed", this.he);
      this.k("Base Stats");
      this.hf = new dn(this);
      this.a("Damage", (JComponent)this.hf);
      this.hg = new DoClass(this);
      this.a("Mining", (JComponent)this.hg);
      this.hh = new dp(this);
      this.a("Scan", (JComponent)this.hh);
      this.Y();
      JPanel var2 = new JPanel();
      this.bQ = new JButton("Delete Multitool");
      this.bQ.addActionListener(new dq(this, var1));
      var2.add(this.bQ);
      this.bR = new JButton("Export");
      this.bR.addActionListener(new dr(this, var1));
      var2.add(this.bR);
      this.bS = new JButton("Import");
      this.bS.addActionListener(new ds(this, var1));
      var2.add(this.bS);
      this.a(var2);
      this.hi = new bO(var1);
      this.b(this.hi);
   }

   void w() {
      this.hi.w();
   }

   void x() {
      this.hi.x();
   }

   void y() {
      this.hi.y();
   }

   void z() {
      this.hi.z();
   }

   void A() {
      this.hi.A();
   }

   void a(gt var1) {
      this.hi.a(var1);
   }

   gv[] aK() {
      return this.hj;
   }

   void a(gv[] var1, gB var2) {
      this.hj = var1;
      if (var1.length == 0) {
         this.ha.setSelectedIndex(-1);
      } else {
         int var3 = var2 == null ? 0 : var2.dU();
         if (var3 >= var1.length) {
            var3 = 0;
         }

         this.ha.setSelectedIndex(var3);
      }

      this.ha.updateUI();
   }
}
