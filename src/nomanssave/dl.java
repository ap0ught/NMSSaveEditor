// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dl extends G
{
    final /* synthetic */ dj hl;
    
    dl(final dj hl) {
        this.hl = hl;
    }
    
    @Override
    protected String g(String trim) {
        final gv gv = (gv)this.hl.ha.getSelectedItem();
        if (gv == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gv.getName())) {
            gv.setName(trim);
            this.hl.hb.setText(trim);
        }
        return trim;
    }
}
