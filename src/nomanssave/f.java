package nomanssave;

import java.io.IOException;

class F implements fs {
   final String filename;
   final long bd;
   final fn be;
   final eY bf;

   public F(Application var1, String var2, long var3, fn var5, eY var6) {
      this.aZ = var1;
      this.filename = var2;
      this.bd = var3;
      this.be = var5;
      this.bf = var6;
   }

   @Override
   public String K() {
      return this.filename;
   }

   @Override
   public fn L() {
      return this.be;
   }

   @Override
   public long lastModified() {
      return this.bd;
   }

   @Override
   public eY M() {
      return this.bf;
   }

   @Override
   public String b(eY var1) {
      throw new IOException("Save not supported!");
   }

   @Override
   public String toString() {
      return this.filename;
   }
}
