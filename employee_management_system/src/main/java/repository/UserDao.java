package repository;

import entity.User;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDao {

    public static User getUser(String userName, String password){
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<User> tq = em.createQuery("select u from User u where u.userName = :u and u.password = :p", User.class);
            tq.setParameter("u", userName);
            tq.setParameter("p", password);
            return tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
