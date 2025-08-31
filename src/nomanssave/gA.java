// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;

public class gA
{
    private final eS rd;
    final /* synthetic */ gz re;
    
    private gA(final gz re, final eS rd) {
        this.re = re;
        this.rd = rd;
    }
    
    public String getID() {
        return this.rd.getID();
    }
    
    public boolean c(final eU eu) {
        for (final String s : this.rd.bw()) {
            if (this.rd.z(s) == eu) {
                return this.re.d(s, eu.ordinal());
            }
        }
        return false;
    }
    
    public void a(final eU eu, final boolean b) {
        for (final String s : this.rd.bw()) {
            if (this.rd.z(s) == eu) {
                this.re.a(s, eu.ordinal(), b);
            }
        }
    }
}
