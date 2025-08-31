// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.lang.annotation.Repeatable;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import javax.swing.Icon;
import java.beans.PropertyChangeListener;
import javax.swing.border.Border;
import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.reflect.Method;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.function.Predicate;
import java.util.LinkedHashMap;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.SystemInfo;
import java.util.function.BiFunction;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;
import java.util.Iterator;
import java.util.List;
import com.formdev.flatlaf.util.StringUtils;
import javax.swing.JComponent;

public class FlatStylingSupport
{
    public static Object getStyle(final JComponent c) {
        return c.getClientProperty("FlatLaf.style");
    }
    
    public static Object getStyleClass(final JComponent c) {
        return c.getClientProperty("FlatLaf.styleClass");
    }
    
    static boolean hasStyleProperty(final JComponent c) {
        return getStyle(c) != null || getStyleClass(c) != null;
    }
    
    public static Object getResolvedStyle(final JComponent c, final String type) {
        final Object style = getStyle(c);
        final Object styleClass = getStyleClass(c);
        final Object styleForClasses = getStyleForClasses(styleClass, type);
        return joinStyles(styleForClasses, style);
    }
    
    public static Object getStyleForClasses(Object styleClass, final String type) {
        if (styleClass == null) {
            return null;
        }
        if (styleClass instanceof String && ((String)styleClass).indexOf(32) >= 0) {
            styleClass = StringUtils.split((String)styleClass, ' ', true, true);
        }
        if (styleClass instanceof String) {
            return getStyleForClass(((String)styleClass).trim(), type);
        }
        if (styleClass instanceof String[]) {
            Object style = null;
            for (final String cls : (String[])styleClass) {
                style = joinStyles(style, getStyleForClass(cls, type));
            }
            return style;
        }
        if (styleClass instanceof List) {
            Object style = null;
            for (final Object cls2 : (List)styleClass) {
                style = joinStyles(style, getStyleForClass((String)cls2, type));
            }
            return style;
        }
        return null;
    }
    
    private static Object getStyleForClass(final String styleClass, final String type) {
        return joinStyles(UIManager.get("[style]." + styleClass), UIManager.get("[style]" + type + '.' + styleClass));
    }
    
    public static Object joinStyles(final Object style1, final Object style2) {
        if (style1 == null) {
            return style2;
        }
        if (style2 == null) {
            return style1;
        }
        if (style1 instanceof String && style2 instanceof String) {
            return style1 + "; " + style2;
        }
        final Map<String, Object> map1 = (style1 instanceof String) ? parse((String)style1) : style1;
        if (map1 == null) {
            return style2;
        }
        final Map<String, Object> map2 = (style2 instanceof String) ? parse((String)style2) : style2;
        if (map2 == null) {
            return style1;
        }
        final Map<String, Object> map3 = new HashMap<String, Object>(map1);
        map3.putAll(map2);
        return map3;
    }
    
    public static String concatStyles(final String style1, final String style2) {
        if (style1 == null) {
            return style2;
        }
        if (style2 == null) {
            return style1;
        }
        return style1 + "; " + style2;
    }
    
    public static Map<String, Object> parseAndApply(final Map<String, Object> oldStyleValues, final Object style, final BiFunction<String, Object, Object> applyProperty) throws UnknownStyleException, IllegalArgumentException {
        if (oldStyleValues != null) {
            for (final Map.Entry<String, Object> e : oldStyleValues.entrySet()) {
                applyProperty.apply(e.getKey(), e.getValue());
            }
        }
        if (style == null) {
            return null;
        }
        if (style instanceof String) {
            final String str = (String)style;
            if (StringUtils.isTrimmedEmpty(str)) {
                return null;
            }
            return applyStyle(parse(str), applyProperty);
        }
        else {
            if (style instanceof Map) {
                final Map<String, Object> map = (Map<String, Object>)style;
                return applyStyle(map, applyProperty);
            }
            return null;
        }
    }
    
