package nomanssave;

import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

// $VF: renamed from: nomanssave.cI
class class_217 implements TreeModel {
   // $VF: renamed from: gh java.util.ArrayList
   private ArrayList field_596;

   private class_217(class_322 var1) {
      this.field_597 = var1;
      this.field_596 = new ArrayList();
   }

   @Override
   public Object getRoot() {
      return new class_216(this.field_597, null, 0, class_322.method_922(this.field_597), class_322.method_923(this.field_597));
   }

   @Override
   public Object getChild(Object var1, int var2) {
      return ((class_216)var1).method_833(var2);
   }

   @Override
   public int getChildCount(Object var1) {
      return ((class_216)var1).getChildCount();
   }

   @Override
   public boolean isLeaf(Object var1) {
      return ((class_216)var1).isLeaf();
   }

   @Override
   public void valueForPathChanged(TreePath var1, Object var2) {
   }

   @Override
   public int getIndexOfChild(Object var1, Object var2) {
      return ((class_216)var1).indexOf(var2);
   }

   @Override
   public void addTreeModelListener(TreeModelListener var1) {
      this.field_596.add(var1);
   }

   @Override
   public void removeTreeModelListener(TreeModelListener var1) {
      this.field_596.remove(var1);
   }

   // $VF: renamed from: a (nomanssave.cJ) void
   public void method_835(class_216 var1) {
      ArrayList var2 = new ArrayList();
      var2.add(var1);

      while ((var1 = var1.field_593) != null) {
         var2.add(0, var1);
      }

      TreeModelEvent var3 = new TreeModelEvent(this, var2.toArray());

      for (TreeModelListener var4 : this.field_596) {
         var4.treeStructureChanged(var3);
      }
   }
}
