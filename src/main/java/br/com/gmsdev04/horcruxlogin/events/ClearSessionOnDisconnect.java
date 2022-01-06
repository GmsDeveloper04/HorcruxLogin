package br.com.gmsdev04.horcruxlogin.events;

import br.com.gmsdev04.horcruxlogin.repository.LoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryLoginSessionRepository;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ClearSessionOnDisconnect implements Listener {

    private LoginSessionRepository sessionRepository;

    public ClearSessionOnDisconnect(){
        this.sessionRepository =  InMemoryLoginSessionRepository.getInstance();
    }

    @EventHandler
    public void clearSession(PlayerQuitEvent event){
        this.sessionRepository.deleteSession(event.getPlayer().getUniqueId());
    }
}
