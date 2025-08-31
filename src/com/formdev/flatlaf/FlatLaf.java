// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf;

import java.util.Hashtable;
import java.util.function.IntUnaryOperator;
import java.util.Locale;
import java.lang.invoke.MethodType;
import javax.swing.plaf.ComponentUI;
import java.lang.invoke.MethodHandles;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import com.formdev.flatlaf.ui.FlatUIUtils;
import javax.swing.JMenuBar;
import javax.swing.JDialog;
import javax.swing.JFrame;
import com.formdev.flatlaf.ui.FlatRootPaneUI;
import javax.swing.RootPaneContainer;
import java.awt.Component;
import javax.swing.SwingUtilities;
import java.awt.Window;
import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.beans.PropertyChangeEvent;
import java.util.Collections;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.awt.RenderingHints;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.StyleContext;
import com.formdev.flatlaf.util.FontUtils;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.Enumeration;
import java.util.MissingResourceException;
import com.formdev.flatlaf.util.StringUtils;
import java.util.ResourceBundle;
import java.util.Properties;
import java.util.Iterator;
import com.formdev.flatlaf.util.UIScale;
import javax.swing.BorderFactory;
import java.util.ArrayList;
import java.util.ServiceLoader;
import java.lang.reflect.Method;
import javax.swing.text.html.HTMLEditorKit;
import com.formdev.flatlaf.ui.FlatPopupFactory;
import java.awt.image.ImageProducer;
import java.awt.Image;
import com.formdev.flatlaf.util.MultiResolutionImageSupport;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import com.formdev.flatlaf.util.GrayFilter;
import java.awt.image.ImageFilter;
import javax.swing.ImageIcon;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.UIResource;
import javax.swing.Icon;
import javax.swing.JComponent;
import com.formdev.flatlaf.ui.FlatNativeWindowBorder;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.UIManager;
import javax.swing.LookAndFeel;
import java.lang.invoke.MethodHandle;
import javax.swing.UIDefaults;
import java.util.function.Consumer;
import javax.swing.PopupFactory;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import javax.swing.plaf.basic.BasicLookAndFeel;

public abstract class FlatLaf extends BasicLookAndFeel
{
    private static final String DESKTOPFONTHINTS = "awt.font.desktophints";
    private static List<Object> customDefaultsSources;
    private static Map<String, String> globalExtraDefaults;
    private Map<String, String> extraDefaults;
    private static Function<String, Color> systemColorGetter;
    private String desktopPropertyName;
    private String desktopPropertyName2;
    private PropertyChangeListener desktopPropertyListener;
    private static boolean aquaLoaded;
    private static boolean updateUIPending;
    private PopupFactory oldPopupFactory;
    private MnemonicHandler mnemonicHandler;
    private boolean subMenuUsabilityHelperInstalled;
    private Consumer<UIDefaults> postInitialization;
    private List<Function<Object, Object>> uiDefaultsGetters;
    private static String preferredFontFamily;
    private static String preferredLightFontFamily;
    private static String preferredSemiboldFontFamily;
    private static String preferredMonospacedFontFamily;
    public static final Object NULL_VALUE;
    private static boolean getUIMethodInitialized;
    private static MethodHandle getUIMethod;
    
    public static boolean setup(final LookAndFeel newLookAndFeel) {
        try {
            UIManager.setLookAndFeel(newLookAndFeel);
            return true;
        }
        catch (final Exception ex) {
            LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to setup look and feel '" + newLookAndFeel.getClass().getName() + "'.", ex);
            return false;
        }
    }
    
    @Deprecated
    public static boolean install(final LookAndFeel newLookAndFeel) {
        return setup(newLookAndFeel);
    }
    
    public static void installLafInfo(final String lafName, final Class<? extends LookAndFeel> lafClass) {
        UIManager.installLookAndFeel(new UIManager.LookAndFeelInfo(lafName, lafClass.getName()));
    }
    
    @Override
    public String getID() {
        return "FlatLaf - " + this.getName();
    }
    
    public abstract boolean isDark();
    
    public static boolean isLafDark() {
        final LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
        return lookAndFeel instanceof FlatLaf && ((FlatLaf)lookAndFeel).isDark();
    }
    
