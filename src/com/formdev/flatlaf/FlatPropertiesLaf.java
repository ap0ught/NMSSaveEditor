package com.formdev.flatlaf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class FlatPropertiesLaf extends FlatLaf {
   private final String name;
   private final String baseTheme;
   private final boolean dark;
   private final Properties properties;

   public FlatPropertiesLaf(String name, File propertiesFile) throws IOException {
      this(name, new FileInputStream(propertiesFile));
   }

   public FlatPropertiesLaf(String name, InputStream in) throws IOException {
      this(name, loadProperties(in));
   }

   private static Properties loadProperties(InputStream in) throws IOException {
      Properties properties = new Properties();
      InputStream in2 = in;

      try {
         properties.load(in2);
      } catch (Throwable var6) {
         if (in != null) {
            try {
               in2.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }
         }

         throw var6;
      }

      if (in != null) {
         in.close();
      }

      return properties;
   }

   public FlatPropertiesLaf(String name, Properties properties) {
      this.name = name;
      this.properties = properties;
      this.baseTheme = properties.getProperty("@baseTheme", "light");
      this.dark = "dark".equalsIgnoreCase(this.baseTheme) || "darcula".equalsIgnoreCase(this.baseTheme);
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public String getDescription() {
      return this.name;
   }

   @Override
   public boolean isDark() {
      return this.dark;
   }

   public Properties getProperties() {
      return this.properties;
   }

   protected ArrayList<Class<?>> getLafClassesForDefaultsLoading() {
      ArrayList<Class<?>> lafClasses = new ArrayList<>();
      lafClasses.add(FlatLaf.class);
      String var2 = this.baseTheme.toLowerCase();
      switch (var2) {
         case "light":
         default:
            lafClasses.add(FlatLightLaf.class);
            break;
         case "dark":
            lafClasses.add(FlatDarkLaf.class);
            break;
         case "intellij":
            lafClasses.add(FlatLightLaf.class);
            lafClasses.add(FlatIntelliJLaf.class);
            break;
         case "darcula":
            lafClasses.add(FlatDarkLaf.class);
            lafClasses.add(FlatDarculaLaf.class);
      }

      return lafClasses;
   }

   @Override
   protected Properties getAdditionalDefaults() {
      return this.properties;
   }
}
