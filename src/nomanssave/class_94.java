package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Predicate;

// $VF: renamed from: nomanssave.fh
public class class_94 {
   // $VF: renamed from: kU int
   public static final int field_282 = 0;
   // $VF: renamed from: kV int
   public static final int field_283 = 1;
   // $VF: renamed from: kW int
   public static final int field_284 = 2;
   // $VF: renamed from: kX int
   public static final int field_285 = 3;
   // $VF: renamed from: kY int
   public static final int field_286 = 4;
   // $VF: renamed from: kZ java.util.function.Predicate
   static final Predicate field_287 = fh::a;
   // $VF: renamed from: la java.util.function.Predicate
   static final Predicate field_288 = fh::b;
   // $VF: renamed from: lb java.util.function.Predicate
   static final Predicate field_289 = fh::c;
   // $VF: renamed from: lc java.util.function.Predicate
   static final Predicate field_290 = fh::d;
   // $VF: renamed from: ld java.util.function.Predicate
   static final Predicate field_291 = fh::e;
   // $VF: renamed from: gc java.lang.String
   static final String field_292 = "0123456789ABCDEFabcdef";

   // $VF: renamed from: a (java.lang.Class) boolean
   static boolean method_519(Class var0) {
      if (var0 == null) {
         return true;
      } else if (Boolean.class.isAssignableFrom(var0)) {
         return true;
      } else if (BigDecimal.class.isAssignableFrom(var0)) {
         return true;
      } else if (Number.class.isAssignableFrom(var0)) {
         return true;
      } else if (String.class.isAssignableFrom(var0)) {
         return true;
      } else if (eY.class.isAssignableFrom(var0)) {
         return !fk.class.isAssignableFrom(var0);
      } else {
         return eV.class.isAssignableFrom(var0) ? true : fg.class.isAssignableFrom(var0);
      }
   }

   // $VF: renamed from: b (java.lang.Object, boolean) java.lang.String
   public static String method_520(Object var0, boolean var1) {
      return method_521(var0, var1 ? 7 : 0, null);
   }

   // $VF: renamed from: a (java.lang.Object, int, java.util.function.Predicate) java.lang.String
   public static String method_521(Object var0, int var1, Predicate var2) {
      String var3 = null;
      if ((var1 & 3) != 0) {
         switch (var1 & 3) {
            case 1:
               var3 = "\n";
               break;
            case 2:
               var3 = "\r\n";
               break;
            default:
               var3 = System.lineSeparator();
         }
      }

      boolean var4 = (var1 & 4) != 0;
      return method_523(var0, var3, var4, var2);
   }

   // $VF: renamed from: a (java.lang.Object, java.lang.String, boolean) java.lang.String
   static String method_522(Object var0, String var1, boolean var2) {
      return method_523(var0, var1, var2, null);
   }

   // $VF: renamed from: a (java.lang.Object, java.lang.String, boolean, java.util.function.Predicate) java.lang.String
   private static String method_523(Object var0, String var1, boolean var2, Predicate var3) {
      if (var0 == null) {
         return "null";
      } else if (var0 instanceof Boolean) {
         return var0.toString();
      } else if (var0 instanceof BigDecimal) {
         return ((BigDecimal)var0).toEngineeringString();
      } else if (var0 instanceof Number) {
         return var0.toString();
      } else if (var0 instanceof String) {
         return method_532((String)var0, var3);
      } else if (var0 instanceof class_137) {
         return method_527((class_137)var0, var1, var2, var3);
      } else if (var0 instanceof class_142) {
         return method_525((class_142)var0, var1, var2, var3);
      } else if (var0 instanceof class_95) {
         return method_529((class_95)var0);
      } else {
         throw new RuntimeException("unsupported data type");
      }
   }

   // $VF: renamed from: a (nomanssave.eV, java.lang.String, boolean) java.lang.String
   static String method_524(class_142 var0, String var1, boolean var2) {
      return method_525(var0, var1, var2, null);
   }

