package nomanssave;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

// $VF: renamed from: nomanssave.bE
public class class_362 extends JPanel {
   // $VF: renamed from: ew int
   private static final int field_1242 = 0;
   private static final int TYPE_DOUBLE = 1;
   // $VF: renamed from: ex nomanssave.bN[]
   private final class_361[] field_1243 = new class_361[3];
   // $VF: renamed from: cp nomanssave.gz
   private class_38 field_1244;

   class_362(Application var1) {
      GridLayout var2 = new GridLayout(1, 3, 10, 0);
      this.setLayout(var2);
      this.field_1243[0] = new class_361(this);
      this.add(this.field_1243[0]);
      this.field_1243[1] = new class_361(this);
      this.add(this.field_1243[1]);
      this.field_1243[2] = new class_361(this);
      this.add(this.field_1243[2]);
      this.field_1243[0].a("Milestones", Application.method_1325("UI-MILESTONES.PNG", 32, 32));
      this.field_1243[0].method_1163("On Foot Exploration", class_283.field_738);
      this.field_1243[0].method_1163("Alien Colonist Encounters", class_283.field_739);
      this.field_1243[0].method_1164("Words Collected", class_283.field_740, false, "See Discovery tab for more details");
      this.field_1243[0].method_1163("Most Units Accrued", class_283.field_741);
      this.field_1243[0].method_1164("Ships Destroyed", class_283.field_742, false, "See Kills section for more details");
      this.field_1243[0].method_1164("Sentinels Destroyed", class_283.field_743, false, "See Kills section for more details");
      this.field_1243[0].method_1165("Extreme Survival", new class_250(this));
      this.field_1243[0].method_1163("Space Exploration (Warps)", class_283.field_744);
      this.field_1243[0].method_1163("Planet Zoology Scanned", class_283.field_745);
      this.field_1243[0].a("Kills", Application.method_1325("UI-CREATURES.PNG", 32, 32));
      this.field_1243[0].method_1163("Predators", class_283.field_732);
      this.field_1243[0].method_1163("Sentinel Drones", class_283.field_733);
      this.field_1243[0].method_1163("Sentinel Quads", class_283.field_735);
      this.field_1243[0].method_1163("Sentinel Walkers", class_283.field_734);
      this.field_1243[0].method_1163("Pirates", class_283.field_736);
      this.field_1243[0].method_1163("Police", class_283.field_737);
      this.field_1243[1].a("Gek", Application.method_1325("UI-GEK.PNG", 32, 32));
      this.field_1243[1].method_1163("Standing", class_283.field_715);
      this.field_1243[1].method_1163("Missions Completed", class_283.field_716);
      this.field_1243[1].method_1166("Words Learned", new class_249(this), false, "See Discovery tab for more details");
      this.field_1243[1].method_1163("Systems Visited", class_283.field_717);
      this.field_1243[1].a("Vy'keen", Application.method_1325("UI-VYKEEN.PNG", 32, 32));
      this.field_1243[1].method_1163("Standing", class_283.field_721);
      this.field_1243[1].method_1163("Missions Completed", class_283.field_722);
      this.field_1243[1].method_1166("Words Learned", new class_248(this), false, "See Discovery tab for more details");
      this.field_1243[1].method_1163("Systems Visited", class_283.field_723);
      this.field_1243[1].a("Korvax", Application.method_1325("UI-KORVAX.PNG", 32, 32));
      this.field_1243[1].method_1163("Standing", class_283.field_726);
      this.field_1243[1].method_1163("Missions Completed", class_283.field_727);
      this.field_1243[1].method_1166("Words Learned", new class_247(this), false, "See Discovery tab for more details");
      this.field_1243[1].method_1163("Systems Visited", class_283.field_728);
      this.field_1243[2].a("Traders", Application.method_1325("UI-TRADERS.PNG", 32, 32));
      this.field_1243[2].method_1163("Standing", class_283.field_718);
      this.field_1243[2].method_1163("Missions Completed", class_283.field_719);
      this.field_1243[2].method_1163("Plants Farmed", class_283.field_720);
      this.field_1243[2].method_1164("Units Earned", class_283.field_741, false, "See Milestones section for more details");
      this.field_1243[2].a("Warriors", Application.method_1325("UI-WARRIORS.PNG", 32, 32));
      this.field_1243[2].method_1163("Standing", class_283.field_724);
      this.field_1243[2].method_1163("Missions Completed", class_283.field_725);
      this.field_1243[2].method_1164("Sentinels Destroyed", class_283.field_743, false, "See Kills section for more details");
      this.field_1243[2].method_1164("Pirates Killed", class_283.field_742, false, "See Kills section for more details");
      this.field_1243[2].a("Explorers", Application.method_1325("UI-EXPLORERS.PNG", 32, 32));
      this.field_1243[2].method_1163("Standing", class_283.field_729);
      this.field_1243[2].method_1163("Missions Completed", class_283.field_730);
      this.field_1243[2].method_1163("Rare Creatures Scanned", class_283.field_731);
      this.field_1243[2].method_1164("Distance Warped", class_283.field_744, false, "See Milestones section for more details");
   }

   // $VF: renamed from: B () void
   void method_1167() {
      int var1 = this.field_1244.method_181();
      this.field_1244.method_189(class_283.field_740, var1);
      this.method_1170(class_283.field_740, Integer.toString(var1));
   }

   // $VF: renamed from: C () void
   void method_1168() {
      long var1 = this.field_1244.method_163();
      int var3 = this.field_1244.method_188(class_283.field_741);
      if ((long)var3 < var1) {
         var3 = (int)Math.min(var1, 2147483647L);
         this.field_1244.method_189(class_283.field_741, var3);
         this.method_1170(class_283.field_741, Integer.toString(var3));
      }
   }

   // $VF: renamed from: aa () void
   void method_1169() {
      for (int var2 = 0; var2 < this.field_1243.length; var2++) {
         for (int var3 = 0; var3 < this.field_1243[var2].getComponentCount(); var3++) {
            Component var1 = this.field_1243[var2].getComponent(var3);
            if (var1 instanceof class_373 && ((class_373)var1).field_1357.isSpecial()) {
               ((class_373)var1).method_1311();
            }
         }
      }
   }

   // $VF: renamed from: a (nomanssave.gs, java.lang.String) void
   private void method_1170(class_283 var1, String var2) {
      for (int var4 = 0; var4 < this.field_1243.length; var4++) {
         for (int var5 = 0; var5 < this.field_1243[var4].getComponentCount(); var5++) {
            Component var3 = this.field_1243[var4].getComponent(var5);
            if (var3 instanceof class_408 && ((class_408)var3).field_1396 == var1) {
               ((class_408)var3).setText(var2);
            }
         }
      }
   }

   // $VF: renamed from: a (nomanssave.gz) void
   void method_1171(class_38 var1) {
      this.field_1244 = var1;

      for (int var3 = 0; var3 < this.field_1243.length; var3++) {
         for (int var4 = 0; var4 < this.field_1243[var3].getComponentCount(); var4++) {
            Component var2 = this.field_1243[var3].getComponent(var4);
            if (var2 instanceof class_408) {
               ((class_408)var2).method_1316();
            } else if (var2 instanceof class_373) {
               ((class_373)var2).method_1311();
            }
         }
      }
   }
}
