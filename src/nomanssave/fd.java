package nomanssave;

import java.io.IOException;

class fD extends fH implements fs {
   final int lO;
   fn me;

   fD(fA var1, int var2) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", true);
      this.ma = var1;
      this.lO = var2;

      try {
         String var3 = new String(this.ah(65536));
         this.me = fn.T(var3);
      } catch (IOException var4) {
         hc.a("Could not read game mode from " + this.mh.getName(), var4);
      }
   }

   fD(fA var1, int var2, byte[] var3, eY var4) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", false);
      this.ma = var1;
      this.lO = var2;
      this.lK = var3;
      this.me = fn.i(var4);
      this.writeBytes(fA.l(var4));
   }

   @Override
   public fn L() {
      return this.me;
   }

   @Override
   public eY M() {
      return fA.b(this.readBytes(), eG.jV);
   }

   @Override
   public String b(eY var1) {
      this.a(this.lO == 0 ? "ps4_backup" : "ps4_backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
      this.writeBytes(fA.l(var1));
      return this.K();
   }

   @Override
   public long lastModified() {
      return this.mh.lastModified();
   }

   @Override
   public String toString() {
      return this.K();
   }
}
