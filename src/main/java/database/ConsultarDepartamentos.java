package database;

import entities.DepartamentosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ConsultarDepartamentos {
    public static void leerDepartamentos(EntityManager em) {
        Query query = em.createQuery("from DepartamentosEntity");
        List<DepartamentosEntity> deps = query.getResultList();
        for (DepartamentosEntity d : deps){
            System.out.println(d.getDnombre());
        }
    }
}