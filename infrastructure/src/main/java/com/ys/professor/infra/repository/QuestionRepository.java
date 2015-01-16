package com.ys.professor.infra.repository;

import com.ys.professor.infra.domain.Question;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Set;



/**
 * Created by rob on 1/11/15.
 */
@Repository
@Transactional(readOnly = true)
public class QuestionRepository implements RepositoryInterface<Question,Long>{

    private EntityManager em = null;

    /**
     * Sets <></>he entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void add(Question object) {
        em.persist(object);

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void remove(Question object) {
        em.remove(em.merge(object));
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void update(Question object) {
        em.merge(object);
    }

    @Override
    public Question retrieveByID(Long id) {
        return em.find(Question.class, id);
    }

    @Override
    public Collection<Question> retrieveAll() {
        return em.createQuery("select q from Question q order by q.questionId").getResultList();
    }
}
