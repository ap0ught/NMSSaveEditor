package nomanssave;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// $VF: renamed from: nomanssave.eb
public class class_367 extends class_365 {
   // $VF: renamed from: ib nomanssave.ec[]
   private class_359[] field_1275;
   // $VF: renamed from: ic nomanssave.gM[]
   private class_69[] field_1276;
   // $VF: renamed from: ie nomanssave.gy[]
   private static final class_281[] field_1277 = new class_281[]{class_281.field_695, class_281.field_696, class_281.field_697};

   class_367(Application var1) {
      GridBagLayout var2 = new GridBagLayout();
      var2.columnWidths = new int[]{class_300.field_971, class_300.field_971, class_300.field_971, class_300.field_971, 0};
      var2.rowHeights = new int[3];
      var2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      var2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
      this.setLayout(var2);
      this.field_1276 = new class_69[0];
      this.field_1275 = new class_359[0];
   }

   // $VF: renamed from: a (nomanssave.gM[]) void
   void method_1218(class_69[] var1) {
      this.field_1276 = var1;

      for (int var2 = var1.length; var2 < this.field_1275.length; var2++) {
         this.remove(this.field_1275[var2]);
      }

      byte var6;
      if (var1.length <= 4) {
         var6 = 2;
      } else if (var1.length <= 6) {
         var6 = 3;
      } else {
         var6 = 4;
      }

      class_359[] var4 = new class_359[var1.length];
      System.arraycopy(this.field_1275, 0, var4, 0, Math.min(var1.length, this.field_1275.length));

      for (int var5 = this.field_1275.length; var5 < var1.length; var5++) {
         var4[var5] = new class_359(this, var5);
         GridBagConstraints var3 = new GridBagConstraints();
         var3.insets = new Insets(10, 10, 0, 0);
         var3.fill = 2;
         var3.anchor = 11;
         var3.gridx = var5 % var6;
         var3.gridy = var5 / var6;
         this.add(var4[var5], var3);
      }

      this.field_1275 = var4;

      for (int var7 = 0; var7 < var1.length; var7++) {
         class_359.method_1154(this.field_1275[var7]);
      }

      this.updateUI();
   }
}
