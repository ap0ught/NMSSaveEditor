package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.MultiResolutionImageSupport;
import com.formdev.flatlaf.util.ScaledImageIcon;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class FlatTitlePaneIcon extends ScaledImageIcon {
   private final List<Image> images;

   public FlatTitlePaneIcon(List<Image> images, Dimension size) {
      super(null, size.width, size.height);
      this.images = images;
   }

   @Override
   protected Image getResolutionVariant(int destImageWidth, int destImageHeight) {
      List<Image> allImages = new ArrayList<>();

      for (Image image : this.images) {
         if (MultiResolutionImageSupport.isMultiResolutionImage(image)) {
            allImages.add(MultiResolutionImageSupport.getResolutionVariant(image, destImageWidth, destImageHeight));
         } else {
            allImages.add(image);
         }
      }

      if (allImages.size() == 1) {
         return allImages.get(0);
      } else {
         allImages.sort((image1, image2) -> image1.getWidth(null) - image2.getWidth(null));

         for (Image imagex : allImages) {
            if (destImageWidth <= imagex.getWidth(null) && destImageHeight <= imagex.getHeight(null)) {
               return imagex;
            }
         }

         return allImages.get(allImages.size() - 1);
      }
   }
}
