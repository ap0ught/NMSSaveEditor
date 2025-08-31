// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class gf
{
    final eY nj;
    final /* synthetic */ ge nk;
    
    private gf(final ge nk, final eY nj) {
        this.nk = nk;
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
    
    public List cI() {
        final ArrayList list = new ArrayList();
        final Iterator iterator = gV.G(this.nj).iterator();
        while (iterator.hasNext()) {
            list.add(new gg(this, (eY)iterator.next()));
        }
        return list;
    }
    
    public boolean a(final gg gg) {
        return gV.a(this.nj, gg.nl);
    }
    
    @Override
    public String toString() {
        return this.nj.getValueAsString("Name");
    }
}
