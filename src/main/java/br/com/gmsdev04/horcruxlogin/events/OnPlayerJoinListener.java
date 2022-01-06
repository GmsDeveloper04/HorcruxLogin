package br.com.gmsdev04.horcruxlogin.events;

import br.com.gmsdev04.horcruxlogin.repository.LoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryLoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryUserRepository;
import br.com.gmsdev04.horcruxlogin.repository.UserRepository;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinListener implements Listener {

    private UserRepository userRepository;
    public OnPlayerJoinListener(){
        this.userRepository = InMemoryUserRepository.getInstace();
    }

    @EventHandler
    public void handle(PlayerJoinEvent event){
        Player player = event.getPlayer();

        boolean userExists = this.userRepository.userExists(player.getName());

        if(userExists) {
            player.sendMessage("Favor se logar no servidor com o comando /logar senha");
        }else{
            player.sendMessage("Favor se registrar no servidor com o comando /registrar senha senha");
        }

    }
}
