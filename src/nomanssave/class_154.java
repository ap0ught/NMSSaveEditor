package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// $VF: renamed from: nomanssave.eQ
public class class_154 extends class_152 {
   // $VF: renamed from: gc java.lang.String
   private static final String field_484 = "0123456789ABCDEFabcdef";
   // $VF: renamed from: jY boolean
   final boolean field_485;
   final String name;
   // $VF: renamed from: jZ nomanssave.ex
   final class_295 field_486;
   final boolean special;
   // $VF: renamed from: ka java.lang.Integer
   final Integer field_487;
   // $VF: renamed from: jM java.lang.String
   final String field_488;
   // $VF: renamed from: kc java.lang.String
   final String field_489;
   // $VF: renamed from: kd int
   final int field_490;
   final String description;
   // $VF: renamed from: ke java.util.List
   final List field_491;
   // $VF: renamed from: km nomanssave.eR
   final class_153 field_492;

   class_154(Element var1, boolean var2) {
      super(var1.getAttribute("id"));
      this.field_485 = var2;
      this.name = var1.getAttribute("name");

      try {
         if (var2) {
            this.field_486 = class_295.valueOf("PROC_" + var1.getAttribute("category"));
         } else {
            this.field_486 = class_295.valueOf(var1.getAttribute("category"));
         }
      } catch (IllegalArgumentException var10) {
         throw new RuntimeException("Error in tech: " + this.id, var10);
      }

      this.special = var1.hasAttribute("special") ? Boolean.valueOf(var1.getAttribute("special")) : false;
      this.field_487 = var1.hasAttribute("chargeable") ? new Integer(var1.getAttribute("chargeable")) : null;
      this.field_488 = var1.getAttribute("subtitle");
      this.field_489 = var1.hasAttribute("icon") ? var1.getAttribute("icon") : null;
      if (var1.hasAttribute("multiplier")) {
         this.field_490 = Integer.parseInt(var1.getAttribute("multiplier"));
      } else {
         this.field_490 = 0;
      }

      String var3 = null;
      ArrayList var4 = new ArrayList();
      class_153 var5 = null;
      NodeList var6 = var1.getChildNodes();

      for (int var9 = 0; var9 < var6.getLength(); var9++) {
         Node var7 = var6.item(var9);
         if (var7 instanceof Element) {
            Element var8 = (Element)var7;
            if (var8.getNodeName().equals("description")) {
               var3 = a(var8);
            } else if (var8.getNodeName().equals("requirement")) {
               var4.add(new class_123(this, var8));
            } else if (var8.getNodeName().equals("techbox")) {
               var5 = new class_153(this, var8);
            }
         }
      }

      this.description = var3;
      this.field_491 = Collections.unmodifiableList(var4);
      this.field_492 = var5;
   }

   // $VF: renamed from: ba () nomanssave.eB
   @Override
   public class_298 method_777() {
      return class_298.field_952;
   }

   // $VF: renamed from: bb () boolean
   @Override
   public boolean method_778() {
      return this.field_485;
   }

   @Override
   public String getName() {
      return this.name;
   }

   // $VF: renamed from: bc () nomanssave.ex
   @Override
   public class_295 method_779() {
      return this.field_486;
   }

   // $VF: renamed from: bd () boolean
   @Override
   public boolean method_780() {
      return !this.field_485 && this.field_486 != class_295.field_910 && this.field_486 != class_295.field_909;
   }

   // $VF: renamed from: be () boolean
   @Override
   public boolean method_781() {
      return !this.field_485 && this.special;
   }

   // $VF: renamed from: bf () java.lang.Integer
   @Override
   public Integer method_782() {
      return this.field_487;
   }

   // $VF: renamed from: bg () java.lang.String
   @Override
   public String method_783() {
      return this.field_488;
   }

   // $VF: renamed from: bh () boolean
   @Override
   public boolean method_784() {
      return false;
   }

   // $VF: renamed from: bi () java.lang.String
   @Override
   public String method_785() {
      return this.field_489;
   }

   // $VF: renamed from: bj () int
   @Override
   public int method_788() {
      return this.field_490;
   }

   @Override
   public String getDescription() {
      return this.description;
   }

   // $VF: renamed from: bk () java.util.List
   @Override
   public List method_789() {
      return this.field_491;
   }

   // $VF: renamed from: bv () nomanssave.eR
   public class_153 method_808() {
      return this.field_492;
   }

   @Override
   public String toString() {
      return this.name.length() == 0 ? this.id : this.name;
   }
}
