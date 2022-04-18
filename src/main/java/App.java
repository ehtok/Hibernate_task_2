import Entity.HomeTask;
import Entity.Person;
import Entity.Task;
import Entity.WorkTask;
import Utils.HibernateUtilsFactory;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {

        Person personLooking = Person.builder()
                .name("Ivan")
                .surname("Igorev")
                .build();

        Person personPerformer = Person.builder()
                .name("Irina")
                .surname("Malina")
                .build();


        Task task = Task.builder()
                .name("Task_1")
                .description("Create db...")
                .build();

        HomeTask homeTask = (HomeTask) HomeTask.builder()
                .startDate("22.12.2014")
                .endDate("15.01.2015")
                .performer(personPerformer)
                .looking(personLooking)
                .name("Home Task")
                .description("Add dao")
                .build();

        WorkTask workTask = (WorkTask) WorkTask.builder()
                .cost(225.5)
                .name("Work Task")
                .description("Add Entity")
                .build();

        EntityManager em = HibernateUtilsFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.persist(homeTask);
        em.persist(workTask);
        em.getTransaction().commit();
        em.close();
        HibernateUtilsFactory.close();

    }
}
