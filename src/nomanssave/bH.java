// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bH implements bK
{
    final /* synthetic */ bE ey;
    
    bH(final bE ey) {
        this.ey = ey;
    }
    
    @Override
    public String getID() {
        return "TWordsLearnt";
    }
    
    @Override
    public boolean isSpecial() {
        return true;
    }
    
    @Override
    public String ab() {
        return Integer.toString(this.ey.cp.b(eU.ks));
    }
    
    @Override
    public void l(final String s) {
        throw new RuntimeException("Cannot set words learnt");
    }
}
