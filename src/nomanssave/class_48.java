package nomanssave;

import java.util.ArrayList;
import java.util.List;

// $VF: renamed from: nomanssave.gf
public class class_48 {
   // $VF: renamed from: nj nomanssave.eY
   final class_137 field_126;

   private class_48(class_49 var1, class_137 var2) {
      this.field_127 = var1;
      this.field_126 = var2;
   }

   // $VF: renamed from: cF () java.lang.String
   public String method_296() {
      Object var1 = this.field_126.getValue("GalacticAddress");
      if (var1 instanceof String) {
         return (String)var1;
      } else {
         return var1 instanceof Number ? "0x" + Long.toHexString(((Number)var1).longValue()) : null;
      }
   }

   public String getName() {
      return this.field_126.getValueAsString("Name");
   }

   public void setName(String var1) {
      this.field_126.method_713("Name", var1);
   }

   // $VF: renamed from: cG () int
   public int method_297() {
      return this.field_126.method_703("Objects").size();
   }

   // $VF: renamed from: cH () nomanssave.eY
   public class_137 method_298() {
      return this.field_126;
   }

   // $VF: renamed from: cI () java.util.List
   public List method_299() {
      ArrayList var1 = new ArrayList();

      for (class_137 var2 : class_63.method_343(this.field_126)) {
         var1.add(new class_47(this, var2));
      }

      return var1;
   }

   // $VF: renamed from: a (nomanssave.gg) boolean
   public boolean method_300(class_47 var1) {
      return class_63.method_344(this.field_126, var1.field_124);
   }

   @Override
   public String toString() {
      return this.field_126.getValueAsString("Name");
   }
}
