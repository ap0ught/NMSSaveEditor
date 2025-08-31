// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.awt.Insets;
import java.awt.FontMetrics;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.util.StringUtils;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import javax.swing.JToolTip;
import java.util.function.Supplier;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.beans.PropertyChangeListener;
import javax.swing.plaf.basic.BasicToolTipUI;

public class FlatToolTipUI extends BasicToolTipUI implements PropertyChangeListener
{
    public static ComponentUI createUI(final JComponent c) {
        return FlatUIUtils.createSharedUI(FlatToolTipUI.class, (Supplier<ComponentUI>)FlatToolTipUI::new);
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        FlatLabelUI.updateHTMLRenderer(c, ((JToolTip)c).getTipText(), false);
    }
    
    @Override
    protected void installListeners(final JComponent c) {
        super.installListeners(c);
        c.addPropertyChangeListener(this);
    }
    
    @Override
    protected void uninstallListeners(final JComponent c) {
        super.uninstallListeners(c);
        c.removePropertyChangeListener(this);
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        final String name = e.getPropertyName();
        if (name == "tiptext" || name == "font" || name == "foreground") {
            final JToolTip toolTip = (JToolTip)e.getSource();
            FlatLabelUI.updateHTMLRenderer(toolTip, toolTip.getTipText(), false);
        }
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        final String text = ((JToolTip)c).getTipText();
        if (text == null || text.isEmpty()) {
            return new Dimension();
        }
        if (this.isMultiLine(c)) {
            final FontMetrics fm = c.getFontMetrics(c.getFont());
            final Insets insets = c.getInsets();
            final List<String> lines = StringUtils.split(((JToolTip)c).getTipText(), '\n');
            int width = 0;
            final int height = fm.getHeight() * Math.max(lines.size(), 1);
            for (final String line : lines) {
                width = Math.max(width, SwingUtilities.computeStringWidth(fm, line));
            }
            return new Dimension(insets.left + width + insets.right + 6, insets.top + height + insets.bottom);
        }
        return super.getPreferredSize(c);
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        if (this.isMultiLine(c)) {
            final FontMetrics fm = c.getFontMetrics(c.getFont());
            final Insets insets = c.getInsets();
            g.setColor(c.getForeground());
            final List<String> lines = StringUtils.split(((JToolTip)c).getTipText(), '\n');
            final int x = insets.left + 3;
            final int x2 = c.getWidth() - insets.right - 3;
            int y = insets.top - fm.getDescent();
            final int lineHeight = fm.getHeight();
            final JComponent comp = ((JToolTip)c).getComponent();
            final boolean leftToRight = ((comp != null) ? comp : c).getComponentOrientation().isLeftToRight();
            for (final String line : lines) {
                y += lineHeight;
                FlatUIUtils.drawString(c, g, line, leftToRight ? x : (x2 - SwingUtilities.computeStringWidth(fm, line)), y);
            }
        }
        else {
            super.paint(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g), c);
        }
    }
    
    private boolean isMultiLine(final JComponent c) {
        final String text = ((JToolTip)c).getTipText();
        return c.getClientProperty("html") == null && text != null && text.indexOf(10) >= 0;
    }
}
