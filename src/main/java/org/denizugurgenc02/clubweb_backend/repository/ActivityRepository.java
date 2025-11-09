package org.denizugurgenc02.clubweb_backend.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.denizugurgenc02.clubweb_backend.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityRepository {

    protected EntityManager entityManager;

    @Autowired
    public ActivityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Activity activity) {
        entityManager.persist(activity);
    }

    public Activity read(Integer id) {
        return entityManager.find(Activity.class, id);
    }

    public List<Activity> readAll() {
        TypedQuery<Activity> query = entityManager.createQuery("FROM Activity", Activity.class);

        return query.getResultList();
    }

    public void update(Activity activity) {
        entityManager.merge(activity);
    }

    public void delete(Integer id) {
        Activity activity = entityManager.find(Activity.class, id);

        entityManager.remove(activity);
    }
}
