package common;

import model.TestObjectClass;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    /**
     * Метод может быть полезен при параллелизации, т.к. видимо он относится к конкретному потоку.
     */
    public static int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Пример использования double brace инициализации.
     * Она позволяет создавать коллекции и объекты одновременно с их объявлением.
     * Она может быть актуальна при задании, например, списков с фиксированными значениями (unmodifiableList).
     */
    public static TestObjectClass getRandomTestObject() {
        int i = getRandomNumberInRange(1,100);
        return new TestObjectClass() {{
            setName("name_" + i);
            setAge(i);
        }};
    }
}
