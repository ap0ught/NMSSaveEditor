package nomanssave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleConstants;
import javax.swing.text.Utilities;

// $VF: renamed from: nomanssave.cW
public class class_353 extends JPanel implements PropertyChangeListener, CaretListener, DocumentListener {
   // $VF: renamed from: gx float
   public static final float field_1152 = 0.0F;
   // $VF: renamed from: gy float
   public static final float field_1153 = 0.5F;
   // $VF: renamed from: gz float
   public static final float field_1154 = 1.0F;
   // $VF: renamed from: gA javax.swing.border.Border
   private static final Border field_1155 = new MatteBorder(0, 0, 0, 2, Color.GRAY);
   private static final int HEIGHT = 2146483647;
   // $VF: renamed from: gB javax.swing.text.JTextComponent
   private JTextComponent field_1156;
   // $VF: renamed from: gC boolean
   private boolean field_1157;
   // $VF: renamed from: gD int
   private int field_1158;
   // $VF: renamed from: gE java.awt.Color
   private Color field_1159;
   // $VF: renamed from: gF float
   private float field_1160;
   // $VF: renamed from: gG int
   private int field_1161;
   // $VF: renamed from: gH int
   private int field_1162;
   // $VF: renamed from: gI int
   private int field_1163;
   // $VF: renamed from: gJ int
   private int field_1164;
   // $VF: renamed from: gK java.util.HashMap
   private HashMap field_1165;

   public class_353(JTextComponent var1) {
      this(var1, 3);
   }

   public class_353(JTextComponent var1, int var2) {
      this.field_1156 = var1;
      this.setFont(var1.getFont());
      this.method_1036(5);
      this.method_1038(Color.RED);
      this.method_1040(1.0F);
      this.method_1042(var2);
      var1.getDocument().addDocumentListener(this);
      var1.addCaretListener(this);
      var1.addPropertyChangeListener("font", this);
   }

   // $VF: renamed from: aD () boolean
   public boolean method_1033() {
      return this.field_1157;
   }

   // $VF: renamed from: b (boolean) void
   public void method_1034(boolean var1) {
      this.field_1157 = var1;
   }

   // $VF: renamed from: aE () int
   public int method_1035() {
      return this.field_1158;
   }

   // $VF: renamed from: y (int) void
   public void method_1036(int var1) {
      this.field_1158 = var1;
      EmptyBorder var2 = new EmptyBorder(0, var1, 0, var1);
      this.setBorder(new CompoundBorder(field_1155, var2));
      this.field_1162 = 0;
      this.method_1043();
   }

   // $VF: renamed from: aF () java.awt.Color
   public Color method_1037() {
      return this.field_1159 == null ? this.getForeground() : this.field_1159;
   }

   // $VF: renamed from: a (java.awt.Color) void
   public void method_1038(Color var1) {
      this.field_1159 = var1;
   }

   // $VF: renamed from: aG () float
   public float method_1039() {
      return this.field_1160;
   }

   // $VF: renamed from: a (float) void
   public void method_1040(float var1) {
      this.field_1160 = var1 > 1.0F ? 1.0F : (var1 < 0.0F ? -1.0F : var1);
   }

   // $VF: renamed from: aH () int
   public int method_1041() {
      return this.field_1161;
   }

   // $VF: renamed from: z (int) void
   public void method_1042(int var1) {
      this.field_1161 = var1;
      this.method_1043();
   }

   // $VF: renamed from: aI () void
   private void method_1043() {
      Element var1 = this.field_1156.getDocument().getDefaultRootElement();
      int var2 = var1.getElementCount();
      int var3 = Math.max(String.valueOf(var2).length(), this.field_1161);
      if (this.field_1162 != var3) {
         this.field_1162 = var3;
         FontMetrics var4 = this.getFontMetrics(this.getFont());
         int var5 = var4.charWidth('0') * var3;
         Insets var6 = this.getInsets();
         int var7 = var6.left + var6.right + var5;
         Dimension var8 = this.getPreferredSize();
         var8.setSize(var7, 2146483647);
         this.setPreferredSize(var8);
         this.setSize(var8);
      }
   }

