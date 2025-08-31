// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.awt.Dimension;
import java.awt.Image;

public class MultiResolutionImageSupport
{
    public static boolean isAvailable() {
        return false;
    }
    
    public static boolean isMultiResolutionImage(final Image image) {
        return false;
    }
    
    public static Image create(final int baseImageIndex, final Image... resolutionVariants) {
        return resolutionVariants[baseImageIndex];
    }
    
    public static Image create(final int baseImageIndex, final Dimension[] dimensions, final Function<Dimension, Image> producer) {
        return producer.apply(dimensions[baseImageIndex]);
    }
    
    public static Image map(final Image image, final Function<Image, Image> mapper) {
        return mapper.apply(image);
    }
    
    public static Image getResolutionVariant(final Image image, final int destImageWidth, final int destImageHeight) {
        return image;
    }
    
    public static List<Image> getResolutionVariants(final Image image) {
        return Collections.singletonList(image);
    }
}
