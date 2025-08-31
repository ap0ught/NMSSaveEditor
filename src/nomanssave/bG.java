// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bG implements bK
{
    final /* synthetic */ bE ey;
    
    bG(final bE ey) {
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
        return Integer.toString(this.ey.cp.b(eU.kr));
    }
    
    @Override
    public void l(final String s) {
        throw new RuntimeException("Cannot set words learnt");
    }
}
