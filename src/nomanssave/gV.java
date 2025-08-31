// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class gV
{
    private static double[] a(final eY ey, final String str) {
        final eV d = ey.d(str);
        if (d.size() != 3) {
            throw new RuntimeException("Invalid " + str + " coordinates");
        }
        return new double[] { d.aa(0), d.aa(1), d.aa(2) };
    }
    
    private static void a(final eY ey, final String s, final double[] array) {
        ey.b(s, new eV(new Object[] { new Double(Double.isNaN(array[0]) ? 0.0 : array[0]), new Double(Double.isNaN(array[1]) ? 0.0 : array[1]), new Double(Double.isNaN(array[2]) ? 0.0 : array[2]) }));
    }
    
    public static boolean F(final eY ey) {
        return b(ey, "^BUILDSIGNAL");
    }
    
    public static boolean b(final eY ey, final String s) {
        final eV d = ey.d("Objects");
        eY ey2 = null;
        eY ey3 = null;
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if ("^BASE_FLAG".equals(v.getValueAsString("ObjectID"))) {
                if (ey2 != null) {
                    hc.warn("  multiple base computers found");
                    return false;
                }
                ey2 = v;
            }
            else if (s.equals(v.getValueAsString("ObjectID"))) {
                if (ey3 != null) {
                    hc.warn("  multiple " + s + " objects found");
                    return false;
                }
                ey3 = v;
            }
        }
        if (ey2 == null) {
            hc.warn("  no base computer found");
            return false;
        }
        if (ey3 == null) {
            hc.warn("  no " + s + " object found");
            return false;
        }
        a(ey, ey2, ey3);
        return true;
    }
    
    public static List G(final eY ey) {
        final ArrayList list = new ArrayList();
        boolean b = false;
        final eV d = ey.d("Objects");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            final String valueAsString = v.getValueAsString("ObjectID");
            if ("^BASE_FLAG".equals(v.getValueAsString("ObjectID"))) {
                b = true;
            }
            else if ("^BUILDSIGNAL".equals(valueAsString)) {
                list.add(v);
            }
            else if ("^BP_ANALYSER".equals(valueAsString)) {
                list.add(v);
            }
            else if ("^BUILDBEACON".equals(valueAsString)) {
                list.add(v);
            }
        }
        return b ? list : Collections.emptyList();
    }
    
    public static boolean a(final eY ey, final eY ey2) {
        final eV d = ey.d("Objects");
        boolean b = false;
        eY ey3 = null;
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if ("^BASE_FLAG".equals(v.getValueAsString("ObjectID"))) {
                if (ey3 != null) {
                    hc.warn("  multiple base computers found");
                    return false;
                }
                ey3 = v;
            }
            else if (v == ey2) {
                b = true;
            }
        }
        if (ey3 == null) {
            hc.warn("  no base computer found");
            return false;
        }
        if (!b) {
            hc.warn("  replacement object found");
            return false;
        }
        a(ey, ey3, ey2);
        return true;
    }
    
    private static void a(final eY ey, final eY ey2, final eY ey3) {
        final double[] a = a(ey, "Position");
        final double[] a2 = a(ey, "Forward");
        final double[] a3 = a(ey3, "Position");
        final double[] c;
        final double[] array = c = new gT(a, a2).c(a3);
        final int n = 0;
        c[n] += a[0];
        final double[] array2 = array;
        final int n2 = 1;
        array2[n2] += a[1];
        final double[] array3 = array;
        final int n3 = 2;
        array3[n3] += a[2];
        a(ey, "Position", array);
        final double[] a4 = a(ey2, "At");
        a(ey2, "At", a(ey3, "At"));
        a(ey3, "At", a4);
        a(ey3, "Position", new double[] { -a3[0], -a3[1], -a3[2] });
        final eV d = ey.d("Objects");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v != ey2) {
                if (v != ey3) {
                    final double[] a5;
                    final double[] array4 = a5 = a(v, "Position");
                    final int n4 = 0;
                    a5[n4] -= a3[0];
                    final double[] array5 = array4;
                    final int n5 = 1;
                    array5[n5] -= a3[1];
                    final double[] array6 = array4;
                    final int n6 = 2;
                    array6[n6] -= a3[2];
                    a(v, "Position", array4);
                }
            }
        }
    }
}
