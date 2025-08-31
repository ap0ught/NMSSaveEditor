// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gy
{
    qR("VYKEEN", 0, "Vy\u2019keen", "Warriors", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCVYKEEN.SCENE.MBIN"), 
    qS("KORVAX", 1, "Korvax", "Explorers", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCKORVAX.SCENE.MBIN"), 
    qT("GEK", 2, "Gek", "Traders", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCGEK.SCENE.MBIN"), 
    qU("FOURTHRACE", 3, "Fourth Race", (String)null, "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCFOURTH.SCENE.MBIN"), 
    qV("VYKEEN_OLD", 4, "Vy\u2019keen (Old)", (String)null, "MODELS/PLANETS/NPCS/WARRIOR/WARRIOR.SCENE.MBIN"), 
    qW("KORVAX_OLD", 5, "Korvax (Old)", (String)null, "MODELS/PLANETS/NPCS/EXPLORER/EXPLORERIPAD.SCENE.MBIN"), 
    qX("GEK_OLD", 6, "Gek (Old)", (String)null, "MODELS/PLANETS/NPCS/LOWERORDER/LOWERORDER.SCENE.MBIN"), 
    qY("FOURTHRACE_OLD", 7, "Fourth Race (Old)", (String)null, "MODELS/PLANETS/NPCS/FOURTHRACE/FOURTHRACE.SCENE.MBIN");
    
    private String name;
    private String qZ;
    private String filename;
    
    static {
        ra = new gy[] { gy.qR, gy.qS, gy.qT, gy.qU, gy.qV, gy.qW, gy.qX, gy.qY };
    }
    
    private gy(final String name, final int ordinal, final String name2, final String qz, final String filename) {
        this.name = name2;
        this.qZ = qz;
        this.filename = filename;
    }
    
    public String K() {
        return this.filename;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static gy as(final String s) {
        for (int i = 0; i < values().length; ++i) {
            if (s.equals(values()[i].filename)) {
                return values()[i];
            }
        }
        return null;
    }
    
    public static gy at(final String s) {
        for (int i = 0; i < values().length; ++i) {
            if (s.equals(values()[i].qZ)) {
                return values()[i];
            }
        }
        return null;
    }
}
