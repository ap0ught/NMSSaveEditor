package nomanssave;

import java.io.IOException;
import java.util.regex.Matcher;

// $VF: renamed from: nomanssave.fY
class class_102 extends class_101 implements class_9 {
   // $VF: renamed from: lO int
   final int field_324;
   // $VF: renamed from: me nomanssave.fn
   class_294 field_325;
   // $VF: renamed from: na java.lang.String
   String field_326;

   class_102(class_104 var1, int var2) {
      super(var1, "Slot" + (var2 / 2 + 1) + (var2 % 2 == 0 ? "Auto" : "Manual"));
      this.field_327 = var1;
      this.field_324 = var2;

      try {
         String var3 = new String(this.ah(1048576));
         Matcher var4 = class_104.method_589().matcher(var3);
         if (var4.find()) {
            this.field_326 = var4.group(3);
         }

         this.field_325 = class_294.method_855(var3);
      } catch (IOException var5) {
         class_37.method_156("Could not read game mode from " + this.mO.name, var5);
      }
   }

   class_102(class_104 var1, class_100 var2, class_137 var3) {
      super(var1, var2);
      this.field_327 = var1;
      this.field_324 = var2.field_311;
      this.mZ.method_612(var2.field_314);
      int var4 = class_104.method_590(var3.method_705("Version"));
      if (var4 != 0) {
         this.mZ.setVersion(var4);
      }

      this.field_326 = var3.getValueAsString("CommonStateData.SaveName");
      if (this.field_326 != null) {
         this.mZ.method_609(this.field_326);
      }

      this.field_325 = class_294.method_856(var3);
      long var5 = var3.method_707("PlayerStateData.TotalPlayTime");
      if (var5 != 0L) {
         this.mZ.method_611(var5);
      }

      this.h(var3);
   }

   // $VF: renamed from: L () nomanssave.fn
   @Override
   public class_294 method_34() {
      return this.field_325;
   }

   @Override
   public long lastModified() {
      return this.mO.timestamp;
   }

   // $VF: renamed from: M () nomanssave.eY
   @Override
   public class_137 method_35() {
      return this.a(class_297.field_949);
   }

   // $VF: renamed from: b (nomanssave.eY) java.lang.String
   @Override
   public String method_36(class_137 var1) {
      this.a(this.field_324 == 0 ? "wgsbackup" : "wgsbackup" + (this.field_324 + 1), this.field_325);
      int var2 = class_104.method_590(var1.method_705("Version"));
      if (var2 != 0) {
         this.mZ.setVersion(var2);
      }

      this.field_326 = var1.getValueAsString("CommonStateData.SaveName");
      if (this.field_326 != null) {
         this.mZ.method_609(this.field_326);
      }

      this.field_325 = class_294.method_856(var1);
      long var3 = var1.method_707("PlayerStateData.TotalPlayTime");
      if (var3 != 0L) {
         this.mZ.method_611(var3);
      }

      this.h(var1);
      return this.mO.filename;
   }

   @Override
   public String toString() {
      return this.mO.name;
   }

   @Override
   public String getName() {
      return this.field_326;
   }

   @Override
   public String getDescription() {
      return this.mZ.getDescription();
   }
}
