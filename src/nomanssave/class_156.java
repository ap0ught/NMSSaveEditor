package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// $VF: renamed from: nomanssave.eH
public class class_156 extends class_152 {
   // $VF: renamed from: jY boolean
   final boolean field_500;
   final String name;
   // $VF: renamed from: jZ nomanssave.ex
   final class_295 field_501;
   final boolean special;
   // $VF: renamed from: ka java.lang.Integer
   final Integer field_502;
   // $VF: renamed from: jM java.lang.String
   final String field_503;
   // $VF: renamed from: kb boolean
   final boolean field_504;
   // $VF: renamed from: kc java.lang.String
   final String field_505;
   // $VF: renamed from: kd int
   final int field_506;
   final String description;
   // $VF: renamed from: ke java.util.List
   final List field_507;

   class_156(Element var1, boolean var2) {
      super(var1.getAttribute("id"));
      this.field_500 = var2;
      this.name = var1.getAttribute("name");
      if (var2) {
         this.field_501 = class_295.field_908;
      } else {
         this.field_501 = class_295.valueOf(var1.getAttribute("category"));
      }

      this.special = var1.hasAttribute("special") ? Boolean.valueOf(var1.getAttribute("special")) : false;
      this.field_502 = var1.hasAttribute("chargeable") ? new Integer(var1.getAttribute("chargeable")) : null;
      this.field_503 = var1.getAttribute("subtitle");
      this.field_504 = var1.hasAttribute("cooking") ? Boolean.valueOf(var1.getAttribute("cooking")) : false;
      this.field_505 = var1.hasAttribute("icon") ? var1.getAttribute("icon") : null;
      if (var1.hasAttribute("multiplier")) {
         this.field_506 = Integer.parseInt(var1.getAttribute("multiplier"));
      } else {
         this.field_506 = 0;
      }

      String var3 = null;
      NodeList var4 = var1.getChildNodes();
      ArrayList var6 = new ArrayList();

      for (int var7 = 0; var7 < var4.getLength(); var7++) {
         Node var5 = var4.item(var7);
         if (var5 instanceof Element) {
            var1 = (Element)var5;
            if (var1.getNodeName().equals("description")) {
               var3 = a(var1);
            } else if (var1.getNodeName().equals("requirement")) {
               var6.add(new class_123(this, var1));
            }
         }
      }

      this.description = var3;
      this.field_507 = Collections.unmodifiableList(var6);
   }

   // $VF: renamed from: ba () nomanssave.eB
   @Override
   public class_298 method_777() {
      return class_298.field_953;
   }

   // $VF: renamed from: bb () boolean
   @Override
   public boolean method_778() {
      return this.field_500;
   }

   @Override
   public String getName() {
      return this.name;
   }

   // $VF: renamed from: bc () nomanssave.ex
   @Override
   public class_295 method_779() {
      return this.field_501;
   }

   // $VF: renamed from: bd () boolean
   @Override
   public boolean method_780() {
      return !this.field_500 && this.field_501 != class_295.field_910 && this.field_501 != class_295.field_909;
   }

   // $VF: renamed from: be () boolean
   @Override
   public boolean method_781() {
      return !this.field_500 && this.special;
   }

   // $VF: renamed from: bf () java.lang.Integer
   @Override
   public Integer method_782() {
      return this.field_502;
   }

   // $VF: renamed from: bg () java.lang.String
   @Override
   public String method_783() {
      return this.field_503;
   }

   // $VF: renamed from: bh () boolean
   @Override
   public boolean method_784() {
      return this.field_504;
   }

   // $VF: renamed from: bi () java.lang.String
   @Override
   public String method_785() {
      return this.field_505;
   }

   // $VF: renamed from: bj () int
   @Override
   public int method_788() {
      return this.field_506;
   }

   @Override
   public String getDescription() {
      return this.description;
   }

   // $VF: renamed from: bk () java.util.List
   @Override
   public List method_789() {
      return this.field_507;
   }

   @Override
   public String toString() {
      return this.name.length() == 0 ? this.id : this.name;
   }
}
