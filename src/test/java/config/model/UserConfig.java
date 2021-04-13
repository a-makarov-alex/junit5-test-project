package config.model;

import lombok.Getter;


/**
 * Класс маппится на проперти данных пользователя
 */
@Getter
public class UserConfig {
    private final String username;
    private final String password;

    public UserConfig(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
