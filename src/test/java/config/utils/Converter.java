package config.utils;

import java.util.Arrays;

public class Converter {
    public static String[] split(String string) {
        String[] split = string.split(":", -1);

        if (split.length != 2) {
            throw new IllegalStateException("Config contains mode than key:value pair");
        }

        if (Arrays.stream(split).anyMatch(x -> x.contains("***"))) {
            throw new IllegalStateException("You have not a config, but a template. Key: " + split[0] + " Value: " + split[1]);
        }
        return split;
    }
}
