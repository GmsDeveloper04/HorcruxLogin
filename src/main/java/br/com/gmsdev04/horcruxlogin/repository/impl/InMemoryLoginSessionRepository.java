package br.com.gmsdev04.horcruxlogin.repository.impl;

import br.com.gmsdev04.horcruxlogin.repository.LoginSessionRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class InMemoryLoginSessionRepository implements LoginSessionRepository {

    private static InMemoryLoginSessionRepository INSTANCE;
    private Set<UUID> sessions;

    private InMemoryLoginSessionRepository() {
        this.sessions = new HashSet<>();
    }

    public static InMemoryLoginSessionRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new InMemoryLoginSessionRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean sessionExists(UUID uniqueId) {
        return this.sessions.contains(uniqueId);
    }

    @Override
    public void createSession(UUID uniqueId) {
        this.sessions.add(uniqueId);
    }

    @Override
    public void deleteSession(UUID uniqueId) {
        this.sessions.remove(uniqueId);
    }
}
