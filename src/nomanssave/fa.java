// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class fa
{
    final eY kM;
    
    public fa() {
        this.kM = new eY();
    }
    
    public fa d(final String s, final Object o) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (!eY.kH.matcher(s).matches()) {
            throw new RuntimeException("Invalid name: " + s);
        }
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        this.kM.a(s, o);
        return this;
    }
    
    public eY bH() {
        return this.kM;
    }
}
