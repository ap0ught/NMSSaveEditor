package nomanssave;

public class gF implements gQ {
   private final eY kM;

   private gF(gE var1, eY var2) {
      this.rf = var1;
      this.kM = var2;
   }

   public boolean isValid() {
      String var1 = this.kM.getValueAsString("ElementId");
      return var1 != null && var1.length() > 1;
   }

   @Override
   public String getType() {
      return "Product";
   }

   @Override
   public Object dz() {
      return this.kM.getValue("ElementId");
   }

   @Override
   public void m(Object var1) {
      this.kM.b("ElementId", var1);
      this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
   }

   @Override
   public int dA() {
      return this.kM.J("Amount");
   }

   @Override
   public void aA(int var1) {
      this.kM.b("Amount", var1);
      this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
   }

   @Override
   public int dB() {
      return 999;
   }
}
