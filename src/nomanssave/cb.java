package nomanssave;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class cB implements DocumentListener {
   cB(cy var1) {
      this.gg = var1;
   }

   @Override
   public void insertUpdate(DocumentEvent var1) {
      cy.a(this.gg, true);
   }

   @Override
   public void removeUpdate(DocumentEvent var1) {
      cy.a(this.gg, true);
   }

   @Override
   public void changedUpdate(DocumentEvent var1) {
   }
}
