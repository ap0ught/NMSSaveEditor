// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf;

import javax.swing.LookAndFeel;

public class FlatDarculaLaf extends FlatDarkLaf
{
    public static final String NAME = "FlatLaf Darcula";
    
    public static boolean setup() {
        return FlatLaf.setup(new FlatDarculaLaf());
    }
    
    @Deprecated
    public static boolean install() {
        return setup();
    }
    
    public static void installLafInfo() {
        FlatLaf.installLafInfo("FlatLaf Darcula", FlatDarculaLaf.class);
    }
    
    @Override
    public String getName() {
        return "FlatLaf Darcula";
    }
    
    @Override
    public String getDescription() {
        return "FlatLaf Darcula Look and Feel";
    }
}