   @Override
   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      FontMetrics var2 = this.field_1156.getFontMetrics(this.field_1156.getFont());
      Insets var3 = this.getInsets();
      int var4 = this.getSize().width - var3.left - var3.right;
      Rectangle var5 = var1.getClipBounds();
      int var6 = this.field_1156.viewToModel(new Point(0, var5.y));
      int var7 = this.field_1156.viewToModel(new Point(0, var5.y + var5.height));

      while (var6 <= var7) {
         try {
            if (this.method_1044(var6)) {
               var1.setColor(this.method_1037());
            } else {
               var1.setColor(this.getForeground());
            }

            String var8 = this.method_1045(var6);
            int var9 = var2.stringWidth(var8);
            int var10 = this.method_1046(var4, var9) + var3.left;
            int var11 = this.method_1047(var6, var2);
            var1.drawString(var8, var10, var11);
            var6 = Utilities.getRowEnd(this.field_1156, var6) + 1;
         } catch (Exception var12) {
            break;
         }
      }
   }

   // $VF: renamed from: A (int) boolean
   private boolean method_1044(int var1) {
      int var2 = this.field_1156.getCaretPosition();
      Element var3 = this.field_1156.getDocument().getDefaultRootElement();
      return var3.getElementIndex(var1) == var3.getElementIndex(var2);
   }

   // $VF: renamed from: B (int) java.lang.String
   protected String method_1045(int var1) {
      Element var2 = this.field_1156.getDocument().getDefaultRootElement();
      int var3 = var2.getElementIndex(var1);
      Element var4 = var2.getElement(var3);
      return var4.getStartOffset() == var1 ? String.valueOf(var3 + 1) : "";
   }

   // $VF: renamed from: b (int, int) int
   private int method_1046(int var1, int var2) {
      return (int)((float)(var1 - var2) * this.field_1160);
   }

   // $VF: renamed from: a (int, java.awt.FontMetrics) int
   private int method_1047(int var1, FontMetrics var2) {
      Rectangle var3 = this.field_1156.modelToView(var1);
      int var4 = var2.getHeight();
      int var5 = var3.y + var3.height;
      int var6 = 0;
      if (var3.height == var4) {
         var6 = var2.getDescent();
      } else {
         if (this.field_1165 == null) {
            this.field_1165 = new HashMap();
         }

         Element var7 = this.field_1156.getDocument().getDefaultRootElement();
         int var8 = var7.getElementIndex(var1);
         Element var9 = var7.getElement(var8);

         for (int var10 = 0; var10 < var9.getElementCount(); var10++) {
            Element var11 = var9.getElement(var10);
            AttributeSet var12 = var11.getAttributes();
            Object var13 = (String)var12.getAttribute(StyleConstants.FontFamily);
            Integer var14 = (Integer)var12.getAttribute(StyleConstants.FontSize);
            String var15 = var13 + var14;
            FontMetrics var16 = (FontMetrics)this.field_1165.get(var15);
            if (var16 == null) {
               Font var17 = new Font((String)var13, 0, var14);
               var16 = this.field_1156.getFontMetrics(var17);
               this.field_1165.put(var15, var16);
            }

            var6 = Math.max(var6, var16.getDescent());
         }
      }

      return var5 - var6;
   }

   @Override
   public void caretUpdate(CaretEvent var1) {
      int var2 = this.field_1156.getCaretPosition();
      Element var3 = this.field_1156.getDocument().getDefaultRootElement();
      int var4 = var3.getElementIndex(var2);
      if (this.field_1164 != var4) {
         this.repaint();
         this.field_1164 = var4;
      }
   }

   @Override
   public void changedUpdate(DocumentEvent var1) {
      this.method_1048();
   }

   @Override
   public void insertUpdate(DocumentEvent var1) {
      this.method_1048();
   }

   @Override
   public void removeUpdate(DocumentEvent var1) {
      this.method_1048();
   }

   // $VF: renamed from: aJ () void
   private void method_1048() {
      SwingUtilities.invokeLater(new class_197(this));
   }

   @Override
   public void propertyChange(PropertyChangeEvent var1) {
      if (var1.getNewValue() instanceof Font) {
         if (this.field_1157) {
            Font var2 = (Font)var1.getNewValue();
            this.setFont(var2);
            this.field_1162 = 0;
            this.method_1043();
         } else {
            this.repaint();
         }
      }
   }
}
