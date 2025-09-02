package com.formdev.flatlaf;

import com.formdev.flatlaf.json.Json;
import com.formdev.flatlaf.json.ParseException;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.LoggingFacade;
import com.formdev.flatlaf.util.StringUtils;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;

public class IntelliJTheme {
   public final String name;
   public final boolean dark;
   public final String author;
   private final boolean isMaterialUILite;
   private final Map<String, String> colors;
   private final Map<String, Object> ui;
   private final Map<String, Object> icons;
   private Map<String, ColorUIResource> namedColors = Collections.emptyMap();
   private static final Map<String, String> uiKeyMapping = new HashMap<>();
   private static final Map<String, String> uiKeyCopying = new HashMap<>();
   private static final Map<String, String> uiKeyInverseMapping = new HashMap<>();
   private static final Map<String, String> checkboxKeyMapping = new HashMap<>();
   private static final Map<String, String> checkboxDuplicateColors = new HashMap<>();

   public static boolean setup(InputStream in) {
      try {
         return FlatLaf.setup(createLaf(in));
      } catch (Exception var2) {
         LoggingFacade.INSTANCE.logSevere("FlatLaf: Failed to load IntelliJ theme", var2);
         return false;
      }
   }

   @Deprecated
   public static boolean install(InputStream in) {
      return setup(in);
   }

   public static FlatLaf createLaf(InputStream in) throws IOException {
      return createLaf(new IntelliJTheme(in));
   }

   public static FlatLaf createLaf(IntelliJTheme theme) {
      return new IntelliJTheme.ThemeLaf(theme);
   }

   public IntelliJTheme(InputStream in) throws IOException {
      Map<String, Object> json;
      try {
         Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

         try {
            json = (Map<String, Object>)Json.parse(reader);
         } catch (Throwable var7) {
            try {
               reader.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }

            throw var7;
         }

         reader.close();
      } catch (ParseException var8) {
         throw new IOException(var8.getMessage(), var8);
      }

      this.name = (String)json.get("name");
      this.dark = Boolean.parseBoolean((String)json.get("dark"));
      this.author = (String)json.get("author");
      this.isMaterialUILite = this.author.equals("Mallowigi");
      this.colors = (Map<String, String>)json.get("colors");
      this.ui = (Map<String, Object>)json.get("ui");
      this.icons = (Map<String, Object>)json.get("icons");
   }

