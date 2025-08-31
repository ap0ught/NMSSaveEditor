// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gG
{
    rg("Population", 0, 200), 
    rh("Happiness", 1, 100), 
    ri("Production", 2, 1000000), 
    rj("Upkeep", 3, 1000000), 
    rk("Sentinels", 4, 100), 
    rl("Debt", 5, 10000000), 
    rm("Alert", 6, 100);
    
    final int rn;
    
    static {
        ro = new gG[] { gG.rg, gG.rh, gG.ri, gG.rj, gG.rk, gG.rl, gG.rm };
    }
    
    private gG(final String name, final int ordinal, final int rn) {
        this.rn = rn;
    }
    
    public int dY() {
        return this.rn;
    }
}
