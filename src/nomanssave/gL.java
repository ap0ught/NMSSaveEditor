// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gL implements gD
{
    rs("HAULER", 0, "Hauler", "MODELS/COMMON/SPACECRAFT/DROPSHIPS/DROPSHIP_PROC.SCENE.MBIN", 4), 
    rt("EXPLORER", 1, "Explorer", "MODELS/COMMON/SPACECRAFT/SCIENTIFIC/SCIENTIFIC_PROC.SCENE.MBIN", 4), 
    ru("SHUTTLE", 2, "Shuttle", "MODELS/COMMON/SPACECRAFT/SHUTTLE/SHUTTLE_PROC.SCENE.MBIN", 4), 
    rv("FIGHTER", 3, "Fighter", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTER_PROC.SCENE.MBIN", 4), 
    rw("EXOTIC", 4, "Exotic", "MODELS/COMMON/SPACECRAFT/S-CLASS/S-CLASS_PROC.SCENE.MBIN", 4), 
    rx("LIVING", 5, "Living", "MODELS/COMMON/SPACECRAFT/S-CLASS/BIOPARTS/BIOSHIP_PROC.SCENE.MBIN", 64), 
    ry("SOLAR", 6, "Solar", "MODELS/COMMON/SPACECRAFT/SAILSHIP/SAILSHIP_PROC.SCENE.MBIN", 4), 
    rz("UTOPIA", 7, "Utopia Speeder", "MODELS/COMMON/SPACECRAFT/FIGHTERS/VRSPEEDER.SCENE.MBIN", 4), 
    rA("GOLDEN_VECTOR", 8, "Golden Vector", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERCLASSICGOLD.SCENE.MBIN", 4), 
    rB("HORIZON_VECTOR", 9, "Horizon Vector NX (Switch)", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERSPECIALSWITCH.SCENE.MBIN", 4), 
    rC("ROBOTSHIP", 10, "Robot", "MODELS/COMMON/SPACECRAFT/SENTINELSHIP/SENTINELSHIP_PROC.SCENE.MBIN", 256), 
    rD("STARBORN", 11, "Starborn Runner", "MODELS/COMMON/SPACECRAFT/FIGHTERS/WRACER.SCENE.MBIN", 4), 
    rE("CORVETTE", 12, "Corvette", "MODELS/COMMON/SPACECRAFT/BIGGS/BIGGS.SCENE.MBIN", 4);
    
    private String name;
    private String filename;
    private int rF;
    
    static {
        rG = new gL[] { gL.rs, gL.rt, gL.ru, gL.rv, gL.rw, gL.rx, gL.ry, gL.rz, gL.rA, gL.rB, gL.rC, gL.rD, gL.rE };
    }
    
    private gL(final String name, final int ordinal, final String name2, final String filename, final int rf) {
        this.name = name2;
        this.filename = filename;
        this.rF = rf;
    }
    
    @Override
    public String K() {
        return this.filename;
    }
    
    public int ea() {
        return this.rF;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static gL aw(final String s) {
        for (int i = 0; i < values().length; ++i) {
            if (s.equals(values()[i].filename)) {
                return values()[i];
            }
        }
        return null;
    }
}
