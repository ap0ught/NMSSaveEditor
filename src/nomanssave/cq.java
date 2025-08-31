// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class cq extends FileView
{
    final /* synthetic */ cp fM;
    
    cq(final cp fm) {
        this.fM = fm;
    }
    
    @Override
    public Icon getIcon(final File f) {
        final String name = f.getName();
        if (name.endsWith(".pet")) {
            return cp.fK;
        }
        if (name.endsWith(".egg")) {
            return cp.fL;
        }
        return super.getIcon(f);
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".pet")) {
            return name.substring(0, name.length() - 4);
        }
        if (name.endsWith(".egg")) {
            return name.substring(0, name.length() - 4);
        }
        return name;
    }
}
