package nomanssave;

class dl extends G {
   dl(dj var1) {
      this.hl = var1;
   }

   @Override
   protected String g(String var1) {
      gv var2 = (gv)dj.j(this.hl).getSelectedItem();
      if (var2 == null) {
         return "";
      } else {
         var1 = var1.trim();
         if (!var1.equals(var2.getName())) {
            var2.setName(var1);
            dj.b(this.hl).setText(var1);
         }

         return var1;
      }
   }
}
