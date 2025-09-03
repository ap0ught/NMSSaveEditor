package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dk implements ComboBoxModel {
   private gv hk;

   dk(dj var1) {
      this.hl = var1;
      this.hk = null;
   }

   @Override
   public int getSize() {
      return dj.a(this.hl) == null ? 0 : dj.a(this.hl).length;
   }

   public gv D(int var1) {
      return dj.a(this.hl)[var1];
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      this.hk = (gv)var1;
      if (this.hk == null) {
         dj.b(this.hl).setText("");
         dj.c(this.hl).setSelectedIndex(-1);
         dj.d(this.hl).setSelectedIndex(-1);
         dj.e(this.hl).setText("");
         dj.f(this.hl).setText("");
         dj.g(this.hl).setText("");
         dj.h(this.hl).setText("");
         dj.i(this.hl).a(Collections.emptyList());
      } else {
         dj.b(this.hl).setText(this.hk.getName());
         dj.c(this.hl).m(this.hk.cT());
         dj.d(this.hl).m(this.hk.cW());
         dj.e(this.hl).setText(this.hk.cK());
         dj.f(this.hl).setText(Double.toString(this.hk.dF()));
         dj.g(this.hl).setText(Double.toString(this.hk.dG()));
         dj.h(this.hl).setText(Double.toString(this.hk.dH()));
         dj.i(this.hl).a(Collections.singletonList(this.hk.dE()));
      }
   }

   @Override
   public Object getSelectedItem() {
      return this.hk;
   }
}
