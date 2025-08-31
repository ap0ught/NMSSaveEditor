// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gC
{
    private final eY oI;
    
    public static gC y(final eY ey) {
        return new gC(ey);
    }
    
    private gC(final eY oi) {
        this.oI = oi;
    }
    
    public int dV() {
        return this.oI.J("PrimaryShip");
    }
    
    public void aG(final int i) {
        this.oI.b("PrimaryShip", i);
    }
    
    public int dM() {
        return this.oI.J("ShipHealth");
    }
    
    public void aB(final int value) {
        this.oI.b("ShipHealth", new Integer(value));
    }
    
    public int dN() {
        return this.oI.J("ShipShield");
    }
    
    public void aC(final int value) {
        this.oI.b("ShipShield", new Integer(value));
    }
}
