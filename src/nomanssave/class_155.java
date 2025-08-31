package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// $VF: renamed from: nomanssave.eP
public class class_155 extends class_152 {
   final String name;
   // $VF: renamed from: jZ nomanssave.ex
   final class_295 field_493;
   final boolean special;
   // $VF: renamed from: ka java.lang.Integer
   final Integer field_494;
   // $VF: renamed from: jM java.lang.String
   final String field_495;
   // $VF: renamed from: kb boolean
   final boolean field_496;
   // $VF: renamed from: kc java.lang.String
   final String field_497;
   // $VF: renamed from: kd int
   final int field_498;
   final String description;
   // $VF: renamed from: ke java.util.List
   final List field_499;

   class_155(Element var1) {
      super(var1.getAttribute("id"));
      this.name = var1.getAttribute("name");
      this.field_493 = class_295.valueOf(var1.getAttribute("category"));
      this.special = var1.hasAttribute("special") ? Boolean.valueOf(var1.getAttribute("special")) : false;
      this.field_494 = var1.hasAttribute("chargeable") ? new Integer(var1.getAttribute("chargeable")) : null;
      this.field_495 = var1.getAttribute("subtitle");
      this.field_496 = var1.hasAttribute("cooking") ? Boolean.valueOf(var1.getAttribute("cooking")) : false;
      this.field_497 = var1.hasAttribute("icon") ? var1.getAttribute("icon") : null;
      if (var1.hasAttribute("multiplier")) {
         this.field_498 = Integer.parseInt(var1.getAttribute("multiplier"));
      } else {
         this.field_498 = 0;
      }

      String var2 = null;
      NodeList var3 = var1.getChildNodes();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 < var3.getLength(); var6++) {
         Node var4 = var3.item(var6);
         if (var4 instanceof Element) {
            var1 = (Element)var4;
            if (var1.getNodeName().equals("description")) {
               var2 = a(var1);
            } else if (var1.getNodeName().equals("requirement")) {
               var5.add(new class_123(this, var1));
            }
         }
      }

      this.description = var2;
      this.field_499 = Collections.unmodifiableList(var5);
   }

   // $VF: renamed from: ba () nomanssave.eB
   @Override
   public class_298 method_777() {
      return class_298.field_954;
   }

   // $VF: renamed from: bb () boolean
   @Override
   public boolean method_778() {
      return false;
   }

   @Override
   public String getName() {
      return this.name;
   }

   // $VF: renamed from: bc () nomanssave.ex
   @Override
   public class_295 method_779() {
      return this.field_493;
   }

   // $VF: renamed from: bd () boolean
   @Override
   public boolean method_780() {
      return this.field_493 != class_295.field_910 && this.field_493 != class_295.field_909;
   }

   // $VF: renamed from: be () boolean
   @Override
   public boolean method_781() {
      return this.special;
   }

   // $VF: renamed from: bf () java.lang.Integer
   @Override
   public Integer method_782() {
      return this.field_494;
   }

   // $VF: renamed from: bg () java.lang.String
   @Override
   public String method_783() {
      return this.field_495;
   }

   // $VF: renamed from: bh () boolean
   @Override
   public boolean method_784() {
      return this.field_496;
   }

   // $VF: renamed from: bi () java.lang.String
   @Override
   public String method_785() {
      return this.field_497;
   }

   // $VF: renamed from: bj () int
   @Override
   public int method_788() {
      return this.field_498;
   }

   @Override
   public String getDescription() {
      return this.description;
   }

   // $VF: renamed from: bk () java.util.List
   @Override
   public List method_789() {
      return this.field_499;
   }

   @Override
   public String toString() {
      return this.name.length() == 0 ? this.id : this.name;
   }
}
