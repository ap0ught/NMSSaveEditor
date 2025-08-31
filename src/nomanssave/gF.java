// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gF implements gQ
{
    private final eY kM;
    final /* synthetic */ gE rf;
    
    private gF(final gE rf, final eY km) {
        this.rf = rf;
        this.kM = km;
    }
    
    public boolean isValid() {
        final String valueAsString = this.kM.getValueAsString("ElementId");
        return valueAsString != null && valueAsString.length() > 1;
    }
    
    @Override
    public String getType() {
        return "Product";
    }
    
    @Override
    public Object dz() {
        return this.kM.getValue("ElementId");
    }
    
    @Override
    public void m(final Object o) {
        this.kM.b("ElementId", o);
        this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
    }
    
    @Override
    public int dA() {
        return this.kM.J("Amount");
    }
    
    @Override
    public void aA(final int i) {
        this.kM.b("Amount", i);
        this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
    }
    
    @Override
    public int dB() {
        return 999;
    }
}