   private void applyProperties(UIDefaults defaults) {
      if (this.ui != null) {
         defaults.put("Component.isIntelliJTheme", true);
         defaults.put("Button.paintShadow", true);
         defaults.put("Button.shadowWidth", this.dark ? 2 : 1);
         Map<Object, Object> themeSpecificDefaults = this.removeThemeSpecificDefaults(defaults);
         this.loadNamedColors(defaults);
         ArrayList<Object> defaultsKeysCache = new ArrayList<>();
         Set<String> uiKeys = new HashSet<>();

         for (Entry<String, Object> e : this.ui.entrySet()) {
            this.apply(e.getKey(), e.getValue(), defaults, defaultsKeysCache, uiKeys);
         }

         this.applyColorPalette(defaults);
         this.applyCheckBoxColors(defaults);

         for (Entry<String, String> e : uiKeyCopying.entrySet()) {
            Object value = defaults.get(e.getValue());
            if (value != null) {
               defaults.put(e.getKey(), value);
            }
         }

         Object panelBackground = defaults.get("Panel.background");
         defaults.put("Button.disabledBackground", panelBackground);
         defaults.put("ToggleButton.disabledBackground", panelBackground);
         this.copyIfNotSet(defaults, "Button.focusedBorderColor", "Component.focusedBorderColor", uiKeys);
         defaults.put("Button.hoverBorderColor", defaults.get("Button.focusedBorderColor"));
         defaults.put("HelpButton.hoverBorderColor", defaults.get("Button.focusedBorderColor"));
         Object helpButtonBackground = defaults.get("Button.startBackground");
         Object helpButtonBorderColor = defaults.get("Button.startBorderColor");
         if (helpButtonBackground == null) {
            helpButtonBackground = defaults.get("Button.background");
         }

         if (helpButtonBorderColor == null) {
            helpButtonBorderColor = defaults.get("Button.borderColor");
         }

         defaults.put("HelpButton.background", helpButtonBackground);
         defaults.put("HelpButton.borderColor", helpButtonBorderColor);
         defaults.put("HelpButton.disabledBackground", panelBackground);
         defaults.put("HelpButton.disabledBorderColor", defaults.get("Button.disabledBorderColor"));
         defaults.put("HelpButton.focusedBorderColor", defaults.get("Button.focusedBorderColor"));
         defaults.put("HelpButton.focusedBackground", defaults.get("Button.focusedBackground"));
         defaults.put("ComboBox.editableBackground", defaults.get("TextField.background"));
         defaults.put("Spinner.background", defaults.get("TextField.background"));
         defaults.put("Spinner.buttonBackground", defaults.get("ComboBox.buttonEditableBackground"));
         defaults.put("Spinner.buttonArrowColor", defaults.get("ComboBox.buttonArrowColor"));
         defaults.put("Spinner.buttonDisabledArrowColor", defaults.get("ComboBox.buttonDisabledArrowColor"));
         if (uiKeys.contains("TextField.background")) {
            Object textFieldBackground = defaults.get("TextField.background");
            if (!uiKeys.contains("FormattedTextField.background")) {
               defaults.put("FormattedTextField.background", textFieldBackground);
            }

            if (!uiKeys.contains("PasswordField.background")) {
               defaults.put("PasswordField.background", textFieldBackground);
            }

            if (!uiKeys.contains("EditorPane.background")) {
               defaults.put("EditorPane.background", textFieldBackground);
            }

            if (!uiKeys.contains("TextArea.background")) {
               defaults.put("TextArea.background", textFieldBackground);
            }

            if (!uiKeys.contains("TextPane.background")) {
               defaults.put("TextPane.background", textFieldBackground);
            }

            if (!uiKeys.contains("Spinner.background")) {
               defaults.put("Spinner.background", textFieldBackground);
            }
         }

         if (!uiKeys.contains("ToggleButton.startBackground") && !uiKeys.contains("*.startBackground")) {
            defaults.put("ToggleButton.startBackground", defaults.get("Button.startBackground"));
         }

         if (!uiKeys.contains("ToggleButton.endBackground") && !uiKeys.contains("*.endBackground")) {
            defaults.put("ToggleButton.endBackground", defaults.get("Button.endBackground"));
         }

         if (!uiKeys.contains("ToggleButton.foreground") && uiKeys.contains("Button.foreground")) {
            defaults.put("ToggleButton.foreground", defaults.get("Button.foreground"));
         }

         Color desktopBackgroundBase = defaults.getColor("Panel.background");
         Color desktopBackground = ColorFunctions.applyFunctions(desktopBackgroundBase, new ColorFunctions.HSLIncreaseDecrease(2, this.dark, 5.0F, false, true));
         defaults.put("Desktop.background", new ColorUIResource(desktopBackground));
         if (this.isMaterialUILite) {
            defaults.put("List.background", defaults.get("Tree.background"));
            defaults.put("Table.background", defaults.get("Tree.background"));
         }

         int rowHeight = defaults.getInt("Tree.rowHeight");
         if (rowHeight > 22) {
            defaults.put("Tree.rowHeight", 22);
         }

         for (Entry<Object, Object> ex : themeSpecificDefaults.entrySet()) {
            Object key = ex.getKey();
            Object value = ex.getValue();
            if (key instanceof String && ((String)key).startsWith("[style]")) {
               Object oldValue = defaults.get(key);
               if (oldValue != null) {
                  value = oldValue + "; " + value;
               }
            }

            defaults.put(key, value);
         }
      }
   }

