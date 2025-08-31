// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf;

import java.util.Hashtable;
import com.formdev.flatlaf.util.GrayFilter;
import com.formdev.flatlaf.util.UIScale;
import java.util.Collection;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import com.formdev.flatlaf.util.DerivedColor;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.HSLColor;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;
import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.util.Locale;
import com.formdev.flatlaf.util.StringUtils;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.border.Border;
import java.util.Collections;
import java.awt.Color;
import javax.swing.UIManager;
import java.io.InputStream;
import java.util.Iterator;
import java.io.IOException;
import com.formdev.flatlaf.util.LoggingFacade;
import java.util.function.Function;
import com.formdev.flatlaf.util.SystemInfo;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.UIDefaults;
import java.util.Properties;
import java.util.List;
import com.formdev.flatlaf.util.SoftCache;
import javax.swing.plaf.ColorUIResource;
import java.util.Map;

class UIDefaultsLoader
{
    private static final String TYPE_PREFIX = "{";
    private static final String TYPE_PREFIX_END = "}";
    private static final String VARIABLE_PREFIX = "@";
    private static final String PROPERTY_PREFIX = "$";
    private static final String OPTIONAL_PREFIX = "?";
    private static final String WILDCARD_PREFIX = "*.";
    static final String KEY_VARIABLES = "FlatLaf.internal.variables";
    private static int parseColorDepth;
    private static Map<String, ColorUIResource> systemColorCache;
    private static final SoftCache<String, Object> fontCache;
    private static final ValueType[] tempResultValueType;
    private static Map<Class<?>, ValueType> javaValueTypes;
    private static Map<String, ValueType> knownValueTypes;
    
    static void loadDefaultsFromProperties(final Class<?> lookAndFeelClass, final List<FlatDefaultsAddon> addons, final Properties additionalDefaults, final boolean dark, final UIDefaults defaults) {
        final ArrayList<Class<?>> lafClasses = new ArrayList<Class<?>>();
        for (Class<?> lafClass = lookAndFeelClass; FlatLaf.class.isAssignableFrom(lafClass); lafClass = lafClass.getSuperclass()) {
            lafClasses.add(0, lafClass);
        }
        loadDefaultsFromProperties(lafClasses, addons, additionalDefaults, dark, defaults);
    }
    
    static void loadDefaultsFromProperties(final List<Class<?>> lafClasses, final List<FlatDefaultsAddon> addons, final Properties additionalDefaults, final boolean dark, final UIDefaults defaults) {
        try {
            UIDefaultsLoader.systemColorCache = ((FlatLaf.getSystemColorGetter() != null) ? new HashMap<String, ColorUIResource>() : null);
            final Properties properties = new Properties();
            for (final Class<?> lafClass : lafClasses) {
                final String propertiesName = '/' + lafClass.getName().replace('.', '/') + ".properties";
                try (final InputStream in = lafClass.getResourceAsStream(propertiesName)) {
                    if (in != null) {
                        properties.load(in);
                    }
                    if (in == null) {
                        continue;
                    }
                }
            }
            for (final FlatDefaultsAddon addon : addons) {
                for (final Class<?> lafClass2 : lafClasses) {
                    try (final InputStream in2 = addon.getDefaults(lafClass2)) {
                        if (in2 != null) {
                            properties.load(in2);
                        }
                        if (in2 == null) {
                            continue;
                        }
                    }
                }
            }
            final List<ClassLoader> addonClassLoaders = new ArrayList<ClassLoader>();
            for (final FlatDefaultsAddon addon2 : addons) {
                final ClassLoader addonClassLoader = addon2.getClass().getClassLoader();
                if (!addonClassLoaders.contains(addonClassLoader)) {
                    addonClassLoaders.add(addonClassLoader);
                }
            }
            final List<Object> customDefaultsSources = FlatLaf.getCustomDefaultsSources();
            for (int size = (customDefaultsSources != null) ? customDefaultsSources.size() : 0, i = 0; i < size; ++i) {
                final Object source = customDefaultsSources.get(i);
                if (source instanceof String && i + 1 < size) {
                    String packageName = (String)source;
                    ClassLoader classLoader = customDefaultsSources.get(++i);
                    if (classLoader != null && !addonClassLoaders.contains(classLoader)) {
                        addonClassLoaders.add(classLoader);
                    }
                    packageName = packageName.replace('.', '/');
                    if (classLoader == null) {
                        classLoader = FlatLaf.class.getClassLoader();
                    }
                    for (final Class<?> lafClass3 : lafClasses) {
                        final String propertiesName2 = packageName + '/' + lafClass3.getSimpleName() + ".properties";
                        try (final InputStream in3 = classLoader.getResourceAsStream(propertiesName2)) {
                            if (in3 != null) {
                                properties.load(in3);
                            }
                            if (in3 == null) {
                                continue;
                            }
                        }
                    }
                }
                else if (source instanceof URL) {
                    final URL packageUrl = (URL)source;
                    for (final Class<?> lafClass4 : lafClasses) {
                        final URL propertiesUrl = new URL(packageUrl + lafClass4.getSimpleName() + ".properties");
                        try (final InputStream in4 = propertiesUrl.openStream()) {
                            properties.load(in4);
                            if (in4 == null) {
                                continue;
                            }
                        }
                        catch (final FileNotFoundException ex3) {}
                    }
                }
                else if (source instanceof File) {
                    final File folder = (File)source;
                    for (final Class<?> lafClass4 : lafClasses) {
                        final File propertiesFile = new File(folder, lafClass4.getSimpleName() + ".properties");
                        if (!propertiesFile.isFile()) {
                            continue;
                        }
                        try (final InputStream in4 = new FileInputStream(propertiesFile)) {
                            properties.load(in4);
                        }
                    }
                }
            }
            if (additionalDefaults != null) {
                properties.putAll(additionalDefaults);
            }
            final ArrayList<String> platformSpecificKeys = new ArrayList<String>();
            String key = null;
            for (final Object okey : properties.keySet()) {
                key = (String)okey;
                if (key.startsWith("[") && (key.startsWith("[win]") || key.startsWith("[mac]") || key.startsWith("[linux]") || key.startsWith("[light]") || key.startsWith("[dark]"))) {
                    platformSpecificKeys.add(key);
                }
            }
            Object value = null;
            if (!platformSpecificKeys.isEmpty()) {
                final String lightOrDarkPrefix = dark ? "[dark]" : "[light]";
                final Iterator<String> iterator9 = platformSpecificKeys.iterator();
                while (iterator9.hasNext()) {
                    key = iterator9.next();
                    if (key.startsWith(lightOrDarkPrefix)) {
                        properties.put(key.substring(lightOrDarkPrefix.length()), properties.remove(key));
                    }
                }
                final String platformPrefix = SystemInfo.isWindows ? "[win]" : (SystemInfo.isMacOS ? "[mac]" : (SystemInfo.isLinux ? "[linux]" : "[unknown]"));
                for (final String key2 : platformSpecificKeys) {
                    value = properties.remove(key2);
                    if (key2.startsWith(platformPrefix)) {
                        properties.put(key2.substring(platformPrefix.length()), value);
                    }
                }
            }
            final HashMap<String, String> wildcards = new HashMap<String, String>();
            final Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
            while (it.hasNext()) {
                final Map.Entry<Object, Object> e = it.next();
                final String key2 = e.getKey();
                if (key2.startsWith("*.")) {
                    wildcards.put(key2.substring("*.".length()), e.getValue());
                    it.remove();
                }
            }
            for (final Object key3 : ((Hashtable<Object, V>)defaults).keySet()) {
                if (key3 instanceof String && !properties.containsKey(key3)) {
                    final int dot;
                    if ((dot = ((String)key3).lastIndexOf(46)) < 0) {
                        continue;
                    }
                    final String wildcardKey = ((String)key3).substring(dot + 1);
                    final String wildcardValue = wildcards.get(wildcardKey);
                    if (wildcardValue == null) {
                        continue;
                    }
                    properties.put(key3, wildcardValue);
                }
            }
            final Function<String, String> propertiesGetter = (Function<String, String>)(key -> properties.getProperty(key));
            final Function<String, String> resolver = (Function<String, String>)(value -> resolveValue(value, propertiesGetter));
            final Map<String, String> variables = new HashMap<String, String>(50);
            for (final Map.Entry<Object, Object> e2 : properties.entrySet()) {
                final String key4 = e2.getKey();
                if (key4.startsWith("@")) {
                    variables.put(key4, e2.getValue());
                }
                else {
                    final String value2 = resolveValue(e2.getValue(), propertiesGetter);
                    try {
                        defaults.put(key4, parseValue(key4, value2, null, null, resolver, addonClassLoaders));
                    }
                    catch (final RuntimeException ex) {
                        logParseError(key4, value2, ex, true);
                    }
                }
            }
            defaults.put("FlatLaf.internal.variables", variables);
            UIDefaultsLoader.systemColorCache = null;
        }
        catch (final IOException ex2) {
            LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to load properties files.", ex2);
        }
    }
    
