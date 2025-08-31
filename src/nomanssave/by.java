// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class by extends G
{
    final /* synthetic */ bl er;
    
    by(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(String string) {
        if (this.er.eq < 0) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(this.er.ep[this.er.eq].cV())) {
                this.er.ep[this.er.eq].ai(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return this.er.ep[this.er.eq].cV();
        }
    }
}
