// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gh
{
    final String name;
    final eY nn;
    final /* synthetic */ ge nk;
    
    private gh(final ge nk, final String name, final eY nn) {
        this.nk = nk;
        this.name = name;
        this.nn = nn;
    }
    
    public gy cJ() {
        return gy.as(this.nn.getValueAsString("ResourceElement.Filename"));
    }
    
    public String cK() {
        return this.nn.d("ResourceElement.Seed").X(1);
    }
    
    public void aa(final String s) {
        this.nn.d("ResourceElement.Seed").a(1, s);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
