// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileView;

class cL extends FileView
{
    final /* synthetic */ cK gl;
    
    cL(final cK gl) {
        this.gl = gl;
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".json")) {
            return name.substring(0, name.length() - 5);
        }
        return name;
    }
}
