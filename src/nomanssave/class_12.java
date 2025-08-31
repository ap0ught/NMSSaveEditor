package nomanssave;

// $VF: renamed from: nomanssave.gQ
public interface class_12 {
   String getType();

   // $VF: renamed from: dz () java.lang.Object
   Object method_40();

   // $VF: renamed from: ei () java.lang.String
   default String method_41() {
      Object var1 = this.method_40();
      return var1 instanceof class_95 ? ((class_95)var1).method_551() : var1.toString();
   }

   // $VF: renamed from: m (java.lang.Object) void
   void method_42(Object var1);

   // $VF: renamed from: dA () int
   int method_43();

   // $VF: renamed from: aA (int) void
   void method_44(int var1);

   // $VF: renamed from: dB () int
   int method_45();
}
