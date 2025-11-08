package org.denizugurgenc02.clubweb_backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.denizugurgenc02.clubweb_backend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    protected EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(User user) {
        entityManager.persist(user);
    }

    public User read(Integer id) {
        return entityManager.find(User.class, id);
    }

    public List<User> readAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);

        return query.getResultList();
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(Integer id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }
}
