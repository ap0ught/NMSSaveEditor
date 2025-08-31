package nomanssave;

import java.util.function.Function;
import java.util.regex.Matcher;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// $VF: renamed from: nomanssave.eA
class class_162 {
   // $VF: renamed from: id java.lang.String
   final String field_513;
   final String name;
   // $VF: renamed from: jM java.lang.String
   final String field_514;
   final String description;

   class_162(Element var1) {
      this.field_513 = var1.getAttribute("id");
      this.name = var1.getAttribute("name");
      this.field_514 = var1.getAttribute("subtitle");
      String var2 = null;
      NodeList var3 = var1.getChildNodes();

      for (int var5 = 0; var5 < var3.getLength(); var5++) {
         Node var4 = var3.item(var5);
         if (var4 instanceof Element) {
            var1 = (Element)var4;
            if (var1.getNodeName().equals("description")) {
               var2 = class_152.method_790(var1);
            }
         }
      }

      this.description = var2;
   }

   // $VF: renamed from: a (java.lang.String, java.util.function.Function) java.lang.String
   private String method_821(String var1, Function var2) {
      StringBuilder var3 = new StringBuilder();
      int var4 = 0;

      for (Matcher var5 = class_152.method_797().matcher(var1); var5.find(); var4 = var5.end()) {
         var3.append(var1.substring(var4, var5.start()));
         var3.append((String)var2.apply(var5.group(1)));
      }

      var3.append(var1.substring(var4));
      return var3.toString();
   }

   // $VF: renamed from: a (java.util.function.Function) java.lang.String
   String method_822(Function var1) {
      return this.method_821(this.name, var1);
   }

   // $VF: renamed from: b (java.util.function.Function) java.lang.String
   String method_823(Function var1) {
      return this.method_821(this.field_514, var1);
   }

   // $VF: renamed from: c (java.util.function.Function) java.lang.String
   String method_824(Function var1) {
      return this.description == null ? null : this.method_821(this.description, var1);
   }
}
