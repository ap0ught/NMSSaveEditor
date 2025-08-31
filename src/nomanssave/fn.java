// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum fn
{
    lm("NORMAL", 0), 
    ln("SURVIVAL", 1), 
    lo("CREATIVE", 2), 
    lp("AMBIENT", 3), 
    lq("PERMADEATH", 4), 
    lr("EXPEDITION", 5), 
    ls("RELAXED", 6), 
    lt("CUSTOM", 7);
    
    private static final Pattern lu;
    private static final Pattern lv;
    private static final Pattern lw;
    private static final Pattern lx;
    
    static {
        ly = new fn[] { fn.lm, fn.ln, fn.lo, fn.lp, fn.lq, fn.lr, fn.ls, fn.lt };
        lu = Pattern.compile("\"((?:XTp)|(?:ActiveContext))\":\"([^\"]+)\",");
        lv = Pattern.compile("\"((?:vLc)|(?:BaseContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
        lw = Pattern.compile("\"((?:2YS)|(?:ExpeditionContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
        lx = Pattern.compile("\"((?:7ND)|(?:DifficultyPresetType))\":\"(\\w+)\"");
    }
    
    private fn(final String name, final int ordinal) {
    }
    
    private static fn S(final String s) {
        fn[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final fn fn = values[i];
            if (s.equalsIgnoreCase(fn.name())) {
                return fn;
            }
        }
        return null;
    }
    
    public static fn T(final String s) {
        Matcher matcher = fn.lu.matcher(s);
        if (matcher.find()) {
            final String group = matcher.group(2);
            if ("Main".equals(group)) {
                matcher = fn.lv.matcher(s);
            }
            else if ("Season".equals(group)) {
                matcher = fn.lw.matcher(s);
            }
            if (matcher.find()) {
                final int int1 = Integer.parseInt(matcher.group(3));
                if (int1 > 0 && int1 <= values().length) {
                    return values()[int1 - 1];
                }
            }
        }
        final Matcher matcher2 = fn.lx.matcher(s);
        if (matcher2.find()) {
            return S(matcher2.group(2));
        }
        return null;
    }
    
    public static fn i(final eY ey) {
        final String valueAsString = ey.getValueAsString("ActiveContext");
        if ("Main".equals(valueAsString)) {
            final int j = ey.J("BaseContext.GameMode");
            if (j > 0 && j <= values().length) {
                return values()[j - 1];
            }
        }
        else if ("Season".equals(valueAsString)) {
            final int i = ey.J("ExpeditionContext.GameMode");
            if (i > 0 && i <= values().length) {
                return values()[i - 1];
            }
        }
        final String valueAsString2 = ey.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
        if (valueAsString2 != null) {
            return S(valueAsString2);
        }
        return null;
    }
}
