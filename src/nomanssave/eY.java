// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.File;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class eY
{
    private static final int kB = 10;
    private static final int kC = 10;
    private static final Pattern kH;
    int length;
    String[] names;
    Object[] values;
    Object kD;
    fe kI;
    Map kJ;
    private static final Pattern kK;
    
    static {
        kH = Pattern.compile("[^\"\\.\\[\\]]+");
        kK = Pattern.compile("([^\\.\\[\\]]+)|(?:\\.([^\\.\\[\\]]+))|(?:\\[(\\d+)\\])");
    }
    
    public static eY E(final String s) {
        return fh.Q(s);
    }
    
    public eY() {
        this.length = 0;
        this.names = new String[10];
        this.values = new Object[10];
        this.kJ = new HashMap();
    }
    
    public void b(final String s, final Function function) {
        this.kJ.put(s, function);
    }
    
    void a(final String s, final Object o) {
        for (int i = 0; i < this.length; ++i) {
            if (this.names[i].equals(s)) {
                throw new RuntimeException("duplicate key: " + s);
            }
        }
        if (this.values.length == this.length) {
            final String[] names = new String[this.length + 10];
            final Object[] values = new Object[this.length + 10];
            System.arraycopy(this.names, 0, names, 0, this.length);
            System.arraycopy(this.values, 0, values, 0, this.length);
            this.names = names;
            this.values = values;
        }
        this.names[this.length] = s;
        fh.a(this.values[this.length] = o, this);
        ++this.length;
    }
    
    public String bz() {
        return fh.a(this, System.lineSeparator(), true);
    }
    
    @Override
    public String toString() {
        return fh.a(this, null, false);
    }
    
    public eY bE() {
        final eY ey = new eY();
        ey.names = new String[this.values.length];
        ey.values = new Object[this.values.length];
        System.arraycopy(this.names, 0, ey.names, 0, this.length);
        for (int i = 0; i < this.length; ++i) {
            if (this.values[i] instanceof eY) {
                fh.a(ey.values[i] = ((eY)this.values[i]).bE(), ey);
            }
            else if (this.values[i] instanceof eV) {
                fh.a(ey.values[i] = ((eV)this.values[i]).bA(), ey);
            }
            else {
                ey.values[i] = this.values[i];
            }
        }
        ey.length = this.length;
        return ey;
    }
    
    public int size() {
        return this.length;
    }
    
    public List names() {
        final String[] a = new String[this.length];
        System.arraycopy(this.names, 0, a, 0, this.length);
        return Arrays.asList(a);
    }
    
    public boolean contains(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (!eY.kH.matcher(s).matches()) {
            throw new RuntimeException("Invalid name: " + s);
        }
        for (int i = 0; i < this.length; ++i) {
            if (s.equals(this.names[i])) {
                return true;
            }
        }
        return false;
    }
    
    public Object get(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (!eY.kH.matcher(s).matches()) {
            throw new RuntimeException("Invalid name: " + s);
        }
        for (int i = 0; i < this.length; ++i) {
            if (s.equals(this.names[i])) {
                return this.values[i];
            }
        }
        return null;
    }
    
    public Object put(final String s, final Object o) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (!eY.kH.matcher(s).matches()) {
            throw new RuntimeException("Invalid name: " + s);
        }
        if (o != null && !fh.a(o.getClass())) {
            throw new RuntimeException("Unsupported type: " + o.getClass().getSimpleName());
        }
        for (int i = 0; i < this.length; ++i) {
            if (s.equals(this.names[i])) {
                final Object o2 = this.values[i];
                fh.i(o2);
                fh.a(this.values[i] = o, this);
                this.firePropertyChange(s, o2, o);
                return o2;
            }
        }
        if (this.values.length == this.length) {
            final String[] names = new String[this.length + 10];
            final Object[] values = new Object[this.length + 10];
            System.arraycopy(this.names, 0, names, 0, this.length);
            System.arraycopy(this.values, 0, values, 0, this.length);
            this.names = names;
            this.values = values;
        }
        this.names[this.length] = s;
        fh.a(this.values[this.length] = o, this);
        ++this.length;
        this.firePropertyChange(s, null, o);
        return null;
    }
    
    public Object F(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (!eY.kH.matcher(s).matches()) {
            throw new RuntimeException("Invalid name: " + s);
        }
        for (int i = 0; i < this.length; ++i) {
            if (s.equals(this.names[i])) {
                final Object o = this.values[i];
                fh.i(o);
                ++i;
                while (i < this.length) {
                    this.names[i - 1] = this.names[i];
                    this.values[i - 1] = this.values[i];
                    ++i;
                }
                --this.length;
                this.firePropertyChange(s, o, null);
                return o;
            }
        }
        return null;
    }
    
    public void c(final eY ey) {
        if (ey == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < ey.length; ++i) {
            boolean b = false;
            for (int j = 0; j < this.length; ++j) {
                if (ey.names[i].equals(this.names[j])) {
                    final Object o = this.values[j];
                    fh.i(o);
                    if (o instanceof eY && ey.values[i] instanceof eY) {
                        ((eY)o).c((eY)ey.values[i]);
                        this.values[j] = o;
                    }
                    else {
                        this.values[j] = ey.values[i];
                    }
                    fh.a(this.values[j], this);
                    b = true;
                }
            }
            if (!b) {
                if (this.values.length == this.length) {
                    final String[] names = new String[this.length + 10];
                    final Object[] values = new Object[this.length + 10];
                    System.arraycopy(this.names, 0, names, 0, this.length);
                    System.arraycopy(this.values, 0, values, 0, this.length);
                    this.names = names;
                    this.values = values;
                }
                this.names[this.length] = ey.names[i];
                fh.a(this.values[this.length] = ey.values[i], this);
                ++this.length;
            }
        }
        this.firePropertyChange("", null, this);
    }
    
    int indexOf(final String s) {
        for (int i = 0; i < this.length; ++i) {
            if (s.equals(this.names[i])) {
                return i;
            }
        }
        return -1;
    }
    
    Object set(final int n, final Object o) {
        final Object o2 = this.values[n];
        fh.i(o2);
        fh.a(this.values[n] = o, this);
        this.firePropertyChange(this.names[n], o2, null);
        return o2;
    }
    
    Object remove(final int n) {
        final String s = this.names[n];
        final Object o = this.values[n];
        fh.i(o);
        for (int i = n + 1; i < this.length; ++i) {
            this.names[i - 1] = this.names[i];
            this.values[i - 1] = this.values[i];
        }
        --this.length;
        this.firePropertyChange(s, o, null);
        return o;
    }
    
    public void clear() {
        for (int i = 0; i < this.length; ++i) {
            fh.i(this.values[i]);
            this.firePropertyChange(this.names[i], this.values[i], null);
        }
        this.length = 0;
    }
    
    public void a(final fe ki) {
        this.kI = ki;
    }
    
    void a(final Object o, final String str, final Object o2, final Object o3) {
        for (int i = 0; i < this.length; ++i) {
            if (o == this.values[i]) {
                this.firePropertyChange(String.valueOf(this.names[i]) + str, o2, o3);
                return;
            }
        }
    }
    
    private void firePropertyChange(final String str, final Object o, final Object o2) {
        if (this.kI != null) {
            EventQueue.invokeLater(() -> this.kI.propertyChanged(s2, o3, o4));
        }
        final String s = (str.length() == 0) ? "" : ("." + str);
        if (this.kD instanceof eY) {
            ((eY)this.kD).a(this, s, o, o2);
        }
        if (this.kD instanceof eV) {
            ((eV)this.kD).a(this, s, o, o2);
        }
    }
    
    private fc G(String string) {
        for (final Map.Entry<Object, V> entry : this.kJ.entrySet()) {
            if (string.equals(entry.getKey())) {
                string = (String)((Function)entry.getValue()).apply(this);
                break;
            }
            if (string.startsWith(String.valueOf(entry.getKey()) + ".") || string.startsWith(String.valueOf(entry.getKey()) + "[")) {
                string = String.valueOf(((Function)entry.getValue()).apply(this)) + string.substring(entry.getKey().length());
                break;
            }
        }
        final Matcher matcher = eY.kK.matcher(string);
        if (matcher.find() && matcher.start() == 0) {
            int n = matcher.end();
            fc fc;
            if (matcher.group(1) != null) {
                fc = new fb(this, matcher.group(1), null);
            }
            else {
                if (matcher.group(3) == null) {
                    throw new RuntimeException("Invalid path");
                }
                fc = new eZ(this, Integer.parseInt(matcher.group(3)), null);
            }
            while (matcher.find() && matcher.start() == n) {
                n = matcher.end();
                if (matcher.group(2) != null) {
                    fc = new fb(this, matcher.group(2), fc);
                }
                else {
                    if (matcher.group(3) == null) {
                        throw new RuntimeException("Invalid path");
                    }
                    fc = new eZ(this, Integer.parseInt(matcher.group(3)), fc);
                }
            }
            if (matcher.hitEnd()) {
                return fc;
            }
        }
        throw new RuntimeException("Invalid path");
    }
    
    public Object getValue(final String s) {
        try {
            return this.G(s).getValue();
        }
        catch (final fd fd) {
            hc.debug("Path not found: " + s);
            return null;
        }
        catch (final RuntimeException ex) {
            hc.warn("Error getting value: " + s + ", " + ex.getMessage());
            return null;
        }
    }
    
    public eY H(final String s) {
        return (eY)this.getValue(s);
    }
    
    public eV d(final String s) {
        return (eV)this.getValue(s);
    }
    
    public String getValueAsString(final String s) {
        final Object value = this.getValue(s);
        if (value instanceof fg) {
            return value.toString();
        }
        return (String)value;
    }
    
    public String I(final String s) {
        final Object value = this.getValue(s);
        if (value == null) {
            return "";
        }
        if (value instanceof Number) {
            String str;
            for (str = Long.toHexString(((Number)value).longValue()); str.length() < 16; str = "0" + str) {}
            return "0x" + str.toUpperCase();
        }
        return (String)this.getValue(s);
    }
    
    public int J(final String s) {
        final Object value = this.getValue(s);
        if (value == null) {
            return 0;
        }
        return ((Number)value).intValue();
    }
    
    public int c(final String s, final int n) {
        final Object value = this.getValue(s);
        if (value == null) {
            return n;
        }
        return ((Number)value).intValue();
    }
    
    public long K(final String s) {
        final Object value = this.getValue(s);
        if (value == null) {
            return 0L;
        }
        return ((Number)value).longValue();
    }
    
    public long a(final String s, final long n) {
        final Object value = this.getValue(s);
        if (value == null) {
            return n;
        }
        return ((Number)value).longValue();
    }
    
    public double L(final String s) {
        final Object value = this.getValue(s);
        if (value == null) {
            return 0.0;
        }
        return ((Number)value).doubleValue();
    }
    
    public double c(final String s, final double n) {
        final Object value = this.getValue(s);
        if (value == null) {
            return n;
        }
        return ((Number)value).doubleValue();
    }
    
    public boolean M(final String s) {
        final Object value = this.getValue(s);
        return value != null && (boolean)value;
    }
    
    public boolean a(final String s, final boolean b) {
        final Object value = this.getValue(s);
        if (value == null) {
            return b;
        }
        return (boolean)value;
    }
    
    public Object b(final String s, final Object o) {
        return this.G(s).a(o, false);
    }
    
    public Object c(final String s, final Object o) {
        return this.G(s).a(o, true);
    }
    
    public Object N(final String s) {
        try {
            return this.G(s).bG();
        }
        catch (final fd fd) {
            hc.debug("Path not found: " + s);
            return null;
        }
        catch (final RuntimeException ex) {
            hc.warn("Error getting value: " + s + ", " + ex.getMessage());
            return null;
        }
    }
    
    public eY b(final String s, final eY ey) {
        return this.G(s).e(ey);
    }
    
    public void d(final eY ey) {
        if (ey == null) {
            throw new NullPointerException();
        }
        if (ey.kD != null) {
            throw new RuntimeException("Object must not have a parent");
        }
        this.clear();
        this.length = ey.length;
        this.names = new String[ey.length];
        this.values = new Object[ey.length];
        System.arraycopy(ey.names, 0, this.names, 0, this.length);
        for (int i = 0; i < this.length; ++i) {
            if (ey.values[i] instanceof eY) {
                fh.a(this.values[i] = ((eY)ey.values[i]).bE(), this);
            }
            else if (ey.values[i] instanceof eV) {
                fh.a(this.values[i] = ((eV)ey.values[i]).bA(), this);
            }
            else {
                this.values[i] = ey.values[i];
            }
            this.firePropertyChange(this.names[i], null, this.values[i]);
        }
    }
    
    public void c(final File file) {
        Throwable t = null;
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(fh.b(this, true).getBytes(StandardCharsets.UTF_8));
            }
            finally {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    public void d(final File file) {
        Throwable t = null;
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            try {
                final Object p = fh.P(new String(hk.g(fileInputStream), StandardCharsets.UTF_8));
                if (p instanceof eY) {
                    this.d((eY)p);
                    return;
                }
                throw new eX("Object expected", 0, 0);
            }
            finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
}
