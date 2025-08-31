// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Window;
import com.formdev.flatlaf.util.SystemInfo;

public class FlatNativeWindowsLibrary
{
    private static long osBuildNumber;
    public static final int DWMWCP_DEFAULT = 0;
    public static final int DWMWCP_DONOTROUND = 1;
    public static final int DWMWCP_ROUND = 2;
    public static final int DWMWCP_ROUNDSMALL = 3;
    
    public static boolean isLoaded() {
        return SystemInfo.isWindows && FlatNativeLibrary.isLoaded();
    }
    
    public static long getOSBuildNumber() {
        if (FlatNativeWindowsLibrary.osBuildNumber == Long.MIN_VALUE) {
            FlatNativeWindowsLibrary.osBuildNumber = getOSBuildNumberImpl();
        }
        return FlatNativeWindowsLibrary.osBuildNumber;
    }
    
    private static native long getOSBuildNumberImpl();
    
    public static native long getHWND(final Window p0);
    
    public static native boolean setWindowCornerPreference(final long p0, final int p1);
    
    public static native boolean setWindowBorderColor(final long p0, final int p1, final int p2, final int p3);
    
    static {
        FlatNativeWindowsLibrary.osBuildNumber = Long.MIN_VALUE;
    }
}
