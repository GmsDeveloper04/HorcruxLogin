package br.com.gmsdev04.horcruxlogin.commands;

import br.com.gmsdev04.horcruxlogin.domain.User;
import br.com.gmsdev04.horcruxlogin.repository.LoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.UserRepository;
import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryLoginSessionRepository;
import br.com.gmsdev04.horcruxlogin.repository.impl.InMemoryUserRepository;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LogarCommand implements CommandExecutor {

    private final UserRepository userRepository;
    private final LoginSessionRepository loginSessionRepository;

    public LogarCommand(){
        this.userRepository =  InMemoryUserRepository.getInstace();
        this.loginSessionRepository = InMemoryLoginSessionRepository.getInstance();
    }
    
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            
            if(args != null && args.length == 1) {
                User user = this.userRepository.getUser(player.getName());

                boolean validPassword = user.getPassword().equals(args[0]);

                if(validPassword) {
                    this.loginSessionRepository.createSession(player.getUniqueId());
                    player.sendMessage("Logado com sucesso!");
                }else{
                    player.sendMessage("Senha inválida");
                }

                return true;
            }
        }else{
            commandSender.sendMessage("Você precisa ser um jogador para usar este comando");
        }
        return false;
    }
}
