// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf;

import javax.swing.LookAndFeel;

public class FlatDarkLaf extends FlatLaf
{
    public static final String NAME = "FlatLaf Dark";
    
    public static boolean setup() {
        return FlatLaf.setup(new FlatDarkLaf());
    }
    
    @Deprecated
    public static boolean install() {
        return setup();
    }
    
    public static void installLafInfo() {
        FlatLaf.installLafInfo("FlatLaf Dark", FlatDarkLaf.class);
    }
    
    @Override
    public String getName() {
        return "FlatLaf Dark";
    }
    
    @Override
    public String getDescription() {
        return "FlatLaf Dark Look and Feel";
    }
    
    @Override
    public boolean isDark() {
        return true;
    }
}
