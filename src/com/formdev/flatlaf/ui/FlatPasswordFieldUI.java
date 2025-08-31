// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.text.JTextComponent;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Graphics;
import javax.swing.text.PasswordView;
import javax.swing.text.View;
import javax.swing.text.Element;
import java.awt.Color;
import java.util.Map;
import com.formdev.flatlaf.icons.FlatCapsLockIcon;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import java.awt.event.KeyListener;
import javax.swing.Icon;

public class FlatPasswordFieldUI extends FlatTextFieldUI
{
    private static final String KEY_REVEAL_SELECTED = "FlatLaf.internal.FlatPasswordFieldUI.revealSelected";
    private Character echoChar;
    @FlatStylingSupport.Styleable
    protected boolean showCapsLock;
    @FlatStylingSupport.Styleable
    protected boolean showRevealButton;
    protected Icon capsLockIcon;
    protected Icon revealIcon;
    private KeyListener capsLockListener;
    private boolean capsLockIconShared;
    private JToggleButton revealButton;
    private boolean uninstallEchoChar;
    
    public FlatPasswordFieldUI() {
        this.capsLockIconShared = true;
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatPasswordFieldUI();
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "PasswordField";
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installRevealButton();
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        this.uninstallRevealButton();
        super.uninstallUI(c);
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        final String prefix = this.getPropertyPrefix();
        this.echoChar = (Character)UIManager.get(prefix + ".echoChar");
        if (this.echoChar != null) {
            LookAndFeel.installProperty(this.getComponent(), "echoChar", this.echoChar);
        }
        this.showCapsLock = UIManager.getBoolean("PasswordField.showCapsLock");
        this.showRevealButton = UIManager.getBoolean("PasswordField.showRevealButton");
        this.capsLockIcon = UIManager.getIcon("PasswordField.capsLockIcon");
        this.revealIcon = UIManager.getIcon("PasswordField.revealIcon");
        this.capsLockIconShared = true;
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.capsLockIcon = null;
        this.revealIcon = null;
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.capsLockListener = new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                this.repaint(e);
            }
            
            @Override
            public void keyReleased(final KeyEvent e) {
                this.repaint(e);
            }
            