   private Map<Object, Object> removeThemeSpecificDefaults(UIDefaults defaults) {
      ArrayList<String> themeSpecificKeys = new ArrayList<>();

      for (Object key : defaults.keySet()) {
         if (key instanceof String && ((String)key).startsWith("[") && !((String)key).startsWith("[style]")) {
            themeSpecificKeys.add((String)key);
         }
      }

      Map<Object, Object> themeSpecificDefaults = new HashMap<>();
      String currentThemePrefix = '[' + this.name.replace(' ', '_') + ']';
      String currentThemeAndAuthorPrefix = '[' + this.name.replace(' ', '_') + "---" + this.author.replace(' ', '_') + ']';
      String currentAuthorPrefix = "[author-" + this.author.replace(' ', '_') + ']';
      String allThemesPrefix = "[*]";
      String[] prefixes = new String[]{currentThemePrefix, currentThemeAndAuthorPrefix, currentAuthorPrefix, allThemesPrefix};

      for (String keyx : themeSpecificKeys) {
         Object value = defaults.remove(keyx);

         for (String prefix : prefixes) {
            if (keyx.startsWith(prefix)) {
               themeSpecificDefaults.put(keyx.substring(prefix.length()), value);
               break;
            }
         }
      }

      return themeSpecificDefaults;
   }

   private void loadNamedColors(UIDefaults defaults) {
      if (this.colors != null) {
         this.namedColors = new HashMap<>();

         for (Entry<String, String> e : this.colors.entrySet()) {
            String value = e.getValue();
            ColorUIResource color = this.parseColor(value);
            if (color != null) {
               String key = e.getKey();
               this.namedColors.put(key, color);
               defaults.put("ColorPalette." + key, color);
            }
         }
      }
   }

   private void apply(String key, Object value, UIDefaults defaults, ArrayList<Object> defaultsKeysCache, Set<String> uiKeys) {
      if (value instanceof Map) {
         Map<String, Object> map = (Map<String, Object>)value;
         if (!map.containsKey("os.default") && !map.containsKey("os.windows") && !map.containsKey("os.mac") && !map.containsKey("os.linux")) {
            for (Entry<String, Object> e : map.entrySet()) {
               this.apply(key + '.' + e.getKey(), e.getValue(), defaults, defaultsKeysCache, uiKeys);
            }
         } else {
            String osKey = SystemInfo.isWindows ? "os.windows" : (SystemInfo.isMacOS ? "os.mac" : (SystemInfo.isLinux ? "os.linux" : null));
            if (osKey != null && map.containsKey(osKey)) {
               this.apply(key, map.get(osKey), defaults, defaultsKeysCache, uiKeys);
            } else if (map.containsKey("os.default")) {
               this.apply(key, map.get("os.default"), defaults, defaultsKeysCache, uiKeys);
            }
         }
      } else {
         if ("".equals(value)) {
            return;
         }

         uiKeys.add(key);
         if (key.endsWith(".border")
            || key.endsWith(".rowHeight")
            || key.equals("ComboBox.padding")
            || key.equals("Spinner.padding")
            || key.equals("Tree.leftChildIndent")
            || key.equals("Tree.rightChildIndent")) {
            return;
         }

         key = uiKeyMapping.getOrDefault(key, key);
         if (key.isEmpty()) {
            return;
         }

         String valueStr = value.toString();
         Object uiValue = this.namedColors.get(valueStr);
         if (uiValue == null) {
            if (valueStr.startsWith("#") || !key.endsWith("ground") && !key.endsWith("Color")) {
               if (valueStr.startsWith("##")) {
                  valueStr = this.fixColorIfValid(valueStr.substring(1), valueStr);
               } else if (key.endsWith(".border") || key.endsWith("Border")) {
                  List<String> parts = StringUtils.split(valueStr, ',');
                  if (parts.size() == 5 && !parts.get(4).startsWith("#")) {
                     parts.set(4, "#" + parts.get(4));
                     valueStr = String.join(",", parts);
                  }
               }
            } else {
               valueStr = this.fixColorIfValid("#" + valueStr, valueStr);
            }

            try {
               uiValue = UIDefaultsLoader.parseValue(key, valueStr, null);
            } catch (RuntimeException var12) {
               UIDefaultsLoader.logParseError(key, valueStr, var12, false);
               return;
            }
         }

         if (key.startsWith("*.")) {
            String tail = key.substring(1);
            if (defaultsKeysCache.size() != defaults.size()) {
               defaultsKeysCache.clear();
               Enumeration<Object> e = defaults.keys();

               while (e.hasMoreElements()) {
                  defaultsKeysCache.add(e.nextElement());
               }
            }

            for (Object k : defaultsKeysCache) {
               if (!k.equals("Desktop.background") && !k.equals("DesktopIcon.background") && k instanceof String) {
                  String km = uiKeyInverseMapping.getOrDefault(k, (String)k);
                  if (km.endsWith(tail) && !((String)k).startsWith("CheckBox.icon.")) {
                     defaults.put(k, uiValue);
                  }
               }
            }
         } else {
            defaults.put(key, uiValue);
         }
      }
   }

