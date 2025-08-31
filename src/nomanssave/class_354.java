package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// $VF: renamed from: nomanssave.c
public class class_354 extends JPanel {
   // $VF: renamed from: c nomanssave.f
   private final class_331 field_1166;
   // $VF: renamed from: d nomanssave.f
   private final class_331 field_1167;
   // $VF: renamed from: e nomanssave.f
   private final class_331 field_1168;

   class_354(Application var1) {
      GridLayout var2 = new GridLayout(2, 3);
      this.setLayout(var2);
      JPanel var3 = new JPanel();
      this.add(var3);
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Season Rewards");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var3.add(var4, "2, 2");
      JScrollPane var5 = new JScrollPane();
      var3.add(var5, "2, 4, fill, fill");
      this.field_1166 = new class_331(this, var1, eI::bq, eI::P);
      var5.setViewportView(this.field_1166);
      JPanel var6 = new JPanel();
      this.add(var6);
      var6.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var4 = new JLabel("Twitch Rewards");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var6.add(var4, "2, 2");
      JScrollPane var7 = new JScrollPane();
      var6.add(var7, "2, 4, fill, fill");
      this.field_1167 = new class_331(this, var1, eI::br, eI::Q);
      var7.setViewportView(this.field_1167);
      var4 = new JLabel("NOTE: To use twitch drops, you must go offline before you start the game.");
      var6.add(var4, "2, 6, fill, fill");
      var4 = new JLabel("You can claim them at the Synthesis vendor in the Anomaly.");
      var6.add(var4, "2, 7, fill, fill");
      JPanel var8 = new JPanel();
      this.add(var8);
      var8.setLayout(
         new FormLayout(
            new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC},
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("200px:grow"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      var4 = new JLabel("Platform Rewards");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var8.add(var4, "2, 2");
      JScrollPane var9 = new JScrollPane();
      var8.add(var9, "2, 4, fill, fill");
      this.field_1168 = new class_331(this, var1, eI::bs, eI::R);
      var9.setViewportView(this.field_1168);
      JPanel var10 = new JPanel();
      this.add(var10);
      var10 = new JPanel();
      this.add(var10);
      var10 = new JPanel();
      this.add(var10);
   }

   // $VF: renamed from: a (nomanssave.eY) void
   void method_1053(class_137 var1) {
      if (var1 == null) {
         this.field_1166.method_984(null);
         this.field_1167.method_984(null);
         this.field_1168.method_984(null);
      } else {
         this.field_1166.method_984(var1.method_703("UserSettingsData.UnlockedSeasonRewards"));
         this.field_1167.method_984(var1.method_703("UserSettingsData.UnlockedTwitchRewards"));
         this.field_1168.method_984(var1.method_703("UserSettingsData.UnlockedPlatformRewards"));
      }

      this.updateUI();
   }
}
