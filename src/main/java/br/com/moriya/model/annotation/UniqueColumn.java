package br.com.moriya.model.annotation;

import br.com.moriya.model.annotation.validator.UniqueColumnValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by andre on 5/8/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = UniqueColumnValidator.class)
public @interface UniqueColumn {

    String[] columnsName();

    String message() default "The name '${validatedValue}' is already registered";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
