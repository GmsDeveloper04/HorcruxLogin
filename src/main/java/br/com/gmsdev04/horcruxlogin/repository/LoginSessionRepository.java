package br.com.gmsdev04.horcruxlogin.repository;

import java.util.UUID;

public interface LoginSessionRepository {
    boolean sessionExists(UUID uniqueId);
    void createSession(UUID uniqueId);
    void deleteSession(UUID uniqueId);
}
