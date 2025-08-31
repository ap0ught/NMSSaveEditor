package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// $VF: renamed from: nomanssave.er
public class class_128 {
   // $VF: renamed from: id java.lang.String
   final String field_423;
   final String name;
   // $VF: renamed from: iB nomanssave.gq
   final class_285 field_424;
   // $VF: renamed from: iC int
   final int field_425;
   // $VF: renamed from: iD nomanssave.gr
   final class_284 field_426;
   // $VF: renamed from: iE boolean
   final boolean field_427;
   // $VF: renamed from: iF nomanssave.gr[]
   final class_284[] field_428;
   // $VF: renamed from: iG java.util.List
   private static final List field_429 = new ArrayList();

   static {
      InputStream var0 = Application.class.getResourceAsStream("db/frigates.xml");
      if (var0 != null) {
         try {
            Document var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var0);
            Element var2 = var1.getDocumentElement();
            NodeList var3 = var2.getChildNodes();

            for (int var4 = 0; var4 < var3.getLength(); var4++) {
               Node var5 = var3.item(var4);
               if (var5 instanceof Element && var5.getNodeName().equals("trait")) {
                  field_429.add(new class_128((Element)var5));
               }
            }
         } catch (ParserConfigurationException var6) {
         } catch (SAXException var7) {
         } catch (IOException var8) {
         }
      }

      field_429.sort(new class_127());
   }

   private class_128(Element var1) {
      this.field_423 = var1.getAttribute("id");
      this.name = var1.getAttribute("name");
      String var2 = var1.getAttribute("type");
      this.field_424 = var2 == null ? null : class_285.valueOf(var2);
      this.field_425 = Integer.parseInt(var1.getAttribute("strength"));
      var2 = var1.getAttribute("primary");
      this.field_426 = var2 == null ? null : class_284.method_848(var2);
      this.field_427 = Boolean.parseBoolean(var1.getAttribute("beneficial"));
      this.field_428 = method_668(var1.getAttribute("secondary"));
   }

   // $VF: renamed from: n (java.lang.String) nomanssave.gr[]
   private static class_284[] method_668(String var0) {
      ArrayList var1 = new ArrayList();
      int var2 = 0;

      while (var2 < var0.length()) {
         int var4 = var0.indexOf(",", var2);
         class_284 var3;
         if (var4 >= 0) {
            var3 = class_284.method_848(var0.substring(var2, var4));
            var2 = var4 + 1;
         } else {
            var3 = class_284.method_848(var0.substring(var2));
            var2 = var0.length();
         }

         if (var3 != null) {
            var1.add(var3);
         }
      }

      return var1.toArray(new class_284[0]);
   }

   public String getID() {
      return this.field_423;
   }

   public String getName() {
      return this.name;
   }

   // $VF: renamed from: aU () nomanssave.gq
   public class_285 method_669() {
      return this.field_424;
   }

   // $VF: renamed from: aV () int
   public int method_670() {
      return this.field_425 * this.field_424.method_849();
   }

   // $VF: renamed from: aW () boolean
   public boolean method_671() {
      return this.field_427;
   }

   @Override
   public String toString() {
      String var1 = (this.field_425 > 0 ? "+" : "") + this.field_425 + (this.field_424 == class_285.field_765 ? "%" : "");
      return this.name + " (" + var1 + " " + this.field_424 + ")";
   }

   // $VF: renamed from: a (nomanssave.gr) nomanssave.er[]
   public static class_128[] method_672(class_284 var0) {
      return field_429.stream().filter(er::a).toArray(er::K);
   }

   // $VF: renamed from: b (nomanssave.gr) nomanssave.er[]
   public static class_128[] method_673(class_284 var0) {
      return field_429.stream().filter(er::b).toArray(er::K);
   }

   // $VF: renamed from: o (java.lang.String) nomanssave.er
   public static class_128 method_674(String var0) {
      int var1 = field_429.indexOf(new class_126(var0));
      return var1 >= 0 ? (class_128)field_429.get(var1) : null;
   }
}
