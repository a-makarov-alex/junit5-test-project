package database;

import lombok.Data;
import org.apache.log4j.Logger;


@Data
public class TestObjectDB {
    private Logger log = Logger.getLogger(TestObjectDB.class);

    private String name;
    private int age;

    public TestObjectDB() {
    }

    public TestObjectDB(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String insertTestObject(int num) {
        log.info("INSERTING TEST OBJECT TO DB...");
        return "someName_" + num;
    }

    public void deleteTestObject(String name) {
        log.info("DELETING TEST OBJECT: " + name);
    }

    public TestObjectDB findByName(String name) {
        log.info("SEARCHING " + name + " INTO DB...");
        TestObjectDB testObjectDB = new TestObjectDB("name", 12);
        return testObjectDB;
    }
}
