// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.LayoutFocusTraversalPolicy;
import javax.swing.JToolBar;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import java.awt.Container;
import java.util.Iterator;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import java.awt.Graphics2D;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import java.awt.Component;
import com.formdev.flatlaf.util.LoggingFacade;
import java.beans.PropertyChangeListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.FocusTraversalPolicy;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.plaf.basic.BasicToolBarUI;

public class FlatToolBarUI extends BasicToolBarUI implements FlatStylingSupport.StyleableUI
{
    @FlatStylingSupport.Styleable
    protected boolean focusableButtons;
    @FlatStylingSupport.Styleable
    protected boolean arrowKeysOnlyNavigation;
    @FlatStylingSupport.Styleable
    protected int hoverButtonGroupArc;
    @FlatStylingSupport.Styleable
    protected Color hoverButtonGroupBackground;
    @FlatStylingSupport.Styleable
    protected Insets borderMargins;
    @FlatStylingSupport.Styleable
    protected Color gripColor;
    private FocusTraversalPolicy focusTraversalPolicy;
    private Boolean oldFloatable;
    private Map<String, Object> oldStyleValues;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatToolBarUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.installFocusTraversalPolicy();
        this.installStyle();
        if (!this.focusableButtons) {
            this.setButtonsFocusable(false);
        }
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        if (!this.focusableButtons) {
            this.setButtonsFocusable(true);
        }
        this.uninstallFocusTraversalPolicy();
        this.oldStyleValues = null;
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.focusableButtons = UIManager.getBoolean("ToolBar.focusableButtons");
        this.arrowKeysOnlyNavigation = UIManager.getBoolean("ToolBar.arrowKeysOnlyNavigation");
        this.hoverButtonGroupArc = UIManager.getInt("ToolBar.hoverButtonGroupArc");
        this.hoverButtonGroupBackground = UIManager.getColor("ToolBar.hoverButtonGroupBackground");
        if (!UIManager.getBoolean("ToolBar.floatable")) {
            this.oldFloatable = this.toolBar.isFloatable();
            this.toolBar.setFloatable(false);
        }
        else {
            this.oldFloatable = null;
        }
    }
    
    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        this.hoverButtonGroupBackground = null;
        if (this.oldFloatable != null) {
            this.toolBar.setFloatable(this.oldFloatable);
            this.oldFloatable = null;
        }
    }
    
    @Override
    protected ContainerListener createToolBarContListener() {
        return new ToolBarContListener() {
            @Override
            public void componentAdded(final ContainerEvent e) {
                super.componentAdded(e);
                if (!FlatToolBarUI.this.focusableButtons) {
                    FlatToolBarUI.this.setButtonFocusable(e.getChild(), false);
                }
            }
            
            @Override
            public void componentRemoved(final ContainerEvent e) {
                super.componentRemoved(e);
                if (!FlatToolBarUI.this.focusableButtons) {
                    FlatToolBarUI.this.setButtonFocusable(e.getChild(), true);
                }
            }
        };
    }
    
    @Override
    protected PropertyChangeListener createPropertyListener() {
        return FlatStylingSupport.createPropertyChangeListener(this.toolBar, this::installStyle, super.createPropertyListener());
    }
    
    protected void installStyle() {
        try {
            this.applyStyle(FlatStylingSupport.getResolvedStyle(this.toolBar, "ToolBar"));
        }
        catch (final RuntimeException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    protected void applyStyle(final Object style) {
        final boolean oldFocusableButtons = this.focusableButtons;
        final boolean oldArrowKeysOnlyNavigation = this.arrowKeysOnlyNavigation;
        this.oldStyleValues = FlatStylingSupport.parseAndApply(this.oldStyleValues, style, this::applyStyleProperty);
        if (this.focusableButtons != oldFocusableButtons) {
            this.setButtonsFocusable(this.focusableButtons);
        }
        if (this.arrowKeysOnlyNavigation != oldArrowKeysOnlyNavigation || this.focusableButtons != oldFocusableButtons) {
            if (this.arrowKeysOnlyNavigation) {
                this.installFocusTraversalPolicy();
            }
            else {
                this.uninstallFocusTraversalPolicy();
            }
        }
    }
    
    protected Object applyStyleProperty(final String key, final Object value) {
        return FlatStylingSupport.applyToAnnotatedObjectOrComponent(this, this.toolBar, key, value);
    }
    
    @Override
    public Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        return FlatStylingSupport.getAnnotatedStyleableInfos(this);
    }
    
    @Override
    public Object getStyleableValue(final JComponent c, final String key) {
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }
    
    protected void setButtonsFocusable(final boolean focusable) {
        for (final Component c : this.toolBar.getComponents()) {
            this.setButtonFocusable(c, focusable);
        }
    }
    
    private void setButtonFocusable(final Component c, final boolean focusable) {
        if (c instanceof AbstractButton && focusable != c.isFocusable()) {
            c.setFocusable(focusable);
        }
    }
    
    protected void installFocusTraversalPolicy() {
        if (!this.arrowKeysOnlyNavigation || !this.focusableButtons || this.toolBar.getFocusTraversalPolicy() != null) {
            return;
        }
        this.focusTraversalPolicy = this.createFocusTraversalPolicy();
        if (this.focusTraversalPolicy != null) {
            this.toolBar.setFocusTraversalPolicy(this.focusTraversalPolicy);
            this.toolBar.setFocusTraversalPolicyProvider(true);
        }
    }
    
    protected void uninstallFocusTraversalPolicy() {
        if (this.focusTraversalPolicy != null && this.toolBar.getFocusTraversalPolicy() == this.focusTraversalPolicy) {
            this.toolBar.setFocusTraversalPolicy(null);
            this.toolBar.setFocusTraversalPolicyProvider(false);
        }
        this.focusTraversalPolicy = null;
    }
    
    protected FocusTraversalPolicy createFocusTraversalPolicy() {
        return new FlatToolBarFocusTraversalPolicy();
    }
    
    @Override
    protected void navigateFocusedComp(final int direction) {
        final int count = this.toolBar.getComponentCount();
        if (this.focusedCompIndex < 0 || this.focusedCompIndex >= count) {
            return;
        }
        int add = 0;
        switch (direction) {
            case 3:
            case 5: {
                add = 1;
                break;
            }
            case 1:
            case 7: {
                add = -1;
                break;
            }
            default: {
                return;
            }
        }
        int i = this.focusedCompIndex;
        while (true) {
            i += add;
            if (i < 0) {
                i = count - 1;
            }
            else if (i >= count) {
                i = 0;
            }
            if (i == this.focusedCompIndex) {
                return;
            }
            final Component c = this.toolBar.getComponentAtIndex(i);
            if (canBeFocusOwner(c)) {
                c.requestFocus();
            }
        }
    }
    
    private static boolean canBeFocusOwner(final Component c) {
        if (c == null || !c.isEnabled() || !c.isVisible() || !c.isDisplayable() || !c.isFocusable()) {
            return false;
        }
        if (c instanceof JComboBox) {
            final JComboBox<?> comboBox = (JComboBox<?>)c;
            return comboBox.getUI().isFocusTraversable(comboBox);
        }
        if (c instanceof JComponent) {
            InputMap inputMap;
            for (inputMap = ((JComponent)c).getInputMap(0); inputMap != null && inputMap.size() == 0; inputMap = inputMap.getParent()) {}
            if (inputMap == null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected void setBorderToRollover(final Component c) {
    }
    
    @Override
    protected void setBorderToNonRollover(final Component c) {
    }
    
    @Override
    protected void setBorderToNormal(final Component c) {
    }
    
    @Override
    protected void installRolloverBorders(final JComponent c) {
    }
    
    @Override
    protected void installNonRolloverBorders(final JComponent c) {
    }
    
    @Override
    protected void installNormalBorders(final JComponent c) {
    }
    
    @Override
    protected Border createRolloverBorder() {
        return null;
    }
    
    @Override
    protected Border createNonRolloverBorder() {
        return null;
    }
    
    @Override
    public void setOrientation(final int orientation) {
        if (orientation != this.toolBar.getOrientation()) {
            final Insets margin = this.toolBar.getMargin();
            final Insets newMargin = new Insets(margin.left, margin.top, margin.right, margin.bottom);
            if (!newMargin.equals(margin)) {
                this.toolBar.setMargin(newMargin);
            }
        }
        super.setOrientation(orientation);
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        super.paint(g, c);
        this.paintButtonGroup(g);
    }
    
    protected void paintButtonGroup(final Graphics g) {
        if (this.hoverButtonGroupBackground == null) {
            return;
        }
        ButtonGroup group = null;
        for (final Component b : this.toolBar.getComponents()) {
            if (b instanceof AbstractButton && ((AbstractButton)b).getModel().isRollover()) {
                group = this.getButtonGroup((AbstractButton)b);
                if (group != null) {
                    break;
                }
            }
        }
        if (group == null) {
            return;
        }
        final ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
        final Enumeration<AbstractButton> e = group.getElements();
        while (e.hasMoreElements()) {
            final AbstractButton gb = e.nextElement();
            if (gb.getParent() == this.toolBar) {
                rects.add(gb.getBounds());
            }
        }
        final boolean horizontal = this.toolBar.getOrientation() == 0;
        rects.sort((r1, r2) -> horizontal ? (r1.x - r2.x) : (r1.y - r2.y));
        final Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);
        g.setColor(FlatUIUtils.deriveColor(this.hoverButtonGroupBackground, this.toolBar.getBackground()));
        final int maxSepWidth = UIScale.scale(10);
        Rectangle gr = null;
        for (final Rectangle r : rects) {
            if (gr == null) {
                gr = r;
            }
            else {
                Label_0317: {
                    if (horizontal) {
                        if (gr.x + gr.width + maxSepWidth < r.x) {
                            break Label_0317;
                        }
                    }
                    else if (gr.y + gr.height + maxSepWidth < r.y) {
                        break Label_0317;
                    }
                    gr = gr.union(r);
                    continue;
                }
                FlatUIUtils.paintComponentBackground((Graphics2D)g, gr.x, gr.y, gr.width, gr.height, 0.0f, (float)UIScale.scale(this.hoverButtonGroupArc));
                gr = r;
            }
        }
        if (gr != null) {
            FlatUIUtils.paintComponentBackground((Graphics2D)g, gr.x, gr.y, gr.width, gr.height, 0.0f, (float)UIScale.scale(this.hoverButtonGroupArc));
        }
        FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
    }
    
    protected void repaintButtonGroup(final AbstractButton b) {
        if (this.hoverButtonGroupBackground == null) {
            return;
        }
        final ButtonGroup group = this.getButtonGroup(b);
        if (group == null) {
            return;
        }
        Rectangle gr = null;
        final Enumeration<AbstractButton> e = group.getElements();
        while (e.hasMoreElements()) {
            final AbstractButton gb = e.nextElement();
            final Container parent = gb.getParent();
            if (parent == this.toolBar) {
                gr = ((gr != null) ? gr.union(gb.getBounds()) : gb.getBounds());
            }
        }
        if (gr != null) {
            this.toolBar.repaint(gr);
        }
    }
    
    private ButtonGroup getButtonGroup(final AbstractButton b) {
        final ButtonModel model = b.getModel();
        return (model instanceof DefaultButtonModel) ? ((DefaultButtonModel)model).getGroup() : null;
    }
    
    protected class FlatToolBarFocusTraversalPolicy extends LayoutFocusTraversalPolicy
    {
        @Override
        public Component getComponentAfter(final Container aContainer, final Component aComponent) {
            if (!(aComponent instanceof AbstractButton)) {
                return super.getComponentAfter(aContainer, aComponent);
            }
            Component c = aComponent;
            while ((c = super.getComponentAfter(aContainer, c)) != null) {
                if (!(c instanceof AbstractButton)) {
                    return c;
                }
            }
            return null;
        }
        
        @Override
        public Component getComponentBefore(final Container aContainer, final Component aComponent) {
            if (!(aComponent instanceof AbstractButton)) {
                return super.getComponentBefore(aContainer, aComponent);
            }
            Component c = aComponent;
            while ((c = super.getComponentBefore(aContainer, c)) != null) {
                if (!(c instanceof AbstractButton)) {
                    return c;
                }
            }
            return null;
        }
        
        @Override
        public Component getFirstComponent(final Container aContainer) {
            return this.getRecentComponent(aContainer, true);
        }
        
        @Override
        public Component getLastComponent(final Container aContainer) {
            return this.getRecentComponent(aContainer, false);
        }
        
        private Component getRecentComponent(final Container aContainer, final boolean first) {
            if (FlatToolBarUI.this.focusedCompIndex >= 0 && FlatToolBarUI.this.focusedCompIndex < FlatToolBarUI.this.toolBar.getComponentCount()) {
                return FlatToolBarUI.this.toolBar.getComponent(FlatToolBarUI.this.focusedCompIndex);
            }
            return first ? super.getFirstComponent(aContainer) : super.getLastComponent(aContainer);
        }
    }
}
