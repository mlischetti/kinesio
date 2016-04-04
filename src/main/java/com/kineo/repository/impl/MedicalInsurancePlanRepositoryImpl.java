package com.kineo.repository.impl;

import com.kineo.model.MedicalInsurancePlan;
import com.kineo.repository.MedicalInsurancePlanRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mlischetti on 12/8/15.
 */
@Repository
public class MedicalInsurancePlanRepositoryImpl extends GenericRepository<MedicalInsurancePlan> implements MedicalInsurancePlanRepository {

    @Autowired
    public MedicalInsurancePlanRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<MedicalInsurancePlan> find(int firstResult, int maxResults) {
        Criteria criteria = getCriteria();
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        criteria.add(Restrictions.eq("deleted", Boolean.FALSE));
        return criteria.list();
    }
}