    static void logParseError(final String key, final String value, final RuntimeException ex, final boolean severe) {
        final String message = "FlatLaf: Failed to parse: '" + key + '=' + value + '\'';
        if (severe) {
            LoggingFacade.INSTANCE.logSevere(message, ex);
        }
        else {
            LoggingFacade.INSTANCE.logConfig(message, ex);
        }
    }
    
    static String resolveValue(String value, final Function<String, String> propertiesGetter) {
        final String value2;
        value = (value2 = value.trim());
        if (value.startsWith("$")) {
            value = value.substring("$".length());
        }
        else if (!value.startsWith("@")) {
            return value;
        }
        boolean optional = false;
        if (value.startsWith("?")) {
            value = value.substring("?".length());
            optional = true;
        }
        final String newValue = propertiesGetter.apply(value);
        if (newValue == null) {
            if (optional) {
                return "null";
            }
            throw new IllegalArgumentException("variable or property '" + value + "' not found");
        }
        else {
            if (newValue.equals(value2)) {
                throw new IllegalArgumentException("endless recursion in variable or property '" + value + "'");
            }
            return resolveValue(newValue, propertiesGetter);
        }
    }
    
    static String resolveValueFromUIManager(final String value) {
        if (value.startsWith("@")) {
            final Map<String, String> variables = (Map<String, String>)UIManager.get("FlatLaf.internal.variables");
            final String newValue = (variables != null) ? variables.get(value) : null;
            if (newValue == null) {
                throw new IllegalArgumentException("variable '" + value + "' not found");
            }
            return resolveValueFromUIManager(newValue);
        }
        else {
            if (!value.startsWith("$")) {
                return value;
            }
            final String key = value.substring("$".length());
            final Object newValue2 = UIManager.get(key);
            if (newValue2 == null) {
                throw new IllegalArgumentException("property '" + key + "' not found");
            }
            if (newValue2 instanceof Color) {
                final Color color = (Color)newValue2;
                final int alpha = color.getAlpha();
                return String.format((alpha != 255) ? "#%06x%02x" : "#%06x", color.getRGB() & 0xFFFFFF, alpha);
            }
            throw new IllegalArgumentException("property value type '" + newValue2.getClass().getName() + "' not supported in references");
        }
    }
    
    static Object parseValue(final String key, final String value, final Class<?> valueType) {
        return parseValue(key, value, valueType, (ValueType[])null, v -> v, Collections.emptyList());
    }
    
