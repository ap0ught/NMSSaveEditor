// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileFilter;

class fO implements FileFilter
{
    final /* synthetic */ fN mw;
    private final /* synthetic */ ArrayList mg;
    
    fO(final fN mw, final ArrayList mg) {
        this.mw = mw;
        this.mg = mg;
    }
    
    @Override
    public boolean accept(final File file) {
        final Matcher matcher = fJ.lW.matcher(file.getName());
        if (matcher.matches()) {
            final int n = (matcher.group(1).length() == 0) ? 0 : (Integer.parseInt(matcher.group(1)) - 1);
            if (n / 2 == this.mw.lT) {
                try {
                    this.mg.add(new fL(this.mw.mt, file.getName(), n));
                }
                catch (final IOException ex) {
                    hc.a("Cannot load " + file.getName(), ex);
                }
            }
        }
        return false;
    }
}
