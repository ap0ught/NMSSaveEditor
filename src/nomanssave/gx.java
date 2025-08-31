// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gx implements gD
{
    qH("STANDARD", 0, "Standard", "MODELS/COMMON/WEAPONS/MULTITOOL/MULTITOOL.SCENE.MBIN"), 
    qI("ROYAL", 1, "Royal", "MODELS/COMMON/WEAPONS/MULTITOOL/ROYALMULTITOOL.SCENE.MBIN"), 
    qJ("SENTINEL", 2, "Sentinel", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOL.SCENE.MBIN"), 
    qK("SENTINELB", 3, "Sentinel B", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOLB.SCENE.MBIN"), 
    qL("SWITCH", 4, "Switch", "MODELS/COMMON/WEAPONS/MULTITOOL/SWITCHMULTITOOL.SCENE.MBIN"), 
    qM("STAFFMULTITOOL", 5, "Staff", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOL.SCENE.MBIN"), 
    qN("STAFFNPCMULTITOOL", 6, "Staff NPC", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFNPCMULTITOOL.SCENE.MBIN"), 
    qO("ATLAS", 7, "Atlas", "MODELS/COMMON/WEAPONS/MULTITOOL/ATLASMULTITOOL.SCENE.MBIN"), 
    qP("ATLAS_STAFF", 8, "Atlas Scepter", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOLATLAS.SCENE.MBIN");
    
    private String name;
    private String filename;
    
    static {
        qQ = new gx[] { gx.qH, gx.qI, gx.qJ, gx.qK, gx.qL, gx.qM, gx.qN, gx.qO, gx.qP };
    }
    
    private gx(final String name, final int ordinal, final String name2, final String filename) {
        this.name = name2;
        this.filename = filename;
    }
    
    @Override
    public String K() {
        return this.filename;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static gx ar(final String s) {
        if (s == null) {
            return null;
        }
        for (int i = 0; i < values().length; ++i) {
            if (s.equals(values()[i].filename)) {
                return values()[i];
            }
        }
        return null;
    }
}
