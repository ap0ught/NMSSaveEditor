// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Comparator;
import java.io.FileFilter;
import java.util.ArrayList;

class fN implements ft
{
    final int lT;
    final /* synthetic */ fJ mt;
    
    fN(final fJ mt, final int lt) {
        this.mt = mt;
        this.lT = lt;
    }
    
    @Override
    public int getIndex() {
        return this.lT;
    }
    
    @Override
    public boolean isEmpty() {
        return this.mt.ms[this.lT * 2] == null && this.mt.ms[this.lT * 2 + 1] == null;
    }
    
    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        final ArrayList list = new ArrayList();
        if (this.mt.ms[this.lT * 2] != null) {
            list.add(this.mt.ms[this.lT * 2]);
        }
        if (this.mt.ms[this.lT * 2 + 1] != null) {
            list.add(this.mt.ms[this.lT * 2 + 1]);
        }
        aH.cG.listFiles(new fO(this, list));
        list.sort(new fP(this));
        return list.toArray(new fs[0]);
    }
    
    @Override
    public fn L() {
        long lastModified = Long.MIN_VALUE;
        fn fn = null;
        if (this.mt.ms[this.lT * 2] != null) {
            fn = this.mt.ms[this.lT * 2].L();
            lastModified = this.mt.ms[this.lT * 2].lastModified();
        }
        if (this.mt.ms[this.lT * 2 + 1] != null && this.mt.ms[this.lT * 2 + 1].lastModified() > lastModified) {
            fn = this.mt.ms[this.lT * 2 + 1].L();
        }
        return fn;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Slot " + (this.lT + 1) + " - ");
        long lastModified = Long.MIN_VALUE;
        String str = null;
        Enum enum1 = null;
        if (this.mt.ms[this.lT * 2] != null) {
            enum1 = this.mt.ms[this.lT * 2].L();
            lastModified = this.mt.ms[this.lT * 2].lastModified();
            str = this.mt.ms[this.lT * 2].getName();
        }
        if (this.mt.ms[this.lT * 2 + 1] != null) {
            final long lastModified2 = this.mt.ms[this.lT * 2 + 1].lastModified();
            if (lastModified2 > lastModified) {
                enum1 = this.mt.ms[this.lT * 2 + 1].L();
                lastModified = lastModified2;
                str = this.mt.ms[this.lT * 2 + 1].getName();
            }
        }
        if (enum1 != null) {
            sb.append(enum1.toString());
            if (str != null) {
                sb.append(" - " + str);
            }
            else {
                sb.append(" - " + Application.b(lastModified));
            }
        }
        else {
            sb.append("[EMPTY]");
        }
        return sb.toString();
    }
}
