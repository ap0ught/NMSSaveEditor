// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cu extends FileFilter
{
    final /* synthetic */ cs fP;
    
    cu(final cs fp) {
        this.fP = fp;
    }
    
    @Override
    public String getDescription() {
        return "Freighter Backup File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".fb3");
    }
}
