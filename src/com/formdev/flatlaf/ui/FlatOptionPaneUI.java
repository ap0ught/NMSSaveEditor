// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.Icon;
import java.awt.GridBagConstraints;
import com.formdev.flatlaf.util.SwingUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import javax.swing.JRootPane;
import java.awt.Component;
import javax.swing.SwingUtilities;
import java.beans.PropertyChangeListener;
import java.awt.Container;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class FlatOptionPaneUI extends BasicOptionPaneUI
{
    protected boolean showIcon;
    protected int iconMessageGap;
    protected int messagePadding;
    protected int maxCharactersPerLine;
    private int focusWidth;
    private boolean sameSizeButtons;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatOptionPaneUI();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.showIcon = UIManager.getBoolean("OptionPane.showIcon");
        this.iconMessageGap = UIManager.getInt("OptionPane.iconMessageGap");
        this.messagePadding = UIManager.getInt("OptionPane.messagePadding");
        this.maxCharactersPerLine = UIManager.getInt("OptionPane.maxCharactersPerLine");
        this.focusWidth = UIManager.getInt("Component.focusWidth");
        this.sameSizeButtons = FlatUIUtils.getUIBoolean("OptionPane.sameSizeButtons", true);
    }
    
    @Override
    protected void installComponents() {
        super.installComponents();
        this.updateChildPanels(this.optionPane);
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        final PropertyChangeListener superListener = super.createPropertyChangeListener();
        return e -> {
            superListener.propertyChange(e);
            if (!this.showIcon && "ancestor".equals(e.getPropertyName()) && e.getNewValue() != null) {
                final JRootPane rootPane = SwingUtilities.getRootPane(this.optionPane);
                if (rootPane != null && rootPane.getContentPane().getComponentCount() > 0 && rootPane.getContentPane().getComponent(0) == this.optionPane) {
                    rootPane.putClientProperty("JRootPane.titleBarShowIcon", false);
                }
            }
        };
    }
    
    @Override
    public Dimension getMinimumOptionPaneSize() {
        return UIScale.scale(super.getMinimumOptionPaneSize());
    }
    
    @Override
    protected int getMaxCharactersPerLineCount() {
        final int max = super.getMaxCharactersPerLineCount();
        return (this.maxCharactersPerLine > 0 && max == Integer.MAX_VALUE) ? this.maxCharactersPerLine : max;
    }
    
    @Override
    protected Container createMessageArea() {
        final Container messageArea = super.createMessageArea();
        if (this.iconMessageGap > 0) {
            final Component iconMessageSeparator = SwingUtils.getComponentByName(messageArea, "OptionPane.separator");
            if (iconMessageSeparator != null) {
                iconMessageSeparator.setPreferredSize(new Dimension(UIScale.scale(this.iconMessageGap), 1));
            }
        }
        return messageArea;
    }
    
    @Override
    protected Container createButtonArea() {
        final Container buttonArea = super.createButtonArea();
        if (buttonArea.getLayout() instanceof ButtonAreaLayout) {
            final ButtonAreaLayout layout = (ButtonAreaLayout)buttonArea.getLayout();
            layout.setPadding(UIScale.scale(layout.getPadding() - this.focusWidth * 2));
        }
        return buttonArea;
    }
    
    @Override
    protected void addMessageComponents(final Container container, final GridBagConstraints cons, Object msg, int maxll, final boolean internallyCreated) {
        if (this.messagePadding > 0) {
            cons.insets.bottom = UIScale.scale(this.messagePadding);
        }
        if (msg != null && !(msg instanceof Component) && !(msg instanceof Object[]) && !(msg instanceof Icon)) {
            msg = msg.toString();
            if (BasicHTML.isHTMLString((String)msg)) {
                maxll = Integer.MAX_VALUE;
            }
        }
        if (msg instanceof Box) {
            final Box box = (Box)msg;
            if ("OptionPane.verticalBox".equals(box.getName()) && box.getLayout() instanceof BoxLayout && ((BoxLayout)box.getLayout()).getAxis() == 1) {
                box.addPropertyChangeListener("componentOrientation", e -> {
                    final float alignX = box.getComponentOrientation().isLeftToRight() ? 0.0f : 1.0f;
                    box.getComponents();
                    final Component[] array;
                    int i = 0;
                    for (int length = array.length; i < length; ++i) {
                        final Component c = array[i];
                        if (c instanceof JLabel && "OptionPane.label".equals(c.getName())) {
                            ((JLabel)c).setAlignmentX(alignX);
                        }
                    }
                    return;
                });
            }
        }
        super.addMessageComponents(container, cons, msg, maxll, internallyCreated);
    }
    
    private void updateChildPanels(final Container c) {
        for (final Component child : c.getComponents()) {
            if (child.getClass() == JPanel.class) {
                final JPanel panel = (JPanel)child;
                panel.setOpaque(false);
                final Border border = panel.getBorder();
                if (border instanceof UIResource) {
                    panel.setBorder(FlatUIUtils.nonUIResource(border));
                }
            }
            if (child instanceof Container) {
                this.updateChildPanels((Container)child);
            }
        }
    }
    
    @Override
    protected boolean getSizeButtonsToSameWidth() {
        return this.sameSizeButtons;
    }
}
