package nomanssave;

public enum eB {
   jN("Technology"),
   jO("Product"),
   jP("Substance"),
   jQ("TechBox");

   private String name;

   private eB(String var3) {
      this.name = var3;
   }

   @Override
   public String toString() {
      return this.name;
   }
}
