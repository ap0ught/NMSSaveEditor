// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.event.ListSelectionEvent;
import java.awt.Point;
import java.awt.Container;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.DefaultListCellRenderer;
import java.awt.Graphics2D;
import com.formdev.flatlaf.util.Graphics2DProxy;
import javax.swing.ListSelectionModel;
import javax.swing.ListModel;
import javax.swing.ListCellRenderer;
import java.awt.Graphics;
import java.awt.Component;
import com.formdev.flatlaf.util.LoggingFacade;
import java.awt.Rectangle;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import java.beans.PropertyChangeListener;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicListUI;

public class FlatListUI extends BasicListUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected Color selectionBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionForeground;
    @FlatStylingSupport.Styleable
    protected Color selectionInactiveBackground;
    @FlatStylingSupport.Styleable
    protected Color selectionInactiveForeground;
    @FlatStylingSupport.Styleable
    protected Insets selectionInsets;
    @FlatStylingSupport.Styleable
    protected int selectionArc;
    @FlatStylingSupport.Styleable
    protected Insets cellMargins;
    @FlatStylingSupport.Styleable
    protected Color cellFocusColor;
    @FlatStylingSupport.Styleable
    protected Boolean showCellFocusIndicator;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatListUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        if (FlatUIUtils.needsLightAWTPeer(c)) {
            FlatUIUtils.runWithLightAWTPeerUIDefaults(() -> this.installUIImpl(c));
        }
        else {
            this.installUIImpl(c);
        }
    }
    
    private void installUIImpl(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.selectionBackground = UIManager.getColor("List.selectionBackground");
        this.selectionForeground = UIManager.getColor("List.selectionForeground");
        this.selectionInactiveBackground = UIManager.getColor("List.selectionInactiveBackground");
        this.selectionInactiveForeground = UIManager.getColor("List.selectionInactiveForeground");
        this.selectionInsets = UIManager.getInsets("List.selectionInsets");
        this.selectionArc = UIManager.getInt("List.selectionArc");
        this.toggleSelectionColors();
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.selectionBackground = null;
        this.selectionForeground = null;
        this.selectionInactiveBackground = null;
        this.selectionInactiveForeground = null;
        this.oldStyleValues = null;
    }
    
    @Override
    protected FocusListener createFocusListener() {
        return new FocusHandler() {
            @Override
            public void focusGained(final FocusEvent e) {
                super.focusGained(e);
                FlatListUI.this.toggleSelectionColors();
            }
            
            @Override
            public void focusLost(final FocusEvent e) {
                super.focusLost(e);
                EventQueue.invokeLater(() -> FlatListUI.this.toggleSelectionColors());
            }
        };
    }
    
    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   javax/swing/plaf/basic/BasicListUI.createPropertyChangeListener:()Ljava/beans/PropertyChangeListener;
        //     4: astore_1        /* superListener */
        //     5: aload_0         /* this */
        //     6: aload_1         /* superListener */
        //     7: invokedynamic   BootstrapMethod #1, propertyChange:(Lcom/formdev/flatlaf/ui/FlatListUI;Ljava/beans/PropertyChangeListener;)Ljava/beans/PropertyChangeListener;
        //    12: areturn        
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
    protected ListSelectionListener createListSelectionListener() {
        final ListSelectionListener superListener2 = super.createListSelectionListener();
        return e -> {
            superListener.valueChanged(e);
            if (this.useUnitedRoundedSelection(true, true) && !this.list.isSelectionEmpty() && this.list.getMaxSelectionIndex() - this.list.getMinSelectionIndex() >= 1) {
                final int size = this.list.getModel().getSize();
                final int firstIndex = Math.min(Math.max(e.getFirstIndex(), 0), size - 1);
                final int lastIndex = Math.min(Math.max(e.getLastIndex(), 0), size - 1);
                final Rectangle r = this.getCellBounds(this.list, firstIndex, lastIndex);
                if (r != null) {
                    final int arc = (int)Math.ceil(UIScale.scale(this.selectionArc / 2.0f));
                    this.list.repaint(r.x - arc, r.y - arc, r.width + arc * 2, r.height + arc * 2);
                }
            }
        };
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.list, "List"));
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
            final Color selBg = this.list.getSelectionBackground();
            if (selBg == oldSelectionBackground) {
                this.list.setSelectionBackground(this.selectionBackground);
            }
            else if (selBg == oldSelectionInactiveBackground) {
                this.list.setSelectionBackground(this.selectionInactiveBackground);
            }
        }
        if (this.selectionForeground != oldSelectionForeground) {
            final Color selFg = this.list.getSelectionForeground();
            if (selFg == oldSelectionForeground) {
                this.list.setSelectionForeground(this.selectionForeground);
            }
            else if (selFg == oldSelectionInactiveForeground) {
                this.list.setSelectionForeground(this.selectionInactiveForeground);
            }
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.list, key, value);
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
        if (this.list == null) {
            return;
        }
        if (FlatUIUtils.isPermanentFocusOwner(this.list)) {
            if (this.list.getSelectionBackground() == this.selectionInactiveBackground) {
                this.list.setSelectionBackground(this.selectionBackground);
            }
            if (this.list.getSelectionForeground() == this.selectionInactiveForeground) {
                this.list.setSelectionForeground(this.selectionForeground);
            }
        }
        else {
            if (this.list.getSelectionBackground() == this.selectionBackground) {
                this.list.setSelectionBackground(this.selectionInactiveBackground);
            }
            if (this.list.getSelectionForeground() == this.selectionForeground) {
                this.list.setSelectionForeground(this.selectionInactiveForeground);
            }
        }
    }
    
    @Override
    protected void paintCell(Graphics g, final int row, final Rectangle rowBounds, final ListCellRenderer cellRenderer, final ListModel dataModel, final ListSelectionModel selModel, final int leadIndex) {
        final boolean isSelected = selModel.isSelectedIndex(row);
        final Component rendererComponent = cellRenderer.getListCellRendererComponent(this.list, dataModel.getElementAt(row), row, isSelected, FlatUIUtils.isPermanentFocusOwner(this.list) && row == leadIndex);
        final boolean isFileList = Boolean.TRUE.equals(this.list.getClientProperty("List.isFileList"));
        int cw;
        int cx;
        if (isFileList) {
            cw = Math.min(rowBounds.width, rendererComponent.getPreferredSize().width + 4);
            cx = (this.list.getComponentOrientation().isLeftToRight() ? rowBounds.x : (rowBounds.x + (rowBounds.width - cw)));
        }
        else {
            cx = rowBounds.x;
            cw = rowBounds.width;
        }
        if (isSelected && !isFileList && (rendererComponent instanceof DefaultListCellRenderer || rendererComponent instanceof BasicComboBoxRenderer) && (this.selectionArc > 0 || (this.selectionInsets != null && (this.selectionInsets.top != 0 || this.selectionInsets.left != 0 || this.selectionInsets.bottom != 0 || this.selectionInsets.right != 0)))) {
            class RoundedSelectionGraphics extends Graphics2DProxy
            {
                private boolean inPaintSelection;
                final /* synthetic */ int val$row;
                
                RoundedSelectionGraphics(final Graphics val$row) {
                    this.val$row = (int)val$row;
                    super((Graphics2D)delegate);
                }
                
                @Override
                public Graphics create() {
                    return new RoundedSelectionGraphics(super.create(), rowBounds, rendererComponent, this.val$row);
                }
                
                @Override
                public Graphics create(final int x, final int y, final int width, final int height) {
                    return new RoundedSelectionGraphics(super.create(x, y, width, height), rowBounds, rendererComponent, this.val$row);
                }
                
                @Override
                public void fillRect(final int x, final int y, final int width, final int height) {
                    if (!this.inPaintSelection && x == 0 && y == 0 && width == rowBounds.width && height == rowBounds.height && this.getColor() == rendererComponent.getBackground()) {
                        this.inPaintSelection = true;
                        FlatListUI.this.paintCellSelection(this, this.val$row, x, y, width, height);
                        this.inPaintSelection = false;
                    }
                    else {
                        super.fillRect(x, y, width, height);
                    }
                }
            }
            g = new RoundedSelectionGraphics(g);
        }
        this.rendererPane.paintComponent(g, rendererComponent, this.list, cx, rowBounds.y, cw, rowBounds.height, true);
    }
    
    protected void paintCellSelection(final Graphics g, final int row, final int x, final int y, final int width, final int height) {
        float arcBottomRight;
        float arcBottomLeft;
        float arcTopLeft;
        float arcTopRight = arcTopLeft = (arcBottomLeft = (arcBottomRight = UIScale.scale(this.selectionArc / 2.0f)));
        if (this.list.getLayoutOrientation() == 0) {
            if (this.useUnitedRoundedSelection(true, false)) {
                if (row > 0 && this.list.isSelectedIndex(row - 1)) {
                    arcTopRight = (arcTopLeft = 0.0f);
                }
                if (row < this.list.getModel().getSize() - 1 && this.list.isSelectedIndex(row + 1)) {
                    arcBottomRight = (arcBottomLeft = 0.0f);
                }
            }
        }
        else {
            Rectangle r = null;
            if (this.useUnitedRoundedSelection(true, false)) {
                r = this.getCellBounds(this.list, row, row);
                final int topIndex = this.locationToIndex(this.list, new Point(r.x, r.y - 1));
                final int bottomIndex = this.locationToIndex(this.list, new Point(r.x, r.y + r.height));
                if (topIndex >= 0 && topIndex != row && this.list.isSelectedIndex(topIndex)) {
                    arcTopRight = (arcTopLeft = 0.0f);
                }
                if (bottomIndex >= 0 && bottomIndex != row && this.list.isSelectedIndex(bottomIndex)) {
                    arcBottomRight = (arcBottomLeft = 0.0f);
                }
            }
            if (this.useUnitedRoundedSelection(false, true)) {
                if (r == null) {
                    r = this.getCellBounds(this.list, row, row);
                }
                int leftIndex = this.locationToIndex(this.list, new Point(r.x - 1, r.y));
                int rightIndex = this.locationToIndex(this.list, new Point(r.x + r.width, r.y));
                final boolean ltr = this.list.getComponentOrientation().isLeftToRight();
                if (!ltr && leftIndex >= 0 && leftIndex != row && leftIndex == this.locationToIndex(this.list, new Point(r.x - 1, r.y - 1))) {
                    leftIndex = -1;
                }
                if (ltr && rightIndex >= 0 && rightIndex != row && rightIndex == this.locationToIndex(this.list, new Point(r.x + r.width, r.y - 1))) {
                    rightIndex = -1;
                }
                if (leftIndex >= 0 && leftIndex != row && this.list.isSelectedIndex(leftIndex)) {
                    arcBottomLeft = (arcTopLeft = 0.0f);
                }
                if (rightIndex >= 0 && rightIndex != row && this.list.isSelectedIndex(rightIndex)) {
                    arcBottomRight = (arcTopRight = 0.0f);
                }
            }
        }
        FlatUIUtils.paintSelection((Graphics2D)g, x, y, width, height, UIScale.scale(this.selectionInsets), arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight, 0);
    }
    
    private boolean useUnitedRoundedSelection(final boolean vertical, final boolean horizontal) {
        return this.selectionArc > 0 && (this.selectionInsets == null || (vertical && this.selectionInsets.top == 0 && this.selectionInsets.bottom == 0) || (horizontal && this.selectionInsets.left == 0 && this.selectionInsets.right == 0));
    }
    
    public static void paintCellSelection(final JList<?> list, final Graphics g, final int row, final int x, final int y, final int width, final int height) {
        if (!(list.getUI() instanceof FlatListUI)) {
            return;
        }
        final FlatListUI ui = (FlatListUI)list.getUI();
        ui.paintCellSelection(g, row, x, y, width, height);
    }
}
