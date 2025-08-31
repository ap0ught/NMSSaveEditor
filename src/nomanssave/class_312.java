package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// $VF: renamed from: nomanssave.P
class class_312 implements ActionListener {
   class_312(class_372 var1, Application var2) {
      this.field_991 = var1;
      this.field_992 = var2;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      class_48 var2 = (class_48)class_372.method_1310(this.field_991).getSelectedItem();
      if (var2 != null) {
         List var3 = var2.method_299();
         if (var3.size() == 0) {
            this.field_992
               .method_1342(
                  "Cannot move base computer.\nPlease ensure that your base has a suitable Signal Booster / Blueprint Analyser / Beacon placed where you want your base computer to be."
               );
         } else {
            int var4;
            if ((var4 = class_324.method_943(this.field_992.method_1327(), var3)) >= 0) {
               class_47 var5 = (class_47)var3.get(var4);
               class_37.info("Attempting to swap base computer with " + var5.toString() + "...");
               if (var2.method_300(var5)) {
                  class_37.info("Base computer relocated: " + var2.getName());
               } else {
                  class_37.info("Base computer not moved.");
                  this.field_992.method_1342("An error occurred while attempting to move base computer.");
               }
            }
         }
      }
   }
}
