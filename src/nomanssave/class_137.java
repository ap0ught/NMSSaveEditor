package nomanssave;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: renamed from: nomanssave.eY
public class class_137 {
   // $VF: renamed from: kB int
   private static final int field_444 = 10;
   // $VF: renamed from: kC int
   private static final int field_445 = 10;
   // $VF: renamed from: kH java.util.regex.Pattern
   private static final Pattern field_446 = Pattern.compile("[^\"\\.\\[\\]]+");
   int length = 0;
   String[] names = new String[10];
   Object[] values = new Object[10];
   // $VF: renamed from: kD java.lang.Object
   Object field_447;
   // $VF: renamed from: kI nomanssave.fe
   class_4 field_448;
   // $VF: renamed from: kJ java.util.Map
   Map field_449 = new HashMap();
   // $VF: renamed from: kK java.util.regex.Pattern
   private static final Pattern field_450 = Pattern.compile("([^\\.\\[\\]]+)|(?:\\.([^\\.\\[\\]]+))|(?:\\[(\\d+)\\])");

   // $VF: renamed from: E (java.lang.String) nomanssave.eY
   public static class_137 method_689(String var0) {
      return class_94.method_535(var0);
   }

   // $VF: renamed from: b (java.lang.String, java.util.function.Function) void
   public void method_690(String var1, Function var2) {
      this.field_449.put(var1, var2);
   }

   // $VF: renamed from: a (java.lang.String, java.lang.Object) void
   void method_691(String var1, Object var2) {
      for (int var3 = 0; var3 < this.length; var3++) {
         if (this.names[var3].equals(var1)) {
            throw new RuntimeException("duplicate key: " + var1);
         }
      }

      if (this.values.length == this.length) {
         String[] var5 = new String[this.length + 10];
         Object[] var4 = new Object[this.length + 10];
         System.arraycopy(this.names, 0, var5, 0, this.length);
         System.arraycopy(this.values, 0, var4, 0, this.length);
         this.names = var5;
         this.values = var4;
      }

      this.names[this.length] = var1;
      this.values[this.length] = var2;
      class_94.method_545(var2, this);
      this.length++;
   }

   // $VF: renamed from: bz () java.lang.String
   public String method_692() {
      return class_94.method_526(this, System.lineSeparator(), true);
   }

   @Override
   public String toString() {
      return class_94.method_526(this, null, false);
   }

   // $VF: renamed from: bE () nomanssave.eY
   public class_137 method_693() {
      class_137 var1 = new class_137();
      var1.names = new String[this.values.length];
      var1.values = new Object[this.values.length];
      System.arraycopy(this.names, 0, var1.names, 0, this.length);

      for (int var2 = 0; var2 < this.length; var2++) {
         if (this.values[var2] instanceof class_137) {
            var1.values[var2] = ((class_137)this.values[var2]).method_693();
            class_94.method_545(var1.values[var2], var1);
         } else if (this.values[var2] instanceof class_142) {
            var1.values[var2] = ((class_142)this.values[var2]).method_730();
            class_94.method_545(var1.values[var2], var1);
         } else {
            var1.values[var2] = this.values[var2];
         }
      }

      var1.length = this.length;
      return var1;
   }

   public int size() {
      return this.length;
   }

   public List names() {
      String[] var1 = new String[this.length];
      System.arraycopy(this.names, 0, var1, 0, this.length);
      return Arrays.asList(var1);
   }

   public boolean contains(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!field_446.matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else {
         for (int var2 = 0; var2 < this.length; var2++) {
            if (var1.equals(this.names[var2])) {
               return true;
            }
         }

         return false;
      }
   }

   // $VF: renamed from: get (java.lang.String) java.lang.Object
   public Object method_694(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!field_446.matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else {
         for (int var2 = 0; var2 < this.length; var2++) {
            if (var1.equals(this.names[var2])) {
               return this.values[var2];
            }
         }

         return null;
      }
   }

