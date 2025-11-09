package org.denizugurgenc02.clubweb_backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.denizugurgenc02.clubweb_backend.entities.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementRepository{
    protected EntityManager entityManager;

    @Autowired
    public AnnouncementRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Announcement announcement){
        entityManager.persist(announcement);
    }

    public Announcement read(Integer id){
        return entityManager.find(Announcement.class,id);
    }

    public List<Announcement> readAll(){
        TypedQuery<Announcement> query = entityManager.createQuery("FROM Announcement", Announcement.class);

        return query.getResultList();
    }
    public void update(Announcement announcement) {
        entityManager.merge(announcement);
    }

    public void delete(Integer id) {
        Announcement announcement= entityManager.find(Announcement.class, id);

        entityManager.remove(announcement);
    }
}