            private void repaint(final KeyEvent e) {
                if (e.getKeyCode() == 20) {
                    e.getComponent().repaint();
                    FlatPasswordFieldUI.this.scrollCaretToVisible();
                }
            }
        };
        this.getComponent().addKeyListener(this.capsLockListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.getComponent().removeKeyListener(this.capsLockListener);
        this.capsLockListener = null;
    }
    
    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
        final ActionMap map = SwingUtilities.getUIActionMap(this.getComponent());
        if (map != null && map.get("select-word") != null) {
            final Action selectLineAction = map.get("select-line");
            if (selectLineAction != null) {
                map.put("select-word", selectLineAction);
            }
        }
    }
    
    @Override
    String getStyleType() {
        return "PasswordField";
    }
    
    @Override
    protected void applyStyle(final Object style) {
        final boolean oldShowRevealButton = this.showRevealButton;
        super.applyStyle(style);
        if (this.showRevealButton != oldShowRevealButton) {
            this.uninstallRevealButton();
            this.installRevealButton();
        }
    }
    
    @Override
    protected Object applyStyleProperty(final String key, final Object value) {
        if (key.equals("capsLockIconColor") && this.capsLockIcon instanceof FlatCapsLockIcon) {
            if (this.capsLockIconShared) {
                this.capsLockIcon = FlatStylingSupport.cloneIcon(this.capsLockIcon);
                this.capsLockIconShared = false;
            }
            return ((FlatCapsLockIcon)this.capsLockIcon).applyStyleProperty(key, value);
        }
        return super.applyStyleProperty(key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final Map<String, Class<?>> infos = super.getStyleableInfos(c);
        infos.put("capsLockIconColor", Color.class);
        return infos;
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        if (key.equals("capsLockIconColor") && this.capsLockIcon instanceof FlatCapsLockIcon) {
            return ((FlatCapsLockIcon)this.capsLockIcon).getStyleableValue(key);
        }
        return super.getStyleableValue(c, key);
    }
    
    @Override
    public View create(final Element elem) {
        return new PasswordView(elem);
    }
    
    @Override
    protected void paintIcons(final Graphics g, final Rectangle r) {
        super.paintIcons(g, r);
        if (this.isCapsLockVisible()) {
            this.paintCapsLock(g, r);
        }
    }
    
    protected void paintCapsLock(final Graphics g, final Rectangle r) {
        final JTextComponent c = this.getComponent();
        final int x = c.getComponentOrientation().isLeftToRight() ? (r.x + r.width - this.capsLockIcon.getIconWidth()) : r.x;
        final int y = r.y + Math.round((r.height - this.capsLockIcon.getIconHeight()) / 2.0f);
        this.capsLockIcon.paintIcon(c, g, x, y);
    }
    
    @Override
    protected boolean hasTrailingIcon() {
        return super.hasTrailingIcon() || this.isCapsLockVisible();
    }
    
    @Override
    protected int getTrailingIconWidth() {
        return super.getTrailingIconWidth() + (this.isCapsLockVisible() ? (this.capsLockIcon.getIconWidth() + UIScale.scale(this.iconTextGap)) : 0);
    }
    
    protected boolean isCapsLockVisible() {
        return this.showCapsLock && FlatUIUtils.isPermanentFocusOwner(this.getComponent()) && Toolkit.getDefaultToolkit().getLockingKeyState(20);
    }
    
    protected void installRevealButton() {
        if (this.showRevealButton) {
            this.revealButton = this.createRevealButton();
            this.updateRevealButton();
            this.installLayout();
            this.getComponent().add(this.revealButton);
        }
    }
    
    protected JToggleButton createRevealButton() {
        final JPasswordField c = (JPasswordField)this.getComponent();
        final JToggleButton button = new JToggleButton(this.revealIcon, !c.echoCharIsSet());
        button.setName("PasswordField.revealButton");
        this.prepareLeadingOrTrailingComponent(button);
        button.putClientProperty("FlatLaf.styleClass", "inTextField revealButton");
        if (FlatClientProperties.clientPropertyBoolean(c, "FlatLaf.internal.FlatPasswordFieldUI.revealSelected", false)) {
            button.setSelected(true);
            this.updateEchoChar(true);
        }
        button.addActionListener(e -> {
            final boolean selected = button.isSelected();
            this.updateEchoChar(selected);
            c.putClientProperty("FlatLaf.internal.FlatPasswordFieldUI.revealSelected", selected);
            return;
        });
        return button;
    }
    
    protected void updateRevealButton() {
        if (this.revealButton == null) {
            return;
        }
        final JTextComponent c = this.getComponent();
        final boolean visible = c.isEnabled();
        if (visible != this.revealButton.isVisible()) {
            this.revealButton.setVisible(visible);
            c.revalidate();
            c.repaint();
            if (!visible) {
                this.revealButton.setSelected(false);
                this.updateEchoChar(false);
                this.getComponent().putClientProperty("FlatLaf.internal.FlatPasswordFieldUI.revealSelected", null);
            }
        }
    }
    
    @Override
    protected void propertyChange(final PropertyChangeEvent e) {
        super.propertyChange(e);
        final String propertyName = e.getPropertyName();
        switch (propertyName) {
            case "enabled": {
                this.updateRevealButton();
                break;
            }
        }
    }
    
    private void updateEchoChar(final boolean selected) {
        final char newEchoChar = selected ? '\0' : ((this.echoChar != null) ? this.echoChar : '*');
        final JPasswordField c = (JPasswordField)this.getComponent();
        if (newEchoChar == c.getEchoChar()) {
            return;
        }
        LookAndFeel.installProperty(c, "echoChar", newEchoChar);
        final char actualEchoChar = c.getEchoChar();
        if (actualEchoChar != newEchoChar) {
            if (selected && actualEchoChar != '\0') {
                this.echoChar = actualEchoChar;
                this.uninstallEchoChar = true;
            }
            c.setEchoChar(newEchoChar);
        }
    }
    
    protected void uninstallRevealButton() {
        if (this.revealButton != null) {
            if (this.uninstallEchoChar && this.revealButton.isSelected()) {
                ((JPasswordField)this.getComponent()).setEchoChar(this.echoChar);
            }
            this.getComponent().remove(this.revealButton);
            this.revealButton = null;
        }
    }
    
    @Override
    protected JComponent[] getTrailingComponents() {
        return new JComponent[] { this.trailingComponent, this.revealButton, this.clearButton };
    }
}
