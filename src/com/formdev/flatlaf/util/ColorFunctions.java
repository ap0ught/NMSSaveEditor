// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.awt.Color;

public class ColorFunctions
{
    public static Color lighten(final Color color, final float amount) {
        return hslIncreaseDecrease(color, amount, 2, true);
    }
    
    public static Color darken(final Color color, final float amount) {
        return hslIncreaseDecrease(color, amount, 2, false);
    }
    
    public static Color saturate(final Color color, final float amount) {
        return hslIncreaseDecrease(color, amount, 1, true);
    }
    
    public static Color desaturate(final Color color, final float amount) {
        return hslIncreaseDecrease(color, amount, 1, false);
    }
    
    public static Color spin(final Color color, final float angle) {
        return hslIncreaseDecrease(color, angle, 0, true);
    }
    
    private static Color hslIncreaseDecrease(final Color color, final float amount, final int hslIndex, final boolean increase) {
        final float[] hsl = HSLColor.fromRGB(color);
        final float alpha = color.getAlpha() / 255.0f;
        final float amount2 = increase ? amount : (-amount);
        if (hslIndex == 0) {
            hsl[0] = (hsl[0] + amount2) % 360.0f;
        }
        else {
            hsl[hslIndex] = clamp(hsl[hslIndex] + amount2 * 100.0f);
        }
        return HSLColor.toRGB(hsl[0], hsl[1], hsl[2], alpha);
    }
    
    public static Color fade(final Color color, final float amount) {
        final int newAlpha = Math.round(255.0f * amount);
        return new Color((color.getRGB() & 0xFFFFFF) | newAlpha << 24, true);
    }
    
    public static Color mix(final Color color1, final Color color2, final float weight) {
        if (weight >= 1.0f) {
            return color1;
        }
        if (weight <= 0.0f) {
            return color2;
        }
        if (color1.equals(color2)) {
            return color1;
        }
        final int r1 = color1.getRed();
        final int g1 = color1.getGreen();
        final int b1 = color1.getBlue();
        final int a1 = color1.getAlpha();
        final int r2 = color2.getRed();
        final int g2 = color2.getGreen();
        final int b2 = color2.getBlue();
        final int a2 = color2.getAlpha();
        return new Color(Math.round(r2 + (r1 - r2) * weight), Math.round(g2 + (g1 - g2) * weight), Math.round(b2 + (b1 - b2) * weight), Math.round(a2 + (a1 - a2) * weight));
    }
    
    public static Color tint(final Color color, final float weight) {
        return mix(Color.white, color, weight);
    }
    
    public static Color shade(final Color color, final float weight) {
        return mix(Color.black, color, weight);
    }
    
    public static float luma(final Color color) {
        final float r = gammaCorrection(color.getRed() / 255.0f);
        final float g = gammaCorrection(color.getGreen() / 255.0f);
        final float b = gammaCorrection(color.getBlue() / 255.0f);
        return 0.2126f * r + 0.7152f * g + 0.0722f * b;
    }
    
    private static float gammaCorrection(final float value) {
        return (value <= 0.03928f) ? (value / 12.92f) : ((float)Math.pow((value + 0.055) / 1.055, 2.4));
    }
    
    public static Color applyFunctions(final Color color, final ColorFunction... functions) {
        if (functions.length == 1 && functions[0] instanceof Mix) {
            final Mix mixFunction = (Mix)functions[0];
            return mix(color, mixFunction.color2, mixFunction.weight / 100.0f);
        }
        final float[] hsl = HSLColor.fromRGB(color);
        final float alpha = color.getAlpha() / 255.0f;
        final float[] hsla = { hsl[0], hsl[1], hsl[2], alpha * 100.0f };
        for (final ColorFunction function : functions) {
            function.apply(hsla);
        }
        return HSLColor.toRGB(hsla[0], hsla[1], hsla[2], hsla[3] / 100.0f);
    }
    
    public static float clamp(final float value) {
        return (value < 0.0f) ? 0.0f : ((value > 100.0f) ? 100.0f : value);
    }
    
