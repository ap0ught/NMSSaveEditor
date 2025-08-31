// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bg extends G
{
    final /* synthetic */ bd dP;
    
    bg(final bd dp) {
        this.dP = dp;
    }
    
    @Override
    protected String g(String string) {
        if (this.dP.dO == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(this.dP.dO.cV())) {
                this.dP.dO.ai(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return this.dP.dO.cV();
        }
    }
}
