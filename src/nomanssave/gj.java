// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;

public class gj
{
    private final gl nF;
    private final int index;
    private final eY bf;
    
    public static boolean n(final eY ey) {
        return ey.d("Pets") != null && ey.d("Eggs") != null;
    }
    
    public static gj[] o(final eY ey) {
        final ArrayList list = new ArrayList();
        final eV d = ey.d("Pets");
        if (d != null) {
            for (int i = 0; i < d.size(); ++i) {
                final eY v = d.V(i);
                if (v.d("CreatureSeed").ab(0)) {
                    list.add(new gj(gl.oF, i, v));
                }
            }
        }
        final eV d2 = ey.d("Eggs");
        if (d2 != null) {
            for (int j = 0; j < d2.size(); ++j) {
                final eY v2 = d2.V(j);
                if (v2.d("CreatureSeed").ab(0)) {
                    list.add(new gj(gl.oG, j, v2));
                }
            }
        }
        return (gj[])list.toArray(new gj[0]);
    }
    
    public static gj a(final eY ey, final File file) {
        eV ev = null;
        gl gl = null;
        if (file.getName().endsWith(".pet")) {
            ev = ey.d("Pets");
            gl = nomanssave.gl.oF;
        }
        if (file.getName().endsWith(".egg")) {
            ev = ey.d("Eggs");
            gl = nomanssave.gl.oG;
        }
        if (ev == null || ev.size() == 0) {
            throw new RuntimeException("Companion cannot be imported to current file!");
        }
        int n = -1;
        for (int i = 0; i < ev.size(); ++i) {
            if (!ev.V(i).d("CreatureSeed").ab(0)) {
                n = i;
                break;
            }
        }
        if (n < 0) {
            throw new RuntimeException("Companion cannot be imported to current file!");
        }
        eY ey2 = gR.az("companion");
        Throwable t = null;
        try {
            final ff ff = new ff(new FileInputStream(file));
            try {
                if (ey2 == null) {
                    ey2 = ff.bK();
                }
                else {
                    ey2.c(ff.bK());
                }
            }
            finally {
                if (ff != null) {
                    ff.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
        final eV d = ey2.d("CreatureSeed");
        if (d == null || !d.ab(0)) {
            throw new RuntimeException("Invalid creature data");
        }
        ev.a(n, ey2);
        return new gj(gl, n, ey2);
    }
    
    private gj(final gl nf, final int index, final eY bf) {
        this.nF = nf;
        this.index = index;
        this.bf = bf;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void cm() {
        this.bf.d("CreatureSeed").a(0, Boolean.FALSE);
        this.bf.d("CreatureSeed").a(1, "0x0");
    }
    
    public void j(final File file) {
        Throwable t = null;
        try {
            final fj fj = new fj(new FileOutputStream(file));
            try {
                fj.h(this.bf.bE());
            }
            finally {
                if (fj != null) {
                    fj.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    public gl cL() {
        return this.nF;
    }
    
    public String getName() {
        return this.bf.getValueAsString("CustomName");
    }
    
    public void setName(final String s) {
        this.bf.b("CustomName", s);
    }
    
    public String cM() {
        return this.bf.getValueAsString("CreatureID");
    }
    
    public String cK() {
        return this.bf.d("CreatureSeed").X(1);
    }
    
    public void aa(final String s) {
        this.bf.d("CreatureSeed").a(1, s);
    }
    
    public String cN() {
        final eV d = this.bf.d("CreatureSecondarySeed");
        return d.ab(0) ? d.X(1) : "";
    }
    
    public void ab(final String s) {
        final eV d = this.bf.d("CreatureSecondarySeed");
        if (s == null || s.length() == 0) {
            d.a(0, false);
            d.a(1, "");
        }
        else {
            d.a(0, true);
            d.a(1, s);
        }
    }
    
    public String cO() {
        return this.bf.I("SpeciesSeed");
    }
    
    public void ac(final String s) {
        this.bf.b("SpeciesSeed", s);
    }
    
    public String cP() {
        return this.bf.I("GenusSeed");
    }
    
    public void ad(final String s) {
        this.bf.b("GenusSeed", s);
    }
    
    public boolean cQ() {
        return this.bf.M("Predator");
    }
    
    public void d(final boolean b) {
        this.bf.b("Predator", b);
    }
    
    public String cR() {
        return this.bf.getValueAsString("Biome.Biome");
    }
    
    public void ae(final String s) {
        this.bf.b("Biome.Biome", s);
    }
    
    public String cS() {
        return this.bf.getValueAsString("CreatureType.CreatureType");
    }
    
    public void af(final String s) {
        this.bf.b("CreatureType.CreatureType", s);
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        return String.valueOf(this.nF.name()) + " [" + this.index + "]";
    }
}