   // $VF: renamed from: a (nomanssave.eV, java.lang.String, boolean, java.util.function.Predicate) java.lang.String
   private static String method_525(class_142 var0, String var1, boolean var2, Predicate var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append('[');

      for (int var5 = 0; var5 < var0.length; var5++) {
         if (var5 > 0) {
            var4.append(',');
         }

         if (var1 != null) {
            var4.append(var1 + "\t");
         }

         var4.append(method_523(var0.values[var5], var1 == null ? null : var1 + "\t", var2, var3));
      }

      if (var0.length > 0) {
         var4.append(var1);
      }

      var4.append(']');
      return var4.toString();
   }

   // $VF: renamed from: a (nomanssave.eY, java.lang.String, boolean) java.lang.String
   static String method_526(class_137 var0, String var1, boolean var2) {
      return method_527(var0, var1, var2, null);
   }

   // $VF: renamed from: a (nomanssave.eY, java.lang.String, boolean, java.util.function.Predicate) java.lang.String
   private static String method_527(class_137 var0, String var1, boolean var2, Predicate var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append('{');

      for (int var5 = 0; var5 < var0.length; var5++) {
         if (var5 > 0) {
            var4.append(',');
         }

         if (var1 != null) {
            var4.append(var1 + "\t");
         }

         var4.append(method_532(var0.names[var5], var3));
         var4.append(':');
         if (var2) {
            var4.append(' ');
         }

         var4.append(method_523(var0.values[var5], var1 == null ? null : var1 + "\t", var2, var3));
      }

      if (var0.length > 0) {
         var4.append(var1);
      }

      var4.append('}');
      return var4.toString();
   }

   // $VF: renamed from: a (nomanssave.fg) java.lang.String
   private static String method_528(class_95 var0) {
      StringBuilder var1 = new StringBuilder();

      byte[] var5;
      for (byte var2 : var5 = var0.toByteArray()) {
         int var6 = var2 & 255;
         if (var6 == 13) {
            var1.append("\\r");
         } else if (var6 == 10) {
            var1.append("\\n");
         } else if (var6 == 9) {
            var1.append("\\t");
         } else if (var6 == 12) {
            var1.append("\\f");
         } else if (var6 == 8) {
            var1.append("\\b");
         } else if (var6 == 11) {
            var1.append("\\v");
         } else if (var6 == 0) {
            var1.append("\\0");
         } else if (var6 == 34) {
            var1.append("\\\"");
         } else if (var6 == 92) {
            var1.append("\\\\");
         } else if (var6 >= 32 && var6 < 128) {
            var1.append(Character.toString((char)var6));
         } else {
            var1.append("\\x");
            var1.append("0123456789ABCDEFabcdef".charAt(var6 >> 4 & 15));
            var1.append("0123456789ABCDEFabcdef".charAt(var6 & 15));
         }
      }

      return var1.toString();
   }

   // $VF: renamed from: b (nomanssave.fg) java.lang.String
   private static String method_529(class_95 var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append('"');
      var1.append(method_528(var0));
      var1.append('"');
      return var1.toString();
   }

   // $VF: renamed from: a (java.lang.String, java.util.function.Predicate) java.lang.String
   private static String method_530(String var0, Predicate var1) {
      StringBuilder var2 = new StringBuilder();

      char[] var6;
      for (char var3 : var6 = var0.toCharArray()) {
         if (var3 == '\r') {
            var2.append("\\r");
         } else if (var3 == '\n') {
            var2.append("\\n");
         } else if (var3 == '\t') {
            var2.append("\\t");
         } else if (var3 == '\f') {
            var2.append("\\f");
         } else if (var3 == '\b') {
            var2.append("\\b");
         } else if (var3 == '"') {
            var2.append("\\\"");
         } else if (var3 == '\\') {
            var2.append("\\\\");
         } else if (var3 >= ' ' && (var1 == null || var1.test(var3))) {
            var2.append(Character.toString(var3));
         } else {
            var2.append("\\u");
            var2.append("0123456789ABCDEFabcdef".charAt(var3 >> '\f' & 15));
            var2.append("0123456789ABCDEFabcdef".charAt(var3 >> '\b' & 15));
            var2.append("0123456789ABCDEFabcdef".charAt(var3 >> 4 & 15));
            var2.append("0123456789ABCDEFabcdef".charAt(var3 & 15));
         }
      }

      return var2.toString();
   }

