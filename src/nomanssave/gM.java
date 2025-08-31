// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gM
{
    private final eV rH;
    private final eY rI;
    private final int index;
    
    public static gM[] D(final eY ey) {
        final eV d = ey.d("SquadronUnlockedPilotSlots");
        final eV d2 = ey.d("SquadronPilots");
        if (d == null || d2 == null) {
            return new gM[0];
        }
        final gM[] array = new gM[Math.min(d.size(), d2.size())];
        for (int i = 0; i < array.length; ++i) {
            array[i] = new gM(d, d2.V(i), i);
        }
        return array;
    }
    
    private gM(final eV rh, final eY ri, final int index) {
        this.rH = rh;
        this.rI = ri;
        this.index = index;
    }
    
    public boolean isEnabled() {
        return this.rH.ab(this.index);
    }
    
    public void setEnabled(final boolean b) {
        this.rH.a(this.index, b);
    }
    
    public boolean isValid() {
        return this.rI.d("NPCResource.Seed").ab(0) && this.rI.d("ShipResource.Seed").ab(0);
    }
    
    public gy ed() {
        return gy.as(this.rI.getValueAsString("NPCResource.Filename"));
    }
    
    public void a(final gy gy) {
        this.rI.b("NPCResource.Filename", gy.K());
    }
    
    public String ee() {
        final eV d = this.rI.d("NPCResource.Seed");
        return d.ab(0) ? d.X(1) : "";
    }
    
    public void ax(final String s) {
        final eV d = this.rI.d("NPCResource.Seed");
        if (s == null || s.length() == 0) {
            d.a(0, false);
            d.a(1, "0x0");
        }
        else {
            d.a(0, true);
            d.a(1, s);
        }
    }
    
    public gL ef() {
        return gL.aw(this.rI.getValueAsString("ShipResource.Filename"));
    }
    
    public void a(final gL gl) {
        this.rI.b("ShipResource.Filename", gl.K());
    }
    
    public String eg() {
        final eV d = this.rI.d("ShipResource.Seed");
        return d.ab(0) ? d.X(1) : "";
    }
    
    public void ay(final String s) {
        final eV d = this.rI.d("ShipResource.Seed");
        if (s == null || s.length() == 0) {
            d.a(0, false);
            d.a(1, "0x0");
        }
        else {
            d.a(0, true);
            d.a(1, s);
        }
    }
    
    public int eh() {
        return this.rI.J("PilotRank");
    }
    
    public void aI(final int i) {
        this.rI.b("PilotRank", i);
    }
    
    @Override
    public String toString() {
        return this.isEnabled() ? (this.isValid() ? ("Wingman " + this.index) : "EMPTY") : "LOCKED";
    }
}