    static Object parseValue(final String key, String value, final Class<?> javaValueType, ValueType[] resultValueType, final Function<String, String> resolver, final List<ClassLoader> addonClassLoaders) {
        if (resultValueType == null) {
            resultValueType = UIDefaultsLoader.tempResultValueType;
        }
        if (key.startsWith("[style]")) {
            resultValueType[0] = ValueType.STRING;
            return value;
        }
        value = value.trim();
        if (value.equals("null") || value.isEmpty()) {
            resultValueType[0] = ValueType.NULL;
            return null;
        }
        if (value.startsWith("if(") && value.endsWith(")")) {
            final List<String> params = splitFunctionParams(value.substring(3, value.length() - 1), ',');
            if (params.size() != 3) {
                throwMissingParametersException(value);
            }
            final boolean ifCondition = parseCondition(params.get(0), resolver, addonClassLoaders);
            final String ifValue = params.get(ifCondition ? 1 : 2);
            return parseValue(key, resolver.apply(ifValue), javaValueType, resultValueType, resolver, addonClassLoaders);
        }
        ValueType valueType = ValueType.UNKNOWN;
        if (javaValueType != null) {
            if (UIDefaultsLoader.javaValueTypes == null) {
                (UIDefaultsLoader.javaValueTypes = new HashMap<Class<?>, ValueType>()).put(String.class, ValueType.STRING);
                UIDefaultsLoader.javaValueTypes.put(Boolean.TYPE, ValueType.BOOLEAN);
                UIDefaultsLoader.javaValueTypes.put(Boolean.class, ValueType.BOOLEAN);
                UIDefaultsLoader.javaValueTypes.put(Character.TYPE, ValueType.CHARACTER);
                UIDefaultsLoader.javaValueTypes.put(Character.class, ValueType.CHARACTER);
                UIDefaultsLoader.javaValueTypes.put(Integer.TYPE, ValueType.INTEGER);
                UIDefaultsLoader.javaValueTypes.put(Integer.class, ValueType.INTEGER);
                UIDefaultsLoader.javaValueTypes.put(Float.TYPE, ValueType.FLOAT);
                UIDefaultsLoader.javaValueTypes.put(Float.class, ValueType.FLOAT);
                UIDefaultsLoader.javaValueTypes.put(Border.class, ValueType.BORDER);
                UIDefaultsLoader.javaValueTypes.put(Icon.class, ValueType.ICON);
                UIDefaultsLoader.javaValueTypes.put(Insets.class, ValueType.INSETS);
                UIDefaultsLoader.javaValueTypes.put(Dimension.class, ValueType.DIMENSION);
                UIDefaultsLoader.javaValueTypes.put(Color.class, ValueType.COLOR);
                UIDefaultsLoader.javaValueTypes.put(Font.class, ValueType.FONT);
            }
            valueType = UIDefaultsLoader.javaValueTypes.get(javaValueType);
            if (valueType == null) {
                throw new IllegalArgumentException("unsupported value type '" + javaValueType.getName() + "'");
            }
            if (valueType == ValueType.STRING && value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
        }
        else {
            final String s = value;
            switch (s) {
                case "false": {
                    resultValueType[0] = ValueType.BOOLEAN;
                    return false;
                }
                case "true": {
                    resultValueType[0] = ValueType.BOOLEAN;
                    return true;
                }
                default: {
                    if (value.startsWith("lazy(") && value.endsWith(")")) {
                        resultValueType[0] = ValueType.LAZY;
                        final String uiKey = StringUtils.substringTrimmed(value, 5, value.length() - 1);
                        return t -> lazyUIManagerGet(uiKey);
                    }
                    if (value.startsWith("#")) {
                        valueType = ValueType.COLOR;
                    }
                    else if (value.startsWith("{")) {
                        final int end = value.indexOf("}");
                        if (end != -1) {
                            try {
                                final String typeStr = value.substring("{".length(), end);
                                valueType = ValueType.valueOf(typeStr.toUpperCase(Locale.ENGLISH));
                                value = value.substring(end + "}".length());
                            }
                            catch (final IllegalArgumentException ex) {}
                        }
                    }
                    if (valueType == ValueType.UNKNOWN) {
                        if (UIDefaultsLoader.knownValueTypes == null) {
                            (UIDefaultsLoader.knownValueTypes = new HashMap<String, ValueType>()).put("activeCaptionBorder", ValueType.COLOR);
                            UIDefaultsLoader.knownValueTypes.put("inactiveCaptionBorder", ValueType.COLOR);
                            UIDefaultsLoader.knownValueTypes.put("windowBorder", ValueType.COLOR);
                            UIDefaultsLoader.knownValueTypes.put("SplitPane.dividerSize", ValueType.INTEGER);
                            UIDefaultsLoader.knownValueTypes.put("SplitPaneDivider.gripDotSize", ValueType.INTEGER);
                            UIDefaultsLoader.knownValueTypes.put("dividerSize", ValueType.INTEGER);
                            UIDefaultsLoader.knownValueTypes.put("gripDotSize", ValueType.INTEGER);
                            UIDefaultsLoader.knownValueTypes.put("TabbedPane.closeCrossPlainSize", ValueType.FLOAT);
                            UIDefaultsLoader.knownValueTypes.put("TabbedPane.closeCrossFilledSize", ValueType.FLOAT);
                            UIDefaultsLoader.knownValueTypes.put("closeCrossPlainSize", ValueType.FLOAT);
                            UIDefaultsLoader.knownValueTypes.put("closeCrossFilledSize", ValueType.FLOAT);
                            UIDefaultsLoader.knownValueTypes.put("Table.intercellSpacing", ValueType.DIMENSION);
                            UIDefaultsLoader.knownValueTypes.put("intercellSpacing", ValueType.DIMENSION);
                        }
                        valueType = UIDefaultsLoader.knownValueTypes.getOrDefault(key, ValueType.UNKNOWN);
                    }
                    if (valueType != ValueType.UNKNOWN) {
                        break;
                    }
                    if (key.endsWith("UI")) {
                        valueType = ValueType.STRING;
                        break;
                    }
                    if (key.endsWith("Color") || (key.endsWith("ground") && (key.endsWith(".background") || key.endsWith("Background") || key.equals("background") || key.endsWith(".foreground") || key.endsWith("Foreground") || key.equals("foreground")))) {
                        valueType = ValueType.COLOR;
                        break;
                    }
                    if (key.endsWith(".font") || key.endsWith("Font") || key.equals("font")) {
                        valueType = ValueType.FONT;
                        break;
                    }
                    if (key.endsWith(".border") || key.endsWith("Border") || key.equals("border")) {
                        valueType = ValueType.BORDER;
                        break;
                    }
                    if (key.endsWith(".icon") || key.endsWith("Icon") || key.equals("icon")) {
                        valueType = ValueType.ICON;
                        break;
                    }
                    if (key.endsWith(".margin") || key.equals("margin") || key.endsWith(".padding") || key.equals("padding") || key.endsWith("Margins") || key.endsWith("Insets")) {
                        valueType = ValueType.INSETS;
                        break;
                    }
                    if (key.endsWith("Size")) {
                        valueType = ValueType.DIMENSION;
                        break;
                    }
                    if (key.endsWith("Width") || key.endsWith("Height")) {
                        valueType = ValueType.INTEGERORFLOAT;
                        break;
                    }
                    if (key.endsWith("Char")) {
                        valueType = ValueType.CHARACTER;
                        break;
                    }
                    if (key.endsWith("grayFilter")) {
                        valueType = ValueType.GRAYFILTER;
                        break;
                    }
                    break;
                }
            }
        }
        resultValueType[0] = valueType;
        switch (valueType) {
            case STRING: {
                return value;
            }
            case BOOLEAN: {
                return parseBoolean(value);
            }
            case CHARACTER: {
                return parseCharacter(value);
            }
            case INTEGER: {
                return parseInteger(value);
            }
            case INTEGERORFLOAT: {
                return parseIntegerOrFloat(value);
            }
            case FLOAT: {
                return parseFloat(value);
            }
            case BORDER: {
                return parseBorder(value, resolver, addonClassLoaders);
            }
            case ICON: {
                return parseInstance(value, addonClassLoaders);
            }
            case INSETS: {
                return parseInsets(value);
            }
            case DIMENSION: {
                return parseDimension(value);
            }
            case COLOR: {
                return parseColorOrFunction(value, resolver);
            }
            case FONT: {
                return parseFont(value);
            }
            case SCALEDINTEGER: {
                return parseScaledInteger(value);
            }
            case SCALEDFLOAT: {
                return parseScaledFloat(value);
            }
            case SCALEDINSETS: {
                return parseScaledInsets(value);
            }
            case SCALEDDIMENSION: {
                return parseScaledDimension(value);
            }
            case INSTANCE: {
                return parseInstance(value, addonClassLoaders);
            }
            case CLASS: {
                return parseClass(value, addonClassLoaders);
            }
            case GRAYFILTER: {
                return parseGrayFilter(value);
            }
            default: {
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    resultValueType[0] = ValueType.STRING;
                    return value.substring(1, value.length() - 1);
                }
                if (value.startsWith("#") || value.endsWith(")")) {
                    final Object color = parseColorOrFunction(value, resolver);
                    resultValueType[0] = ((color != null) ? ValueType.COLOR : ValueType.NULL);
                    return color;
                }
                final char firstChar = value.charAt(0);
                Label_1686: {
                    if ((firstChar < '0' || firstChar > '9') && firstChar != '-' && firstChar != '+') {
                        if (firstChar != '.') {
                            break Label_1686;
                        }
                    }
                    try {
                        final Integer integer = parseInteger(value);
                        resultValueType[0] = ValueType.INTEGER;
                        return integer;
                    }
                    catch (final NumberFormatException ex2) {
                        try {
                            final Float f = parseFloat(value);
                            resultValueType[0] = ValueType.FLOAT;
                            return f;
                        }
                        catch (final NumberFormatException ex3) {}
                    }
                }
                resultValueType[0] = ValueType.STRING;
                return value;
            }
        }
    }
    
