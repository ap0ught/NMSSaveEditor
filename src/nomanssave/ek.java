// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class ek extends FileFilter
{
    final /* synthetic */ ej is;
    
    ek(final ej is) {
        this.is = is;
    }
    
    @Override
    public String getDescription() {
        return "Saved Game";
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            return true;
        }
        final String name = file.getName();
        return (name.endsWith(".hg") && !name.startsWith("mf_")) || name.equals("containers.index");
    }
}