   private String fixColorIfValid(String newColorStr, String colorStr) {
      try {
         UIDefaultsLoader.parseColorRGBA(newColorStr);
         return newColorStr;
      } catch (IllegalArgumentException var4) {
         return colorStr;
      }
   }

   private void applyColorPalette(UIDefaults defaults) {
      if (this.icons != null) {
         Object palette = this.icons.get("ColorPalette");
         if (palette instanceof Map) {
            Map<String, Object> colorPalette = (Map<String, Object>)palette;

            for (Entry<String, Object> e : colorPalette.entrySet()) {
               String key = e.getKey();
               Object value = e.getValue();
               if (!key.startsWith("Checkbox.") && value instanceof String) {
                  if (this.dark) {
                     key = StringUtils.removeTrailing(key, ".Dark");
                  }

                  ColorUIResource color = this.toColor((String)value);
                  if (color != null) {
                     defaults.put(key, color);
                  }
               }
            }
         }
      }
   }

   private ColorUIResource toColor(String value) {
      ColorUIResource color = this.namedColors.get(value);
      return color != null ? color : this.parseColor(value);
   }

   private ColorUIResource parseColor(String value) {
      try {
         return UIDefaultsLoader.parseColor(value);
      } catch (IllegalArgumentException var3) {
         return null;
      }
   }

   private void applyCheckBoxColors(UIDefaults defaults) {
      if (this.icons != null) {
         Object palette = this.icons.get("ColorPalette");
         if (palette instanceof Map) {
            boolean checkboxModified = false;
            Map<String, Object> colorPalette = (Map<String, Object>)palette;

            for (Entry<String, Object> e : colorPalette.entrySet()) {
               String key = e.getKey();
               Object value = e.getValue();
               if (key.startsWith("Checkbox.") && value instanceof String) {
                  if (key.equals("Checkbox.Background.Default") || key.equals("Checkbox.Foreground.Selected")) {
                     value = "#ffffff";
                  }

                  String key2 = checkboxDuplicateColors.get(key);
                  if (this.dark) {
                     key = StringUtils.removeTrailing(key, ".Dark");
                  }

                  String newKey = checkboxKeyMapping.get(key);
                  if (newKey != null) {
                     String checkBoxIconPrefix = "CheckBox.icon.";
                     if (!this.dark && newKey.startsWith(checkBoxIconPrefix)) {
                        newKey = "CheckBox.icon[filled].".concat(newKey.substring(checkBoxIconPrefix.length()));
                     }

                     ColorUIResource color = this.toColor((String)value);
                     if (color != null) {
                        defaults.put(newKey, color);
                        if (key2 != null) {
                           if (this.dark) {
                              key2 = StringUtils.removeTrailing(key2, ".Dark");
                           }

                           String newKey2 = checkboxKeyMapping.get(key2);
                           if (newKey2 != null) {
                              defaults.put(newKey2, color);
                           }
                        }
                     }

                     checkboxModified = true;
                  }
               }
            }

            if (checkboxModified) {
               defaults.remove("CheckBox.icon.focusWidth");
               defaults.put("CheckBox.icon.hoverBorderColor", defaults.get("CheckBox.icon.focusedBorderColor"));
               defaults.remove("CheckBox.icon[filled].focusWidth");
               defaults.put("CheckBox.icon[filled].hoverBorderColor", defaults.get("CheckBox.icon[filled].focusedBorderColor"));
               defaults.put("CheckBox.icon[filled].focusedSelectedBackground", defaults.get("CheckBox.icon[filled].selectedBackground"));
               if (this.dark) {
                  String[] focusedBorderColorKeys = new String[]{
                     "CheckBox.icon.focusedBorderColor",
                     "CheckBox.icon.focusedSelectedBorderColor",
                     "CheckBox.icon[filled].focusedBorderColor",
                     "CheckBox.icon[filled].focusedSelectedBorderColor"
                  };

                  for (String key : focusedBorderColorKeys) {
                     Color color = defaults.getColor(key);
                     if (color != null) {
                        defaults.put(key, new ColorUIResource(new Color(color.getRGB() & 16777215 | -1509949440, true)));
                     }
                  }
               }
            }
         }
      }
   }

