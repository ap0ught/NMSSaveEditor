// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Supplier;
import com.formdev.flatlaf.util.Graphics2DProxy;
import java.awt.geom.Point2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Paint;
import com.formdev.flatlaf.util.DerivedColor;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.border.CompoundBorder;
import com.formdev.flatlaf.util.UIScale;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.SwingUtilities;
import java.awt.Window;
import java.util.function.Predicate;
import java.awt.KeyboardFocusManager;
import java.awt.Container;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.plaf.UIResource;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatSystemProperties;
import javax.swing.JComponent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.UIDefaults;
import javax.swing.plaf.ComponentUI;
import java.util.IdentityHashMap;
import javax.swing.LookAndFeel;
import java.util.WeakHashMap;

public class FlatUIUtils
{
    private static boolean useSharedUIs;
    private static final WeakHashMap<LookAndFeel, IdentityHashMap<Object, ComponentUI>> sharedUIinstances;
    private static UIDefaults lightAWTPeerDefaults;
    public static final double MOVE_TO = -1.000000000001E12;
    public static final double QUAD_TO = -1.000000000002E12;
    public static final double CURVE_TO = -1.000000000003E12;
    public static final double ROUNDED = -1.000000000004E12;
    public static final double CLOSE_PATH = -1.000000000005E12;
    
    public static Rectangle addInsets(final Rectangle r, final Insets insets) {
        return new Rectangle(r.x - insets.left, r.y - insets.top, r.width + insets.left + insets.right, r.height + insets.top + insets.bottom);
    }
    
    public static Rectangle subtractInsets(final Rectangle r, final Insets insets) {
        return new Rectangle(r.x + insets.left, r.y + insets.top, r.width - insets.left - insets.right, r.height - insets.top - insets.bottom);
    }
    
    public static Dimension addInsets(final Dimension dim, final Insets insets) {
        return new Dimension(dim.width + insets.left + insets.right, dim.height + insets.top + insets.bottom);
    }
    
    public static Insets addInsets(final Insets insets1, final Insets insets2) {
        if (insets1 == null) {
            return insets2;
        }
        if (insets2 == null) {
            return insets1;
        }
        return new Insets(insets1.top + insets2.top, insets1.left + insets2.left, insets1.bottom + insets2.bottom, insets1.right + insets2.right);
    }
    
    public static void setInsets(final Insets dest, final Insets src) {
        dest.top = src.top;
        dest.left = src.left;
        dest.bottom = src.bottom;
        dest.right = src.right;
    }
    
    public static Color getUIColor(final String key, final int defaultColorRGB) {
        final Color color = UIManager.getColor(key);
        return (color != null) ? color : new Color(defaultColorRGB);
    }
    
    public static Color getUIColor(final String key, final Color defaultColor) {
        final Color color = UIManager.getColor(key);
        return (color != null) ? color : defaultColor;
    }
    
    public static Color getUIColor(final String key, final String defaultKey) {
        final Color color = UIManager.getColor(key);
        return (color != null) ? color : UIManager.getColor(defaultKey);
    }
    
    public static boolean getUIBoolean(final String key, final boolean defaultValue) {
        final Object value = UIManager.get(key);
        return (boolean)((value instanceof Boolean) ? value : defaultValue);
    }
    
    public static int getUIInt(final String key, final int defaultValue) {
        final Object value = UIManager.get(key);
        return (int)((value instanceof Integer) ? value : defaultValue);
    }
    
    public static float getUIFloat(final String key, final float defaultValue) {
        final Object value = UIManager.get(key);
        return (value instanceof Number) ? ((Number)value).floatValue() : defaultValue;
    }
    
    public static <T extends Enum<T>> T getUIEnum(final String key, final Class<T> enumType, final T defaultValue) {
        final Object value = UIManager.get(key);
        if (value instanceof String) {
            try {
                return Enum.valueOf(enumType, (String)value);
            }
            catch (final IllegalArgumentException ex) {}
        }
        return defaultValue;
    }
    
