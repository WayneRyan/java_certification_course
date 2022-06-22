package repository;

import entity.DepartmentEntity;
import resources.DbResource;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DepartmentDao {

    public static List<DepartmentEntity> getAllDepartments() {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<DepartmentEntity> tq = em.createQuery("select department from DepartmentEntity department ", DepartmentEntity.class);
            return tq.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public static  DepartmentEntity getDepartment(int id) {
        try {
            EntityManager em = DbResource.getEntityManager();
            TypedQuery<DepartmentEntity> tq = em.createQuery("select department from DepartmentEntity department where department.id = :deptID", DepartmentEntity.class);
            tq.setParameter("deptID", id);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