    public static class HSLIncreaseDecrease implements ColorFunction
    {
        public final int hslIndex;
        public final boolean increase;
        public final float amount;
        public final boolean relative;
        public final boolean autoInverse;
        
        public HSLIncreaseDecrease(final int hslIndex, final boolean increase, final float amount, final boolean relative, final boolean autoInverse) {
            this.hslIndex = hslIndex;
            this.increase = increase;
            this.amount = amount;
            this.relative = relative;
            this.autoInverse = autoInverse;
        }
        
        @Override
        public void apply(final float[] hsla) {
            float amount2 = this.increase ? this.amount : (-this.amount);
            if (this.hslIndex == 0) {
                hsla[0] = (hsla[0] + amount2) % 360.0f;
                return;
            }
            amount2 = ((this.autoInverse && this.shouldInverse(hsla)) ? (-amount2) : amount2);
            hsla[this.hslIndex] = ColorFunctions.clamp(this.relative ? (hsla[this.hslIndex] * ((100.0f + amount2) / 100.0f)) : (hsla[this.hslIndex] + amount2));
        }
        
        protected boolean shouldInverse(final float[] hsla) {
            return this.increase ? (hsla[this.hslIndex] > 65.0f) : (hsla[this.hslIndex] < 35.0f);
        }
        
        @Override
        public String toString() {
            String name = null;
            switch (this.hslIndex) {
                case 0: {
                    name = "spin";
                    break;
                }
                case 1: {
                    name = (this.increase ? "saturate" : "desaturate");
                    break;
                }
                case 2: {
                    name = (this.increase ? "lighten" : "darken");
                    break;
                }
                case 3: {
                    name = (this.increase ? "fadein" : "fadeout");
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
            return String.format("%s(%.0f%%%s%s)", name, this.amount, this.relative ? " relative" : "", this.autoInverse ? " autoInverse" : "");
        }
    }
    
    public static class HSLChange implements ColorFunction
    {
        public final int hslIndex;
        public final float value;
        
        public HSLChange(final int hslIndex, final float value) {
            this.hslIndex = hslIndex;
            this.value = value;
        }
        
        @Override
        public void apply(final float[] hsla) {
            hsla[this.hslIndex] = ((this.hslIndex == 0) ? (this.value % 360.0f) : ColorFunctions.clamp(this.value));
        }
        
        @Override
        public String toString() {
            String name = null;
            switch (this.hslIndex) {
                case 0: {
                    name = "changeHue";
                    break;
                }
                case 1: {
                    name = "changeSaturation";
                    break;
                }
                case 2: {
                    name = "changeLightness";
                    break;
                }
                case 3: {
                    name = "changeAlpha";
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
            return String.format("%s(%.0f%s)", name, this.value, (this.hslIndex == 0) ? "" : "%");
        }
    }
    
    public static class Fade implements ColorFunction
    {
        public final float amount;
        
        public Fade(final float amount) {
            this.amount = amount;
        }
        
        @Override
        public void apply(final float[] hsla) {
            hsla[3] = ColorFunctions.clamp(this.amount);
        }
        
        @Override
        public String toString() {
            return String.format("fade(%.0f%%)", this.amount);
        }
    }
    
    public static class Mix implements ColorFunction
    {
        public final Color color2;
        public final float weight;
        
        public Mix(final Color color2, final float weight) {
            this.color2 = color2;
            this.weight = weight;
        }
        
        @Override
        public void apply(final float[] hsla) {
            final Color color1 = HSLColor.toRGB(hsla[0], hsla[1], hsla[2], hsla[3] / 100.0f);
            final Color color2 = ColorFunctions.mix(color1, this.color2, this.weight / 100.0f);
            final float[] hsl = HSLColor.fromRGB(color2);
            System.arraycopy(hsl, 0, hsla, 0, hsl.length);
            hsla[3] = color2.getAlpha() / 255.0f * 100.0f;
        }
        
        @Override
        public String toString() {
            return String.format("mix(#%08x,%.0f%%)", this.color2.getRGB(), this.weight);
        }
    }
    
    public interface ColorFunction
    {
        void apply(final float[] p0);
    }
}
