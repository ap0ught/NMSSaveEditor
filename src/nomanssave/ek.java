package nomanssave;

import java.util.Comparator;

class eK implements Comparator {
   public int a(eI var1, eI var2) {
      return var1.name.compareTo(var2.name);
   }
}
