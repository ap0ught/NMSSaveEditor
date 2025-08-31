// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.awt.Component;
import java.awt.Container;

public class SwingUtils
{
    public static <T extends Component> T getComponentByName(final Container parent, final String name) {
        for (final Component child : parent.getComponents()) {
            if (name.equals(child.getName())) {
                return (T)child;
            }
            if (child instanceof Container) {
                final T c = (T)getComponentByName((Container)child, name);
                if (c != null) {
                    return c;
                }
            }
        }
        return null;
    }
}
