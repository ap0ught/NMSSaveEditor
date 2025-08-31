package net.jpountz.xxhash;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public abstract class XXHash64 {
   public abstract long hash(byte[] var1, int var2, int var3, long var4);

   public abstract long hash(ByteBuffer var1, int var2, int var3, long var4);

   public final long hash(ByteBuffer buf, long seed) {
      long hash = this.hash(buf, buf.position(), buf.remaining(), seed);
      ((Buffer)buf).position(buf.limit());
      return hash;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName();
   }
}
