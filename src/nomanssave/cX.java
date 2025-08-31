// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Rectangle;
import javax.swing.text.BadLocationException;

class cX implements Runnable
{
    final /* synthetic */ cW gL;
    
    cX(final cW gl) {
        this.gL = gl;
    }
    
    @Override
    public void run() {
        try {
            final Rectangle modelToView = this.gL.gB.modelToView(this.gL.gB.getDocument().getLength());
            if (modelToView != null && modelToView.y != this.gL.gI) {
                this.gL.aI();
                this.gL.repaint();
                cW.a(this.gL, modelToView.y);
            }
        }
        catch (final BadLocationException ex) {}
    }
}
