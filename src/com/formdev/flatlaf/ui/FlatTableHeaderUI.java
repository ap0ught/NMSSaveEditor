// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Graphics;
import javax.swing.event.MouseInputListener;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicTableHeaderUI;

public class FlatTableHeaderUI extends BasicTableHeaderUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected Color hoverBackground;
    @FlatStylingSupport.Styleable
    protected Color hoverForeground;
    @FlatStylingSupport.Styleable
    protected Color pressedBackground;
    @FlatStylingSupport.Styleable
    protected Color pressedForeground;
    @FlatStylingSupport.Styleable
    protected Color bottomSeparatorColor;
    @FlatStylingSupport.Styleable
    protected int height;
    @FlatStylingSupport.Styleable(type = String.class)
    protected int sortIconPosition;
    @FlatStylingSupport.Styleable
    protected Insets cellMargins;
    @FlatStylingSupport.Styleable
    protected Color separatorColor;
    @FlatStylingSupport.Styleable
    protected Boolean showTrailingVerticalLine;
    @FlatStylingSupport.Styleable
    public String arrowType;
    @FlatStylingSupport.Styleable
    public Color sortIconColor;
    private PropertyChangeListener propertyChangeListener;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatTableHeaderUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.hoverBackground = UIManager.getColor("TableHeader.hoverBackground");
        this.hoverForeground = UIManager.getColor("TableHeader.hoverForeground");
        this.pressedBackground = UIManager.getColor("TableHeader.pressedBackground");
        this.pressedForeground = UIManager.getColor("TableHeader.pressedForeground");
        this.bottomSeparatorColor = UIManager.getColor("TableHeader.bottomSeparatorColor");
        this.height = UIManager.getInt("TableHeader.height");
        this.sortIconPosition = parseSortIconPosition(UIManager.getString("TableHeader.sortIconPosition"));
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.hoverBackground = null;
        this.hoverForeground = null;
        this.pressedBackground = null;
        this.pressedForeground = null;
        this.bottomSeparatorColor = null;
        this.oldStyleValues = null;
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.propertyChangeListener = FlatStylingSupport.createPropertyChangeListener(this.header, this::installStyle, null);
        this.header.addPropertyChangeListener(this.propertyChangeListener);
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.header.removePropertyChangeListener(this.propertyChangeListener);
        this.propertyChangeListener = null;
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.header, "TableHeader"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, Object value) {
        if (key.equals("sortIconPosition") && value instanceof String) {
            value = parseSortIconPosition((String)value);
        }
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.header, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        if (!key.equals("sortIconPosition")) {
            return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
        }
        switch (this.sortIconPosition) {
            default: {
                return "right";
            }
            case 2: {
                return "left";
            }
            case 1: {
                return "top";
            }
            case 3: {
                return "bottom";
            }
        }
    }
    
    private static int parseSortIconPosition(String str) {
        if (str == null) {
            str = "";
        }
        final String s = str;
        switch (s) {
            default: {
                return 4;
            }
            case "left": {
                return 2;
            }
            case "top": {
                return 1;
            }
            case "bottom": {
                return 3;
            }
        }
    }
    
    @Override
    protected MouseInputListener createMouseInputListener() {
        return new FlatMouseInputHandler();
    }
    
    public int getRolloverColumn() {
        return super.getRolloverColumn();
    }
    
    @Override
    protected void rolloverColumnUpdated(final int oldColumn, final int newColumn) {
        this.header.repaint(this.header.getHeaderRect(oldColumn));
        this.header.repaint(this.header.getHeaderRect(newColumn));
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        fixDraggedAndResizingColumns(this.header);
        final TableColumnModel columnModel = this.header.getColumnModel();
        if (columnModel.getColumnCount() <= 0) {
            return;
        }
        final int columnCount = columnModel.getColumnCount();
        int totalWidth = 0;
        for (int i = 0; i < columnCount; ++i) {
            totalWidth += columnModel.getColumn(i).getWidth();
        }
        if (totalWidth < this.header.getWidth()) {
            final TableCellRenderer defaultRenderer = this.header.getDefaultRenderer();
            boolean paintBottomSeparator = this.isSystemDefaultRenderer(defaultRenderer);
            if (!paintBottomSeparator && this.header.getTable() != null) {
                final Component rendererComponent = defaultRenderer.getTableCellRendererComponent(this.header.getTable(), "", false, false, -1, 0);
                paintBottomSeparator = this.isSystemDefaultRenderer(rendererComponent);
            }
            if (paintBottomSeparator) {
                final int w = c.getWidth() - totalWidth;
                final int x = this.header.getComponentOrientation().isLeftToRight() ? (c.getWidth() - w) : 0;
                this.paintBottomSeparator(g, c, x, w);
            }
        }
        final FlatTableCellHeaderRenderer tempRenderer = new FlatTableCellHeaderRenderer(this.header.getDefaultRenderer());
        this.header.setDefaultRenderer(tempRenderer);
        super.paint(g, c);
        tempRenderer.reset();
        this.header.setDefaultRenderer(tempRenderer.delegate);
    }
    
    private boolean isSystemDefaultRenderer(final Object headerRenderer) {
        final String rendererClassName = headerRenderer.getClass().getName();
        return rendererClassName.equals("sun.swing.table.DefaultTableCellHeaderRenderer") || rendererClassName.equals("sun.swing.FilePane$AlignableTableHeaderRenderer");
    }
    
    protected void paintBottomSeparator(final Graphics g, final JComponent c, final int x, final int w) {
        final float lineWidth = UIScale.scale(1.0f);
        final Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(this.bottomSeparatorColor);
            g2.fill(new Rectangle2D.Float((float)x, c.getHeight() - lineWidth, (float)w, lineWidth));
        }
        finally {
            g2.dispose();
        }
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        final Dimension size = super.getPreferredSize(c);
        if (size.height > 0) {
            size.height = Math.max(size.height, UIScale.scale(this.height));
        }
        return size;
    }
    
    static void fixDraggedAndResizingColumns(final JTableHeader header) {
        if (header == null) {
            return;
        }
        final TableColumn draggedColumn = header.getDraggedColumn();
        if (draggedColumn != null && !isValidColumn(header.getColumnModel(), draggedColumn)) {
            header.setDraggedColumn(null);
        }
        final TableColumn resizingColumn = header.getResizingColumn();
        if (resizingColumn != null && !isValidColumn(header.getColumnModel(), resizingColumn)) {
            header.setResizingColumn(null);
        }
    }
    
    private static boolean isValidColumn(final TableColumnModel cm, final TableColumn column) {
        for (int count = cm.getColumnCount(), i = 0; i < count; ++i) {
            if (cm.getColumn(i) == column) {
                return true;
            }
        }
        return false;
    }
    
    private class FlatTableCellHeaderRenderer implements TableCellRenderer, Border, UIResource
    {
        private final TableCellRenderer delegate;
        private JLabel l;
        private Color oldBackground;
        private Color oldForeground;
        private Boolean oldOpaque;
        private int oldHorizontalTextPosition;
        private Border origBorder;
        private Icon sortIcon;
        
        FlatTableCellHeaderRenderer(final TableCellRenderer delegate) {
            this.oldHorizontalTextPosition = -1;
            this.delegate = delegate;
        }
        
        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
            final Component c = this.delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!(c instanceof JLabel)) {
                return c;
            }
            this.l = (JLabel)c;
            final TableColumn draggedColumn = FlatTableHeaderUI.this.header.getDraggedColumn();
            Color background = null;
            Color foreground = null;
            if (draggedColumn != null && FlatTableHeaderUI.this.header.getTable().convertColumnIndexToView(draggedColumn.getModelIndex()) == column) {
                background = FlatTableHeaderUI.this.pressedBackground;
                foreground = FlatTableHeaderUI.this.pressedForeground;
            }
            else if (FlatTableHeaderUI.this.getRolloverColumn() == column) {
                background = FlatTableHeaderUI.this.hoverBackground;
                foreground = FlatTableHeaderUI.this.hoverForeground;
            }
            if (background != null) {
                if (this.oldBackground == null) {
                    this.oldBackground = this.l.getBackground();
                }
                if (this.oldOpaque == null) {
                    this.oldOpaque = this.l.isOpaque();
                }
                this.l.setBackground(FlatUIUtils.deriveColor(background, FlatTableHeaderUI.this.header.getBackground()));
                this.l.setOpaque(true);
            }
            if (foreground != null) {
                if (this.oldForeground == null) {
                    this.oldForeground = this.l.getForeground();
                }
                this.l.setForeground(FlatUIUtils.deriveColor(foreground, FlatTableHeaderUI.this.header.getForeground()));
            }
            if (FlatTableHeaderUI.this.sortIconPosition == 2) {
                if (this.oldHorizontalTextPosition < 0) {
                    this.oldHorizontalTextPosition = this.l.getHorizontalTextPosition();
                }
                this.l.setHorizontalTextPosition(4);
            }
            else if (FlatTableHeaderUI.this.sortIconPosition == 1 || FlatTableHeaderUI.this.sortIconPosition == 3) {
                this.sortIcon = this.l.getIcon();
                this.origBorder = this.l.getBorder();
                this.l.setIcon(null);
                this.l.setBorder(this);
            }
            return this.l;
        }
        
        void reset() {
            if (this.l == null) {
                return;
            }
            if (this.oldBackground != null) {
                this.l.setBackground(this.oldBackground);
            }
            if (this.oldForeground != null) {
                this.l.setForeground(this.oldForeground);
            }
            if (this.oldOpaque != null) {
                this.l.setOpaque(this.oldOpaque);
            }
            if (this.oldHorizontalTextPosition >= 0) {
                this.l.setHorizontalTextPosition(this.oldHorizontalTextPosition);
            }
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            if (this.origBorder != null) {
                this.origBorder.paintBorder(c, g, x, y, width, height);
            }
            if (this.sortIcon != null) {
                final int xi = x + (width - this.sortIcon.getIconWidth()) / 2;
                final int yi = (FlatTableHeaderUI.this.sortIconPosition == 1) ? (y + UIScale.scale(1)) : (y + height - this.sortIcon.getIconHeight() - 1 - (int)(1.0f * UIScale.getUserScaleFactor()));
                this.sortIcon.paintIcon(c, g, xi, yi);
            }
        }
        
        @Override
        public Insets getBorderInsets(final Component c) {
            return (this.origBorder != null) ? this.origBorder.getBorderInsets(c) : new Insets(0, 0, 0, 0);
        }
        
        @Override
        public boolean isBorderOpaque() {
            return this.origBorder != null && this.origBorder.isBorderOpaque();
        }
    }
    
    protected class FlatMouseInputHandler extends MouseInputHandler
    {
        Cursor oldCursor;
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            if (this.oldCursor != null) {
                FlatTableHeaderUI.this.header.setCursor(this.oldCursor);
                this.oldCursor = null;
            }
            super.mouseMoved(e);
            final JTable table;
            final int column;
            if (FlatTableHeaderUI.this.header.isEnabled() && (table = FlatTableHeaderUI.this.header.getTable()) != null && table.getAutoResizeMode() != 0 && FlatTableHeaderUI.this.header.getCursor() == Cursor.getPredefinedCursor(11) && (column = FlatTableHeaderUI.this.header.columnAtPoint(e.getPoint())) >= 0 && column == FlatTableHeaderUI.this.header.getColumnModel().getColumnCount() - 1) {
                final Rectangle r = FlatTableHeaderUI.this.header.getHeaderRect(column);
                r.grow(-3, 0);
                if (!r.contains(e.getX(), e.getY())) {
                    boolean isResizeLastColumn = e.getX() >= r.x + r.width / 2;
                    if (!FlatTableHeaderUI.this.header.getComponentOrientation().isLeftToRight()) {
                        isResizeLastColumn = !isResizeLastColumn;
                    }
                    if (isResizeLastColumn) {
                        this.oldCursor = FlatTableHeaderUI.this.header.getCursor();
                        FlatTableHeaderUI.this.header.setCursor(Cursor.getDefaultCursor());
                    }
                }
            }
        }
    }
}