    public static boolean getBoolean(final JComponent c, final String systemPropertyKey, final String clientPropertyKey, final String uiKey, final boolean defaultValue) {
        Boolean value = FlatSystemProperties.getBooleanStrict(systemPropertyKey, null);
        if (value != null) {
            return value;
        }
        value = FlatClientProperties.clientPropertyBooleanStrict(c, clientPropertyKey, null);
        if (value != null) {
            return value;
        }
        return getUIBoolean(uiKey, defaultValue);
    }
    
    public static boolean isChevron(final String arrowType) {
        return !"triangle".equals(arrowType);
    }
    
    public static Color nonUIResource(final Color c) {
        return (c instanceof UIResource) ? new Color(c.getRGB(), true) : c;
    }
    
    public static Font nonUIResource(final Font font) {
        return (font instanceof UIResource) ? font.deriveFont(font.getStyle()) : font;
    }
    
    public static Border nonUIResource(final Border border) {
        return (border instanceof UIResource) ? new NonUIResourceBorder(border) : border;
    }
    
    static Border unwrapNonUIResourceBorder(final Border border) {
        return (border instanceof NonUIResourceBorder) ? ((NonUIResourceBorder)border).delegate : border;
    }
    
    public static int minimumWidth(final JComponent c, final int minimumWidth) {
        return FlatClientProperties.clientPropertyInt(c, "JComponent.minimumWidth", minimumWidth);
    }
    
    public static int minimumHeight(final JComponent c, final int minimumHeight) {
        return FlatClientProperties.clientPropertyInt(c, "JComponent.minimumHeight", minimumHeight);
    }
    
    public static boolean isCellEditor(final Component c) {
        if (c == null) {
            return false;
        }
        Component c2 = c;
        Container parent;
        for (int i = 0; i <= 2 && c2 != null; c2 = parent, ++i) {
            parent = c2.getParent();
            if (parent instanceof JTable && ((JTable)parent).getEditorComponent() == c2) {
                return true;
            }
        }
        final String name = c.getName();
        return "Table.editor".equals(name) || "Tree.cellEditor".equals(name) || (c instanceof JComponent && Boolean.TRUE.equals(((JComponent)c).getClientProperty("JComboBox.isTableCellEditor")));
    }
    
    public static boolean isPermanentFocusOwner(final Component c) {
        final KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        if (c instanceof JComponent) {
            final Object value = ((JComponent)c).getClientProperty("JComponent.focusOwner");
            if (value instanceof Predicate) {
                return ((Predicate)value).test(c) && isInActiveWindow(c, keyboardFocusManager.getActiveWindow());
            }
        }
        return c.hasFocus() || (keyboardFocusManager.getPermanentFocusOwner() == c && isInActiveWindow(c, keyboardFocusManager.getActiveWindow()));
    }
    
    static boolean isInActiveWindow(final Component c, final Window activeWindow) {
        final Window window = SwingUtilities.windowForComponent(c);
        return window == activeWindow || (window != null && window.getType() == Window.Type.POPUP && window.getOwner() == activeWindow);
    }
    
    static boolean isAWTPeer(final Component c) {
        return SystemInfo.isMacOS && c.getClass().getName().startsWith("sun.lwawt.LW");
    }
    
    static boolean needsLightAWTPeer(final JComponent c) {
        return isAWTPeer(c) && FlatLaf.isLafDark();
    }
    
    static void runWithLightAWTPeerUIDefaults(final Runnable runnable) {
        if (FlatUIUtils.lightAWTPeerDefaults == null) {
            final FlatLaf lightLaf = (UIManager.getInt("Component.focusWidth") >= 2) ? new FlatIntelliJLaf() : new FlatLightLaf();
            FlatUIUtils.lightAWTPeerDefaults = lightLaf.getDefaults();
        }
        FlatLaf.runWithUIDefaultsGetter(key -> {
            final Object value = FlatUIUtils.lightAWTPeerDefaults.get(key);
            return (value != null) ? value : FlatLaf.NULL_VALUE;
        }, runnable);
    }
    
