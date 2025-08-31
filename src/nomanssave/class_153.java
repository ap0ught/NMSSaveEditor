package nomanssave;

import java.io.ByteArrayOutputStream;
import java.util.List;
import org.w3c.dom.Element;

// $VF: renamed from: nomanssave.eR
public class class_153 extends class_152 {
   // $VF: renamed from: kc java.lang.String
   final String field_481;
   // $VF: renamed from: kn nomanssave.eA
   final class_162 field_482;

   class_153(class_154 var1, Element var2) {
      super(var2.getAttribute("id"));
      this.field_483 = var1;
      this.field_481 = var2.hasAttribute("icon") ? var2.getAttribute("icon") : null;
      this.field_482 = class_152.method_796(var2.getAttribute("template"));
   }

   // $VF: renamed from: aZ () java.lang.Object
   @Override
   public Object method_775() {
      return this.method_776(this.field_483.field_485 ? (int)Math.floor(Math.random() * 100000.0) : 0);
   }

   // $VF: renamed from: M (int) java.lang.Object
   @Override
   public Object method_776(int var1) {
      if (this.id.length() != 13 || this.id.charAt(0) != '^') {
         throw new RuntimeException("Cannot create ID: invalid string");
      } else if (var1 >= 0 && var1 < 100000) {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         var2.write(94);

         for (int var3 = 0; var3 < 6; var3++) {
            int var4 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(var3 * 2 + 1));
            int var5 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(var3 * 2 + 2));
            if (var4 < 0 || var5 < 0) {
               throw new RuntimeException("Cannot create ID: invalid hex");
            }

            if (var4 >= 16) {
               var4 -= 6;
            }

            if (var5 >= 16) {
               var5 -= 6;
            }

            var2.write(var4 << 4 | var5);
         }

         var2.write(35);

         for (int var6 = 100000; var6 > 1; var6 /= 10) {
            int var7 = var1 * 10 / var6 % 10;
            var2.write("0123456789ABCDEFabcdef".charAt(var7));
         }

         return new class_95(var2.toByteArray());
      } else {
         throw new RuntimeException("Cannot create ID: invalid proc");
      }
   }

   // $VF: renamed from: ba () nomanssave.eB
   @Override
   public class_298 method_777() {
      return class_298.field_953;
   }

   // $VF: renamed from: bb () boolean
   @Override
   public boolean method_778() {
      return this.field_483.field_485;
   }

   // $VF: renamed from: y (java.lang.String) java.lang.String
   private String method_807(String var1) {
      if ("NAME".equals(var1)) {
         return this.field_483.name;
      } else {
         return "TECH_DESC".equals(var1) ? this.field_483.description : var1;
      }
   }

   @Override
   public String getName() {
      return this.field_482.method_822(this::y);
   }

   // $VF: renamed from: bc () nomanssave.ex
   @Override
   public class_295 method_779() {
      return class_295.field_913;
   }

   // $VF: renamed from: bd () boolean
   @Override
   public boolean method_780() {
      return false;
   }

   // $VF: renamed from: be () boolean
   @Override
   public boolean method_781() {
      return false;
   }

   // $VF: renamed from: bf () java.lang.Integer
   @Override
   public Integer method_782() {
      return null;
   }

   // $VF: renamed from: bg () java.lang.String
   @Override
   public String method_783() {
      return this.field_482.method_823(this::y);
   }

   // $VF: renamed from: bh () boolean
   @Override
   public boolean method_784() {
      return false;
   }

   // $VF: renamed from: bi () java.lang.String
   @Override
   public String method_785() {
      return this.field_481;
   }

   // $VF: renamed from: bj () int
   @Override
   public int method_788() {
      return 0;
   }

   @Override
   public String getDescription() {
      return this.field_482.method_824(this::y);
   }

   // $VF: renamed from: bk () java.util.List
   @Override
   public List method_789() {
      return this.field_483.field_491;
   }

   @Override
   public String toString() {
      return this.field_483.name.length() == 0 ? this.id : this.field_483.name;
   }
}
