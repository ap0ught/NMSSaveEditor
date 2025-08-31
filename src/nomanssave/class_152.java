package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// $VF: renamed from: nomanssave.ey
public abstract class class_152 {
   // $VF: renamed from: jD int
   public static final int field_473 = 0;
   // $VF: renamed from: jE int
   public static final int field_474 = 1;
   // $VF: renamed from: jF int
   public static final int field_475 = 2;
   // $VF: renamed from: jG int
   public static final int field_476 = 3;
   // $VF: renamed from: id java.lang.String
   final String field_477;
   // $VF: renamed from: jH java.util.regex.Pattern
   private static final Pattern field_478 = Pattern.compile("%(\\w+)%");
   // $VF: renamed from: jI java.util.List
   private static final List field_479;
   // $VF: renamed from: jJ java.util.List
   private static final List field_480;

   static {
      Element var0 = null;
      InputStream var1 = Application.class.getResourceAsStream("db/items.xml");
      if (var1 != null) {
         try {
            Document var2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(var1);
            var0 = var2.getDocumentElement();
         } catch (ParserConfigurationException var7) {
         } catch (SAXException var8) {
         } catch (IOException var9) {
         }
      }

      ArrayList var10 = new ArrayList();
      if (var0 != null) {
         NodeList var3 = var0.getChildNodes();

         for (int var4 = 0; var4 < var3.getLength(); var4++) {
            Node var5 = var3.item(var4);
            if (var5 instanceof Element && var5.getNodeName().equals("product-template")) {
               var10.add(new class_162((Element)var5));
            }
         }
      }

      field_479 = Collections.unmodifiableList(var10);
      ArrayList var11 = new ArrayList();
      if (var0 != null) {
         NodeList var12 = var0.getChildNodes();

         for (int var14 = 0; var14 < var12.getLength(); var14++) {
            Node var6 = var12.item(var14);
            if (var6 instanceof Element && var6.getNodeName().equals("substance")) {
               var11.add(new class_155((Element)var6));
            } else if (var6 instanceof Element && var6.getNodeName().equals("product")) {
               var11.add(new class_156((Element)var6, false));
            } else if (var6 instanceof Element && var6.getNodeName().equals("procedural-product")) {
               var11.add(new class_156((Element)var6, true));
            } else if (var6 instanceof Element && var6.getNodeName().equals("technology")) {
               var11.add(new class_154((Element)var6, false));
            } else if (var6 instanceof Element && var6.getNodeName().equals("procedural-technology")) {
               var11.add(new class_154((Element)var6, true));
            }
         }
      }

      List var13 = var11.stream().filter(ey::a).map(eQ.class::cast).map(ey::a).filter(ey::a).collect(Collectors.toList());
      var11.addAll(var13);
      var13.sort(ey::a);
      field_480 = Collections.unmodifiableList(var11);
   }

   class_152(String var1) {
      this.field_477 = var1;
   }

   public final String getID() {
      return this.field_477;
   }

   // $VF: renamed from: L (int) java.lang.String
   private static String method_774(int var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append(Integer.toString(var0));

      while (var1.length() < 5) {
         var1.insert(0, '0');
      }

      return var1.toString();
   }

   // $VF: renamed from: aZ () java.lang.Object
   public Object method_775() {
      if (this.field_477.length() < 2 || this.field_477.charAt(0) != '^') {
         throw new RuntimeException("Cannot create ID: invalid string");
      } else if (this.method_778()) {
         int var1 = (int)Math.floor(Math.random() * 100000.0);
         return this.field_477 + "#" + method_774(var1);
      } else {
         return this.field_477;
      }
   }

   // $VF: renamed from: M (int) java.lang.Object
   public Object method_776(int var1) {
      if (this.field_477.length() < 2 || this.field_477.charAt(0) != '^') {
         throw new RuntimeException("Cannot create ID: invalid string");
      } else if (this.method_778()) {
         if (var1 >= 0 && var1 < 100000) {
            return this.field_477 + "#" + method_774(var1);
         } else {
            throw new RuntimeException("Cannot create ID: invalid proc");
         }
      } else if (var1 != 0) {
         throw new RuntimeException("Cannot create ID: invalid proc");
      } else {
         return this.field_477;
      }
   }

   // $VF: renamed from: ba () nomanssave.eB
   public abstract class_298 method_777();

   // $VF: renamed from: bb () boolean
   public abstract boolean method_778();

   public abstract String getName();

   // $VF: renamed from: bc () nomanssave.ex
   public abstract class_295 method_779();

   // $VF: renamed from: bd () boolean
   public abstract boolean method_780();

   // $VF: renamed from: be () boolean
   public abstract boolean method_781();

   // $VF: renamed from: bf () java.lang.Integer
   public abstract Integer method_782();

   // $VF: renamed from: bg () java.lang.String
   public abstract String method_783();

   // $VF: renamed from: bh () boolean
   public abstract boolean method_784();

   // $VF: renamed from: bi () java.lang.String
   public abstract String method_785();

   // $VF: renamed from: N (int) javax.swing.ImageIcon
   public final ImageIcon method_786(int var1) {
      String var2 = this.method_785();
      switch (var1) {
         case 0:
            return var2 == null ? null : Application.method_1324(var2);
         case 1:
            return var2 == null ? null : Application.method_1325(var2, 40, 40);
         case 2:
            return var2 == null ? null : Application.method_1325(var2, 80, 80);
         case 3:
            return var2 == null ? null : Application.method_1325(var2, 20, 20);
         default:
            return null;
      }
   }

