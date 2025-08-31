package nomanssave;

import javax.swing.JTextField;

// $VF: renamed from: nomanssave.G
public abstract class class_374 extends JTextField {
   public class_374() {
      this.addFocusListener(new class_317(this));
   }

   // $VF: renamed from: N () void
   public void method_1313() {
      this.setText(this.method_1315(this.getText()));
   }

   // $VF: renamed from: f (java.lang.String) void
   public void method_1314(String var1) {
      this.setText(this.method_1315(var1));
   }

   // $VF: renamed from: g (java.lang.String) java.lang.String
   protected abstract String method_1315(String var1);
}
