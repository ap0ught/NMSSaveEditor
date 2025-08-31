package com.formdev.flatlaf.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.function.Function;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.TableUI;

public class FlatTableCellBorder extends FlatLineBorder {
   protected boolean showCellFocusIndicator = UIManager.getBoolean("Table.showCellFocusIndicator");
   private Component c;

   protected FlatTableCellBorder() {
      super(UIManager.getInsets("Table.cellMargins"), UIManager.getColor("Table.cellFocusColor"));
   }

   @Override
   public Insets getBorderInsets(Component c, Insets insets) {
      Insets m = getStyleFromTableUI(c, ui -> ui.cellMargins);
      return m != null ? scaleInsets(c, insets, m.top, m.left, m.bottom, m.right) : super.getBorderInsets(c, insets);
   }

   @Override
   public Color getLineColor() {
      if (this.c != null) {
         Color color = getStyleFromTableUI(this.c, ui -> ui.cellFocusColor);
         if (color != null) {
            return color;
         }
      }

      return super.getLineColor();
   }

   @Override
   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      this.c = c;
      super.paintBorder(c, g, x, y, width, height);
      this.c = null;
   }

   static <T> T getStyleFromTableUI(Component c, Function<FlatTableUI, T> f) {
      JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
      if (table != null) {
         TableUI ui = table.getUI();
         if (ui instanceof FlatTableUI) {
            return f.apply((FlatTableUI)ui);
         }
      }

      return null;
   }

   public static class Default extends FlatTableCellBorder {
      @Override
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      }
   }

   public static class Focused extends FlatTableCellBorder {
      @Override
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         if (c != null && c.getClass().getName().equals("javax.swing.JTable$BooleanRenderer")) {
            JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
            if (table != null && c.getForeground() == table.getSelectionForeground() && c.getBackground() == table.getSelectionBackground()) {
               Border border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder");
               if (border != null) {
                  border.paintBorder(c, g, x, y, width, height);
                  return;
               }
            }
         }

         super.paintBorder(c, g, x, y, width, height);
      }
   }

   public static class Selected extends FlatTableCellBorder {
      public int maxCheckCellsEditable = 50;

      @Override
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         Boolean b = getStyleFromTableUI(c, ui -> ui.showCellFocusIndicator);
         boolean showCellFocusIndicator = b != null ? b : this.showCellFocusIndicator;
         if (!showCellFocusIndicator) {
            JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
            if (table != null && !this.shouldShowCellFocusIndicator(table)) {
               return;
            }
         }

         super.paintBorder(c, g, x, y, width, height);
      }

      protected boolean shouldShowCellFocusIndicator(JTable table) {
         boolean rowSelectionAllowed = table.getRowSelectionAllowed();
         boolean columnSelectionAllowed = table.getColumnSelectionAllowed();
         if (rowSelectionAllowed && columnSelectionAllowed) {
            return false;
         } else {
            if (rowSelectionAllowed) {
               if (table.getSelectedRowCount() != 1) {
                  return false;
               }

               int columnCount = table.getColumnCount();
               if (columnCount > this.maxCheckCellsEditable) {
                  return true;
               }

               int selectedRow = table.getSelectedRow();

               for (int column = 0; column < columnCount; column++) {
                  if (table.isCellEditable(selectedRow, column)) {
                     return true;
                  }
               }
            } else if (columnSelectionAllowed) {
               if (table.getSelectedColumnCount() != 1) {
                  return false;
               }

               int rowCount = table.getRowCount();
               if (rowCount > this.maxCheckCellsEditable) {
                  return true;
               }

               int selectedColumn = table.getSelectedColumn();

               for (int row = 0; row < rowCount; row++) {
                  if (table.isCellEditable(row, selectedColumn)) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }
}
