package br.com.gmsdev04.horcruxlogin.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String nickname;
    private String password;
}
