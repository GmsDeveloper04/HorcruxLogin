package br.com.gmsdev04.horcruxlogin.repository;

import br.com.gmsdev04.horcruxlogin.domain.User;

public interface UserRepository {

    boolean userExists(String nickname);
    boolean createUser(User user);
    User getUser(String nickname);

}
