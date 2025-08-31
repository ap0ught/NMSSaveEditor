package nomanssave;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// $VF: renamed from: nomanssave.aH
public class class_300 {
   // $VF: renamed from: cC java.io.File
   private static File field_965;
   // $VF: renamed from: cD java.io.File
   public static File field_966;
   // $VF: renamed from: cE java.io.File
   public static File field_967;
   // $VF: renamed from: cF java.io.File
   public static File field_968;
   // $VF: renamed from: cG java.io.File
   public static File field_969;
   // $VF: renamed from: cH int
   public static int field_970;
   // $VF: renamed from: cI int
   public static int field_971;
   // $VF: renamed from: cJ int
   public static int field_972;
   // $VF: renamed from: cK nomanssave.eY
   private static class_137 field_973;
   // $VF: renamed from: cL boolean
   private static boolean field_974;

   public static String getProperty(String var0) {
      return field_973.getValueAsString(var0);
   }

   public static void setProperty(String var0, String var1) {
      if (var1 == null) {
         field_973.method_715(var0);
      } else {
         field_973.method_714(var0, var1);
      }

      field_974 = true;
   }

   // $VF: renamed from: j (java.lang.String) int
   public static int method_858(String var0) {
      return field_973.method_705(var0);
   }

   // $VF: renamed from: a (java.lang.String, int) int
   public static int method_859(String var0, int var1) {
      return field_973.method_706(var0, var1);
   }

   // $VF: renamed from: b (java.lang.String, int) void
   public static void method_860(String var0, int var1) {
      field_973.method_714(var0, var1);
      field_974 = true;
   }

   // $VF: renamed from: a (java.lang.String, double) double
   public static double method_861(String var0, double var1) {
      return field_973.method_710(var0, var1);
   }

   // $VF: renamed from: b (java.lang.String, double) void
   public static void method_862(String var0, double var1) {
      field_973.method_714(var0, var1);
      field_974 = true;
   }

   // $VF: renamed from: a (java.lang.String, java.lang.Class) java.lang.Object[]
   public static Object[] method_863(String var0, Class var1) {
      class_142 var2 = field_973.method_703(var0);
      if (var2 == null) {
         return (Object[])Array.newInstance(var1, 0);
      } else {
         Object var3 = Array.newInstance(var1, var2.size());

         for (int var4 = 0; var4 < var2.size(); var4++) {
            Array.set(var3, var4, var1.cast(var2.getValue(var4)));
         }

         return (Object[])var3;
      }
   }

   // $VF: renamed from: a (java.lang.String, java.lang.Object[]) void
   public static void method_864(String var0, Object[] var1) {
      class_142 var2 = new class_142();

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2.method_744(var1[var3]);
      }

