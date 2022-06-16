package service;

import entity.UserEntity;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Authentication {

    public static UserEntity checkCredentials(String userName, String password) {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<UserEntity> tq = em.createQuery("select user from UserEntity user where user.password = :password and user.userName = :userName", UserEntity.class);
            tq.setParameter("userName", userName);
            tq.setParameter("password", password);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
