// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class fb extends fc
{
    final String name;
    final /* synthetic */ eY kL;
    
    fb(final eY kl, final String name, final fc fc) {
        this.kL = kl;
        super(kl, fc);
        this.name = name;
    }
    
    @Override
    Object a(final Class clazz, final boolean b) {
        eY kl;
        if (this.kN == null) {
            kl = this.kL;
        }
        else {
            kl = (eY)this.kN.a(eY.class, b);
        }
        final int index = kl.indexOf(this.name);
        if (index < 0) {
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
            kl.put(this.name, instance);
            return instance;
        }
        else {
            if (clazz.isInstance(kl.values[index])) {
                return clazz.cast(kl.values[index]);
            }
            throw new RuntimeException("Unexpected path");
        }
    }
    
    @Override
    Object getValue() {
        eY kl;
        if (this.kN == null) {
            kl = this.kL;
        }
        else {
            kl = (eY)this.kN.a(eY.class, false);
        }
        return kl.get(this.name);
    }
    
    @Override
    Object a(final Object o, final boolean b) {
        eY kl;
        if (this.kN == null) {
            kl = this.kL;
        }
        else {
            kl = (eY)this.kN.a(eY.class, b);
        }
        return kl.put(this.name, o);
    }
    
    @Override
    Object bG() {
        eY kl;
        if (this.kN == null) {
            kl = this.kL;
        }
        else {
            kl = (eY)this.kN.a(eY.class, false);
        }
        return kl.F(this.name);
    }
    
    @Override
    eY e(final eY ey) {
        eY kl;
        if (this.kN == null) {
            kl = this.kL;
        }
        else {
            kl = (eY)this.kN.a(eY.class, false);
        }
        final Object value = kl.get(this.name);
        if (value == null) {
            kl.put(this.name, ey);
            return null;
        }
        if (value instanceof eY) {
            ((eY)value).c(ey);
            return (eY)value;
        }
        throw new RuntimeException("Unsupported type: " + ((eY)value).getClass().getSimpleName());
    }
}
