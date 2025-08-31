// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gW
{
    public static void i(final byte[] array) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Data: " + array.length);
        sb.append(System.lineSeparator());
        sb.append("  ");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toString((array[i] & 0xF0) >> 4, 16));
            sb.append(Integer.toString(array[i] & 0xF, 16));
            if (array[i] >= 32 && array[i] < 127) {
                sb2.append((char)(array[i] & 0xFF));
            }
            else {
                sb2.append('?');
            }
            if (i % 16 == 15) {
                sb.append("  ");
                sb.append((CharSequence)sb2);
                sb.append(System.lineSeparator());
                sb.append("  ");
                sb2 = new StringBuilder();
            }
        }
        if (sb2.length() > 0) {
            while (sb2.length() < 16) {
                sb.append("  ");
                sb2.append(" ");
            }
            sb.append("  ");
            sb.append((CharSequence)sb2);
        }
        System.out.println(sb.toString());
    }
    
    public static void a(final long[] array) {
        final byte[] array2 = new byte[array.length * 4];
        for (int i = 0; i < array.length; ++i) {
            array2[i * 4 + 3] = (byte)(array[i] >> 24 & 0xFFL);
            array2[i * 4 + 2] = (byte)(array[i] >> 16 & 0xFFL);
            array2[i * 4 + 1] = (byte)(array[i] >> 8 & 0xFFL);
            array2[i * 4] = (byte)(array[i] & 0xFFL);
        }
        i(array2);
    }
}
