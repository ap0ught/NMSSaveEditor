package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class m implements ActionListener {
   m(h var1) {
      this.z = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      h.a(this.z, (ey)h.j(this.z).getSelectedItem());
      this.z.setVisible(false);
   }
}
