// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Arrays;
import java.io.IOException;
import java.util.regex.Pattern;
import java.io.File;

public interface fq
{
    public static final int lz = 15;
    
    default String c(long n) {
        final int n2 = (int)(n % 60L);
        n /= 60L;
        final int i = (int)(n % 60L);
        n /= 60L;
        final int j = (int)n;
        final StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(':');
        if (i < 10) {
            sb.append(0);
        }
        sb.append(i);
        return sb.toString();
    }
    
    default String c(final fq fq) {
        if (fq instanceof fJ) {
            return "Steam";
        }
        if (fq instanceof fT) {
            return "Xbox Game Pass";
        }
        if (fq instanceof fA) {
            return "PS4 - Save Wizard";
        }
        return null;
    }
    
    default fq a(final File file, final fR fr) {
        if (!file.exists()) {
            return null;
        }
        try {
            if (file.isDirectory()) {
                if (file.listFiles(file2 -> file2.getName().equalsIgnoreCase("containers.index")).length > 0) {
                    return new fT(file, fr);
                }
                if (file.listFiles(file4 -> file4.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", file4.getName().toLowerCase())).length > 0) {
                    return new fJ(file, fr);
                }
                if (file.listFiles(file6 -> Pattern.matches("savedata\\d{2}.hg", file6.getName().toLowerCase())).length > 0) {
                    return new fA(file, fr);
                }
            }
            else {
                if (file.getName().equalsIgnoreCase("containers.index")) {
                    return new fT(file.getParentFile(), fr);
                }
                if (file.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", file.getName().toLowerCase())) {
                    return new fJ(file.getParentFile(), fr);
                }
                if (Pattern.matches("savedata\\d{2}.hg", file.getName().toLowerCase())) {
                    return new fA(file.getParentFile(), fr);
                }
            }
        }
        catch (final IOException ex) {
            hc.error("cannot load storage", ex);
        }
        return null;
    }
    
    default fq a(final String anObject, final File file, final fR fr) {
        if (!file.exists()) {
            return null;
        }
        if (anObject == null) {
            return a(file, fr);
        }
        try {
            if ("Steam".equals(anObject)) {
                return new fJ(file, fr);
            }
            if ("Xbox Game Pass".equals(anObject)) {
                return new fT(file, fr);
            }
            if ("PS4 - Save Wizard".equals(anObject)) {
                return new fA(file, fr);
            }
        }
        catch (final IOException ex) {
            hc.error("cannot load storage", ex);
        }
        return null;
    }
    
    File bS();
    
    fr bT();
    
    ft[] bU();
    
    default ft[] bV() {
        return Arrays.asList(this.bU()).stream().filter(ft -> !ft.isEmpty()).toArray(ft[]::new);
    }
    
    int W(final String p0);
    
    default boolean bW() {
        return false;
    }
    
    default String a(final int n, final eY ey) {
        throw new IOException("cannot create slot " + (n + 1));
    }
    
    void X(final String p0);
}
