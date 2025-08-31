// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;

class F implements fs
{
    final String filename;
    final long bd;
    final fn be;
    final eY bf;
    final /* synthetic */ Application aZ;
    
    public F(final Application az, final String filename, final long bd, final fn be, final eY bf) {
        this.aZ = az;
        this.filename = filename;
        this.bd = bd;
        this.be = be;
        this.bf = bf;
    }
    
    @Override
    public String K() {
        return this.filename;
    }
    
    @Override
    public fn L() {
        return this.be;
    }
    
    @Override
    public long lastModified() {
        return this.bd;
    }
    
    @Override
    public eY M() {
        return this.bf;
    }
    
    @Override
    public String b(final eY ey) {
        throw new IOException("Save not supported!");
    }
    
    @Override
    public String toString() {
        return this.filename;
    }
}
