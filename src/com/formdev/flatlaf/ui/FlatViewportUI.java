// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.lang.reflect.Method;
import java.awt.Component;
import javax.swing.JViewport;
import java.awt.Graphics;
import java.util.function.Supplier;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicViewportUI;

public class FlatViewportUI extends BasicViewportUI
{
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.createSharedUI(FlatViewportUI.class, (Supplier<ComponentUI>)FlatViewportUI::new);
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        super.paint(g, c);
        final Component view = ((JViewport)c).getView();
        if (view instanceof JComponent) {
            try {
                final Method m = view.getClass().getMethod("getUI", (Class<?>[])new Class[0]);
                final Object ui = m.invoke(view, new Object[0]);
                if (ui instanceof ViewportPainter) {
                    ((ViewportPainter)ui).paintViewport(g, (JComponent)view, (JViewport)c);
                }
            }
            catch (final Exception ex) {}
        }
    }
    
    public interface ViewportPainter
    {
        void paintViewport(final Graphics p0, final JComponent p1, final JViewport p2);
    }
}
