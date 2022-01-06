package br.com.gmsdev04.horcruxlogin.events;

import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryLoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.LoginSessionRepository;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PreventPlayerWithoutLogin implements Listener {

    private LoginSessionRepository sessionRepository;

    public PreventPlayerWithoutLogin(){
        this.sessionRepository =  InMemoryLoginSessionRepository.getInstance();
    }

    @EventHandler
    public void preventMove(PlayerMoveEvent event){
        prevent(event);
    }

    @EventHandler
    public void preventDrop(PlayerDropItemEvent event){
        prevent(event);
    }

    @EventHandler
    public void preventDamage(PlayerItemDamageEvent event){
        prevent(event);
    }

    @EventHandler
    public void preventItemConsume(PlayerItemConsumeEvent event){
        prevent(event);
    }

    private void prevent(PlayerEvent event){
        Player player = event.getPlayer();
        boolean sessionExists = this.sessionRepository.sessionExists(player.getUniqueId());
        Cancellable cancellable = (Cancellable) event;
        if(!cancellable.isCancelled()){
            cancellable.setCancelled(!sessionExists);
        }
    }
}