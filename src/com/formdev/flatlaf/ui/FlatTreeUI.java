// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import java.awt.Container;
import javax.swing.CellRendererPane;
import java.awt.Component;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Graphics;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JTree;
import java.beans.PropertyChangeListener;
import java.awt.Rectangle;
import javax.swing.tree.TreePath;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.UIManager;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import javax.swing.Icon;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicTreeUI;

public class FlatTreeUI extends BasicTreeUI implements FlatStylingSupport.StyleableUI
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
    protected Color selectionBorderColor;
    @FlatStylingSupport.Styleable
    protected Insets selectionInsets;
    @FlatStylingSupport.Styleable
    protected int selectionArc;
    @FlatStylingSupport.Styleable
    protected boolean wideSelection;
    @FlatStylingSupport.Styleable
    protected boolean showCellFocusIndicator;
    protected boolean showDefaultIcons;
    @FlatStylingSupport.Styleable(dot = true)
    public String iconArrowType;
    @FlatStylingSupport.Styleable(dot = true)
    public Color iconExpandedColor;
    @FlatStylingSupport.Styleable(dot = true)
    public Color iconCollapsedColor;
    @FlatStylingSupport.Styleable(dot = true)
    public Color iconLeafColor;
    @FlatStylingSupport.Styleable(dot = true)
    public Color iconClosedColor;
    @FlatStylingSupport.Styleable(dot = true)
    public Color iconOpenColor;
    @FlatStylingSupport.Styleable
    protected boolean paintSelection;
    private Icon defaultLeafIcon;
    private Icon defaultClosedIcon;
    private Icon defaultOpenIcon;
    private boolean paintLines;
    private Color defaultCellNonSelectionBackground;
    private Color defaultSelectionBackground;
    private Color defaultSelectionForeground;
    private Color defaultSelectionBorderColor;
    private Map<String, Object> oldStyleValues;
    
    public FlatTreeUI() {
        this.paintSelection = true;
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatTreeUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installStyle();
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.installBorder(this.tree, "Tree.border");
        this.selectionBackground = UIManager.getColor("Tree.selectionBackground");
        this.selectionForeground = UIManager.getColor("Tree.selectionForeground");
        this.selectionInactiveBackground = UIManager.getColor("Tree.selectionInactiveBackground");
        this.selectionInactiveForeground = UIManager.getColor("Tree.selectionInactiveForeground");
        this.selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
        this.selectionInsets = UIManager.getInsets("Tree.selectionInsets");
        this.selectionArc = UIManager.getInt("Tree.selectionArc");
        this.wideSelection = UIManager.getBoolean("Tree.wideSelection");
        this.showCellFocusIndicator = UIManager.getBoolean("Tree.showCellFocusIndicator");
        this.showDefaultIcons = UIManager.getBoolean("Tree.showDefaultIcons");
        this.defaultLeafIcon = UIManager.getIcon("Tree.leafIcon");
        this.defaultClosedIcon = UIManager.getIcon("Tree.closedIcon");
        this.defaultOpenIcon = UIManager.getIcon("Tree.openIcon");
        this.paintLines = UIManager.getBoolean("Tree.paintLines");
        this.defaultCellNonSelectionBackground = UIManager.getColor("Tree.textBackground");
        this.defaultSelectionBackground = this.selectionBackground;
        this.defaultSelectionForeground = this.selectionForeground;
        this.defaultSelectionBorderColor = this.selectionBorderColor;
        final int rowHeight = FlatUIUtils.getUIInt("Tree.rowHeight", 16);
        if (rowHeight > 0) {
            LookAndFeel.installProperty(this.tree, "rowHeight", UIScale.scale(rowHeight));
        }
        this.setLeftChildIndent(UIScale.scale(this.getLeftChildIndent()));
        this.setRightChildIndent(UIScale.scale(this.getRightChildIndent()));
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        LookAndFeel.uninstallBorder(this.tree);
        this.selectionBackground = null;
        this.selectionForeground = null;
        this.selectionInactiveBackground = null;
        this.selectionInactiveForeground = null;
        this.selectionBorderColor = null;
        this.defaultLeafIcon = null;
        this.defaultClosedIcon = null;
        this.defaultOpenIcon = null;
        this.defaultCellNonSelectionBackground = null;
        this.defaultSelectionBackground = null;
        this.defaultSelectionForeground = null;
        this.defaultSelectionBorderColor = null;
        this.oldStyleValues = null;
    }
    
    @Override
    protected void updateRenderer() {
        super.updateRenderer();
        if (!this.showDefaultIcons && this.currentCellRenderer instanceof DefaultTreeCellRenderer) {
            final DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)this.currentCellRenderer;
            if (renderer.getLeafIcon() == this.defaultLeafIcon && renderer.getClosedIcon() == this.defaultClosedIcon && renderer.getOpenIcon() == this.defaultOpenIcon) {
                renderer.setLeafIcon(null);
                renderer.setClosedIcon(null);
                renderer.setOpenIcon(null);
            }
        }
    }
    
    @Override
    protected MouseListener createMouseListener() {
        return new MouseHandler() {
            @Override
            public void mousePressed(final MouseEvent e) {
                super.mousePressed(this.handleWideMouseEvent(e));
            }
            
            @Override
            public void mouseReleased(final MouseEvent e) {
                super.mouseReleased(this.handleWideMouseEvent(e));
            }
            
            @Override
            public void mouseDragged(final MouseEvent e) {
                super.mouseDragged(this.handleWideMouseEvent(e));
            }
            
            private MouseEvent handleWideMouseEvent(final MouseEvent e) {
                if (!FlatTreeUI.this.isWideSelection() || !FlatTreeUI.this.tree.isEnabled() || !SwingUtilities.isLeftMouseButton(e) || e.isConsumed()) {
                    return e;
                }
                final int x = e.getX();
                final int y = e.getY();
                final TreePath path = FlatTreeUI.this.getClosestPathForLocation(FlatTreeUI.this.tree, x, y);
                if (path == null || BasicTreeUI.this.isLocationInExpandControl(path, x, y)) {
                    return e;
                }
                final Rectangle bounds = FlatTreeUI.this.getPathBounds(FlatTreeUI.this.tree, path);
                if (bounds == null || y < bounds.y || y >= bounds.y + bounds.height) {
                    return e;
                }
                final int newX = Math.max(bounds.x, Math.min(x, bounds.x + bounds.width - 1));
                if (newX == x) {
                    return e;
                }
                return new MouseEvent(e.getComponent(), e.getID(), e.getWhen(), e.getModifiers() | e.getModifiersEx(), newX, e.getY(), e.getClickCount(), e.isPopupTrigger(), e.getButton());
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
        //     1: invokespecial   javax/swing/plaf/basic/BasicTreeUI.createPropertyChangeListener:()Ljava/beans/PropertyChangeListener;
        //     4: astore_1        /* superListener */
        //     5: aload_0         /* this */
        //     6: aload_1         /* superListener */
        //     7: invokedynamic   BootstrapMethod #0, propertyChange:(Lcom/formdev/flatlaf/ui/FlatTreeUI;Ljava/beans/PropertyChangeListener;)Ljava/beans/PropertyChangeListener;
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
    
    private void repaintWideDropLocation(final JTree.DropLocation loc) {
        if (loc == null || this.isDropLine(loc)) {
            return;
        }
        final Rectangle r = this.tree.getPathBounds(loc.getPath());
        if (r != null) {
            this.tree.repaint(0, r.y, this.tree.getWidth(), r.height);
        }
    }
    
    @Override
    protected TreeSelectionListener createTreeSelectionListener() {
        final TreeSelectionListener superListener2 = super.createTreeSelectionListener();
        return e -> {
            superListener.valueChanged(e);
            final TreePath[] changedPaths;
            if (this.useUnitedRoundedSelection() && this.tree.getSelectionCount() > 1 && (changedPaths = e.getPaths()) != null) {
                if (changedPaths.length > 4) {
                    this.tree.repaint();
                }
                else {
                    final int arc = (int)Math.ceil(UIScale.scale(this.selectionArc / 2.0f));
                    final TreePath[] array;
                    int i = 0;
                    for (int length = array.length; i < length; ++i) {
                        final TreePath path = array[i];
                        final Rectangle r = this.getPathBounds(this.tree, path);
                        if (r != null) {
                            this.tree.repaint(r.x, r.y - arc, r.width, r.height + arc * 2);
                        }
                    }
                }
            }
        };
    }
    
    @Override
    public Rectangle getPathBounds(final JTree tree, final TreePath path) {
        final Rectangle bounds = super.getPathBounds(tree, path);
        if (bounds != null && this.isWideSelection() && UIManager.getBoolean("FlatLaf.experimental.tree.widePathForLocation") && StackUtils.wasInvokedFrom(JTree.class.getName(), "getPathForLocation", 5)) {
            bounds.x = 0;
            bounds.width = tree.getWidth();
        }
        return bounds;
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.tree, "Tree"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.tree, key, value);
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
    public void paint(final Graphics g, final JComponent c) {
        if (this.treeState == null) {
            return;
        }
        final Rectangle clipBounds = g.getClipBounds();
        final TreePath firstPath = this.getClosestPathForLocation(this.tree, 0, clipBounds.y);
        final Enumeration<TreePath> visiblePaths = this.treeState.getVisiblePathsFrom(firstPath);
        if (visiblePaths != null) {
            final Insets insets = this.tree.getInsets();
            final HashSet<TreePath> verticalLinePaths = this.paintLines ? new HashSet<TreePath>() : null;
            final ArrayList<Runnable> paintLinesLater = this.paintLines ? new ArrayList<Runnable>() : null;
            final ArrayList<Runnable> paintExpandControlsLater = this.paintLines ? new ArrayList<Runnable>() : null;
            TreePath path = null;
            if (this.paintLines) {
                for (path = firstPath.getParentPath(); path != null; path = path.getParentPath()) {
                    verticalLinePaths.add(path);
                }
            }
            final Rectangle boundsBuffer = new Rectangle();
            final boolean rootVisible = this.isRootVisible();
            int row = this.treeState.getRowForPath(firstPath);
            final boolean leftToRight = this.tree.getComponentOrientation().isLeftToRight();
            final int treeWidth = this.tree.getWidth();
            while (visiblePaths.hasMoreElements()) {
                final TreePath path2 = visiblePaths.nextElement();
                if (path2 == null) {
                    break;
                }
                final Rectangle bounds = this.treeState.getBounds(path2, boundsBuffer);
                if (bounds == null) {
                    break;
                }
                if (leftToRight) {
                    final Rectangle rectangle = bounds;
                    rectangle.x += insets.left;
                }
                else {
                    bounds.x = treeWidth - insets.right - (bounds.x + bounds.width);
                }
                final Rectangle rectangle2 = bounds;
                rectangle2.y += insets.top;
                final boolean isLeaf = this.treeModel.isLeaf(path2.getLastPathComponent());
                final boolean isExpanded = !isLeaf && this.treeState.getExpandedState(path2);
                final boolean hasBeenExpanded = !isLeaf && this.tree.hasBeenExpanded(path2);
                this.paintRow(g, clipBounds, insets, bounds, path2, row, isExpanded, hasBeenExpanded, isLeaf);
                Rectangle bounds2 = null;
                int row2 = 0;
                if (this.paintLines) {
                    final TreePath parentPath = path2.getParentPath();
                    if (parentPath != null) {
                        verticalLinePaths.add(parentPath);
                    }
                    if (parentPath != null || (rootVisible && row == 0)) {
                        bounds2 = new Rectangle(bounds);
                        row2 = row;
                        paintLinesLater.add(() -> this.paintHorizontalPartOfLeg(g, clipBounds, insets, bounds2, path, row2, isExpanded, hasBeenExpanded, isLeaf));
                    }
                }
                if (this.shouldPaintExpandControl(path2, row, isExpanded, hasBeenExpanded, isLeaf)) {
                    if (this.paintLines) {
                        final Rectangle bounds3 = new Rectangle(bounds);
                        final int row3 = row;
                        paintExpandControlsLater.add(() -> this.paintExpandControl(g, clipBounds, insets, bounds2, path, row2, isExpanded, hasBeenExpanded, isLeaf));
                    }
                    else {
                        this.paintExpandControl(g, clipBounds, insets, bounds, path2, row, isExpanded, hasBeenExpanded, isLeaf);
                    }
                }
                if (bounds.y + bounds.height >= clipBounds.y + clipBounds.height) {
                    break;
                }
                ++row;
            }
            if (this.paintLines) {
                final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
                for (final Runnable r : paintLinesLater) {
                    r.run();
                }
                g.setColor(Color.green);
                for (final TreePath path3 : verticalLinePaths) {
                    this.paintVerticalPartOfLeg(g, clipBounds, insets, path3);
                }
                if (oldRenderingHints != null) {
                    FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
                }
                for (final Runnable r : paintExpandControlsLater) {
                    r.run();
                }
            }
        }
        this.paintDropLine(g);
        this.rendererPane.removeAll();
    }
    
    @Override
    protected void paintRow(final Graphics g, final Rectangle clipBounds, final Insets insets, final Rectangle bounds, final TreePath path, final int row, final boolean isExpanded, final boolean hasBeenExpanded, final boolean isLeaf) {
        final boolean isEditing = this.editingComponent != null && this.editingRow == row;
        final boolean isSelected = this.tree.isRowSelected(row);
        final boolean isDropRow = this.isDropRow(row);
        final boolean needsSelectionPainting = (isSelected || isDropRow) && this.isPaintSelection();
        if (isEditing) {
            if (isSelected && this.isWideSelection()) {
                final Color oldColor = g.getColor();
                g.setColor(this.selectionInactiveBackground);
                this.paintWideSelection(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
                g.setColor(oldColor);
            }
            return;
        }
        boolean hasFocus = FlatUIUtils.isPermanentFocusOwner(this.tree);
        final boolean cellHasFocus = hasFocus && row == this.getLeadSelectionRow();
        if (!hasFocus && isSelected && this.tree.getParent() instanceof CellRendererPane) {
            hasFocus = FlatUIUtils.isPermanentFocusOwner(this.tree.getParent().getParent());
        }
        final Component rendererComponent = this.currentCellRenderer.getTreeCellRendererComponent(this.tree, path.getLastPathComponent(), isSelected, isExpanded, isLeaf, row, cellHasFocus);
        Color oldBackgroundSelectionColor = null;
        if (isSelected && !hasFocus && !isDropRow) {
            oldBackgroundSelectionColor = this.setRendererBackgroundSelectionColor(rendererComponent, this.selectionInactiveBackground);
            this.setRendererForeground(rendererComponent, this.selectionInactiveForeground);
        }
        else if (isSelected) {
            if (this.selectionBackground != this.defaultSelectionBackground) {
                oldBackgroundSelectionColor = this.setRendererBackgroundSelectionColor(rendererComponent, this.selectionBackground);
            }
            if (this.selectionForeground != this.defaultSelectionForeground) {
                this.setRendererForeground(rendererComponent, this.selectionForeground);
            }
        }
        Color oldBorderSelectionColor = null;
        if (isSelected && hasFocus && (!this.showCellFocusIndicator || this.tree.getMinSelectionRow() == this.tree.getMaxSelectionRow())) {
            oldBorderSelectionColor = this.setRendererBorderSelectionColor(rendererComponent, null);
        }
        else if (hasFocus && this.selectionBorderColor != this.defaultSelectionBorderColor) {
            oldBorderSelectionColor = this.setRendererBorderSelectionColor(rendererComponent, this.selectionBorderColor);
        }
        if (needsSelectionPainting) {
            final Color oldColor2 = g.getColor();
            g.setColor(isDropRow ? UIManager.getColor("Tree.dropCellBackground") : ((rendererComponent instanceof DefaultTreeCellRenderer) ? ((DefaultTreeCellRenderer)rendererComponent).getBackgroundSelectionColor() : (hasFocus ? this.selectionBackground : this.selectionInactiveBackground)));
            if (this.isWideSelection()) {
                this.paintWideSelection(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
            }
            else {
                this.paintCellBackground(g, rendererComponent, bounds, row, true);
            }
            g.setColor(oldColor2);
        }
        else if (rendererComponent instanceof DefaultTreeCellRenderer) {
            final DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)rendererComponent;
            final Color bg = renderer.getBackgroundNonSelectionColor();
            if (bg != null && !bg.equals(this.defaultCellNonSelectionBackground)) {
                final Color oldColor3 = g.getColor();
                g.setColor(bg);
                this.paintCellBackground(g, rendererComponent, bounds, row, false);
                g.setColor(oldColor3);
            }
        }
        this.rendererPane.paintComponent(g, rendererComponent, this.tree, bounds.x, bounds.y, bounds.width, bounds.height, true);
        if (oldBackgroundSelectionColor != null) {
            ((DefaultTreeCellRenderer)rendererComponent).setBackgroundSelectionColor(oldBackgroundSelectionColor);
        }
        if (oldBorderSelectionColor != null) {
            ((DefaultTreeCellRenderer)rendererComponent).setBorderSelectionColor(oldBorderSelectionColor);
        }
    }
    
    private Color setRendererBackgroundSelectionColor(final Component rendererComponent, final Color color) {
        Color oldColor = null;
        if (rendererComponent instanceof DefaultTreeCellRenderer) {
            final DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)rendererComponent;
            if (renderer.getBackgroundSelectionColor() == this.defaultSelectionBackground) {
                oldColor = renderer.getBackgroundSelectionColor();
                renderer.setBackgroundSelectionColor(color);
            }
        }
        else if (rendererComponent.getBackground() == this.defaultSelectionBackground) {
            rendererComponent.setBackground(color);
        }
        return oldColor;
    }
    
    private void setRendererForeground(final Component rendererComponent, final Color color) {
        if (rendererComponent.getForeground() == this.defaultSelectionForeground) {
            rendererComponent.setForeground(color);
        }
    }
    
    private Color setRendererBorderSelectionColor(final Component rendererComponent, final Color color) {
        Color oldColor = null;
        if (rendererComponent instanceof DefaultTreeCellRenderer) {
            final DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)rendererComponent;
            if (renderer.getBorderSelectionColor() == this.defaultSelectionBorderColor) {
                oldColor = renderer.getBorderSelectionColor();
                renderer.setBorderSelectionColor(color);
            }
        }
        return oldColor;
    }
    
    private void paintWideSelection(final Graphics g, final Rectangle clipBounds, final Insets insets, final Rectangle bounds, final TreePath path, final int row, final boolean isExpanded, final boolean hasBeenExpanded, final boolean isLeaf) {
        float arcTop;
        float arcBottom = arcTop = UIScale.scale(this.selectionArc / 2.0f);
        if (this.useUnitedRoundedSelection()) {
            if (row > 0 && this.tree.isRowSelected(row - 1)) {
                arcTop = 0.0f;
            }
            if (row < this.tree.getRowCount() - 1 && this.tree.isRowSelected(row + 1)) {
                arcBottom = 0.0f;
            }
        }
        FlatUIUtils.paintSelection((Graphics2D)g, 0, bounds.y, this.tree.getWidth(), bounds.height, UIScale.scale(this.selectionInsets), arcTop, arcTop, arcBottom, arcBottom, 0);
    }
    
    private void paintCellBackground(final Graphics g, final Component rendererComponent, final Rectangle bounds, final int row, final boolean paintSelection) {
        int xOffset = 0;
        int imageOffset = 0;
        if (rendererComponent instanceof JLabel) {
            final JLabel label = (JLabel)rendererComponent;
            final Icon icon = label.isEnabled() ? label.getIcon() : label.getDisabledIcon();
            imageOffset = ((icon != null && label.getText() != null) ? (icon.getIconWidth() + Math.max(label.getIconTextGap() - 1, 0)) : 0);
            xOffset = (label.getComponentOrientation().isLeftToRight() ? imageOffset : 0);
        }
        if (paintSelection) {
            float arcBottomRight;
            float arcBottomLeft;
            float arcTopLeft;
            float arcTopRight = arcTopLeft = (arcBottomLeft = (arcBottomRight = UIScale.scale(this.selectionArc / 2.0f)));
            if (this.useUnitedRoundedSelection()) {
                if (row > 0 && this.tree.isRowSelected(row - 1)) {
                    final Rectangle r = this.getPathBounds(this.tree, this.tree.getPathForRow(row - 1));
                    arcTopLeft = Math.min(arcTopLeft, (float)(r.x - bounds.x));
                    arcTopRight = Math.min(arcTopRight, (float)(bounds.x + bounds.width - (r.x + r.width)));
                }
                if (row < this.tree.getRowCount() - 1 && this.tree.isRowSelected(row + 1)) {
                    final Rectangle r = this.getPathBounds(this.tree, this.tree.getPathForRow(row + 1));
                    arcBottomLeft = Math.min(arcBottomLeft, (float)(r.x - bounds.x));
                    arcBottomRight = Math.min(arcBottomRight, (float)(bounds.x + bounds.width - (r.x + r.width)));
                }
            }
            FlatUIUtils.paintSelection((Graphics2D)g, bounds.x + xOffset, bounds.y, bounds.width - imageOffset, bounds.height, UIScale.scale(this.selectionInsets), arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight, 0);
        }
        else {
            g.fillRect(bounds.x + xOffset, bounds.y, bounds.width - imageOffset, bounds.height);
        }
    }
    
    private boolean useUnitedRoundedSelection() {
        return this.selectionArc > 0 && (this.selectionInsets == null || (this.selectionInsets.top == 0 && this.selectionInsets.bottom == 0));
    }
    
    @Override
    protected void paintVerticalLine(final Graphics g, final JComponent c, final int x, final int top, final int bottom) {
        ((Graphics2D)g).fill(new Rectangle2D.Float((float)x, (float)top, UIScale.scale(1.0f), (float)(bottom - top)));
    }
    
    @Override
    protected void paintHorizontalLine(final Graphics g, final JComponent c, final int y, final int left, final int right) {
        ((Graphics2D)g).fill(new Rectangle2D.Float((float)left, (float)y, (float)(right - left), UIScale.scale(1.0f)));
    }
    
    private boolean isDropRow(final int row) {
        final JTree.DropLocation dropLocation = this.tree.getDropLocation();
        return dropLocation != null && dropLocation.getChildIndex() == -1 && this.tree.getRowForPath(dropLocation.getPath()) == row;
    }
    
    @Override
    protected Rectangle getDropLineRect(final JTree.DropLocation loc) {
        final Rectangle r = super.getDropLineRect(loc);
        return this.isWideSelection() ? new Rectangle(0, r.y, this.tree.getWidth(), r.height) : r;
    }
    
    protected boolean isWideSelection() {
        return FlatClientProperties.clientPropertyBoolean(this.tree, "JTree.wideSelection", this.wideSelection);
    }
    
    protected boolean isPaintSelection() {
        return FlatClientProperties.clientPropertyBoolean(this.tree, "JTree.paintSelection", this.paintSelection);
    }
}
