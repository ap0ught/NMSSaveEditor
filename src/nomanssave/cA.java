// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

class cA extends DefaultTreeCellRenderer
{
    final /* synthetic */ cy gg;
    
    cA(final cy gg) {
        this.gg = gg;
    }
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value, final boolean sel, final boolean expanded, final boolean leaf, final int row, final boolean hasFocus) {
        final JLabel label = (JLabel)super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if (((cJ)value).gi == null) {
            label.setIcon(Application.a("UI-FILEICON.PNG", 20, 20));
        }
        else if (leaf) {
            label.setIcon(UIManager.getIcon("Tree.leafIcon"));
        }
        else if (expanded) {
            label.setIcon(UIManager.getIcon("Tree.openIcon"));
        }
        else {
            label.setIcon(UIManager.getIcon("Tree.closedIcon"));
        }
        return label;
    }
}
