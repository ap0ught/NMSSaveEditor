// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gq
{
    oS("COMBAT", 0, "Combat"), 
    oT("EXPLORATION", 1, "Exploration"), 
    oU("MINING", 2, "Industry"), 
    oV("DIPLOMATIC", 3, "Trading"), 
    oW("FUELBURNRATE", 4, "Cost Per Warp"), 
    oX("FUELCAPACITY", 5, "Expedition Fuel Cost", -1), 
    oY("SPEED", 6, "Expedition Duration", -1), 
    oZ("EXTRALOOT", 7, "Loot"), 
    pa("REPAIR", 8, "Repair"), 
    pb("INVULNERABLE", 9, "Damage Reduction"), 
    pc("STEALTH", 10, "Stealth");
    
    private String name;
    private int pd;
    
    static {
        pe = new gq[] { gq.oS, gq.oT, gq.oU, gq.oV, gq.oW, gq.oX, gq.oY, gq.oZ, gq.pa, gq.pb, gq.pc };
    }
    
    private gq(final String s, final int n, final String s2) {
        this(s, n, s2, 1);
    }
    
    private gq(final String name, final int ordinal, final String name2, final int pd) {
        this.name = name2;
        this.pd = pd;
    }
    
    public int di() {
        return this.pd;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
