package net.jpountz.xxhash;

abstract class AbstractStreamingXXHash32Java extends StreamingXXHash32 {
   // $VF: renamed from: v1 int
   int field_24;
   // $VF: renamed from: v2 int
   int field_25;
   // $VF: renamed from: v3 int
   int field_26;
   // $VF: renamed from: v4 int
   int field_27;
   int memSize;
   long totalLen;
   final byte[] memory = new byte[16];

   AbstractStreamingXXHash32Java(int seed) {
      super(seed);
      this.reset();
   }

   @Override
   public void reset() {
      this.field_24 = this.seed + -1640531535 + -2048144777;
      this.field_25 = this.seed + -2048144777;
      this.field_26 = this.seed + 0;
      this.field_27 = this.seed - -1640531535;
      this.totalLen = 0L;
      this.memSize = 0;
   }
}