   // $VF: renamed from: O (java.lang.String) java.lang.String
   static String method_531(String var0) {
      return method_532(var0, null);
   }

   // $VF: renamed from: b (java.lang.String, java.util.function.Predicate) java.lang.String
   private static String method_532(String var0, Predicate var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append('"');
      var2.append(method_530(var0, var1));
      var2.append('"');
      return var2.toString();
   }

   // $VF: renamed from: P (java.lang.String) java.lang.Object
   public static Object method_533(String var0) {
      class_93 var1 = new class_93(var0);
      Object var2 = method_534(var1, var1.method_516());
      if (var1.method_516() >= 0) {
         throw new class_140("Invalid trailing data", var1.field_280, var1.field_281);
      } else {
         return var2;
      }
   }

   // $VF: renamed from: a (nomanssave.fi, int) java.lang.Object
   private static Object method_534(class_93 var0, int var1) {
      if (var1 < 0) {
         throw new class_140("Short read", var0.field_280, var0.field_281);
      } else if (var1 == 123) {
         return method_536(var0);
      } else if (var1 == 91) {
         return method_538(var0);
      } else if (var1 == 34) {
         return method_541(var0);
      } else if (var1 == 102) {
         if (var0.read() != 97) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 108) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 115) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 101) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else {
            return Boolean.FALSE;
         }
      } else if (var1 == 116) {
         if (var0.read() != 114) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 117) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 101) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else {
            return Boolean.TRUE;
         }
      } else if (var1 == 110) {
         if (var0.read() != 117) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 108) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 108) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else {
            return null;
         }
      } else if (var1 == 100) {
         if (var0.read() != 97) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 116) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 97) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.read() != 40) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else if (var0.method_516() != 34) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         } else {
            class_95 var2 = method_542(var0);
            if (var0.method_516() != 41) {
               throw new class_140("Invalid token", var0.field_280, var0.field_281);
            } else {
               return var2;
            }
         }
      } else if (var1 != 45 && (var1 < 48 || var1 > 57)) {
         throw new class_140("Invalid token", var0.field_280, var0.field_281);
      } else {
         return method_543(var0, var1);
      }
   }

   // $VF: renamed from: Q (java.lang.String) nomanssave.eY
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static class_137 method_535(String var0) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         class_93 var3 = new class_93(var0);

         Throwable var10000;
         label157: {
            try {
               if (var3.method_516() != 123) {
                  throw new class_140("Invalid object string", var3.field_280, var3.field_281);
               }

               class_137 var4 = method_536(var3);
               if (var3.method_516() >= 0) {
                  throw new class_140("Invalid trailing data", var3.field_280, var3.field_281);
               }

               var17 = var4;
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var10001 = false;
               break label157;
            }

            if (var3 != null) {
               var3.close();
            }

            label140:
            try {
               return var17;
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var18 = false;
               break label140;
            }
         }

         var1 = var10000;
         if (var3 != null) {
            var3.close();
         }

         throw var1;
      } catch (Throwable var16) {
         if (var1 == null) {
            var1 = var16;
         } else if (var1 != var16) {
            var1.addSuppressed(var16);
         }

         throw var1;
      }
   }

   // $VF: renamed from: a (nomanssave.fi) nomanssave.eY
   private static class_137 method_536(class_93 var0) {
      class_137 var1 = new class_137();
      int var2 = var0.method_516();
      if (var2 == 34) {
         while (true) {
            String var3 = method_540(var0);
            if (var0.method_516() != 58) {
               throw new class_140("Invalid token", var0.field_280, var0.field_281);
            }

            Object var4 = method_534(var0, var0.method_516());
            var1.method_691(var3, var4);
            var2 = var0.method_516();
            if (var2 == 125) {
               break;
            }

            if (var2 != 44) {
               throw new class_140("Invalid token", var0.field_280, var0.field_281);
            }

            var2 = var0.method_516();
            if (var2 != 34) {
               throw new class_140("Invalid token", var0.field_280, var0.field_281);
            }
         }
      } else if (var2 != 125) {
         throw new class_140("Invalid token", var0.field_280, var0.field_281);
      }

      return var1;
   }

   // $VF: renamed from: R (java.lang.String) nomanssave.eV
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static class_142 method_537(String var0) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         class_93 var3 = new class_93(var0);

         Throwable var10000;
         label157: {
            try {
               if (var3.method_516() != 91) {
                  throw new class_140("Invalid array string", var3.field_280, var3.field_281);
               }

               class_142 var4 = method_538(var3);
               if (var3.method_516() >= 0) {
                  throw new class_140("Invalid trailing data", var3.field_280, var3.field_281);
               }

               var17 = var4;
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var10001 = false;
               break label157;
            }

            if (var3 != null) {
               var3.close();
            }

            label140:
            try {
               return var17;
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var18 = false;
               break label140;
            }
         }

         var1 = var10000;
         if (var3 != null) {
            var3.close();
         }

         throw var1;
      } catch (Throwable var16) {
         if (var1 == null) {
            var1 = var16;
         } else if (var1 != var16) {
            var1.addSuppressed(var16);
         }

         throw var1;
      }
   }

   // $VF: renamed from: b (nomanssave.fi) nomanssave.eV
   private static class_142 method_538(class_93 var0) {
      class_142 var1 = new class_142();
      int var2;
      if ((var2 = var0.method_516()) != 93) {
         while (true) {
            Object var3 = method_534(var0, var2);
            var1.method_727(var3);
            var2 = var0.method_516();
            if (var2 == 93) {
               break;
            }

            if (var2 != 44) {
               throw new class_140("Invalid token", var0.field_280, var0.field_281);
            }

            var2 = var0.method_516();
         }
      }

      return var1;
   }

   // $VF: renamed from: ae (int) int
   static int method_539(int var0) {
      if (var0 < 0) {
         throw new IOException("short read");
      } else {
         var0 = "0123456789ABCDEFabcdef".indexOf((char)var0);
         if (var0 < 0) {
            throw new IOException("invalid hex char");
         } else {
            if (var0 >= 16) {
               var0 -= 6;
            }

            return var0;
         }
      }
   }

   // $VF: renamed from: c (nomanssave.fi) java.lang.String
   private static String method_540(class_93 var0) {
      Object var1 = method_541(var0);
      if (var1 instanceof String) {
         return (String)var1;
      } else {
         throw new class_140("Invalid string", var0.field_280, var0.field_281);
      }
   }

   // $VF: renamed from: d (nomanssave.fi) java.lang.Object
   private static Object method_541(class_93 var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();

         int var3;
         while ((var3 = var0.read()) != 34) {
            if (var3 < 0) {
               throw new class_140("Short read");
            }

            if (var3 == 92) {
               var3 = var0.read();
               if (var3 < 0) {
                  throw new class_140("Short read");
               }

               switch (var3) {
                  case 48:
                     var3 = 0;
                     break;
                  case 98:
                     var3 = 8;
                     break;
                  case 102:
                     var3 = 12;
                     break;
                  case 110:
                     var3 = 10;
                     break;
                  case 114:
                     var3 = 13;
                     break;
                  case 116:
                     var3 = 9;
                     break;
                  case 117:
                     var3 = method_539(var0.read()) << 12 | method_539(var0.read()) << 8 | method_539(var0.read()) << 4 | method_539(var0.read());
                     if (var3 <= 255) {
                        if (var1 != null) {
                           var1.append((char)var3);
                        }

                        if (var2 != null) {
                           var2.write(var3);
                        }
                     } else {
                        if (var1 == null) {
                           throw new class_140("Mixed encodings detected in string");
                        }

                        var2 = null;
                        var1.append((char)var3);
                     }
                     continue;
                  case 118:
                     var3 = 11;
                     break;
                  case 120:
                     var3 = method_539(var0.read()) << 4 | method_539(var0.read());
                     if (var2 == null) {
                        throw new class_140("Mixed encodings detected in stringx");
                     }

                     var2.write(var3);
                     var1 = null;
                     continue;
               }
            }

            if (var1 != null) {
               var1.append((char)var3);
            }

            if (var2 != null) {
               var2.write(var3);
            }
         }

         return var1 != null ? var1.toString() : new class_95(var2.toByteArray());
      } catch (class_140 var4) {
         throw var4;
      } catch (IOException var5) {
         throw new class_140("Invalid string", var5, var0.field_280, var0.field_281);
      }
   }

   // $VF: renamed from: e (nomanssave.fi) nomanssave.fg
   private static class_95 method_542(class_93 var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      if (var0.read() != 48) {
         throw new class_140("Invalid hex data", var0.field_280, var0.field_281);
      } else if (var0.read() != 120) {
         throw new class_140("Invalid hex data", var0.field_280, var0.field_281);
      } else {
         int var2;
         while ((var2 = var0.read()) != 34) {
            if (var2 < 0) {
               throw new class_140("Short read", var0.field_280, var0.field_281);
            }

            int var3;
            if ((var3 = var0.read()) < 0) {
               throw new class_140("Short read", var0.field_280, var0.field_281);
            }

            var2 = "0123456789abcdefABCDEF".indexOf((char)var2);
            if (var2 < 0) {
               throw new class_140("Invalid hex data", var0.field_280, var0.field_281);
            }

            if (var2 >= 16) {
               var2 -= 6;
            }

            var3 = "0123456789abcdefABCDEF".indexOf((char)var3);
            if (var3 < 0) {
               throw new class_140("Invalid hex data", var0.field_280, var0.field_281);
            }

            if (var3 >= 16) {
               var3 -= 6;
            }

            var1.write(var2 << 4 | var3);
         }

         return new class_95(var1.toByteArray());
      }
   }

   // $VF: renamed from: b (nomanssave.fi, int) java.lang.Number
   private static Number method_543(class_93 var0, int var1) {
      boolean var3 = false;
      if (var1 == 45) {
         var1 = class_93.method_518(var0, field_287);
         if (var1 < 0) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         }

         var3 = true;
      }

      BigDecimal var2 = new BigDecimal(var1 - 48);
      if (var1 != 48) {
         while ((var1 = class_93.method_518(var0, field_287)) >= 0) {
            var2 = var2.multiply(BigDecimal.TEN).add(new BigDecimal(var1 - 48));
         }
      }

      boolean var4 = true;
      if (class_93.method_518(var0, field_288) >= 0) {
         var4 = false;
         var1 = class_93.method_518(var0, field_287);
         if (var1 < 0) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         }

         int var5 = 0;

         do {
            var2 = var2.add(new BigDecimal(var1 - 48).scaleByPowerOfTen(--var5));
         } while ((var1 = class_93.method_518(var0, field_287)) >= 0);
      }

      if (class_93.method_518(var0, field_289) >= 0) {
         var4 = false;
         var1 = class_93.method_518(var0, field_290);
         boolean var12 = false;
         if (var1 == 43 || var1 == 45) {
            var12 = var1 == 45;
            var1 = class_93.method_518(var0, field_287);
         }

         if (var1 < 0) {
            throw new class_140("Invalid token", var0.field_280, var0.field_281);
         }

         int var6 = 0;

         do {
            var6 *= 10;
            var6 += var1 - 48;
         } while ((var1 = class_93.method_518(var0, field_287)) >= 0);

         if (var12) {
            var6 = -var6;
         }

         var2 = var2.scaleByPowerOfTen(var6);
      }

      if (var3) {
         var2 = var2.negate();
      }

      if (var4) {
         try {
            return var2.intValueExact();
         } catch (ArithmeticException var8) {
            try {
               return var2.longValueExact();
            } catch (ArithmeticException var7) {
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: i (java.lang.Object) void
   static void method_544(Object var0) {
      if (var0 instanceof class_137) {
         ((class_137)var0).field_447 = null;
      }

      if (var0 instanceof class_142) {
         ((class_142)var0).field_457 = null;
      }
   }

   // $VF: renamed from: a (java.lang.Object, java.lang.Object) void
   static void method_545(Object var0, Object var1) {
      if (var0 instanceof class_137) {
         ((class_137)var0).field_447 = var1;
      }

      if (var0 instanceof class_142) {
         ((class_142)var0).field_457 = var1;
      }
   }
}
