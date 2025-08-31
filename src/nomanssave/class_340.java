package nomanssave;

import javax.swing.JFileChooser;

// $VF: renamed from: nomanssave.cK
public class class_340 extends JFileChooser {
   // $VF: renamed from: gk nomanssave.cK
   private static class_340 field_1128 = null;
   private static final String name = "JSON File";

   // $VF: renamed from: aA () nomanssave.cK
   public static class_340 method_1020() {
      if (field_1128 == null) {
         field_1128 = new class_340();
      }

      return field_1128;
   }

   private class_340() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new class_215(this));
      this.setFileFilter(new class_208(this));
      this.setDialogTitle("Choose JSON File");
   }
}
