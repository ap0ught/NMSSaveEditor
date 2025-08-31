// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.ui;

import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.awt.Image;
import java.lang.reflect.Method;
import com.formdev.flatlaf.util.LoggingFacade;
import javax.swing.filechooser.FileSystemView;
import javax.swing.ButtonGroup;
import java.util.function.Function;
import javax.swing.JToolBar;
import com.formdev.flatlaf.util.ScaledImageIcon;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.io.File;
import javax.swing.plaf.basic.BasicFileChooserUI;
import javax.swing.filechooser.FileView;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.AbstractButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JFileChooser;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class FlatFileChooserUI extends MetalFileChooserUI
{
    private final FlatFileView fileView;
    private FlatShortcutsPanel shortcutsPanel;
    
    public static ComponentUI createUI(final JComponent c) {
        return new FlatFileChooserUI((JFileChooser)c);
    }
    
    public FlatFileChooserUI(final JFileChooser filechooser) {
        super(filechooser);
        this.fileView = new FlatFileView();
    }
    
    @Override
    public void installComponents(final JFileChooser fc) {
        super.installComponents(fc);
        this.patchUI(fc);
        if (!UIManager.getBoolean("FileChooser.noPlacesBar")) {
            final FlatShortcutsPanel panel = this.createShortcutsPanel(fc);
            if (panel.getComponentCount() > 0) {
                fc.add(this.shortcutsPanel = panel, "Before");
                fc.addPropertyChangeListener(this.shortcutsPanel);
            }
        }
    }
    
    @Override
    public void uninstallComponents(final JFileChooser fc) {
        super.uninstallComponents(fc);
        if (this.shortcutsPanel != null) {
            fc.removePropertyChangeListener(this.shortcutsPanel);
            this.shortcutsPanel = null;
        }
    }
    
    private void patchUI(final JFileChooser fc) {
        final Component topPanel = fc.getComponent(0);
        if (topPanel instanceof JPanel && ((JPanel)topPanel).getLayout() instanceof BorderLayout) {
            final Component topButtonPanel = ((JPanel)topPanel).getComponent(0);
            if (topButtonPanel instanceof JPanel && ((JPanel)topButtonPanel).getLayout() instanceof BoxLayout) {
                final Insets margin = UIManager.getInsets("Button.margin");
                final Component[] comps = ((JPanel)topButtonPanel).getComponents();
                for (int i = comps.length - 1; i >= 0; --i) {
                    final Component c = comps[i];
                    if (c instanceof JButton || c instanceof JToggleButton) {
                        final AbstractButton b = (AbstractButton)c;
                        b.putClientProperty("JButton.buttonType", "toolBarButton");
                        b.setMargin(margin);
                        b.setFocusable(false);
                    }
                    else if (c instanceof Box.Filler) {
                        ((JPanel)topButtonPanel).remove(i);
                    }
                }
            }
        }
        try {
            final Component directoryComboBox = ((JPanel)topPanel).getComponent(2);
            if (directoryComboBox instanceof JComboBox) {
                final int maximumRowCount = UIManager.getInt("ComboBox.maximumRowCount");
                if (maximumRowCount > 0) {
                    ((JComboBox)directoryComboBox).setMaximumRowCount(maximumRowCount);
                }
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {}
        final LayoutManager layout = fc.getLayout();
        if (layout instanceof BorderLayout) {
            final BorderLayout borderLayout = (BorderLayout)layout;
            borderLayout.setHgap(8);
            final Component north = borderLayout.getLayoutComponent("North");
            final Component lineEnd = borderLayout.getLayoutComponent("After");
            final Component center = borderLayout.getLayoutComponent("Center");
            final Component south = borderLayout.getLayoutComponent("South");
            if (north != null && lineEnd != null && center != null && south != null) {
                final JPanel p = new JPanel(new BorderLayout(0, 11));
                p.add(north, "North");
                p.add(lineEnd, "After");
                p.add(center, "Center");
                p.add(south, "South");
                fc.add(p, "Center");
            }
        }
    }
    
    @Override
    protected JPanel createDetailsView(final JFileChooser fc) {
        final JPanel p = super.createDetailsView(fc);
        if (!SystemInfo.isWindows) {
            return p;
        }
        JScrollPane scrollPane = null;
        for (final Component c : p.getComponents()) {
            if (c instanceof JScrollPane) {
                scrollPane = (JScrollPane)c;
                break;
            }
        }
        if (scrollPane == null) {
            return p;
        }
        final Component view = scrollPane.getViewport().getView();
        if (!(view instanceof JTable)) {
            return p;
        }
        final JTable table = (JTable)view;
        final TableCellRenderer defaultRenderer = table.getDefaultRenderer(Object.class);
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(final JTable table, Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
                if (value instanceof String && ((String)value).startsWith("\u200e")) {
                    final String str = (String)value;
                    final char[] buf = new char[str.length()];
                    int j = 0;
                    for (int i = 0; i < buf.length; ++i) {
                        final char ch = str.charAt(i);
                        if (ch != '\u200e' && ch != '\u200f') {
                            buf[j++] = ch;
                        }
                    }
                    value = new String(buf, 0, j);
                }
                return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        return p;
    }
    
    protected FlatShortcutsPanel createShortcutsPanel(final JFileChooser fc) {
        return new FlatShortcutsPanel(fc);
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        final Dimension prefSize = super.getPreferredSize(c);
        final Dimension minSize = this.getMinimumSize(c);
        final int shortcutsPanelWidth = (this.shortcutsPanel != null) ? this.shortcutsPanel.getPreferredSize().width : 0;
        return new Dimension(Math.max(prefSize.width, minSize.width + shortcutsPanelWidth), Math.max(prefSize.height, minSize.height));
    }
    
    @Override
    public Dimension getMinimumSize(final JComponent c) {
        return UIScale.scale(super.getMinimumSize(c));
    }
    
    @Override
    public FileView getFileView(final JFileChooser fc) {
        return this.doNotUseSystemIcons() ? super.getFileView(fc) : this.fileView;
    }
    
    @Override
    public void clearIconCache() {
        if (this.doNotUseSystemIcons()) {
            super.clearIconCache();
        }
        else {
            this.fileView.clearIconCache();
        }
    }
    
    private boolean doNotUseSystemIcons() {
        return SystemInfo.isWindows && SystemInfo.isX86 && SystemInfo.isJava_17_orLater && !SystemInfo.isJava_18_orLater;
    }
    
    private class FlatFileView extends BasicFileView
    {
        @Override
        public Icon getIcon(final File f) {
            Icon icon = this.getCachedIcon(f);
            if (icon != null) {
                return icon;
            }
            if (f != null) {
                icon = FlatFileChooserUI.this.getFileChooser().getFileSystemView().getSystemIcon(f);
                if (icon != null) {
                    if (icon instanceof ImageIcon) {
                        icon = new ScaledImageIcon((ImageIcon)icon);
                    }
                    this.cacheIcon(f, icon);
                    return icon;
                }
            }
            icon = super.getIcon(f);
            if (icon instanceof ImageIcon) {
                icon = new ScaledImageIcon((ImageIcon)icon);
                this.cacheIcon(f, icon);
            }
            return icon;
        }
    }
    
    public static class FlatShortcutsPanel extends JToolBar implements PropertyChangeListener
    {
        private final JFileChooser fc;
        private final Dimension buttonSize;
        private final Dimension iconSize;
        private final Function<File[], File[]> filesFunction;
        private final Function<File, String> displayNameFunction;
        private final Function<File, Icon> iconFunction;
        protected final File[] files;
        protected final JToggleButton[] buttons;
        protected final ButtonGroup buttonGroup;
        
        public FlatShortcutsPanel(final JFileChooser fc) {
            super(1);
            this.fc = fc;
            this.setFloatable(false);
            this.buttonSize = UIScale.scale(this.getUIDimension("FileChooser.shortcuts.buttonSize", 84, 64));
            this.iconSize = this.getUIDimension("FileChooser.shortcuts.iconSize", 32, 32);
            this.filesFunction = (Function)UIManager.get("FileChooser.shortcuts.filesFunction");
            this.displayNameFunction = (Function)UIManager.get("FileChooser.shortcuts.displayNameFunction");
            this.iconFunction = (Function)UIManager.get("FileChooser.shortcuts.iconFunction");
            final FileSystemView fsv = fc.getFileSystemView();
            File[] files = this.getChooserShortcutPanelFiles(fsv);
            if (this.filesFunction != null) {
                files = this.filesFunction.apply(files);
            }
            this.files = files;
            this.buttons = new JToggleButton[files.length];
            this.buttonGroup = new ButtonGroup();
            for (int i = 0; i < files.length; ++i) {
                if (fsv.isFileSystemRoot(files[i])) {
                    files[i] = fsv.createFileObject(files[i].getAbsolutePath());
                }
                final File file = files[i];
                String name = this.getDisplayName(fsv, file);
                Icon icon = this.getIcon(fsv, file);
                final int lastSepIndex = name.lastIndexOf(File.separatorChar);
                if (lastSepIndex >= 0 && lastSepIndex < name.length() - 1) {
                    name = name.substring(lastSepIndex + 1);
                }
                if (icon instanceof ImageIcon) {
                    icon = new ScaledImageIcon((ImageIcon)icon, this.iconSize.width, this.iconSize.height);
                }
                else if (icon != null) {
                    icon = new ShortcutIcon(icon, this.iconSize.width, this.iconSize.height);
                }
                final JToggleButton button = this.createButton(name, icon);
                button.addActionListener(e -> fc.setCurrentDirectory(file));
                this.add(button);
                this.buttonGroup.add(button);
                this.buttons[i] = button;
            }
            this.directoryChanged(fc.getCurrentDirectory());
        }
        
        private Dimension getUIDimension(final String key, final int defaultWidth, final int defaultHeight) {
            Dimension size = UIManager.getDimension(key);
            if (size == null) {
                size = new Dimension(defaultWidth, defaultHeight);
            }
            return size;
        }
        
        protected JToggleButton createButton(final String name, final Icon icon) {
            final JToggleButton button = new JToggleButton(name, icon);
            button.setVerticalTextPosition(3);
            button.setHorizontalTextPosition(0);
            button.setAlignmentX(0.5f);
            button.setIconTextGap(0);
            button.setPreferredSize(this.buttonSize);
            button.setMaximumSize(this.buttonSize);
            return button;
        }
        
        protected File[] getChooserShortcutPanelFiles(final FileSystemView fsv) {
            try {
                if (SystemInfo.isJava_12_orLater) {
                    final Method m = fsv.getClass().getMethod("getChooserShortcutPanelFiles", (Class<?>[])new Class[0]);
                    File[] files = (File[])m.invoke(fsv, new Object[0]);
                    if (files.length == 1 && files[0].equals(new File(System.getProperty("user.home")))) {
                        files = new File[0];
                    }
                    return files;
                }
                if (SystemInfo.isWindows) {
                    final Class<?> cls = Class.forName("sun.awt.shell.ShellFolder");
                    final Method i = cls.getMethod("get", String.class);
                    return (File[])i.invoke(null, "fileChooserShortcutPanelFolders");
                }
            }
            catch (final IllegalAccessException ex2) {}
            catch (final Exception ex) {
                LoggingFacade.INSTANCE.logSevere(null, ex);
            }
            return new File[0];
        }
        
        protected String getDisplayName(final FileSystemView fsv, final File file) {
            if (this.displayNameFunction != null) {
                final String name = this.displayNameFunction.apply(file);
                if (name != null) {
                    return name;
                }
            }
            return fsv.getSystemDisplayName(file);
        }
        
        protected Icon getIcon(final FileSystemView fsv, final File file) {
            if (this.iconFunction != null) {
                final Icon icon = this.iconFunction.apply(file);
                if (icon != null) {
                    return icon;
                }
            }
            try {
                if (SystemInfo.isJava_17_orLater) {
                    final Method m = fsv.getClass().getMethod("getSystemIcon", File.class, Integer.TYPE, Integer.TYPE);
                    return (Icon)m.invoke(fsv, file, this.iconSize.width, this.iconSize.height);
                }
                if (this.iconSize.width > 16 || this.iconSize.height > 16) {
                    final Class<?> cls = Class.forName("sun.awt.shell.ShellFolder");
                    if (cls.isInstance(file)) {
                        final Method i = file.getClass().getMethod("getIcon", Boolean.TYPE);
                        i.setAccessible(true);
                        final Image image = (Image)i.invoke(file, true);
                        if (image != null) {
                            return new ImageIcon(image);
                        }
                    }
                }
            }
            catch (final IllegalAccessException ex2) {}
            catch (final Exception ex) {
                LoggingFacade.INSTANCE.logSevere(null, ex);
            }
            return fsv.getSystemIcon(file);
        }
        
        protected void directoryChanged(final File file) {
            if (file != null) {
                final String absolutePath = file.getAbsolutePath();
                for (int i = 0; i < this.files.length; ++i) {
                    if (this.files[i].equals(file) || this.files[i].getAbsolutePath().equals(absolutePath)) {
                        this.buttons[i].setSelected(true);
                        return;
                    }
                }
            }
            this.buttonGroup.clearSelection();
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String propertyName = e.getPropertyName();
            switch (propertyName) {
                case "directoryChanged": {
                    this.directoryChanged(this.fc.getCurrentDirectory());
                    break;
                }
            }
        }
    }
    
    private static class ShortcutIcon implements Icon
    {
        private final Icon icon;
        private final int iconWidth;
        private final int iconHeight;
        
        ShortcutIcon(final Icon icon, final int iconWidth, final int iconHeight) {
            this.icon = icon;
            this.iconWidth = iconWidth;
            this.iconHeight = iconHeight;
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Graphics2D g2 = (Graphics2D)g.create();
            try {
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                final double scale = this.getIconWidth() / (double)this.icon.getIconWidth();
                g2.translate(x, y);
                g2.scale(scale, scale);
                this.icon.paintIcon(c, g2, 0, 0);
            }
            finally {
                g2.dispose();
            }
        }
        
        @Override
        public int getIconWidth() {
            return UIScale.scale(this.iconWidth);
        }
        
        @Override
        public int getIconHeight() {
            return UIScale.scale(this.iconHeight);
        }
    }
}
