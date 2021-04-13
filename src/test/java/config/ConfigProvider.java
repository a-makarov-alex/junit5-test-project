package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Этот класс отвечает за парсинг строки типа key:value. Просто разбивает её и возвращает массив с 2 значениями.
 */
public interface ConfigProvider {
    default EnvConfig getEnvProps() {
        // не до конца ясен смысл System.getProperties(), но можно и без них использовать конструктор с 1 параметром
        return ConfigFactory.create(EnvConfig.class, System.getProperties());
    }

    default CredsConfig getCredsProps() {
        return ConfigFactory.create(CredsConfig.class, System.getProperties());
    }
}
