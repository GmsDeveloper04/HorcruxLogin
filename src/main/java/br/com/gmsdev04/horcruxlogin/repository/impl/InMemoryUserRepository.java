package br.com.gmsdev04.horcruxlogin.repository.impl;

import br.com.gmsdev04.horcruxlogin.domain.User;
import br.com.gmsdev04.horcruxlogin.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String,User> users;
    private static InMemoryUserRepository INSTANCE;

    private InMemoryUserRepository(){
        this.users = new HashMap<>();
    }

    public static InMemoryUserRepository getInstace(){
        if(INSTANCE == null){
            INSTANCE = new InMemoryUserRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean userExists(String nickname) {
        return this.users.containsKey(nickname);
    }

    @Override
    public boolean createUser(User user) {
        this.users.put(user.getNickname(),user);
        return true;
    }

    @Override
    public User getUser(String nickname) {
        return this.users.get(nickname);
    }
}
