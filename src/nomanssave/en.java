package nomanssave;

import java.util.Comparator;

class eN implements Comparator {
   public int a(eM var1, eM var2) {
      return var1.name.compareTo(var2.name);
   }
}
