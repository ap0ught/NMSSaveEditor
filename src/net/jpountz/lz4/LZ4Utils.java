package net.jpountz.lz4;

enum LZ4Utils {
   private static final int MAX_INPUT_SIZE = 2113929216;

   static int maxCompressedLength(int length) {
      if (length < 0) {
         throw new IllegalArgumentException("length must be >= 0, got " + length);
      } else if (length >= 2113929216) {
         throw new IllegalArgumentException("length must be < 2113929216");
      } else {
         return length + length / 255 + 16;
      }
   }

   static int hash(int i) {
      return i * -1640531535 >>> 20;
   }

   static int hash64k(int i) {
      return i * -1640531535 >>> 19;
   }

   static int hashHC(int i) {
      return i * -1640531535 >>> 17;
   }

   static void copyTo(LZ4Utils.Match m1, LZ4Utils.Match m2) {
      m2.field_29 = m1.field_29;
      m2.start = m1.start;
      m2.field_28 = m1.field_28;
   }

   static class Match {
      int start;
      // $VF: renamed from: ref int
      int field_28;
      // $VF: renamed from: len int
      int field_29;

      // $VF: renamed from: fix (int) void
      void method_55(int correction) {
         this.start += correction;
         this.field_28 += correction;
         this.field_29 -= correction;
      }

      // $VF: renamed from: end () int
      int method_56() {
         return this.start + this.field_29;
      }
   }
}
