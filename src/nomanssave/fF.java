// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileFilter;

class fF implements FileFilter
{
    final /* synthetic */ fE mf;
    private final /* synthetic */ ArrayList mg;
    
    fF(final fE mf, final ArrayList mg) {
        this.mf = mf;
        this.mg = mg;
    }
    
    @Override
    public boolean accept(final File file) {
        final Matcher matcher = fA.lW.matcher(file.getName());
        if (matcher.matches()) {
            final int n = (matcher.group(1).length() == 0) ? 0 : (Integer.parseInt(matcher.group(1)) - 1);
            if (n / 2 == this.mf.lT) {
                try {
                    this.mg.add(new fC(this.mf.ma, file.getName(), n));
                }
                catch (final IOException ex) {
                    hc.a("Cannot load " + file.getName(), ex);
                }
            }
        }
        return false;
    }
}
