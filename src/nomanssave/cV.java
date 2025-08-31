// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cV extends FileFilter
{
    final /* synthetic */ cT gw;
    
    cV(final cT gw) {
        this.gw = gw;
    }
    
    @Override
    public String getDescription() {
        return "Ship Export File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".sh0");
    }
}
