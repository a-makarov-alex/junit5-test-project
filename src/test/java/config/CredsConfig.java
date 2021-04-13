package config;

import config.convertor.UserConverter;
import config.model.UserConfig;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/creds/creds.properties"
})
public interface CredsConfig extends Config {
    @Separator(":")
    @Key("keycloak.user")
    @ConverterClass(UserConverter.class)
    UserConfig keycloakUser();

    @Separator(":")
    @Key("db.user")
    @ConverterClass(UserConverter.class)
    UserConfig dbUser();

    @Separator(":")
    @Key("some.valuable.info")
    @ConverterClass(UserConverter.class)
    UserConfig someValuableInfo();
}
