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

// $VF: renamed from: nomanssave.eu
public class class_125 {
   // $VF: renamed from: iH java.util.List
   private static List field_421 = new ArrayList();

   static {
      InputStream var0 = Application.class.getResourceAsStream("db/inventory.xml");
      if (var0 != null) {
         try {
            Document var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var0);
            Element var2 = var1.getDocumentElement();
            NodeList var3 = var2.getChildNodes();

            for (int var4 = 0; var4 < var3.getLength(); var4++) {
               Node var5 = var3.item(var4);
               if (var5 instanceof Element && var5.getNodeName().equals("difficulty")) {
                  field_421.add(new class_158((Element)var5));
               }
            }
         } catch (ParserConfigurationException var6) {
         } catch (SAXException var7) {
         } catch (IOException var8) {
         }
      }
   }

   // $VF: renamed from: b (java.lang.String, java.lang.String) nomanssave.ew
   public static class_124 method_666(String var0, String var1) {
      for (class_158 var2 : field_421) {
         if (var2.field_509.equals(var0)) {
            for (class_124 var4 : var2) {
               if (var4.field_418.equals(var1)) {
                  return var4;
               }
            }
         }
      }

      return null;
   }
}
