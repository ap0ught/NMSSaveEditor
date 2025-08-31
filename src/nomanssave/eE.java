// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.util.ArrayList;

class eE extends ArrayList
{
    private eE() {
    }
    
    public boolean add(final String s, final String s2) {
        return this.add(new eF(s, s2));
    }
    
    public boolean s(final String s) {
        if (this.size() == 0) {
            return false;
        }
        final eF ef = this.get(0);
        return ef.key.equals(s) || ef.name.equals(s);
    }
    
    public eF t(final String anObject) {
        for (final eF ef : this) {
            if (ef.key.equals(anObject)) {
                return ef;
            }
        }
        return null;
    }
    
    public eF u(final String anObject) {
        for (final eF ef : this) {
            if (ef.name.equals(anObject)) {
                return ef;
            }
        }
        return null;
    }
    
    public eF v(final String anotherString) {
        for (final eF ef : this) {
            if (ef.name.equalsIgnoreCase(anotherString)) {
                return ef;
            }
        }
        return null;
    }
}
