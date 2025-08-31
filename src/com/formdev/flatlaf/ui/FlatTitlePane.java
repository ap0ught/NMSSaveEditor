// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.ComponentEvent;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.FontMetrics;
import javax.swing.border.AbstractBorder;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.AWTEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.GraphicsConfiguration;
import java.util.Objects;
import java.util.Iterator;
import java.awt.Graphics;
import java.awt.EventQueue;
import javax.swing.Box;
import java.awt.event.ComponentListener;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;
import java.awt.Dialog;
import java.awt.Image;
import javax.swing.JDialog;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Frame;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.Point;
import javax.swing.Icon;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.plaf.LabelUI;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.util.List;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;

public class FlatTitlePane extends JComponent
{
    private static final String KEY_DEBUG_SHOW_RECTANGLES = "FlatLaf.debug.titlebar.showRectangles";
    protected final Font titleFont;
    protected final Color activeBackground;
    protected final Color inactiveBackground;
    protected final Color activeForeground;
    protected final Color inactiveForeground;
    protected final Color embeddedForeground;
    protected final Color borderColor;
    protected final boolean showIcon;
    protected final boolean showIconInDialogs;
    protected final int noIconLeftGap;
    protected final Dimension iconSize;
    protected final int titleMinimumWidth;
    protected final int buttonMinimumWidth;
    protected final int buttonMaximizedHeight;
    protected final boolean centerTitle;
    protected final boolean centerTitleIfMenuBarEmbedded;
    protected final boolean showIconBesideTitle;
    protected final int menuBarTitleGap;
    protected final int menuBarTitleMinimumGap;
    protected final int menuBarResizeHeight;
    protected final JRootPane rootPane;
    protected JPanel leftPanel;
    protected JLabel iconLabel;
    protected JComponent menuBarPlaceholder;
    protected JLabel titleLabel;
    protected JPanel buttonPanel;
    protected JButton iconifyButton;
    protected JButton maximizeButton;
    protected JButton restoreButton;
    protected JButton closeButton;
    protected Window window;
    private final Handler handler;
    private int laterCounter;
    private int debugTitleBarHeight;
    private List<Rectangle> debugHitTestSpots;
    private Rectangle debugAppIconBounds;
    private Rectangle debugMinimizeButtonBounds;
    private Rectangle debugMaximizeButtonBounds;
    private Rectangle debugCloseButtonBounds;
    
    public FlatTitlePane(final JRootPane rootPane) {
        this.titleFont = UIManager.getFont("TitlePane.font");
        this.activeBackground = UIManager.getColor("TitlePane.background");
        this.inactiveBackground = UIManager.getColor("TitlePane.inactiveBackground");
        this.activeForeground = UIManager.getColor("TitlePane.foreground");
        this.inactiveForeground = UIManager.getColor("TitlePane.inactiveForeground");
        this.embeddedForeground = UIManager.getColor("TitlePane.embeddedForeground");
        this.borderColor = UIManager.getColor("TitlePane.borderColor");
        this.showIcon = FlatUIUtils.getUIBoolean("TitlePane.showIcon", true);
        this.showIconInDialogs = FlatUIUtils.getUIBoolean("TitlePane.showIconInDialogs", true);
        this.noIconLeftGap = FlatUIUtils.getUIInt("TitlePane.noIconLeftGap", 8);
        this.iconSize = UIManager.getDimension("TitlePane.iconSize");
        this.titleMinimumWidth = FlatUIUtils.getUIInt("TitlePane.titleMinimumWidth", 60);
        this.buttonMinimumWidth = FlatUIUtils.getUIInt("TitlePane.buttonMinimumWidth", 30);
        this.buttonMaximizedHeight = UIManager.getInt("TitlePane.buttonMaximizedHeight");
        this.centerTitle = UIManager.getBoolean("TitlePane.centerTitle");
        this.centerTitleIfMenuBarEmbedded = FlatUIUtils.getUIBoolean("TitlePane.centerTitleIfMenuBarEmbedded", true);
        this.showIconBesideTitle = UIManager.getBoolean("TitlePane.showIconBesideTitle");
        this.menuBarTitleGap = FlatUIUtils.getUIInt("TitlePane.menuBarTitleGap", 40);
        this.menuBarTitleMinimumGap = FlatUIUtils.getUIInt("TitlePane.menuBarTitleMinimumGap", 12);
        this.menuBarResizeHeight = FlatUIUtils.getUIInt("TitlePane.menuBarResizeHeight", 4);
        this.rootPane = rootPane;
        this.handler = this.createHandler();
        this.setBorder(this.createTitlePaneBorder());
        this.addSubComponents();
        this.activeChanged(true);
        this.addMouseListener(this.handler);
        this.addMouseMotionListener(this.handler);
        this.iconLabel.addMouseListener(this.handler);
        this.applyComponentOrientation(rootPane.getComponentOrientation());
    }
    
    protected FlatTitlePaneBorder createTitlePaneBorder() {
        return new FlatTitlePaneBorder();
    }
    
    protected Handler createHandler() {
        return new Handler();
    }
    