    private static boolean parseCondition(final String condition, final Function<String, String> resolver, final List<ClassLoader> addonClassLoaders) {
        try {
            final Object conditionValue = parseValue("", resolver.apply(condition), null, null, resolver, addonClassLoaders);
            return conditionValue != null && !conditionValue.equals(false) && !conditionValue.equals(0);
        }
        catch (final IllegalArgumentException ex) {
            return false;
        }
    }
    
    private static Object parseBorder(final String value, final Function<String, String> resolver, final List<ClassLoader> addonClassLoaders) {
        if (value.indexOf(44) >= 0) {
            final List<String> parts = splitFunctionParams(value, ',');
            final Insets insets = parseInsets(value);
            final ColorUIResource lineColor = (parts.size() >= 5) ? ((ColorUIResource)parseColorOrFunction(resolver.apply(parts.get(4)), resolver)) : null;
            final float lineThickness = (parts.size() >= 6 && !parts.get(5).isEmpty()) ? parseFloat(parts.get(5)) : 1.0f;
            final int arc = (parts.size() >= 7) ? parseInteger(parts.get(6)) : 0;
            return t -> {
                if (lineColor != null) {
                    new(com.formdev.flatlaf.ui.FlatLineBorder.class)();
                    new FlatLineBorder(insets, lineColor, lineThickness, arc);
                }
                else {
                    new(com.formdev.flatlaf.ui.FlatEmptyBorder.class)();
                    new FlatEmptyBorder(insets);
                }
                return;
            };
        }
        return parseInstance(value, addonClassLoaders);
    }
    
