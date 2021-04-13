package junit.extention.resolver;

import database.TestObjectDB;
import junit.annotation.Existing;
import junit.annotation.Generated;
import junit.extention.JunitStoreConst;
import model.TestObjectClass;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class TestObjectResolver implements ParameterResolver {
    private Logger log = Logger.getLogger(TestObjectResolver.class);

    //private final TestObjectDB testObjectDB = new TestObjectDB();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        boolean b = parameterContext.getParameter().getType() == TestObjectClass.class;
        log.info("SUPPORTS PARAMETER: " + parameterContext.getParameter().getType());
        return b;
    }

    @Override
    public TestObjectClass resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
       // TestObjectDB testObjectDB = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                //.get(JunitStoreConst.TEST_OBJECT, TestObjectDB.class);
                // TODO сначала сделал со строкой, переделать потом на объект
        String testObjName = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                .get(JunitStoreConst.TEST_OBJECT, String.class);

        if (parameterContext.isAnnotated(Existing.class)) {
            // ЭТО ТИПА ОБЪЕКТ, СУЩЕСТВУЮЩИЙ В БД
            //TestObjectDB tobjDB = testObjectDB.findByName(testObjectDB.getName());
            TestObjectDB tobjDB = new TestObjectDB("nameFromResolver", 17);
            log.info("RETURNING TEST OBJECT FROM DB (RESOLVER)");
            return mapFrom(tobjDB);
        }
        if (parameterContext.isAnnotated(Generated.class)) {
            log.info("RETURNING NEW TEST OBJECT (RESOLVER)");
            TestObjectClass tobjClass = new TestObjectClass("newName", 15);
            return tobjClass;
        }
        return null;
    }

    /**
     * Создаем объект TestObjectClass из объекта БД
     */
    private TestObjectClass mapFrom(TestObjectDB tobjDB) {
        TestObjectClass tobjClass = new TestObjectClass();
        tobjClass.setName(tobjDB.getName());
        tobjClass.setAge(tobjDB.getAge());
        return tobjClass;
    }
}
