// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.themes;

import javax.swing.LookAndFeel;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class FlatMacLightLaf extends FlatLightLaf
{
    public static final String NAME = "FlatLaf macOS Light";
    
    public static boolean setup() {
        return FlatLaf.setup(new FlatMacLightLaf());
    }
    
    public static void installLafInfo() {
        FlatLaf.installLafInfo("FlatLaf macOS Light", FlatMacLightLaf.class);
    }
    
    @Override
    public String getName() {
        return "FlatLaf macOS Light";
    }
    
    @Override
    public String getDescription() {
        return "FlatLaf macOS Light Look and Feel";
    }
    
    @Override
    public boolean isDark() {
        return false;
    }
}
