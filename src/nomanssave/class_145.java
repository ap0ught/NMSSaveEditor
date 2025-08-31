package nomanssave;

// $VF: renamed from: nomanssave.eO
class class_145 {
   // $VF: renamed from: id java.lang.String
   final String field_461;

   class_145(String var1) {
      this.field_461 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      class_147 var2 = (class_147)var1;
      return var2.field_464 ? this.field_461.startsWith(var2.field_462 + "#") : this.field_461.equals(var2.field_462);
   }
}
