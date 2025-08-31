package nomanssave;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

// $VF: renamed from: nomanssave.ej
public class class_334 extends JFileChooser {
   // $VF: renamed from: im javax.swing.ImageIcon
   private static final ImageIcon field_1110 = Application.method_1325("UI-FILEICON.PNG", 16, 16);
   // $VF: renamed from: io javax.swing.ImageIcon
   private static final ImageIcon field_1111 = Application.method_1325("UI-GAMEPASS.PNG", 16, 16);
   // $VF: renamed from: ip javax.swing.ImageIcon
   private static final ImageIcon field_1112 = Application.method_1325("UI-STEAMLOGO.PNG", 16, 16);
   // $VF: renamed from: iq java.util.regex.Pattern
   private static final Pattern field_1113 = Pattern.compile("st_(\\d*)");
   // $VF: renamed from: ir nomanssave.ej
   private static class_334 field_1114 = null;

   private class_334() {
      this.setFileSelectionMode(2);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileFilter(new class_201(this));
      this.setFileView(new class_209(this));
      this.setDialogTitle("Choose Save Path");
      UIManager.addPropertyChangeListener(this::a);
   }

   // $VF: renamed from: a (java.io.File) java.lang.String
   private String method_995(File var1) {
      Matcher var2 = field_1113.matcher(var1.getName());
      if (var2.matches()) {
         long var3 = Long.parseLong(var2.group(1));
         return class_32.method_123(var3);
      } else {
         return null;
      }
   }

   // $VF: renamed from: b (java.io.File) java.io.File
   public static File method_996(File var0) {
      if (field_1114 == null) {
         field_1114 = new class_334();
      }

      if (var0 != null && var0.exists()) {
         if (var0.isFile()) {
            var0 = var0.getParentFile();
         }

         field_1114.setCurrentDirectory(var0);
      } else {
         File var1 = new File(System.getProperty("user.home"));
         File var2 = new File(var1, "AppData\\Roaming\\HelloGames\\NMS");
         File var3 = new File(var1, "AppData\\Local\\Packages\\HelloGames.NoMansSky_bs190hzg1sesy\\SystemAppData");
         if (var2.isDirectory()) {
            field_1114.setCurrentDirectory(var2);
         } else if (var3.isDirectory()) {
            field_1114.setCurrentDirectory(var3);
         } else {
            field_1114.setCurrentDirectory(var1);
         }
      }

      return field_1114.showOpenDialog(null) == 0 ? field_1114.getSelectedFile() : null;
   }
}
