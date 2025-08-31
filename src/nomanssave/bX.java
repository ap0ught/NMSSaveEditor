// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Container;
import javax.swing.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class bX extends MouseAdapter
{
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;
    
    bX(final bS fk, final int fl, final int fm) {
        this.fk = fk;
        this.fl = fl;
        this.fm = fm;
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (!this.fk.eX.eW.h(this.fl, this.fm) || this.fk.eX.eW.l(this.fl, this.fm)) {
            return;
        }
        final int int1 = UIManager.getInt("Inventory.gridSize");
        final int n = this.fl + (int)Math.floor(mouseEvent.getX() / (double)int1);
        final int n2 = this.fm + (int)Math.floor(mouseEvent.getY() / (double)int1);
        if (n < 0 || n >= this.fk.eX.eW.getWidth()) {
            return;
        }
        if (n2 < 0 || n2 >= this.fk.eX.eW.getHeight()) {
            return;
        }
        if (n == this.fl && n2 == this.fm) {
            return;
        }
        final bS a = this.fk.eX.a(n, n2);
        if (a == null || !a.ao() || a.ap()) {
            return;
        }
        if (mouseEvent.isControlDown()) {
            this.fk.eX.eW.a(this.fl, this.fm, n, n2);
        }
        else {
            this.fk.eX.eW.b(this.fl, this.fm, n, n2);
        }
        this.fk.aq();
        a.aq();
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            final gu f = this.fk.eX.eW.f(this.fl, this.fm);
            if (f != null) {
                cg.a(this.fk.eX, f);
                this.fk.aq();
            }
        }
    }
}
