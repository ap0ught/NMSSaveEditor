package nomanssave;

public class gh {
   final String name;
   final eY nn;

   private gh(ge var1, String var2, eY var3) {
      this.nk = var1;
      this.name = var2;
      this.nn = var3;
   }

   public gy cJ() {
      return gy.as(this.nn.getValueAsString("ResourceElement.Filename"));
   }

   public String cK() {
      return this.nn.d("ResourceElement.Seed").X(1);
   }

   public void aa(String var1) {
      this.nn.d("ResourceElement.Seed").a(1, var1);
   }

   @Override
   public String toString() {
      return this.name;
   }
}
