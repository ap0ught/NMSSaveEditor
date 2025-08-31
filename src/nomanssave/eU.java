// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum eU
{
    kr("TRADERS", 0, "Gek"), 
    ks("WARRIORS", 1, "Vy'keen"), 
    kt("EXPLORERS", 2, "Korvax"), 
    ku("ROBOTS", 3, "Robot"), 
    kv("ATLAS", 4, "Atlas"), 
    kw("DIPLOMATS", 5, "Diplomats"), 
    kx("EXOTICS", 6, "Exotics"), 
    ky("NONE", 7, "None"), 
    kz("BUILDERS", 8, "Autophage");
    
    private String name;
    
    static {
        kA = new eU[] { eU.kr, eU.ks, eU.kt, eU.ku, eU.kv, eU.kw, eU.kx, eU.ky, eU.kz };
    }
    
    private eU(final String name, final int ordinal, final String name2) {
        this.name = name2;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static eU C(final String anObject) {
        eU[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final eU eu = values[i];
            if (eu.name().equals(anObject)) {
                return eu;
            }
        }
        return null;
    }
}
