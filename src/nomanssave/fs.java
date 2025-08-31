// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public interface fs
{
    String K();
    
    fn L();
    
    eY M();
    
    String b(final eY p0);
    
    long lastModified();
    
    default String getName() {
        return null;
    }
    
    default String getDescription() {
        return null;
    }
}
