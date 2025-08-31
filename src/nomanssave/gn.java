// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gn
{
    final eY nj;
    final /* synthetic */ gm oK;
    
    private gn(final gm ok, final eY nj) {
        this.oK = ok;
        this.nj = nj;
    }
    
    public String cF() {
        final Object value = this.nj.getValue("GalacticAddress");
        if (value instanceof String) {
            return (String)value;
        }
        if (value instanceof Number) {
            return "0x" + Long.toHexString(((Number)value).longValue());
        }
        return null;
    }
    
    public String getName() {
        return this.nj.getValueAsString("Name");
    }
    
    public void setName(final String s) {
        this.nj.b("Name", s);
    }
    
    public int cG() {
        return this.nj.d("Objects").size();
    }
    
    public eY cH() {
        return this.nj;
    }
    
    @Override
    public String toString() {
        return this.nj.getValueAsString("Name");
    }
}
