// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Arrays;
import java.util.stream.Stream;

public class eV
{
    private static final int kB = 10;
    private static final int kC = 10;
    int length;
    Object[] values;
    Object kD;
    
    public static eV D(final String s) {
        return fh.R(s);
    }
    
    public eV() {
        this.length = 0;
        this.values = new Object[10];
    }
    
    public eV(final Object... array) {
        this.length = array.length;
        this.values = new Object[array.length];
        for (int i = 0; i < this.length; ++i) {
            if (array[i] != null && !fh.a(array[i].getClass())) {
                throw new RuntimeException("Unsupported type: " + array[i].getClass().getSimpleName());
            }
            this.values[i] = array[i];
            fh.a(array[i], this);
        }
    }
    
    void e(final Object o) {
        if (this.values.length == this.length) {
            final Object[] values = new Object[this.length + 10];
            System.arraycopy(this.values, 0, values, 0, this.length);
            this.values = values;
        }
        fh.a(this.values[this.length] = o, this);
        ++this.length;
    }
    
    Object U(final int n) {
        return this.values[n];
    }
    
    public String bz() {
        return fh.a(this, System.lineSeparator(), true);
    }
    
    @Override
    public String toString() {
        return fh.a(this, null, false);
    }
    
    public eV bA() {
        final eV ev = new eV();
        ev.values = new Object[this.values.length];
        for (int i = 0; i < this.length; ++i) {
            if (this.values[i] instanceof eY) {
                fh.a(ev.values[i] = ((eY)this.values[i]).bE(), ev);
            }
            else if (this.values[i] instanceof eV) {
                fh.a(ev.values[i] = ((eV)this.values[i]).bA(), ev);
            }
            else {
                ev.values[i] = this.values[i];
            }
        }
        ev.length = this.length;
        return ev;
    }
    
    public int size() {
        return this.length;
    }
    
    public int indexOf(final Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.length; ++i) {
            if (o.equals(this.values[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public Object get(final int n) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.values[n];
    }
    
    public Object set(final int i, final Object o) {
        if (i < 0 || i >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        final Object o2 = this.values[i];
        fh.i(o2);
        fh.a(this.values[i] = o, this);
        this.firePropertyChange("[" + i + "]", o2, o);
        return o2;
    }
    
    public void add(final Object o) {
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        final eV ev = new eV();
        if (this.values.length == this.length) {
            ev.values = this.values;
            ev.length = this.length;
            final Object[] values = new Object[this.length + 10];
            System.arraycopy(this.values, 0, values, 0, this.length);
            this.values = values;
        }
        else {
            ev.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, ev.values, 0, this.length);
            ev.length = this.length;
        }
        fh.a(this.values[this.length] = o, this);
        ++this.length;
        this.firePropertyChange("", ev, this);
    }
    
    public void add(final int n, final Object o) {
        if (n < 0 || n > this.length) {
            throw new IndexOutOfBoundsException();
        }
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        final eV ev = new eV();
        if (this.values.length == this.length) {
            ev.values = this.values;
            ev.length = this.length;
            final Object[] values = new Object[this.length + 10];
            System.arraycopy(this.values, 0, values, 0, this.length);
            this.values = values;
        }
        else {
            ev.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, ev.values, 0, this.length);
            ev.length = this.length;
        }
        for (int i = this.length; i > n; ++i) {
            this.values[i] = this.values[i - 1];
        }
        fh.a(this.values[n] = o, this);
        ++this.length;
        this.firePropertyChange("", ev, this);
    }
    
    public Object remove(final int n) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        final eV ev = new eV();
        ev.values = new Object[this.values.length];
        System.arraycopy(this.values, 0, ev.values, 0, this.length);
        ev.length = this.length;
        final Object o = this.values[n];
        fh.i(o);
        for (int i = n; i < this.length - 1; ++i) {
            this.values[i] = this.values[i + 1];
        }
        --this.length;
        this.firePropertyChange("", ev, this);
        return o;
    }
    
    public void clear() {
        final eV ev = new eV();
        ev.values = new Object[this.values.length];
        System.arraycopy(this.values, 0, ev.values, 0, this.length);
        ev.length = this.length;
        for (int i = 0; i < this.length; ++i) {
            fh.i(this.values[i]);
        }
        this.length = 0;
        this.firePropertyChange("", ev, this);
    }
    
    void a(final Object o, final String str, final Object o2, final Object o3) {
        for (int i = 0; i < this.length; ++i) {
            if (o == this.values[i]) {
                this.firePropertyChange("[" + i + "]" + str, o2, o3);
                return;
            }
        }
    }
    
    private void firePropertyChange(final String s, final Object o, final Object o2) {
        if (this.kD instanceof eY) {
            ((eY)this.kD).a(this, s, o, o2);
        }
        if (this.kD instanceof eV) {
            ((eV)this.kD).a(this, s, o, o2);
        }
    }
    
    public Object getValue(final int n) {
        return this.get(n);
    }
    
    public eY V(final int n) {
        return (eY)this.getValue(n);
    }
    
    public eV W(final int n) {
        return (eV)this.getValue(n);
    }
    
    public String X(final int n) {
        final Object value = this.getValue(n);
        if (value instanceof fg) {
            return value.toString();
        }
        return (String)value;
    }
    
    public int Y(final int n) {
        final Object value = this.getValue(n);
        if (value == null) {
            return 0;
        }
        return ((Number)value).intValue();
    }
    
    public long Z(final int n) {
        final Object value = this.getValue(n);
        if (value == null) {
            return 0L;
        }
        return ((Number)value).longValue();
    }
    
    public double aa(final int n) {
        final Object value = this.getValue(n);
        if (value == null) {
            return 0.0;
        }
        return ((Number)value).doubleValue();
    }
    
    public boolean ab(final int n) {
        final Object value = this.getValue(n);
        return value != null && (boolean)value;
    }
    
    public void a(final int n, final Object o) {
        this.set(n, o);
    }
    
    public void f(final Object o) {
        this.add(o);
    }
    
    public boolean hasValue(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    public boolean ac(final int n) {
        this.remove(n);
        return true;
    }
    
    public boolean g(final Object o) {
        final int index = this.indexOf(o);
        if (index < 0) {
            return false;
        }
        this.remove(index);
        return true;
    }
    
    public Stream bB() {
        final eY[] array = new eY[this.length];
        int endExclusive = 0;
        for (int i = 0; i < this.length; ++i) {
            if (this.values[i] instanceof eY) {
                array[endExclusive++] = (eY)this.values[i];
            }
        }
        return Arrays.stream(array, 0, endExclusive);
    }
}
