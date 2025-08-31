package nomanssave;

import java.io.IOException;

// $VF: renamed from: nomanssave.fD
class class_120 extends class_119 implements class_9 {
   // $VF: renamed from: lO int
   final int field_404;
   // $VF: renamed from: me nomanssave.fn
   class_294 field_405;

   class_120(class_122 var1, int var2) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", true);
      this.field_406 = var1;
      this.field_404 = var2;

      try {
         String var3 = new String(this.ah(65536));
         this.field_405 = class_294.method_855(var3);
      } catch (IOException var4) {
         class_37.method_156("Could not read game mode from " + this.mh.getName(), var4);
      }
   }

   class_120(class_122 var1, int var2, byte[] var3, class_137 var4) {
      super(var1, "savedata" + (var2 < 8 ? "0" : "") + Integer.toString(var2 + 2) + ".hg", false);
      this.field_406 = var1;
      this.field_404 = var2;
      this.lK = var3;
      this.field_405 = class_294.method_856(var4);
      this.writeBytes(class_122.method_660(var4));
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_34() {
      return this.field_405;
   }

   // $VF: renamed from: M () nomanssave.eY
   @Override
   public class_137 method_35() {
      return class_122.method_659(this.readBytes(), class_297.field_949);
   }

   // $VF: renamed from: b (nomanssave.eY) java.lang.String
   @Override
   public String method_36(class_137 var1) {
      this.a(this.field_404 == 0 ? "ps4_backup" : "ps4_backup" + (this.field_404 + 1), this.field_405, this.getName(), this.getDescription());
      this.writeBytes(class_122.method_660(var1));
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
