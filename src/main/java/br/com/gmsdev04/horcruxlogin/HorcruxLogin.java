package br.com.gmsdev04.horcruxlogin;

import br.com.gmsdev04.horcruxlogin.commands.LogarCommand;
import br.com.gmsdev04.horcruxlogin.commands.RegistrarCommand;
import br.com.gmsdev04.horcruxlogin.events.ClearSessionOnDisconnect;
import br.com.gmsdev04.horcruxlogin.events.OnPlayerJoinListener;
import br.com.gmsdev04.horcruxlogin.events.PreventPlayerWithoutLogin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class HorcruxLogin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().log(Level.INFO,"Enabling HorcruxLogin...");
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, "Disabling HorcruxLogin....");
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new OnPlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PreventPlayerWithoutLogin(), this);
        getServer().getPluginManager().registerEvents(new ClearSessionOnDisconnect(), this);
    }

    private void registerCommands(){
        this.getCommand("registrar").setExecutor(new RegistrarCommand());
        this.getCommand("logar").setExecutor(new LogarCommand());
    }

}
