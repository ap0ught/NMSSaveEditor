package nomanssave;

import java.util.Arrays;
import java.util.stream.Stream;

// $VF: renamed from: nomanssave.eV
public class class_142 {
   // $VF: renamed from: kB int
   private static final int field_455 = 10;
   // $VF: renamed from: kC int
   private static final int field_456 = 10;
   int length;
   Object[] values;
   // $VF: renamed from: kD java.lang.Object
   Object field_457;

   // $VF: renamed from: D (java.lang.String) nomanssave.eV
   public static class_142 method_726(String var0) {
      return class_94.method_537(var0);
   }

   public class_142() {
      this.length = 0;
      this.values = new Object[10];
   }

   public class_142(Object... var1) {
      this.length = var1.length;
      this.values = new Object[var1.length];

      for (int var2 = 0; var2 < this.length; var2++) {
         if (var1[var2] != null && !class_94.method_519(var1[var2].getClass())) {
            throw new RuntimeException("Unsupported type: " + var1[var2].getClass().getSimpleName());
         }

         this.values[var2] = var1[var2];
         class_94.method_545(var1[var2], this);
      }
   }

   // $VF: renamed from: e (java.lang.Object) void
   void method_727(Object var1) {
      if (this.values.length == this.length) {
         Object[] var2 = new Object[this.length + 10];
         System.arraycopy(this.values, 0, var2, 0, this.length);
         this.values = var2;
      }

      this.values[this.length] = var1;
      class_94.method_545(var1, this);
      this.length++;
   }

   // $VF: renamed from: U (int) java.lang.Object
   Object method_728(int var1) {
      return this.values[var1];
   }

   // $VF: renamed from: bz () java.lang.String
   public String method_729() {
      return class_94.method_524(this, System.lineSeparator(), true);
   }

   @Override
   public String toString() {
      return class_94.method_524(this, null, false);
   }

   // $VF: renamed from: bA () nomanssave.eV
   public class_142 method_730() {
      class_142 var1 = new class_142();
      var1.values = new Object[this.values.length];

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

   public int indexOf(Object var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         for (int var2 = 0; var2 < this.length; var2++) {
            if (var1.equals(this.values[var2])) {
               return var2;
            }
         }

         return -1;
      }
   }

   // $VF: renamed from: get (int) java.lang.Object
   public Object method_731(int var1) {
      if (var1 >= 0 && var1 < this.length) {
         return this.values[var1];
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   // $VF: renamed from: set (int, java.lang.Object) java.lang.Object
   public Object method_732(int var1, Object var2) {
      if (var1 < 0 || var1 >= this.length) {
         throw new IndexOutOfBoundsException();
      } else if (var2 != null && !class_94.method_519(var2.getClass())) {
         throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
      } else {
         Object var3 = this.values[var1];
         class_94.method_544(var3);
         this.values[var1] = var2;
         class_94.method_545(var2, this);
         this.firePropertyChange("[" + var1 + "]", var3, var2);
         return var3;
      }
   }

   // $VF: renamed from: add (java.lang.Object) void
   public void method_733(Object var1) {
      if (var1 != null && !class_94.method_519(var1.getClass())) {
         throw new RuntimeException("Unsupported type: " + var1.getClass().getSimpleName());
      } else {
         class_142 var2 = new class_142();
         if (this.values.length == this.length) {
            var2.values = this.values;
            var2.length = this.length;
            Object[] var3 = new Object[this.length + 10];
            System.arraycopy(this.values, 0, var3, 0, this.length);
            this.values = var3;
         } else {
            var2.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, var2.values, 0, this.length);
            var2.length = this.length;
         }

         this.values[this.length] = var1;
         class_94.method_545(var1, this);
         this.length++;
         this.firePropertyChange("", var2, this);
      }
   }

   // $VF: renamed from: add (int, java.lang.Object) void
   public void method_734(int var1, Object var2) {
      if (var1 < 0 || var1 > this.length) {
         throw new IndexOutOfBoundsException();
      } else if (var2 != null && !class_94.method_519(var2.getClass())) {
         throw new RuntimeException("Unsupported type: " + var2.getClass().getSimpleName());
      } else {
         class_142 var3 = new class_142();
         if (this.values.length == this.length) {
            var3.values = this.values;
            var3.length = this.length;
            Object[] var4 = new Object[this.length + 10];
            System.arraycopy(this.values, 0, var4, 0, this.length);
            this.values = var4;
         } else {
            var3.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, var3.values, 0, this.length);
            var3.length = this.length;
         }

         for (int var5 = this.length; var5 > var1; var5++) {
            this.values[var5] = this.values[var5 - 1];
         }

         this.values[var1] = var2;
         class_94.method_545(var2, this);
         this.length++;
         this.firePropertyChange("", var3, this);
      }
   }

