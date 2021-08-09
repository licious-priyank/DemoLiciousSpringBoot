
package com.priyank.db.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = LongValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface IsLong {
    String message() default "Should be a Long Integer";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
