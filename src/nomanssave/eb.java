package nomanssave;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class eb extends em {
   private ec[] ib;
   private gM[] ic;
   private static final gy[] ie = new gy[]{gy.qR, gy.qS, gy.qT};

   eb(Application var1) {
      GridBagLayout var2 = new GridBagLayout();
      var2.columnWidths = new int[]{aH.cI, aH.cI, aH.cI, aH.cI, 0};
      var2.rowHeights = new int[3];
      var2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      var2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
      this.setLayout(var2);
      this.ic = new gM[0];
      this.ib = new ec[0];
   }

   void a(gM[] var1) {
      this.ic = var1;

      for (int var2 = var1.length; var2 < this.ib.length; var2++) {
         this.remove(this.ib[var2]);
      }

      byte var6;
      if (var1.length <= 4) {
         var6 = 2;
      } else if (var1.length <= 6) {
         var6 = 3;
      } else {
         var6 = 4;
      }

      ec[] var4 = new ec[var1.length];
      System.arraycopy(this.ib, 0, var4, 0, Math.min(var1.length, this.ib.length));

      for (int var5 = this.ib.length; var5 < var1.length; var5++) {
         var4[var5] = new ec(this, var5);
         GridBagConstraints var3 = new GridBagConstraints();
         var3.insets = new Insets(10, 10, 0, 0);
         var3.fill = 2;
         var3.anchor = 11;
         var3.gridx = var5 % var6;
         var3.gridy = var5 / var6;
         this.add(var4[var5], var3);
      }

      this.ib = var4;

      for (int var7 = 0; var7 < var1.length; var7++) {
         ec.g(this.ib[var7]);
      }

      this.updateUI();
   }
}
