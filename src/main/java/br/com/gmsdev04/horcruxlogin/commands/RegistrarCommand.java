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

import java.util.Arrays;

import static java.util.Objects.isNull;

public class RegistrarCommand implements CommandExecutor {

    private UserRepository userRepository;
    private LoginSessionRepository loginSessionRepository;

    public RegistrarCommand(){
        this.userRepository = InMemoryUserRepository.getInstace();
        this.loginSessionRepository = InMemoryLoginSessionRepository.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(commandIsValid(args)){

                boolean userExists = userRepository.userExists(player.getName());
                if(!userExists){
                    User user = User.builder().nickname(player.getName()).password(args[0]).build();
                    userRepository.createUser(user);

                    loginSessionRepository.createSession(player.getUniqueId());

                    player.sendMessage("Registrado com sucesso");
                }else{
                    player.sendMessage("Usuário já cadastrado");
                }

                return true;

            }
        }

        sender.sendMessage("Você precisa ser um jogador para usar este comando");

        return false;
    }

    private boolean commandIsValid(String[] args) {
        System.out.println("COMAND IS VALID ->"+ Arrays.toString(args));
        return args.length == 2 && !isNull(args[0]) && !isNull(args[1]) && args[0].equals(args[1]);
    }
}
