// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileFilter;

class ga implements FileFilter
{
    final /* synthetic */ fZ nb;
    private final /* synthetic */ ArrayList mg;
    
    ga(final fZ nb, final ArrayList mg) {
        this.nb = nb;
        this.mg = mg;
    }
    
    @Override
    public boolean accept(final File file) {
        final Matcher matcher = fT.lW.matcher(file.getName());
        if (matcher.matches()) {
            final int n = (matcher.group(1).length() == 0) ? 0 : (Integer.parseInt(matcher.group(1)) - 1);
            if (n / 2 == this.nb.lT) {
                try {
                    this.mg.add(new fV(this.nb.mN, file.getName(), n));
                }
                catch (final IOException ex) {
                    hc.a("Cannot load " + file.getName(), ex);
                }
            }
        }
        return false;
    }
}
