// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class M extends G
{
    final /* synthetic */ I bt;
    
    M(final I bt) {
        this.bt = bt;
    }
    
    @Override
    protected String g(String trim) {
        final gf gf = (gf)this.bt.bk.getSelectedItem();
        if (gf == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gf.getName())) {
            gf.setName(trim);
            this.bt.bl.setText(trim);
        }
        return trim;
    }
}
