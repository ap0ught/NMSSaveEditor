package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// $VF: renamed from: nomanssave.eS
public class class_144 {
   // $VF: renamed from: id java.lang.String
   final String field_458;
   final String text;
   // $VF: renamed from: kp java.util.HashMap
   private final HashMap field_459;
   // $VF: renamed from: kq java.util.List
   private static final List field_460 = new ArrayList();

   static {
      InputStream var0 = Application.class.getResourceAsStream("db/words.xml");
      if (var0 != null) {
         try {
            Document var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var0);
            Element var2 = var1.getDocumentElement();
            NodeList var3 = var2.getChildNodes();

            for (int var4 = 0; var4 < var3.getLength(); var4++) {
               Node var5 = var3.item(var4);
               if (var5 instanceof Element && var5.getNodeName().equals("word")) {
                  field_460.add(new class_144((Element)var5));
               }
            }
         } catch (ParserConfigurationException var6) {
         } catch (SAXException var7) {
         } catch (IOException var8) {
         }
      }

      field_460.sort(new class_143());
   }

   private class_144(Element var1) {
      this.field_458 = var1.getAttribute("id");
      this.text = var1.getAttribute("text");
      this.field_459 = new HashMap();
      NodeList var2 = var1.getElementsByTagName("group");

      for (int var3 = 0; var3 < var2.getLength(); var3++) {
         Element var4 = (Element)var2.item(var3);
         String var5 = var4.getAttribute("group");
         class_296 var6 = class_296.method_857(var4.getAttribute("race"));
         if (var6 != null) {
            this.field_459.put(var5, var6);
         }
      }
   }

   public String getID() {
      return this.field_458;
   }

   public String getText() {
      return this.text;
   }

   // $VF: renamed from: bw () java.lang.Iterable
   public Iterable method_749() {
      return Collections.unmodifiableSet(this.field_459.keySet());
   }

   // $VF: renamed from: z (java.lang.String) nomanssave.eU
   public class_296 method_750(String var1) {
      return (class_296)this.field_459.get(var1);
   }

   // $VF: renamed from: a (nomanssave.eU) boolean
   public boolean method_751(class_296 var1) {
      return this.field_459.containsValue(var1);
   }

   // $VF: renamed from: A (java.lang.String) nomanssave.eS
   public static class_144 method_752(String var0) {
      for (class_144 var1 : field_460) {
         if (var1.field_458.equals(var0)) {
            return var1;
         }
      }

      return null;
   }

   // $VF: renamed from: B (java.lang.String) nomanssave.eS
   public static class_144 method_753(String var0) {
      for (class_144 var1 : field_460) {
         if (var1.field_459.containsKey(var0)) {
            return var1;
         }
      }

      return null;
   }

   // $VF: renamed from: bx () int
   public static int method_754() {
      return field_460.size();
   }

   // $VF: renamed from: T (int) nomanssave.eS
   public static class_144 method_755(int var0) {
      return (class_144)field_460.get(var0);
   }

   // $VF: renamed from: by () java.lang.Iterable
   public static Iterable method_756() {
      return Collections.unmodifiableList(field_460);
   }
}
