package net.jpountz.xxhash;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public abstract class XXHash32 {
   public abstract int hash(byte[] var1, int var2, int var3, int var4);

   public abstract int hash(ByteBuffer var1, int var2, int var3, int var4);

   public final int hash(ByteBuffer buf, int seed) {
      int hash = this.hash(buf, buf.position(), buf.remaining(), seed);
      ((Buffer)buf).position(buf.limit());
      return hash;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName();
   }
}
