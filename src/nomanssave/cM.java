// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class cM extends FileFilter
{
    final /* synthetic */ cK gl;
    
    cM(final cK gl) {
        this.gl = gl;
    }
    
    @Override
    public String getDescription() {
        return "JSON File";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".json");
    }
}
