// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.MenuElement;
import java.awt.EventQueue;
import javax.swing.event.MenuKeyEvent;
import javax.swing.plaf.ButtonUI;
import javax.swing.MenuSelectionManager;
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.SwingUtilities;
import java.awt.event.MouseWheelEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JViewport;
import java.awt.Point;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.PopupMenuListener;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.Insets;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Component;
import javax.swing.PopupFactory;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.Popup;
import javax.swing.JPopupMenu;
import com.formdev.flatlaf.util.LoggingFacade;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.plaf.UIResource;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import javax.swing.plaf.basic.BasicPopupMenuUI;

public class FlatPopupMenuUI extends BasicPopupMenuUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected String arrowType;
    @FlatStylingSupport.Styleable
    protected Color scrollArrowColor;
    @FlatStylingSupport.Styleable
    protected Color hoverScrollArrowBackground;
    private PropertyChangeListener propertyChangeListener;
    private Map<String, Object> oldStyleValues;
    private AtomicBoolean borderShared;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatPopupMenuUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        this.oldStyleValues = null;
        this.borderShared = null;
    }
    
    @Override
    public void installDefaults() {
        super.installDefaults();
        this.arrowType = UIManager.getString("Component.arrowType");
        this.scrollArrowColor = UIManager.getColor("PopupMenu.scrollArrowColor");
        this.hoverScrollArrowBackground = UIManager.getColor("PopupMenu.hoverScrollArrowBackground");
        final LayoutManager layout = this.popupMenu.getLayout();
        if (layout == null || layout instanceof UIResource) {
            this.popupMenu.setLayout(new FlatPopupMenuLayout(this.popupMenu, 1));
        }
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.scrollArrowColor = null;
        this.hoverScrollArrowBackground = null;
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.propertyChangeListener = FlatStylingSupport.createPropertyChangeListener(this.popupMenu, this::installStyle, null);
        this.popupMenu.addPropertyChangeListener(this.propertyChangeListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.popupMenu.removePropertyChangeListener(this.propertyChangeListener);
        this.propertyChangeListener = null;
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.popupMenu, "PopupMenu"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (this.borderShared == null) {
            this.borderShared = new AtomicBoolean(true);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrBorder(this, key, value, this.popupMenu, this.borderShared);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this, this.popupMenu.getBorder());
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, this.popupMenu.getBorder(), key);
    }
    
    @Override
    public Popup getPopup(final JPopupMenu popup, final int x, final int y) {
        if (popup instanceof BasicComboPopup || (popup.getComponentCount() > 0 && popup.getComponent(0) instanceof JScrollPane)) {
            return super.getPopup(popup, x, y);
        }
        final Dimension prefSize = popup.getPreferredSize();
        final int screenHeight = this.getScreenHeightAt(x, y);
        if (prefSize.height <= screenHeight) {
            return super.getPopup(popup, x, y);
        }
        final FlatPopupScroller scroller = new FlatPopupScroller(popup);
        scroller.setPreferredSize(new Dimension(prefSize.width, screenHeight));
        final PopupFactory popupFactory = PopupFactory.getSharedInstance();
        return popupFactory.getPopup(popup.getInvoker(), scroller, x, y);
    }
    
    private int getScreenHeightAt(final int x, final int y) {
        GraphicsConfiguration gc = null;
        for (final GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            if (device.getType() == 0) {
                final GraphicsConfiguration dgc = device.getDefaultConfiguration();
                if (dgc.getBounds().contains(x, y)) {
                    gc = dgc;
                    break;
                }
            }
        }
        if (gc == null && this.popupMenu.getInvoker() != null) {
            gc = this.popupMenu.getInvoker().getGraphicsConfiguration();
        }
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Rectangle screenBounds = (gc != null) ? gc.getBounds() : new Rectangle(toolkit.getScreenSize());
        final Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        return screenBounds.height - screenInsets.top - screenInsets.bottom;
    }
    
    protected static class FlatPopupMenuLayout extends DefaultMenuLayout
    {
        public FlatPopupMenuLayout(final Container target, final int axis) {
            super(target, axis);
        }
        
        @Override
        public Dimension preferredLayoutSize(final Container target) {
            FlatMenuItemRenderer.clearClientProperties(target);
            return super.preferredLayoutSize(target);
        }
    }
    
    private class FlatPopupScroller extends JPanel implements MouseWheelListener, PopupMenuListener, MenuKeyListener
    {
        private final JPopupMenu popup;
        private final JScrollPane scrollPane;
        private final JButton scrollUpButton;
        private final JButton scrollDownButton;
        private int unitIncrement;
        final /* synthetic */ FlatPopupMenuUI this$0;
        
        FlatPopupScroller(final JPopupMenu popup) {
            super(new BorderLayout());
            this.popup = popup;
            final JPanel view = new JPanel(new BorderLayout());
            view.add(popup, "Center");
            (this.scrollPane = new JScrollPane(view, 21, 31)).setBorder(null);
            this.scrollUpButton = new ArrowButton(1);
            this.scrollDownButton = new ArrowButton(5);
            this.add(this.scrollPane, "Center");
            this.add(this.scrollUpButton, "North");
            this.add(this.scrollDownButton, "South");
            this.setBackground(popup.getBackground());
            this.setBorder(popup.getBorder());
            popup.setBorder(null);
            popup.addPopupMenuListener(this);
            popup.addMouseWheelListener(this);
            popup.addMenuKeyListener(this);
            this.updateArrowButtons();
            this.putClientProperty("Popup.borderCornerRadius", UIManager.getInt("PopupMenu.borderCornerRadius"));
        }
        
        void scroll(final int unitsToScroll) {
            if (this.unitIncrement == 0) {
                this.unitIncrement = new JMenuItem("X").getPreferredSize().height;
            }
            final JViewport viewport = this.scrollPane.getViewport();
            final Point viewPosition = viewport.getViewPosition();
            int newY = viewPosition.y + this.unitIncrement * unitsToScroll;
            if (newY < 0) {
                newY = 0;
            }
            else {
                newY = Math.min(newY, viewport.getViewSize().height - viewport.getExtentSize().height);
            }
            viewport.setViewPosition(new Point(viewPosition.x, newY));
            this.updateArrowButtons();
        }
        
        void updateArrowButtons() {
            final JViewport viewport = this.scrollPane.getViewport();
            final Point viewPosition = viewport.getViewPosition();
            this.scrollUpButton.setVisible(viewPosition.y > 0);
            this.scrollDownButton.setVisible(viewPosition.y < viewport.getViewSize().height - viewport.getExtentSize().height);
        }
        
        @Override
        public void popupMenuWillBecomeInvisible(final PopupMenuEvent e) {
            this.popup.setBorder(this.getBorder());
            this.popup.removePopupMenuListener(this);
            this.popup.removeMouseWheelListener(this);
            this.popup.removeMenuKeyListener(this);
        }
        
        @Override
        public void popupMenuWillBecomeVisible(final PopupMenuEvent e) {
        }
        
        @Override
        public void popupMenuCanceled(final PopupMenuEvent e) {
        }
        
        @Override
        public void mouseWheelMoved(final MouseWheelEvent e) {
            final Point mouseLocation = SwingUtilities.convertPoint((Component)e.getSource(), e.getPoint(), this);
            this.scroll(e.getUnitsToScroll());
            final Component c = SwingUtilities.getDeepestComponentAt(this, mouseLocation.x, mouseLocation.y);
            if (c instanceof JMenuItem) {
                final ButtonUI ui = ((JMenuItem)c).getUI();
                if (ui instanceof BasicMenuItemUI) {
                    MenuSelectionManager.defaultManager().setSelectedPath(((BasicMenuItemUI)ui).getPath());
                }
            }
            e.consume();
        }
        
        @Override
        public void menuKeyPressed(final MenuKeyEvent e) {
            EventQueue.invokeLater(() -> {
                if (!(!this.isDisplayable())) {
                    final MenuElement[] path = MenuSelectionManager.defaultManager().getSelectedPath();
                    if (path.length != 0) {
                        final Component c = path[path.length - 1].getComponent();
                        final JViewport viewport = this.scrollPane.getViewport();
                        final Point pt = SwingUtilities.convertPoint(c, 0, 0, viewport);
                        viewport.scrollRectToVisible(new Rectangle(pt, c.getSize()));
                        final boolean upVisible = this.scrollUpButton.isVisible();
                        this.updateArrowButtons();
                        if (!upVisible && this.scrollUpButton.isVisible()) {
                            final Point viewPosition = viewport.getViewPosition();
                            final int newY = viewPosition.y + this.scrollUpButton.getPreferredSize().height;
                            viewport.setViewPosition(new Point(viewPosition.x, newY));
                        }
                    }
                }
            });
        }
        
        @Override
        public void menuKeyTyped(final MenuKeyEvent e) {
        }
        
        @Override
        public void menuKeyReleased(final MenuKeyEvent e) {
        }
        
        private class ArrowButton extends FlatArrowButton implements MouseListener, ActionListener
        {
            private Timer timer;
            
            ArrowButton(final int direction) {
                super(direction, FlatPopupScroller.this.this$0.arrowType, FlatPopupScroller.this.this$0.scrollArrowColor, null, null, FlatPopupScroller.this.this$0.hoverScrollArrowBackground, null, null);
                this.addMouseListener(this);
            }
            
            @Override
            public void paint(final Graphics g) {
                g.setColor(FlatPopupScroller.this.popup.getBackground());
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                super.paint(g);
            }
            
            @Override
            public void mouseClicked(final MouseEvent e) {
            }
            
            @Override
            public void mousePressed(final MouseEvent e) {
            }
            
            @Override
            public void mouseReleased(final MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(final MouseEvent e) {
                if (this.timer == null) {
                    this.timer = new Timer(50, this);
                }
                this.timer.start();
            }
            
            @Override
            public void mouseExited(final MouseEvent e) {
                if (this.timer != null) {
                    this.timer.stop();
                }
            }
            
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (this.timer != null && !this.isDisplayable()) {
                    this.timer.stop();
                    return;
                }
                FlatPopupScroller.this.scroll((this.direction == 1) ? -1 : 1);
            }
        }
    }
}