    public static boolean isFullScreen(final Component c) {
        final GraphicsConfiguration gc = c.getGraphicsConfiguration();
        final GraphicsDevice gd = (gc != null) ? gc.getDevice() : null;
        final Window fullScreenWindow = (gd != null) ? gd.getFullScreenWindow() : null;
        return fullScreenWindow != null && fullScreenWindow == SwingUtilities.windowForComponent(c);
    }
    
    public static Boolean isRoundRect(final Component c) {
        return (c instanceof JComponent) ? FlatClientProperties.clientPropertyBooleanStrict((JComponent)c, "JComponent.roundRect", null) : null;
    }
    
    public static float getBorderFocusWidth(final JComponent c) {
        final FlatBorder border = getOutsideFlatBorder(c);
        return (border != null) ? UIScale.scale((float)border.getFocusWidth(c)) : 0.0f;
    }
    
    public static float getBorderLineWidth(final JComponent c) {
        final FlatBorder border = getOutsideFlatBorder(c);
        return (border != null) ? UIScale.scale((float)border.getLineWidth(c)) : 0.0f;
    }
    
    public static int getBorderFocusAndLineWidth(final JComponent c) {
        final FlatBorder border = getOutsideFlatBorder(c);
        return (border != null) ? Math.round(UIScale.scale((float)border.getFocusWidth(c)) + UIScale.scale((float)border.getLineWidth(c))) : 0;
    }
    
    public static float getBorderArc(final JComponent c) {
        final FlatBorder border = getOutsideFlatBorder(c);
        return (border != null) ? UIScale.scale((float)border.getArc(c)) : 0.0f;
    }
    
    public static boolean hasRoundBorder(final JComponent c) {
        return getBorderArc(c) >= c.getHeight();
    }
    
    public static FlatBorder getOutsideFlatBorder(final JComponent c) {
        Border border;
        for (border = c.getBorder(); !(border instanceof FlatBorder); border = ((CompoundBorder)border).getOutsideBorder()) {
            if (!(border instanceof CompoundBorder)) {
                return null;
            }
        }
        return (FlatBorder)border;
    }
    