   // $VF: renamed from: put (java.lang.String, java.lang.Object) java.lang.Object
   public Object method_695(String var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!field_446.matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else if (var2 != null && !class_94.method_519(var2.getClass())) {
         throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
      } else {
         for (int var3 = 0; var3 < this.length; var3++) {
            if (var1.equals(this.names[var3])) {
               Object var4 = this.values[var3];
               class_94.method_544(var4);
               this.values[var3] = var2;
               class_94.method_545(var2, this);
               this.firePropertyChange(var1, var4, var2);
               return var4;
            }
         }

         if (this.values.length == this.length) {
            String[] var5 = new String[this.length + 10];
            Object[] var6 = new Object[this.length + 10];
            System.arraycopy(this.names, 0, var5, 0, this.length);
            System.arraycopy(this.values, 0, var6, 0, this.length);
            this.names = var5;
            this.values = var6;
         }

         this.names[this.length] = var1;
         this.values[this.length] = var2;
         class_94.method_545(var2, this);
         this.length++;
         this.firePropertyChange(var1, null, var2);
         return null;
      }
   }

   // $VF: renamed from: F (java.lang.String) java.lang.Object
   public Object method_696(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (!field_446.matcher(var1).matches()) {
         throw new RuntimeException("Invalid name: " + var1);
      } else {
         for (int var2 = 0; var2 < this.length; var2++) {
            if (var1.equals(this.names[var2])) {
               Object var3 = this.values[var2];
               class_94.method_544(var3);
               var2++;

               while (var2 < this.length) {
                  this.names[var2 - 1] = this.names[var2];
                  this.values[var2 - 1] = this.values[var2];
                  var2++;
               }

               this.length--;
               this.firePropertyChange(var1, var3, null);
               return var3;
            }
         }

         return null;
      }
   }

