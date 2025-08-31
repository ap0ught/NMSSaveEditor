// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.Icon;
import com.formdev.flatlaf.util.ScaledImageIcon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import com.formdev.flatlaf.util.UIScale;
import java.awt.LayoutManager;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class FlatInternalFrameTitlePane extends BasicInternalFrameTitlePane
{
    private JLabel titleLabel;
    private JPanel buttonPanel;
    
    public FlatInternalFrameTitlePane(final JInternalFrame f) {
        super(f);
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.installBorder(this, "InternalFrameTitlePane.border");
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        return new FlatPropertyChangeHandler();
    }
    
    @Override
    protected LayoutManager createLayout() {
        return new BorderLayout(UIScale.scale(4), 0);
    }
    
    @Override
    protected void createButtons() {
        super.createButtons();
        this.iconButton.setContentAreaFilled(false);
        this.maxButton.setContentAreaFilled(false);
        this.closeButton.setContentAreaFilled(false);
        final Border emptyBorder = BorderFactory.createEmptyBorder();
        this.iconButton.setBorder(emptyBorder);
        this.maxButton.setBorder(emptyBorder);
        this.closeButton.setBorder(emptyBorder);
        this.updateButtonsVisibility();
    }
    
    @Override
    protected void addSubComponents() {
        (this.titleLabel = new JLabel(this.frame.getTitle())).setFont(FlatUIUtils.nonUIResource(this.getFont()));
        this.titleLabel.setMinimumSize(new Dimension(UIScale.scale(32), 1));
        this.updateFrameIcon();
        this.updateColors();
        (this.buttonPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                final Dimension size = super.getPreferredSize();
                int height = size.height;
                if (!FlatInternalFrameTitlePane.this.iconButton.isVisible()) {
                    height = Math.max(height, FlatInternalFrameTitlePane.this.iconButton.getPreferredSize().height);
                }
                if (!FlatInternalFrameTitlePane.this.maxButton.isVisible()) {
                    height = Math.max(height, FlatInternalFrameTitlePane.this.maxButton.getPreferredSize().height);
                }
                if (!FlatInternalFrameTitlePane.this.closeButton.isVisible()) {
                    height = Math.max(height, FlatInternalFrameTitlePane.this.closeButton.getPreferredSize().height);
                }
                return new Dimension(size.width, height);
            }
        }).setLayout(new BoxLayout(this.buttonPanel, 2));
        this.buttonPanel.setOpaque(false);
        this.buttonPanel.add(this.iconButton);
        this.buttonPanel.add(this.maxButton);
        this.buttonPanel.add(this.closeButton);
        this.add(this.titleLabel, "Center");
        this.add(this.buttonPanel, "After");
    }
    
    protected void updateFrameIcon() {
        Icon frameIcon = this.frame.getFrameIcon();
        if (frameIcon != null && (frameIcon.getIconWidth() == 0 || frameIcon.getIconHeight() == 0)) {
            frameIcon = null;
        }
        else if (frameIcon instanceof ImageIcon) {
            frameIcon = new ScaledImageIcon((ImageIcon)frameIcon);
        }
        this.titleLabel.setIcon(frameIcon);
    }
    
    protected void updateColors() {
        final Color background = FlatUIUtils.nonUIResource(this.frame.isSelected() ? this.selectedTitleColor : this.notSelectedTitleColor);
        final Color foreground = FlatUIUtils.nonUIResource(this.frame.isSelected() ? this.selectedTextColor : this.notSelectedTextColor);
        this.titleLabel.setForeground(foreground);
        this.iconButton.setBackground(background);
        this.iconButton.setForeground(foreground);
        this.maxButton.setBackground(background);
        this.maxButton.setForeground(foreground);
        this.closeButton.setBackground(background);
        this.closeButton.setForeground(foreground);
    }
    
    protected void updateButtonsVisibility() {
        this.iconButton.setVisible(this.frame.isIconifiable());
        this.maxButton.setVisible(this.frame.isMaximizable());
        this.closeButton.setVisible(this.frame.isClosable());
    }
    
    Rectangle getFrameIconBounds() {
        final Icon icon = this.titleLabel.getIcon();
        if (icon == null) {
            return null;
        }
        final int iconWidth = icon.getIconWidth();
        final int iconHeight = icon.getIconHeight();
        final boolean leftToRight = this.titleLabel.getComponentOrientation().isLeftToRight();
        final int x = this.titleLabel.getX() + (leftToRight ? 0 : (this.titleLabel.getWidth() - iconWidth));
        final int y = this.titleLabel.getY() + (this.titleLabel.getHeight() - iconHeight) / 2;
        return new Rectangle(x, y, iconWidth, iconHeight);
    }
    
    @Override
    protected void assembleSystemMenu() {
    }
    
    @Override
    protected void showSystemMenu() {
    }
    
    @Override
    public void paintComponent(final Graphics g) {
        this.paintTitleBackground(g);
    }
    
    protected class FlatPropertyChangeHandler extends PropertyChangeHandler
    {
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String propertyName = e.getPropertyName();
            switch (propertyName) {
                case "title": {
                    FlatInternalFrameTitlePane.this.titleLabel.setText(FlatInternalFrameTitlePane.this.frame.getTitle());
                    break;
                }
                case "frameIcon": {
                    FlatInternalFrameTitlePane.this.updateFrameIcon();
                    break;
                }
                case "selected": {
                    FlatInternalFrameTitlePane.this.updateColors();
                    break;
                }
                case "iconable":
                case "maximizable":
                case "closable": {
                    FlatInternalFrameTitlePane.this.updateButtonsVisibility();
                    BasicInternalFrameTitlePane.this.enableActions();
                    FlatInternalFrameTitlePane.this.revalidate();
                    FlatInternalFrameTitlePane.this.repaint();
                    return;
                }
                case "componentOrientation": {
                    FlatInternalFrameTitlePane.this.applyComponentOrientation(FlatInternalFrameTitlePane.this.frame.getComponentOrientation());
                    break;
                }
                case "opaque": {
                    return;
                }
            }
            super.propertyChange(e);
        }
    }
}
