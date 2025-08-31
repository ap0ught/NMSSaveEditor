package nomanssave;

// $VF: renamed from: nomanssave.cJ
class class_216 {
   // $VF: renamed from: gi nomanssave.cJ
   final class_216 field_593;
   // $VF: renamed from: gj int
   final int field_594;
   final String name;
   Object value;

   class_216(class_322 var1, class_216 var2, int var3, String var4, Object var5) {
      this.field_595 = var1;
      this.field_593 = var2;
      this.value = var5;
      this.name = var4;
      this.field_594 = var3;
   }

   boolean isLeaf() {
      if (this.value == null) {
         return true;
      } else {
         return this.value instanceof class_137 ? false : !(this.value instanceof class_142);
      }
   }

   int getChildCount() {
      if (this.value == null) {
         return 0;
      } else if (this.value instanceof class_137) {
         return ((class_137)this.value).names().size();
      } else {
         return this.value instanceof class_142 ? ((class_142)this.value).size() : 0;
      }
   }

   // $VF: renamed from: x (int) java.lang.Object
   Object method_833(int var1) {
      if (this.value == null) {
         throw new RuntimeException("No children for null");
      } else if (this.value instanceof class_137) {
         String var4 = (String)((class_137)this.value).names().get(var1);
         Object var3 = ((class_137)this.value).getValue(var4);
         return new class_216(this.field_595, this, var1, var4, var3);
      } else if (this.value instanceof class_142) {
         Object var2 = ((class_142)this.value).getValue(var1);
         return new class_216(this.field_595, this, var1, "[" + var1 + "]", var2);
      } else {
         throw new RuntimeException("No children for " + this.value.getClass().getName());
      }
   }

   int indexOf(Object var1) {
      return var1 instanceof class_216 && ((class_216)var1).field_593 == this ? ((class_216)var1).field_594 : -1;
   }

   @Override
   public String toString() {
      return this.name;
   }

   public String getText() {
      return class_94.method_521(this.value, 1, cJ::a);
   }

   public void setText(String var1) {
      if (this.field_593 == null) {
         this.value = class_137.method_689(var1);
         class_322.method_923(this.field_595).method_717((class_137)this.value);
      } else {
         this.value = class_94.method_533(var1);
         if (this.field_593.value instanceof class_137) {
            ((class_137)this.field_593.value).method_713(this.name, this.value);
         } else if (this.field_593.value instanceof class_142) {
            ((class_142)this.field_593.value).method_743(this.field_594, this.value);
         }
      }

      class_322.method_924(this.field_595, false);
      class_322.method_925(this.field_595, true);
   }

   public void remove() {
      if (this.field_593 == null) {
         throw new RuntimeException("Cannot remove root node");
      } else {
         this.value = null;
         if (this.field_593.value instanceof class_137) {
            ((class_137)this.field_593.value).method_715(this.name);
         } else if (this.field_593.value instanceof class_142) {
            ((class_142)this.field_593.value).method_745(this.field_594);
         }

         class_322.method_924(this.field_595, false);
         class_322.method_925(this.field_595, true);
      }
   }
}