   // $VF: renamed from: c (int, int) javax.swing.ImageIcon
   public final ImageIcon method_787(int var1, int var2) {
      String var3 = this.method_785();
      return var3 == null ? null : Application.method_1325(var3, var1, var2);
   }

   // $VF: renamed from: bj () int
   public abstract int method_788();

   public abstract String getDescription();

   // $VF: renamed from: bk () java.util.List
   public abstract List method_789();

   @Override
   public String toString() {
      return this.field_477;
   }

   // $VF: renamed from: a (org.w3c.dom.Element) java.lang.String
   static String method_790(Element var0) {
      if (var0 == null) {
         throw new IllegalArgumentException();
      } else {
         NodeList var1 = var0.getChildNodes();
         StringBuffer var2 = new StringBuffer();
         boolean var3 = false;

         for (int var5 = 0; var5 < var1.getLength(); var5++) {
            Node var4 = var1.item(var5);
            if (var4.getNodeType() == 3) {
               var2.append(var4.getNodeValue());
               var3 = true;
            }
         }

         return !var3 ? null : var2.toString();
      }
   }

   // $VF: renamed from: O (int) java.util.List
   private static List method_791(int var0) {
      ArrayList var1 = new ArrayList();
      boolean var2 = (var0 & 16384) == 0;
      if ((var0 & 4) == 4) {
         var1.add(class_295.field_914);
         var1.add(class_295.field_928);
         var1.add(class_295.field_931);
         if (var2) {
            var1.add(class_295.field_932);
         }
      }

      if ((var0 & 64) == 64) {
         var1.add(class_295.field_926);
         var1.add(class_295.field_928);
         if (var2) {
            var1.add(class_295.field_927);
         }
      }

      if ((var0 & 256) == 256) {
         var1.add(class_295.field_930);
         var1.add(class_295.field_928);
         var1.add(class_295.field_931);
         if (var2) {
            var1.add(class_295.field_932);
         }
      }

      if ((var0 & 2) == 2) {
         var1.add(class_295.field_915);
         if (var2) {
            var1.add(class_295.field_916);
         }
      }

      if ((var0 & 1) == 1) {
         var1.add(class_295.field_917);
         if (var2) {
            var1.add(class_295.field_918);
         }
      }

      if ((var0 & 8) == 8) {
         var1.add(class_295.field_920);
         if (var2) {
            var1.add(class_295.field_921);
         }
      }

      if ((var0 & 16) == 16) {
         var1.add(class_295.field_922);
         var1.add(class_295.field_929);
         if (var2) {
            var1.add(class_295.field_923);
         }
      }

      if ((var0 & 32) == 32) {
         var1.add(class_295.field_924);
         var1.add(class_295.field_929);
         if (var2) {
            var1.add(class_295.field_925);
         }
      }

      if ((var0 & 128) == 128) {
         var1.add(class_295.field_933);
         var1.add(class_295.field_929);
         if (var2) {
            var1.add(class_295.field_934);
         }
      }

      boolean var3 = (var0 & 32768) != 0;
      if ((var0 & 1024) == 1024) {
         if (var3) {
            var1.add(class_295.field_895);
            var1.add(class_295.field_899);
            var1.add(class_295.field_900);
            var1.add(class_295.field_902);
         } else {
            var1.add(class_295.field_895);
            var1.add(class_295.field_896);
            var1.add(class_295.field_897);
            var1.add(class_295.field_898);
            var1.add(class_295.field_899);
            var1.add(class_295.field_900);
            var1.add(class_295.field_901);
            var1.add(class_295.field_902);
         }
      }

      if ((var0 & 512) == 512) {
         if (var3) {
            var1.add(class_295.field_903);
            var1.add(class_295.field_904);
         } else {
            var1.add(class_295.field_903);
            var1.add(class_295.field_904);
            var1.add(class_295.field_905);
            var1.add(class_295.field_906);
            var1.add(class_295.field_909);
            var1.add(class_295.field_911);
            if (var2) {
               var1.add(class_295.field_908);
            }

            if ((var0 & 8192) == 0) {
               var1.add(class_295.field_913);
            }
         }
      }

      if ((var0 & 2048) == 2048) {
         var1.add(class_295.field_912);
      }

      return var1;
   }

   // $VF: renamed from: b (int, java.lang.String) java.util.List
   public static List method_792(int var0, String var1) {
      String var2 = var1.toUpperCase();
      return field_480.stream().filter(ey::a).collect(Collectors.toList());
   }

   // $VF: renamed from: bl () java.util.List
   public static List method_793() {
      return field_480.stream().filter(ey::b).collect(Collectors.toList());
   }

   // $VF: renamed from: bm () java.util.List
   public static List method_794() {
      return field_480.stream().filter(ey::c).collect(Collectors.toList());
   }

   // $VF: renamed from: d (java.lang.Object) nomanssave.ey
   public static class_152 method_795(Object var0) {
      String var1 = var0 instanceof class_95 ? ((class_95)var0).method_551() : var0.toString();
      return (class_152)field_480.stream().filter(ey::a).findFirst().orElse(null);
   }

   // $VF: renamed from: p (java.lang.String) nomanssave.eA
   static class_162 method_796(String var0) {
      return (class_162)field_479.stream().filter(ey::a).findFirst().orElse(null);
   }
}