    private static Object parseInstance(final String value, final List<ClassLoader> addonClassLoaders) {
        return t -> {
            try {
                return findClass(value, addonClassLoaders).getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            catch (final Exception ex) {
                LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to instantiate '" + value + "'.", ex);
                return null;
            }
        };
    }
    
    private static Object parseClass(final String value, final List<ClassLoader> addonClassLoaders) {
        return t -> {
            try {
                return findClass(value, addonClassLoaders);
            }
            catch (final ClassNotFoundException ex) {
                LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to find class '" + value + "'.", ex);
                return null;
            }
        };
    }
    
    private static Class<?> findClass(final String className, final List<ClassLoader> addonClassLoaders) throws ClassNotFoundException {
        try {
            return Class.forName(className);
        }
        catch (final ClassNotFoundException ex) {
            for (final ClassLoader addonClassLoader : addonClassLoaders) {
                try {
                    return addonClassLoader.loadClass(className);
                }
                catch (final ClassNotFoundException ex2) {
                    continue;
                }
                break;
            }
            throw ex;
        }
    }
    
    private static Insets parseInsets(final String value) {
        final List<String> numbers = StringUtils.split(value, ',', true, false);
        try {
            return new InsetsUIResource(Integer.parseInt(numbers.get(0)), Integer.parseInt(numbers.get(1)), Integer.parseInt(numbers.get(2)), Integer.parseInt(numbers.get(3)));
        }
        catch (final NumberFormatException ex) {
            throw new IllegalArgumentException("invalid insets '" + value + "'");
        }
    }
    
    private static Dimension parseDimension(final String value) {
        final List<String> numbers = StringUtils.split(value, ',', true, false);
        try {
            return new DimensionUIResource(Integer.parseInt(numbers.get(0)), Integer.parseInt(numbers.get(1)));
        }
        catch (final NumberFormatException ex) {
            throw new IllegalArgumentException("invalid size '" + value + "'");
        }
    }
    
    private static Object parseColorOrFunction(final String value, final Function<String, String> resolver) {
        if (value.endsWith(")")) {
            return parseColorFunctions(value, resolver);
        }
        return parseColor(value);
    }
    
    static ColorUIResource parseColor(final String value) {
        final int rgba = parseColorRGBA(value);
        return ((rgba & 0xFF000000) == 0xFF000000) ? new ColorUIResource(rgba) : new ColorUIResource(new Color(rgba, true));
    }
    
    static int parseColorRGBA(final String value) {
        final int len = value.length();
        if ((len != 4 && len != 5 && len != 7 && len != 9) || value.charAt(0) != '#') {
            throw newInvalidColorException(value);
        }
        int n = 0;
        for (int i = 1; i < len; ++i) {
            final char ch = value.charAt(i);
            int digit;
            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            }
            else if (ch >= 'a' && ch <= 'f') {
                digit = ch - 'a' + 10;
            }
            else {
                if (ch < 'A' || ch > 'F') {
                    throw newInvalidColorException(value);
                }
                digit = ch - 'A' + 10;
            }
            n = (n << 4 | digit);
        }
        if (len <= 5) {
            final int n2 = n & 0xF000;
            final int n3 = n & 0xF00;
            final int n4 = n & 0xF0;
            final int n5 = n & 0xF;
            n = (n2 << 16 | n2 << 12 | n3 << 12 | n3 << 8 | n4 << 8 | n4 << 4 | n5 << 4 | n5);
        }
        return (len == 4 || len == 7) ? (0xFF000000 | n) : ((n >> 8 & 0xFFFFFF) | (n & 0xFF) << 24);
    }
    
    private static IllegalArgumentException newInvalidColorException(final String value) {
        return new IllegalArgumentException("invalid color '" + value + "'");
    }
    
    private static Object parseColorFunctions(final String value, final Function<String, String> resolver) {
        final int paramsStart = value.indexOf(40);
        if (paramsStart < 0) {
            throw new IllegalArgumentException("missing opening parenthesis in function '" + value + "'");
        }
        final String function = StringUtils.substringTrimmed(value, 0, paramsStart);
        final List<String> params = splitFunctionParams(value.substring(paramsStart + 1, value.length() - 1), ',');
        if (params.isEmpty()) {
            throwMissingParametersException(value);
        }
        if (UIDefaultsLoader.parseColorDepth > 100) {
            throw new IllegalArgumentException("endless recursion in color function '" + value + "'");
        }
        ++UIDefaultsLoader.parseColorDepth;
        try {
            final String s = function;
            switch (s) {
                case "if": {
                    return parseColorIf(value, params, resolver);
                }
                case "systemColor": {
                    return parseColorSystemColor(value, params, resolver);
                }
                case "rgb": {
                    return parseColorRgbOrRgba(false, params, resolver);
                }
                case "rgba": {
                    return parseColorRgbOrRgba(true, params, resolver);
                }
                case "hsl": {
                    return parseColorHslOrHsla(false, params);
                }
                case "hsla": {
                    return parseColorHslOrHsla(true, params);
                }
                case "lighten": {
                    return parseColorHSLIncreaseDecrease(2, true, params, resolver);
                }
                case "darken": {
                    return parseColorHSLIncreaseDecrease(2, false, params, resolver);
                }
                case "saturate": {
                    return parseColorHSLIncreaseDecrease(1, true, params, resolver);
                }
                case "desaturate": {
                    return parseColorHSLIncreaseDecrease(1, false, params, resolver);
                }
                case "fadein": {
                    return parseColorHSLIncreaseDecrease(3, true, params, resolver);
                }
                case "fadeout": {
                    return parseColorHSLIncreaseDecrease(3, false, params, resolver);
                }
                case "fade": {
                    return parseColorFade(params, resolver);
                }
                case "spin": {
                    return parseColorSpin(params, resolver);
                }
                case "changeHue": {
                    return parseColorChange(0, params, resolver);
                }
                case "changeSaturation": {
                    return parseColorChange(1, params, resolver);
                }
                case "changeLightness": {
                    return parseColorChange(2, params, resolver);
                }
                case "changeAlpha": {
                    return parseColorChange(3, params, resolver);
                }
                case "mix": {
                    return parseColorMix(null, params, resolver);
                }
                case "tint": {
                    return parseColorMix("#fff", params, resolver);
                }
                case "shade": {
                    return parseColorMix("#000", params, resolver);
                }
                case "contrast": {
                    return parseColorContrast(params, resolver);
                }
                case "over": {
                    return parseColorOver(params, resolver);
                }
            }
        }
        finally {
            --UIDefaultsLoader.parseColorDepth;
        }
        throw new IllegalArgumentException("unknown color function '" + value + "'");
    }
    
    private static Object parseColorIf(final String value, final List<String> params, final Function<String, String> resolver) {
        if (params.size() != 3) {
            throwMissingParametersException(value);
        }
        final boolean ifCondition = parseCondition(params.get(0), resolver, Collections.emptyList());
        final String ifValue = params.get(ifCondition ? 1 : 2);
        return parseColorOrFunction(resolver.apply(ifValue), resolver);
    }
    
