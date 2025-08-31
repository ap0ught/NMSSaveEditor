// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class eO
{
    final String id;
    
    eO(final String id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(final Object o) {
        final eM em = (eM)o;
        if (em.jY) {
            return this.id.startsWith(String.valueOf(em.id) + "#");
        }
        return this.id.equals(em.id);
    }
}
