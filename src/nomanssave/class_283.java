package nomanssave;

// $VF: renamed from: nomanssave.gs
public enum class_283 {
   // $VF: renamed from: pq nomanssave.gs
   field_715("^TRA_STANDING", "Gek Standing"),
   // $VF: renamed from: pr nomanssave.gs
   field_716("^TDONE_MISSIONS", "Gek Missions"),
   // $VF: renamed from: ps nomanssave.gs
   field_717("^TSEEN_SYSTEMS", "Gek Systems"),
   // $VF: renamed from: pt nomanssave.gs
   field_718("^TGUILD_STAND", "Traders Guild Standing"),
   // $VF: renamed from: pu nomanssave.gs
   field_719("^TGDONE_MISSIONS", "Traders Guild Missions"),
   // $VF: renamed from: pv nomanssave.gs
   field_720("^PLANTS_PLANTED", "Plants Farmed"),
   // $VF: renamed from: pw nomanssave.gs
   field_721("^WAR_STANDING", "Vy'keen Standing"),
   // $VF: renamed from: px nomanssave.gs
   field_722("^WDONE_MISSIONS", "Vy'keen Missions"),
   // $VF: renamed from: py nomanssave.gs
   field_723("^WSEEN_SYSTEMS", "Vy'keen Systems"),
   // $VF: renamed from: pz nomanssave.gs
   field_724("^WGUILD_STAND", "Warriors Guild Standing"),
   // $VF: renamed from: pA nomanssave.gs
   field_725("^WGDONE_MISSIONS", "Warriors Guild Missions"),
   // $VF: renamed from: pB nomanssave.gs
   field_726("^EXP_STANDING", "Korvax Standing"),
   // $VF: renamed from: pC nomanssave.gs
   field_727("^EDONE_MISSIONS", "Korvax Missions"),
   // $VF: renamed from: pD nomanssave.gs
   field_728("^ESEEN_SYSTEMS", "Korvax Systems"),
   // $VF: renamed from: pE nomanssave.gs
   field_729("^EGUILD_STAND", "Explorers Guild Standing"),
   // $VF: renamed from: pF nomanssave.gs
   field_730("^EGDONE_MISSIONS", "Explorers Guild Missions"),
   // $VF: renamed from: pG nomanssave.gs
   field_731("^RARE_SCANNED", "Rare Creatures Scanned"),
   // $VF: renamed from: pH nomanssave.gs
   field_732("^PREDS_KILLED", "Predators Killed"),
   // $VF: renamed from: pI nomanssave.gs
   field_733("^DRONES_KILLED", "Drones Killed"),
   // $VF: renamed from: pJ nomanssave.gs
   field_734("^WALKERS_KILLED", "Walkers Killed"),
   // $VF: renamed from: pK nomanssave.gs
   field_735("^QUADS_KILLED", "Quads Killed"),
   // $VF: renamed from: pL nomanssave.gs
   field_736("^PIRATES_KILLED", "Pirates Killed"),
   // $VF: renamed from: pM nomanssave.gs
   field_737("^POLICE_KILLED", "Police Killed"),
   // $VF: renamed from: pN nomanssave.gs
   field_738("^DIST_WALKED", "Distance Walked"),
   // $VF: renamed from: pO nomanssave.gs
   field_739("^ALIENS_MET", "Aliens Met"),
   // $VF: renamed from: pP nomanssave.gs
   field_740("^WORDS_LEARNT", "Words Learnt"),
   // $VF: renamed from: pQ nomanssave.gs
   field_741("^MONEY", "Money"),
   // $VF: renamed from: pR nomanssave.gs
   field_742("^ENEMIES_KILLED", "Ships Destroyed"),
   // $VF: renamed from: pS nomanssave.gs
   field_743("^SENTINEL_KILLS", "Sentinels Destroyed"),
   // $VF: renamed from: pT nomanssave.gs
   field_744("^DIST_WARP", "Distance Warped"),
   // $VF: renamed from: pU nomanssave.gs
   field_745("^DISC_ALL_CREATU", "Planet Zoology Scanned");

   // $VF: renamed from: id java.lang.String
   final String field_746;
   final String name;

   private class_283(String var3, String var4) {
      this.field_746 = var3;
      this.name = var4;
   }

   public String getID() {
      return this.field_746;
   }

   @Override
   public String toString() {
      return this.name;
   }
}