    private static Map<String, Object> applyStyle(final Map<String, Object> style, final BiFunction<String, Object, Object> applyProperty) {
        if (style.isEmpty()) {
            return null;
        }
        final Map<String, Object> oldValues = new HashMap<String, Object>();
        for (final Map.Entry<String, Object> e : style.entrySet()) {
            String key = e.getKey();
            final Object newValue = e.getValue();
            if (key.startsWith("[")) {
                if ((!SystemInfo.isWindows || !key.startsWith("[win]")) && (!SystemInfo.isMacOS || !key.startsWith("[mac]")) && (!SystemInfo.isLinux || !key.startsWith("[linux]")) && (key.startsWith("[light]") || FlatLaf.isLafDark()) && (!key.startsWith("[dark]") || !FlatLaf.isLafDark())) {
                    continue;
                }
                key = key.substring(key.indexOf(93) + 1);
            }
            final Object oldValue = applyProperty.apply(key, newValue);
            oldValues.put(key, oldValue);
        }
        return oldValues;
    }
    
    public static Map<String, Object> parse(final String style) throws IllegalArgumentException {
        if (style == null || StringUtils.isTrimmedEmpty(style)) {
            return null;
        }
        Map<String, Object> map = null;
        for (final String part : StringUtils.split(style, ';', true, true)) {
            final int sepIndex = part.indexOf(58);
            if (sepIndex < 0) {
                throw new IllegalArgumentException("missing colon in '" + part + "'");
            }
            final String key = StringUtils.substringTrimmed(part, 0, sepIndex);
            final String value = StringUtils.substringTrimmed(part, sepIndex + 1);
            if (key.isEmpty()) {
                throw new IllegalArgumentException("missing key in '" + part + "'");
            }
            if (value.isEmpty()) {
                throw new IllegalArgumentException("missing value in '" + part + "'");
            }
            if (map == null) {
                map = new LinkedHashMap<String, Object>();
            }
            map.put(key, parseValue(key, value));
        }
        return map;
    }
    
    private static Object parseValue(String key, final String value) {
        if (value.startsWith("$")) {
            return UIManager.get(value.substring(1));
        }
        if (key.startsWith("[")) {
            key = key.substring(key.indexOf(93) + 1);
        }
        return FlatLaf.parseDefaultsValue(key, value, null);
    }
    
    public static Object applyToAnnotatedObject(final Object obj, final String key, final Object value) throws UnknownStyleException, IllegalArgumentException {
        final String fieldName = keyToFieldName(key);
        return applyToField(obj, fieldName, key, value, field -> {
            final Styleable styleable = field.getAnnotation(Styleable.class);
            final boolean b;
            if (styleable != null) {
                if (styleable.dot() == (fieldName != key)) {
                    return b;
                }
            }
            return b;
        });
    }
    
    private static String keyToFieldName(final String key) {
        final int dotIndex = key.indexOf(46);
        if (dotIndex < 0) {
            return key;
        }
        return key.substring(0, dotIndex) + Character.toUpperCase(key.charAt(dotIndex + 1)) + key.substring(dotIndex + 2);
    }
    
    static Object applyToField(final Object obj, final String fieldName, final String key, final Object value) throws UnknownStyleException, IllegalArgumentException {
        return applyToField(obj, fieldName, key, value, null);
    }
    
