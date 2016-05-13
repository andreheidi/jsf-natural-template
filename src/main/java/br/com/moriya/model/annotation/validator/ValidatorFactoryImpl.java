package br.com.moriya.model.annotation.validator;

import javax.persistence.EntityManagerFactory;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * Created by andre on 5/8/16.
 */
public class ValidatorFactoryImpl implements ConstraintValidatorFactory {

    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> aClass) {
        T instance = null;

        try {
            instance = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {
    }
}
