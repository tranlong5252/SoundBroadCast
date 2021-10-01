package tranlong5252.soundbroadcast.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Config {

    private static String INS;
    private static String PREFIX;

    public static void reload(JavaPlugin plugin) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
        INS = config.getString("instrument");
        PREFIX = config.getString("prefix") + "&r ";
    }

    public static String getInstrument() {
        return INS.toLowerCase();
    }

    public static String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', PREFIX);
    }
}
