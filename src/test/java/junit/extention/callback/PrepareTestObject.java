package junit.extention.callback;

import common.Utils;
import database.TestObjectDB;
import junit.annotation.CreateDependentObject;
import junit.annotation.CreateTestObject;
import junit.annotation.CreateTwoTestObjects;
import junit.extention.JunitStoreConst;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.ArrayList;
import java.util.List;

public class PrepareTestObject implements BeforeEachCallback, AfterEachCallback {

    private final TestObjectDB testObjectDB = new TestObjectDB();
    private final List<String> testObjectNames = new ArrayList<>(); // Будем собирать имена созданных объектов

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        context.getTestMethod().ifPresent(x -> {
            if (x.isAnnotationPresent(CreateTwoTestObjects.class)) {
                String objName1 = testObjectDB.insertTestObject(Utils.getRandomNumberInRange(1,100));
                String objName2 = testObjectDB.insertTestObject(Utils.getRandomNumberInRange(1,100));
                testObjectNames.add(objName1);
                testObjectNames.add(objName2);
                context.getStore(ExtensionContext.Namespace.GLOBAL).put(JunitStoreConst.TEST_OBJECT_LIST, testObjectNames);
            } else {
                if (x.isAnnotationPresent(CreateTestObject.class)) {
                    String objName = testObjectDB.insertTestObject(Utils.getRandomNumberInRange(1, 100));
                    testObjectNames.add(objName);
                    context.getStore(ExtensionContext.Namespace.GLOBAL).put(JunitStoreConst.TEST_OBJECT, objName);
                }
            }
        });
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        testObjectNames.forEach(testObjectDB::deleteTestObject);
    }
}
