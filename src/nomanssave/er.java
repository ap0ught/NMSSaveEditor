package nomanssave;

import java.io.ByteArrayOutputStream;
import java.util.List;
import org.w3c.dom.Element;

public class eR extends ey {
   final String kc;
   final eA kn;

   eR(eQ var1, Element var2) {
      super(var2.getAttribute("id"));
      this.ko = var1;
      this.kc = var2.hasAttribute("icon") ? var2.getAttribute("icon") : null;
      this.kn = ey.p(var2.getAttribute("template"));
   }

   @Override
   public Object aZ() {
      return this.M(this.ko.jY ? (int)Math.floor(Math.random() * 100000.0) : 0);
   }

   @Override
   public Object M(int var1) {
      if (this.id.length() != 13 || this.id.charAt(0) != '^') {
         throw new RuntimeException("Cannot create ID: invalid string");
      } else if (var1 >= 0 && var1 < 100000) {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         var2.write(94);

         for (int var3 = 0; var3 < 6; var3++) {
            int var4 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(var3 * 2 + 1));
            int var5 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(var3 * 2 + 2));
            if (var4 < 0 || var5 < 0) {
               throw new RuntimeException("Cannot create ID: invalid hex");
            }

            if (var4 >= 16) {
               var4 -= 6;
            }

            if (var5 >= 16) {
               var5 -= 6;
            }

            var2.write(var4 << 4 | var5);
         }

         var2.write(35);

         for (int var6 = 100000; var6 > 1; var6 /= 10) {
            int var7 = var1 * 10 / var6 % 10;
            var2.write("0123456789ABCDEFabcdef".charAt(var7));
         }

         return new fg(var2.toByteArray());
      } else {
         throw new RuntimeException("Cannot create ID: invalid proc");
      }
   }

   @Override
   public eB ba() {
      return eB.jO;
   }

   @Override
   public boolean bb() {
      return this.ko.jY;
   }

   private String y(String var1) {
      if ("NAME".equals(var1)) {
         return this.ko.name;
      } else {
         return "TECH_DESC".equals(var1) ? this.ko.description : var1;
      }
   }

   @Override
   public String getName() {
      return this.kn.a(this::y);
   }

   @Override
   public ex bc() {
      return ex.jd;
   }

   @Override
   public boolean bd() {
      return false;
   }

   @Override
   public boolean be() {
      return false;
   }

   @Override
   public Integer bf() {
      return null;
   }

   @Override
   public String bg() {
      return this.kn.b(this::y);
   }

   @Override
   public boolean bh() {
      return false;
   }

   @Override
   public String bi() {
      return this.kc;
   }

   @Override
   public int bj() {
      return 0;
   }

   @Override
   public String getDescription() {
      return this.kn.c(this::y);
   }

   @Override
   public List bk() {
      return this.ko.ke;
   }

   @Override
   public String toString() {
      return this.ko.name.length() == 0 ? this.id : this.ko.name;
   }
}
