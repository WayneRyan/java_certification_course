package resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbResource {

    private static final EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

    public static EntityManager getEntityManager() {
        return em;
    }
}
