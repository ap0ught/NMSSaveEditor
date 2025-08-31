// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gu implements gQ
{
    private final eY qD;
    final /* synthetic */ gt qE;
    
    private gu(final gt qe, final eY qd) {
        this.qE = qe;
        this.qD = qd;
    }
    
    @Override
    public String getType() {
        return this.qD.getValueAsString("Type.InventoryType");
    }
    
    @Override
    public Object dz() {
        return this.qD.getValue("Id");
    }
    
    @Override
    public void m(final Object o) {
        this.qD.b("Id", o);
    }
    
    @Override
    public int dA() {
        return this.qD.J("Amount");
    }
    
    @Override
    public void aA(final int value) {
        this.qD.b("Amount", new Integer(value));
    }
    
    @Override
    public int dB() {
        return this.qD.J("MaxAmount");
    }
    
    public double dC() {
        return this.qD.L("DamageFactor");
    }
    
    public void c(final double value) {
        this.qD.b("DamageFactor", new Double(value));
    }
    
    public boolean dD() {
        return this.qD.M("FullyInstalled");
    }
    
    public void e(final boolean value) {
        this.qD.b("FullyInstalled", new Boolean(value));
    }
}
