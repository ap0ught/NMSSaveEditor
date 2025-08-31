// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.Container;
import com.formdev.flatlaf.FlatLaf;
import java.awt.Component;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.SwingUtilities;
import javax.swing.InputMap;
import java.beans.PropertyChangeEvent;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Objects;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import com.formdev.flatlaf.util.UIScale;
import java.lang.invoke.MethodHandles;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import javax.swing.UIManager;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.plaf.basic.BasicScrollBarUI;

@FlatStylingSupport.StyleableFields({ @FlatStylingSupport.StyleableField(cls = BasicScrollBarUI.class, key = "track", fieldName = "trackColor"), @FlatStylingSupport.StyleableField(cls = BasicScrollBarUI.class, key = "thumb", fieldName = "thumbColor"), @FlatStylingSupport.StyleableField(cls = BasicScrollBarUI.class, key = "width", fieldName = "scrollBarWidth"), @FlatStylingSupport.StyleableField(cls = BasicScrollBarUI.class, key = "minimumThumbSize"), @FlatStylingSupport.StyleableField(cls = BasicScrollBarUI.class, key = "maximumThumbSize") })
public class FlatScrollBarUI extends BasicScrollBarUI implements FlatStylingSupport.StyleableUI, FlatStylingSupport.StyleableLookupProvider
{
    @FlatStylingSupport.Styleable
    protected boolean allowsAbsolutePositioning;
    @FlatStylingSupport.Styleable
    protected Dimension minimumButtonSize;
    @FlatStylingSupport.Styleable
    protected Insets trackInsets;
    @FlatStylingSupport.Styleable
    protected Insets thumbInsets;
    @FlatStylingSupport.Styleable
    protected int trackArc;
    @FlatStylingSupport.Styleable
    protected int thumbArc;
    @FlatStylingSupport.Styleable
    protected Color hoverTrackColor;
    @FlatStylingSupport.Styleable
    protected Color hoverThumbColor;
    @FlatStylingSupport.Styleable
    protected boolean hoverThumbWithTrack;
    @FlatStylingSupport.Styleable
    protected Color pressedTrackColor;
    @FlatStylingSupport.Styleable
    protected Color pressedThumbColor;
    @FlatStylingSupport.Styleable
    protected boolean pressedThumbWithTrack;
    @FlatStylingSupport.Styleable
    protected boolean showButtons;
    @FlatStylingSupport.Styleable
    protected String arrowType;
    @FlatStylingSupport.Styleable
    protected Color buttonArrowColor;
    @FlatStylingSupport.Styleable
    protected Color buttonDisabledArrowColor;
    @FlatStylingSupport.Styleable
    protected Color hoverButtonBackground;
    @FlatStylingSupport.Styleable
    protected Color pressedButtonBackground;
    private MouseAdapter hoverListener;
    protected boolean hoverTrack;
    protected boolean hoverThumb;
    private Map<String, Object> oldStyleValues;
    private boolean isAWTPeer;
    private static boolean isPressed;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatScrollBarUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.hoverListener = new ScrollBarHoverListener();
        this.scrollbar.addMouseListener(this.hoverListener);
        this.scrollbar.addMouseMotionListener(this.hoverListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.scrollbar.removeMouseListener(this.hoverListener);
        this.scrollbar.removeMouseMotionListener(this.hoverListener);
        this.hoverListener = null;
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.allowsAbsolutePositioning = super.getSupportsAbsolutePositioning();
        this.minimumButtonSize = UIManager.getDimension("ScrollBar.minimumButtonSize");
        this.trackInsets = UIManager.getInsets("ScrollBar.trackInsets");
        this.thumbInsets = UIManager.getInsets("ScrollBar.thumbInsets");
        this.trackArc = UIManager.getInt("ScrollBar.trackArc");
        this.thumbArc = UIManager.getInt("ScrollBar.thumbArc");
        this.hoverTrackColor = UIManager.getColor("ScrollBar.hoverTrackColor");
        this.hoverThumbColor = UIManager.getColor("ScrollBar.hoverThumbColor");
        this.hoverThumbWithTrack = UIManager.getBoolean("ScrollBar.hoverThumbWithTrack");
        this.pressedTrackColor = UIManager.getColor("ScrollBar.pressedTrackColor");
        this.pressedThumbColor = UIManager.getColor("ScrollBar.pressedThumbColor");
        this.pressedThumbWithTrack = UIManager.getBoolean("ScrollBar.pressedThumbWithTrack");
        this.showButtons = UIManager.getBoolean("ScrollBar.showButtons");
        this.arrowType = UIManager.getString("Component.arrowType");
        this.buttonArrowColor = UIManager.getColor("ScrollBar.buttonArrowColor");
        this.buttonDisabledArrowColor = UIManager.getColor("ScrollBar.buttonDisabledArrowColor");
        this.hoverButtonBackground = UIManager.getColor("ScrollBar.hoverButtonBackground");
        this.pressedButtonBackground = UIManager.getColor("ScrollBar.pressedButtonBackground");
        if (this.trackInsets == null) {
            this.trackInsets = new Insets(0, 0, 0, 0);
        }
        if (this.thumbInsets == null) {
            this.thumbInsets = new Insets(0, 0, 0, 0);
        }
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.minimumButtonSize = null;
        this.trackInsets = null;
        this.thumbInsets = null;
        this.hoverTrackColor = null;
        this.hoverThumbColor = null;
        this.pressedTrackColor = null;
        this.pressedThumbColor = null;
        this.buttonArrowColor = null;
        this.buttonDisabledArrowColor = null;
        this.hoverButtonBackground = null;
        this.pressedButtonBackground = null;
        this.oldStyleValues = null;
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        PropertyChangeListener superListener = super.createPropertyChangeListener();
        return new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Delegate to super listener
                if (superListener != null)
                    superListener.propertyChange(evt);
                // Add FlatLaf-specific property change handling here if needed
                // For example:
                if ("style".equals(evt.getPropertyName())) {
                    installStyle();
                }
            }
        };
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.scrollbar, "ScrollBar"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        if (this.incrButton instanceof FlatScrollBarButton) {
            ((FlatScrollBarButton)this.incrButton).updateStyle();
        }
        if (this.decrButton instanceof FlatScrollBarButton) {
            ((FlatScrollBarButton)this.decrButton).updateStyle();
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.scrollbar, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    @Override
    public MethodHandles.Lookup getLookupForStyling() {
        return MethodHandles.lookup();
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return UIScale.scale(super.getPreferredSize(c));
    }
    
    @Override
    protected JButton createDecreaseButton(final int orientation) {
        return new FlatScrollBarButton(orientation);
    }
    
    @Override
    protected JButton createIncreaseButton(final int orientation) {
        return new FlatScrollBarButton(orientation);
    }
    
    protected boolean isShowButtons() {
        Object showButtons = this.scrollbar.getClientProperty("JScrollBar.showButtons");
        if (showButtons == null && this.scrollbar.getParent() instanceof JScrollPane) {
            final JScrollPane scrollPane = (JScrollPane)this.scrollbar.getParent();
            showButtons = scrollPane.getClientProperty("JScrollBar.showButtons");
            if (showButtons == null && scrollPane.getUI() instanceof FlatScrollPaneUI) {
                showButtons = ((FlatScrollPaneUI)scrollPane.getUI()).showButtons;
            }
        }
        return (showButtons != null) ? Objects.equals(showButtons, true) : this.showButtons;
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
        super.paint(g, c);
        FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
    }
    
    @Override
    protected void paintTrack(final Graphics g, final JComponent c, final Rectangle trackBounds) {
        if (trackBounds.isEmpty() || !this.scrollbar.isEnabled()) {
            return;
        }
        g.setColor(this.getTrackColor(c, this.hoverTrack, FlatScrollBarUI.isPressed && this.hoverTrack && !this.hoverThumb));
        this.paintTrackOrThumb(g, c, trackBounds, this.trackInsets, this.trackArc);
    }
    
    @Override
    protected void paintThumb(final Graphics g, final JComponent c, final Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
            return;
        }
        g.setColor(this.getThumbColor(c, this.hoverThumb || (this.hoverThumbWithTrack && this.hoverTrack), FlatScrollBarUI.isPressed && (this.hoverThumb || (this.pressedThumbWithTrack && this.hoverTrack))));
        this.paintTrackOrThumb(g, c, thumbBounds, this.thumbInsets, this.thumbArc);
    }
    
    protected void paintTrackOrThumb(final Graphics g, final JComponent c, Rectangle bounds, Insets insets, int arc) {
        if (this.scrollbar.getOrientation() == 0) {
            insets = new Insets(insets.right, insets.top, insets.left, insets.bottom);
        }
        bounds = FlatUIUtils.subtractInsets(bounds, UIScale.scale(insets));
        if (arc <= 0) {
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
        else {
            arc = Math.min(UIScale.scale(arc), Math.min(bounds.width, bounds.height));
            g.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, arc, arc);
        }
    }
    
    @Override
    protected void paintDecreaseHighlight(final Graphics g) {
    }
    
    @Override
    protected void paintIncreaseHighlight(final Graphics g) {
    }
    
    protected Color getTrackColor(final JComponent c, final boolean hover, final boolean pressed) {
        final Color trackColor = FlatUIUtils.deriveColor(this.trackColor, c.getBackground());
        return (pressed && this.pressedTrackColor != null) ? FlatUIUtils.deriveColor(this.pressedTrackColor, trackColor) : ((hover && this.hoverTrackColor != null && !this.isAWTPeer) ? FlatUIUtils.deriveColor(this.hoverTrackColor, trackColor) : trackColor);
    }
    
    protected Color getThumbColor(final JComponent c, final boolean hover, final boolean pressed) {
        final Color trackColor = FlatUIUtils.deriveColor(this.trackColor, c.getBackground());
        final Color thumbColor = FlatUIUtils.deriveColor(this.thumbColor, trackColor);
        return (pressed && this.pressedThumbColor != null) ? FlatUIUtils.deriveColor(this.pressedThumbColor, thumbColor) : ((hover && this.hoverThumbColor != null && !this.isAWTPeer) ? FlatUIUtils.deriveColor(this.hoverThumbColor, thumbColor) : thumbColor);
    }
    
    @Override
    protected Dimension getMinimumThumbSize() {
        return UIScale.scale(FlatUIUtils.addInsets(super.getMinimumThumbSize(), this.thumbInsets));
    }
    
    @Override
    protected Dimension getMaximumThumbSize() {
        return UIScale.scale(FlatUIUtils.addInsets(super.getMaximumThumbSize(), this.thumbInsets));
    }
    
    @Override
    public boolean getSupportsAbsolutePositioning() {
        return this.allowsAbsolutePositioning;
    }
    
    private class ScrollBarHoverListener extends MouseAdapter
    {
        @Override
        public void mouseExited(final MouseEvent e) {
            if (!FlatScrollBarUI.isPressed) {
                final FlatScrollBarUI this$0 = FlatScrollBarUI.this;
                final FlatScrollBarUI this$2 = FlatScrollBarUI.this;
                final boolean b = false;
                this$2.hoverThumb = b;
                this$0.hoverTrack = b;
                this.repaint();
            }
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            if (!FlatScrollBarUI.isPressed) {
                this.update(e.getX(), e.getY());
            }
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) || this.isAbsolutePositioning(e)) {
                FlatScrollBarUI.isPressed = true;
                this.repaint();
                if (this.isAbsolutePositioning(e)) {
                    this.update(e.getX(), e.getY());
                }
            }
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) || this.isAbsolutePositioning(e)) {
                FlatScrollBarUI.isPressed = false;
                this.repaint();
            }
            this.update(e.getX(), e.getY());
        }
        
        private boolean isAbsolutePositioning(final MouseEvent e) {
            return FlatScrollBarUI.this.getSupportsAbsolutePositioning() && SwingUtilities.isMiddleMouseButton(e);
        }
        
        private void update(final int x, final int y) {
            final boolean inTrack = BasicScrollBarUI.this.getTrackBounds().contains(x, y);
            final boolean inThumb = BasicScrollBarUI.this.getThumbBounds().contains(x, y);
            if (inTrack != FlatScrollBarUI.this.hoverTrack || inThumb != FlatScrollBarUI.this.hoverThumb) {
                FlatScrollBarUI.this.hoverTrack = inTrack;
                FlatScrollBarUI.this.hoverThumb = inThumb;
                this.repaint();
            }
        }
        
        private void repaint() {
            if (FlatScrollBarUI.this.scrollbar.isEnabled()) {
                FlatScrollBarUI.this.scrollbar.repaint();
            }
        }
    }
    
    protected class FlatScrollBarButton extends FlatArrowButton
    {
        protected FlatScrollBarButton(final FlatScrollBarUI this$0, final int direction) {
            this(this$0, direction, this$0.arrowType, this$0.buttonArrowColor, this$0.buttonDisabledArrowColor, null, this$0.hoverButtonBackground, null, this$0.pressedButtonBackground);
        }
        
        protected FlatScrollBarButton(final int direction, final String type, final Color foreground, final Color disabledForeground, final Color hoverForeground, final Color hoverBackground, final Color pressedForeground, final Color pressedBackground) {
            super(direction, type, foreground, disabledForeground, hoverForeground, hoverBackground, pressedForeground, pressedBackground);
            this.setFocusable(false);
            this.setRequestFocusEnabled(false);
        }
        
        protected void updateStyle() {
            this.updateStyle(FlatScrollBarUI.this.arrowType, FlatScrollBarUI.this.buttonArrowColor, FlatScrollBarUI.this.buttonDisabledArrowColor, null, FlatScrollBarUI.this.hoverButtonBackground, null, FlatScrollBarUI.this.pressedButtonBackground);
        }
        
        @Override
        public int getArrowWidth() {
            int arrowWidth = Math.round(6.0f * (FlatScrollBarUI.this.scrollBarWidth / 10.0f));
            arrowWidth = FlatScrollBarUI.this.scrollBarWidth - (FlatScrollBarUI.this.scrollBarWidth - arrowWidth) / 2 * 2;
            return arrowWidth;
        }
        
        @Override
        protected Color deriveBackground(final Color background) {
            return FlatUIUtils.deriveColor(background, FlatScrollBarUI.this.scrollbar.getBackground());
        }
        
        @Override
        public Dimension getPreferredSize() {
            if (FlatScrollBarUI.this.isShowButtons()) {
                final int w = UIScale.scale(Math.max(FlatScrollBarUI.this.scrollBarWidth, (FlatScrollBarUI.this.minimumButtonSize != null) ? FlatScrollBarUI.this.minimumButtonSize.width : 0));
                final int h = UIScale.scale(Math.max(FlatScrollBarUI.this.scrollBarWidth, (FlatScrollBarUI.this.minimumButtonSize != null) ? FlatScrollBarUI.this.minimumButtonSize.height : 0));
                return new Dimension(w, h);
            }
            return new Dimension();
        }
        
        @Override
        public Dimension getMinimumSize() {
            return FlatScrollBarUI.this.isShowButtons() ? super.getMinimumSize() : new Dimension();
        }
        
        @Override
        public Dimension getMaximumSize() {
            return FlatScrollBarUI.this.isShowButtons() ? super.getMaximumSize() : new Dimension();
        }
    }
}
