// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.util.function.BiPredicate;

class StackUtilsImpl extends StackUtils
{
    @Override
    boolean wasInvokedFromImpl(final BiPredicate<String, String> predicate, final int limit) {
        int count = -2;
        final StackTraceElement[] stackTrace2;
        final StackTraceElement[] stackTrace = stackTrace2 = Thread.currentThread().getStackTrace();
        for (final StackTraceElement stackTraceElement : stackTrace2) {
            if (predicate.test(stackTraceElement.getClassName(), stackTraceElement.getMethodName())) {
                return true;
            }
            ++count;
            if (limit > 0 && count > limit) {
                return false;
            }
        }
        return false;
    }
}
