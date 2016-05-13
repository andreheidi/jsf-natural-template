package br.com.moriya.model.annotation.validator;

import br.com.moriya.model.annotation.UniqueColumn;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 5/8/16.
 */
public class UniqueColumnValidator implements ConstraintValidator<UniqueColumn, Serializable> {

    private String[] columnsName;

    @Inject
    private EntityManager entityManager;

    public void initialize(UniqueColumn uniqueColumn) {
        this.columnsName = uniqueColumn.columnsName();
    }

    public boolean isValid(Serializable serializable, ConstraintValidatorContext constraintValidatorContext) {
        Class<?> entity = serializable.getClass();

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> query = builder.createQuery();

        Root<?> root = query.from(entity);

        List<Predicate> predicates = new ArrayList<Predicate>(columnsName.length);

        try {
            for(int index = 0; index < columnsName.length; index++) {
                String propertyName = columnsName[index];
                PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, entity);
                Method method = descriptor.getReadMethod();

                Object value = method.invoke(serializable);

                Predicate predicate = builder.equal(root.get(propertyName), value);

                predicates.add(predicate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Object> typedQuery = this.entityManager.createQuery(query);
        List<Object> resultSet = typedQuery.getResultList();


        return resultSet.size() == 0;
    }

}