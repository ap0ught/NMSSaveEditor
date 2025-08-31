// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum aI
{
    cN("Light", 0, "Light"), 
    cO("Dark", 1, "Dark"), 
    cP("IntelliJ", 2, "IntelliJ"), 
    cQ("Darcula", 3, "Darcula"), 
    cR("MacLight", 4, "macOS Light"), 
    cS("MacDark", 5, "macOS Dark");
    
    final String cT;
    
    static {
        cU = new aI[] { aI.cN, aI.cO, aI.cP, aI.cQ, aI.cR, aI.cS };
    }
    
    private aI(final String name, final int ordinal, final String ct) {
        this.cT = ct;
    }
    
    @Override
    public String toString() {
        return this.cT;
    }
}
