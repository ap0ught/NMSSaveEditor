// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.text.AttributedCharacterIterator;
import java.awt.Paint;
import com.formdev.flatlaf.util.Graphics2DProxy;
import java.awt.Container;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.JMenu;
import java.awt.Shape;
import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Component;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.text.View;
import com.formdev.flatlaf.util.DerivedColor;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.FontMetrics;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import java.util.Map;
import com.formdev.flatlaf.icons.FlatMenuArrowIcon;
import com.formdev.flatlaf.icons.FlatCheckBoxMenuItemIcon;
import javax.swing.UIManager;
import javax.swing.KeyStroke;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JMenuItem;

public class FlatMenuItemRenderer
{
    private static final String KEY_MAX_ICONS_WIDTH = "FlatLaf.internal.FlatMenuItemRenderer.maxIconWidth";
    protected final JMenuItem menuItem;
    protected Icon checkIcon;
    protected Icon arrowIcon;
    @FlatStylingSupport.Styleable
    protected Font acceleratorFont;
    protected final String acceleratorDelimiter;
    @FlatStylingSupport.Styleable
    protected boolean verticallyAlignText;
    @FlatStylingSupport.Styleable
    protected int minimumWidth;
    @FlatStylingSupport.Styleable
    protected Dimension minimumIconSize;
    @FlatStylingSupport.Styleable
    protected int textAcceleratorGap;
    @FlatStylingSupport.Styleable
    protected int textNoAcceleratorGap;
    @FlatStylingSupport.Styleable
    protected int acceleratorArrowGap;
    @FlatStylingSupport.Styleable
    protected Color checkBackground;
    @FlatStylingSupport.Styleable
    protected Insets checkMargins;
    @FlatStylingSupport.Styleable
    protected Insets selectionInsets;
    @FlatStylingSupport.Styleable
    protected int selectionArc;
    @FlatStylingSupport.Styleable
    protected Color underlineSelectionBackground;
    @FlatStylingSupport.Styleable
    protected Color underlineSelectionCheckBackground;
    @FlatStylingSupport.Styleable
    protected Color underlineSelectionColor;
    @FlatStylingSupport.Styleable
    protected int underlineSelectionHeight;
    private boolean iconsShared;
    private final Font menuFont;
    private KeyStroke cachedAccelerator;
    private String cachedAcceleratorText;
    private boolean cachedAcceleratorLeftToRight;
    private static final char controlGlyph = '\u2303';
    private static final char optionGlyph = '\u2325';
    private static final char shiftGlyph = '\u21e7';
    private static final char commandGlyph = '\u2318';
    
