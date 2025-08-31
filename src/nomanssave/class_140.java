package nomanssave;

import java.io.IOException;

// $VF: renamed from: nomanssave.eX
public class class_140 extends IOException {
   // $VF: renamed from: kF int
   final int field_452;
   // $VF: renamed from: kG int
   final int field_453;

   class_140(String var1) {
      this(var1, 1, 0);
   }

   class_140(String var1, int var2, int var3) {
      super(var1);
      this.field_452 = var2;
      this.field_453 = var3;
   }

   class_140(String var1, IOException var2, int var3, int var4) {
      super(var1, var2);
      this.field_452 = var3;
      this.field_453 = var4;
   }

   public int getLineNumber() {
      return this.field_452;
   }

   // $VF: renamed from: bD () int
   public int method_723() {
      return this.field_453;
   }
}
