package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/env/${env}.properties"
})
public interface EnvConfig extends Config {
    @Key("keycloak.url")
    String keycloakUrl();

    @Key("stand.url")
    String standUrl();

    @Key("db.url")
    String dbUrl();
}