   public Object remove(int var1) {
      if (var1 >= 0 && var1 < this.length) {
         class_142 var2 = new class_142();
         var2.values = new Object[this.values.length];
         System.arraycopy(this.values, 0, var2.values, 0, this.length);
         var2.length = this.length;
         Object var3 = this.values[var1];
         class_94.method_544(var3);

         for (int var4 = var1; var4 < this.length - 1; var4++) {
            this.values[var4] = this.values[var4 + 1];
         }

         this.length--;
         this.firePropertyChange("", var2, this);
         return var3;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void clear() {
      class_142 var1 = new class_142();
      var1.values = new Object[this.values.length];
      System.arraycopy(this.values, 0, var1.values, 0, this.length);
      var1.length = this.length;

      for (int var2 = 0; var2 < this.length; var2++) {
         class_94.method_544(this.values[var2]);
      }

      this.length = 0;
      this.firePropertyChange("", var1, this);
   }

   // $VF: renamed from: a (java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object) void
   void method_735(Object var1, String var2, Object var3, Object var4) {
      for (int var5 = 0; var5 < this.length; var5++) {
         if (var1 == this.values[var5]) {
            this.firePropertyChange("[" + var5 + "]" + var2, var3, var4);
            return;
         }
      }
   }

   private void firePropertyChange(String var1, Object var2, Object var3) {
      if (this.field_457 instanceof class_137) {
         ((class_137)this.field_457).method_700(this, var1, var2, var3);
      }

      if (this.field_457 instanceof class_142) {
         ((class_142)this.field_457).method_735(this, var1, var2, var3);
      }
   }

   public Object getValue(int var1) {
      return this.method_731(var1);
   }

   // $VF: renamed from: V (int) nomanssave.eY
   public class_137 method_736(int var1) {
      return (class_137)this.getValue(var1);
   }

   // $VF: renamed from: W (int) nomanssave.eV
   public class_142 method_737(int var1) {
      return (class_142)this.getValue(var1);
   }

   // $VF: renamed from: X (int) java.lang.String
   public String method_738(int var1) {
      Object var2 = this.getValue(var1);
      return var2 instanceof class_95 ? var2.toString() : (String)var2;
   }

   // $VF: renamed from: Y (int) int
   public int method_739(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0 : ((Number)var2).intValue();
   }

   // $VF: renamed from: Z (int) long
   public long method_740(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0L : ((Number)var2).longValue();
   }

   // $VF: renamed from: aa (int) double
   public double method_741(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? 0.0 : ((Number)var2).doubleValue();
   }

   // $VF: renamed from: ab (int) boolean
   public boolean method_742(int var1) {
      Object var2 = this.getValue(var1);
      return var2 == null ? false : (Boolean)var2;
   }

   // $VF: renamed from: a (int, java.lang.Object) void
   public void method_743(int var1, Object var2) {
      this.method_732(var1, var2);
   }

   // $VF: renamed from: f (java.lang.Object) void
   public void method_744(Object var1) {
      this.method_733(var1);
   }

   public boolean hasValue(Object var1) {
      return this.indexOf(var1) >= 0;
   }

   // $VF: renamed from: ac (int) boolean
   public boolean method_745(int var1) {
      this.remove(var1);
      return true;
   }

   // $VF: renamed from: g (java.lang.Object) boolean
   public boolean method_746(Object var1) {
      int var2 = this.indexOf(var1);
      if (var2 < 0) {
         return false;
      } else {
         this.remove(var2);
         return true;
      }
   }

   // $VF: renamed from: bB () java.util.stream.Stream
   public Stream method_747() {
      class_137[] var1 = new class_137[this.length];
      int var2 = 0;

      for (int var3 = 0; var3 < this.length; var3++) {
         if (this.values[var3] instanceof class_137) {
            var1[var2++] = (class_137)this.values[var3];
         }
      }

      return Arrays.stream(var1, 0, var2);
   }
}