      field_973.method_714(var0, var2);
      field_974 = true;
   }

   // $VF: renamed from: T () boolean
   static boolean method_865() {
      return field_974;
   }

   // $VF: renamed from: U () void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static void method_866() {
      String var0 = class_94.method_520(field_973, true);

      try {
         Throwable var1 = null;
         Object var2 = null;

         try {
            FileOutputStream var3 = new FileOutputStream(field_965);

            try {
               var3.write(var0.getBytes("UTF-8"));
               field_974 = false;
            } finally {
               if (var3 != null) {
                  var3.close();
               }
            }
         } catch (Throwable var11) {
            if (var1 == null) {
               var1 = var11;
            } else if (var1 != var11) {
               var1.addSuppressed(var11);
            }

            throw var1;
         }
      } catch (IOException var12) {
         class_37.error("Could not save configuration file", var12);
      }
   }

   public static void init(boolean var0) {
      System.out.println("Initializing environment...");
      File var1 = null;

      try {
         URL var2 = Application.class.getProtectionDomain().getCodeSource().getLocation();
         if (var0 && var2.getFile().endsWith(".jar")) {
            var1 = Paths.get(var2.toURI()).toFile().getParentFile();
         } else {
            var1 = new File(".").getCanonicalFile();
         }
      } catch (URISyntaxException var20) {
         System.out.println("Error: cannot find working directory");
         var20.printStackTrace();
         System.exit(1);
      } catch (IOException var21) {
         System.out.println("Error: cannot find working directory");
         var21.printStackTrace();
         System.exit(1);
      }

      if (!var1.isDirectory()) {
         System.out.println("Error: working directory error: " + var1.getAbsolutePath());
         System.exit(1);
      }

      field_966 = var1;
      field_965 = new File(var1, "NMSSaveEditor.conf");
      field_967 = new File(var1, "bases");
      field_968 = new File(var1, "exported");
      field_969 = new File(var1, "backups");
      if (!field_969.exists() && !field_969.mkdir()) {
         System.out.println("Error: cannot create backups folder");
         System.exit(1);
      }

      class_37.method_153(new File(var1, "NMSSaveEditor.log"));
      class_37.debug("Java Vendor: " + System.getProperty("java.vendor"));
      class_37.debug("Java Version: " + System.getProperty("java.version"));
      class_37.debug("Java Architecture: " + System.getProperty("os.arch"));
      class_37.debug("Operating System: " + System.getProperty("os.name"));
      class_37.debug("Working Dir: " + var1.getAbsolutePath());
      field_973 = new class_137();
      field_974 = false;
      if (field_965.exists()) {
         try {
            byte[] var22 = class_31.method_121(field_965);
            if (var22.length > 0 && var22[0] == 123) {
               field_973 = class_137.method_689(new String(var22, "UTF-8"));
            } else {
               Properties var3 = new Properties();
               FileInputStream var4 = new FileInputStream(field_965);

               try {
                  var3.load(var4);
               } finally {
                  var4.close();
               }

               class_142 var6 = new class_142();

               for (String var7 : var3.stringPropertyNames()) {
                  try {
                     String var9 = var3.getProperty(var7);
                     if (!var7.equals("InventoryFontScale")) {
                        if (var7.equals("InventoryScaling")) {
                           field_973.method_713("InventoryScaling", Double.parseDouble(var9));
                        } else if (var7.equals("FontScaling")) {
                           field_973.method_713("FontScaling", Double.parseDouble(var9));
                        } else if (var7.endsWith(".Location")) {
                           var7 = var7.substring(0, var7.lastIndexOf("."));
                           int var5;
                           if ((var5 = var9.indexOf(44)) > 0) {
                              int var10 = Integer.parseInt(var9.substring(0, var5));
                              int var11 = Integer.parseInt(var9.substring(var5 + 1));
                              field_973.method_714(var7 + ".X", var10);
                              field_973.method_714(var7 + ".Y", var11);
                           }
                        } else if (var7.endsWith(".Size")) {
                           var7 = var7.substring(0, var7.lastIndexOf("."));
                           int var24;
                           if ((var24 = var9.indexOf(44)) > 0) {
                              int var28 = Integer.parseInt(var9.substring(0, var24));
                              int var30 = Integer.parseInt(var9.substring(var24 + 1));
                              field_973.method_714(var7 + ".Width", var28);
                              field_973.method_714(var7 + ".Height", var30);
                           }
                        } else if (var7.equals("JSONEditor.Divider")) {
                           int var29 = Integer.parseInt(var9);
                           field_973.method_714(var7, var29);
                        } else if (var7.startsWith("SteamID.")) {
                           var7 = var7.substring(8);
                           var6.method_744(Long.parseLong(var7));
                           field_973.method_714("KnownPlayers." + var7, var9);
                        } else {
                           field_973.method_714(var7, var9);
                        }
                     }
                  } catch (NumberFormatException var17) {
                  }
               }

               if (var6.size() > 0) {
                  field_973.method_713("SteamIDs", var6);
               }

               field_974 = true;
            }
         } catch (IOException var19) {
            class_37.method_156("Could not load configuration file", var19);
         }
      }

      String var23 = field_973.getValueAsString("LogLevel");
      if (var23 != null) {
         class_37.method_154(var23);
      }

      FlatLaf.registerCustomDefaultsSource("nomanssave");
      method_867();
   }

   // $VF: renamed from: V () void
   public static void method_867() {
      String var0 = field_973.getValueAsString("LookAndFeel");
      class_299 var1 = Stream.of(class_299.values()).filter(aH::a).findFirst().orElse(class_299.field_957);

      try {
         Object var2;
         switch (method_868()[var1.ordinal()]) {
            case 1:
            default:
               var2 = new FlatLightLaf();
               break;
            case 2:
               var2 = new FlatDarkLaf();
               break;
            case 3:
               var2 = new FlatIntelliJLaf();
               break;
            case 4:
               var2 = new FlatDarculaLaf();
               break;
            case 5:
               var2 = new FlatMacLightLaf();
               break;
            case 6:
               var2 = new FlatMacDarkLaf();
         }

         UIManager.setLookAndFeel((LookAndFeel)var2);
      } catch (UnsupportedLookAndFeelException var13) {
         class_37.method_156("Could not set look and feel: " + var1, var13);
         return;
      }

      class_37.debug("Look and Feel: " + UIManager.getLookAndFeel().getName());
      Font var3 = UIManager.getFont("Label.font");
      if (var3 == null) {
         field_970 = 120;
         field_971 = 350;
         field_972 = 200;
         UIManager.put("Inventory.font", null);
         UIManager.put("Inventory.gridSize", 200);
         UIManager.put("Inventory.iconSize", 64);
      } else {
         double var4 = field_973.method_709("InventoryScaling");
         if (var4 <= 0.0) {
            var4 = 1.0;
            field_973.method_713("InventoryScaling", var4);
            field_974 = true;
         }

         int var6 = (int)Math.round((double)var3.getSize() * var4);
         Font var7 = new Font(var3.getName(), 0, var6);
         Canvas var8 = new Canvas();
         FontMetrics var9 = var8.getFontMetrics(var3);
         field_970 = var9.stringWidth("MMMMMMMMMM");
         field_971 = var9.stringWidth("MMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
         field_972 = var9.stringWidth("MMMMMMMMMMMMMMMMM");
         var9 = var8.getFontMetrics(var7);
         int var10 = var9.stringWidth("MMMMMMMMMMM");
         int var11 = var10 - (var9.getHeight() * 2 + 8);
         int var12 = 16;

         while (var12 * 2 <= var11) {
            var12 *= 2;
         }

         if ((double)var12 * 1.5 <= (double)var11) {
            var12 = (int)((double)var12 * 1.5);
         }

         UIManager.put("Inventory.font", var7);
         UIManager.put("Inventory.gridSize", var10);
         UIManager.put("Inventory.iconSize", var12);
      }
   }
}
