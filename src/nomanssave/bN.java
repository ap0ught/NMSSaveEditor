// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JComponent;

class bN extends ba
{
    final /* synthetic */ bE ey;
    
    bN(final bE ey) {
        this.ey = ey;
        super(new int[] { aH.cJ, 0 });
    }
    
    void a(final String s, final gs gs) {
        this.a(s, gs, true, null);
    }
    
    void a(final String s, final gs gs, final boolean b, final String toolTipText) {
        final bJ bj = new bJ(this.ey, gs, b);
        if (toolTipText != null) {
            bj.setToolTipText(toolTipText);
        }
        this.a(s, (JComponent)bj);
    }
    
    void a(final String s, final bK bk) {
        this.a(s, bk, true, null);
    }
    
    void a(final String s, final bK bk, final boolean b, final String toolTipText) {
        final bL bl = new bL(this.ey, bk, b);
        if (toolTipText != null) {
            bl.setToolTipText(toolTipText);
        }
        this.a(s, bl);
    }
}