    protected FlatMenuItemRenderer(final JMenuItem menuItem, final Icon checkIcon, final Icon arrowIcon, final Font acceleratorFont, final String acceleratorDelimiter) {
        this.verticallyAlignText = FlatUIUtils.getUIBoolean("MenuItem.verticallyAlignText", true);
        this.minimumWidth = UIManager.getInt("MenuItem.minimumWidth");
        this.textAcceleratorGap = FlatUIUtils.getUIInt("MenuItem.textAcceleratorGap", 28);
        this.textNoAcceleratorGap = FlatUIUtils.getUIInt("MenuItem.textNoAcceleratorGap", 6);
        this.acceleratorArrowGap = FlatUIUtils.getUIInt("MenuItem.acceleratorArrowGap", 2);
        this.checkBackground = UIManager.getColor("MenuItem.checkBackground");
        this.checkMargins = UIManager.getInsets("MenuItem.checkMargins");
        this.selectionInsets = UIManager.getInsets("MenuItem.selectionInsets");
        this.selectionArc = UIManager.getInt("MenuItem.selectionArc");
        this.underlineSelectionBackground = UIManager.getColor("MenuItem.underlineSelectionBackground");
        this.underlineSelectionCheckBackground = UIManager.getColor("MenuItem.underlineSelectionCheckBackground");
        this.underlineSelectionColor = UIManager.getColor("MenuItem.underlineSelectionColor");
        this.underlineSelectionHeight = UIManager.getInt("MenuItem.underlineSelectionHeight");
        this.iconsShared = true;
        this.menuFont = UIManager.getFont("Menu.font");
        this.menuItem = menuItem;
        this.checkIcon = checkIcon;
        this.arrowIcon = arrowIcon;
        this.acceleratorFont = acceleratorFont;
        this.acceleratorDelimiter = acceleratorDelimiter;
        final Dimension minimumIconSize = UIManager.getDimension("MenuItem.minimumIconSize");
        this.minimumIconSize = ((minimumIconSize != null) ? minimumIconSize : new Dimension(16, 16));
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        if (key.startsWith("icon.") || key.equals("selectionForeground")) {
            if (this.iconsShared) {
                if (this.checkIcon instanceof FlatCheckBoxMenuItemIcon) {
                    this.checkIcon = FlatStylingSupport.cloneIcon(this.checkIcon);
                }
                if (this.arrowIcon instanceof FlatMenuArrowIcon) {
                    this.arrowIcon = FlatStylingSupport.cloneIcon(this.arrowIcon);
                }
                this.iconsShared = false;
            }
            if (key.startsWith("icon.")) {
                final String key2 = key.substring("icon.".length());
                try {
                    if (this.checkIcon instanceof FlatCheckBoxMenuItemIcon) {
                        return ((FlatCheckBoxMenuItemIcon)this.checkIcon).applyStyleProperty(key2, value);
                    }
                }
                catch (final FlatStylingSupport.UnknownStyleException ex) {}
                try {
                    if (this.arrowIcon instanceof FlatMenuArrowIcon) {
                        return ((FlatMenuArrowIcon)this.arrowIcon).applyStyleProperty(key2, value);
                    }
                }
                catch (final FlatStylingSupport.UnknownStyleException ex2) {}
                throw new FlatStylingSupport.UnknownStyleException(key);
            }
            if (key.equals("selectionForeground")) {
                if (this.checkIcon instanceof FlatCheckBoxMenuItemIcon) {
                    ((FlatCheckBoxMenuItemIcon)this.checkIcon).applyStyleProperty(key, value);
                }
                if (this.arrowIcon instanceof FlatMenuArrowIcon) {
                    ((FlatMenuArrowIcon)this.arrowIcon).applyStyleProperty(key, value);
                }
                throw new FlatStylingSupport.UnknownStyleException(key);
            }
        }
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }
    
    public Map<String, Class<?>> getStyleableInfos() {
        final Map<String, Class<?>> infos = FlatStylingSupport.getAnnotatedStyleableInfos(this);
        if (this.checkIcon instanceof FlatCheckBoxMenuItemIcon) {
            FlatStylingSupport.putAllPrefixKey(infos, "icon.", ((FlatCheckBoxMenuItemIcon)this.checkIcon).getStyleableInfos());
        }
        infos.remove("icon.selectionForeground");
        if (this.arrowIcon instanceof FlatMenuArrowIcon) {
            FlatStylingSupport.putAllPrefixKey(infos, "icon.", ((FlatMenuArrowIcon)this.arrowIcon).getStyleableInfos());
        }
        infos.remove("icon.selectionForeground");
        return infos;
    }
    
