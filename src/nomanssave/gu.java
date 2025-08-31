package nomanssave;

public class gu implements gQ {
   private final eY qD;

   private gu(gt var1, eY var2) {
      this.qE = var1;
      this.qD = var2;
   }

   @Override
   public String getType() {
      return this.qD.getValueAsString("Type.InventoryType");
   }

   @Override
   public Object dz() {
      return this.qD.getValue("Id");
   }

   @Override
   public void m(Object var1) {
      this.qD.b("Id", var1);
   }

   @Override
   public int dA() {
      return this.qD.J("Amount");
   }

   @Override
   public void aA(int var1) {
      this.qD.b("Amount", new Integer(var1));
   }

   @Override
   public int dB() {
      return this.qD.J("MaxAmount");
   }

   public double dC() {
      return this.qD.L("DamageFactor");
   }

   public void c(double var1) {
      this.qD.b("DamageFactor", new Double(var1));
   }

   public boolean dD() {
      return this.qD.M("FullyInstalled");
   }

   public void e(boolean var1) {
      this.qD.b("FullyInstalled", new Boolean(var1));
   }
}
