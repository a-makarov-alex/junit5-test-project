package junit.annotation;

import junit.extention.callback.PrepareTestObject;
import junit.extention.resolver.TestObjectResolver;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({PrepareTestObject.class, TestObjectResolver.class})
public @interface CreateTestObject {
}
