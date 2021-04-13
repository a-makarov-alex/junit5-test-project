package database;

import lombok.Data;
import org.apache.log4j.Logger;

@Data
public class DependentObjectDB {
    private Logger log = Logger.getLogger(DependentObjectDB.class);

    private String name;
    private TestObjectDB testObjectDB;

    public String insertDependentObject(int num, String testObjectName) {
        log.info("INSERTING DEPENDENT OBJECT " + num + " TO DB WITH TEST OBJECT: " + testObjectDB.getName());
        return "dependentName_" + num;
    }

    public void deleteDependentObject(String name) {
        log.info("DELETING DEPENDENT OBJECT: " + name);
    }
}
