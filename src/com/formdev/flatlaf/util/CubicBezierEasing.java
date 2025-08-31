package com.formdev.flatlaf.util;

public class CubicBezierEasing implements Animator.Interpolator {
   public static final CubicBezierEasing STANDARD_EASING = new CubicBezierEasing(0.4F, 0.0F, 0.2F, 1.0F);
   public static final CubicBezierEasing EASE = new CubicBezierEasing(0.25F, 0.1F, 0.25F, 1.0F);
   public static final CubicBezierEasing EASE_IN = new CubicBezierEasing(0.42F, 0.0F, 1.0F, 1.0F);
   public static final CubicBezierEasing EASE_IN_OUT = new CubicBezierEasing(0.42F, 0.0F, 0.58F, 1.0F);
   public static final CubicBezierEasing EASE_OUT = new CubicBezierEasing(0.0F, 0.0F, 0.58F, 1.0F);
   // $VF: renamed from: x1 float
   private final float field_6;
   // $VF: renamed from: y1 float
   private final float field_7;
   // $VF: renamed from: x2 float
   private final float field_8;
   // $VF: renamed from: y2 float
   private final float field_9;

   public CubicBezierEasing(float x1, float y1, float x2, float y2) {
      if (!(x1 < 0.0F) && !(x1 > 1.0F) && !(y1 < 0.0F) && !(y1 > 1.0F) && !(x2 < 0.0F) && !(x2 > 1.0F) && !(y2 < 0.0F) && !(y2 > 1.0F)) {
         this.field_6 = x1;
         this.field_7 = y1;
         this.field_8 = x2;
         this.field_9 = y2;
      } else {
         throw new IllegalArgumentException("control points must be in range [0, 1]");
      }
   }

   @Override
   public float interpolate(float fraction) {
      if (!(fraction <= 0.0F) && !(fraction >= 1.0F)) {
         float low = 0.0F;
         float high = 1.0F;

         while (true) {
            float mid = (low + high) / 2.0F;
            float estimate = cubicBezier(mid, this.field_6, this.field_8);
            if (Math.abs(fraction - estimate) < 5.0E-4F) {
               return cubicBezier(mid, this.field_7, this.field_9);
            }

            if (estimate < fraction) {
               low = mid;
            } else {
               high = mid;
            }
         }
      } else {
         return fraction;
      }
   }

   private static float cubicBezier(float t, float xy1, float xy2) {
      float invT = 1.0F - t;
      float b1 = 3.0F * t * invT * invT;
      float b2 = 3.0F * t * t * invT;
      float b3 = t * t * t;
      return b1 * xy1 + b2 * xy2 + b3;
   }
}
