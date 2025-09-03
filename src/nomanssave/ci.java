package nomanssave;

import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

class cI implements TreeModel {
   private ArrayList gh;

   private cI(cy var1) {
      this.gg = var1;
      this.gh = new ArrayList();
   }

   @Override
   public Object getRoot() {
      return new cJ(this.gg, null, 0, cy.a(this.gg), cy.b(this.gg));
   }

   @Override
   public Object getChild(Object var1, int var2) {
      return ((cJ)var1).x(var2);
   }

   @Override
   public int getChildCount(Object var1) {
      return ((cJ)var1).getChildCount();
   }

   @Override
   public boolean isLeaf(Object var1) {
      return ((cJ)var1).isLeaf();
   }

   @Override
   public void valueForPathChanged(TreePath var1, Object var2) {
   }

   @Override
   public int getIndexOfChild(Object var1, Object var2) {
      return ((cJ)var1).indexOf(var2);
   }

   @Override
   public void addTreeModelListener(TreeModelListener var1) {
      this.gh.add(var1);
   }

   @Override
   public void removeTreeModelListener(TreeModelListener var1) {
      this.gh.remove(var1);
   }

   public void a(cJ var1) {
      ArrayList var2 = new ArrayList();
      var2.add(var1);

      while ((var1 = var1.gi) != null) {
         var2.add(0, var1);
      }

      TreeModelEvent var3 = new TreeModelEvent(this, var2.toArray());

      for (TreeModelListener var4 : this.gh) {
         var4.treeStructureChanged(var3);
      }
   }
}
