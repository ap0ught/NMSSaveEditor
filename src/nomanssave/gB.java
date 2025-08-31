// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gB
{
    private final eY oI;
    
    public static gB x(final eY ey) {
        return new gB(ey);
    }
    
    private gB(final eY oi) {
        this.oI = oi;
    }
    
    public int dU() {
        return this.oI.J("ActiveMultioolIndex");
    }
    
    public void aF(final int n) {
        final eY h = this.oI.H("Multitools[" + n + "]");
        if (h == null || !h.M("Seed[0]")) {
            throw new RuntimeException("Cannot set current multitool");
        }
        this.oI.b("ActiveMultioolIndex", n);
        this.oI.b("WeaponInventory", (Object)h.H("Store").bE());
        this.oI.b("CurrentWeapon.GenerationSeed[1]", h.I("Seed[1]"));
        this.oI.b("CurrentWeapon.Filename", h.getValueAsString("Resource.Filename"));
    }
}
