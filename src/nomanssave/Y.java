// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;

class Y implements ComboBoxModel
{
    private gj bU;
    final /* synthetic */ X bV;
    
    Y(final X bv) {
        this.bV = bv;
        this.bU = null;
    }
    
    @Override
    public int getSize() {
        return (this.bV.bT == null) ? 0 : this.bV.bT.length;
    }
    
    public gj q(final int n) {
        return this.bV.bT[n];
    }
    
    @Override
    public void addListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener listDataListener) {
    }
    
    @Override
    public void setSelectedItem(final Object o) {
        this.bU = (gj)o;
        if (this.bU == null) {
            this.bV.bH.setSelectedIndex(-1);
            this.bV.bI.setText("");
            this.bV.bI.setEnabled(false);
            this.bV.bJ.setText("");
            this.bV.bJ.setEnabled(false);
            this.bV.bK.setText("");
            this.bV.bK.setEnabled(false);
            this.bV.bL.setText("");
            this.bV.bL.setEnabled(false);
            this.bV.bM.setText("");
            this.bV.bM.setEnabled(false);
            this.bV.bN.setSelected(false);
            this.bV.bN.setEnabled(false);
            this.bV.bO.setSelectedIndex(-1);
            this.bV.bO.setEnabled(false);
            this.bV.bP.setSelectedIndex(-1);
            this.bV.bP.setEnabled(false);
        }
        else {
            this.bV.bH.setSelectedIndex(this.bU.cL().ordinal());
            this.bV.bI.setText(this.bU.getName());
            this.bV.bI.setEnabled(true);
            this.bV.bJ.setText(this.bU.cK());
            this.bV.bJ.setEnabled(true);
            this.bV.bK.setText(this.bU.cN());
            this.bV.bK.setEnabled(true);
            this.bV.bL.setText(this.bU.cO());
            this.bV.bL.setEnabled(true);
            this.bV.bM.setText(this.bU.cP());
            this.bV.bM.setEnabled(true);
            this.bV.bN.setSelected(this.bU.cQ());
            this.bV.bN.setEnabled(true);
            this.bV.bO.m(this.bU.cR());
            this.bV.bO.setEnabled(true);
            this.bV.bP.m(this.bU.cS());
            this.bV.bP.setEnabled(true);
        }
    }
    
    @Override
    public Object getSelectedItem() {
        return this.bU;
    }
}
