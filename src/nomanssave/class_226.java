package nomanssave;

import java.awt.Color;

// $VF: renamed from: nomanssave.bu
class class_226 implements Runnable {
   class_226(class_227 var1, Application var2) {
      this.field_607 = var1;
      this.field_608 = var2;
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      class_355.method_1063(class_227.method_837(this.field_607), class_355.method_1059(class_227.method_837(this.field_607)).getSelectedRow());
      if (class_355.method_1056(class_227.method_837(this.field_607)) < 0) {
         class_355.method_1064(class_227.method_837(this.field_607), new class_128[0]);
         class_355.method_1065(class_227.method_837(this.field_607), new class_128[0]);
         class_355.method_1066(class_227.method_837(this.field_607)).setVisible(false);
         class_355.method_1067(class_227.method_837(this.field_607)).setVisible(false);
         class_355.method_1068(class_227.method_837(this.field_607)).setText("");
         class_355.method_1069(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1070(class_227.method_837(this.field_607)).setText("");
         class_355.method_1071(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1072(class_227.method_837(this.field_607)).setText("");
         class_355.method_1073(class_227.method_837(this.field_607)).setText("");

         for (int var2 = 0; var2 < class_355.method_1058(class_227.method_837(this.field_607)).length; var2++) {
            class_355.method_1058(class_227.method_837(this.field_607))[var2].setText("");
         }

         class_355.method_1074(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1075(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1076(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1077(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1078(class_227.method_837(this.field_607)).setSelectedIndex(-1);
         class_355.method_1079(class_227.method_837(this.field_607)).setText("");
         class_355.method_1080(class_227.method_837(this.field_607)).setText("");
         class_355.method_1081(class_227.method_837(this.field_607)).setText("");
         class_355.method_1082(class_227.method_837(this.field_607)).setText("");
         class_355.method_1066(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1067(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1083(class_227.method_837(this.field_607)).setText("");
         class_355.method_1084(class_227.method_837(this.field_607)).setVisible(false);
         class_355.method_1085(class_227.method_837(this.field_607)).setEnabled(false);
         class_355.method_1062(class_227.method_837(this.field_607)).setEnabled(false);
      } else {
         class_355.method_1064(
            class_227.method_837(this.field_607),
            class_128.method_672(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_224()
            )
         );
         class_355.method_1065(
            class_227.method_837(this.field_607),
            class_128.method_673(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_224()
            )
         );
         class_355.method_1066(class_227.method_837(this.field_607)).setVisible(true);
         class_355.method_1067(class_227.method_837(this.field_607)).setVisible(true);
         class_355.method_1068(class_227.method_837(this.field_607))
            .setText(class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].getName());
         class_355.method_1069(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_224()
            );
         class_355.method_1070(class_227.method_837(this.field_607))
            .setText(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_226().toString()
            );
         class_355.method_1071(class_227.method_837(this.field_607))
            .method_985(class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_231());
         class_355.method_1072(class_227.method_837(this.field_607))
            .setText(class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_227());
         class_355.method_1073(class_227.method_837(this.field_607))
            .setText(class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_229());

         for (int var1 = 0; var1 < class_355.method_1058(class_227.method_837(this.field_607)).length; var1++) {
            class_355.method_1058(class_227.method_837(this.field_607))[var1]
               .setText(
                  Integer.toString(
                     class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_233(var1)
                  )
               );
         }

         class_355.method_1074(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_235(0)
            );
         class_355.method_1075(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_235(1)
            );
         class_355.method_1076(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_235(2)
            );
         class_355.method_1077(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_235(3)
            );
         class_355.method_1078(class_227.method_837(this.field_607))
            .setSelectedItem(
               class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_235(4)
            );
         class_355.method_1079(class_227.method_837(this.field_607))
            .setText(
               Integer.toString(
                  class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_237()
               )
            );
         class_355.method_1080(class_227.method_837(this.field_607))
            .setText(
               Integer.toString(
                  class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_239()
               )
            );
         class_355.method_1081(class_227.method_837(this.field_607))
            .setText(
               Integer.toString(
                  class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_241()
               )
            );
         class_355.method_1082(class_227.method_837(this.field_607))
            .setText(
               Integer.toString(
                  class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_243()
               )
            );
         if (this.field_608
            .method_1371(class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].getIndex())) {
            class_355.method_1083(class_227.method_837(this.field_607)).setText("Status: On Mission");
            class_355.method_1083(class_227.method_837(this.field_607)).setForeground(Color.BLUE);
            class_355.method_1084(class_227.method_837(this.field_607)).setVisible(false);
         } else if (class_355.method_1057(class_227.method_837(this.field_607))[class_355.method_1056(class_227.method_837(this.field_607))].method_247() > 0) {
            class_355.method_1083(class_227.method_837(this.field_607)).setText("Status: Damaged!");
            class_355.method_1083(class_227.method_837(this.field_607)).setForeground(Color.RED);
            class_355.method_1084(class_227.method_837(this.field_607)).setVisible(true);
         } else {
            class_355.method_1083(class_227.method_837(this.field_607)).setText("");
            class_355.method_1084(class_227.method_837(this.field_607)).setVisible(false);
         }

         class_355.method_1066(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1067(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1074(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1075(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1076(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1077(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1078(class_227.method_837(this.field_607)).updateUI();
         class_355.method_1085(class_227.method_837(this.field_607)).setEnabled(class_355.method_1057(class_227.method_837(this.field_607)).length > 1);
         class_355.method_1062(class_227.method_837(this.field_607))
            .setEnabled(class_355.method_1057(class_227.method_837(this.field_607)).length < 30 || class_130.method_681());
      }
   }
}