    public Object getStyleableValue(final String key) {
        if (key.startsWith("icon.")) {
            final String key2 = key.substring("icon.".length());
            if (this.checkIcon instanceof FlatCheckBoxMenuItemIcon) {
                return ((FlatCheckBoxMenuItemIcon)this.checkIcon).getStyleableValue(key2);
            }
            if (this.arrowIcon instanceof FlatMenuArrowIcon) {
                return ((FlatMenuArrowIcon)this.arrowIcon).getStyleableValue(key2);
            }
        }
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    protected Dimension getPreferredMenuItemSize() {
        int width = 0;
        int height = 0;
        final boolean isTopLevelMenu = isTopLevelMenu(this.menuItem);
        final Rectangle viewRect = new Rectangle(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        final Rectangle iconRect = new Rectangle();
        final Rectangle textRect = new Rectangle();
        SwingUtilities.layoutCompoundLabel(this.menuItem, this.menuItem.getFontMetrics(isTopLevelMenu ? this.getTopLevelFont() : this.menuItem.getFont()), this.menuItem.getText(), this.getIconForLayout(), this.menuItem.getVerticalAlignment(), this.menuItem.getHorizontalAlignment(), this.menuItem.getVerticalTextPosition(), this.menuItem.getHorizontalTextPosition(), viewRect, iconRect, textRect, UIScale.scale(this.menuItem.getIconTextGap()));
        final Rectangle labelRect = iconRect.union(textRect);
        width += labelRect.width;
        height = Math.max(labelRect.height, height);
        final String accelText = this.getAcceleratorText();
        if (accelText != null) {
            width += UIScale.scale(isTopLevelMenu ? this.menuItem.getIconTextGap() : this.textAcceleratorGap);
            final FontMetrics accelFm = this.menuItem.getFontMetrics(this.acceleratorFont);
            width += SwingUtilities.computeStringWidth(accelFm, accelText);
            height = Math.max(accelFm.getHeight(), height);
        }
        if (!isTopLevelMenu && this.arrowIcon != null) {
            if (accelText == null) {
                width += UIScale.scale(this.textNoAcceleratorGap);
            }
            width += UIScale.scale(this.acceleratorArrowGap);
            width += this.arrowIcon.getIconWidth();
            height = Math.max(this.arrowIcon.getIconHeight(), height);
        }
        final Insets insets = this.menuItem.getInsets();
        width += insets.left + insets.right;
        height += insets.top + insets.bottom;
        if (!isTopLevelMenu) {
            final int minimumWidth = FlatUIUtils.minimumWidth(this.menuItem, this.minimumWidth);
            width = Math.max(width, UIScale.scale(minimumWidth));
        }
        return new Dimension(width, height);
    }
    
    private void layout(final Rectangle viewRect, final Rectangle iconRect, final Rectangle textRect, final Rectangle accelRect, final Rectangle arrowRect, final Rectangle labelRect) {
        final boolean isTopLevelMenu = isTopLevelMenu(this.menuItem);
        if (!isTopLevelMenu && this.arrowIcon != null) {
            arrowRect.width = this.arrowIcon.getIconWidth();
            arrowRect.height = this.arrowIcon.getIconHeight();
        }
        else {
            arrowRect.setSize(0, 0);
        }
        arrowRect.y = viewRect.y + centerOffset(viewRect.height, arrowRect.height);
        final String accelText = this.getAcceleratorText();
        if (accelText != null) {
            final FontMetrics accelFm = this.menuItem.getFontMetrics(this.acceleratorFont);
            accelRect.width = SwingUtilities.computeStringWidth(accelFm, accelText);
            accelRect.height = accelFm.getHeight();
            accelRect.y = viewRect.y + centerOffset(viewRect.height, accelRect.height);
        }
        else {
            accelRect.setBounds(0, 0, 0, 0);
        }
        final int accelArrowGap = isTopLevelMenu ? 0 : UIScale.scale(this.acceleratorArrowGap);
        if (this.menuItem.getComponentOrientation().isLeftToRight()) {
            arrowRect.x = viewRect.x + viewRect.width - arrowRect.width;
            accelRect.x = arrowRect.x - accelArrowGap - accelRect.width;
        }
        else {
            arrowRect.x = viewRect.x;
            accelRect.x = arrowRect.x + accelArrowGap + arrowRect.width;
        }
        int accelArrowWidth = accelRect.width + arrowRect.width;
        if (accelText != null) {
            accelArrowWidth += UIScale.scale(isTopLevelMenu ? this.menuItem.getIconTextGap() : this.textAcceleratorGap);
        }
        if (!isTopLevelMenu && this.arrowIcon != null) {
            if (accelText == null) {
                accelArrowWidth += UIScale.scale(this.textNoAcceleratorGap);
            }
            accelArrowWidth += UIScale.scale(this.acceleratorArrowGap);
        }
        labelRect.setBounds(viewRect);
        labelRect.width -= accelArrowWidth;
        if (!this.menuItem.getComponentOrientation().isLeftToRight()) {
            labelRect.x += accelArrowWidth;
        }
        SwingUtilities.layoutCompoundLabel(this.menuItem, this.menuItem.getFontMetrics(isTopLevelMenu ? this.getTopLevelFont() : this.menuItem.getFont()), this.menuItem.getText(), this.getIconForLayout(), this.menuItem.getVerticalAlignment(), this.menuItem.getHorizontalAlignment(), this.menuItem.getVerticalTextPosition(), this.menuItem.getHorizontalTextPosition(), labelRect, iconRect, textRect, UIScale.scale(this.menuItem.getIconTextGap()));
    }
    
    private static int centerOffset(final int wh1, final int wh2) {
        return wh1 / 2 - wh2 / 2;
    }
    
    protected void paintMenuItem(final Graphics g, final Color selectionBackground, final Color selectionForeground, final Color disabledForeground, final Color acceleratorForeground, final Color acceleratorSelectionForeground) {
        final Rectangle viewRect = new Rectangle(this.menuItem.getWidth(), this.menuItem.getHeight());
        final Insets insets = this.menuItem.getInsets();
        final Rectangle rectangle = viewRect;
        rectangle.x += insets.left;
        final Rectangle rectangle2 = viewRect;
        rectangle2.y += insets.top;
        final Rectangle rectangle3 = viewRect;
        rectangle3.width -= insets.left + insets.right;
        final Rectangle rectangle4 = viewRect;
        rectangle4.height -= insets.top + insets.bottom;
        final Rectangle iconRect = new Rectangle();
        final Rectangle textRect = new Rectangle();
        final Rectangle accelRect = new Rectangle();
        final Rectangle arrowRect = new Rectangle();
        final Rectangle labelRect = new Rectangle();
        this.layout(viewRect, iconRect, textRect, accelRect, arrowRect, labelRect);
        final boolean armedOrSelected = isArmedOrSelected(this.menuItem);
        final boolean underlineSelection = this.isUnderlineSelection();
        this.paintBackground(g);
        if (armedOrSelected) {
            if (underlineSelection) {
                this.paintUnderlineSelection(g, this.underlineSelectionBackground, this.underlineSelectionColor, this.underlineSelectionHeight);
            }
            else {
                this.paintSelection(g, selectionBackground, this.selectionInsets, this.selectionArc);
            }
        }
        this.paintIcon(g, iconRect, this.getIconForPainting(), underlineSelection ? this.underlineSelectionCheckBackground : this.checkBackground, selectionBackground);
        this.paintText(g, textRect, this.menuItem.getText(), selectionForeground, disabledForeground);
        this.paintAccelerator(g, accelRect, this.getAcceleratorText(), acceleratorForeground, acceleratorSelectionForeground, disabledForeground);
        if (!isTopLevelMenu(this.menuItem)) {
            this.paintArrowIcon(g, arrowRect, this.arrowIcon);
        }
    }
    
    protected void paintBackground(final Graphics g) {
        if (this.menuItem.isOpaque()) {
            g.setColor(this.menuItem.getBackground());
            g.fillRect(0, 0, this.menuItem.getWidth(), this.menuItem.getHeight());
        }
    }
    
    protected void paintSelection(final Graphics g, final Color selectionBackground, final Insets selectionInsets, final int selectionArc) {
        final float arc = UIScale.scale(selectionArc / 2.0f);
        g.setColor(this.deriveBackground(selectionBackground));
        FlatUIUtils.paintSelection((Graphics2D)g, 0, 0, this.menuItem.getWidth(), this.menuItem.getHeight(), UIScale.scale(selectionInsets), arc, arc, arc, arc, 0);
    }
    
    protected void paintUnderlineSelection(final Graphics g, final Color underlineSelectionBackground, final Color underlineSelectionColor, final int underlineSelectionHeight) {
        final int width = this.menuItem.getWidth();
        final int height = this.menuItem.getHeight();
        g.setColor(this.deriveBackground(underlineSelectionBackground));
        g.fillRect(0, 0, width, height);
        final int underlineHeight = UIScale.scale(underlineSelectionHeight);
        g.setColor(underlineSelectionColor);
        if (isTopLevelMenu(this.menuItem)) {
            g.fillRect(0, height - underlineHeight, width, underlineHeight);
        }
        else if (this.menuItem.getComponentOrientation().isLeftToRight()) {
            g.fillRect(0, 0, underlineHeight, height);
        }
        else {
            g.fillRect(width - underlineHeight, 0, underlineHeight, height);
        }
    }
    
    protected Color deriveBackground(final Color background) {
        if (!(background instanceof DerivedColor)) {
            return background;
        }
        final Color baseColor = this.menuItem.isOpaque() ? this.menuItem.getBackground() : FlatUIUtils.getParentBackground(this.menuItem);
        return FlatUIUtils.deriveColor(background, baseColor);
    }
    
    protected void paintIcon(final Graphics g, final Rectangle iconRect, final Icon icon, final Color checkBackground, final Color selectionBackground) {
        if (this.menuItem.isSelected() && this.checkIcon != null && icon != this.checkIcon) {
            final Rectangle r = FlatUIUtils.addInsets(iconRect, UIScale.scale(this.checkMargins));
            g.setColor(FlatUIUtils.deriveColor(checkBackground, selectionBackground));
            g.fillRect(r.x, r.y, r.width, r.height);
        }
        paintIcon(g, this.menuItem, icon, iconRect);
    }
    
    protected void paintText(final Graphics g, final Rectangle textRect, final String text, final Color selectionForeground, final Color disabledForeground) {
        final View htmlView = (View)this.menuItem.getClientProperty("html");
        if (htmlView != null) {
            paintHTMLText(g, this.menuItem, textRect, htmlView, this.isUnderlineSelection() ? null : selectionForeground);
            return;
        }
        final int mnemonicIndex = FlatLaf.isShowMnemonics() ? this.menuItem.getDisplayedMnemonicIndex() : -1;
        final boolean isTopLevelMenu = isTopLevelMenu(this.menuItem);
        final Color foreground = (isTopLevelMenu ? this.menuItem.getParent() : this.menuItem).getForeground();
        paintText(g, this.menuItem, textRect, text, mnemonicIndex, isTopLevelMenu ? this.getTopLevelFont() : this.menuItem.getFont(), foreground, this.isUnderlineSelection() ? foreground : selectionForeground, disabledForeground);
    }
    
    protected void paintAccelerator(final Graphics g, final Rectangle accelRect, final String accelText, final Color foreground, final Color selectionForeground, final Color disabledForeground) {
        paintText(g, this.menuItem, accelRect, accelText, -1, this.acceleratorFont, foreground, this.isUnderlineSelection() ? foreground : selectionForeground, disabledForeground);
    }
    
    protected void paintArrowIcon(final Graphics g, final Rectangle arrowRect, final Icon arrowIcon) {
        paintIcon(g, this.menuItem, arrowIcon, arrowRect);
    }
    
    protected static void paintIcon(final Graphics g, final JMenuItem menuItem, final Icon icon, final Rectangle iconRect) {
        if (icon == null) {
            return;
        }
        final int x = iconRect.x + centerOffset(iconRect.width, icon.getIconWidth());
        final int y = iconRect.y + centerOffset(iconRect.height, icon.getIconHeight());
        icon.paintIcon(menuItem, g, x, y);
    }
    
    protected static void paintText(final Graphics g, final JMenuItem menuItem, final Rectangle textRect, final String text, final int mnemonicIndex, final Font font, final Color foreground, final Color selectionForeground, final Color disabledForeground) {
        if (text == null || text.isEmpty()) {
            return;
        }
        final FontMetrics fm = menuItem.getFontMetrics(font);
        final Font oldFont = g.getFont();
        g.setFont(font);
        g.setColor(menuItem.isEnabled() ? (isArmedOrSelected(menuItem) ? selectionForeground : foreground) : disabledForeground);
        FlatUIUtils.drawStringUnderlineCharAt(menuItem, g, text, mnemonicIndex, textRect.x, textRect.y + fm.getAscent());
        g.setFont(oldFont);
    }
    
    protected static void paintHTMLText(Graphics g, final JMenuItem menuItem, Rectangle textRect, final View htmlView, final Color selectionForeground) {
        textRect = new Rectangle(textRect);
        textRect.width = (int)htmlView.getPreferredSpan(0);
        if (isArmedOrSelected(menuItem) && selectionForeground != null) {
            g = new GraphicsProxyWithTextColor((Graphics2D)g, selectionForeground);
        }
        htmlView.paint(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g), textRect);
    }
    
    protected static boolean isArmedOrSelected(final JMenuItem menuItem) {
        return menuItem.isArmed() || (menuItem instanceof JMenu && menuItem.isSelected());
    }
    
    protected static boolean isTopLevelMenu(final JMenuItem menuItem) {
        return menuItem instanceof JMenu && ((JMenu)menuItem).isTopLevelMenu();
    }
    
    protected boolean isUnderlineSelection() {
        return "underline".equals(UIManager.getString("MenuItem.selectionType"));
    }
    
    private Font getTopLevelFont() {
        final Font font = this.menuItem.getFont();
        return (font != this.menuFont || this.menuItem.getParent() == null) ? font : this.menuItem.getParent().getFont();
    }
    
    private Icon getIconForPainting() {
        final Icon icon = this.menuItem.getIcon();
        if (icon == null && this.checkIcon != null && !isTopLevelMenu(this.menuItem)) {
            return this.checkIcon;
        }
        if (icon == null) {
            return null;
        }
        if (!this.menuItem.isEnabled()) {
            return this.menuItem.getDisabledIcon();
        }
        if (this.menuItem.getModel().isPressed() && this.menuItem.isArmed()) {
            final Icon pressedIcon = this.menuItem.getPressedIcon();
            if (pressedIcon != null) {
                return pressedIcon;
            }
        }
        if (isArmedOrSelected(this.menuItem)) {
            final Icon selectedIcon = this.menuItem.getSelectedIcon();
            if (selectedIcon != null) {
                return selectedIcon;
            }
        }
        return icon;
    }
    
    private Icon getIconForLayout() {
        final Icon icon = this.menuItem.getIcon();
        if (isTopLevelMenu(this.menuItem)) {
            return (icon != null) ? new MinSizeIcon(icon) : null;
        }
        return new MinSizeIcon((icon != null) ? icon : this.checkIcon);
    }
    
    private String getAcceleratorText() {
        final KeyStroke accelerator = this.menuItem.getAccelerator();
        if (accelerator == null) {
            return null;
        }
        final boolean leftToRight = this.menuItem.getComponentOrientation().isLeftToRight();
        if (accelerator == this.cachedAccelerator && leftToRight == this.cachedAcceleratorLeftToRight) {
            return this.cachedAcceleratorText;
        }
        this.cachedAccelerator = accelerator;
        this.cachedAcceleratorText = this.getTextForAccelerator(accelerator);
        this.cachedAcceleratorLeftToRight = leftToRight;
        return this.cachedAcceleratorText;
    }
    
    protected String getTextForAccelerator(final KeyStroke accelerator) {
        final StringBuilder buf = new StringBuilder();
        final boolean leftToRight = this.menuItem.getComponentOrientation().isLeftToRight();
        final int modifiers = accelerator.getModifiers();
        if (modifiers != 0) {
            if (SystemInfo.isMacOS) {
                if (leftToRight) {
                    buf.append(this.getMacOSModifiersExText(modifiers, leftToRight));
                }
            }
            else {
                buf.append(InputEvent.getModifiersExText(modifiers)).append(this.acceleratorDelimiter);
            }
        }
        final int keyCode = accelerator.getKeyCode();
        if (keyCode != 0) {
            buf.append(KeyEvent.getKeyText(keyCode));
        }
        else {
            buf.append(accelerator.getKeyChar());
        }
        if (modifiers != 0 && !leftToRight && SystemInfo.isMacOS) {
            buf.append(this.getMacOSModifiersExText(modifiers, leftToRight));
        }
        return buf.toString();
    }
    
    protected String getMacOSModifiersExText(final int modifiers, final boolean leftToRight) {
        final StringBuilder buf = new StringBuilder();
        if ((modifiers & 0x80) != 0x0) {
            buf.append('\u2303');
        }
        if ((modifiers & 0x2200) != 0x0) {
            buf.append('\u2325');
        }
        if ((modifiers & 0x40) != 0x0) {
            buf.append('\u21e7');
        }
        if ((modifiers & 0x100) != 0x0) {
            buf.append('\u2318');
        }
        if (!leftToRight) {
            buf.reverse();
        }
        return buf.toString();
    }
    
    private int getMaxIconsWidth() {
        if (!this.verticallyAlignText) {
            return 0;
        }
        final Container parent = this.menuItem.getParent();
        if (!(parent instanceof JComponent)) {
            return 0;
        }
        int maxWidth = FlatClientProperties.clientPropertyInt((JComponent)parent, "FlatLaf.internal.FlatMenuItemRenderer.maxIconWidth", -1);
        if (maxWidth >= 0) {
            return maxWidth;
        }
        maxWidth = 0;
        for (final Component c : parent.getComponents()) {
            if (c instanceof JMenuItem) {
                final Icon icon = ((JMenuItem)c).getIcon();
                if (icon != null) {
                    maxWidth = Math.max(maxWidth, icon.getIconWidth());
                }
            }
        }
        ((JComponent)parent).putClientProperty("FlatLaf.internal.FlatMenuItemRenderer.maxIconWidth", maxWidth);
        return maxWidth;
    }
    
    static void clearClientProperties(final Component c) {
        if (!(c instanceof JComponent)) {
            return;
        }
        final JComponent jc = (JComponent)c;
        jc.putClientProperty("FlatLaf.internal.FlatMenuItemRenderer.maxIconWidth", null);
    }
    
    private class MinSizeIcon implements Icon
    {
        private final Icon delegate;
        
        MinSizeIcon(final Icon delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public int getIconWidth() {
            int iconWidth = (this.delegate != null) ? this.delegate.getIconWidth() : 0;
            iconWidth = Math.max(iconWidth, FlatMenuItemRenderer.this.getMaxIconsWidth());
            return Math.max(iconWidth, UIScale.scale(FlatMenuItemRenderer.this.minimumIconSize.width));
        }
        
        @Override
        public int getIconHeight() {
            final int iconHeight = (this.delegate != null) ? this.delegate.getIconHeight() : 0;
            return Math.max(iconHeight, UIScale.scale(FlatMenuItemRenderer.this.minimumIconSize.height));
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        }
    }
    
    private static class GraphicsProxyWithTextColor extends Graphics2DProxy
    {
        private final Color textColor;
        
        GraphicsProxyWithTextColor(final Graphics2D delegate, final Color textColor) {
            super(delegate);
            this.textColor = textColor;
        }
        
        @Override
        public void drawString(final String str, final int x, final int y) {
            final Paint oldPaint = this.getPaint();
            this.setPaint(this.textColor);
            super.drawString(str, x, y);
            this.setPaint(oldPaint);
        }
        
        @Override
        public void drawString(final String str, final float x, final float y) {
            final Paint oldPaint = this.getPaint();
            this.setPaint(this.textColor);
            super.drawString(str, x, y);
            this.setPaint(oldPaint);
        }
        
        @Override
        public void drawString(final AttributedCharacterIterator iterator, final int x, final int y) {
            final Paint oldPaint = this.getPaint();
            this.setPaint(this.textColor);
            super.drawString(iterator, x, y);
            this.setPaint(oldPaint);
        }
        
        @Override
        public void drawString(final AttributedCharacterIterator iterator, final float x, final float y) {
            final Paint oldPaint = this.getPaint();
            this.setPaint(this.textColor);
            super.drawString(iterator, x, y);
            this.setPaint(oldPaint);
        }
        
        @Override
        public void drawChars(final char[] data, final int offset, final int length, final int x, final int y) {
            final Paint oldPaint = this.getPaint();
            this.setPaint(this.textColor);
            super.drawChars(data, offset, length, x, y);
            this.setPaint(oldPaint);
        }
    }
}
