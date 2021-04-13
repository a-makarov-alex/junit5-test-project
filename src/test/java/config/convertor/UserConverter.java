package config.convertor;

import config.model.UserConfig;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

/**
 * Класс отвечает за указание, как именно парсить конфиг подобного рода (key:value)
 */
public class UserConverter implements Converter<UserConfig> {

    @Override
    public UserConfig convert(Method method, String value) {
        String[] splitResult = config.utils.Converter.split(value);
        return new UserConfig(splitResult[0], splitResult[1]);
    }
}
