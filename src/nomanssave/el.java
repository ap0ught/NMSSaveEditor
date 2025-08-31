// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class el extends FileView
{
    final /* synthetic */ ej is;
    
    el(final ej is) {
        this.is = is;
    }
    
    @Override
    public Icon getIcon(final File file) {
        if (file.isFile()) {
            final String name = file.getName();
            if (name.endsWith(".hg") && !name.startsWith("mf_")) {
                return ej.im;
            }
            if (name.equals("containers.index")) {
                return ej.io;
            }
            return null;
        }
        else {
            if (this.is.a(file) == null) {
                return null;
            }
            return ej.ip;
        }
    }
    
    @Override
    public String getName(final File file) {
        if (file.isFile()) {
            return file.getName();
        }
        final String a = this.is.a(file);
        if (a == null) {
            return file.getName();
        }
        return "[" + a + "] " + file.getName();
    }
}
