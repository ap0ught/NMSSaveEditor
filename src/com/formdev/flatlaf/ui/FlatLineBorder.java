package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

public class FlatLineBorder extends FlatEmptyBorder {
   private final Color lineColor;
   private final float lineThickness;
   // $VF: renamed from: arc int
   private final int field_46;

   public FlatLineBorder(Insets insets, Color lineColor) {
      this(insets, lineColor, 1.0F, 0);
   }

   public FlatLineBorder(Insets insets, Color lineColor, float lineThickness, int arc) {
      super(insets);
      this.lineColor = lineColor;
      this.lineThickness = lineThickness;
      this.field_46 = arc;
   }

   public Color getLineColor() {
      return this.lineColor;
   }

   public float getLineThickness() {
      return this.lineThickness;
   }

   public int getArc() {
      return this.field_46;
   }

   @Override
   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D)g.create();

      try {
         FlatUIUtils.setRenderingHints(g2);
         FlatUIUtils.paintOutlinedComponent(
            g2,
            x,
            y,
            width,
            height,
            0.0F,
            0.0F,
            0.0F,
            UIScale.scale(this.getLineThickness()),
            (float)UIScale.scale(this.getArc()),
            null,
            this.getLineColor(),
            null
         );
      } finally {
         g2.dispose();
      }
   }
}
