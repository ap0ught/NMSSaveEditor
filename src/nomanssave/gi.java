// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public enum gi
{
    no("Lush", 0), 
    np("Toxic", 1), 
    nq("Scorched", 2), 
    nr("Radioactive", 3), 
    ns("Frozen", 4), 
    nt("Barren", 5), 
    nu("Dead", 6), 
    nv("Weird", 7), 
    nw("Red", 8), 
    nx("Green", 9), 
    ny("Blue", 10), 
    nz("Test", 11), 
    nA("Swamp", 12), 
    nB("Lava", 13), 
    nC("Waterworld", 14), 
    nD("All", 15);
    
    static {
        nE = new gi[] { gi.no, gi.np, gi.nq, gi.nr, gi.ns, gi.nt, gi.nu, gi.nv, gi.nw, gi.nx, gi.ny, gi.nz, gi.nA, gi.nB, gi.nC, gi.nD };
    }
    
    private gi(final String name, final int ordinal) {
    }
}
