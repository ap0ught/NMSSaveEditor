// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cn extends FileFilter
{
    final /* synthetic */ cl fI;
    
    cn(final cl fi) {
        this.fI = fi;
    }
    
    @Override
    public String getDescription() {
        return "Planetary Base Backup File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".pb3");
    }
}
