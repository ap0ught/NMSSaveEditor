// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.JViewport;
import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.Graphics2DProxy;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import com.formdev.flatlaf.util.LoggingFacade;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.LookAndFeel;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.plaf.basic.BasicTableUI;

public class FlatTableUI extends BasicTableUI implements FlatStylingSupport.StyleableUI, FlatViewportUI.ViewportPainter
{
    protected boolean showHorizontalLines;
    protected boolean showVerticalLines;
    @FlatStylingSupport.Styleable
    protected boolean showTrailingVerticalLine;
    protected Dimension intercellSpacing;
    @FlatStylingSupport.Styleable
    protected Color selectionBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionForeground;
    @FlatStylingSupport.Styleable
    protected Color selectionInactiveBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionInactiveForeground;
    @FlatStylingSupport.Styleable
    protected Insets cellMargins;
    @FlatStylingSupport.Styleable
    protected Color cellFocusColor;
    @FlatStylingSupport.Styleable
    protected Boolean showCellFocusIndicator;
    private boolean oldShowHorizontalLines;
    private boolean oldShowVerticalLines;
    private Dimension oldIntercellSpacing;
    private PropertyChangeListener propertyChangeListener;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatTableUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.showHorizontalLines = UIManager.getBoolean("Table.showHorizontalLines");
        this.showVerticalLines = UIManager.getBoolean("Table.showVerticalLines");
        this.showTrailingVerticalLine = UIManager.getBoolean("Table.showTrailingVerticalLine");
        this.intercellSpacing = UIManager.getDimension("Table.intercellSpacing");
        this.selectionBackground = UIManager.getColor("Table.selectionBackground");
        this.selectionForeground = UIManager.getColor("Table.selectionForeground");
        this.selectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");
        this.selectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
        this.toggleSelectionColors();
        final int rowHeight = FlatUIUtils.getUIInt("Table.rowHeight", 16);
        if (rowHeight > 0) {
            LookAndFeel.installProperty(this.table, "rowHeight", UIScale.scale(rowHeight));
        }
        if (!this.showHorizontalLines) {
            this.oldShowHorizontalLines = this.table.getShowHorizontalLines();
            this.table.setShowHorizontalLines(false);
        }
        if (!this.showVerticalLines) {
            this.oldShowVerticalLines = this.table.getShowVerticalLines();
            this.table.setShowVerticalLines(false);
        }
        if (this.intercellSpacing != null) {
            this.oldIntercellSpacing = this.table.getIntercellSpacing();
            this.table.setIntercellSpacing(this.intercellSpacing);
        }
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.selectionBackground = null;
        this.selectionForeground = null;
        this.selectionInactiveBackground = null;
        this.selectionInactiveForeground = null;
        this.oldStyleValues = null;
        if (!this.showHorizontalLines && this.oldShowHorizontalLines && !this.table.getShowHorizontalLines()) {
            this.table.setShowHorizontalLines(true);
        }
        if (!this.showVerticalLines && this.oldShowVerticalLines && !this.table.getShowVerticalLines()) {
            this.table.setShowVerticalLines(true);
        }
        if (this.intercellSpacing != null && this.table.getIntercellSpacing().equals(this.intercellSpacing)) {
            this.table.setIntercellSpacing(this.oldIntercellSpacing);
        }
    }
    
    @Override
    protected void installListeners() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   javax/swing/plaf/basic/BasicTableUI.installListeners:()V
        //     4: aload_0         /* this */
        //     5: aload_0         /* this */
        //     6: invokedynamic   BootstrapMethod #0, propertyChange:(Lcom/formdev/flatlaf/ui/FlatTableUI;)Ljava/beans/PropertyChangeListener;
        //    11: putfield        com/formdev/flatlaf/ui/FlatTableUI.propertyChangeListener:Ljava/beans/PropertyChangeListener;
        //    14: aload_0         /* this */
        //    15: getfield        com/formdev/flatlaf/ui/FlatTableUI.table:Ljavax/swing/JTable;
        //    18: aload_0         /* this */
        //    19: getfield        com/formdev/flatlaf/ui/FlatTableUI.propertyChangeListener:Ljava/beans/PropertyChangeListener;
        //    22: invokevirtual   javax/swing/JTable.addPropertyChangeListener:(Ljava/beans/PropertyChangeListener;)V
        //    25: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot invoke "com.strobel.assembler.metadata.TypeReference.getSimpleType()" because the return value of "com.strobel.decompiler.ast.Variable.getType()" is null
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:252)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:185)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.nameVariables(AstMethodBodyBuilder.java:1482)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.populateVariables(AstMethodBodyBuilder.java:1411)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:334)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:255)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:130)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        this.table.removePropertyChangeListener(this.propertyChangeListener);
        this.propertyChangeListener = null;
    }
    
    @Override
    protected FocusListener createFocusListener() {
        return new FocusHandler() {
            @Override
            public void focusGained(final FocusEvent e) {
                super.focusGained(e);
                FlatTableUI.this.toggleSelectionColors();
            }
            
            @Override
            public void focusLost(final FocusEvent e) {
                super.focusLost(e);
                EventQueue.invokeLater(() -> FlatTableUI.this.toggleSelectionColors());
            }
        };
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.table, "Table"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        final Color oldSelectionBackground = this.selectionBackground;
        final Color oldSelectionForeground = this.selectionForeground;
        final Color oldSelectionInactiveBackground = this.selectionInactiveBackground;
        final Color oldSelectionInactiveForeground = this.selectionInactiveForeground;
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        if (this.selectionBackground != oldSelectionBackground) {
            final Color selBg = this.table.getSelectionBackground();
            if (selBg == oldSelectionBackground) {
                this.table.setSelectionBackground(this.selectionBackground);
            }
            else if (selBg == oldSelectionInactiveBackground) {
                this.table.setSelectionBackground(this.selectionInactiveBackground);
            }
        }
        if (this.selectionForeground != oldSelectionForeground) {
            final Color selFg = this.table.getSelectionForeground();
            if (selFg == oldSelectionForeground) {
                this.table.setSelectionForeground(this.selectionForeground);
            }
            else if (selFg == oldSelectionInactiveForeground) {
                this.table.setSelectionForeground(this.selectionInactiveForeground);
            }
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.table, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    private void toggleSelectionColors() {
        if (this.table == null) {
            return;
        }
        if (FlatUIUtils.isPermanentFocusOwner(this.table)) {
            if (this.table.getSelectionBackground() == this.selectionInactiveBackground) {
                this.table.setSelectionBackground(this.selectionBackground);
            }
            if (this.table.getSelectionForeground() == this.selectionInactiveForeground) {
                this.table.setSelectionForeground(this.selectionForeground);
            }
        }
        else {
            if (this.table.getSelectionBackground() == this.selectionBackground) {
                this.table.setSelectionBackground(this.selectionInactiveBackground);
            }
            if (this.table.getSelectionForeground() == this.selectionForeground) {
                this.table.setSelectionForeground(this.selectionInactiveForeground);
            }
        }
    }
    
    @Override
    public void paint(Graphics g, final JComponent c) {
        FlatTableHeaderUI.fixDraggedAndResizingColumns(this.table.getTableHeader());
        final boolean horizontalLines = this.table.getShowHorizontalLines();
        final boolean verticalLines = this.table.getShowVerticalLines();
        if (horizontalLines || verticalLines) {
            final boolean hideLastVerticalLine = this.hideLastVerticalLine();
            final int tableWidth = this.table.getWidth();
            final JTableHeader header = this.table.getTableHeader();
            final boolean isDragging = header != null && header.getDraggedColumn() != null;
            final double systemScaleFactor = UIScale.getSystemScaleFactor((Graphics2D)g);
            final double lineThickness = 1.0 / systemScaleFactor * (int)systemScaleFactor;
            g = new Graphics2DProxy((Graphics2D)g) {
                @Override
                public void drawLine(final int x1, final int y1, final int x2, final int y2) {
                    if (hideLastVerticalLine && verticalLines && x1 == x2 && y1 == 0 && x1 == tableWidth - 1 && this.wasInvokedFromPaintGrid()) {
                        return;
                    }
                    if (isDragging && SystemInfo.isJava_9_orLater && ((horizontalLines && y1 == y2) || (verticalLines && x1 == x2)) && this.wasInvokedFromMethod("paintDraggedArea")) {
                        if (y1 == y2) {
                            super.fill(new Rectangle2D.Double(x1, y1, x2 - x1 + 1, lineThickness));
                        }
                        else if (x1 == x2) {
                            super.fill(new Rectangle2D.Double(x1, y1, lineThickness, y2 - y1 + 1));
                        }
                        return;
                    }
                    super.drawLine(x1, y1, x2, y2);
                }
                
                @Override
                public void fillRect(final int x, final int y, final int width, final int height) {
                    if (hideLastVerticalLine && verticalLines && width == 1 && y == 0 && x == tableWidth - 1 && this.wasInvokedFromPaintGrid()) {
                        return;
                    }
                    if (lineThickness != 1.0) {
                        if (horizontalLines && height == 1 && this.wasInvokedFromPaintGrid()) {
                            super.fill(new Rectangle2D.Double(x, y, width, lineThickness));
                            return;
                        }
                        if (verticalLines && width == 1 && y == 0 && this.wasInvokedFromPaintGrid()) {
                            super.fill(new Rectangle2D.Double(x, y, lineThickness, height));
                            return;
                        }
                    }
                    super.fillRect(x, y, width, height);
                }
                
                private boolean wasInvokedFromPaintGrid() {
                    return this.wasInvokedFromMethod("paintGrid");
                }
                
                private boolean wasInvokedFromMethod(final String methodName) {
                    return StackUtils.wasInvokedFrom(BasicTableUI.class.getName(), methodName, 8);
                }
            };
        }
        super.paint(g, c);
    }
    
    protected boolean hideLastVerticalLine() {
        if (this.showTrailingVerticalLine) {
            return false;
        }
        final Container viewport = SwingUtilities.getUnwrappedParent(this.table);
        final Container viewportParent = (viewport != null) ? viewport.getParent() : null;
        if (!(viewportParent instanceof JScrollPane)) {
            return false;
        }
        if (this.table.getX() + this.table.getWidth() < viewport.getWidth()) {
            return false;
        }
        final JScrollPane scrollPane = (JScrollPane)viewportParent;
        final JViewport rowHeader = scrollPane.getRowHeader();
        return scrollPane.getComponentOrientation().isLeftToRight() ? (viewport != rowHeader) : (viewport == rowHeader || rowHeader == null);
    }
    
    @Override
    public void paintViewport(final Graphics g, final JComponent c, final JViewport viewport) {
        final int viewportWidth = viewport.getWidth();
        final int viewportHeight = viewport.getHeight();
        if (viewport.isOpaque()) {
            g.setColor(this.table.getBackground());
            g.fillRect(0, 0, viewportWidth, viewportHeight);
        }
        final boolean paintOutside = UIManager.getBoolean("Table.paintOutsideAlternateRows");
        final Color alternateColor;
        if (paintOutside && (alternateColor = UIManager.getColor("Table.alternateRowColor")) != null) {
            g.setColor(alternateColor);
            final int rowCount = this.table.getRowCount();
            final int tableHeight = this.table.getHeight();
            if (tableHeight < viewportHeight) {
                final int tableWidth = this.table.getWidth();
                for (int rowHeight = this.table.getRowHeight(), y = tableHeight, row = rowCount; y < viewportHeight; y += rowHeight, ++row) {
                    if (row % 2 != 0) {
                        g.fillRect(0, y, tableWidth, rowHeight);
                    }
                }
            }
        }
    }
}
