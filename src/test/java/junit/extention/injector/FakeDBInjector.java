package junit.extention.injector;

import com.google.inject.Inject;
import database.DependentObjectDB;
import database.TestObjectDB;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;

public class FakeDBInjector implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext extensionContext) throws Exception {
        Field[] declaredFields = testInstance.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(Inject.class) && field.getType().isAssignableFrom(TestObjectDB.class)) {
                field.setAccessible(true);
                field.set(testInstance, new TestObjectDB("name123", 18));
            }

            if(field.isAnnotationPresent(Inject.class) && field.getType().isAssignableFrom(DependentObjectDB.class)) {
                field.setAccessible(true);
                field.set(testInstance, new DependentObjectDB());
            }
        }
    }
}
