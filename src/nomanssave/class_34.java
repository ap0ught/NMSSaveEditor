package nomanssave;

import java.security.SecureRandom;

// $VF: renamed from: nomanssave.hg
public class class_34 {
   // $VF: renamed from: sv java.security.SecureRandom
   private static final SecureRandom field_98 = new SecureRandom();
   // $VF: renamed from: sw long
   private final long field_99;

   // $VF: renamed from: aB (java.lang.String) nomanssave.hg
   public static class_34 method_147(String var0) {
      var0 = var0.trim();
      if (!var0.startsWith("0x")) {
         throw new RuntimeException("Invalid seed: " + var0);
      } else {
         long var1 = Long.parseUnsignedLong(var0.substring(2), 16);
         return new class_34(var1);
      }
   }

   // $VF: renamed from: eo () nomanssave.hg
   public static class_34 method_148() {
      return new class_34(field_98.nextLong());
   }

   public class_34(long var1) {
      this.field_99 = var1;
   }

   @Override
   public String toString() {
      return "0x" + Long.toHexString(this.field_99).toUpperCase();
   }
}
