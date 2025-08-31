package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

// $VF: renamed from: nomanssave.fj
public class class_92 implements Closeable {
   // $VF: renamed from: kP int
   public static final int field_274 = 2;
   // $VF: renamed from: kQ int
   public static final int field_275 = 8;
   // $VF: renamed from: le byte[]
   private static final byte[] field_276 = "null".getBytes();
   // $VF: renamed from: lf byte[]
   private static final byte[] field_277 = "true".getBytes();
   // $VF: renamed from: lg byte[]
   private static final byte[] field_278 = "false".getBytes();
   // $VF: renamed from: lh java.io.OutputStream
   private final OutputStream field_279;
   private final int flags;

   // $VF: renamed from: j (java.lang.Object) byte[]
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static byte[] method_505(Object var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(var1, 0);

         try {
            var4.method_508(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   // $VF: renamed from: g (nomanssave.eY) byte[]
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static byte[] method_506(class_137 var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(var1, 0);

         try {
            var4.method_511(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   // $VF: renamed from: b (nomanssave.eV) byte[]
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static byte[] method_507(class_142 var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      Throwable var2 = null;
      Object var3 = null;

      try {
         class_92 var4 = new class_92(var1, 0);

         try {
            var4.method_513(var0);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var10) {
         if (var2 == null) {
            var2 = var10;
         } else if (var2 != var10) {
            var2.addSuppressed(var10);
         }

         throw var2;
      }

      return var1.toByteArray();
   }

   public class_92(OutputStream var1) {
      this(var1, 0);
   }

   public class_92(OutputStream var1, int var2) {
      this.field_279 = var1;
      this.flags = var2;
   }

   // $VF: renamed from: k (java.lang.Object) void
   public void method_508(Object var1) {
      if (var1 == null) {
         this.field_279.write(field_276);
      } else if (var1.equals(Boolean.TRUE)) {
         this.field_279.write(field_277);
      } else if (var1.equals(Boolean.FALSE)) {
         this.field_279.write(field_278);
      } else if (var1 instanceof String) {
         this.writeString((String)var1);
      } else if (var1 instanceof class_95) {
         this.method_510((class_95)var1);
      } else if (var1 instanceof class_138) {
         this.method_512((class_137)var1, ((class_138)var1).field_451);
      } else if (var1 instanceof class_137) {
         this.method_512((class_137)var1, null);
      } else if (var1 instanceof class_142) {
         this.method_514((class_142)var1, null);
      } else {
         if (!(var1 instanceof Number)) {
            throw new IOException("Cannot write value");
         }

         this.method_515((Number)var1);
      }
   }

   // $VF: renamed from: a (java.lang.Object, nomanssave.eC) void
   private void method_509(Object var1, class_161 var2) {
      if (var1 == null) {
         this.field_279.write(field_276);
      } else if (var1.equals(Boolean.TRUE)) {
         this.field_279.write(field_277);
      } else if (var1.equals(Boolean.FALSE)) {
         this.field_279.write(field_278);
      } else if (var1 instanceof String) {
         this.writeString((String)var1);
      } else if (var1 instanceof class_95) {
         this.method_510((class_95)var1);
      } else if (var1 instanceof class_137) {
         this.method_512((class_137)var1, var2);
      } else if (var1 instanceof class_142) {
         this.method_514((class_142)var1, var2);
      } else {
         if (!(var1 instanceof Number)) {
            throw new IOException("Cannot write value");
         }

         this.method_515((Number)var1);
      }
   }

   private void writeString(String var1) {
      this.field_279.write(class_94.method_531(var1).getBytes(StandardCharsets.UTF_8));
   }

   // $VF: renamed from: c (nomanssave.fg) void
   private void method_510(class_95 var1) {
      this.field_279.write(34);

      byte[] var5;
      for (byte var2 : var5 = var1.toByteArray()) {
         int var6 = var2 & 255;
         if (var6 == 13) {
            this.field_279.write("\\r".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 10) {
            this.field_279.write("\\n".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 9) {
            this.field_279.write("\\t".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 12) {
            this.field_279.write("\\f".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 8) {
            this.field_279.write("\\b".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 34) {
            this.field_279.write("\\\"".getBytes(StandardCharsets.UTF_8));
         } else if (var6 == 92) {
            this.field_279.write("\\\\".getBytes(StandardCharsets.UTF_8));
         } else if (var6 >= 32) {
            this.field_279.write(var6);
         } else {
            StringBuffer var7 = new StringBuffer();
            var7.append("\\u00");
            var7.append("0123456789ABCDEFabcdef".charAt(var6 >> 4 & 15));
            var7.append("0123456789ABCDEFabcdef".charAt(var6 & 15));
            this.field_279.write(var7.toString().getBytes(StandardCharsets.UTF_8));
         }
      }

      this.field_279.write(34);
   }

   // $VF: renamed from: h (nomanssave.eY) void
   public void method_511(class_137 var1) {
      this.method_512(var1, var1 instanceof class_138 ? ((class_138)var1).field_451 : null);
   }

   // $VF: renamed from: a (nomanssave.eY, nomanssave.eC) void
   private void method_512(class_137 var1, class_161 var2) {
      this.field_279.write(123);
      if (var1.length > 0) {
         for (int var3 = 0; var3 < var1.length; var3++) {
            if (var3 > 0) {
               this.field_279.write(44);
            }

            this.writeString(var2 == null ? var1.names[var3] : var2.method_818(var1.names[var3]));
            this.field_279.write(58);
            this.method_509(var1.values[var3], var2);
         }
      }

      this.field_279.write(125);
   }

   // $VF: renamed from: c (nomanssave.eV) void
   public void method_513(class_142 var1) {
      this.method_514(var1, null);
   }

   // $VF: renamed from: a (nomanssave.eV, nomanssave.eC) void
   private void method_514(class_142 var1, class_161 var2) {
      this.field_279.write(91);
      if (var1.length > 0) {
         for (int var3 = 0; var3 < var1.length; var3++) {
            if (var3 > 0) {
               this.field_279.write(44);
            }

            this.method_509(var1.values[var3], var2);
         }
      }

      this.field_279.write(93);
   }

   // $VF: renamed from: a (java.lang.Number) void
   private void method_515(Number var1) {
      if (var1 instanceof BigDecimal) {
         this.field_279.write(((BigDecimal)var1).toString().replace('E', 'e').getBytes(StandardCharsets.UTF_8));
      } else {
         this.field_279.write(var1.toString().getBytes(StandardCharsets.UTF_8));
      }
   }

   @Override
   public void close() {
      try {
         if ((this.flags & 2) != 0) {
            this.field_279.write(0);
         }
      } finally {
         if ((this.flags & 8) == 0) {
            this.field_279.close();
         }
      }
   }
}
