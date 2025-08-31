// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;

class fD extends fH implements fs
{
    final int lO;
    fn me;
    final /* synthetic */ fA ma;
    
    fD(final fA ma, final int lo) {
        this.ma = ma;
        super(ma, "savedata" + ((lo < 8) ? "0" : "") + Integer.toString(lo + 2) + ".hg", true);
        this.lO = lo;
        try {
            this.me = fn.T(new String(this.ah(65536)));
        }
        catch (final IOException ex) {
            hc.a("Could not read game mode from " + this.mh.getName(), ex);
        }
    }
    
    fD(final fA ma, final int lo, final byte[] lk, final eY ey) {
        this.ma = ma;
        super(ma, "savedata" + ((lo < 8) ? "0" : "") + Integer.toString(lo + 2) + ".hg", false);
        this.lO = lo;
        this.lK = lk;
        this.me = fn.i(ey);
        this.writeBytes(g(ey));
    }
    
    @Override
    public fn L() {
        return this.me;
    }
    
    @Override
    public eY M() {
        return a(this.readBytes(), eG.jV);
    }
    
    @Override
    public String b(final eY ey) {
        this.a((this.lO == 0) ? "ps4_backup" : ("ps4_backup" + (this.lO + 1)), this.me, this.getName(), this.getDescription());
        this.writeBytes(g(ey));
        return this.K();
    }
    
    @Override
    public long lastModified() {
        return this.mh.lastModified();
    }
    
    @Override
    public String toString() {
        return this.K();
    }
}
