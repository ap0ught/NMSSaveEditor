package nomanssave;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class cN extends JComboBox {
   private final boolean gm;
   private final Enum[] gn;
   private final List go;
   private cR gp;
   private Object gq;
   private static final Color gr = Color.RED;
   private static final Color gs = new Color(255, 100, 100);

   public cN(Class var1) {
      this.gm = gD.class.isAssignableFrom(var1);
      this.gn = (Enum[])var1.getEnumConstants();
      this.go = new ArrayList();
      this.setModel(new cO(this, var1));
      this.setRenderer(new cP(this));
   }

   public void m(String var1) {
      Object var2 = null;
      if (var1 != null) {
         for (Enum var3 : this.gn) {
            if (this.gm) {
               if (((gD)var3).K().equals(var1)) {
                  var2 = var3;
                  break;
               }
            } else if (var3.name().equals(var1)) {
               var2 = var3;
               break;
            }
         }

         if (var2 == null) {
            int var7 = this.go.indexOf(new cQ(this, var1));
            if (var7 >= 0) {
               var2 = this.go.get(var7);
            } else {
               var2 = this.gm ? new cS(this, var1) : var1;
               this.go.add(var2);
            }
         }
      }

      this.gq = var2;
      this.selectedItemChanged();
      this.updateUI();
   }

   public void a(cR var1) {
      this.gp = var1;
   }
}
