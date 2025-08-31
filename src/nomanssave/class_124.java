package nomanssave;

import org.w3c.dom.Element;

// $VF: renamed from: nomanssave.ew
public class class_124 {
   // $VF: renamed from: iI java.lang.String
   final String field_418;
   // $VF: renamed from: iJ int
   final int field_419;
   // $VF: renamed from: iK int
   final int field_420;

   class_124(Element var1) {
      this.field_418 = var1.getAttribute("group");
      this.field_419 = Integer.parseInt(var1.getAttribute("substance"));
      this.field_420 = Integer.parseInt(var1.getAttribute("product"));
   }

   // $VF: renamed from: aX () int
   public int method_664() {
      return this.field_419;
   }

   // $VF: renamed from: aY () int
   public int method_665() {
      return this.field_420;
   }
}
