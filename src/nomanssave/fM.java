// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import java.io.IOException;

class fM extends fQ implements fs
{
    fn me;
    final /* synthetic */ fJ mt;
    
    fM(final fJ mt, final int n) {
        this.mt = mt;
        super(mt, (n == 0) ? "save.hg" : ("save" + (n + 1) + ".hg"), n, true);
        try {
            this.me = fn.T(new String(this.ah(65536)));
        }
        catch (final IOException ex) {
            hc.a("Could not read game mode from " + this.filename, ex);
        }
    }
    
    fM(final fJ mt, final int n, final eY ey) {
        this.mt = mt;
        super(mt, (n == 0) ? "save.hg" : ("save" + (n + 1) + ".hg"), n, false);
        this.me = fn.i(ey);
        this.a(ey, true);
    }
    
    @Override
    public fn L() {
        return this.me;
    }
    
    @Override
    public eY M() {
        return this.a(eG.jV);
    }
    
    void cm() {
        this.a((this.lO == 0) ? "backup" : ("backup" + (this.lO + 1)), this.me, this.getName(), this.getDescription());
        new File(this.mt.lX, this.filename).delete();
        new File(this.mt.lX, "mf_" + this.filename).delete();
    }
    
    @Override
    public String b(final eY ey) {
        this.a((this.lO == 0) ? "backup" : ("backup" + (this.lO + 1)), this.me, this.getName(), this.getDescription());
        this.mx.Y(ey.getValueAsString("CommonStateData.SaveName"));
        this.me = fn.i(ey);
        this.mx.al((int)ey.K("CommonStateData.TotalPlayTime"));
        this.a(ey, true);
        return this.filename;
    }
    
    @Override
    public String toString() {
        return this.filename;
    }
    
    @Override
    public String getName() {
        return this.mx.ck();
    }
    
    @Override
    public String getDescription() {
        return this.mx.getDescription();
    }
}
