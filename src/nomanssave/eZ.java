// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class eZ extends fc
{
    final int index;
    final /* synthetic */ eY kL;
    
    eZ(final eY kl, final int index, final fc fc) {
        this.kL = kl;
        super(kl, fc);
        this.index = index;
    }
    
    @Override
    Object a(final Class clazz, final boolean b) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        final eV ev = (eV)this.kN.a(eV.class, b);
        if (this.index < 0 || this.index > ev.length) {
            throw new RuntimeException("Array index out of bounds");
        }
        if (this.index == ev.length) {
            if (!b) {
                throw new fd((fd)null);
            }
            Object instance;
            try {
                instance = clazz.newInstance();
            }
            catch (final InstantiationException | IllegalAccessException cause) {
                throw new RuntimeException("Unexpected error", (Throwable)cause);
            }
            ev.add(instance);
            return instance;
        }
        else {
            if (clazz.isInstance(ev.values[this.index])) {
                return clazz.cast(ev.values[this.index]);
            }
            throw new RuntimeException("Unexpected path");
        }
    }
    
    @Override
    Object getValue() {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        return ((eV)this.kN.a(eV.class, false)).get(this.index);
    }
    
    @Override
    Object a(final Object o, final boolean b) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        final eV ev = (eV)this.kN.a(eV.class, b);
        if (this.index == ev.length) {
            ev.add(o);
            return null;
        }
        return ev.set(this.index, o);
    }
    
    @Override
    Object bG() {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        return ((eV)this.kN.a(eV.class, false)).remove(this.index);
    }
    
    @Override
    eY e(final eY ey) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        final eV ev = (eV)this.kN.a(eV.class, false);
        final Object value = ev.get(this.index);
        if (value == null) {
            ev.set(this.index, ey);
            return null;
        }
        if (value instanceof eY) {
            ((eY)value).c(ey);
            return (eY)value;
        }
        throw new RuntimeException("Unsupported type: " + ((eY)value).getClass().getSimpleName());
    }
}