   private void copyIfNotSet(UIDefaults defaults, String destKey, String srcKey, Set<String> uiKeys) {
      if (!uiKeys.contains(destKey)) {
         defaults.put(destKey, defaults.get(srcKey));
      }
   }

   static {
      uiKeyMapping.put("ComboBox.background", "");
      uiKeyMapping.put("ComboBox.nonEditableBackground", "ComboBox.background");
      uiKeyMapping.put("ComboBox.ArrowButton.background", "ComboBox.buttonEditableBackground");
      uiKeyMapping.put("ComboBox.ArrowButton.disabledIconColor", "ComboBox.buttonDisabledArrowColor");
      uiKeyMapping.put("ComboBox.ArrowButton.iconColor", "ComboBox.buttonArrowColor");
      uiKeyMapping.put("ComboBox.ArrowButton.nonEditableBackground", "ComboBox.buttonBackground");
      uiKeyCopying.put("ComboBox.buttonSeparatorColor", "Component.borderColor");
      uiKeyCopying.put("ComboBox.buttonDisabledSeparatorColor", "Component.disabledBorderColor");
      uiKeyMapping.put("Component.inactiveErrorFocusColor", "Component.error.borderColor");
      uiKeyMapping.put("Component.errorFocusColor", "Component.error.focusedBorderColor");
      uiKeyMapping.put("Component.inactiveWarningFocusColor", "Component.warning.borderColor");
      uiKeyMapping.put("Component.warningFocusColor", "Component.warning.focusedBorderColor");
      uiKeyMapping.put("Link.activeForeground", "Component.linkColor");
      uiKeyMapping.put("Menu.border", "Menu.margin");
      uiKeyMapping.put("MenuItem.border", "MenuItem.margin");
      uiKeyCopying.put("CheckBoxMenuItem.margin", "MenuItem.margin");
      uiKeyCopying.put("RadioButtonMenuItem.margin", "MenuItem.margin");
      uiKeyMapping.put("PopupMenu.border", "PopupMenu.borderInsets");
      uiKeyCopying.put("MenuItem.underlineSelectionColor", "TabbedPane.underlineColor");
      uiKeyCopying.put("Menu.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("MenuItem.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("CheckBoxMenuItem.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("RadioButtonMenuItem.selectionBackground", "List.selectionBackground");
      uiKeyMapping.put("ProgressBar.background", "");
      uiKeyMapping.put("ProgressBar.foreground", "");
      uiKeyMapping.put("ProgressBar.trackColor", "ProgressBar.background");
      uiKeyMapping.put("ProgressBar.progressColor", "ProgressBar.foreground");
      uiKeyCopying.put("ProgressBar.selectionForeground", "ProgressBar.background");
      uiKeyCopying.put("ProgressBar.selectionBackground", "ProgressBar.foreground");
      uiKeyMapping.put("ScrollBar.trackColor", "ScrollBar.track");
      uiKeyMapping.put("ScrollBar.thumbColor", "ScrollBar.thumb");
      uiKeyMapping.put("Separator.separatorColor", "Separator.foreground");
      uiKeyMapping.put("Slider.trackWidth", "");
      uiKeyCopying.put("Slider.trackValueColor", "ProgressBar.foreground");
      uiKeyCopying.put("Slider.thumbColor", "ProgressBar.foreground");
      uiKeyCopying.put("Slider.trackColor", "ProgressBar.background");
      uiKeyCopying.put("Spinner.buttonSeparatorColor", "Component.borderColor");
      uiKeyCopying.put("Spinner.buttonDisabledSeparatorColor", "Component.disabledBorderColor");
      uiKeyCopying.put("TabbedPane.selectedBackground", "DefaultTabs.underlinedTabBackground");
      uiKeyCopying.put("TabbedPane.selectedForeground", "DefaultTabs.underlinedTabForeground");
      uiKeyCopying.put("TabbedPane.inactiveUnderlineColor", "DefaultTabs.inactiveUnderlineColor");
      uiKeyCopying.put("TitlePane.inactiveBackground", "TitlePane.background");
      uiKeyMapping.put("TitlePane.infoForeground", "TitlePane.foreground");
      uiKeyMapping.put("TitlePane.inactiveInfoForeground", "TitlePane.inactiveForeground");

      for (Entry<String, String> e : uiKeyMapping.entrySet()) {
         uiKeyInverseMapping.put(e.getValue(), e.getKey());
      }

      uiKeyCopying.put("ToggleButton.tab.underlineColor", "TabbedPane.underlineColor");
      uiKeyCopying.put("ToggleButton.tab.disabledUnderlineColor", "TabbedPane.disabledUnderlineColor");
      uiKeyCopying.put("ToggleButton.tab.selectedBackground", "TabbedPane.selectedBackground");
      uiKeyCopying.put("ToggleButton.tab.hoverBackground", "TabbedPane.hoverColor");
      uiKeyCopying.put("ToggleButton.tab.focusBackground", "TabbedPane.focusColor");
      checkboxKeyMapping.put("Checkbox.Background.Default", "CheckBox.icon.background");
      checkboxKeyMapping.put("Checkbox.Background.Disabled", "CheckBox.icon.disabledBackground");
      checkboxKeyMapping.put("Checkbox.Border.Default", "CheckBox.icon.borderColor");
      checkboxKeyMapping.put("Checkbox.Border.Disabled", "CheckBox.icon.disabledBorderColor");
      checkboxKeyMapping.put("Checkbox.Focus.Thin.Default", "CheckBox.icon.focusedBorderColor");
      checkboxKeyMapping.put("Checkbox.Focus.Wide", "CheckBox.icon.focusColor");
      checkboxKeyMapping.put("Checkbox.Foreground.Disabled", "CheckBox.icon.disabledCheckmarkColor");
      checkboxKeyMapping.put("Checkbox.Background.Selected", "CheckBox.icon.selectedBackground");
      checkboxKeyMapping.put("Checkbox.Border.Selected", "CheckBox.icon.selectedBorderColor");
      checkboxKeyMapping.put("Checkbox.Foreground.Selected", "CheckBox.icon.checkmarkColor");
      checkboxKeyMapping.put("Checkbox.Focus.Thin.Selected", "CheckBox.icon.focusedSelectedBorderColor");
      checkboxDuplicateColors.put("Checkbox.Background.Default.Dark", "Checkbox.Background.Selected.Dark");
      checkboxDuplicateColors.put("Checkbox.Border.Default.Dark", "Checkbox.Border.Selected.Dark");
      checkboxDuplicateColors.put("Checkbox.Focus.Thin.Default.Dark", "Checkbox.Focus.Thin.Selected.Dark");
      Entry<String, String>[] entries = checkboxDuplicateColors.entrySet().toArray(new Entry[checkboxDuplicateColors.size()]);

      for (Entry<String, String> e : entries) {
         checkboxDuplicateColors.put(e.getValue(), e.getKey());
      }
   }

   public static class ThemeLaf extends FlatLaf {
      private final IntelliJTheme theme;

      public ThemeLaf(IntelliJTheme theme) {
         this.theme = theme;
      }

      @Override
      public String getName() {
         return this.theme.name;
      }

      @Override
      public String getDescription() {
         return this.getName();
      }

      @Override
      public boolean isDark() {
         return this.theme.dark;
      }

      public IntelliJTheme getTheme() {
         return this.theme;
      }

      @Override
      void applyAdditionalDefaults(UIDefaults defaults) {
         this.theme.applyProperties(defaults);
      }

      protected ArrayList<Class<?>> getLafClassesForDefaultsLoading() {
         ArrayList<Class<?>> lafClasses = new ArrayList<>();
         lafClasses.add(FlatLaf.class);
         lafClasses.add(this.theme.dark ? FlatDarkLaf.class : FlatLightLaf.class);
         lafClasses.add(this.theme.dark ? FlatDarculaLaf.class : FlatIntelliJLaf.class);
         lafClasses.add(IntelliJTheme.ThemeLaf.class);
         return lafClasses;
      }
   }
}
