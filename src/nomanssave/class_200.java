package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;

// $VF: renamed from: nomanssave.cO
class class_200 implements ComboBoxModel {
   class_200(class_333 var1, Class var2) {
      this.field_576 = var1;
      this.field_577 = var2;
   }

   @Override
   public int getSize() {
      return ((Enum[])this.field_577.getEnumConstants()).length + class_333.method_987(this.field_576).size();
   }

   @Override
   public Object getElementAt(int var1) {
      return var1 < ((Enum[])this.field_577.getEnumConstants()).length
         ? ((Enum[])this.field_577.getEnumConstants())[var1]
         : class_333.method_987(this.field_576).get(var1 - ((Enum[])this.field_577.getEnumConstants()).length);
   }

   @Override
   public void addListDataListener(ListDataListener var1) {
   }

   @Override
   public void removeListDataListener(ListDataListener var1) {
   }

   @Override
   public void setSelectedItem(Object var1) {
      Object var2 = class_333.method_988(this.field_576);
      class_333.method_989(this.field_576, var1);
      if (class_333.method_990(this.field_576) != null) {
         SwingUtilities.invokeLater(this::c);
      }
   }

   @Override
   public Object getSelectedItem() {
      return class_333.method_988(this.field_576);
   }
}
