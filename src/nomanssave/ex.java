// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum ex
{
    iL("FUEL", 0, "Fuel"), 
    iM("METAL", 1, "Metal"), 
    iN("CATALYST", 2, "Catalyst"), 
    iO("STELLAR", 3, "Stellar"), 
    iP("FLORA", 4, "Flora"), 
    iQ("EARTH", 5, "Earth"), 
    iR("EXOTIC", 6, "Exotic"), 
    iS("SPECIAL", 7, "Special"), 
    iT("COMPONENT", 8, "Component"), 
    iU("CONSUMABLE", 9, "Consumable"), 
    iV("TRADEABLE", 10, "Tradeable"), 
    iW("CURIOSITY", 11, "Curiosity"), 
    iX("BUILDING_PART", 12, "Building Part"), 
    iY("PROC_PRODUCT", 13, "Procedural"), 
    iZ("CUSTOMISATION_PART", 14, "Customisation Part"), 
    ja("EMOTE", 15, "Emote"), 
    jb("PET", 16, "Pet"), 
    jc("FISH", 17, "Fish"), 
    jd("TECHBOX", 18, "TechBox"), 
    je("SHIP", 19, "Ship"), 
    jf("WEAPON", 20, "Weapon"), 
    jg("PROC_WEAPON", 21, "Procedural"), 
    jh("SUIT", 22, "Suit"), 
    ji("PROC_SUIT", 23, "Procedural"), 
    jj("PERSONAL", 24, "Personal"), 
    jk("FREIGHTER", 25, "Freighter"), 
    jl("PROC_FREIGHTER", 26, "Procedural"), 
    jm("VEHICLE", 27, "Vehicle"), 
    jn("PROC_VEHICLE", 28, "Procedural"), 
    jo("AQUATIC", 29, "Aquatic"), 
    jp("PROC_AQUATIC", 30, "Procedural"), 
    jq("ALIENSHIP", 31, "Living Ship"), 
    jr("PROC_ALIENSHIP", 32, "Procedural"), 
    js("ALLSHIPS", 33, "All Ships"), 
    jt("ALLVEHICLES", 34, "All Vehicles"), 
    ju("ROBOTSHIP", 35, "Robot Ship"), 
    jv("ALLSHIPSEXCEPTALIEN", 36, "All Ships Except Alien"), 
    jw("PROC_ALLSHIPSEXCEPTALIEN", 37, "Procedural"), 
    jx("MECH", 38, "Mech"), 
    jy("PROC_MECH", 39, "Procedural"), 
    jz("MAINTENANCE", 40, "Maintenance"), 
    jA("CORVETTE", 41, "Corvette"), 
    jB("PROC_CORVETTE", 42, "Procedural");
    
    private String name;
    
    static {
        jC = new ex[] { ex.iL, ex.iM, ex.iN, ex.iO, ex.iP, ex.iQ, ex.iR, ex.iS, ex.iT, ex.iU, ex.iV, ex.iW, ex.iX, ex.iY, ex.iZ, ex.ja, ex.jb, ex.jc, ex.jd, ex.je, ex.jf, ex.jg, ex.jh, ex.ji, ex.jj, ex.jk, ex.jl, ex.jm, ex.jn, ex.jo, ex.jp, ex.jq, ex.jr, ex.js, ex.jt, ex.ju, ex.jv, ex.jw, ex.jx, ex.jy, ex.jz, ex.jA, ex.jB };
    }
    
    private ex(final String name, final int ordinal, final String name2) {
        this.name = name2;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
