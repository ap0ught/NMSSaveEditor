// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cx extends FileFilter
{
    final /* synthetic */ cv fR;
    
    cx(final cv fr) {
        this.fR = fr;
    }
    
    @Override
    public String getDescription() {
        return "Weapon Export File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".wp0");
    }
}
