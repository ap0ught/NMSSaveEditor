package nomanssave;

// $VF: renamed from: nomanssave.fB
class class_121 extends class_119 implements class_8 {
   class_121(class_122 var1) {
      super(var1, "savedata00.hg", true);
      this.field_407 = var1;
   }

   // $VF: renamed from: M () nomanssave.eY
   @Override
   public class_137 method_31() {
      return class_122.method_659(this.readBytes(), class_297.field_950);
   }

   // $VF: renamed from: k (nomanssave.eY) void
   @Override
   public void method_32(class_137 var1) {
      this.a("ps4_accountdata", null, null, null);
      this.writeBytes(class_122.method_660(var1));
   }
}
