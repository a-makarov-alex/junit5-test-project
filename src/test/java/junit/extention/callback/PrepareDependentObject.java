package junit.extention.callback;

import common.Utils;
import database.DependentObjectDB;
import junit.annotation.CreateDependentObject;
import junit.extention.JunitStoreConst;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.ArrayList;
import java.util.List;

public class PrepareDependentObject implements BeforeEachCallback, AfterEachCallback {
    private final DependentObjectDB dependentObjectDB = new DependentObjectDB();
    private final List<String> dependentObjectNames = new ArrayList<>(); // Будем собирать имена созданных объектов

    @Override
    @SuppressWarnings("unchecked") // снимает предупреждение в коде
    public void beforeEach(ExtensionContext context) throws Exception {
        context.getTestMethod().ifPresent(x -> {
            if (x.isAnnotationPresent(CreateDependentObject.class)) {
                List<String> testObjects = context.getStore(ExtensionContext.Namespace.GLOBAL)
                        .get(JunitStoreConst.TEST_OBJECT_LIST, List.class);

                String depName1 = dependentObjectDB.insertDependentObject(Utils.getRandomNumberInRange(1,100), testObjects.get(0));
                dependentObjectNames.add(depName1);
                context.getStore(ExtensionContext.Namespace.GLOBAL).put(JunitStoreConst.DEPENDENT_OBJECT, depName1);
            }
        });
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {

    }
}
