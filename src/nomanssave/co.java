// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class co extends FileFilter
{
    final /* synthetic */ cl fI;
    
    co(final cl fi) {
        this.fI = fi;
    }
    
    @Override
    public String getDescription() {
        return "All Base Backup Files";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        final String name = file.getName();
        return name.endsWith(".pb3") || name.endsWith(".pb0");
    }
}