    protected void addSubComponents() {
        this.leftPanel = new JPanel();
        this.iconLabel = new JLabel();
        this.titleLabel = new JLabel() {
            @Override
            public void updateUI() {
                this.setUI(new FlatTitleLabelUI());
            }
        };
        this.iconLabel.setBorder(new FlatEmptyBorder(UIManager.getInsets("TitlePane.iconMargins")));
        this.titleLabel.setBorder(new FlatEmptyBorder(UIManager.getInsets("TitlePane.titleMargins")));
        this.leftPanel.setLayout(new BoxLayout(this.leftPanel, 2));
        this.leftPanel.setOpaque(false);
        this.leftPanel.add(this.iconLabel);
        this.menuBarPlaceholder = new JComponent() {
            @Override
            public Dimension getPreferredSize() {
                final JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
                return FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar) ? menuBar.getPreferredSize() : new Dimension();
            }
        };
        this.leftPanel.add(this.menuBarPlaceholder);
        this.createButtons();
        this.setLayout(new BorderLayout() {
            @Override
            public void layoutContainer(final Container target) {
                final Insets insets = target.getInsets();
                final int x = insets.left;
                final int y = insets.top;
                final int w = target.getWidth() - insets.left - insets.right;
                final int h = target.getHeight() - insets.top - insets.bottom;
                int leftWidth = FlatTitlePane.this.leftPanel.getPreferredSize().width;
                int buttonsWidth = FlatTitlePane.this.buttonPanel.getPreferredSize().width;
                int titleWidth = w - leftWidth - buttonsWidth;
                int minTitleWidth = UIScale.scale(FlatTitlePane.this.titleMinimumWidth);
                final Icon icon = FlatTitlePane.this.titleLabel.getIcon();
                if (icon != null) {
                    final Insets iconInsets = FlatTitlePane.this.iconLabel.getInsets();
                    final int iconTextGap = FlatTitlePane.this.titleLabel.getComponentOrientation().isLeftToRight() ? iconInsets.right : iconInsets.left;
                    minTitleWidth += icon.getIconWidth() + iconTextGap;
                }
                if (titleWidth < minTitleWidth) {
                    buttonsWidth = Math.max(buttonsWidth - (minTitleWidth - titleWidth), FlatTitlePane.this.buttonPanel.getMinimumSize().width);
                    titleWidth = w - leftWidth - buttonsWidth;
                }
                if (titleWidth < minTitleWidth) {
                    final int minLeftWidth = FlatTitlePane.this.iconLabel.isVisible() ? (FlatTitlePane.this.iconLabel.getWidth() - FlatTitlePane.this.iconLabel.getInsets().right) : UIScale.scale(FlatTitlePane.this.noIconLeftGap);
                    leftWidth = Math.max(leftWidth - (minTitleWidth - titleWidth), minLeftWidth);
                    titleWidth = w - leftWidth - buttonsWidth;
                }
                if (target.getComponentOrientation().isLeftToRight()) {
                    FlatTitlePane.this.leftPanel.setBounds(x, y, leftWidth, h);
                    FlatTitlePane.this.titleLabel.setBounds(x + leftWidth, y, titleWidth, h);
                    FlatTitlePane.this.buttonPanel.setBounds(x + leftWidth + titleWidth, y, buttonsWidth, h);
                }
                else {
                    FlatTitlePane.this.buttonPanel.setBounds(x, y, buttonsWidth, h);
                    FlatTitlePane.this.titleLabel.setBounds(x + buttonsWidth, y, titleWidth, h);
                    FlatTitlePane.this.leftPanel.setBounds(x + buttonsWidth + titleWidth, y, leftWidth, h);
                }
                final JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
                if (FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar)) {
                    final Component horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar);
                    if (horizontalGlue != null) {
                        final Point glueLocation = SwingUtilities.convertPoint(horizontalGlue, 0, 0, FlatTitlePane.this.titleLabel);
                        FlatTitlePane.this.titleLabel.setBounds(FlatTitlePane.this.titleLabel.getX() + glueLocation.x, FlatTitlePane.this.titleLabel.getY(), horizontalGlue.getWidth(), FlatTitlePane.this.titleLabel.getHeight());
                    }
                }
            }
        });
        this.add(this.leftPanel, "Before");
        this.add(this.titleLabel, "Center");
        this.add(this.buttonPanel, "After");
    }
    
    protected void createButtons() {
        this.iconifyButton = this.createButton("TitlePane.iconifyIcon", "Iconify", e -> this.iconify());
        this.maximizeButton = this.createButton("TitlePane.maximizeIcon", "Maximize", e -> this.maximize());
        this.restoreButton = this.createButton("TitlePane.restoreIcon", "Restore", e -> this.restore());
        this.closeButton = this.createButton("TitlePane.closeIcon", "Close", e -> this.close());
        this.iconifyButton.setVisible(false);
        this.maximizeButton.setVisible(false);
        this.restoreButton.setVisible(false);
        (this.buttonPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                if (FlatTitlePane.this.buttonMaximizedHeight > 0 && FlatTitlePane.this.isWindowMaximized() && !FlatTitlePane.this.hasVisibleEmbeddedMenuBar(FlatTitlePane.this.rootPane.getJMenuBar())) {
                    size = new Dimension(size.width, Math.min(size.height, UIScale.scale(FlatTitlePane.this.buttonMaximizedHeight)));
                }
                return size;
            }
        }).setOpaque(false);
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, 2));
        if (this.rootPane.getWindowDecorationStyle() == 1) {
            this.buttonPanel.add(this.iconifyButton);
            this.buttonPanel.add(this.maximizeButton);
            this.buttonPanel.add(this.restoreButton);
        }
        this.buttonPanel.add(this.closeButton);
    }
    
    protected JButton createButton(final String iconKey, final String accessibleName, final ActionListener action) {
        final JButton button = new JButton(UIManager.getIcon(iconKey)) {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(UIScale.scale(FlatTitlePane.this.buttonMinimumWidth), super.getMinimumSize().height);
            }
        };
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.putClientProperty("AccessibleName", accessibleName);
        button.addActionListener(action);
        return button;
    }
    
    protected void activeChanged(final boolean active) {
        Color background = FlatClientProperties.clientPropertyColor(this.rootPane, "JRootPane.titleBarBackground", null);
        Color titleForeground;
        Color foreground = titleForeground = FlatClientProperties.clientPropertyColor(this.rootPane, "JRootPane.titleBarForeground", null);
        if (background == null) {
            background = FlatUIUtils.nonUIResource(active ? this.activeBackground : this.inactiveBackground);
        }
        if (foreground == null) {
            foreground = FlatUIUtils.nonUIResource(active ? this.activeForeground : this.inactiveForeground);
            titleForeground = ((active && this.hasVisibleEmbeddedMenuBar(this.rootPane.getJMenuBar())) ? FlatUIUtils.nonUIResource(this.embeddedForeground) : foreground);
        }
        this.setBackground(background);
        this.titleLabel.setForeground(titleForeground);
        this.iconifyButton.setForeground(foreground);
        this.maximizeButton.setForeground(foreground);
        this.restoreButton.setForeground(foreground);
        this.closeButton.setForeground(foreground);
        this.iconifyButton.setBackground(background);
        this.maximizeButton.setBackground(background);
        this.restoreButton.setBackground(background);
        this.closeButton.setBackground(background);
    }
    
    protected void frameStateChanged() {
        if (this.window == null || this.rootPane.getWindowDecorationStyle() != 1) {
            return;
        }
        this.updateVisibility();
        if (this.window instanceof Frame) {
            final Frame frame = (Frame)this.window;
            if (this.isWindowMaximized() && (!SystemInfo.isLinux || !FlatNativeLinuxLibrary.isWMUtilsSupported(this.window)) && this.rootPane.getClientProperty("_flatlaf.maximizedBoundsUpToDate") == null) {
                this.rootPane.putClientProperty("_flatlaf.maximizedBoundsUpToDate", null);
                final Rectangle oldMaximizedBounds = frame.getMaximizedBounds();
                this.updateMaximizedBounds();
                final Rectangle newMaximizedBounds = frame.getMaximizedBounds();
                if (newMaximizedBounds != null && !newMaximizedBounds.equals(oldMaximizedBounds)) {
                    final int oldExtendedState = frame.getExtendedState();
                    frame.setExtendedState(oldExtendedState & 0xFFFFFFF9);
                    frame.setExtendedState(oldExtendedState);
                }
            }
        }
    }
    
    protected void updateVisibility() {
        this.titleLabel.setVisible(FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.titleBarShowTitle", true));
        this.closeButton.setVisible(FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.titleBarShowClose", true));
        if (this.window instanceof Frame) {
            final Frame frame = (Frame)this.window;
            final boolean maximizable = frame.isResizable() && FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.titleBarShowMaximize", true);
            final boolean maximized = this.isWindowMaximized();
            this.iconifyButton.setVisible(FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.titleBarShowIconify", true));
            this.maximizeButton.setVisible(maximizable && !maximized);
            this.restoreButton.setVisible(maximizable && maximized);
        }
        else {
            this.iconifyButton.setVisible(false);
            this.maximizeButton.setVisible(false);
            this.restoreButton.setVisible(false);
        }
    }
    
    protected void updateIcon() {
        boolean defaultShowIcon = this.showIcon;
        if (!this.showIconInDialogs && this.rootPane.getParent() instanceof JDialog) {
            defaultShowIcon = false;
        }
        List<Image> images = null;
        if (FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.titleBarShowIcon", defaultShowIcon)) {
            images = this.window.getIconImages();
            if (images.isEmpty()) {
                for (Window owner = this.window.getOwner(); owner != null; owner = owner.getOwner()) {
                    images = owner.getIconImages();
                    if (!images.isEmpty()) {
                        break;
                    }
                }
            }
        }
        final boolean hasIcon = images != null && !images.isEmpty();
        this.iconLabel.setIcon((hasIcon && !this.showIconBesideTitle) ? new FlatTitlePaneIcon(images, this.iconSize) : null);
        this.titleLabel.setIcon((hasIcon && this.showIconBesideTitle) ? new FlatTitlePaneIcon(images, this.iconSize) : null);
        this.iconLabel.setVisible(hasIcon && !this.showIconBesideTitle);
        this.leftPanel.setBorder((hasIcon && !this.showIconBesideTitle) ? null : FlatUIUtils.nonUIResource(new FlatEmptyBorder(0, this.noIconLeftGap, 0, 0)));
        this.updateNativeTitleBarHeightAndHitTestSpotsLater();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        this.uninstallWindowListeners();
        this.window = SwingUtilities.getWindowAncestor(this);
        if (this.window != null) {
            this.frameStateChanged();
            this.activeChanged(this.window.isActive());
            this.updateIcon();
            this.titleLabel.setText(this.getWindowTitle());
            this.installWindowListeners();
        }
        this.updateNativeTitleBarHeightAndHitTestSpotsLater();
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        this.uninstallWindowListeners();
        this.window = null;
    }
    
    protected String getWindowTitle() {
        if (this.window instanceof Frame) {
            return ((Frame)this.window).getTitle();
        }
        if (this.window instanceof Dialog) {
            return ((Dialog)this.window).getTitle();
        }
        return null;
    }
    
    protected void installWindowListeners() {
        if (this.window == null) {
            return;
        }
        this.window.addPropertyChangeListener(this.handler);
        this.window.addWindowListener(this.handler);
        this.window.addWindowStateListener(this.handler);
        this.window.addComponentListener(this.handler);
    }
    
    protected void uninstallWindowListeners() {
        if (this.window == null) {
            return;
        }
        this.window.removePropertyChangeListener(this.handler);
        this.window.removeWindowListener(this.handler);
        this.window.removeWindowStateListener(this.handler);
        this.window.removeComponentListener(this.handler);
    }
    
    protected boolean hasVisibleEmbeddedMenuBar(final JMenuBar menuBar) {
        return menuBar != null && menuBar.isVisible() && this.isMenuBarEmbedded();
    }
    
    protected boolean isMenuBarEmbedded() {
        return FlatUIUtils.getBoolean(this.rootPane, "flatlaf.menuBarEmbedded", "JRootPane.menuBarEmbedded", "TitlePane.menuBarEmbedded", false);
    }
    
    protected Rectangle getMenuBarBounds() {
        final Insets insets = this.rootPane.getInsets();
        final Rectangle bounds = new Rectangle(SwingUtilities.convertPoint(this.menuBarPlaceholder, -insets.left, -insets.top, this.rootPane), this.menuBarPlaceholder.getSize());
        final Insets borderInsets = this.getBorder().getBorderInsets(this);
        final Rectangle rectangle = bounds;
        rectangle.height += borderInsets.bottom;
        final Component horizontalGlue = this.findHorizontalGlue(this.rootPane.getJMenuBar());
        if (horizontalGlue != null) {
            final boolean leftToRight = this.getComponentOrientation().isLeftToRight();
            int titleWidth = leftToRight ? (this.buttonPanel.getX() - (this.leftPanel.getX() + this.leftPanel.getWidth())) : (this.leftPanel.getX() - (this.buttonPanel.getX() + this.buttonPanel.getWidth()));
            titleWidth = Math.max(titleWidth, 0);
            final Rectangle rectangle2 = bounds;
            rectangle2.width += titleWidth;
            if (!leftToRight) {
                final Rectangle rectangle3 = bounds;
                rectangle3.x -= titleWidth;
            }
        }
        return bounds;
    }
    
    protected Component findHorizontalGlue(final JMenuBar menuBar) {
        if (menuBar == null) {
            return null;
        }
        final int count = menuBar.getComponentCount();
        for (int i = count - 1; i >= 0; --i) {
            final Component c = menuBar.getComponent(i);
            if (c instanceof Box.Filler && c.getMaximumSize().width >= 32767) {
                return c;
            }
        }
        return null;
    }
    
    protected void titleBarColorsChanged() {
        this.activeChanged(this.window == null || this.window.isActive());
        this.repaint();
    }
    
    protected void menuBarChanged() {
        this.menuBarPlaceholder.invalidate();
        this.repaint();
        EventQueue.invokeLater(() -> this.activeChanged(this.window == null || this.window.isActive()));
    }
    
    protected void menuBarLayouted() {
        this.updateNativeTitleBarHeightAndHitTestSpotsLater();
        this.doLayout();
    }
    
    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        if (!UIManager.getBoolean("FlatLaf.debug.titlebar.showRectangles")) {
            return;
        }
        if (this.debugTitleBarHeight > 0) {
            g.setColor(Color.green);
            g.drawLine(0, this.debugTitleBarHeight, this.getWidth(), this.debugTitleBarHeight);
        }
        if (this.debugHitTestSpots != null) {
            for (final Rectangle r : this.debugHitTestSpots) {
                this.paintRect(g, Color.red, r);
            }
        }
        this.paintRect(g, Color.cyan, this.debugCloseButtonBounds);
        this.paintRect(g, Color.blue, this.debugAppIconBounds);
        this.paintRect(g, Color.blue, this.debugMinimizeButtonBounds);
        this.paintRect(g, Color.magenta, this.debugMaximizeButtonBounds);
        this.paintRect(g, Color.cyan, this.debugCloseButtonBounds);
    }
    
    private void paintRect(final Graphics g, final Color color, final Rectangle r) {
        if (r == null) {
            return;
        }
        g.setColor(color);
        final Point offset = SwingUtilities.convertPoint(this, 0, 0, this.window);
        g.drawRect(r.x - offset.x, r.y - offset.y, r.width - 1, r.height - 1);
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor((UIManager.getBoolean("TitlePane.unifiedBackground") && FlatClientProperties.clientPropertyColor(this.rootPane, "JRootPane.titleBarBackground", null) == null) ? FlatUIUtils.getParentBackground(this) : this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    protected void repaintWindowBorder() {
        final int width = this.rootPane.getWidth();
        final int height = this.rootPane.getHeight();
        final Insets insets = this.rootPane.getInsets();
        this.rootPane.repaint(0, 0, width, insets.top);
        this.rootPane.repaint(0, 0, insets.left, height);
        this.rootPane.repaint(0, height - insets.bottom, width, insets.bottom);
        this.rootPane.repaint(width - insets.right, 0, insets.right, height);
    }
    
    protected void iconify() {
        if (!(this.window instanceof Frame)) {
            return;
        }
        final Frame frame = (Frame)this.window;
        if (!FlatNativeWindowBorder.showWindow(this.window, 6)) {
            frame.setExtendedState(frame.getExtendedState() | 0x1);
        }
    }
    
    protected boolean isWindowMaximized() {
        return this.window instanceof Frame && (((Frame)this.window).getExtendedState() & 0x6) == 0x6;
    }
    
    protected void maximize() {
        if (!(this.window instanceof Frame)) {
            return;
        }
        final Frame frame = (Frame)this.window;
        this.updateMaximizedBounds();
        this.rootPane.putClientProperty("_flatlaf.maximizedBoundsUpToDate", true);
        if (!FlatNativeWindowBorder.showWindow(frame, 3)) {
            final int oldState = frame.getExtendedState();
            int newState = oldState | 0x6;
            if (SystemInfo.isLinux && (oldState & 0x6) == 0x4) {
                newState = ((oldState & 0xFFFFFFF9) | 0x2);
            }
            frame.setExtendedState(newState);
        }
    }
    
    protected void updateMaximizedBounds() {
        final Frame frame = (Frame)this.window;
        final Rectangle oldMaximizedBounds = frame.getMaximizedBounds();
        if (!this.hasNativeCustomDecoration() && (oldMaximizedBounds == null || Objects.equals(oldMaximizedBounds, this.rootPane.getClientProperty("_flatlaf.maximizedBounds")))) {
            final GraphicsConfiguration gc = this.window.getGraphicsConfiguration();
            final Rectangle screenBounds = gc.getBounds();
            int maximizedX = screenBounds.x;
            int maximizedY = screenBounds.y;
            int maximizedWidth = screenBounds.width;
            int maximizedHeight = screenBounds.height;
            if (SystemInfo.isWindows && !this.isMaximizedBoundsFixed()) {
                maximizedX = 0;
                maximizedY = 0;
                final AffineTransform defaultTransform = gc.getDefaultTransform();
                maximizedWidth *= (int)defaultTransform.getScaleX();
                maximizedHeight *= (int)defaultTransform.getScaleY();
            }
            final Insets screenInsets = this.window.getToolkit().getScreenInsets(gc);
            final Rectangle newMaximizedBounds = new Rectangle(maximizedX + screenInsets.left, maximizedY + screenInsets.top, maximizedWidth - screenInsets.left - screenInsets.right, maximizedHeight - screenInsets.top - screenInsets.bottom);
            if (!Objects.equals(oldMaximizedBounds, newMaximizedBounds)) {
                frame.setMaximizedBounds(newMaximizedBounds);
                this.rootPane.putClientProperty("_flatlaf.maximizedBounds", newMaximizedBounds);
            }
        }
    }
    
    private boolean isMaximizedBoundsFixed() {
        return SystemInfo.isJava_15_orLater || (SystemInfo.javaVersion >= SystemInfo.toVersion(11, 0, 8, 0) && SystemInfo.javaVersion < SystemInfo.toVersion(12, 0, 0, 0)) || (SystemInfo.javaVersion >= SystemInfo.toVersion(13, 0, 4, 0) && SystemInfo.javaVersion < SystemInfo.toVersion(14, 0, 0, 0));
    }
    
    protected void restore() {
        if (!(this.window instanceof Frame)) {
            return;
        }
        final Frame frame = (Frame)this.window;
        if (!FlatNativeWindowBorder.showWindow(this.window, 9)) {
            final int state = frame.getExtendedState();
            frame.setExtendedState(((state & 0x1) != 0x0) ? (state & 0xFFFFFFFE) : (state & 0xFFFFFFF9));
        }
    }
    
    private void maximizeOrRestore() {
        if (!(this.window instanceof Frame) || !((Frame)this.window).isResizable()) {
            return;
        }
        if (this.isWindowMaximized()) {
            this.restore();
        }
        else {
            this.maximize();
        }
    }
    
    protected void close() {
        if (this.window != null) {
            this.window.dispatchEvent(new WindowEvent(this.window, 201));
        }
    }
    
    private boolean hasJBRCustomDecoration() {
        return this.window != null && JBRCustomDecorations.hasCustomDecoration(this.window);
    }
    
    protected boolean hasNativeCustomDecoration() {
        return this.window != null && FlatNativeWindowBorder.hasCustomDecoration(this.window);
    }
    
    protected void updateNativeTitleBarHeightAndHitTestSpotsLater() {
        ++this.laterCounter;
        EventQueue.invokeLater(() -> {
            --this.laterCounter;
            if (this.laterCounter == 0) {
                this.updateNativeTitleBarHeightAndHitTestSpots();
            }
        });
    }
    
    protected void updateNativeTitleBarHeightAndHitTestSpots() {
        if (!this.isDisplayable()) {
            return;
        }
        if (!this.hasNativeCustomDecoration()) {
            return;
        }
        int titleBarHeight = this.getHeight();
        if (titleBarHeight > 0) {
            --titleBarHeight;
        }
        final List<Rectangle> hitTestSpots = new ArrayList<Rectangle>();
        Rectangle appIconBounds = null;
        if (!this.showIconBesideTitle && this.iconLabel.isVisible()) {
            final Point location = SwingUtilities.convertPoint(this.iconLabel, 0, 0, this.window);
            final Insets iconInsets = this.iconLabel.getInsets();
            final Rectangle iconBounds = new Rectangle(location.x + iconInsets.left - 1, location.y + iconInsets.top - 1, this.iconLabel.getWidth() - iconInsets.left - iconInsets.right + 2, this.iconLabel.getHeight() - iconInsets.top - iconInsets.bottom + 2);
            if (this.isWindowMaximized()) {
                final Rectangle rectangle = iconBounds;
                rectangle.height += iconBounds.y;
                iconBounds.y = 0;
                if (this.window.getComponentOrientation().isLeftToRight()) {
                    final Rectangle rectangle2 = iconBounds;
                    rectangle2.width += iconBounds.x;
                    iconBounds.x = 0;
                }
                else {
                    final Rectangle rectangle3 = iconBounds;
                    rectangle3.width += iconInsets.right;
                }
            }
            if (this.hasJBRCustomDecoration()) {
                hitTestSpots.add(iconBounds);
            }
            else {
                appIconBounds = iconBounds;
            }
        }
        else if (this.showIconBesideTitle && this.titleLabel.getIcon() != null && this.titleLabel.getUI() instanceof FlatTitleLabelUI) {
            final FlatTitleLabelUI ui = (FlatTitleLabelUI)this.titleLabel.getUI();
            final Insets insets = this.titleLabel.getInsets();
            final Rectangle viewR = new Rectangle(insets.left, insets.top, this.titleLabel.getWidth() - insets.left - insets.right, this.titleLabel.getHeight() - insets.top - insets.bottom);
            final Rectangle iconR = new Rectangle();
            final Rectangle textR = new Rectangle();
            ui.layoutCL(this.titleLabel, this.titleLabel.getFontMetrics(this.titleLabel.getFont()), this.titleLabel.getText(), this.titleLabel.getIcon(), viewR, iconR, textR);
            if (iconR.x == 0) {
                final Point location2 = SwingUtilities.convertPoint(this.titleLabel, 0, 0, this.window);
                final Rectangle rectangle4 = iconR;
                rectangle4.x += location2.x;
                final Rectangle rectangle5 = iconR;
                rectangle5.y += location2.y;
                final Rectangle rectangle6 = iconR;
                --rectangle6.x;
                final Rectangle rectangle7 = iconR;
                --rectangle7.y;
                final Rectangle rectangle8 = iconR;
                rectangle8.width += 2;
                final Rectangle rectangle9 = iconR;
                rectangle9.height += 2;
                if (this.hasJBRCustomDecoration()) {
                    hitTestSpots.add(iconR);
                }
                else {
                    appIconBounds = iconR;
                }
            }
        }
        Rectangle r = this.getNativeHitTestSpot(this.buttonPanel);
        if (r != null) {
            hitTestSpots.add(r);
        }
        final JMenuBar menuBar = this.rootPane.getJMenuBar();
        if (this.hasVisibleEmbeddedMenuBar(menuBar)) {
            r = this.getNativeHitTestSpot(menuBar);
            if (r != null) {
                if (this.window instanceof Frame && ((Frame)this.window).isResizable() && !this.isWindowMaximized()) {
                    final int resizeHeight = UIScale.scale(Math.min(this.menuBarResizeHeight, 8));
                    final Rectangle rectangle10 = r;
                    rectangle10.y += resizeHeight;
                    final Rectangle rectangle11 = r;
                    rectangle11.height -= resizeHeight;
                }
                final int count = menuBar.getComponentCount();
                for (int i = count - 1; i >= 0; --i) {
                    final Component c = menuBar.getComponent(i);
                    if (c instanceof Box.Filler || (c instanceof JComponent && FlatClientProperties.clientPropertyBoolean((JComponent)c, "JComponent.titleBarCaption", false))) {
                        final Point glueLocation = SwingUtilities.convertPoint(c, 0, 0, this.window);
                        final int x2 = glueLocation.x + c.getWidth();
                        Rectangle r2;
                        if (this.getComponentOrientation().isLeftToRight()) {
                            r2 = new Rectangle(x2, r.y, r.x + r.width - x2, r.height);
                            r.width = glueLocation.x - r.x;
                        }
                        else {
                            r2 = new Rectangle(r.x, r.y, glueLocation.x - r.x, r.height);
                            r.width = r.x + r.width - x2;
                            r.x = x2;
                        }
                        if (r2.width > 0) {
                            hitTestSpots.add(r2);
                        }
                    }
                }
                hitTestSpots.add(r);
            }
        }
        final Rectangle minimizeButtonBounds = this.boundsInWindow(this.iconifyButton);
        final Rectangle maximizeButtonBounds = this.boundsInWindow(this.maximizeButton.isVisible() ? this.maximizeButton : this.restoreButton);
        final Rectangle closeButtonBounds = this.boundsInWindow(this.closeButton);
        FlatNativeWindowBorder.setTitleBarHeightAndHitTestSpots(this.window, titleBarHeight, hitTestSpots, appIconBounds, minimizeButtonBounds, maximizeButtonBounds, closeButtonBounds);
        this.debugTitleBarHeight = titleBarHeight;
        this.debugHitTestSpots = hitTestSpots;
        this.debugAppIconBounds = appIconBounds;
        this.debugMinimizeButtonBounds = minimizeButtonBounds;
        this.debugMaximizeButtonBounds = maximizeButtonBounds;
        this.debugCloseButtonBounds = closeButtonBounds;
        if (UIManager.getBoolean("FlatLaf.debug.titlebar.showRectangles")) {
            this.repaint();
        }
    }
    
    private Rectangle boundsInWindow(final JComponent c) {
        return c.isShowing() ? SwingUtilities.convertRectangle(c.getParent(), c.getBounds(), this.window) : null;
    }
    
    protected Rectangle getNativeHitTestSpot(final JComponent c) {
        final Dimension size = c.getSize();
        if (size.width <= 0 || size.height <= 0) {
            return null;
        }
        final Point location = SwingUtilities.convertPoint(c, 0, 0, this.window);
        final Rectangle r = new Rectangle(location, size);
        return r;
    }
    
    protected class FlatTitlePaneBorder extends AbstractBorder
    {
        @Override
        public Insets getBorderInsets(final Component c, Insets insets) {
            super.getBorderInsets(c, insets);
            final Border menuBarBorder = this.getMenuBarBorder();
            if (menuBarBorder != null) {
                final Insets menuBarInsets = menuBarBorder.getBorderInsets(c);
                final Insets insets2 = insets;
                insets2.bottom += menuBarInsets.bottom;
            }
            else if (FlatTitlePane.this.borderColor != null && (FlatTitlePane.this.rootPane.getJMenuBar() == null || !FlatTitlePane.this.rootPane.getJMenuBar().isVisible())) {
                final Insets insets3 = insets;
                insets3.bottom += UIScale.scale(1);
            }
            if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration() && !FlatTitlePane.this.isWindowMaximized()) {
                insets = FlatUIUtils.addInsets(insets, FlatNativeWindowBorder.WindowTopBorder.getInstance().getBorderInsets());
            }
            return insets;
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            final Border menuBarBorder = this.getMenuBarBorder();
            if (menuBarBorder != null) {
                menuBarBorder.paintBorder(FlatTitlePane.this.rootPane.getJMenuBar(), g, x, y, width, height);
            }
            else if (FlatTitlePane.this.borderColor != null && (FlatTitlePane.this.rootPane.getJMenuBar() == null || !FlatTitlePane.this.rootPane.getJMenuBar().isVisible())) {
                final float lineHeight = UIScale.scale(1.0f);
                FlatUIUtils.paintFilledRectangle(g, FlatTitlePane.this.borderColor, (float)x, y + height - lineHeight, (float)width, lineHeight);
            }
            if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration() && !FlatTitlePane.this.isWindowMaximized()) {
                FlatNativeWindowBorder.WindowTopBorder.getInstance().paintBorder(c, g, x, y, width, height);
            }
        }
        
        protected Border getMenuBarBorder() {
            final JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
            return FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar) ? menuBar.getBorder() : null;
        }
    }
    
    protected class FlatTitleLabelUI extends FlatLabelUI
    {
        protected FlatTitleLabelUI() {
            super(false);
        }
        
        @Override
        protected void installDefaults(final JLabel c) {
            super.installDefaults(c);
            if (FlatTitlePane.this.titleFont != null) {
                c.setFont(FlatTitlePane.this.titleFont);
            }
        }
        
        @Override
        protected String layoutCL(final JLabel label, final FontMetrics fontMetrics, final String text, final Icon icon, final Rectangle viewR, final Rectangle iconR, final Rectangle textR) {
            final JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
            final boolean hasEmbeddedMenuBar = FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar);
            final boolean hasEmbeddedLeadingMenus = hasEmbeddedMenuBar && this.hasLeadingMenus(menuBar);
            final boolean leftToRight = FlatTitlePane.this.getComponentOrientation().isLeftToRight();
            if (hasEmbeddedMenuBar) {
                final int minGap = UIScale.scale(FlatTitlePane.this.menuBarTitleMinimumGap);
                if (hasEmbeddedLeadingMenus) {
                    if (leftToRight) {
                        viewR.x += minGap;
                    }
                    viewR.width -= minGap;
                }
                final Component horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar);
                if (horizontalGlue != null && menuBar.getComponent(menuBar.getComponentCount() - 1) != horizontalGlue) {
                    if (!leftToRight) {
                        viewR.x += minGap;
                    }
                    viewR.width -= minGap;
                }
            }
            int iconTextGap = 0;
            int iconWidthAndGap = 0;
            if (icon != null) {
                final Insets iconInsets = FlatTitlePane.this.iconLabel.getInsets();
                iconTextGap = (leftToRight ? iconInsets.right : iconInsets.left);
                iconWidthAndGap = icon.getIconWidth() + iconTextGap;
            }
            final String clippedText = SwingUtilities.layoutCompoundLabel(label, fontMetrics, text, icon, label.getVerticalAlignment(), label.getHorizontalAlignment(), label.getVerticalTextPosition(), label.getHorizontalTextPosition(), viewR, iconR, textR, iconTextGap);
            if (!clippedText.equals(text)) {
                textR.x = (leftToRight ? (viewR.x + iconWidthAndGap) : (viewR.x + viewR.width - iconWidthAndGap - textR.width));
            }
            else {
                final int leadingGap = hasEmbeddedLeadingMenus ? UIScale.scale(FlatTitlePane.this.menuBarTitleGap - FlatTitlePane.this.menuBarTitleMinimumGap) : 0;
                final boolean center = hasEmbeddedLeadingMenus ? FlatTitlePane.this.centerTitleIfMenuBarEmbedded : FlatTitlePane.this.centerTitle;
                if (center) {
                    final Container parent = label.getParent();
                    final int centeredTextX = (parent != null) ? ((parent.getWidth() - textR.width - iconWidthAndGap) / 2 + iconWidthAndGap - label.getX()) : -1;
                    textR.x = ((centeredTextX >= viewR.x + leadingGap && centeredTextX + textR.width <= viewR.x + viewR.width - leadingGap) ? centeredTextX : (viewR.x + (viewR.width - textR.width - iconWidthAndGap) / 2 + iconWidthAndGap));
                }
                else {
                    textR.x = (leftToRight ? Math.min(viewR.x + leadingGap + iconWidthAndGap, viewR.x + viewR.width - textR.width) : Math.max(viewR.x + viewR.width - leadingGap - iconWidthAndGap - textR.width, viewR.x));
                }
            }
            if (icon != null) {
                iconR.x = (leftToRight ? (textR.x - iconWidthAndGap) : (textR.x + textR.width + iconTextGap));
            }
            return clippedText;
        }
        
        private boolean hasLeadingMenus(final JMenuBar menuBar) {
            if (menuBar.getComponentCount() == 0 || menuBar.getWidth() == 0) {
                return false;
            }
            final Component horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar);
            if (horizontalGlue != null) {
                final boolean leftToRight = FlatTitlePane.this.getComponentOrientation().isLeftToRight();
                if ((leftToRight && horizontalGlue.getX() == 0) || (!leftToRight && horizontalGlue.getX() + horizontalGlue.getWidth() == menuBar.getWidth())) {
                    return false;
                }
            }
            return true;
        }
    }
    
    protected class Handler extends WindowAdapter implements PropertyChangeListener, MouseListener, MouseMotionListener, ComponentListener
    {
        private Point dragOffset;
        private boolean linuxNativeMove;
        private long lastSingleClickWhen;
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String propertyName = e.getPropertyName();
            switch (propertyName) {
                case "title": {
                    FlatTitlePane.this.titleLabel.setText(FlatTitlePane.this.getWindowTitle());
                    break;
                }
                case "resizable": {
                    if (FlatTitlePane.this.window instanceof Frame) {
                        FlatTitlePane.this.frameStateChanged();
                        break;
                    }
                    break;
                }
                case "iconImage": {
                    FlatTitlePane.this.updateIcon();
                    break;
                }
                case "componentOrientation": {
                    FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpotsLater();
                    break;
                }
            }
        }
        
        @Override
        public void windowActivated(final WindowEvent e) {
            FlatTitlePane.this.activeChanged(true);
            FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
            if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration()) {
                FlatNativeWindowBorder.WindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
            }
            FlatTitlePane.this.repaintWindowBorder();
        }
        
        @Override
        public void windowDeactivated(final WindowEvent e) {
            FlatTitlePane.this.activeChanged(false);
            FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
            if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration()) {
                FlatNativeWindowBorder.WindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
            }
            FlatTitlePane.this.repaintWindowBorder();
        }
        
        @Override
        public void windowStateChanged(final WindowEvent e) {
            FlatTitlePane.this.frameStateChanged();
            FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
        }
        
        @Override
        public void mouseClicked(final MouseEvent e) {
            if (this.linuxNativeMove && SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
                if (this.lastSingleClickWhen != 0L && e.getWhen() - this.lastSingleClickWhen <= this.getMultiClickInterval()) {
                    this.lastSingleClickWhen = 0L;
                    FlatTitlePane.this.maximizeOrRestore();
                }
                return;
            }
            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                if (e.getSource() == FlatTitlePane.this.iconLabel) {
                    FlatTitlePane.this.close();
                }
                else if (!FlatTitlePane.this.hasNativeCustomDecoration()) {
                    FlatTitlePane.this.maximizeOrRestore();
                }
            }
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
            if (FlatTitlePane.this.window == null) {
                return;
            }
            if (SwingUtilities.isRightMouseButton(e) && SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
                e.consume();
                FlatNativeLinuxLibrary.showWindowMenu(FlatTitlePane.this.window, e);
                return;
            }
            if (!SwingUtilities.isLeftMouseButton(e)) {
                return;
            }
            this.dragOffset = SwingUtilities.convertPoint(FlatTitlePane.this, e.getPoint(), FlatTitlePane.this.window);
            this.linuxNativeMove = false;
            if (SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
                int clickCount = e.getClickCount();
                if (clickCount == 1 && this.lastSingleClickWhen != 0L && e.getWhen() - this.lastSingleClickWhen <= this.getMultiClickInterval()) {
                    clickCount = 2;
                }
                switch (clickCount) {
                    case 1: {
                        e.consume();
                        this.linuxNativeMove = FlatNativeLinuxLibrary.moveOrResizeWindow(FlatTitlePane.this.window, e, 8);
                        this.lastSingleClickWhen = e.getWhen();
                        break;
                    }
                    case 2: {
                        this.lastSingleClickWhen = 0L;
                        FlatTitlePane.this.maximizeOrRestore();
                        break;
                    }
                }
            }
        }
        
        private int getMultiClickInterval() {
            final Object value = Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
            return (int)((value instanceof Integer) ? value : 500);
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
        }
        
        @Override
        public void mouseEntered(final MouseEvent e) {
        }
        
        @Override
        public void mouseExited(final MouseEvent e) {
        }
        
        @Override
        public void mouseDragged(final MouseEvent e) {
            if (FlatTitlePane.this.window == null || this.dragOffset == null) {
                return;
            }
            if (this.linuxNativeMove) {
                return;
            }
            if (!SwingUtilities.isLeftMouseButton(e)) {
                return;
            }
            if (FlatTitlePane.this.hasNativeCustomDecoration()) {
                return;
            }
            if (FlatTitlePane.this.window instanceof Frame) {
                final Frame frame = (Frame)FlatTitlePane.this.window;
                final int state = frame.getExtendedState();
                if ((state & 0x6) != 0x0) {
                    final int maximizedWidth = FlatTitlePane.this.window.getWidth();
                    frame.setExtendedState(state & 0xFFFFFFF9);
                    final int restoredWidth = FlatTitlePane.this.window.getWidth();
                    final int center = restoredWidth / 2;
                    if (this.dragOffset.x > center) {
                        if (this.dragOffset.x > maximizedWidth - center) {
                            this.dragOffset.x = restoredWidth - (maximizedWidth - this.dragOffset.x);
                        }
                        else {
                            this.dragOffset.x = center;
                        }
                    }
                }
            }
            final int newX = e.getXOnScreen() - this.dragOffset.x;
            final int newY = e.getYOnScreen() - this.dragOffset.y;
            if (newX == FlatTitlePane.this.window.getX() && newY == FlatTitlePane.this.window.getY()) {
                return;
            }
            FlatTitlePane.this.window.setLocation(newX, newY);
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
        }
        
        @Override
        public void componentResized(final ComponentEvent e) {
            FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpotsLater();
        }
        
        @Override
        public void componentShown(final ComponentEvent e) {
            FlatTitlePane.this.frameStateChanged();
        }
        
        @Override
        public void componentMoved(final ComponentEvent e) {
        }
        
        @Override
        public void componentHidden(final ComponentEvent e) {
        }
    }
}