    private static Object parseColorSystemColor(final String value, final List<String> params, final Function<String, String> resolver) {
        if (params.size() < 1) {
            throwMissingParametersException(value);
        }
        final ColorUIResource systemColor = getSystemColor(params.get(0));
        if (systemColor != null) {
            return systemColor;
        }
        final String defaultValue = (params.size() > 1) ? params.get(1) : "";
        if (defaultValue.equals("null") || defaultValue.isEmpty()) {
            return null;
        }
        return parseColorOrFunction(resolver.apply(defaultValue), resolver);
    }
    
    private static ColorUIResource getSystemColor(final String name) {
        final Function<String, Color> systemColorGetter = FlatLaf.getSystemColorGetter();
        if (systemColorGetter == null) {
            return null;
        }
        if (UIDefaultsLoader.systemColorCache != null && UIDefaultsLoader.systemColorCache.containsKey(name)) {
            return UIDefaultsLoader.systemColorCache.get(name);
        }
        final Color color = systemColorGetter.apply(name);
        final ColorUIResource uiColor = (color != null) ? new ColorUIResource(color) : null;
        if (UIDefaultsLoader.systemColorCache != null) {
            UIDefaultsLoader.systemColorCache.put(name, uiColor);
        }
        return uiColor;
    }
    
    private static ColorUIResource parseColorRgbOrRgba(final boolean hasAlpha, final List<String> params, final Function<String, String> resolver) {
        if (hasAlpha && params.size() == 2) {
            final String colorStr = params.get(0);
            final int alpha = parseInteger(params.get(1), 0, 255, true);
            final ColorUIResource color = (ColorUIResource)parseColorOrFunction(resolver.apply(colorStr), resolver);
            return new ColorUIResource(new Color((alpha & 0xFF) << 24 | (color.getRGB() & 0xFFFFFF), true));
        }
        final int red = parseInteger(params.get(0), 0, 255, true);
        final int green = parseInteger(params.get(1), 0, 255, true);
        final int blue = parseInteger(params.get(2), 0, 255, true);
        final int alpha2 = hasAlpha ? parseInteger(params.get(3), 0, 255, true) : 255;
        return hasAlpha ? new ColorUIResource(new Color(red, green, blue, alpha2)) : new ColorUIResource(red, green, blue);
    }
    
    private static ColorUIResource parseColorHslOrHsla(final boolean hasAlpha, final List<String> params) {
        final int hue = parseInteger(params.get(0), 0, 360, false);
        final int saturation = parsePercentage(params.get(1));
        final int lightness = parsePercentage(params.get(2));
        final int alpha = hasAlpha ? parsePercentage(params.get(3)) : 100;
        final float[] hsl = { (float)hue, (float)saturation, (float)lightness };
        return new ColorUIResource(HSLColor.toRGB(hsl, alpha / 100.0f));
    }
    
    private static Object parseColorHSLIncreaseDecrease(final int hslIndex, final boolean increase, final List<String> params, final Function<String, String> resolver) {
        final String colorStr = params.get(0);
        final int amount = parsePercentage(params.get(1));
        boolean relative = false;
        boolean autoInverse = false;
        boolean lazy = false;
        boolean derived = false;
        if (params.size() > 2) {
            final String options = params.get(2);
            relative = options.contains("relative");
            autoInverse = options.contains("autoInverse");
            lazy = options.contains("lazy");
            derived = options.contains("derived");
            if (derived && !options.contains("noAutoInverse")) {
                autoInverse = true;
            }
        }
        final ColorFunctions.ColorFunction function = new ColorFunctions.HSLIncreaseDecrease(hslIndex, increase, (float)amount, relative, autoInverse);
        if (lazy) {
            return t -> {
                final Object color = lazyUIManagerGet(colorStr);
                Object o2 = null;
                if (color instanceof Color) {
                    new(javax.swing.plaf.ColorUIResource.class)();
                    new ColorUIResource(ColorFunctions.applyFunctions((Color)color, function));
                }
                else {
                    o2 = null;
                }
                return o2;
            };
        }
        return parseFunctionBaseColor(colorStr, function, derived, resolver);
    }
    
    private static Object parseColorFade(final List<String> params, final Function<String, String> resolver) {
        final String colorStr = params.get(0);
        final int amount = parsePercentage(params.get(1));
        boolean derived = false;
        boolean lazy = false;
        if (params.size() > 2) {
            final String options = params.get(2);
            derived = options.contains("derived");
            lazy = options.contains("lazy");
        }
        final ColorFunctions.ColorFunction function = new ColorFunctions.Fade((float)amount);
        if (lazy) {
            return t -> {
                final Object color = lazyUIManagerGet(colorStr);
                Object o2 = null;
                if (color instanceof Color) {
                    new(javax.swing.plaf.ColorUIResource.class)();
                    new ColorUIResource(ColorFunctions.applyFunctions((Color)color, function));
                }
                else {
                    o2 = null;
                }
                return o2;
            };
        }
        return parseFunctionBaseColor(colorStr, function, derived, resolver);
    }
    
    private static Object parseColorSpin(final List<String> params, final Function<String, String> resolver) {
        final String colorStr = params.get(0);
        final int amount = parseInteger(params.get(1));
        boolean derived = false;
        if (params.size() > 2) {
            final String options = params.get(2);
            derived = options.contains("derived");
        }
        final ColorFunctions.ColorFunction function = new ColorFunctions.HSLIncreaseDecrease(0, true, (float)amount, false, false);
        return parseFunctionBaseColor(colorStr, function, derived, resolver);
    }
    
    private static Object parseColorChange(final int hslIndex, final List<String> params, final Function<String, String> resolver) {
        final String colorStr = params.get(0);
        final int value = (hslIndex == 0) ? parseInteger(params.get(1)) : parsePercentage(params.get(1));
        boolean derived = false;
        if (params.size() > 2) {
            final String options = params.get(2);
            derived = options.contains("derived");
        }
        final ColorFunctions.ColorFunction function = new ColorFunctions.HSLChange(hslIndex, (float)value);
        return parseFunctionBaseColor(colorStr, function, derived, resolver);
    }
    
