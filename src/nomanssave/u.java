// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class u implements fR
{
    final /* synthetic */ Application aZ;
    
    u(final Application az) {
        this.aZ = az;
    }
    
    @Override
    public void a(final fq fq) {
        if (!this.aZ.aQ || this.aZ.aF != fq) {
            return;
        }
        Application.a(this.aZ, true);
    }
    
    @Override
    public void a(final fq fq, final int n, final String anObject) {
        if (!this.aZ.aQ || this.aZ.aF != fq) {
            return;
        }
        Application.b(this.aZ, true);
        if (this.aZ.aH >= 0 && this.aZ.aG[this.aZ.aH].getIndex() == n) {
            Application.c(this.aZ, true);
            if (this.aZ.aJ >= 0 && this.aZ.aI[this.aZ.aJ].K().equals(anObject)) {
                Application.d(this.aZ, true);
            }
        }
    }
}
