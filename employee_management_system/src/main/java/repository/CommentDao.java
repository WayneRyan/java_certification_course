package repository;

import entity.CommentEntity;
import entity.UserEntity;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CommentDao {
    public static boolean persistComment(CommentEntity comment) {
        try {
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

    public static CommentEntity getComment(int regulationID, UserEntity user) {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<CommentEntity> tq = em.createQuery("select comment from CommentEntity comment where comment.regulation.id = :regulationID and comment.user = :user", CommentEntity.class);
            tq.setParameter("regulationID", regulationID);
            tq.setParameter("user", user);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
