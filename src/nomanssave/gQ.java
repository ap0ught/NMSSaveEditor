// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public interface gQ
{
    String getType();
    
    Object dz();
    
    default String ei() {
        final Object dz = this.dz();
        return (dz instanceof fg) ? ((fg)dz).bP() : dz.toString();
    }
    
    void m(final Object p0);
    
    int dA();
    
    void aA(final int p0);
    
    int dB();
}
