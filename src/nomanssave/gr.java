// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gr
{
    pf("COMBAT", 0, "Combat", false), 
    pg("EXPLORATION", 1, "Exploration", false), 
    ph("MINING", 2, "Mining", false), 
    pi("DIPLOMACY", 3, "Diplomacy", false), 
    pj("SUPPORT", 4, "Support", false), 
    pk("NORMANDY", 5, "Normandy", true), 
    pl("DEEPSPACE", 6, "DeepSpace", true), 
    pm("DEEPSPACECOMMON", 7, "DeepSpaceCommon", true), 
    pn("PIRATE", 8, "Pirate", false), 
    po("GHOSTSHIP", 9, "GhostShip", true);
    
    private String name;
    private boolean special;
    
    static {
        pp = new gr[] { gr.pf, gr.pg, gr.ph, gr.pi, gr.pj, gr.pk, gr.pl, gr.pm, gr.pn, gr.po };
    }
    
    private gr(final String name, final int ordinal, final String name2, final boolean special) {
        this.name = name2;
        this.special = special;
    }
    
    public boolean isSpecial() {
        return this.special;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static gr an(final String s) {
        for (int i = 0; i < values().length; ++i) {
            if (s.equalsIgnoreCase(values()[i].name)) {
                return values()[i];
            }
        }
        return null;
    }
}
