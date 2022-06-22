package repository;

import entity.RegulationEntity;
import entity.UserEntity;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RegulationDao {

    public static boolean persistRegulation(RegulationEntity regulation) {
        try{
            EntityManager em = DbResource.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(regulation);
            et.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<RegulationEntity> getAllRegulations() {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<RegulationEntity> tq = em.createQuery("select regulation from RegulationEntity regulation ", RegulationEntity.class);
            return tq.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<RegulationEntity> getUsersRegulations(UserEntity user) {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<RegulationEntity> tq = em.createQuery("select regulation from RegulationEntity regulation where regulation.department = :deptID", RegulationEntity.class);
            tq.setParameter("deptID", user.getDepartment());
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
