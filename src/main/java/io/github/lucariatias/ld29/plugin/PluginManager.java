package io.github.lucariatias.ld29.plugin;

import io.github.lucariatias.ld29.Descent;
import io.github.lucariatias.ld29.event.plugin.PluginDisableEvent;
import io.github.lucariatias.ld29.event.plugin.PluginEnableEvent;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginManager {

    private Descent descent;

    private File pluginsDirectory;

    private Set<Plugin> plugins = new HashSet<>();

    public PluginManager(Descent descent) {
        this.descent = descent;
        pluginsDirectory = new File("./plugins");
    }

    public void loadPlugins() {
        /*if (pluginsDirectory.exists()) {
            for (File file : pluginsDirectory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            })) {
                loadPlugin(file);
            }
        } else {
            pluginsDirectory.mkdir();
        }*/
    }

    public Plugin loadPlugin(File file) {
        try {
            JarFile jarFile;
            jarFile = new JarFile(file);
            Enumeration<JarEntry> entries = jarFile.entries();
            String mainClass = null;
            while (entries.hasMoreElements()) {
                JarEntry element = entries.nextElement();
                if (element.getName().equalsIgnoreCase("plugin.yml")) {
                    Yaml pluginYaml = new Yaml();
                    Map<String, Object> yamlSections = (Map<String, Object>) pluginYaml.load(new InputStreamReader(jarFile.getInputStream(element)));
                    mainClass = (String) yamlSections.get("main");
                    break;
                }
            }
            if (mainClass != null) {
                ClassLoader loader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()}, getClass().getClassLoader());
                Class<?> clazz = Class.forName(mainClass, true, loader);
                for (Class<?> subclazz : clazz.getClasses()) {
                    Class.forName(subclazz.getName(), true, loader);
                }
                Class<? extends Plugin> pluginClass = clazz.asSubclass(Plugin.class);
                Plugin plugin = pluginClass.newInstance();
                addPlugin(plugin);
                return plugin;
            } else {
                descent.getLogger().warning("Main class not found for plugin: " + file.getName());
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Plugin loadPlugin(Class<? extends Plugin> clazz) {
        try {
            Plugin plugin = clazz.newInstance();
            addPlugin(plugin);
            return plugin;
        } catch (InstantiationException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void addPlugin(Plugin plugin) {
        descent.getLogger().info("Loading plugin: " + plugin.getName());
        PluginEnableEvent pluginEnableEvent = new PluginEnableEvent(plugin);
        descent.getEventManager().dispatchEvent(pluginEnableEvent);
        if (!pluginEnableEvent.isCancelled()) {
            plugin.onEnable();
            plugins.add(plugin);
            descent.getLogger().info(plugin.getName() + " successfully enabled!");
        } else {
            descent.getLogger().warning(plugin.getName() + " was cancelled from loading.");
        }
    }

    public void removePlugin(Plugin plugin) {
        descent.getLogger().info("Unloading plugin: " + plugin.getName());
        PluginDisableEvent pluginDisableEvent = new PluginDisableEvent(plugin);
        descent.getEventManager().dispatchEvent(pluginDisableEvent);
        plugin.onDisable();
        plugins.remove(plugin);
        descent.getLogger().info(plugin.getName() + " successfully disabled.");
    }


}