    @Override
    public boolean getSupportsWindowDecorations() {
        return !SystemInfo.isProjector && !SystemInfo.isWebswing && !SystemInfo.isWinPE && (!SystemInfo.isWindows_10_orLater || !FlatNativeWindowBorder.isSupported()) && (SystemInfo.isWindows_10_orLater || SystemInfo.isLinux);
    }
    
    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }
    
    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }
    
    @Override
    public Icon getDisabledIcon(final JComponent component, final Icon icon) {
        if (icon instanceof DisabledIconProvider) {
            final Icon disabledIcon = ((DisabledIconProvider)icon).getDisabledIcon();
            return (disabledIcon instanceof UIResource) ? disabledIcon : new IconUIResource(disabledIcon);
        }
        if (icon instanceof ImageIcon) {
            final Object grayFilter = UIManager.get("Component.grayFilter");
            final ImageFilter filter = (grayFilter instanceof ImageFilter) ? ((ImageFilter)grayFilter) : GrayFilter.createDisabledIconFilter(this.isDark());
            final Function<Image, Image> mapper = (Function<Image, Image>)(img -> {
                final ImageProducer producer = new FilteredImageSource(img.getSource(), filter);
                return Toolkit.getDefaultToolkit().createImage(producer);
            });
            final Image image = ((ImageIcon)icon).getImage();
            return new ImageIconUIResource(MultiResolutionImageSupport.map(image, mapper));
        }
        return null;
    }
    
    @Override
    public void initialize() {
        if (UIManager.getLookAndFeel() != this) {
            return;
        }
        if (SystemInfo.isMacOS) {
            this.initializeAqua();
        }
        super.initialize();
        this.oldPopupFactory = PopupFactory.getSharedInstance();
        PopupFactory.setSharedInstance(new FlatPopupFactory());
        (this.mnemonicHandler = new MnemonicHandler()).install();
        this.subMenuUsabilityHelperInstalled = SubMenuUsabilityHelper.install();
        if (SystemInfo.isWindows) {
            this.desktopPropertyName = "win.messagebox.font";
        }
        else if (SystemInfo.isLinux) {
            this.desktopPropertyName = "gnome.Gtk/FontName";
            this.desktopPropertyName2 = "gnome.Xft/DPI";
        }
        if (this.desktopPropertyName != null) {
            this.desktopPropertyListener = (e -> {
                if (!FlatSystemProperties.getBoolean("flatlaf.updateUIOnSystemFontChange", true)) {
                    return;
                }
                else {
                    final String propertyName = e.getPropertyName();
                    if (this.desktopPropertyName.equals(propertyName) || propertyName.equals(this.desktopPropertyName2)) {
                        reSetLookAndFeel();
                    }
                    else if ("awt.font.desktophints".equals(propertyName) && UIManager.getLookAndFeel() instanceof FlatLaf) {
                        this.putAATextInfo(UIManager.getLookAndFeelDefaults());
                        updateUILater();
                    }
                    return;
                }
            });
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.getDesktopProperty("dummy");
            toolkit.addPropertyChangeListener(this.desktopPropertyName, this.desktopPropertyListener);
            if (this.desktopPropertyName2 != null) {
                toolkit.addPropertyChangeListener(this.desktopPropertyName2, this.desktopPropertyListener);
            }
            toolkit.addPropertyChangeListener("awt.font.desktophints", this.desktopPropertyListener);
        }
        this.postInitialization = (defaults -> {
            final Color linkColor = defaults.getColor("Component.linkColor");
            if (linkColor != null) {
                new HTMLEditorKit().getStyleSheet().addRule(String.format("a, address { color: #%06x; }", linkColor.getRGB() & 0xFFFFFF));
            }
        });
    }
    
    @Override
    public void uninitialize() {
        if (UIManager.getLookAndFeel() != this) {
            return;
        }
        if (this.desktopPropertyListener != null) {
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.removePropertyChangeListener(this.desktopPropertyName, this.desktopPropertyListener);
            if (this.desktopPropertyName2 != null) {
                toolkit.removePropertyChangeListener(this.desktopPropertyName2, this.desktopPropertyListener);
            }
            toolkit.removePropertyChangeListener("awt.font.desktophints", this.desktopPropertyListener);
            this.desktopPropertyName = null;
            this.desktopPropertyName2 = null;
            this.desktopPropertyListener = null;
        }
        if (this.oldPopupFactory != null) {
            PopupFactory.setSharedInstance(this.oldPopupFactory);
            this.oldPopupFactory = null;
        }
        if (this.mnemonicHandler != null) {
            this.mnemonicHandler.uninstall();
            this.mnemonicHandler = null;
        }
        if (this.subMenuUsabilityHelperInstalled) {
            SubMenuUsabilityHelper.uninstall();
            this.subMenuUsabilityHelperInstalled = false;
        }
        new HTMLEditorKit().getStyleSheet().addRule("a, address { color: blue; }");
        this.postInitialization = null;
        super.uninitialize();
    }
    
    private void initializeAqua() {
        if (FlatLaf.aquaLoaded) {
            return;
        }
        FlatLaf.aquaLoaded = true;
        final String aquaLafClassName = "com.apple.laf.AquaLookAndFeel";
        BasicLookAndFeel aquaLaf;
        try {
            if (SystemInfo.isJava_9_orLater) {
                final Method m = UIManager.class.getMethod("createLookAndFeel", String.class);
                aquaLaf = (BasicLookAndFeel)m.invoke(null, "Mac OS X");
            }
            else {
                aquaLaf = (BasicLookAndFeel)Class.forName(aquaLafClassName).getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
        }
        catch (final Exception ex) {
            LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to initialize Aqua look and feel '" + aquaLafClassName + "'.", ex);
            throw new IllegalStateException();
        }
        final PopupFactory oldPopupFactory = PopupFactory.getSharedInstance();
        aquaLaf.initialize();
        aquaLaf.uninitialize();
        PopupFactory.setSharedInstance(oldPopupFactory);
    }
    
    @Override
    public UIDefaults getDefaults() {
        final UIDefaults defaults = new FlatUIDefaults(1500, 0.75f);
        this.initClassDefaults(defaults);
        this.initSystemColorDefaults(defaults);
        this.initComponentDefaults(defaults);
        defaults.put("laf.dark", this.isDark());
        this.initResourceBundle(defaults, "com.formdev.flatlaf.resources.Bundle");
        this.putDefaults(defaults, defaults.getColor("control"), "Button.disabledBackground", "EditorPane.disabledBackground", "EditorPane.inactiveBackground", "FormattedTextField.disabledBackground", "PasswordField.disabledBackground", "RootPane.background", "Spinner.disabledBackground", "TextArea.disabledBackground", "TextArea.inactiveBackground", "TextField.disabledBackground", "TextPane.disabledBackground", "TextPane.inactiveBackground", "ToggleButton.disabledBackground");
        this.putDefaults(defaults, defaults.getColor("textInactiveText"), "Button.disabledText", "CheckBox.disabledText", "CheckBoxMenuItem.disabledForeground", "Menu.disabledForeground", "MenuItem.disabledForeground", "RadioButton.disabledText", "RadioButtonMenuItem.disabledForeground", "Spinner.disabledForeground", "ToggleButton.disabledText");
        this.putDefaults(defaults, defaults.getColor("textText"), "DesktopIcon.foreground", "RootPane.foreground");
        this.initFonts(defaults);
        initIconColors(defaults, this.isDark());
        FlatInputMaps.initInputMaps(defaults);
        final Object icon = ((Hashtable<K, Object>)defaults).remove("InternalFrame.icon");
        defaults.put("InternalFrame.icon", icon);
        defaults.put("TitlePane.icon", icon);
        final ServiceLoader<FlatDefaultsAddon> addonLoader = ServiceLoader.load(FlatDefaultsAddon.class);
        final List<FlatDefaultsAddon> addons = new ArrayList<FlatDefaultsAddon>();
        for (final FlatDefaultsAddon addon : addonLoader) {
            addons.add(addon);
        }
        FlatDefaultsAddon addon2 = null;
        addons.sort((addon1, addon2) -> addon1.getPriority() - addon2.getPriority());
        final List<Class<?>> lafClassesForDefaultsLoading = this.getLafClassesForDefaultsLoading();
        if (lafClassesForDefaultsLoading != null) {
            UIDefaultsLoader.loadDefaultsFromProperties(lafClassesForDefaultsLoading, addons, this.getAdditionalDefaults(), this.isDark(), defaults);
        }
        else {
            UIDefaultsLoader.loadDefaultsFromProperties(this.getClass(), addons, this.getAdditionalDefaults(), this.isDark(), defaults);
        }
        this.initDefaultFont(defaults);
        if (SystemInfo.isMacOS && Boolean.getBoolean("apple.laf.useScreenMenuBar")) {
            defaults.put("MenuBarUI", "com.apple.laf.AquaMenuBarUI");
            defaults.put("MenuBar.backgroundPainter", BorderFactory.createEmptyBorder());
        }
        this.putAATextInfo(defaults);
        this.applyAdditionalDefaults(defaults);
        final Iterator<FlatDefaultsAddon> iterator2 = addons.iterator();
        while (iterator2.hasNext()) {
            addon2 = iterator2.next();
            addon2.afterDefaultsLoading(this, defaults);
        }
        defaults.put("laf.scaleFactor", t -> UIScale.getUserScaleFactor());
        if (this.postInitialization != null) {
            this.postInitialization.accept(defaults);
            this.postInitialization = null;
        }
        return defaults;
    }
    
    void applyAdditionalDefaults(final UIDefaults defaults) {
    }
    
    protected List<Class<?>> getLafClassesForDefaultsLoading() {
        return null;
    }
    
    protected Properties getAdditionalDefaults() {
        if (FlatLaf.globalExtraDefaults == null && this.extraDefaults == null) {
            return null;
        }
        final Properties properties = new Properties();
        if (FlatLaf.globalExtraDefaults != null) {
            properties.putAll(FlatLaf.globalExtraDefaults);
        }
        if (this.extraDefaults != null) {
            properties.putAll(this.extraDefaults);
        }
        return properties;
    }
    
    private void initResourceBundle(final UIDefaults defaults, final String bundleName) {
        defaults.addResourceBundle(bundleName);
        if (defaults.get("FileChooser.fileNameHeaderText") != null) {
            return;
        }
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle(bundleName, defaults.getDefaultLocale());
            final Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                final String key = keys.nextElement();
                final String value = bundle.getString(key);
                final String baseKey = StringUtils.removeTrailing(key, ".textAndMnemonic");
                if (baseKey != key) {
                    final String text = value.replace("&", "");
                    String mnemonic = null;
                    final int index = value.indexOf(38);
                    if (index >= 0) {
                        mnemonic = Integer.toString(Character.toUpperCase(value.charAt(index + 1)));
                    }
                    defaults.put(baseKey + "Text", text);
                    if (mnemonic == null) {
                        continue;
                    }
                    defaults.put(baseKey + "Mnemonic", mnemonic);
                }
                else {
                    defaults.put(key, value);
                }
            }
        }
        catch (final MissingResourceException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }
    
    private void initFonts(final UIDefaults defaults) {
        final Object activeFont = new ActiveFont(null, null, -1, 0, 0, 0, 0.0f);
        for (final Object key : ((Hashtable<Object, V>)defaults).keySet()) {
            if (key instanceof String && (((String)key).endsWith(".font") || ((String)key).endsWith("Font"))) {
                defaults.put(key, activeFont);
            }
        }
        defaults.put("RootPane.font", activeFont);
        defaults.put("TitlePane.font", activeFont);
    }
    
    private void initDefaultFont(final UIDefaults defaults) {
        FontUIResource uiFont = null;
        if (SystemInfo.isWindows) {
            final Font winFont = (Font)Toolkit.getDefaultToolkit().getDesktopProperty("win.messagebox.font");
            if (winFont != null) {
                if (SystemInfo.isWinPE) {
                    final Font winPEFont = (Font)Toolkit.getDefaultToolkit().getDesktopProperty("win.defaultGUI.font");
                    if (winPEFont != null) {
                        uiFont = createCompositeFont(winPEFont.getFamily(), winPEFont.getStyle(), winFont.getSize());
                    }
                }
                else {
                    uiFont = createCompositeFont(winFont.getFamily(), winFont.getStyle(), winFont.getSize());
                }
            }
        }
        else if (SystemInfo.isMacOS) {
            String fontName;
            if (SystemInfo.isMacOS_10_15_Catalina_orLater) {
                if (SystemInfo.isJetBrainsJVM_11_orLater) {
                    fontName = ".AppleSystemUIFont";
                }
                else {
                    fontName = "Helvetica Neue";
                }
            }
            else if (SystemInfo.isMacOS_10_11_ElCapitan_orLater) {
                fontName = ".SF NS Text";
            }
            else {
                fontName = "Lucida Grande";
            }
            uiFont = createCompositeFont(fontName, 0, 13);
        }
        else if (SystemInfo.isLinux) {
            final Font font = LinuxFontPolicy.getFont();
            uiFont = (FontUIResource)((font instanceof FontUIResource) ? font : new FontUIResource(font));
        }
        if (uiFont == null) {
            uiFont = createCompositeFont("SansSerif", 0, 12);
        }
        if (FlatLaf.preferredFontFamily != null) {
            final FontUIResource preferredFont = createCompositeFont(FlatLaf.preferredFontFamily, uiFont.getStyle(), uiFont.getSize());
            if (!isFallbackFont(preferredFont) || isDialogFamily(FlatLaf.preferredFontFamily)) {
                uiFont = preferredFont;
            }
        }
        final Object defaultFont = ((Hashtable<K, Object>)defaults).remove("defaultFont");
        if (defaultFont instanceof ActiveFont) {
            final Font baseFont = uiFont;
            uiFont = ((ActiveFont)defaultFont).derive(baseFont, fontSize -> Math.round(fontSize * UIScale.computeFontScaleFactor(baseFont)));
        }
        uiFont = UIScale.applyCustomScaleFactor(uiFont);
        defaults.put("defaultFont", uiFont);
    }
    
    static FontUIResource createCompositeFont(final String family, final int style, final int size) {
        FontUtils.loadFontFamily(family);
        final Font font = StyleContext.getDefaultStyleContext().getFont(family, style, size);
        return (FontUIResource)((font instanceof FontUIResource) ? font : new FontUIResource(font));
    }
    
    public static UIDefaults.ActiveValue createActiveFontValue(final float scaleFactor) {
        return new ActiveFont(null, null, -1, 0, 0, 0, scaleFactor);
    }
    
    public static void initIconColors(final UIDefaults defaults, final boolean dark) {
        for (final FlatIconColors c : FlatIconColors.values()) {
            if (c.light == !dark || c.dark == dark) {
                defaults.put(c.key, new ColorUIResource(c.rgb));
            }
        }
    }
    
    private void putAATextInfo(final UIDefaults defaults) {
        if (SystemInfo.isMacOS && SystemInfo.isJetBrainsJVM) {
            defaults.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        else if (SystemInfo.isJava_9_orLater) {
            Object desktopHints = Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");
            if (desktopHints == null) {
                desktopHints = this.fallbackAATextInfo();
            }
            if (desktopHints instanceof Map) {
                final Map<Object, Object> hints = (Map<Object, Object>)desktopHints;
                final Object aaHint = hints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
                if (aaHint != null && aaHint != RenderingHints.VALUE_TEXT_ANTIALIAS_OFF && aaHint != RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT) {
                    defaults.put(RenderingHints.KEY_TEXT_ANTIALIASING, aaHint);
                    defaults.put(RenderingHints.KEY_TEXT_LCD_CONTRAST, hints.get(RenderingHints.KEY_TEXT_LCD_CONTRAST));
                }
            }
        }
        else {
            try {
                final Object key = Class.forName("sun.swing.SwingUtilities2").getField("AA_TEXT_PROPERTY_KEY").get(null);
                Object value = Class.forName("sun.swing.SwingUtilities2$AATextInfo").getMethod("getAATextInfo", Boolean.TYPE).invoke(null, true);
                if (value == null) {
                    value = this.fallbackAATextInfo();
                }
                defaults.put(key, value);
            }
            catch (final Exception ex) {
                LoggingFacade.INSTANCE.logSevere(null, ex);
                throw new RuntimeException(ex);
            }
        }
    }
    
    private Object fallbackAATextInfo() {
        if (System.getProperty("awt.useSystemAAFontSettings") != null) {
            return null;
        }
        Object aaHint = null;
        final Integer lcdContrastHint = null;
        if (SystemInfo.isLinux) {
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (toolkit.getDesktopProperty("gnome.Xft/Antialias") == null && toolkit.getDesktopProperty("fontconfig/Antialias") == null) {
                aaHint = RenderingHints.VALUE_TEXT_ANTIALIAS_ON;
            }
        }
        if (aaHint == null) {
            return null;
        }
        if (SystemInfo.isJava_9_orLater) {
            final Map<Object, Object> hints = new HashMap<Object, Object>();
            hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, aaHint);
            hints.put(RenderingHints.KEY_TEXT_LCD_CONTRAST, lcdContrastHint);
            return hints;
        }
        try {
            return Class.forName("sun.swing.SwingUtilities2$AATextInfo").getConstructor(Object.class, Integer.class).newInstance(aaHint, lcdContrastHint);
        }
        catch (final Exception ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    private void putDefaults(final UIDefaults defaults, final Object value, final String... keys) {
        for (final String key : keys) {
            defaults.put(key, value);
        }
    }
    
    static List<Object> getCustomDefaultsSources() {
        return FlatLaf.customDefaultsSources;
    }
    
    public static void registerCustomDefaultsSource(final String packageName) {
        registerCustomDefaultsSource(packageName, null);
    }
    
    public static void unregisterCustomDefaultsSource(final String packageName) {
        unregisterCustomDefaultsSource(packageName, null);
    }
    
    public static void registerCustomDefaultsSource(final String packageName, final ClassLoader classLoader) {
        if (FlatLaf.customDefaultsSources == null) {
            FlatLaf.customDefaultsSources = new ArrayList<Object>();
        }
        FlatLaf.customDefaultsSources.add(packageName);
        FlatLaf.customDefaultsSources.add(classLoader);
    }
    
    public static void unregisterCustomDefaultsSource(final String packageName, final ClassLoader classLoader) {
        if (FlatLaf.customDefaultsSources == null) {
            return;
        }
        for (int size = FlatLaf.customDefaultsSources.size(), i = 0; i < size - 1; ++i) {
            final Object source = FlatLaf.customDefaultsSources.get(i);
            if (packageName.equals(source) && FlatLaf.customDefaultsSources.get(i + 1) == classLoader) {
                FlatLaf.customDefaultsSources.remove(i + 1);
                FlatLaf.customDefaultsSources.remove(i);
                break;
            }
        }
    }
    
    public static void registerCustomDefaultsSource(final URL packageUrl) {
        if (FlatLaf.customDefaultsSources == null) {
            FlatLaf.customDefaultsSources = new ArrayList<Object>();
        }
        FlatLaf.customDefaultsSources.add(packageUrl);
    }
    
    public static void unregisterCustomDefaultsSource(final URL packageUrl) {
        if (FlatLaf.customDefaultsSources == null) {
            return;
        }
        FlatLaf.customDefaultsSources.remove(packageUrl);
    }
    
    public static void registerCustomDefaultsSource(final File folder) {
        if (FlatLaf.customDefaultsSources == null) {
            FlatLaf.customDefaultsSources = new ArrayList<Object>();
        }
        FlatLaf.customDefaultsSources.add(folder);
    }
    
    public static void unregisterCustomDefaultsSource(final File folder) {
        if (FlatLaf.customDefaultsSources == null) {
            return;
        }
        FlatLaf.customDefaultsSources.remove(folder);
    }
    
    public static Map<String, String> getGlobalExtraDefaults() {
        return FlatLaf.globalExtraDefaults;
    }
    
    public static void setGlobalExtraDefaults(final Map<String, String> globalExtraDefaults) {
        FlatLaf.globalExtraDefaults = globalExtraDefaults;
    }
    
    public Map<String, String> getExtraDefaults() {
        return this.extraDefaults;
    }
    
    public void setExtraDefaults(final Map<String, String> extraDefaults) {
        this.extraDefaults = extraDefaults;
    }
    
    public static Object parseDefaultsValue(final String key, String value, final Class<?> valueType) throws IllegalArgumentException {
        value = UIDefaultsLoader.resolveValueFromUIManager(value);
        Object val = UIDefaultsLoader.parseValue(key, value, valueType, (UIDefaultsLoader.ValueType[])null, v -> UIDefaultsLoader.resolveValueFromUIManager(v), Collections.emptyList());
        if (val instanceof UIDefaults.LazyValue) {
            val = ((UIDefaults.LazyValue)val).createValue(null);
        }
        else if (val instanceof UIDefaults.ActiveValue) {
            val = ((UIDefaults.ActiveValue)val).createValue(null);
        }
        return val;
    }
    
    public static Function<String, Color> getSystemColorGetter() {
        return FlatLaf.systemColorGetter;
    }
    
    public static void setSystemColorGetter(final Function<String, Color> systemColorGetter) {
        FlatLaf.systemColorGetter = systemColorGetter;
    }
    
    private static void reSetLookAndFeel() {
        EventQueue.invokeLater(() -> {
            final LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
            try {
                UIManager.setLookAndFeel(lookAndFeel);
                final PropertyChangeEvent e = new PropertyChangeEvent(UIManager.class, "lookAndFeel", lookAndFeel, lookAndFeel);
                UIManager.getPropertyChangeListeners();
                final PropertyChangeListener[] array;
                int i = 0;
                for (int length = array.length; i < length; ++i) {
                    final PropertyChangeListener l = array[i];
                    l.propertyChange(e);
                }
                updateUI();
            }
            catch (final UnsupportedLookAndFeelException ex) {
                LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to reinitialize look and feel '" + lookAndFeel.getClass().getName() + "'.", ex);
            }
        });
    }
    
    public static void updateUI() {
        for (final Window w : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(w);
        }
    }
    
    public static void updateUILater() {
        synchronized (FlatLaf.class) {
            if (FlatLaf.updateUIPending) {
                return;
            }
            FlatLaf.updateUIPending = true;
        }
        EventQueue.invokeLater(() -> {
            updateUI();
            synchronized (FlatLaf.class) {
                FlatLaf.updateUIPending = false;
            }
        });
    }
    
    public static boolean supportsNativeWindowDecorations() {
        return SystemInfo.isWindows_10_orLater && FlatNativeWindowBorder.isSupported();
    }
    
    public static boolean isUseNativeWindowDecorations() {
        return UIManager.getBoolean("TitlePane.useWindowDecorations");
    }
    
    public static void setUseNativeWindowDecorations(final boolean enabled) {
        UIManager.put("TitlePane.useWindowDecorations", enabled);
        if (!(UIManager.getLookAndFeel() instanceof FlatLaf)) {
            return;
        }
        for (final Window w : Window.getWindows()) {
            if (isDisplayableFrameOrDialog(w)) {
                FlatRootPaneUI.updateNativeWindowBorder(((RootPaneContainer)w).getRootPane());
            }
        }
    }
    
    public static void revalidateAndRepaintAllFramesAndDialogs() {
        for (final Window w : Window.getWindows()) {
            if (isDisplayableFrameOrDialog(w)) {
                final JMenuBar menuBar = (w instanceof JFrame) ? ((JFrame)w).getJMenuBar() : ((w instanceof JDialog) ? ((JDialog)w).getJMenuBar() : null);
                if (menuBar != null) {
                    menuBar.revalidate();
                }
                w.revalidate();
                w.repaint();
            }
        }
    }
    
    public static void repaintAllFramesAndDialogs() {
        for (final Window w : Window.getWindows()) {
            if (isDisplayableFrameOrDialog(w)) {
                w.repaint();
            }
        }
    }
    
    private static boolean isDisplayableFrameOrDialog(final Window w) {
        return w.isDisplayable() && (w instanceof JFrame || w instanceof JDialog);
    }
    
    public static boolean isShowMnemonics() {
        return MnemonicHandler.isShowMnemonics();
    }
    
    public static void showMnemonics(final Component c) {
        MnemonicHandler.showMnemonics(true, c);
    }
    
    public static void hideMnemonics() {
        MnemonicHandler.showMnemonics(false, null);
    }
    
    @Override
    public final boolean equals(final Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    public void registerUIDefaultsGetter(final Function<Object, Object> uiDefaultsGetter) {
        if (this.uiDefaultsGetters == null) {
            this.uiDefaultsGetters = new ArrayList<Function<Object, Object>>();
        }
        this.uiDefaultsGetters.remove(uiDefaultsGetter);
        this.uiDefaultsGetters.add(uiDefaultsGetter);
        FlatUIUtils.setUseSharedUIs(false);
    }
    
    public void unregisterUIDefaultsGetter(final Function<Object, Object> uiDefaultsGetter) {
        if (this.uiDefaultsGetters == null) {
            return;
        }
        this.uiDefaultsGetters.remove(uiDefaultsGetter);
        if (this.uiDefaultsGetters.isEmpty()) {
            FlatUIUtils.setUseSharedUIs(true);
        }
    }
    
    public static void runWithUIDefaultsGetter(final Function<Object, Object> uiDefaultsGetter, final Runnable runnable) {
        final LookAndFeel laf = UIManager.getLookAndFeel();
        if (laf instanceof FlatLaf) {
            ((FlatLaf)laf).registerUIDefaultsGetter(uiDefaultsGetter);
            try {
                runnable.run();
            }
            finally {
                ((FlatLaf)laf).unregisterUIDefaultsGetter(uiDefaultsGetter);
            }
        }
        else {
            runnable.run();
        }
    }
    
    public static Map<String, Class<?>> getStyleableInfos(final JComponent c) {
        final FlatStylingSupport.StyleableUI ui = getStyleableUI(c);
        return (ui != null) ? ui.getStyleableInfos(c) : null;
    }
    
    public static <T> T getStyleableValue(final JComponent c, final String key) {
        final FlatStylingSupport.StyleableUI ui = getStyleableUI(c);
        return (T)((ui != null) ? ui.getStyleableValue(c, key) : null);
    }
    
    private static FlatStylingSupport.StyleableUI getStyleableUI(final JComponent c) {
        if (!FlatLaf.getUIMethodInitialized) {
            FlatLaf.getUIMethodInitialized = true;
            if (SystemInfo.isJava_9_orLater) {
                try {
                    FlatLaf.getUIMethod = MethodHandles.lookup().findVirtual(JComponent.class, "getUI", MethodType.methodType(ComponentUI.class));
                }
                catch (final Exception ex2) {}
            }
        }
        try {
            Object ui;
            if (FlatLaf.getUIMethod != null) {
                ui = FlatLaf.getUIMethod.invoke(c);
            }
            else {
                ui = c.getClass().getMethod("getUI", (Class<?>[])new Class[0]).invoke(c, new Object[0]);
            }
            return (ui instanceof FlatStylingSupport.StyleableUI) ? ((FlatStylingSupport.StyleableUI)ui) : null;
        }
        catch (final Throwable ex) {
            return null;
        }
    }
    
    public static String getPreferredFontFamily() {
        return FlatLaf.preferredFontFamily;
    }
    
    public static void setPreferredFontFamily(final String preferredFontFamily) {
        FlatLaf.preferredFontFamily = preferredFontFamily;
    }
    
    public static String getPreferredLightFontFamily() {
        return FlatLaf.preferredLightFontFamily;
    }
    
    public static void setPreferredLightFontFamily(final String preferredLightFontFamily) {
        FlatLaf.preferredLightFontFamily = preferredLightFontFamily;
    }
    
    public static String getPreferredSemiboldFontFamily() {
        return FlatLaf.preferredSemiboldFontFamily;
    }
    
    public static void setPreferredSemiboldFontFamily(final String preferredSemiboldFontFamily) {
        FlatLaf.preferredSemiboldFontFamily = preferredSemiboldFontFamily;
    }
    
    public static String getPreferredMonospacedFontFamily() {
        return FlatLaf.preferredMonospacedFontFamily;
    }
    
    public static void setPreferredMonospacedFontFamily(final String preferredMonospacedFontFamily) {
        FlatLaf.preferredMonospacedFontFamily = preferredMonospacedFontFamily;
    }
    
    static {
        NULL_VALUE = new Object();
    }
    
    private class FlatUIDefaults extends UIDefaults
    {
        FlatUIDefaults(final int initialCapacity, final float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        
        @Override
        public Object get(final Object key) {
            final Object value = this.getValue(key);
            return (value != null) ? ((value != FlatLaf.NULL_VALUE) ? value : null) : super.get(key);
        }
        
        @Override
        public Object get(final Object key, final Locale l) {
            final Object value = this.getValue(key);
            return (value != null) ? ((value != FlatLaf.NULL_VALUE) ? value : null) : super.get(key, l);
        }
        
        private Object getValue(final Object key) {
            final List<Function<Object, Object>> uiDefaultsGetters = FlatLaf.this.uiDefaultsGetters;
            if (uiDefaultsGetters == null) {
                return null;
            }
            for (int i = uiDefaultsGetters.size() - 1; i >= 0; --i) {
                final Object value = uiDefaultsGetters.get(i).apply(key);
                if (value != null) {
                    return value;
                }
            }
            return null;
        }
    }
    
    static class ActiveFont implements UIDefaults.ActiveValue
    {
        private final String baseFontKey;
        private final List<String> families;
        private final int style;
        private final int styleChange;
        private final int absoluteSize;
        private final int relativeSize;
        private final float scaleSize;
        private FontUIResource font;
        private Font lastBaseFont;
        private boolean inCreateValue;
        
        ActiveFont(final String baseFontKey, final List<String> families, final int style, final int styleChange, final int absoluteSize, final int relativeSize, final float scaleSize) {
            this.baseFontKey = baseFontKey;
            this.families = families;
            this.style = style;
            this.styleChange = styleChange;
            this.absoluteSize = absoluteSize;
            this.relativeSize = relativeSize;
            this.scaleSize = scaleSize;
        }
        
        @Override
        public synchronized Object createValue(final UIDefaults table) {
            if (this.inCreateValue) {
                throw new IllegalStateException("FlatLaf: endless recursion in font");
            }
            Font baseFont = null;
            this.inCreateValue = true;
            try {
                if (this.baseFontKey != null) {
                    baseFont = (Font)UIDefaultsLoader.lazyUIManagerGet(this.baseFontKey);
                }
                if (baseFont == null) {
                    baseFont = UIManager.getFont("defaultFont");
                }
                if (baseFont == null) {
                    baseFont = UIManager.getFont("Label.font");
                }
            }
            finally {
                this.inCreateValue = false;
            }
            if (this.lastBaseFont != baseFont) {
                this.lastBaseFont = baseFont;
                this.font = this.derive(baseFont, fontSize -> UIScale.scale(fontSize));
            }
            return this.font;
        }
        
        FontUIResource derive(final Font baseFont, final IntUnaryOperator scale) {
            final int baseStyle = baseFont.getStyle();
            final int baseSize = baseFont.getSize();
            final int newStyle = (this.style != -1) ? this.style : ((this.styleChange != 0) ? ((baseStyle & ~(this.styleChange >> 16 & 0xFFFF)) | (this.styleChange & 0xFFFF)) : baseStyle);
            int newSize = (this.absoluteSize > 0) ? scale.applyAsInt(this.absoluteSize) : ((this.relativeSize != 0) ? (baseSize + scale.applyAsInt(this.relativeSize)) : ((this.scaleSize > 0.0f) ? Math.round(baseSize * this.scaleSize) : baseSize));
            if (newSize <= 0) {
                newSize = 1;
            }
            if (this.families != null && !this.families.isEmpty()) {
                final String preferredFamily = preferredFamily(this.families);
                if (preferredFamily != null) {
                    final Font font = FlatLaf.createCompositeFont(preferredFamily, newStyle, newSize);
                    if (!isFallbackFont(font) || isDialogFamily(preferredFamily)) {
                        return this.toUIResource(font);
                    }
                }
                for (final String family : this.families) {
                    final Font font2 = FlatLaf.createCompositeFont(family, newStyle, newSize);
                    if (!isFallbackFont(font2) || isDialogFamily(family)) {
                        return this.toUIResource(font2);
                    }
                }
            }
            if (newStyle != baseStyle || newSize != baseSize) {
                if ("Ubuntu Medium".equalsIgnoreCase(baseFont.getName()) && "Ubuntu Light".equalsIgnoreCase(baseFont.getFamily())) {
                    final Font font3 = FlatLaf.createCompositeFont("Ubuntu Medium", newStyle, newSize);
                    if (!isFallbackFont(font3)) {
                        return this.toUIResource(font3);
                    }
                }
                return this.toUIResource(baseFont.deriveFont(newStyle, (float)newSize));
            }
            return this.toUIResource(baseFont);
        }
        
        private FontUIResource toUIResource(final Font font) {
            return (FontUIResource)((font instanceof FontUIResource) ? font : new FontUIResource(font));
        }
        
        private static boolean isFallbackFont(final Font font) {
            return "Dialog".equalsIgnoreCase(font.getFamily());
        }
        
        private static boolean isDialogFamily(final String family) {
            return family.equalsIgnoreCase("Dialog");
        }
        
        private static String preferredFamily(final List<String> families) {
            for (String family : families) {
                family = family.toLowerCase(Locale.ENGLISH);
                if (family.endsWith(" light") || family.endsWith("-thin")) {
                    return FlatLaf.preferredLightFontFamily;
                }
                if (family.endsWith(" semibold") || family.endsWith("-medium")) {
                    return FlatLaf.preferredSemiboldFontFamily;
                }
                if (family.equals("monospaced")) {
                    return FlatLaf.preferredMonospacedFontFamily;
                }
            }
            return null;
        }
    }
    
    private static class ImageIconUIResource extends ImageIcon implements UIResource
    {
        ImageIconUIResource(final Image image) {
            super(image);
        }
    }
    
    public interface DisabledIconProvider
    {
        Icon getDisabledIcon();
    }
}
