package junit.annotation;

import junit.extention.callback.PrepareDependentObject;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith({PrepareDependentObject, })
public @interface CreateDependentObject {
}