    public static Object[] setRenderingHints(final Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        final Object[] oldRenderingHints = { g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING), g2.getRenderingHint(RenderingHints.KEY_STROKE_CONTROL) };
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        return oldRenderingHints;
    }
    
    public static void resetRenderingHints(final Graphics g, final Object[] oldRenderingHints) {
        final Graphics2D g2 = (Graphics2D)g;
        if (oldRenderingHints[0] != null) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldRenderingHints[0]);
        }
        if (oldRenderingHints[1] != null) {
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, oldRenderingHints[1]);
        }
    }
    
    public static void runWithoutRenderingHints(final Graphics g, final Object[] oldRenderingHints, final Runnable runnable) {
        if (oldRenderingHints == null) {
            runnable.run();
            return;
        }
        final Graphics2D g2 = (Graphics2D)g;
        final Object[] oldRenderingHints2 = { g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING), g2.getRenderingHint(RenderingHints.KEY_STROKE_CONTROL) };
        resetRenderingHints(g2, oldRenderingHints);
        runnable.run();
        resetRenderingHints(g2, oldRenderingHints2);
    }
    
    public static Color deriveColor(final Color color, final Color baseColor) {
        return (color instanceof DerivedColor) ? ((DerivedColor)color).derive(baseColor) : color;
    }
    
    public static void paintComponentBackground(final Graphics2D g, final int x, final int y, final int width, final int height, final float focusWidth, final float arc) {
        paintOutlinedComponent(g, x, y, width, height, focusWidth, 0.0f, 0.0f, 0.0f, arc, null, null, g.getPaint());
    }
    
    public static void paintOutlinedComponent(final Graphics2D g, final int x, final int y, final int width, final int height, final float focusWidth, final float focusWidthFraction, final float focusInnerWidth, final float borderWidth, final float arc, final Paint focusColor, final Paint borderColor, final Paint background) {
        final double systemScaleFactor = UIScale.getSystemScaleFactor(g);
        if (systemScaleFactor != 1.0 && systemScaleFactor != 2.0) {
            HiDPIUtils.paintAtScale1x(g, x, y, width, height, (g2d, x2, y2, width2, height2, scaleFactor) -> paintOutlinedComponentImpl(g2d, x2, y2, width2, height2, (float)(focusWidth * scaleFactor), focusWidthFraction, (float)(focusInnerWidth * scaleFactor), (float)(borderWidth * scaleFactor), (float)(arc * scaleFactor), focusColor, borderColor, background));
            return;
        }
        paintOutlinedComponentImpl(g, x, y, width, height, focusWidth, focusWidthFraction, focusInnerWidth, borderWidth, arc, focusColor, borderColor, background);
    }
    
    private static void paintOutlinedComponentImpl(final Graphics2D g, final int x, final int y, final int width, final int height, final float focusWidth, final float focusWidthFraction, float focusInnerWidth, final float borderWidth, final float arc, final Paint focusColor, Paint borderColor, final Paint background) {
        final float x2 = x + focusWidth;
        final float y2 = y + focusWidth;
        final float w1 = width - focusWidth * 2.0f;
        final float h1 = height - focusWidth * 2.0f;
        if (background != null) {
            g.setPaint(background);
            g.fill(createComponentRectangle(x2, y2, w1, h1, arc));
        }
        if (borderColor != null && borderColor.equals(focusColor)) {
            borderColor = null;
            focusInnerWidth = Math.max(focusInnerWidth, borderWidth);
        }
        final float paintedFocusWidth = focusWidth * focusWidthFraction + focusInnerWidth;
        if (focusColor != null && paintedFocusWidth != 0.0f) {
            final float inset = focusWidth - focusWidth * focusWidthFraction;
            final float x3 = x + inset;
            final float y3 = y + inset;
            final float w2 = width - inset * 2.0f;
            final float h2 = height - inset * 2.0f;
            float outerArc = arc + focusWidth * 2.0f;
            final float innerArc = arc - focusInnerWidth * 2.0f;
            if (focusWidth > 0.0f && arc > 0.0f && arc < UIScale.scale(10)) {
                outerArc -= UIScale.scale(2.0f);
            }
            if (focusWidthFraction != 1.0f) {
                outerArc = arc + (outerArc - arc) * focusWidthFraction;
            }
            g.setPaint(focusColor);
            paintOutline(g, x3, y3, w2, h2, paintedFocusWidth, outerArc, innerArc);
        }
        if (borderColor != null && borderWidth != 0.0f) {
            g.setPaint(borderColor);
            paintOutline(g, x2, y2, w1, h1, borderWidth, arc);
        }
    }
    
    public static void paintOutline(final Graphics2D g, final float x, final float y, final float w, final float h, final float lineWidth, final float arc) {
        paintOutline(g, x, y, w, h, lineWidth, arc, arc - lineWidth * 2.0f);
    }
    
    public static void paintOutline(final Graphics2D g, final float x, final float y, final float w, final float h, final float lineWidth, final float arc, final float innerArc) {
        if (lineWidth == 0.0f || w <= 0.0f || h <= 0.0f) {
            return;
        }
        final float t = lineWidth;
        final float t2x = t * 2.0f;
        final Path2D border = new Path2D.Float(0);
        border.append(createComponentRectangle(x, y, w, h, arc), false);
        border.append(createComponentRectangle(x + t, y + t, w - t2x, h - t2x, innerArc), false);
        g.fill(border);
    }
    
    public static Shape createComponentRectangle(final float x, final float y, final float w, final float h, float arc) {
        if (arc <= 0.0f) {
            return new Rectangle2D.Float(x, y, w, h);
        }
        if (w == h && arc >= w) {
            return new Ellipse2D.Float(x, y, w, h);
        }
        arc = Math.min(arc, Math.min(w, h));
        return new RoundRectangle2D.Float(x, y, w, h, arc, arc);
    }
    
    static void paintFilledRectangle(final Graphics g, final Color color, final float x, final float y, final float w, final float h) {
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            setRenderingHints(g2);
            g2.setColor(color);
            g2.fill(new Rectangle2D.Float(x, y, w, h));
        }
        finally {
            g2.dispose();
        }
    }
    
    public static void paintSelection(final Graphics2D g, int x, int y, int width, int height, final Insets insets, final float arcTopLeft, final float arcTopRight, final float arcBottomLeft, final float arcBottomRight, final int flags) {
        if (insets != null) {
            x += insets.left;
            y += insets.top;
            width -= insets.left + insets.right;
            height -= insets.top + insets.bottom;
        }
        if (arcTopLeft > 0.0f || arcTopRight > 0.0f || arcBottomLeft > 0.0f || arcBottomRight > 0.0f) {
            final double systemScaleFactor = UIScale.getSystemScaleFactor(g);
            if (systemScaleFactor != 1.0 && systemScaleFactor != 2.0) {
                HiDPIUtils.paintAtScale1x(g, x, y, width, height, (g2d, x2, y2, width2, height2, scaleFactor) -> paintRoundedSelectionImpl(g2d, x2, y2, width2, height2, (float)(arcTopLeft * scaleFactor), (float)(arcTopRight * scaleFactor), (float)(arcBottomLeft * scaleFactor), (float)(arcBottomRight * scaleFactor)));
            }
            else {
                paintRoundedSelectionImpl(g, x, y, width, height, arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight);
            }
        }
        else {
            g.fillRect(x, y, width, height);
        }
    }
    
    private static void paintRoundedSelectionImpl(final Graphics2D g, final int x, final int y, final int width, final int height, final float arcTopLeft, final float arcTopRight, final float arcBottomLeft, final float arcBottomRight) {
        final Object[] oldRenderingHints = setRenderingHints(g);
        g.fill(createRoundRectanglePath((float)x, (float)y, (float)width, (float)height, arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight));
        resetRenderingHints(g, oldRenderingHints);
    }
    
    public static void paintGrip(final Graphics g, final int x, final int y, final int width, final int height, final boolean horizontal, final int dotCount, int dotSize, int gap, final boolean centerPrecise) {
        dotSize = UIScale.scale(dotSize);
        gap = UIScale.scale(gap);
        final int gripSize = dotSize * dotCount + gap * (dotCount - 1);
        float gx;
        float gy;
        if (horizontal) {
            gx = (float)(x + Math.round((width - gripSize) / 2.0f));
            gy = y + (height - dotSize) / 2.0f;
            if (!centerPrecise) {
                gy = (float)Math.round(gy);
            }
        }
        else {
            gx = x + (width - dotSize) / 2.0f;
            gy = (float)(y + Math.round((height - gripSize) / 2.0f));
            if (!centerPrecise) {
                gx = (float)Math.round(gx);
            }
        }
        for (int i = 0; i < dotCount; ++i) {
            ((Graphics2D)g).fill(new Ellipse2D.Float(gx, gy, (float)dotSize, (float)dotSize));
            if (horizontal) {
                gx += dotSize + gap;
            }
            else {
                gy += dotSize + gap;
            }
        }
    }
    
    public static void paintParentBackground(final Graphics g, final JComponent c) {
        final Color background = getParentBackground(c);
        if (background != null) {
            g.setColor(background);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
    }
    
    public static Color getParentBackground(final JComponent c) {
        final Container parent = findOpaqueParent(c);
        final Color background = (parent != null) ? parent.getBackground() : null;
        if (background != null) {
            return background;
        }
        if (isAWTPeer(c)) {
            return (c instanceof JTextField || c instanceof JScrollPane || c.getBackground() == null) ? SystemColor.window : c.getBackground();
        }
        return UIManager.getColor("Panel.background");
    }
    
    private static Container findOpaqueParent(Container c) {
        while ((c = c.getParent()) != null) {
            if (c.isOpaque()) {
                return c;
            }
        }
        return null;
    }
    
    public static Path2D createRectangle(final float x, final float y, final float width, final float height, final float lineWidth) {
        final Path2D path = new Path2D.Float(0);
        path.append(new Rectangle2D.Float(x, y, width, height), false);
        path.append(new Rectangle2D.Float(x + lineWidth, y + lineWidth, width - lineWidth * 2.0f, height - lineWidth * 2.0f), false);
        return path;
    }
    
    public static Path2D createRoundRectangle(final float x, final float y, final float width, final float height, final float lineWidth, final float arcTopLeft, final float arcTopRight, final float arcBottomLeft, final float arcBottomRight) {
        final Path2D path = new Path2D.Float(0);
        path.append(createRoundRectanglePath(x, y, width, height, arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight), false);
        path.append(createRoundRectanglePath(x + lineWidth, y + lineWidth, width - lineWidth * 2.0f, height - lineWidth * 2.0f, arcTopLeft - lineWidth, arcTopRight - lineWidth, arcBottomLeft - lineWidth, arcBottomRight - lineWidth), false);
        return path;
    }
    
    public static Shape createRoundRectanglePath(final float x, final float y, final float width, final float height, float arcTopLeft, float arcTopRight, float arcBottomLeft, float arcBottomRight) {
        if (arcTopLeft <= 0.0f && arcTopRight <= 0.0f && arcBottomLeft <= 0.0f && arcBottomRight <= 0.0f) {
            return new Rectangle2D.Float(x, y, width, height);
        }
        final float maxArc = Math.min(width, height) / 2.0f;
        arcTopLeft = ((arcTopLeft > 0.0f) ? Math.min(arcTopLeft, maxArc) : 0.0f);
        arcTopRight = ((arcTopRight > 0.0f) ? Math.min(arcTopRight, maxArc) : 0.0f);
        arcBottomLeft = ((arcBottomLeft > 0.0f) ? Math.min(arcBottomLeft, maxArc) : 0.0f);
        arcBottomRight = ((arcBottomRight > 0.0f) ? Math.min(arcBottomRight, maxArc) : 0.0f);
        final float x2 = x + width;
        final float y2 = y + height;
        final double c = 0.5522847498307933;
        final double ci = 1.0 - c;
        final double ciTopLeft = arcTopLeft * ci;
        final double ciTopRight = arcTopRight * ci;
        final double ciBottomLeft = arcBottomLeft * ci;
        final double ciBottomRight = arcBottomRight * ci;
        final Path2D rect = new Path2D.Float(1, 16);
        rect.moveTo(x2 - arcTopRight, y);
        rect.curveTo(x2 - ciTopRight, y, x2, y + ciTopRight, x2, y + arcTopRight);
        rect.lineTo(x2, y2 - arcBottomRight);
        rect.curveTo(x2, y2 - ciBottomRight, x2 - ciBottomRight, y2, x2 - arcBottomRight, y2);
        rect.lineTo(x + arcBottomLeft, y2);
        rect.curveTo(x + ciBottomLeft, y2, x, y2 - ciBottomLeft, x, y2 - arcBottomLeft);
        rect.lineTo(x, y + arcTopLeft);
        rect.curveTo(x, y + ciTopLeft, x + ciTopLeft, y, x + arcTopLeft, y);
        rect.closePath();
        return rect;
    }
    
    public static Shape createRoundTrianglePath(final float x1, final float y1, final float x2, final float y2, final float x3, final float y3, final float arc) {
        final double averageSideLength = (distance(x1, y1, x2, y2) + distance(x2, y2, x3, y3) + distance(x3, y3, x1, y1)) / 3.0;
        final double t1 = 1.0 / averageSideLength * arc;
        final double t2 = 1.0 - t1;
        return createPath(lerp(x3, x1, t2), lerp(y3, y1, t2), -1.000000000002E12, x1, y1, lerp(x1, x2, t1), lerp(y1, y2, t1), lerp(x1, x2, t2), lerp(y1, y2, t2), -1.000000000002E12, x2, y2, lerp(x2, x3, t1), lerp(y2, y3, t1), lerp(x2, x3, t2), lerp(y2, y3, t2), -1.000000000002E12, x3, y3, lerp(x3, x1, t1), lerp(y3, y1, t1));
    }
    
    public static void paintArrow(final Graphics2D g, final int x, final int y, final int width, final int height, final int direction, final boolean chevron, final int arrowSize, final float arrowThickness, final float xOffset, final float yOffset) {
        float aw = (float)UIScale.scale(arrowSize + (chevron ? -1 : 0));
        float ah = chevron ? (aw / 2.0f) : ((float)UIScale.scale(arrowSize / 2 + 1));
        final boolean vert = direction == 1 || direction == 5;
        if (!vert) {
            final float temp = aw;
            aw = ah;
            ah = temp;
        }
        final int extra = chevron ? 1 : 0;
        final float ox = (width - (aw + extra)) / 2.0f + UIScale.scale(xOffset);
        final float oy = (height - (ah + extra)) / 2.0f + UIScale.scale(yOffset);
        final float ax = x + ((direction == 7) ? (-Math.round(-(ox + aw)) - aw) : ((float)Math.round(ox)));
        final float ay = y + ((direction == 1) ? (-Math.round(-(oy + ah)) - ah) : ((float)Math.round(oy)));
        g.translate(ax, ay);
        final Shape arrowShape = createArrowShape(direction, chevron, aw, ah);
        if (chevron) {
            final Stroke oldStroke = g.getStroke();
            g.setStroke(new BasicStroke(UIScale.scale(arrowThickness)));
            drawShapePure(g, arrowShape);
            g.setStroke(oldStroke);
        }
        else {
            g.fill(arrowShape);
        }
        g.translate(-ax, -ay);
    }
    
    public static Shape createArrowShape(final int direction, final boolean chevron, final float w, final float h) {
        switch (direction) {
            case 1: {
                return createPath(!chevron, 0.0, h, w / 2.0f, 0.0, w, h);
            }
            case 5: {
                return createPath(!chevron, 0.0, 0.0, w / 2.0f, h, w, 0.0);
            }
            case 7: {
                return createPath(!chevron, w, 0.0, 0.0, h / 2.0f, w, h);
            }
            case 3: {
                return createPath(!chevron, 0.0, 0.0, w, h / 2.0f, 0.0, h);
            }
            default: {
                return new Path2D.Float();
            }
        }
    }
    
    public static Path2D createPath(final double... points) {
        return createPath(true, points);
    }
    
    public static Path2D createPath(final boolean close, final double... points) {
        final Path2D path = new Path2D.Float(1, points.length / 2 + (close ? 1 : 0));
        path.moveTo(points[0], points[1]);
        int i = 2;
        while (i < points.length) {
            final double p = points[i];
            if (p == -1.000000000001E12) {
                path.moveTo(points[i + 1], points[i + 2]);
                i += 3;
            }
            else if (p == -1.000000000002E12) {
                path.quadTo(points[i + 1], points[i + 2], points[i + 3], points[i + 4]);
                i += 5;
            }
            else if (p == -1.000000000003E12) {
                path.curveTo(points[i + 1], points[i + 2], points[i + 3], points[i + 4], points[i + 5], points[i + 6]);
                i += 7;
            }
            else if (p == -1.000000000004E12) {
                final double x = points[i + 1];
                final double y = points[i + 2];
                final double arc = points[i + 3];
                int ip2 = i + 4;
                if (points[ip2] == -1.000000000002E12 || points[ip2] == -1.000000000004E12) {
                    ++ip2;
                }
                final Point2D p2 = path.getCurrentPoint();
                final double x2 = p2.getX();
                final double y2 = p2.getY();
                final double x3 = points[ip2];
                final double y3 = points[ip2 + 1];
                final double d1 = distance(x, y, x2, y2);
                final double d2 = distance(x, y, x3, y3);
                final double t1 = 1.0 - 1.0 / d1 * arc;
                final double t2 = 1.0 / d2 * arc;
                path.lineTo(lerp(x2, x, t1), lerp(y2, y, t1));
                path.quadTo(x, y, lerp(x, x3, t2), lerp(y, y3, t2));
                i += 4;
            }
            else if (p == -1.000000000005E12) {
                path.closePath();
                ++i;
            }
            else {
                path.lineTo(p, points[i + 1]);
                i += 2;
            }
        }
        if (close) {
            path.closePath();
        }
        return path;
    }
    
    private static double lerp(final double v1, final double v2, final double t) {
        return v1 * (1.0 - t) + v2 * t;
    }
    
    private static double distance(final double x1, final double y1, final double x2, final double y2) {
        final double dx = x2 - x1;
        final double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public static void drawShapePure(final Graphics2D g, final Shape shape) {
        final Object oldStrokeControl = g.getRenderingHint(RenderingHints.KEY_STROKE_CONTROL);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.translate(0.5, 0.5);
        g.draw(shape);
        g.translate(-0.5, -0.5);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, oldStrokeControl);
    }
    
    public static void drawString(final JComponent c, final Graphics g, final String text, final int x, final int y) {
        HiDPIUtils.drawStringWithYCorrection(c, (Graphics2D)g, text, x, y);
    }
    
    public static void drawStringUnderlineCharAt(final JComponent c, Graphics g, final String text, final int underlinedIndex, final int x, final int y) {
        if (underlinedIndex >= 0 && UIScale.getUserScaleFactor() > 1.0f) {
            g = new Graphics2DProxy((Graphics2D)g) {
                @Override
                public void fillRect(final int x, int y, final int width, int height) {
                    if (height == 1) {
                        height = Math.round(UIScale.scale(0.9f));
                        y += height - 1;
                    }
                    super.fillRect(x, y, width, height);
                }
            };
        }
        HiDPIUtils.drawStringUnderlineCharAtWithYCorrection(c, (Graphics2D)g, text, underlinedIndex, x, y);
    }
    
    public static boolean hasOpaqueBeenExplicitlySet(final JComponent c) {
        final boolean oldOpaque = c.isOpaque();
        LookAndFeel.installProperty(c, "opaque", !oldOpaque);
        final boolean explicitlySet = c.isOpaque() == oldOpaque;
        LookAndFeel.installProperty(c, "opaque", oldOpaque);
        return explicitlySet;
    }
    
    public static boolean isUseSharedUIs() {
        return FlatUIUtils.useSharedUIs;
    }
    
    public static boolean setUseSharedUIs(final boolean useSharedUIs) {
        final boolean old = FlatUIUtils.useSharedUIs;
        FlatUIUtils.useSharedUIs = useSharedUIs;
        return old;
    }
    
    public static ComponentUI createSharedUI(final Object key, final Supplier<ComponentUI> newInstanceSupplier) {
        if (!FlatUIUtils.useSharedUIs) {
            return newInstanceSupplier.get();
        }
        return FlatUIUtils.sharedUIinstances.computeIfAbsent(UIManager.getLookAndFeel(), k -> new IdentityHashMap()).computeIfAbsent(key, k -> newInstanceSupplier.get());
    }
    
    public static boolean canUseSharedUI(final JComponent c) {
        return !FlatStylingSupport.hasStyleProperty(c);
    }
    
    static {
        FlatUIUtils.useSharedUIs = true;
        sharedUIinstances = new WeakHashMap<LookAndFeel, IdentityHashMap<Object, ComponentUI>>();
    }
    
    public static class RepaintFocusListener implements FocusListener
    {
        private final Component repaintComponent;
        private final Predicate<Component> repaintCondition;
        
        public RepaintFocusListener(final Component repaintComponent, final Predicate<Component> repaintCondition) {
            this.repaintComponent = repaintComponent;
            this.repaintCondition = repaintCondition;
        }
        
        @Override
        public void focusGained(final FocusEvent e) {
            if (this.repaintCondition == null || this.repaintCondition.test(this.repaintComponent)) {
                this.repaintComponent.repaint();
            }
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            if (this.repaintCondition == null || this.repaintCondition.test(this.repaintComponent)) {
                this.repaintComponent.repaint();
            }
        }
    }
    
    private static class NonUIResourceBorder implements Border
    {
        private final Border delegate;
        
        NonUIResourceBorder(final Border delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            this.delegate.paintBorder(c, g, x, y, width, height);
        }
        
        @Override
        public Insets getBorderInsets(final Component c) {
            return this.delegate.getBorderInsets(c);
        }
        
        @Override
        public boolean isBorderOpaque() {
            return this.delegate.isBorderOpaque();
        }
    }
}