   // $VF: renamed from: c (nomanssave.eY) void
   public void method_697(class_137 var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         for (int var2 = 0; var2 < var1.length; var2++) {
            boolean var3 = false;

            for (int var4 = 0; var4 < this.length; var4++) {
               if (var1.names[var2].equals(this.names[var4])) {
                  Object var5 = this.values[var4];
                  class_94.method_544(var5);
                  if (var5 instanceof class_137 && var1.values[var2] instanceof class_137) {
                     ((class_137)var5).method_697((class_137)var1.values[var2]);
                     this.values[var4] = var5;
                  } else {
                     this.values[var4] = var1.values[var2];
                  }

                  class_94.method_545(this.values[var4], this);
                  var3 = true;
               }
            }

            if (!var3) {
               if (this.values.length == this.length) {
                  String[] var6 = new String[this.length + 10];
                  Object[] var7 = new Object[this.length + 10];
                  System.arraycopy(this.names, 0, var6, 0, this.length);
                  System.arraycopy(this.values, 0, var7, 0, this.length);
                  this.names = var6;
                  this.values = var7;
               }

               this.names[this.length] = var1.names[var2];
               this.values[this.length] = var1.values[var2];
               class_94.method_545(this.values[this.length], this);
               this.length++;
            }
         }

         this.firePropertyChange("", null, this);
      }
   }

   int indexOf(String var1) {
      for (int var2 = 0; var2 < this.length; var2++) {
         if (var1.equals(this.names[var2])) {
            return var2;
         }
      }

      return -1;
   }

   // $VF: renamed from: set (int, java.lang.Object) java.lang.Object
   Object method_698(int var1, Object var2) {
      Object var3 = this.values[var1];
      class_94.method_544(var3);
      this.values[var1] = var2;
      class_94.method_545(var2, this);
      this.firePropertyChange(this.names[var1], var3, null);
      return var3;
   }

   Object remove(int var1) {
      String var2 = this.names[var1];
      Object var3 = this.values[var1];
      class_94.method_544(var3);

      for (int var4 = var1 + 1; var4 < this.length; var4++) {
         this.names[var4 - 1] = this.names[var4];
         this.values[var4 - 1] = this.values[var4];
      }

      this.length--;
      this.firePropertyChange(var2, var3, null);
      return var3;
   }

   public void clear() {
      for (int var1 = 0; var1 < this.length; var1++) {
         class_94.method_544(this.values[var1]);
         this.firePropertyChange(this.names[var1], this.values[var1], null);
      }

      this.length = 0;
   }

   // $VF: renamed from: a (nomanssave.fe) void
   public void method_699(class_4 var1) {
      this.field_448 = var1;
   }

   // $VF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object) void
   void method_700(Object var1, String var2, Object var3, Object var4) {
      for (int var5 = 0; var5 < this.length; var5++) {
         if (var1 == this.values[var5]) {
            this.firePropertyChange(this.names[var5] + var2, var3, var4);
            return;
         }
      }
   }

   private void firePropertyChange(String var1, Object var2, Object var3) {
      if (this.field_448 != null) {
         EventQueue.invokeLater(this::c);
      }

      String var4 = var1.length() == 0 ? "" : "." + var1;
      if (this.field_447 instanceof class_137) {
         ((class_137)this.field_447).method_700(this, var4, var2, var3);
      }

      if (this.field_447 instanceof class_142) {
         ((class_142)this.field_447).method_735(this, var4, var2, var3);
      }
   }

   // $VF: renamed from: G (java.lang.String) nomanssave.fc
   private class_134 method_701(String var1) {
      for (Entry var2 : this.field_449.entrySet()) {
         if (var1.equals(var2.getKey())) {
            var1 = (String)((Function)var2.getValue()).apply(this);
            break;
         }

         if (var1.startsWith((String)var2.getKey() + ".") || var1.startsWith((String)var2.getKey() + "[")) {
            var1 = (String)((Function)var2.getValue()).apply(this) + var1.substring(((String)var2.getKey()).length());
            break;
         }
      }

      Matcher var5 = field_450.matcher(var1);
      if (var5.find() && var5.start() == 0) {
         int var6 = var5.end();
         Object var4;
         if (var5.group(1) != null) {
            var4 = new class_135(this, var5.group(1), null);
         } else {
            if (var5.group(3) == null) {
               throw new RuntimeException("Invalid path");
            }

            var4 = new class_136(this, Integer.parseInt(var5.group(3)), null);
         }

         while (var5.find() && var5.start() == var6) {
            var6 = var5.end();
            if (var5.group(2) != null) {
               var4 = new class_135(this, var5.group(2), (class_134)var4);
            } else {
               if (var5.group(3) == null) {
                  throw new RuntimeException("Invalid path");
               }

               var4 = new class_136(this, Integer.parseInt(var5.group(3)), (class_134)var4);
            }
         }

         if (var5.hitEnd()) {
            return (class_134)var4;
         }
      }

      throw new RuntimeException("Invalid path");
   }

   public Object getValue(String var1) {
      try {
         return this.method_701(var1).getValue();
      } catch (class_139 var3) {
         class_37.debug("Path not found: " + var1);
         return null;
      } catch (RuntimeException var4) {
         class_37.warn("Error getting value: " + var1 + ", " + var4.getMessage());
         return null;
      }
   }

   // $VF: renamed from: H (java.lang.String) nomanssave.eY
   public class_137 method_702(String var1) {
      return (class_137)this.getValue(var1);
   }

   // $VF: renamed from: d (java.lang.String) nomanssave.eV
   public class_142 method_703(String var1) {
      return (class_142)this.getValue(var1);
   }

   public String getValueAsString(String var1) {
      Object var2 = this.getValue(var1);
      return var2 instanceof class_95 ? var2.toString() : (String)var2;
   }

   // $VF: renamed from: I (java.lang.String) java.lang.String
   public String method_704(String var1) {
      Object var2 = this.getValue(var1);
      if (var2 == null) {
         return "";
      } else if (!(var2 instanceof Number)) {
         return (String)this.getValue(var1);
      } else {
         String var3 = Long.toHexString(((Number)var2).longValue());

         while (var3.length() < 16) {
            var3 = "0" + var3;
         }

         return "0x" + var3.toUpperCase();
      }
   }

   // $VF: renamed from: J (java.lang.String) int
   public int method_705(String var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0 : ((Number)var2).intValue();
   }

   // $VF: renamed from: c (java.lang.String, int) int
   public int method_706(String var1, int var2) {
      Object var3 = this.getValue(var1);
      return var3 == null ? var2 : ((Number)var3).intValue();
   }

   // $VF: renamed from: K (java.lang.String) long
   public long method_707(String var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0L : ((Number)var2).longValue();
   }

   // $VF: renamed from: a (java.lang.String, long) long
   public long method_708(String var1, long var2) {
      Object var4 = this.getValue(var1);
      return var4 == null ? var2 : ((Number)var4).longValue();
   }

   // $VF: renamed from: L (java.lang.String) double
   public double method_709(String var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0.0 : ((Number)var2).doubleValue();
   }

   // $VF: renamed from: c (java.lang.String, double) double
   public double method_710(String var1, double var2) {
      Object var4 = this.getValue(var1);
      return var4 == null ? var2 : ((Number)var4).doubleValue();
   }

   // $VF: renamed from: M (java.lang.String) boolean
   public boolean method_711(String var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? false : (Boolean)var2;
   }

   // $VF: renamed from: a (java.lang.String, boolean) boolean
   public boolean method_712(String var1, boolean var2) {
      Object var3 = this.getValue(var1);
      return var3 == null ? var2 : (Boolean)var3;
   }

   // $VF: renamed from: b (java.lang.String, java.lang.Object) java.lang.Object
   public Object method_713(String var1, Object var2) {
      return this.method_701(var1).method_686(var2, false);
   }

   // $VF: renamed from: c (java.lang.String, java.lang.Object) java.lang.Object
   public Object method_714(String var1, Object var2) {
      return this.method_701(var1).method_686(var2, true);
   }

   // $VF: renamed from: N (java.lang.String) java.lang.Object
   public Object method_715(String var1) {
      try {
         return this.method_701(var1).method_687();
      } catch (class_139 var3) {
         class_37.debug("Path not found: " + var1);
         return null;
      } catch (RuntimeException var4) {
         class_37.warn("Error getting value: " + var1 + ", " + var4.getMessage());
         return null;
      }
   }

   // $VF: renamed from: b (java.lang.String, nomanssave.eY) nomanssave.eY
   public class_137 method_716(String var1, class_137 var2) {
      return this.method_701(var1).method_688(var2);
   }

   // $VF: renamed from: d (nomanssave.eY) void
   public void method_717(class_137 var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (var1.field_447 != null) {
         throw new RuntimeException("Object must not have a parent");
      } else {
         this.clear();
         this.length = var1.length;
         this.names = new String[var1.length];
         this.values = new Object[var1.length];
         System.arraycopy(var1.names, 0, this.names, 0, this.length);

         for (int var2 = 0; var2 < this.length; var2++) {
            if (var1.values[var2] instanceof class_137) {
               this.values[var2] = ((class_137)var1.values[var2]).method_693();
               class_94.method_545(this.values[var2], this);
            } else if (var1.values[var2] instanceof class_142) {
               this.values[var2] = ((class_142)var1.values[var2]).method_730();
               class_94.method_545(this.values[var2], this);
            } else {
               this.values[var2] = var1.values[var2];
            }

            this.firePropertyChange(this.names[var2], null, this.values[var2]);
         }
      }
   }

   // $VF: renamed from: c (java.io.File) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_718(File var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         FileOutputStream var4 = new FileOutputStream(var1);

         try {
            String var5 = class_94.method_520(this, true);
            var4.write(var5.getBytes(StandardCharsets.UTF_8));
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var11) {
         if (var2 == null) {
            var2 = var11;
         } else if (var2 != var11) {
            var2.addSuppressed(var11);
         }

         throw var2;
      }
   }

   // $VF: renamed from: d (java.io.File) void
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_719(File var1) {
      Throwable var2 = null;
      Object var3 = null;

      try {
         FileInputStream var4 = new FileInputStream(var1);

         try {
            String var5 = new String(class_31.method_122(var4), StandardCharsets.UTF_8);
            Object var6 = class_94.method_533(var5);
            if (!(var6 instanceof class_137)) {
               throw new class_140("Object expected", 0, 0);
            }

            this.method_717((class_137)var6);
         } finally {
            if (var4 != null) {
               var4.close();
            }
         }
      } catch (Throwable var12) {
         if (var2 == null) {
            var2 = var12;
         } else if (var2 != var12) {
            var2.addSuppressed(var12);
         }

         throw var2;
      }
   }
}
