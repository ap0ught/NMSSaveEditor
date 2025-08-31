// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class fB extends fH implements fr
{
    final /* synthetic */ fA ma;
    
    fB(final fA ma) {
        this.ma = ma;
        super(ma, "savedata00.hg", true);
    }
    
    @Override
    public eY M() {
        return a(this.readBytes(), eG.jW);
    }
    
    @Override
    public void k(final eY ey) {
        this.a("ps4_accountdata", null, null, null);
        this.writeBytes(g(ey));
    }
}
