package tranlong5252.soundbroadcast;

import org.bukkit.plugin.java.JavaPlugin;
import tranlong5252.soundbroadcast.command.CommandMain;
import tranlong5252.soundbroadcast.config.Config;

import java.util.Objects;

public final class SoundBroadcast extends JavaPlugin {

    static SoundBroadcast main;

    public static SoundBroadcast getInstance() {
        return main;
    }

    @Override
    public void onEnable() {
        main = this;
        reloadConfig();
        registerCommands();
    }

    public void registerCommands() {
        CommandMain cmd = new CommandMain();
        Objects.requireNonNull(getCommand("sbc")).setExecutor(cmd);
    }

    @Override
    public void reloadConfig() {
        saveDefaultConfig();
        Config.reload(this);
    }
}
