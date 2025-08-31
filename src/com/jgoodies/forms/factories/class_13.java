package com.jgoodies.forms.factories;

import com.jgoodies.forms.layout.CellConstraints;
import java.io.Serializable;

// $VF: renamed from: com.jgoodies.forms.factories.CC
public final class class_13 implements Cloneable, Serializable {
   public static final CellConstraints.Alignment DEFAULT = CellConstraints.DEFAULT;
   public static final CellConstraints.Alignment FILL = CellConstraints.FILL;
   public static final CellConstraints.Alignment LEFT = CellConstraints.LEFT;
   public static final CellConstraints.Alignment RIGHT = CellConstraints.RIGHT;
   public static final CellConstraints.Alignment CENTER = CellConstraints.CENTER;
   // $VF: renamed from: TOP com.jgoodies.forms.layout.CellConstraints$Alignment
   public static final CellConstraints.Alignment field_45 = CellConstraints.field_44;
   public static final CellConstraints.Alignment BOTTOM = CellConstraints.BOTTOM;

   // $VF: renamed from: xy (int, int) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_74(int col, int row) {
      return xywh(col, row, 1, 1);
   }

   // $VF: renamed from: xy (int, int, java.lang.String) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_75(int col, int row, String encodedAlignments) {
      return xywh(col, row, 1, 1, encodedAlignments);
   }

   // $VF: renamed from: xy (int, int, com.jgoodies.forms.layout.CellConstraints$Alignment, com.jgoodies.forms.layout.CellConstraints$Alignment) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_76(int col, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
      return xywh(col, row, 1, 1, colAlign, rowAlign);
   }

   // $VF: renamed from: xyw (int, int, int) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_77(int col, int row, int colSpan) {
      return xywh(col, row, colSpan, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
   }

   // $VF: renamed from: xyw (int, int, int, java.lang.String) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_78(int col, int row, int colSpan, String encodedAlignments) {
      return xywh(col, row, colSpan, 1, encodedAlignments);
   }

   // $VF: renamed from: xyw (int, int, int, com.jgoodies.forms.layout.CellConstraints$Alignment, com.jgoodies.forms.layout.CellConstraints$Alignment) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_79(int col, int row, int colSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
      return xywh(col, row, colSpan, 1, colAlign, rowAlign);
   }

   public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan) {
      return xywh(col, row, colSpan, rowSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
   }

   public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan, String encodedAlignments) {
      return new CellConstraints().xywh(col, row, colSpan, rowSpan, encodedAlignments);
   }

   public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
      return new CellConstraints(col, row, colSpan, rowSpan, colAlign, rowAlign);
   }

   // $VF: renamed from: rc (int, int) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_80(int row, int col) {
      return rchw(row, col, 1, 1);
   }

   // $VF: renamed from: rc (int, int, java.lang.String) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_81(int row, int col, String encodedAlignments) {
      return rchw(row, col, 1, 1, encodedAlignments);
   }

   // $VF: renamed from: rc (int, int, com.jgoodies.forms.layout.CellConstraints$Alignment, com.jgoodies.forms.layout.CellConstraints$Alignment) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_82(int row, int col, CellConstraints.Alignment rowAlign, CellConstraints.Alignment colAlign) {
      return rchw(row, col, 1, 1, rowAlign, colAlign);
   }

   // $VF: renamed from: rcw (int, int, int) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_83(int row, int col, int colSpan) {
      return rchw(row, col, 1, colSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
   }

   // $VF: renamed from: rcw (int, int, int, java.lang.String) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_84(int row, int col, int colSpan, String encodedAlignments) {
      return rchw(row, col, 1, colSpan, encodedAlignments);
   }

   // $VF: renamed from: rcw (int, int, int, com.jgoodies.forms.layout.CellConstraints$Alignment, com.jgoodies.forms.layout.CellConstraints$Alignment) com.jgoodies.forms.layout.CellConstraints
   public static CellConstraints method_85(int row, int col, int colSpan, CellConstraints.Alignment rowAlign, CellConstraints.Alignment colAlign) {
      return rchw(row, col, 1, colSpan, rowAlign, colAlign);
   }

   public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan) {
      return rchw(row, col, rowSpan, colSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
   }

   public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan, String encodedAlignments) {
      return new CellConstraints().rchw(row, col, rowSpan, colSpan, encodedAlignments);
   }

   public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan, CellConstraints.Alignment rowAlign, CellConstraints.Alignment colAlign) {
      return xywh(col, row, colSpan, rowSpan, colAlign, rowAlign);
   }
}
