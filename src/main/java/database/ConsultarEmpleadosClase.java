package database;

import entities.EmpleadosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ConsultarEmpleadosClase {
    public static void leerEmps() {
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        //aquí comienza nuestro contexto de persistencia asociado a nuestro em
        EntityManager em = emf.createEntityManager();
        try{
            //cada consulta añade información a nuestro contexto de persistencia
            EmpleadosEntity e = em.find(EmpleadosEntity.class, 7499);
            //System.out.println(e.getApellido()+ e.getDepartamentosByDeptNo().getDnombre());
            String jpql = "from EmpleadosEntity where deptNo = 20";
            List<EmpleadosEntity> es = em.createQuery(jpql, EmpleadosEntity.class).getResultList();
            EmpleadosEntity e2 = em.createQuery("from EmpleadosEntity where empNo=7369", EmpleadosEntity.class).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //aseguramos que la conexión se cierra y el contexto de persistencia termina
            em.close();
        }
    }
    public static void modificarEmpleado(EntityManager em){
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        //aquí comienza nuestro contexto de persistencia asociado a nuestro em
        EntityManager em2 = emf.createEntityManager();
        try{
            EntityTransaction transaction = em2.getTransaction();
            //comenzamos a crear el contexto de persistencia
            transaction.begin();
            EmpleadosEntity e2 = new EmpleadosEntity();
            //se añade la relación del objeto e con su registro de la base de datos al contexto de persistencia
            EmpleadosEntity e = em2.createQuery("from EmpleadosEntity where apellido like 'ARROYO'", EmpleadosEntity.class).getSingleResult();
            //a partir de aquí trabajamos sobre el objeto instanciado que representa un registro de la base de datos
            System.out.println("Salario anterior: "+ e.getSalario());
            //las modificaciones del objeto están asociadas al contexto de persistencia pero no están en la base de datos
            e.setSalario(e.getSalario()+100);
            System.out.println("Salario actual: " + e.getSalario());
            //al hacer el commit los cambios se pasan a la base de datos
            transaction.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //aseguramos que la conexión se cierra y el contexto de persistencia termina
            em.close();
        }
    }
    public static void crearEmpleado(){
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        //aquí comienza nuestro contexto de persistencia asociado a nuestro em
        EntityManager em3 = emf.createEntityManager();
        try{
            EntityTransaction transaction = em3.getTransaction();
            //comenzamos a crear el contexto de persistencia
            transaction.begin();
            EmpleadosEntity empNuevo = new EmpleadosEntity();
            empNuevo.setApellido("Julia");
            empNuevo.setOficio("Estudiante");
            empNuevo.setDeptNo((byte)40);
            em3.persist(empNuevo);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //aseguramos que la conexión se cierra y el contexto de persistencia termina
            em3.close();
        }
    }
}

