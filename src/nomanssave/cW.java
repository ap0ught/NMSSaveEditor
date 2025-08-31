// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.CaretEvent;
import javax.swing.text.AttributeSet;
import java.awt.Font;
import javax.swing.text.StyleConstants;
import javax.swing.text.Element;
import java.awt.Rectangle;
import java.awt.FontMetrics;
import javax.swing.text.Utilities;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.text.JTextComponent;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretListener;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class cW extends JPanel implements PropertyChangeListener, CaretListener, DocumentListener
{
    public static final float gx = 0.0f;
    public static final float gy = 0.5f;
    public static final float gz = 1.0f;
    private static final Border gA;
    private static final int HEIGHT = 2146483647;
    private JTextComponent gB;
    private boolean gC;
    private int gD;
    private Color gE;
    private float gF;
    private int gG;
    private int gH;
    private int gI;
    private int gJ;
    private HashMap gK;
    
    static {
        gA = new MatteBorder(0, 0, 0, 2, Color.GRAY);
    }
    
    public cW(final JTextComponent textComponent) {
        this(textComponent, 3);
    }
    
    public cW(final JTextComponent gb, final int n) {
        this.gB = gb;
        this.setFont(gb.getFont());
        this.y(5);
        this.a(Color.RED);
        this.a(1.0f);
        this.z(n);
        gb.getDocument().addDocumentListener(this);
        gb.addCaretListener(this);
        gb.addPropertyChangeListener("font", this);
    }
    
    public boolean aD() {
        return this.gC;
    }
    
    public void b(final boolean gc) {
        this.gC = gc;
    }
    
    public int aE() {
        return this.gD;
    }
    
    public void y(final int n) {
        this.gD = n;
        this.setBorder(new CompoundBorder(cW.gA, new EmptyBorder(0, n, 0, n)));
        this.gH = 0;
        this.aI();
    }
    
    public Color aF() {
        return (this.gE == null) ? this.getForeground() : this.gE;
    }
    
    public void a(final Color ge) {
        this.gE = ge;
    }
    
    public float aG() {
        return this.gF;
    }
    
    public void a(final float n) {
        this.gF = ((n > 1.0f) ? 1.0f : ((n < 0.0f) ? -1.0f : n));
    }
    
    public int aH() {
        return this.gG;
    }
    
    public void z(final int gg) {
        this.gG = gg;
        this.aI();
    }
    
    private void aI() {
        final int max = Math.max(String.valueOf(this.gB.getDocument().getDefaultRootElement().getElementCount()).length(), this.gG);
        if (this.gH != max) {
            this.gH = max;
            final int n = this.getFontMetrics(this.getFont()).charWidth('0') * max;
            final Insets insets = this.getInsets();
            final int width = insets.left + insets.right + n;
            final Dimension preferredSize = this.getPreferredSize();
            preferredSize.setSize(width, 2146483647);
            this.setPreferredSize(preferredSize);
            this.setSize(preferredSize);
        }
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final FontMetrics fontMetrics = this.gB.getFontMetrics(this.gB.getFont());
        final Insets insets = this.getInsets();
        final int n = this.getSize().width - insets.left - insets.right;
        final Rectangle clipBounds = g.getClipBounds();
        int i = this.gB.viewToModel(new Point(0, clipBounds.y));
        while (i <= this.gB.viewToModel(new Point(0, clipBounds.y + clipBounds.height))) {
            try {
                if (this.A(i)) {
                    g.setColor(this.aF());
                }
                else {
                    g.setColor(this.getForeground());
                }
                final String b = this.B(i);
                g.drawString(b, this.b(n, fontMetrics.stringWidth(b)) + insets.left, this.a(i, fontMetrics));
                i = Utilities.getRowEnd(this.gB, i) + 1;
            }
            catch (final Exception ex) {
                break;
            }
        }
    }
    
    private boolean A(final int n) {
        final int caretPosition = this.gB.getCaretPosition();
        final Element defaultRootElement = this.gB.getDocument().getDefaultRootElement();
        return defaultRootElement.getElementIndex(n) == defaultRootElement.getElementIndex(caretPosition);
    }
    
    protected String B(final int n) {
        final Element defaultRootElement = this.gB.getDocument().getDefaultRootElement();
        final int elementIndex = defaultRootElement.getElementIndex(n);
        if (defaultRootElement.getElement(elementIndex).getStartOffset() == n) {
            return String.valueOf(elementIndex + 1);
        }
        return "";
    }
    
    private int b(final int n, final int n2) {
        return (int)((n - n2) * this.gF);
    }
    
    private int a(final int pos, final FontMetrics fontMetrics) {
        final Rectangle modelToView = this.gB.modelToView(pos);
        final int height = fontMetrics.getHeight();
        final int n = modelToView.y + modelToView.height;
        int a = 0;
        if (modelToView.height == height) {
            a = fontMetrics.getDescent();
        }
        else {
            if (this.gK == null) {
                this.gK = new HashMap();
            }
            final Element defaultRootElement = this.gB.getDocument().getDefaultRootElement();
            final Element element = defaultRootElement.getElement(defaultRootElement.getElementIndex(pos));
            for (int i = 0; i < element.getElementCount(); ++i) {
                final AttributeSet attributes = element.getElement(i).getAttributes();
                final String s = (String)attributes.getAttribute(StyleConstants.FontFamily);
                final Integer obj = (Integer)attributes.getAttribute(StyleConstants.FontSize);
                final String string = String.valueOf(s) + obj;
                FontMetrics fontMetrics2 = this.gK.get(string);
                if (fontMetrics2 == null) {
                    fontMetrics2 = this.gB.getFontMetrics(new Font(s, 0, obj));
                    this.gK.put(string, fontMetrics2);
                }
                a = Math.max(a, fontMetrics2.getDescent());
            }
        }
        return n - a;
    }
    
    @Override
    public void caretUpdate(final CaretEvent caretEvent) {
        final int elementIndex = this.gB.getDocument().getDefaultRootElement().getElementIndex(this.gB.getCaretPosition());
        if (this.gJ != elementIndex) {
            this.repaint();
            this.gJ = elementIndex;
        }
    }
    
    @Override
    public void changedUpdate(final DocumentEvent documentEvent) {
        this.aJ();
    }
    
    @Override
    public void insertUpdate(final DocumentEvent documentEvent) {
        this.aJ();
    }
    
    @Override
    public void removeUpdate(final DocumentEvent documentEvent) {
        this.aJ();
    }
    
    private void aJ() {
        SwingUtilities.invokeLater(new cX(this));
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getNewValue() instanceof Font) {
            if (this.gC) {
                this.setFont((Font)propertyChangeEvent.getNewValue());
                this.gH = 0;
                this.aI();
            }
            else {
                this.repaint();
            }
        }
    }
}
