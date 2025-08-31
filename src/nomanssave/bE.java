// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class bE extends JPanel
{
    private static final int ew = 0;
    private static final int TYPE_DOUBLE = 1;
    private final bN[] ex;
    private gz cp;
    
    bE(final Application application) {
        this.ex = new bN[3];
        this.setLayout(new GridLayout(1, 3, 10, 0));
        this.add(this.ex[0] = new bN(this));
        this.add(this.ex[1] = new bN(this));
        this.add(this.ex[2] = new bN(this));
        this.ex[0].a("Milestones", Application.a("UI-MILESTONES.PNG", 32, 32));
        this.ex[0].a("On Foot Exploration", gs.pN);
        this.ex[0].a("Alien Colonist Encounters", gs.pO);
        this.ex[0].a("Words Collected", gs.pP, false, "See Discovery tab for more details");
        this.ex[0].a("Most Units Accrued", gs.pQ);
        this.ex[0].a("Ships Destroyed", gs.pR, false, "See Kills section for more details");
        this.ex[0].a("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
        this.ex[0].a("Extreme Survival", new bF(this));
        this.ex[0].a("Space Exploration (Warps)", gs.pT);
        this.ex[0].a("Planet Zoology Scanned", gs.pU);
        this.ex[0].a("Kills", Application.a("UI-CREATURES.PNG", 32, 32));
        this.ex[0].a("Predators", gs.pH);
        this.ex[0].a("Sentinel Drones", gs.pI);
        this.ex[0].a("Sentinel Quads", gs.pK);
        this.ex[0].a("Sentinel Walkers", gs.pJ);
        this.ex[0].a("Pirates", gs.pL);
        this.ex[0].a("Police", gs.pM);
        this.ex[1].a("Gek", Application.a("UI-GEK.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pq);
        this.ex[1].a("Missions Completed", gs.pr);
        this.ex[1].a("Words Learned", new bG(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.ps);
        this.ex[1].a("Vy'keen", Application.a("UI-VYKEEN.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pw);
        this.ex[1].a("Missions Completed", gs.px);
        this.ex[1].a("Words Learned", new bH(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.py);
        this.ex[1].a("Korvax", Application.a("UI-KORVAX.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pB);
        this.ex[1].a("Missions Completed", gs.pC);
        this.ex[1].a("Words Learned", new bI(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.pD);
        this.ex[2].a("Traders", Application.a("UI-TRADERS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pt);
        this.ex[2].a("Missions Completed", gs.pu);
        this.ex[2].a("Plants Farmed", gs.pv);
        this.ex[2].a("Units Earned", gs.pQ, false, "See Milestones section for more details");
        this.ex[2].a("Warriors", Application.a("UI-WARRIORS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pz);
        this.ex[2].a("Missions Completed", gs.pA);
        this.ex[2].a("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
        this.ex[2].a("Pirates Killed", gs.pR, false, "See Kills section for more details");
        this.ex[2].a("Explorers", Application.a("UI-EXPLORERS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pE);
        this.ex[2].a("Missions Completed", gs.pF);
        this.ex[2].a("Rare Creatures Scanned", gs.pG);
        this.ex[2].a("Distance Warped", gs.pT, false, "See Milestones section for more details");
    }
    
    void B() {
        final int bx = this.cp.bx();
        this.cp.a(gs.pP, bx);
        this.a(gs.pP, Integer.toString(bx));
    }
    
    void C() {
        final long dj = this.cp.dJ();
        if (this.cp.a(gs.pQ) < dj) {
            final int i = (int)Math.min(dj, 2147483647L);
            this.cp.a(gs.pQ, i);
            this.a(gs.pQ, Integer.toString(i));
        }
    }
    
    void aa() {
        for (int i = 0; i < this.ex.length; ++i) {
            for (int j = 0; j < this.ex[i].getComponentCount(); ++j) {
                final Component component = this.ex[i].getComponent(j);
                if (component instanceof bL && ((bL)component).eB.isSpecial()) {
                    ((bL)component).ac();
                }
            }
        }
    }
    
    private void a(final gs gs, final String text) {
        for (int i = 0; i < this.ex.length; ++i) {
            for (int j = 0; j < this.ex[i].getComponentCount(); ++j) {
                final Component component = this.ex[i].getComponent(j);
                if (component instanceof bJ && ((bJ)component).ez == gs) {
                    ((bJ)component).setText(text);
                }
            }
        }
    }
    
    void a(final gz cp) {
        this.cp = cp;
        for (int i = 0; i < this.ex.length; ++i) {
            for (int j = 0; j < this.ex[i].getComponentCount(); ++j) {
                final Component component = this.ex[i].getComponent(j);
                if (component instanceof bJ) {
                    ((bJ)component).ac();
                }
                else if (component instanceof bL) {
                    ((bL)component).ac();
                }
            }
        }
    }
}
