// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class cU extends FileView
{
    final /* synthetic */ cT gw;
    
    cU(final cT gw) {
        this.gw = gw;
    }
    
    @Override
    public Icon getIcon(final File f) {
        if (f.getName().endsWith(".sh0")) {
            return cT.fH;
        }
        return super.getIcon(f);
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".sh0")) {
            return name.substring(0, name.length() - 4);
        }
        return name;
    }
}
