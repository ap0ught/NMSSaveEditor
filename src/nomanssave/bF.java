// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bF implements bK
{
    final /* synthetic */ bE ey;
    
    bF(final bE ey) {
        this.ey = ey;
    }
    
    @Override
    public String getID() {
        return "ExtremeSurvival";
    }
    
    @Override
    public boolean isSpecial() {
        return false;
    }
    
    @Override
    public String ab() {
        return Double.toString(this.ey.cp.dT());
    }
    
    @Override
    public void l(final String s) {
        this.ey.cp.g(Double.parseDouble(s));
    }
}
