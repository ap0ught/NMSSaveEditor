// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum eB
{
    jN("TECHNOLOGY", 0, "Technology"), 
    jO("PRODUCT", 1, "Product"), 
    jP("SUBSTANCE", 2, "Substance"), 
    jQ("TECHBOX", 3, "TechBox");
    
    private String name;
    
    static {
        jR = new eB[] { eB.jN, eB.jO, eB.jP, eB.jQ };
    }
    
    private eB(final String name, final int ordinal, final String name2) {
        this.name = name2;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
