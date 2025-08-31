package nomanssave;

import org.w3c.dom.Element;

// $VF: renamed from: nomanssave.ez
public class class_123 {
   // $VF: renamed from: id java.lang.String
   final String field_415;
   // $VF: renamed from: jK int
   final int field_416;

   class_123(class_152 var1, Element var2) {
      this.field_417 = var1;
      this.field_415 = var2.getAttribute("id");
      this.field_416 = Integer.parseInt(var2.getAttribute("quantity"));
   }

   public String getID() {
      return this.field_415;
   }

   // $VF: renamed from: bo () int
   public int method_663() {
      return this.field_416;
   }
}
