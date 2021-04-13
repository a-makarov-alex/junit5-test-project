package junit.extention.injector;

import api_requests.MailRuAPI;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class APIInjector implements TestInstancePostProcessor, AfterEachCallback {
    private Logger log = Logger.getLogger(APIInjector.class);

    /**
     * В роли testInstance выступает тестовый класс, в котором мы прописываем, какие объекты хотели бы заинджектить
     */
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext extensionContext) throws Exception {
        log.info("POST PROCESS TEST INSTANCE FROM INJECTOR");
        Set<Field> collectInjectsField = Arrays.stream(testInstance.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class)).collect(Collectors.toSet());

        for (Field field : collectInjectsField) {
            if (field.getType().isAssignableFrom(MailRuAPI.class)) {
                field.setAccessible(true);
                field.set(testInstance, new MailRuAPI());
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        log.info("AFTER EACH FROM INJECTOR");

    }
}
