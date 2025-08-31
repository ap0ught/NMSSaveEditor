// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum go implements gD
{
    oL("TINY", 0, "Tiny", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERTINY_PROC.SCENE.MBIN"), 
    oM("SMALL", 1, "Small", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERSMALL_PROC.SCENE.MBIN"), 
    oN("NORMAL", 2, "Normal", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTER_PROC.SCENE.MBIN"), 
    oO("CAPITAL", 3, "Capital", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/CAPITALFREIGHTER_PROC.SCENE.MBIN"), 
    oP("PIRATE", 4, "Pirate", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/PIRATEFREIGHTER.SCENE.MBIN");
    
    private String name;
    private String filename;
    
    static {
        oQ = new go[] { go.oL, go.oM, go.oN, go.oO, go.oP };
    }
    
    private go(final String name, final int ordinal, final String name2, final String filename) {
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
    
    public static go al(final String s) {
        for (int i = 0; i < values().length; ++i) {
            if (s.equals(values()[i].filename)) {
                return values()[i];
            }
        }
        return null;
    }
}
