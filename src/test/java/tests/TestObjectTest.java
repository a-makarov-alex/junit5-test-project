package tests;

import api_requests.MailRuAPI;
import com.google.inject.Inject;
import database.TestObjectDB;
import junit.annotation.CreateTestObject;
import junit.annotation.Existing;
import junit.annotation.Generated;
import junit.extention.injector.APIInjector;
import junit.extention.injector.FakeDBInjector;
import model.TestObjectClass;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({APIInjector.class, FakeDBInjector.class})
public class TestObjectTest {
    private static final Logger log = Logger.getLogger(TestObjectTest.class);

    @Inject
    private TestObjectDB testObjectDB;
    @Inject
    private MailRuAPI mailRuAPI;

    @Test
    public void firstTest() {
        log.info("FIRST TEST START");
        log.info("INJECTED: " + testObjectDB.getName());
        log.info("INJECTED: " + mailRuAPI.AUTH_TOKEN);
    }

    @Test
    @CreateTestObject
    public void secondTest(String testObjectName) {
        log.info("SECOND TEST START");
        log.info("INJECTED: " + testObjectName);
    }
}
