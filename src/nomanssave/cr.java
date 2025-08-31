// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cr extends FileFilter
{
    final /* synthetic */ cp fM;
    
    cr(final cp fm) {
        this.fM = fm;
    }
    
    @Override
    public String getDescription() {
        return "Companion Export File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".pet") || file.getName().endsWith(".egg");
    }
}
