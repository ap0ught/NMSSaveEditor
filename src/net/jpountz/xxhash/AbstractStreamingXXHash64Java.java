package net.jpountz.xxhash;

abstract class AbstractStreamingXXHash64Java extends StreamingXXHash64 {
   int memSize;
   // $VF: renamed from: v1 long
   long field_20;
   // $VF: renamed from: v2 long
   long field_21;
   // $VF: renamed from: v3 long
   long field_22;
   // $VF: renamed from: v4 long
   long field_23;
   long totalLen;
   final byte[] memory = new byte[32];

   AbstractStreamingXXHash64Java(long seed) {
      super(seed);
      this.reset();
   }

   @Override
   public void reset() {
      this.field_20 = this.seed + -7046029288634856825L + -4417276706812531889L;
      this.field_21 = this.seed + -4417276706812531889L;
      this.field_22 = this.seed + 0L;
      this.field_23 = this.seed - -7046029288634856825L;
      this.totalLen = 0L;
      this.memSize = 0;
   }
}