    private static Object parseColorMix(String color1Str, final List<String> params, final Function<String, String> resolver) {
        int i = 0;
        if (color1Str == null) {
            color1Str = params.get(i++);
        }
        final String color2Str = params.get(i++);
        final int weight = (params.size() > i) ? parsePercentage(params.get(i)) : 50;
        final ColorUIResource color2 = (ColorUIResource)parseColorOrFunction(resolver.apply(color2Str), resolver);
        if (color2 == null) {
            return null;
        }
        final ColorFunctions.ColorFunction function = new ColorFunctions.Mix(color2, (float)weight);
        return parseFunctionBaseColor(color1Str, function, false, resolver);
    }
    
    private static Object parseColorContrast(final List<String> params, final Function<String, String> resolver) {
        final String colorStr = params.get(0);
        final String darkStr = params.get(1);
        final String lightStr = params.get(2);
        final int threshold = (params.size() > 3) ? parsePercentage(params.get(3)) : 43;
        final ColorUIResource color = (ColorUIResource)parseColorOrFunction(resolver.apply(colorStr), resolver);
        if (color == null) {
            return null;
        }
        final String darkOrLightColor = (ColorFunctions.luma(color) * 100.0f < threshold) ? lightStr : darkStr;
        return parseColorOrFunction(resolver.apply(darkOrLightColor), resolver);
    }
    
    private static ColorUIResource parseColorOver(final List<String> params, final Function<String, String> resolver) {
        final String foregroundStr = params.get(0);
        final String backgroundStr = params.get(1);
        final ColorUIResource foreground = (ColorUIResource)parseColorOrFunction(resolver.apply(foregroundStr), resolver);
        if (foreground == null || foreground.getAlpha() == 255) {
            return foreground;
        }
        final ColorUIResource foreground2 = new ColorUIResource(foreground.getRGB());
        final ColorUIResource background = (ColorUIResource)parseColorOrFunction(resolver.apply(backgroundStr), resolver);
        if (background == null) {
            return foreground2;
        }
        final float weight = foreground.getAlpha() / 255.0f;
        return new ColorUIResource(ColorFunctions.mix(foreground2, background, weight));
    }
    
    private static Object parseFunctionBaseColor(final String colorStr, final ColorFunctions.ColorFunction function, final boolean derived, final Function<String, String> resolver) {
        final String resolvedColorStr = resolver.apply(colorStr);
        final ColorUIResource baseColor = (ColorUIResource)parseColorOrFunction(resolvedColorStr, resolver);
        if (baseColor == null) {
            return null;
        }
        final Color newColor = ColorFunctions.applyFunctions(baseColor, function);
        if (derived) {
            ColorFunctions.ColorFunction[] functions;
            if (baseColor instanceof DerivedColor && resolvedColorStr == colorStr) {
                final ColorFunctions.ColorFunction[] baseFunctions = ((DerivedColor)baseColor).getFunctions();
                functions = new ColorFunctions.ColorFunction[baseFunctions.length + 1];
                System.arraycopy(baseFunctions, 0, functions, 0, baseFunctions.length);
                functions[baseFunctions.length] = function;
            }
            else {
                functions = new ColorFunctions.ColorFunction[] { function };
            }
            return new DerivedColor(newColor, functions);
        }
        return new ColorUIResource(newColor);
    }
    
