// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gs
{
    pq("TRA_STANDING", 0, "^TRA_STANDING", "Gek Standing"), 
    pr("TDONE_MISSIONS", 1, "^TDONE_MISSIONS", "Gek Missions"), 
    ps("TSEEN_SYSTEMS", 2, "^TSEEN_SYSTEMS", "Gek Systems"), 
    pt("TGUILD_STAND", 3, "^TGUILD_STAND", "Traders Guild Standing"), 
    pu("TGDONE_MISSIONS", 4, "^TGDONE_MISSIONS", "Traders Guild Missions"), 
    pv("PLANTS_PLANTED", 5, "^PLANTS_PLANTED", "Plants Farmed"), 
    pw("WAR_STANDING", 6, "^WAR_STANDING", "Vy'keen Standing"), 
    px("WDONE_MISSIONS", 7, "^WDONE_MISSIONS", "Vy'keen Missions"), 
    py("WSEEN_SYSTEMS", 8, "^WSEEN_SYSTEMS", "Vy'keen Systems"), 
    pz("WGUILD_STAND", 9, "^WGUILD_STAND", "Warriors Guild Standing"), 
    pA("WGDONE_MISSIONS", 10, "^WGDONE_MISSIONS", "Warriors Guild Missions"), 
    pB("EXP_STANDING", 11, "^EXP_STANDING", "Korvax Standing"), 
    pC("EDONE_MISSIONS", 12, "^EDONE_MISSIONS", "Korvax Missions"), 
    pD("ESEEN_SYSTEMS", 13, "^ESEEN_SYSTEMS", "Korvax Systems"), 
    pE("EGUILD_STAND", 14, "^EGUILD_STAND", "Explorers Guild Standing"), 
    pF("EGDONE_MISSIONS", 15, "^EGDONE_MISSIONS", "Explorers Guild Missions"), 
    pG("RARE_SCANNED", 16, "^RARE_SCANNED", "Rare Creatures Scanned"), 
    pH("PREDS_KILLED", 17, "^PREDS_KILLED", "Predators Killed"), 
    pI("DRONES_KILLED", 18, "^DRONES_KILLED", "Drones Killed"), 
    pJ("WALKERS_KILLED", 19, "^WALKERS_KILLED", "Walkers Killed"), 
    pK("QUADS_KILLED", 20, "^QUADS_KILLED", "Quads Killed"), 
    pL("PIRATES_KILLED", 21, "^PIRATES_KILLED", "Pirates Killed"), 
    pM("POLICE_KILLED", 22, "^POLICE_KILLED", "Police Killed"), 
    pN("DIST_WALKED", 23, "^DIST_WALKED", "Distance Walked"), 
    pO("ALIENS_MET", 24, "^ALIENS_MET", "Aliens Met"), 
    pP("WORDS_LEARNT", 25, "^WORDS_LEARNT", "Words Learnt"), 
    pQ("MONEY", 26, "^MONEY", "Money"), 
    pR("ENEMIES_KILLED", 27, "^ENEMIES_KILLED", "Ships Destroyed"), 
    pS("SENTINEL_KILLS", 28, "^SENTINEL_KILLS", "Sentinels Destroyed"), 
    pT("DIST_WARP", 29, "^DIST_WARP", "Distance Warped"), 
    pU("DISC_ALL_CREATU", 30, "^DISC_ALL_CREATU", "Planet Zoology Scanned");
    
    final String id;
    final String name;
    
    static {
        pV = new gs[] { gs.pq, gs.pr, gs.ps, gs.pt, gs.pu, gs.pv, gs.pw, gs.px, gs.py, gs.pz, gs.pA, gs.pB, gs.pC, gs.pD, gs.pE, gs.pF, gs.pG, gs.pH, gs.pI, gs.pJ, gs.pK, gs.pL, gs.pM, gs.pN, gs.pO, gs.pP, gs.pQ, gs.pR, gs.pS, gs.pT, gs.pU };
    }
    
    private gs(final String name, final int ordinal, final String id, final String name2) {
        this.id = id;
        this.name = name2;
    }
    
    public String getID() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
