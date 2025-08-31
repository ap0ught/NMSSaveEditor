package nomanssave;

import java.io.File;
import java.io.IOException;

// $VF: renamed from: nomanssave.fM
class class_111 extends class_110 implements class_9 {
   // $VF: renamed from: me nomanssave.fn
   class_294 field_371;

   class_111(class_113 var1, int var2) {
      super(var1, var2 == 0 ? "save.hg" : "save" + (var2 + 1) + ".hg", var2, true);
      this.field_372 = var1;

      try {
         String var3 = new String(this.ah(65536));
         this.field_371 = class_294.method_855(var3);
      } catch (IOException var4) {
         class_37.method_156("Could not read game mode from " + this.filename, var4);
      }
   }

   class_111(class_113 var1, int var2, class_137 var3) {
      super(var1, var2 == 0 ? "save.hg" : "save" + (var2 + 1) + ".hg", var2, false);
      this.field_372 = var1;
      this.field_371 = class_294.method_856(var3);
      this.a(var3, true);
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_34() {
      return this.field_371;
   }

   // $VF: renamed from: M () nomanssave.eY
   @Override
   public class_137 method_35() {
      return this.a(class_297.field_949);
   }

   // $VF: renamed from: cm () void
   void method_620() {
      this.a(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.field_371, this.getName(), this.getDescription());
      new File(class_113.method_623(this.field_372), this.filename).delete();
      new File(class_113.method_623(this.field_372), "mf_" + this.filename).delete();
   }

   // $VF: renamed from: b (nomanssave.eY) java.lang.String
   @Override
   public String method_36(class_137 var1) {
      this.a(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.field_371, this.getName(), this.getDescription());
      this.mx.method_642(var1.getValueAsString("CommonStateData.SaveName"));
      this.field_371 = class_294.method_856(var1);
      this.mx.method_640((int)var1.method_707("CommonStateData.TotalPlayTime"));
      this.a(var1, true);
      return this.filename;
   }

   @Override
   public String toString() {
      return this.filename;
   }

   @Override
   public String getName() {
      return this.mx.method_641();
   }

   @Override
   public String getDescription() {
      return this.mx.getDescription();
   }
}
