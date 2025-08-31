// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class hh
{
    private static final long sx = 255L;
    private static final int sy = 12;
    private static final int sz = 96;
    private static final int sA = 48;
    private static final int sB = 12;
    private static final int sC = 192;
    private static final int sD = 96;
    private static final int sE = 24;
    private static final long sF = -2401053088876216593L;
    private final long sG;
    private final long sH;
    
    private static long a(final byte[] array, final int n) {
        return ((long)array[n + 7] & 0xFFL) << 56 | ((long)array[n + 6] & 0xFFL) << 48 | ((long)array[n + 5] & 0xFFL) << 40 | ((long)array[n + 4] & 0xFFL) << 32 | ((long)array[n + 3] & 0xFFL) << 24 | ((long)array[n + 2] & 0xFFL) << 16 | ((long)array[n + 1] & 0xFFL) << 8 | ((long)array[n] & 0xFFL);
    }
    
    private static long b(final byte[] array, final int n, final int n2) {
        long n3 = 0L;
        switch (n2) {
            case 7: {
                n3 += ((long)array[n + 6] & 0xFFL) << 48;
            }
            case 6: {
                n3 += ((long)array[n + 5] & 0xFFL) << 40;
            }
            case 5: {
                n3 += ((long)array[n + 4] & 0xFFL) << 32;
            }
            case 4: {
                n3 += ((long)array[n + 3] & 0xFFL) << 24;
            }
            case 3: {
                n3 += ((long)array[n + 2] & 0xFFL) << 16;
            }
            case 2: {
                n3 += ((long)array[n + 1] & 0xFFL) << 8;
            }
            case 1: {
                n3 += ((long)array[n] & 0xFFL);
                break;
            }
        }
        return n3;
    }
    
    private static void a(final byte[] array, final int n, final int n2, final long[] array2) {
        long n3 = array2[0];
        long n4 = array2[1];
        long n5 = -2401053088876216593L;
        long n6 = -2401053088876216593L;
        int i = n2;
        int n7 = n;
        while (i >= 32) {
            final long n8 = n5 + a(array, n7);
            final long n9 = n6 + a(array, n7 + 8);
            final long n10 = (n8 << 50 | n8 >>> 14) + n9;
            final long n11 = n3 ^ n10;
            final long n12 = (n9 << 52 | n9 >>> 12) + n11;
            final long n13 = n4 ^ n12;
            final long n14 = (n11 << 30 | n11 >>> 34) + n13;
            final long n15 = n10 ^ n14;
            final long n16 = (n13 << 41 | n13 >>> 23) + n15;
            final long n17 = n12 ^ n16;
            final long n18 = (n15 << 54 | n15 >>> 10) + n17;
            final long n19 = n14 ^ n18;
            final long n20 = (n17 << 48 | n17 >>> 16) + n19;
            final long n21 = n16 ^ n20;
            final long n22 = (n19 << 38 | n19 >>> 26) + n21;
            final long n23 = n18 ^ n22;
            final long n24 = (n21 << 37 | n21 >>> 27) + n23;
            final long n25 = n20 ^ n24;
            final long n26 = (n23 << 62 | n23 >>> 2) + n25;
            final long n27 = n22 ^ n26;
            final long n28 = (n25 << 34 | n25 >>> 30) + n27;
            final long n29 = n24 ^ n28;
            final long n30 = (n27 << 5 | n27 >>> 59) + n29;
            n5 = (n26 ^ n30);
            final long n31 = (n29 << 36 | n29 >>> 28) + n5;
            n6 = (n28 ^ n31);
            n3 = n30 + a(array, n7 + 16);
            n4 = n31 + a(array, n7 + 24);
            n7 += 32;
            i -= 32;
        }
        if (i >= 16) {
            final long n32 = n5 + a(array, n7);
            final long n33 = n6 + a(array, n7 + 8);
            n7 += 16;
            i -= 16;
            final long n34 = (n32 << 50 | n32 >>> 14) + n33;
            final long n35 = n3 ^ n34;
            final long n36 = (n33 << 52 | n33 >>> 12) + n35;
            final long n37 = n4 ^ n36;
            final long n38 = (n35 << 30 | n35 >>> 34) + n37;
            final long n39 = n34 ^ n38;
            final long n40 = (n37 << 41 | n37 >>> 23) + n39;
            final long n41 = n36 ^ n40;
            final long n42 = (n39 << 54 | n39 >>> 10) + n41;
            final long n43 = n38 ^ n42;
            final long n44 = (n41 << 48 | n41 >>> 16) + n43;
            final long n45 = n40 ^ n44;
            final long n46 = (n43 << 38 | n43 >>> 26) + n45;
            final long n47 = n42 ^ n46;
            final long n48 = (n45 << 37 | n45 >>> 27) + n47;
            final long n49 = n44 ^ n48;
            final long n50 = (n47 << 62 | n47 >>> 2) + n49;
            final long n51 = n46 ^ n50;
            final long n52 = (n49 << 34 | n49 >>> 30) + n51;
            final long n53 = n48 ^ n52;
            n3 = (n51 << 5 | n51 >>> 59) + n53;
            n5 = (n50 ^ n3);
            n4 = (n53 << 36 | n53 >>> 28) + n5;
            n6 = (n52 ^ n4);
        }
        long n54 = n6 + ((long)n2 << 56);
        long n55;
        if (i >= 8) {
            n55 = n5 + a(array, n7);
            n7 += 8;
            i -= 8;
            if (i > 0) {
                n54 += b(array, n7, i);
            }
        }
        else if (i > 0) {
            n55 = n5 + b(array, n7, i);
        }
        else {
            n55 = n5 - 2401053088876216593L;
            n54 -= 2401053088876216593L;
        }
        final long n56 = n54 ^ n55;
        final long n57 = n55 << 15 | n55 >>> 49;
        final long n58 = n56 + n57;
        final long n59 = n3 ^ n58;
        final long n60 = n58 << 52 | n58 >>> 12;
        final long n61 = n59 + n60;
        final long n62 = n4 ^ n61;
        final long n63 = n61 << 26 | n61 >>> 38;
        final long n64 = n62 + n63;
        final long n65 = n57 ^ n64;
        final long n66 = n64 << 51 | n64 >>> 13;
        final long n67 = n65 + n66;
        final long n68 = n60 ^ n67;
        final long n69 = n67 << 28 | n67 >>> 36;
        final long n70 = n68 + n69;
        final long n71 = n63 ^ n70;
        final long n72 = n70 << 9 | n70 >>> 55;
        final long n73 = n71 + n72;
        final long n74 = n66 ^ n73;
        final long n75 = n73 << 47 | n73 >>> 17;
        final long n76 = n74 + n75;
        final long n77 = n69 ^ n76;
        final long n78 = n76 << 54 | n76 >>> 10;
        final long n79 = n77 + n78;
        final long n80 = (n72 ^ n79) + (n79 << 32 | n79 >>> 32);
        final long n81 = (n75 ^ n80) + (n80 << 25 | n80 >>> 39);
        final long n82 = n78 ^ n81;
        final long n83 = n81 << 63 | n81 >>> 1;
        final long n84 = n82 + n83;
        array2[0] = n83;
        array2[1] = n84;
    }
    
    public static long b(final byte[] array, final int n, final int n2, final long[] array2) {
        if (n2 < 192) {
            a(array, n, n2, array2);
            return array2[0];
        }
        long n6;
        long n5;
        long n4;
        long n3 = n4 = (n5 = (n6 = array2[0]));
        long n10;
        long n9;
        long n8;
        long n7 = n8 = (n9 = (n10 = array2[1]));
        long n14;
        long n13;
        long n12;
        long n11 = n12 = (n13 = (n14 = -2401053088876216593L));
        int i;
        int n15;
        for (i = n2, n15 = n; i >= 96; i -= 96, n15 += 96) {
            final long n16 = n4 + a(array, n15);
            final long n17 = n12 ^ n10;
            final long n18 = n14 ^ n16;
            final long n19 = n16 << 11 | n16 >>> 53;
            final long n20 = n18 + n8;
            final long n21 = n8 + a(array, n15 + 8);
            final long n22 = n3 ^ n20;
            final long n23 = n19 ^ n21;
            final long n24 = n21 << 32 | n21 >>> 32;
            final long n25 = n23 + n17;
            final long n26 = n17 + a(array, n15 + 16);
            final long n27 = n7 ^ n25;
            final long n28 = n24 ^ n26;
            final long n29 = n26 << 43 | n26 >>> 21;
            final long n30 = n28 + n22;
            final long n31 = n22 + a(array, n15 + 24);
            final long n32 = n11 ^ n30;
            final long n33 = n29 ^ n31;
            final long n34 = n31 << 31 | n31 >>> 33;
            n12 = n33 + n27;
            final long n35 = n27 + a(array, n15 + 32);
            final long n36 = n5 ^ n12;
            final long n37 = n34 ^ n35;
            final long n38 = n35 << 17 | n35 >>> 47;
            n3 = n37 + n32;
            final long n39 = n32 + a(array, n15 + 40);
            final long n40 = n9 ^ n3;
            final long n41 = n38 ^ n39;
            final long n42 = n39 << 28 | n39 >>> 36;
            n7 = n41 + n36;
            final long n43 = n36 + a(array, n15 + 48);
            final long n44 = n13 ^ n7;
            final long n45 = n42 ^ n43;
            final long n46 = n43 << 39 | n43 >>> 25;
            n11 = n45 + n40;
            final long n47 = n40 + a(array, n15 + 56);
            final long n48 = n6 ^ n11;
            final long n49 = n46 ^ n47;
            final long n50 = n47 << 57 | n47 >>> 7;
            n5 = n49 + n44;
            final long n51 = n44 + a(array, n15 + 64);
            final long n52 = n10 ^ n5;
            final long n53 = n50 ^ n51;
            final long n54 = n51 << 55 | n51 >>> 9;
            n9 = n53 + n48;
            final long n55 = n48 + a(array, n15 + 72);
            final long n56 = n20 ^ n9;
            final long n57 = n54 ^ n55;
            final long n58 = n55 << 54 | n55 >>> 10;
            n13 = n57 + n52;
            final long n59 = n52 + a(array, n15 + 80);
            n4 = (n25 ^ n13);
            final long n60 = n58 ^ n59;
            final long n61 = n59 << 22 | n59 >>> 42;
            n6 = n60 + n56;
            final long n62 = n56 + a(array, n15 + 88);
            n8 = (n30 ^ n6);
            final long n63 = n61 ^ n62;
            n14 = (n62 << 46 | n62 >>> 18);
            n10 = n63 + n4;
        }
        final int n64 = i & 0x7;
        final int n65 = i >>> 3;
        if (n64 > 0) {
            final long b = b(array, n15 + (n65 << 3), n64);
            switch (n65) {
                case 0: {
                    n4 += b;
                    break;
                }
                case 1: {
                    n8 += b;
                    break;
                }
                case 2: {
                    n12 += b;
                    break;
                }
                case 3: {
                    n3 += b;
                    break;
                }
                case 4: {
                    n7 += b;
                    break;
                }
                case 5: {
                    n11 += b;
                    break;
                }
                case 6: {
                    n5 += b;
                    break;
                }
                case 7: {
                    n9 += b;
                    break;
                }
                case 8: {
                    n13 += b;
                    break;
                }
                case 9: {
                    n6 += b;
                    break;
                }
                case 10: {
                    n10 += b;
                    break;
                }
                case 11: {
                    n14 += b;
                    break;
                }
            }
        }
        switch (n65) {
            case 11: {
                n10 += a(array, n15 + 80);
            }
            case 10: {
                n6 += a(array, n15 + 72);
            }
            case 9: {
                n13 += a(array, n15 + 64);
            }
            case 8: {
                n9 += a(array, n15 + 56);
            }
            case 7: {
                n5 += a(array, n15 + 48);
            }
            case 6: {
                n11 += a(array, n15 + 40);
            }
            case 5: {
                n7 += a(array, n15 + 32);
            }
            case 4: {
                n3 += a(array, n15 + 24);
            }
            case 3: {
                n12 += a(array, n15 + 16);
            }
            case 2: {
                n8 += a(array, n15 + 8);
            }
            case 1: {
                n4 += a(array, n15);
                break;
            }
        }
        long n66 = n14 + ((long)i << 56);
        for (int j = 0; j < 3; ++j) {
            final long n67 = n66 + n8;
            final long n68 = n12 ^ n67;
            final long n69 = n8 << 44 | n8 >>> 20;
            final long n70 = n4 + n68;
            final long n71 = n3 ^ n70;
            final long n72 = n68 << 15 | n68 >>> 49;
            final long n73 = n69 + n71;
            final long n74 = n7 ^ n73;
            final long n75 = n71 << 34 | n71 >>> 30;
            n12 = n72 + n74;
            final long n76 = n11 ^ n12;
            final long n77 = n74 << 21 | n74 >>> 43;
            n3 = n75 + n76;
            final long n78 = n5 ^ n3;
            final long n79 = n76 << 38 | n76 >>> 26;
            n7 = n77 + n78;
            final long n80 = n9 ^ n7;
            final long n81 = n78 << 33 | n78 >>> 31;
            n11 = n79 + n80;
            final long n82 = n13 ^ n11;
            final long n83 = n80 << 10 | n80 >>> 54;
            n5 = n81 + n82;
            final long n84 = n6 ^ n5;
            final long n85 = n82 << 13 | n82 >>> 51;
            n9 = n83 + n84;
            final long n86 = n10 ^ n9;
            final long n87 = n84 << 38 | n84 >>> 26;
            n13 = n85 + n86;
            final long n88 = n67 ^ n13;
            final long n89 = n86 << 53 | n86 >>> 11;
            n6 = n87 + n88;
            final long n90 = n70 ^ n6;
            n66 = (n88 << 42 | n88 >>> 22);
            n10 = n89 + n90;
            n8 = (n73 ^ n10);
            n4 = (n90 << 54 | n90 >>> 10);
        }
        array2[0] = n4;
        array2[1] = n8;
        return n4;
    }
    
    private static long a(final CharSequence charSequence, final int n) {
        return (long)charSequence.charAt(n + 3) << 48 | (long)charSequence.charAt(n + 2) << 32 | (long)charSequence.charAt(n + 1) << 16 | (long)charSequence.charAt(n);
    }
    
    private static long a(final CharSequence charSequence, final int n, final int n2) {
        long n3 = 0L;
        switch (n2) {
            case 3: {
                n3 += (long)charSequence.charAt(n + 2) << 32;
            }
            case 2: {
                n3 += (long)charSequence.charAt(n + 1) << 16;
            }
            case 1: {
                n3 += charSequence.charAt(n);
                break;
            }
        }
        return n3;
    }
    
    private static void a(final CharSequence charSequence, final int n, final int n2, final long[] array) {
        long n3 = array[0];
        long n4 = array[1];
        long n5 = -2401053088876216593L;
        long n6 = -2401053088876216593L;
        int i = n2;
        int n7 = n;
        while (i >= 16) {
            final long n8 = n5 + a(charSequence, n7);
            final long n9 = n6 + a(charSequence, n7 + 4);
            final long n10 = (n8 << 50 | n8 >>> 14) + n9;
            final long n11 = n3 ^ n10;
            final long n12 = (n9 << 52 | n9 >>> 12) + n11;
            final long n13 = n4 ^ n12;
            final long n14 = (n11 << 30 | n11 >>> 34) + n13;
            final long n15 = n10 ^ n14;
            final long n16 = (n13 << 41 | n13 >>> 23) + n15;
            final long n17 = n12 ^ n16;
            final long n18 = (n15 << 54 | n15 >>> 10) + n17;
            final long n19 = n14 ^ n18;
            final long n20 = (n17 << 48 | n17 >>> 16) + n19;
            final long n21 = n16 ^ n20;
            final long n22 = (n19 << 38 | n19 >>> 26) + n21;
            final long n23 = n18 ^ n22;
            final long n24 = (n21 << 37 | n21 >>> 27) + n23;
            final long n25 = n20 ^ n24;
            final long n26 = (n23 << 62 | n23 >>> 2) + n25;
            final long n27 = n22 ^ n26;
            final long n28 = (n25 << 34 | n25 >>> 30) + n27;
            final long n29 = n24 ^ n28;
            final long n30 = (n27 << 5 | n27 >>> 59) + n29;
            n5 = (n26 ^ n30);
            final long n31 = (n29 << 36 | n29 >>> 28) + n5;
            n6 = (n28 ^ n31);
            n3 = n30 + a(charSequence, n7 + 8);
            n4 = n31 + a(charSequence, n7 + 12);
            n7 += 16;
            i -= 16;
        }
        if (i >= 8) {
            final long n32 = n5 + a(charSequence, n7);
            final long n33 = n6 + a(charSequence, n7 + 4);
            n7 += 8;
            i -= 8;
            final long n34 = (n32 << 50 | n32 >>> 14) + n33;
            final long n35 = n3 ^ n34;
            final long n36 = (n33 << 52 | n33 >>> 12) + n35;
            final long n37 = n4 ^ n36;
            final long n38 = (n35 << 30 | n35 >>> 34) + n37;
            final long n39 = n34 ^ n38;
            final long n40 = (n37 << 41 | n37 >>> 23) + n39;
            final long n41 = n36 ^ n40;
            final long n42 = (n39 << 54 | n39 >>> 10) + n41;
            final long n43 = n38 ^ n42;
            final long n44 = (n41 << 48 | n41 >>> 16) + n43;
            final long n45 = n40 ^ n44;
            final long n46 = (n43 << 38 | n43 >>> 26) + n45;
            final long n47 = n42 ^ n46;
            final long n48 = (n45 << 37 | n45 >>> 27) + n47;
            final long n49 = n44 ^ n48;
            final long n50 = (n47 << 62 | n47 >>> 2) + n49;
            final long n51 = n46 ^ n50;
            final long n52 = (n49 << 34 | n49 >>> 30) + n51;
            final long n53 = n48 ^ n52;
            n3 = (n51 << 5 | n51 >>> 59) + n53;
            n5 = (n50 ^ n3);
            n4 = (n53 << 36 | n53 >>> 28) + n5;
            n6 = (n52 ^ n4);
        }
        long n54 = n6 + ((long)(n2 << 1) << 56);
        long n55;
        if (i >= 4) {
            n55 = n5 + a(charSequence, n7);
            n7 += 4;
            i -= 4;
            if (i > 0) {
                n54 += a(charSequence, n7, i);
            }
        }
        else if (i > 0) {
            n55 = n5 + a(charSequence, n7, i);
        }
        else {
            n55 = n5 - 2401053088876216593L;
            n54 -= 2401053088876216593L;
        }
        final long n56 = n54 ^ n55;
        final long n57 = n55 << 15 | n55 >>> 49;
        final long n58 = n56 + n57;
        final long n59 = n3 ^ n58;
        final long n60 = n58 << 52 | n58 >>> 12;
        final long n61 = n59 + n60;
        final long n62 = n4 ^ n61;
        final long n63 = n61 << 26 | n61 >>> 38;
        final long n64 = n62 + n63;
        final long n65 = n57 ^ n64;
        final long n66 = n64 << 51 | n64 >>> 13;
        final long n67 = n65 + n66;
        final long n68 = n60 ^ n67;
        final long n69 = n67 << 28 | n67 >>> 36;
        final long n70 = n68 + n69;
        final long n71 = n63 ^ n70;
        final long n72 = n70 << 9 | n70 >>> 55;
        final long n73 = n71 + n72;
        final long n74 = n66 ^ n73;
        final long n75 = n73 << 47 | n73 >>> 17;
        final long n76 = n74 + n75;
        final long n77 = n69 ^ n76;
        final long n78 = n76 << 54 | n76 >>> 10;
        final long n79 = n77 + n78;
        final long n80 = (n72 ^ n79) + (n79 << 32 | n79 >>> 32);
        final long n81 = (n75 ^ n80) + (n80 << 25 | n80 >>> 39);
        final long n82 = n78 ^ n81;
        final long n83 = n81 << 63 | n81 >>> 1;
        final long n84 = n82 + n83;
        array[0] = n83;
        array[1] = n84;
    }
    
    public static long b(final CharSequence charSequence, final int n, final int n2, final long[] array) {
        if (n2 < 96) {
            a(charSequence, n, n2, array);
            return array[0];
        }
        long n6;
        long n5;
        long n4;
        long n3 = n4 = (n5 = (n6 = array[0]));
        long n10;
        long n9;
        long n8;
        long n7 = n8 = (n9 = (n10 = array[1]));
        long n14;
        long n13;
        long n12;
        long n11 = n12 = (n13 = (n14 = -2401053088876216593L));
        int i;
        int n15;
        for (i = n2, n15 = n; i >= 48; i -= 48, n15 += 48) {
            final long n16 = n4 + a(charSequence, n15);
            final long n17 = n12 ^ n10;
            final long n18 = n14 ^ n16;
            final long n19 = n16 << 11 | n16 >>> 53;
            final long n20 = n18 + n8;
            final long n21 = n8 + a(charSequence, n15 + 4);
            final long n22 = n3 ^ n20;
            final long n23 = n19 ^ n21;
            final long n24 = n21 << 32 | n21 >>> 32;
            final long n25 = n23 + n17;
            final long n26 = n17 + a(charSequence, n15 + 8);
            final long n27 = n7 ^ n25;
            final long n28 = n24 ^ n26;
            final long n29 = n26 << 43 | n26 >>> 21;
            final long n30 = n28 + n22;
            final long n31 = n22 + a(charSequence, n15 + 12);
            final long n32 = n11 ^ n30;
            final long n33 = n29 ^ n31;
            final long n34 = n31 << 31 | n31 >>> 33;
            n12 = n33 + n27;
            final long n35 = n27 + a(charSequence, n15 + 16);
            final long n36 = n5 ^ n12;
            final long n37 = n34 ^ n35;
            final long n38 = n35 << 17 | n35 >>> 47;
            n3 = n37 + n32;
            final long n39 = n32 + a(charSequence, n15 + 20);
            final long n40 = n9 ^ n3;
            final long n41 = n38 ^ n39;
            final long n42 = n39 << 28 | n39 >>> 36;
            n7 = n41 + n36;
            final long n43 = n36 + a(charSequence, n15 + 24);
            final long n44 = n13 ^ n7;
            final long n45 = n42 ^ n43;
            final long n46 = n43 << 39 | n43 >>> 25;
            n11 = n45 + n40;
            final long n47 = n40 + a(charSequence, n15 + 28);
            final long n48 = n6 ^ n11;
            final long n49 = n46 ^ n47;
            final long n50 = n47 << 57 | n47 >>> 7;
            n5 = n49 + n44;
            final long n51 = n44 + a(charSequence, n15 + 32);
            final long n52 = n10 ^ n5;
            final long n53 = n50 ^ n51;
            final long n54 = n51 << 55 | n51 >>> 9;
            n9 = n53 + n48;
            final long n55 = n48 + a(charSequence, n15 + 36);
            final long n56 = n20 ^ n9;
            final long n57 = n54 ^ n55;
            final long n58 = n55 << 54 | n55 >>> 10;
            n13 = n57 + n52;
            final long n59 = n52 + a(charSequence, n15 + 40);
            n4 = (n25 ^ n13);
            final long n60 = n58 ^ n59;
            final long n61 = n59 << 22 | n59 >>> 42;
            n6 = n60 + n56;
            final long n62 = n56 + a(charSequence, n15 + 44);
            n8 = (n30 ^ n6);
            final long n63 = n61 ^ n62;
            n14 = (n62 << 46 | n62 >>> 18);
            n10 = n63 + n4;
        }
        final int n64 = i & 0x3;
        final int n65 = i >> 2;
        if (n64 > 0) {
            final long a = a(charSequence, n15 + (n65 << 2), n64);
            switch (n65) {
                case 0: {
                    n4 += a;
                    break;
                }
                case 1: {
                    n8 += a;
                    break;
                }
                case 2: {
                    n12 += a;
                    break;
                }
                case 3: {
                    n3 += a;
                    break;
                }
                case 4: {
                    n7 += a;
                    break;
                }
                case 5: {
                    n11 += a;
                    break;
                }
                case 6: {
                    n5 += a;
                    break;
                }
                case 7: {
                    n9 += a;
                    break;
                }
                case 8: {
                    n13 += a;
                    break;
                }
                case 9: {
                    n6 += a;
                    break;
                }
                case 10: {
                    n10 += a;
                    break;
                }
                case 11: {
                    n14 += a;
                    break;
                }
            }
        }
        switch (n65) {
            case 11: {
                n10 += a(charSequence, n15 + 40);
            }
            case 10: {
                n6 += a(charSequence, n15 + 36);
            }
            case 9: {
                n13 += a(charSequence, n15 + 32);
            }
            case 8: {
                n9 += a(charSequence, n15 + 28);
            }
            case 7: {
                n5 += a(charSequence, n15 + 24);
            }
            case 6: {
                n11 += a(charSequence, n15 + 20);
            }
            case 5: {
                n7 += a(charSequence, n15 + 16);
            }
            case 4: {
                n3 += a(charSequence, n15 + 12);
            }
            case 3: {
                n12 += a(charSequence, n15 + 8);
            }
            case 2: {
                n8 += a(charSequence, n15 + 4);
            }
            case 1: {
                n4 += a(charSequence, n15);
                break;
            }
        }
        long n66 = n14 + ((long)i << 1 << 56);
        for (int j = 0; j < 3; ++j) {
            final long n67 = n66 + n8;
            final long n68 = n12 ^ n67;
            final long n69 = n8 << 44 | n8 >>> 20;
            final long n70 = n4 + n68;
            final long n71 = n3 ^ n70;
            final long n72 = n68 << 15 | n68 >>> 49;
            final long n73 = n69 + n71;
            final long n74 = n7 ^ n73;
            final long n75 = n71 << 34 | n71 >>> 30;
            n12 = n72 + n74;
            final long n76 = n11 ^ n12;
            final long n77 = n74 << 21 | n74 >>> 43;
            n3 = n75 + n76;
            final long n78 = n5 ^ n3;
            final long n79 = n76 << 38 | n76 >>> 26;
            n7 = n77 + n78;
            final long n80 = n9 ^ n7;
            final long n81 = n78 << 33 | n78 >>> 31;
            n11 = n79 + n80;
            final long n82 = n13 ^ n11;
            final long n83 = n80 << 10 | n80 >>> 54;
            n5 = n81 + n82;
            final long n84 = n6 ^ n5;
            final long n85 = n82 << 13 | n82 >>> 51;
            n9 = n83 + n84;
            final long n86 = n10 ^ n9;
            final long n87 = n84 << 38 | n84 >>> 26;
            n13 = n85 + n86;
            final long n88 = n67 ^ n13;
            final long n89 = n86 << 53 | n86 >>> 11;
            n6 = n87 + n88;
            final long n90 = n70 ^ n6;
            n66 = (n88 << 42 | n88 >>> 22);
            n10 = n89 + n90;
            n8 = (n73 ^ n10);
            n4 = (n90 << 54 | n90 >>> 10);
        }
        array[0] = n4;
        array[1] = n8;
        return n4;
    }
    
    private static void a(final long[] array, final int n, final int n2, final long[] array2) {
        long n3 = array2[0];
        long n4 = array2[1];
        long n5 = -2401053088876216593L;
        long n6 = -2401053088876216593L;
        int i = n2;
        int n7 = n;
        while (i >= 4) {
            final long n8 = n5 + array[n7];
            final long n9 = n6 + array[n7 + 1];
            final long n10 = (n8 << 50 | n8 >>> 14) + n9;
            final long n11 = n3 ^ n10;
            final long n12 = (n9 << 52 | n9 >>> 12) + n11;
            final long n13 = n4 ^ n12;
            final long n14 = (n11 << 30 | n11 >>> 34) + n13;
            final long n15 = n10 ^ n14;
            final long n16 = (n13 << 41 | n13 >>> 23) + n15;
            final long n17 = n12 ^ n16;
            final long n18 = (n15 << 54 | n15 >>> 10) + n17;
            final long n19 = n14 ^ n18;
            final long n20 = (n17 << 48 | n17 >>> 16) + n19;
            final long n21 = n16 ^ n20;
            final long n22 = (n19 << 38 | n19 >>> 26) + n21;
            final long n23 = n18 ^ n22;
            final long n24 = (n21 << 37 | n21 >>> 27) + n23;
            final long n25 = n20 ^ n24;
            final long n26 = (n23 << 62 | n23 >>> 2) + n25;
            final long n27 = n22 ^ n26;
            final long n28 = (n25 << 34 | n25 >>> 30) + n27;
            final long n29 = n24 ^ n28;
            final long n30 = (n27 << 5 | n27 >>> 59) + n29;
            n5 = (n26 ^ n30);
            final long n31 = (n29 << 36 | n29 >>> 28) + n5;
            n6 = (n28 ^ n31);
            n3 = n30 + array[n7 + 2];
            n4 = n31 + array[n7 + 3];
            n7 += 4;
            i -= 4;
        }
        if (i >= 2) {
            final long n32 = n5 + array[n7];
            final long n33 = n6 + array[n7 + 1];
            n7 += 2;
            i -= 2;
            final long n34 = (n32 << 50 | n32 >>> 14) + n33;
            final long n35 = n3 ^ n34;
            final long n36 = (n33 << 52 | n33 >>> 12) + n35;
            final long n37 = n4 ^ n36;
            final long n38 = (n35 << 30 | n35 >>> 34) + n37;
            final long n39 = n34 ^ n38;
            final long n40 = (n37 << 41 | n37 >>> 23) + n39;
            final long n41 = n36 ^ n40;
            final long n42 = (n39 << 54 | n39 >>> 10) + n41;
            final long n43 = n38 ^ n42;
            final long n44 = (n41 << 48 | n41 >>> 16) + n43;
            final long n45 = n40 ^ n44;
            final long n46 = (n43 << 38 | n43 >>> 26) + n45;
            final long n47 = n42 ^ n46;
            final long n48 = (n45 << 37 | n45 >>> 27) + n47;
            final long n49 = n44 ^ n48;
            final long n50 = (n47 << 62 | n47 >>> 2) + n49;
            final long n51 = n46 ^ n50;
            final long n52 = (n49 << 34 | n49 >>> 30) + n51;
            final long n53 = n48 ^ n52;
            n3 = (n51 << 5 | n51 >>> 59) + n53;
            n5 = (n50 ^ n3);
            n4 = (n53 << 36 | n53 >>> 28) + n5;
            n6 = (n52 ^ n4);
        }
        long n54 = n6 + ((long)(n2 << 3) << 56);
        long n55;
        if (i > 0) {
            n55 = n5 + array[n7];
        }
        else {
            n55 = n5 - 2401053088876216593L;
            n54 -= 2401053088876216593L;
        }
        final long n56 = n54 ^ n55;
        final long n57 = n55 << 15 | n55 >>> 49;
        final long n58 = n56 + n57;
        final long n59 = n3 ^ n58;
        final long n60 = n58 << 52 | n58 >>> 12;
        final long n61 = n59 + n60;
        final long n62 = n4 ^ n61;
        final long n63 = n61 << 26 | n61 >>> 38;
        final long n64 = n62 + n63;
        final long n65 = n57 ^ n64;
        final long n66 = n64 << 51 | n64 >>> 13;
        final long n67 = n65 + n66;
        final long n68 = n60 ^ n67;
        final long n69 = n67 << 28 | n67 >>> 36;
        final long n70 = n68 + n69;
        final long n71 = n63 ^ n70;
        final long n72 = n70 << 9 | n70 >>> 55;
        final long n73 = n71 + n72;
        final long n74 = n66 ^ n73;
        final long n75 = n73 << 47 | n73 >>> 17;
        final long n76 = n74 + n75;
        final long n77 = n69 ^ n76;
        final long n78 = n76 << 54 | n76 >>> 10;
        final long n79 = n77 + n78;
        final long n80 = (n72 ^ n79) + (n79 << 32 | n79 >>> 32);
        final long n81 = (n75 ^ n80) + (n80 << 25 | n80 >>> 39);
        final long n82 = n78 ^ n81;
        final long n83 = n81 << 63 | n81 >>> 1;
        final long n84 = n82 + n83;
        array2[0] = n83;
        array2[1] = n84;
    }
    
    public static long b(final long[] array, final int n, final int n2, final long[] array2) {
        if (n2 < 24) {
            a(array, n, n2, array2);
            return array2[0];
        }
        long n6;
        long n5;
        long n4;
        long n3 = n4 = (n5 = (n6 = array2[0]));
        long n10;
        long n9;
        long n8;
        long n7 = n8 = (n9 = (n10 = array2[1]));
        long n14;
        long n13;
        long n12;
        long n11 = n12 = (n13 = (n14 = -2401053088876216593L));
        int n15 = n;
        int i;
        for (i = n2; i >= 12; i -= 12) {
            final long n16 = n4 + array[n15];
            final long n17 = n12 ^ n10;
            final long n18 = n14 ^ n16;
            final long n19 = n16 << 11 | n16 >>> 53;
            final long n20 = n18 + n8;
            final long n21 = n8 + array[n15 + 1];
            final long n22 = n3 ^ n20;
            final long n23 = n19 ^ n21;
            final long n24 = n21 << 32 | n21 >>> 32;
            final long n25 = n23 + n17;
            final long n26 = n17 + array[n15 + 2];
            final long n27 = n7 ^ n25;
            final long n28 = n24 ^ n26;
            final long n29 = n26 << 43 | n26 >>> 21;
            final long n30 = n28 + n22;
            final long n31 = n22 + array[n15 + 3];
            final long n32 = n11 ^ n30;
            final long n33 = n29 ^ n31;
            final long n34 = n31 << 31 | n31 >>> 33;
            n12 = n33 + n27;
            final long n35 = n27 + array[n15 + 4];
            final long n36 = n5 ^ n12;
            final long n37 = n34 ^ n35;
            final long n38 = n35 << 17 | n35 >>> 47;
            n3 = n37 + n32;
            final long n39 = n32 + array[n15 + 5];
            final long n40 = n9 ^ n3;
            final long n41 = n38 ^ n39;
            final long n42 = n39 << 28 | n39 >>> 36;
            n7 = n41 + n36;
            final long n43 = n36 + array[n15 + 6];
            final long n44 = n13 ^ n7;
            final long n45 = n42 ^ n43;
            final long n46 = n43 << 39 | n43 >>> 25;
            n11 = n45 + n40;
            final long n47 = n40 + array[n15 + 7];
            final long n48 = n6 ^ n11;
            final long n49 = n46 ^ n47;
            final long n50 = n47 << 57 | n47 >>> 7;
            n5 = n49 + n44;
            final long n51 = n44 + array[n15 + 8];
            final long n52 = n10 ^ n5;
            final long n53 = n50 ^ n51;
            final long n54 = n51 << 55 | n51 >>> 9;
            n9 = n53 + n48;
            final long n55 = n48 + array[n15 + 9];
            final long n56 = n20 ^ n9;
            final long n57 = n54 ^ n55;
            final long n58 = n55 << 54 | n55 >>> 10;
            n13 = n57 + n52;
            final long n59 = n52 + array[n15 + 10];
            n4 = (n25 ^ n13);
            final long n60 = n58 ^ n59;
            final long n61 = n59 << 22 | n59 >>> 42;
            n6 = n60 + n56;
            final long n62 = n56 + array[n15 + 11];
            n8 = (n30 ^ n6);
            final long n63 = n61 ^ n62;
            n14 = (n62 << 46 | n62 >>> 18);
            n10 = n63 + n4;
            n15 += 12;
        }
        switch (i) {
            case 11: {
                n10 += array[n15 + 10];
            }
            case 10: {
                n6 += array[n15 + 9];
            }
            case 9: {
                n13 += array[n15 + 8];
            }
            case 8: {
                n9 += array[n15 + 7];
            }
            case 7: {
                n5 += array[n15 + 6];
            }
            case 6: {
                n11 += array[n15 + 5];
            }
            case 5: {
                n7 += array[n15 + 4];
            }
            case 4: {
                n3 += array[n15 + 3];
            }
            case 3: {
                n12 += array[n15 + 2];
            }
            case 2: {
                n8 += array[n15 + 1];
            }
            case 1: {
                n4 += array[n15];
                break;
            }
        }
        long n64 = n14 + ((long)(i << 3) << 56);
        for (int j = 0; j < 3; ++j) {
            final long n65 = n64 + n8;
            final long n66 = n12 ^ n65;
            final long n67 = n8 << 44 | n8 >>> 20;
            final long n68 = n4 + n66;
            final long n69 = n3 ^ n68;
            final long n70 = n66 << 15 | n66 >>> 49;
            final long n71 = n67 + n69;
            final long n72 = n7 ^ n71;
            final long n73 = n69 << 34 | n69 >>> 30;
            n12 = n70 + n72;
            final long n74 = n11 ^ n12;
            final long n75 = n72 << 21 | n72 >>> 43;
            n3 = n73 + n74;
            final long n76 = n5 ^ n3;
            final long n77 = n74 << 38 | n74 >>> 26;
            n7 = n75 + n76;
            final long n78 = n9 ^ n7;
            final long n79 = n76 << 33 | n76 >>> 31;
            n11 = n77 + n78;
            final long n80 = n13 ^ n11;
            final long n81 = n78 << 10 | n78 >>> 54;
            n5 = n79 + n80;
            final long n82 = n6 ^ n5;
            final long n83 = n80 << 13 | n80 >>> 51;
            n9 = n81 + n82;
            final long n84 = n10 ^ n9;
            final long n85 = n82 << 38 | n82 >>> 26;
            n13 = n83 + n84;
            final long n86 = n65 ^ n13;
            final long n87 = n84 << 53 | n84 >>> 11;
            n6 = n85 + n86;
            final long n88 = n68 ^ n6;
            n64 = (n86 << 42 | n86 >>> 22);
            n10 = n87 + n88;
            n8 = (n71 ^ n10);
            n4 = (n88 << 54 | n88 >>> 10);
        }
        array2[0] = n4;
        array2[1] = n8;
        return n4;
    }
    
    public hh() {
        this(0L, 0L);
    }
    
    public hh(final long sg, final long sh) {
        this.sG = sg;
        this.sH = sh;
    }
    
    public static long a(final byte[] array, final long[] array2) {
        return b(array, 0, array.length, array2);
    }
    
    public long[] c(final byte[] array, final int n, final int n2) {
        final long[] array2 = { this.sG, this.sH };
        b(array, n, n2, array2);
        return array2;
    }
    
    public long[] j(final byte[] array) {
        return this.c(array, 0, array.length);
    }
    
    public static long a(final CharSequence charSequence, final long[] array) {
        return b(charSequence, 0, charSequence.length(), array);
    }
    
    public long[] b(final CharSequence charSequence, final int n, final int n2) {
        final long[] array = { this.sG, this.sH };
        b(charSequence, n, n2, array);
        return array;
    }
    
    public long[] a(final CharSequence charSequence) {
        return this.b(charSequence, 0, charSequence.length());
    }
    
    public static long a(final long[] array, final long[] array2) {
        return b(array, 0, array.length, array2);
    }
    
    public long[] b(final long[] array, final int n, final int n2) {
        final long[] array2 = { this.sG, this.sH };
        b(array, n, n2, array2);
        return array2;
    }
    
    public long[] b(final long[] array) {
        return this.b(array, 0, array.length);
    }
}