    private static Object applyToField(final Object obj, final String fieldName, final String key, final Object value, final Predicate<Field> predicate) throws UnknownStyleException, IllegalArgumentException {
        Class<?> cls = obj.getClass();
        while (true) {
            try {
                final Field f = cls.getDeclaredField(fieldName);
                if (predicate == null || predicate.test(f)) {
                    return applyToField(f, obj, value, false);
                }
            }
            catch (final NoSuchFieldException ex) {}
            for (final StyleableField styleableField : cls.getAnnotationsByType(StyleableField.class)) {
                if (key.equals(styleableField.key())) {
                    return applyToField(getStyleableField(styleableField), obj, value, true);
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                throw new UnknownStyleException(key);
            }
            if (predicate == null) {
                continue;
            }
            final String superclassName = cls.getName();
            if (superclassName.startsWith("java.") || superclassName.startsWith("javax.")) {
                throw new UnknownStyleException(key);
            }
        }
    }
    
    private static Object applyToField(final Field f, final Object obj, final Object value, final boolean useMethodHandles) {
        checkValidField(f);
        if (useMethodHandles && obj instanceof StyleableLookupProvider) {
            try {
                final MethodHandles.Lookup lookup = ((StyleableLookupProvider)obj).getLookupForStyling();
                final Object oldValue = lookup.unreflectGetter(f).invoke(obj);
                lookup.unreflectSetter(f).invoke(obj, convertToEnum(value, f.getType()));
                return oldValue;
            }
            catch (final Throwable ex) {
                throw newFieldAccessFailed(f, ex);
            }
        }
        try {
            f.setAccessible(true);
            final Object oldValue2 = f.get(obj);
            f.set(obj, convertToEnum(value, f.getType()));
            return oldValue2;
        }
        catch (final IllegalAccessException ex2) {
            throw newFieldAccessFailed(f, ex2);
        }
    }
    
    private static Object getFieldValue(final Field f, final Object obj, final boolean useMethodHandles) {
        checkValidField(f);
        if (useMethodHandles && obj instanceof StyleableLookupProvider) {
            try {
                final MethodHandles.Lookup lookup = ((StyleableLookupProvider)obj).getLookupForStyling();
                return lookup.unreflectGetter(f).invoke(obj);
            }
            catch (final Throwable ex) {
                throw newFieldAccessFailed(f, ex);
            }
        }
        try {
            f.setAccessible(true);
            return f.get(obj);
        }
        catch (final IllegalAccessException ex2) {
            throw newFieldAccessFailed(f, ex2);
        }
    }
    
    private static IllegalArgumentException newFieldAccessFailed(final Field f, final Throwable ex) {
        return new IllegalArgumentException("failed to access field '" + f.getDeclaringClass().getName() + "." + f.getName() + "'", ex);
    }
    
    private static void checkValidField(final Field f) {
        if (!isValidField(f)) {
            throw new IllegalArgumentException("field '" + f.getDeclaringClass().getName() + "." + f.getName() + "' is final or static");
        }
    }
    
    private static boolean isValidField(final Field f) {
        final int modifiers = f.getModifiers();
        return (modifiers & 0x18) == 0x0 && !f.isSynthetic();
    }
    
    private static Field getStyleableField(final StyleableField styleableField) {
        String fieldName = styleableField.fieldName();
        if (fieldName.isEmpty()) {
            fieldName = styleableField.key();
        }
        try {
            return styleableField.cls().getDeclaredField(fieldName);
        }
        catch (final NoSuchFieldException ex) {
            throw new IllegalArgumentException("field '" + styleableField.cls().getName() + "." + fieldName + "' not found", ex);
        }
    }
    
    private static Object applyToProperty(final Object obj, final String name, final Object value) throws UnknownStyleException, IllegalArgumentException {
        final Class<?> cls = obj.getClass();
        final String getterName = buildMethodName("get", name);
        final String setterName = buildMethodName("set", name);
        try {
            Method getter;
            try {
                getter = cls.getMethod(getterName, (Class<?>[])new Class[0]);
            }
            catch (final NoSuchMethodException ex) {
                getter = cls.getMethod(buildMethodName("is", name), (Class<?>[])new Class[0]);
            }
            final Method setter = cls.getMethod(setterName, getter.getReturnType());
            final Object oldValue = getter.invoke(obj, new Object[0]);
            setter.invoke(obj, convertToEnum(value, getter.getReturnType()));
            return oldValue;
        }
        catch (final NoSuchMethodException ex2) {
            throw new UnknownStyleException(name);
        }
        catch (final Exception ex3) {
            throw new IllegalArgumentException("failed to invoke property methods '" + cls.getName() + "." + getterName + "()' or '" + setterName + "(...)'", ex3);
        }
    }
    
    private static String buildMethodName(final String prefix, final String name) {
        final int prefixLength = prefix.length();
        final int nameLength = name.length();
        final char[] chars = new char[prefixLength + nameLength];
        prefix.getChars(0, prefixLength, chars, 0);
        name.getChars(0, nameLength, chars, prefixLength);
        chars[prefixLength] = Character.toUpperCase(chars[prefixLength]);
        return new String(chars);
    }
    
    private static Object convertToEnum(Object value, final Class<?> type) throws IllegalArgumentException {
        if (Enum.class.isAssignableFrom(type) && value instanceof String) {
            try {
                value = Enum.valueOf(type, (String)value);
            }
            catch (final IllegalArgumentException ex) {
                throw new IllegalArgumentException("unknown enum value '" + value + "' in enum '" + type.getName() + "'", ex);
            }
        }
        return value;
    }
    
    public static Object applyToAnnotatedObjectOrComponent(final Object obj, final Object comp, final String key, final Object value) throws UnknownStyleException, IllegalArgumentException {
        try {
            return applyToAnnotatedObject(obj, key, value);
        }
        catch (final UnknownStyleException ex) {
            try {
                if (comp != null) {
                    return applyToProperty(comp, key, value);
                }
            }
            catch (final UnknownStyleException ex2) {}
            throw ex;
        }
    }
    
    static Object applyToAnnotatedObjectOrBorder(final Object obj, final String key, final Object value, final JComponent c, final AtomicBoolean borderShared) {
        try {
            return applyToAnnotatedObject(obj, key, value);
        }
        catch (final UnknownStyleException ex) {
            Border border = c.getBorder();
            if (border instanceof StyleableBorder) {
                if (borderShared.get()) {
                    border = cloneBorder(border);
                    c.setBorder(border);
                    borderShared.set(false);
                }
                try {
                    return ((StyleableBorder)border).applyStyleProperty(key, value);
                }
                catch (final UnknownStyleException ex2) {}
            }
            try {
                return applyToProperty(c, key, value);
            }
            catch (final UnknownStyleException ex3) {
                throw ex;
            }
        }
    }
    
    static PropertyChangeListener createPropertyChangeListener(final JComponent c, final Runnable installStyle, final PropertyChangeListener superListener) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* installStyle */
        //     2: aload_0         /* c */
        //     3: invokedynamic   BootstrapMethod #1, propertyChange:(Ljava/beans/PropertyChangeListener;Ljava/lang/Runnable;Ljavax/swing/JComponent;)Ljava/beans/PropertyChangeListener;
        //     8: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot invoke "com.strobel.assembler.metadata.TypeReference.getSimpleType()" because the return value of "com.strobel.decompiler.ast.Variable.getType()" is null
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:252)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:185)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.nameVariables(AstMethodBodyBuilder.java:1482)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.populateVariables(AstMethodBodyBuilder.java:1411)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:334)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:255)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:130)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Border cloneBorder(final Border border) {
        final Class<? extends Border> borderClass = border.getClass();
        try {
            return (Border)borderClass.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            throw new IllegalArgumentException("failed to clone border '" + borderClass.getName() + "'", ex);
        }
    }
    
    static Icon cloneIcon(final Icon icon) {
        final Class<? extends Icon> iconClass = icon.getClass();
        try {
            return (Icon)iconClass.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            throw new IllegalArgumentException("failed to clone icon '" + iconClass.getName() + "'", ex);
        }
    }
    
    public static Map<String, Class<?>> getAnnotatedStyleableInfos(final Object obj) {
        return getAnnotatedStyleableInfos(obj, null);
    }
    
    public static Map<String, Class<?>> getAnnotatedStyleableInfos(final Object obj, final Border border) {
        final Map<String, Class<?>> infos = new StyleableInfosMap<String, Class<?>>();
        collectAnnotatedStyleableInfos(obj, infos);
        collectStyleableInfos(border, infos);
        return infos;
    }
    
    public static void collectAnnotatedStyleableInfos(final Object obj, final Map<String, Class<?>> infos) {
        final HashSet<String> processedFields = new HashSet<String>();
        Class<?> cls = obj.getClass();
        while (true) {
            for (final Field f : cls.getDeclaredFields()) {
                if (isValidField(f)) {
                    final Styleable styleable = f.getAnnotation(Styleable.class);
                    if (styleable != null) {
                        String name = f.getName();
                        Class<?> type = f.getType();
                        if (!processedFields.contains(name)) {
                            processedFields.add(name);
                            if (styleable.dot()) {
                                for (int len = name.length(), i = 0; i < len; ++i) {
                                    if (Character.isUpperCase(name.charAt(i))) {
                                        name = name.substring(0, i) + '.' + Character.toLowerCase(name.charAt(i)) + name.substring(i + 1);
                                        break;
                                    }
                                }
                            }
                            if (styleable.type() != Void.class) {
                                type = styleable.type();
                            }
                            infos.put(name, type);
                        }
                    }
                }
            }
            for (final StyleableField styleableField : cls.getAnnotationsByType(StyleableField.class)) {
                final String name2 = styleableField.key();
                if (!processedFields.contains(name2)) {
                    processedFields.add(name2);
                    final Field f2 = getStyleableField(styleableField);
                    infos.put(name2, f2.getType());
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return;
            }
            final String superclassName = cls.getName();
            if (superclassName.startsWith("java.") || superclassName.startsWith("javax.")) {
                return;
            }
        }
    }
    
    public static void collectStyleableInfos(final Border border, final Map<String, Class<?>> infos) {
        if (border instanceof StyleableBorder) {
            infos.putAll(((StyleableBorder)border).getStyleableInfos());
        }
    }
    
    public static void putAllPrefixKey(final Map<String, Class<?>> infos, final String keyPrefix, final Map<String, Class<?>> infos2) {
        for (final Map.Entry<String, Class<?>> e : infos2.entrySet()) {
            infos.put(keyPrefix.concat(e.getKey()), e.getValue());
        }
    }
    
    public static Object getAnnotatedStyleableValue(final Object obj, final String key) {
        final String fieldName = keyToFieldName(key);
        Class<?> cls = obj.getClass();
        while (true) {
            try {
                final Field f = cls.getDeclaredField(fieldName);
                final Styleable styleable = f.getAnnotation(Styleable.class);
                if (styleable != null) {
                    if (styleable.dot() != (fieldName != key)) {
                        throw new IllegalArgumentException("'Styleable.dot' on field '" + fieldName + "' does not match key '" + key + "'");
                    }
                    if (styleable.type() != Void.class) {
                        throw new IllegalArgumentException("'Styleable.type' on field '" + fieldName + "' not supported");
                    }
                    return getFieldValue(f, obj, false);
                }
            }
            catch (final NoSuchFieldException ex) {}
            for (final StyleableField styleableField : cls.getAnnotationsByType(StyleableField.class)) {
                if (key.equals(styleableField.key())) {
                    return getFieldValue(getStyleableField(styleableField), obj, true);
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return null;
            }
            final String superclassName = cls.getName();
            if (superclassName.startsWith("java.") || superclassName.startsWith("javax.")) {
                return null;
            }
        }
    }
    
    public static Object getAnnotatedStyleableValue(final Object obj, final Border border, final String key) {
        if (border instanceof StyleableBorder) {
            final Object value = ((StyleableBorder)border).getStyleableValue(key);
            if (value != null) {
                return value;
            }
        }
        return getAnnotatedStyleableValue(obj, key);
    }
    
    public static class UnknownStyleException extends IllegalArgumentException
    {
        public UnknownStyleException(final String key) {
            super(key);
        }
        
        @Override
        public String getMessage() {
            return "unknown style '" + super.getMessage() + "'";
        }
    }
    
    static class StyleableInfosMap<K, V> extends LinkedHashMap<K, V>
    {
        @Override
        public V put(final K key, final V value) {
            final V oldValue = super.put(key, value);
            if (oldValue != null) {
                throw new IllegalArgumentException("duplicate key '" + key + "'");
            }
            return oldValue;
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> m) {
            for (final Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                this.put(e.getKey(), e.getValue());
            }
        }
    }
    
    public interface StyleableLookupProvider
    {
        MethodHandles.Lookup getLookupForStyling();
    }
    
    public interface StyleableBorder
    {
        Object applyStyleProperty(final String p0, final Object p1);
        
        Map<String, Class<?>> getStyleableInfos();
        
        Object getStyleableValue(final String p0);
    }
    
    public interface StyleableUI
    {
        Map<String, Class<?>> getStyleableInfos(final JComponent p0);
        
        Object getStyleableValue(final JComponent p0, final String p1);
    }
    
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StyleableFields {
        StyleableField[] value();
    }
    
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(StyleableFields.class)
    public @interface StyleableField {
        Class<?> cls();
        
        String key();
        
        String fieldName() default "";
    }
    
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Styleable {
        boolean dot() default false;
        
        Class<?> type() default Void.class;
    }
}