    private static Object parseFont(final String value) {
        Object font = UIDefaultsLoader.fontCache.get(value);
        if (font != null) {
            return font;
        }
        int style = -1;
        int styleChange = 0;
        int absoluteSize = 0;
        int relativeSize = 0;
        float scaleSize = 0.0f;
        List<String> families = null;
        String baseFontKey = null;
        final StreamTokenizer st = new StreamTokenizer(new StringReader(value));
        st.resetSyntax();
        st.wordChars(33, 255);
        st.whitespaceChars(0, 32);
        st.whitespaceChars(44, 44);
        st.quoteChar(34);
        st.quoteChar(39);
        try {
            while (st.nextToken() != -1) {
                final String sval;
                final String param = sval = st.sval;
                switch (sval) {
                    case "normal": {
                        style = 0;
                        continue;
                    }
                    case "bold": {
                        if (style == -1) {
                            style = 0;
                        }
                        style |= 0x1;
                        continue;
                    }
                    case "italic": {
                        if (style == -1) {
                            style = 0;
                        }
                        style |= 0x2;
                        continue;
                    }
                    case "+bold": {
                        styleChange |= 0x1;
                        continue;
                    }
                    case "-bold": {
                        styleChange |= 0x10000;
                        continue;
                    }
                    case "+italic": {
                        styleChange |= 0x2;
                        continue;
                    }
                    case "-italic": {
                        styleChange |= 0x20000;
                        continue;
                    }
                    default: {
                        final char firstChar = param.charAt(0);
                        if (Character.isDigit(firstChar) || firstChar == '+' || firstChar == '-') {
                            if (absoluteSize != 0 || relativeSize != 0 || scaleSize != 0.0f) {
                                throw new IllegalArgumentException("size specified more than once in '" + value + "'");
                            }
                            if (firstChar == '+' || firstChar == '-') {
                                relativeSize = parseInteger(param);
                                continue;
                            }
                            if (param.endsWith("%")) {
                                scaleSize = parseInteger(param.substring(0, param.length() - 1)) / 100.0f;
                                continue;
                            }
                            absoluteSize = parseInteger(param);
                            continue;
                        }
                        else if (firstChar == '$') {
                            if (baseFontKey != null) {
                                throw new IllegalArgumentException("baseFontKey specified more than once in '" + value + "'");
                            }
                            baseFontKey = param.substring(1);
                            continue;
                        }
                        else {
                            if (families == null) {
                                families = Collections.singletonList(param);
                                continue;
                            }
                            if (families.size() == 1) {
                                families = new ArrayList<String>(families);
                            }
                            families.add(param);
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        catch (final IOException ex) {
            throw new IllegalArgumentException(ex);
        }
        if (style != -1 && styleChange != 0) {
            throw new IllegalArgumentException("can not mix absolute style (e.g. 'bold') with derived style (e.g. '+italic') in '" + value + "'");
        }
        if (styleChange != 0) {
            if ((styleChange & 0x1) != 0x0 && (styleChange & 0x10000) != 0x0) {
                throw new IllegalArgumentException("can not use '+bold' and '-bold' in '" + value + "'");
            }
            if ((styleChange & 0x2) != 0x0 && (styleChange & 0x20000) != 0x0) {
                throw new IllegalArgumentException("can not use '+italic' and '-italic' in '" + value + "'");
            }
        }
        font = new FlatLaf.ActiveFont(baseFontKey, families, style, styleChange, absoluteSize, relativeSize, scaleSize);
        UIDefaultsLoader.fontCache.put(value, font);
        return font;
    }
    
    private static int parsePercentage(final String value) {
        if (!value.endsWith("%")) {
            throw new NumberFormatException("invalid percentage '" + value + "'");
        }
        int val;
        try {
            val = Integer.parseInt(value.substring(0, value.length() - 1));
        }
        catch (final NumberFormatException ex) {
            throw new NumberFormatException("invalid percentage '" + value + "'");
        }
        if (val < 0 || val > 100) {
            throw new IllegalArgumentException("percentage out of range (0-100%) '" + value + "'");
        }
        return val;
    }
    
    private static Boolean parseBoolean(final String value) {
        switch (value) {
            case "false": {
                return false;
            }
            case "true": {
                return true;
            }
            default: {
                throw new IllegalArgumentException("invalid boolean '" + value + "'");
            }
        }
    }
    
    private static Character parseCharacter(final String value) {
        if (value.length() != 1) {
            throw new IllegalArgumentException("invalid character '" + value + "'");
        }
        return value.charAt(0);
    }
    
    private static Integer parseInteger(final String value, final int min, final int max, final boolean allowPercentage) {
        if (allowPercentage && value.endsWith("%")) {
            final int percent = parsePercentage(value);
            return max * percent / 100;
        }
        final Integer integer = parseInteger(value);
        if (integer < min || integer > max) {
            throw new NumberFormatException("integer '" + value + "' out of range (" + min + '-' + max + ')');
        }
        return integer;
    }
    
    private static Integer parseInteger(final String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (final NumberFormatException ex) {
            throw new NumberFormatException("invalid integer '" + value + "'");
        }
    }
    
    private static Number parseIntegerOrFloat(final String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (final NumberFormatException ex) {
            try {
                return Float.parseFloat(value);
            }
            catch (final NumberFormatException ex2) {
                throw new NumberFormatException("invalid integer or float '" + value + "'");
            }
        }
    }
    
    private static Float parseFloat(final String value) {
        try {
            return Float.parseFloat(value);
        }
        catch (final NumberFormatException ex) {
            throw new NumberFormatException("invalid float '" + value + "'");
        }
    }
    
    private static UIDefaults.ActiveValue parseScaledInteger(final String value) {
        final int val = parseInteger(value);
        return t -> UIScale.scale(val);
    }
    
    private static UIDefaults.ActiveValue parseScaledFloat(final String value) {
        final float val = parseFloat(value);
        return t -> UIScale.scale(val);
    }
    
    private static UIDefaults.ActiveValue parseScaledInsets(final String value) {
        final Insets insets = parseInsets(value);
        return t -> UIScale.scale(insets);
    }
    
    private static UIDefaults.ActiveValue parseScaledDimension(final String value) {
        final Dimension dimension = parseDimension(value);
        return t -> UIScale.scale(dimension);
    }
    
    private static Object parseGrayFilter(final String value) {
        final List<String> numbers = StringUtils.split(value, ',', true, false);
        try {
            final int brightness = Integer.parseInt(numbers.get(0));
            final int contrast = Integer.parseInt(numbers.get(1));
            final int alpha = Integer.parseInt(numbers.get(2));
            return t -> new GrayFilter(brightness, contrast, alpha);
        }
        catch (final NumberFormatException ex) {
            throw new IllegalArgumentException("invalid gray filter '" + value + "'");
        }
    }
    
    private static List<String> splitFunctionParams(final String str, final char delim) {
        final ArrayList<String> strs = new ArrayList<String>();
        int nestLevel = 0;
        int start = 0;
        for (int strlen = str.length(), i = 0; i < strlen; ++i) {
            final char ch = str.charAt(i);
            if (ch == '(') {
                ++nestLevel;
            }
            else if (ch == ')') {
                --nestLevel;
            }
            else if (nestLevel == 0 && ch == delim) {
                strs.add(StringUtils.substringTrimmed(str, start, i));
                start = i + 1;
            }
        }
        final String s = StringUtils.substringTrimmed(str, start);
        if (!s.isEmpty() || !strs.isEmpty()) {
            strs.add(s);
        }
        return strs;
    }
    
    static Object lazyUIManagerGet(String uiKey) {
        boolean optional = false;
        if (uiKey.startsWith("?")) {
            uiKey = uiKey.substring("?".length());
            optional = true;
        }
        final Object value = UIManager.get(uiKey);
        if (value == null && !optional) {
            LoggingFacade.INSTANCE.logSevere("FlatLaf: '" + uiKey + "' not found in UI defaults.", null);
        }
        return value;
    }
    
    private static void throwMissingParametersException(final String value) {
        throw new IllegalArgumentException("missing parameters in function '" + value + "'");
    }
    
    static {
        fontCache = new SoftCache<String, Object>();
        tempResultValueType = new ValueType[1];
    }
    
    enum ValueType
    {
        UNKNOWN, 
        STRING, 
        BOOLEAN, 
        CHARACTER, 
        INTEGER, 
        INTEGERORFLOAT, 
        FLOAT, 
        BORDER, 
        ICON, 
        INSETS, 
        DIMENSION, 
        COLOR, 
        FONT, 
        SCALEDINTEGER, 
        SCALEDFLOAT, 
        SCALEDINSETS, 
        SCALEDDIMENSION, 
        INSTANCE, 
        CLASS, 
        GRAYFILTER, 
        NULL, 
        LAZY;
    }
}
