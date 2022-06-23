package repository;

import entity.CommentEntity;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CommentDao {
    public static boolean persistComment(CommentEntity comment) {
        try{
            EntityManager em = DbResource.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(comment);
            et.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
