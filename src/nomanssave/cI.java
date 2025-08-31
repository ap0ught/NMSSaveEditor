// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import javax.swing.tree.TreeModel;

class cI implements TreeModel
{
    private ArrayList gh;
    final /* synthetic */ cy gg;
    
    private cI(final cy gg) {
        this.gg = gg;
        this.gh = new ArrayList();
    }
    
    @Override
    public Object getRoot() {
        return new cJ(this.gg, null, 0, this.gg.fS, this.gg.fT);
    }
    
    @Override
    public Object getChild(final Object o, final int n) {
        return ((cJ)o).x(n);
    }
    
    @Override
    public int getChildCount(final Object o) {
        return ((cJ)o).getChildCount();
    }
    
    @Override
    public boolean isLeaf(final Object o) {
        return ((cJ)o).isLeaf();
    }
    
    @Override
    public void valueForPathChanged(final TreePath treePath, final Object o) {
    }
    
    @Override
    public int getIndexOfChild(final Object o, final Object o2) {
        return ((cJ)o).indexOf(o2);
    }
    
    @Override
    public void addTreeModelListener(final TreeModelListener e) {
        this.gh.add(e);
    }
    
    @Override
    public void removeTreeModelListener(final TreeModelListener o) {
        this.gh.remove(o);
    }
    
    public void a(cJ gi) {
        final ArrayList list = new ArrayList();
        list.add(gi);
        while ((gi = gi.gi) != null) {
            list.add(0, gi);
        }
        final TreeModelEvent treeModelEvent = new TreeModelEvent(this, list.toArray());
        final Iterator iterator = this.gh.iterator();
        while (iterator.hasNext()) {
            ((TreeModelListener)iterator.next()).treeStructureChanged(treeModelEvent);
        }
    }
}
