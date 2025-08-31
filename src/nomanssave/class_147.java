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

// $VF: renamed from: nomanssave.eM
public class class_147 {
   // $VF: renamed from: id java.lang.String
   final String field_462;
   final String name;
   final String description;
   // $VF: renamed from: iE boolean
   final boolean field_463;
   // $VF: renamed from: jY boolean
   final boolean field_464;
   // $VF: renamed from: kl java.util.List
   private static final List field_465 = new ArrayList();

   static {
      InputStream var0 = Application.class.getResourceAsStream("db/settlements.xml");
      if (var0 != null) {
         try {
            Document var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var0);
            Element var2 = var1.getDocumentElement();
            NodeList var3 = var2.getChildNodes();

            for (int var4 = 0; var4 < var3.getLength(); var4++) {
               Node var5 = var3.item(var4);
               if (var5 instanceof Element && var5.getNodeName().equals("perk")) {
                  field_465.add(new class_147((Element)var5));
               }
            }
         } catch (ParserConfigurationException var6) {
         } catch (SAXException var7) {
         } catch (IOException var8) {
         }
      }

      field_465.sort(new class_146());
   }

   private class_147(Element var1) {
      this.field_462 = var1.getAttribute("id");
      this.name = var1.getAttribute("name");
      this.description = var1.getAttribute("description");
      this.field_463 = Boolean.parseBoolean(var1.getAttribute("beneficial"));
      this.field_464 = Boolean.parseBoolean(var1.getAttribute("procedural"));
   }

   public String getID() {
      return this.field_462;
   }

   public String getName() {
      return this.name;
   }

   public String getDescription() {
      return this.description;
   }

   // $VF: renamed from: aW () boolean
   public boolean method_758() {
      return this.field_463;
   }

   // $VF: renamed from: bb () boolean
   public boolean method_759() {
      return this.field_464;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return this.field_464 ? ((String)var1).startsWith(this.field_462 + "#") : ((String)var1).equals(this.field_462);
      } else {
         return super.equals(var1);
      }
   }

   @Override
   public String toString() {
      return this.name;
   }

   public static int getCount() {
      return field_465.size();
   }

   // $VF: renamed from: S (int) nomanssave.eM
   public static class_147 method_760(int var0) {
      return (class_147)field_465.get(var0);
   }

   // $VF: renamed from: w (java.lang.String) int
   public static int method_761(String var0) {
      return field_465.indexOf(new class_145(var0));
   }

   // $VF: renamed from: x (java.lang.String) nomanssave.eM
   public static class_147 method_762(String var0) {
      int var1 = field_465.indexOf(new class_145(var0));
      return var1 >= 0 ? (class_147)field_465.get(var1) : null;
   }
}
