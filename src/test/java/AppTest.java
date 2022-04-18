import Entity.HomeTask;
import Entity.Person;
import Entity.Task;
import Entity.WorkTask;
import Utils.HibernateUtilsFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class AppTest {

    @BeforeAll
    static void createEntity() {
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
    }


    @Test
    void main() {
        EntityManager em = HibernateUtilsFactory.getEntityManager();
        String actual = em.find(Task.class, 1).getName();
        String expect = "Task_1";
        Assertions.assertEquals(actual, expect);
        String actual1 = em.find(HomeTask.class, 2).getStartDate();
        String expect1 = "22.12.2014";
        Assertions.assertEquals(actual1, expect1);
        Double actual2 = em.find(WorkTask.class, 3).getCost();
        Double expect2 = 225.5;
        Assertions.assertEquals(actual2, expect2);
    }

    @AfterAll
    public static void close() {
        HibernateUtilsFactory.close();
    }
}




