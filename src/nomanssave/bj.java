package nomanssave;

class bJ extends G {
   final gs ez;
   final int type;

   bJ(bE var1, gs var2, boolean var3) {
      this.ey = var1;
      this.ez = var2;
      switch (ad()[var2.ordinal()]) {
         case 24:
            this.type = 1;
            break;
         default:
            this.type = 0;
      }

      this.setEnabled(var3);
   }

   @Override
   protected String g(String var1) {
      if (bE.a(this.ey) == null) {
         return "";
      } else {
         String var2;
         switch (this.type) {
            case 0:
               var2 = Integer.toString(bE.a(this.ey).a(this.ez));
               break;
            case 1:
               var2 = Double.toString(bE.a(this.ey).b(this.ez));
               break;
            default:
               return "";
         }

         if (var1.equals(var2)) {
            return var1;
         } else {
            try {
               switch (this.type) {
                  case 0:
                     int var3 = hf.b(var1, 0, Integer.MAX_VALUE);
                     bE.a(this.ey).a(this.ez, var3);
                     var1 = Integer.toString(var3);
                     break;
                  case 1:
                     double var4 = Double.parseDouble(var1);
                     bE.a(this.ey).a(this.ez, var4);
                     var1 = Double.toString(var4);
               }

               bE.a(this.ey, this.ez, var1);
               if (this.ez == gs.pL || this.ez == gs.pM) {
                  int var7 = bE.a(this.ey).a(gs.pL) + bE.a(this.ey).a(gs.pM);
                  bE.a(this.ey).a(gs.pR, var7);
                  bE.a(this.ey, gs.pR, Integer.toString(var7));
               }

               if (this.ez == gs.pI || this.ez == gs.pK || this.ez == gs.pJ) {
                  int var8 = bE.a(this.ey).a(gs.pI) + bE.a(this.ey).a(gs.pK) + bE.a(this.ey).a(gs.pJ);
                  bE.a(this.ey).a(gs.pS, var8);
                  bE.a(this.ey, gs.pS, Integer.toString(var8));
               }

               return var1;
            } catch (RuntimeException var6) {
               return var2;
            }
         }
      }
   }

   void ac() {
      String var1;
      if (bE.a(this.ey) == null) {
         var1 = "";
      } else {
         switch (this.type) {
            case 0:
               var1 = Integer.toString(bE.a(this.ey).a(this.ez));
               break;
            case 1:
               var1 = Double.toString(bE.a(this.ey).b(this.ez));
               break;
            default:
               var1 = "";
         }
      }

      this.setText(var1);
   }
}
