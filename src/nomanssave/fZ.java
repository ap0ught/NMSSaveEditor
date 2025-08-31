// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Comparator;
import java.io.FileFilter;
import java.util.ArrayList;

class fZ implements ft
{
    final int lT;
    final /* synthetic */ fT mN;
    
    fZ(final fT mn, final int lt) {
        this.mN = mn;
        this.lT = lt;
    }
    
    @Override
    public int getIndex() {
        return this.lT;
    }
    
    @Override
    public boolean isEmpty() {
        return this.mN.mE[this.lT * 2] == null && this.mN.mE[this.lT * 2 + 1] == null;
    }
    
    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        final ArrayList list = new ArrayList();
        if (this.mN.mE[this.lT * 2] != null) {
            list.add(this.mN.mE[this.lT * 2]);
        }
        if (this.mN.mE[this.lT * 2 + 1] != null) {
            list.add(this.mN.mE[this.lT * 2 + 1]);
        }
        aH.cG.listFiles(new ga(this, list));
        list.sort(new gb(this));
        return list.toArray(new fs[0]);
    }
    
    @Override
    public fn L() {
        long lastModified = Long.MIN_VALUE;
        fn fn = null;
        if (this.mN.mE[this.lT * 2] != null) {
            fn = this.mN.mE[this.lT * 2].L();
            lastModified = this.mN.mE[this.lT * 2].lastModified();
        }
        if (this.mN.mE[this.lT * 2 + 1] != null && this.mN.mE[this.lT * 2 + 1].lastModified() > lastModified) {
            fn = this.mN.mE[this.lT * 2 + 1].L();
        }
        return fn;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Slot " + (this.lT + 1) + " - ");
        long lastModified = Long.MIN_VALUE;
        Enum enum1 = null;
        if (this.mN.mE[this.lT * 2] != null) {
            enum1 = this.mN.mE[this.lT * 2].L();
            lastModified = this.mN.mE[this.lT * 2].lastModified();
        }
        if (this.mN.mE[this.lT * 2 + 1] != null) {
            final long lastModified2 = this.mN.mE[this.lT * 2 + 1].lastModified();
            if (lastModified2 > lastModified) {
                enum1 = this.mN.mE[this.lT * 2 + 1].L();
                lastModified = lastModified2;
            }
        }
        if (enum1 != null) {
            sb.append(enum1.toString());
            sb.append(" - " + Application.b(lastModified));
        }
        else {
            sb.append("[EMPTY]");
        }
        return sb.toString();
    }
}
