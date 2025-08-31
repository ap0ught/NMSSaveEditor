package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// $VF: renamed from: nomanssave.eI
public class class_151 {
   // $VF: renamed from: kf int
   public static final int field_466 = 0;
   // $VF: renamed from: kg int
   public static final int field_467 = 1;
   // $VF: renamed from: kh int
   public static final int field_468 = 2;
   final int type;
   // $VF: renamed from: id java.lang.String
   final String field_469;
   final String name;
   // $VF: renamed from: ki java.util.List
   private static final List field_470 = new ArrayList();
   // $VF: renamed from: kj java.util.List
   private static final List field_471 = new ArrayList();
   // $VF: renamed from: kk java.util.List
   private static final List field_472 = new ArrayList();

   static {
      InputStream var0 = Application.class.getResourceAsStream("db/rewards.xml");
      if (var0 != null) {
         try {
            Document var1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var0);
            Element var2 = var1.getDocumentElement();
            NodeList var3 = var2.getChildNodes();

            for (int var4 = 0; var4 < var3.getLength(); var4++) {
               Node var5 = var3.item(var4);
               if (var5 instanceof Element && var5.getNodeName().equals("season")) {
                  field_470.add(new class_151((Element)var5, 0));
               }

               if (var5 instanceof Element && var5.getNodeName().equals("twitch")) {
                  field_471.add(new class_151((Element)var5, 1));
               }

               if (var5 instanceof Element && var5.getNodeName().equals("platform")) {
                  field_472.add(new class_151((Element)var5, 2));
               }
            }
         } catch (ParserConfigurationException var6) {
         } catch (SAXException var7) {
         } catch (IOException var8) {
         }
      }

      field_470.sort(new class_150());
      field_471.sort(new class_149());
      field_472.sort(new class_148());
   }

   private class_151(Element var1, int var2) {
      this.type = var2;
      this.field_469 = var1.getAttribute("id");
      this.name = var1.getAttribute("name");
   }

   public String getID() {
      return this.field_469;
   }

   public String getName() {
      return this.name;
   }

   // $VF: renamed from: bq () int
   public static int method_766() {
      return field_470.size();
   }

   // $VF: renamed from: P (int) nomanssave.eI
   public static class_151 method_767(int var0) {
      return (class_151)field_470.get(var0);
   }

   // $VF: renamed from: br () int
   public static int method_768() {
      return field_471.size();
   }

   // $VF: renamed from: Q (int) nomanssave.eI
   public static class_151 method_769(int var0) {
      return (class_151)field_471.get(var0);
   }

   // $VF: renamed from: bs () int
   public static int method_770() {
      return field_472.size();
   }

   // $VF: renamed from: R (int) nomanssave.eI
   public static class_151 method_771(int var0) {
      return (class_151)field_472.get(var0);
   }

   // $VF: renamed from: bt () java.lang.Iterable
   public static Iterable method_772() {
      return Collections.unmodifiableList(field_470);
   }

   // $VF: renamed from: bu () java.lang.Iterable
   public static Iterable method_773() {
      return Collections.unmodifiableList(field_471);
   }
}
