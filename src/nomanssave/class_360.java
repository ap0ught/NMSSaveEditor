package nomanssave;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.dt
public class class_360 extends class_358 {
   // $VF: renamed from: eR nomanssave.Application
   private final Application field_1239;
   // $VF: renamed from: eS javax.swing.JPanel
   private final JPanel field_1240;

   class_360(Application var1) {
      super(class_300.field_972, 0);
      this.field_1239 = var1;
      this.k("Production");
      this.field_1240 = new JPanel();
      this.field_1240.setLayout(new GridBagLayout());
      this.a(this.field_1240);
      UIManager.addPropertyChangeListener(this::a);
   }

   // $VF: renamed from: aL () void
   private void method_1156() {
      synchronized (this.field_1240.getTreeLock()) {
         Component[] var5;
         for (Component var2 : var5 = this.field_1240.getComponents()) {
            class_351 var6 = (class_351)var2;
            class_351.method_1022(var6);
         }
      }

      this.field_1240.revalidate();
      this.field_1240.updateUI();
   }

   // $VF: renamed from: a (nomanssave.gF[]) void
   public void method_1157(class_76[] var1) {
      synchronized (this.field_1240.getTreeLock()) {
         this.field_1240.removeAll();

         for (int var3 = 0; var3 < var1.length; var3++) {
            class_351 var4 = new class_351(this, var1[var3], null);
            GridBagConstraints var5 = new GridBagConstraints();
            var5.fill = 1;
            var5.insets = new Insets(10, 10, 10, 10);
            var5.gridx = var3 % 3;
            var5.gridy = var3 / 3;
            this.field_1240.add(var4, var5);
         }
      }

      this.field_1240.revalidate();
      this.field_1240.updateUI();
   }

   // $VF: renamed from: a (nomanssave.du) void
   private void method_1158(class_351 var1) {
      class_152 var2 = class_319.method_886(this, 28160);
      if (var2 != null) {
         var1.field_1138.method_42(var2.method_775());
         var1.field_1138.method_44(0);
         class_351.method_1022(var1);
      }
   }

   // $VF: renamed from: b (nomanssave.du) void
   private void method_1159(class_351 var1) {
      class_152 var2 = class_152.method_795(var1.field_1138.method_40());
      if (var2 == null) {
         this.field_1239.method_1342("Item details not found!");
      } else {
         List var3 = this.field_1239.method_1347(3584);
         int var4 = class_321.method_910(this, var3, -1);
         if (var4 != -1) {
            class_70 var5 = (class_70)var3.get(var4);
            int var6 = var1.field_1138.method_43();
            class_152 var7 = class_152.method_795(var1.field_1138.method_40());
            var6 = var5.method_403(var7, var6);
            var1.field_1138.method_44(var6);
            class_351.method_1022(var1);
            this.field_1239.method_1361(var5);
         }
      }
   }
}
