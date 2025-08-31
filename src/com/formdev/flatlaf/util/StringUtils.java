// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtils
{
    public static boolean isEmpty(final String string) {
        return string == null || string.isEmpty();
    }
    
    public static String removeLeading(final String string, final String leading) {
        return string.startsWith(leading) ? string.substring(leading.length()) : string;
    }
    
    public static String removeTrailing(final String string, final String trailing) {
        return string.endsWith(trailing) ? string.substring(0, string.length() - trailing.length()) : string;
    }
    
    public static List<String> split(final String str, final char delim) {
        return split(str, delim, false, false);
    }
    
    public static List<String> split(String str, final char delim, final boolean trim, final boolean excludeEmpty) {
        int delimIndex = str.indexOf(delim);
        if (delimIndex < 0) {
            if (trim) {
                str = str.trim();
            }
            return (!excludeEmpty || !str.isEmpty()) ? Collections.singletonList(str) : Collections.emptyList();
        }
        final ArrayList<String> strs = new ArrayList<String>();
        int index;
        for (index = 0; delimIndex >= 0; delimIndex = str.indexOf(delim, index)) {
            add(strs, str, index, delimIndex, trim, excludeEmpty);
            index = delimIndex + 1;
        }
        add(strs, str, index, str.length(), trim, excludeEmpty);
        return strs;
    }
    
    private static void add(final List<String> strs, final String str, int beginIndex, int endIndex, final boolean trim, final boolean excludeEmpty) {
        if (trim) {
            beginIndex = trimBegin(str, beginIndex, endIndex);
            endIndex = trimEnd(str, beginIndex, endIndex);
        }
        if (!excludeEmpty || endIndex > beginIndex) {
            strs.add(str.substring(beginIndex, endIndex));
        }
    }
    
    public static String substringTrimmed(final String str, final int beginIndex) {
        return substringTrimmed(str, beginIndex, str.length());
    }
    
    public static String substringTrimmed(final String str, int beginIndex, int endIndex) {
        beginIndex = trimBegin(str, beginIndex, endIndex);
        endIndex = trimEnd(str, beginIndex, endIndex);
        return (endIndex > beginIndex) ? str.substring(beginIndex, endIndex) : "";
    }
    
    public static boolean isTrimmedEmpty(final String str) {
        final int length = str.length();
        final int beginIndex = trimBegin(str, 0, length);
        final int endIndex = trimEnd(str, beginIndex, length);
        return beginIndex >= endIndex;
    }
    
    private static int trimBegin(final String str, int beginIndex, final int endIndex) {
        while (beginIndex < endIndex && str.charAt(beginIndex) <= ' ') {
            ++beginIndex;
        }
        return beginIndex;
    }
    
    private static int trimEnd(final String str, final int beginIndex, int endIndex) {
        while (beginIndex < endIndex && str.charAt(endIndex - 1) <= ' ') {
            --endIndex;
        }
        return endIndex;
    }
}
