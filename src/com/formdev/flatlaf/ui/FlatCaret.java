// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import javax.swing.text.Document;
import javax.swing.JFormattedTextField;
import javax.swing.text.BadLocationException;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.text.Utilities;
import javax.swing.Action;
import javax.swing.ActionMap;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.Rectangle;
import java.awt.EventQueue;
import javax.swing.text.JTextComponent;
import javax.swing.plaf.UIResource;
import javax.swing.text.DefaultCaret;

public class FlatCaret extends DefaultCaret implements UIResource
{
    private static final String KEY_CARET_INFO = "FlatLaf.internal.caretInfo";
    private final String selectAllOnFocusPolicy;
    private final boolean selectAllOnMouseClick;
    private boolean inInstall;
    private boolean wasFocused;
    private boolean wasTemporaryLost;
    private boolean isMousePressed;
    private boolean isWordSelection;
    private boolean isLineSelection;
    private int dragSelectionStart;
    private int dragSelectionEnd;
    
    public FlatCaret(final String selectAllOnFocusPolicy, final boolean selectAllOnMouseClick) {
        this.selectAllOnFocusPolicy = selectAllOnFocusPolicy;
        this.selectAllOnMouseClick = selectAllOnMouseClick;
    }
    
    @Override
    public void install(final JTextComponent c) {
        long[] ci = (long[])c.getClientProperty("FlatLaf.internal.caretInfo");
        if (ci != null) {
            c.putClientProperty("FlatLaf.internal.caretInfo", null);
            if (System.currentTimeMillis() - 500L > ci[3]) {
                ci = null;
            }
        }
        if (ci != null) {
            this.setBlinkRate((int)ci[2]);
        }
        this.inInstall = true;
        try {
            super.install(c);
        }
        finally {
            this.inInstall = false;
        }
        if (ci != null) {
            this.select((int)ci[1], (int)ci[0]);
            if (this.isSelectionVisible()) {
                EventQueue.invokeLater(() -> {
                    if (this.getComponent() != null) {
                        if (this.isSelectionVisible()) {
                            this.setSelectionVisible(false);
                            this.setSelectionVisible(true);
                        }
                    }
                });
            }
        }
    }
    
    @Override
    public void deinstall(final JTextComponent c) {
        c.putClientProperty("FlatLaf.internal.caretInfo", new long[] { this.getDot(), this.getMark(), this.getBlinkRate(), System.currentTimeMillis() });
        super.deinstall(c);
    }
    
    @Override
    protected void adjustVisibility(final Rectangle nloc) {
        final JTextComponent c = this.getComponent();
        if (c != null && c.getUI() instanceof FlatTextFieldUI) {
            final Rectangle r = ((FlatTextFieldUI)c.getUI()).getVisibleEditorRect();
            if (r != null) {
                nloc.x -= r.x - c.getInsets().left;
            }
        }
        super.adjustVisibility(nloc);
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
        if (!this.inInstall && !this.wasTemporaryLost && (!this.isMousePressed || this.selectAllOnMouseClick)) {
            this.selectAllOnFocusGained();
        }
        this.wasTemporaryLost = false;
        this.wasFocused = true;
        super.focusGained(e);
    }
    
    @Override
    public void focusLost(final FocusEvent e) {
        this.wasTemporaryLost = e.isTemporary();
        super.focusLost(e);
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        this.isMousePressed = true;
        super.mousePressed(e);
        final JTextComponent c = this.getComponent();
        this.isWordSelection = (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e) && !e.isConsumed());
        this.isLineSelection = (e.getClickCount() == 3 && SwingUtilities.isLeftMouseButton(e) && (!e.isConsumed() || c.getDragEnabled()));
        if (this.isLineSelection) {
            final ActionMap actionMap = c.getActionMap();
            final Action selectLineAction = (actionMap != null) ? actionMap.get("select-line") : null;
            if (selectLineAction != null) {
                selectLineAction.actionPerformed(new ActionEvent(c, 1001, null, e.getWhen(), e.getModifiers()));
            }
        }
        if (this.isWordSelection || this.isLineSelection) {
            final int mark = this.getMark();
            final int dot = this.getDot();
            this.dragSelectionStart = Math.min(dot, mark);
            this.dragSelectionEnd = Math.max(dot, mark);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        this.isMousePressed = false;
        this.isWordSelection = false;
        this.isLineSelection = false;
        super.mouseReleased(e);
    }
    
    @Override
    public void mouseDragged(final MouseEvent e) {
        if ((this.isWordSelection || this.isLineSelection) && !e.isConsumed() && SwingUtilities.isLeftMouseButton(e)) {
            final JTextComponent c = this.getComponent();
            final int pos = c.viewToModel(e.getPoint());
            if (pos < 0) {
                return;
            }
            try {
                if (pos > this.dragSelectionEnd) {
                    this.select(this.dragSelectionStart, this.isWordSelection ? Utilities.getWordEnd(c, pos) : Utilities.getRowEnd(c, pos));
                }
                else if (pos < this.dragSelectionStart) {
                    this.select(this.dragSelectionEnd, this.isWordSelection ? Utilities.getWordStart(c, pos) : Utilities.getRowStart(c, pos));
                }
                else {
                    this.select(this.dragSelectionStart, this.dragSelectionEnd);
                }
            }
            catch (final BadLocationException ex) {
                UIManager.getLookAndFeel().provideErrorFeedback(c);
            }
        }
        else {
            super.mouseDragged(e);
        }
    }
    
    protected void selectAllOnFocusGained() {
        final JTextComponent c = this.getComponent();
        final Document doc = c.getDocument();
        if (doc == null || !c.isEnabled() || !c.isEditable() || FlatUIUtils.isCellEditor(c)) {
            return;
        }
        Object selectAllOnFocusPolicy = c.getClientProperty("JTextField.selectAllOnFocusPolicy");
        if (selectAllOnFocusPolicy == null) {
            selectAllOnFocusPolicy = this.selectAllOnFocusPolicy;
        }
        if (selectAllOnFocusPolicy == null || "never".equals(selectAllOnFocusPolicy)) {
            return;
        }
        if (!"always".equals(selectAllOnFocusPolicy)) {
            if (this.wasFocused) {
                return;
            }
            final int dot = this.getDot();
            final int mark = this.getMark();
            if (dot != mark || dot != doc.getLength()) {
                return;
            }
        }
        if (c instanceof JFormattedTextField) {
            EventQueue.invokeLater(() -> {
                if (this.getComponent() != null) {
                    this.select(0, doc.getLength());
                }
            });
        }
        else {
            this.select(0, doc.getLength());
        }
    }
    
    private void select(final int mark, final int dot) {
        if (mark != this.getMark()) {
            this.setDot(mark);
        }
        if (dot != this.getDot()) {
            this.moveDot(dot);
        }
    }
    
    public void scrollCaretToVisible() {
        final JTextComponent c = this.getComponent();
        if (c == null || c.getUI() == null) {
            return;
        }
        try {
            final Rectangle loc = c.getUI().modelToView(c, this.getDot(), this.getDotBias());
            if (loc != null) {
                this.adjustVisibility(loc);
                this.damage(loc);
            }
        }
        catch (final BadLocationException ex) {}
    }
}
