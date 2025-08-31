// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class eW
{
    final eV kE;
    
    public eW() {
        this.kE = new eV();
    }
    
    public eW h(final Object o) {
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        this.kE.e(o);
        return this;
    }
    
    public eV bC() {
        return this.kE;
    }
}
