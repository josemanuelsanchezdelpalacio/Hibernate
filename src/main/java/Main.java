import database.EmfSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import static database.ConsultarEmpleadosClase.crearEmpleado;
import static database.ConsultarEmpleadosClase.leerEmps;

public class Main {
    //Contexto de persistencia haciendo uso del singleton

    public static void main(String[] args) {
        leerEmps();
        //modificarEmpleado(em);
        //insertarEmpleado();
        crearEmpleado();
        desconectar();
    }

    private static void desconectar() {
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        emf.close();
    }


}
