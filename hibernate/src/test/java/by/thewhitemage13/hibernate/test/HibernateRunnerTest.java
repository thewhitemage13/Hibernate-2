package by.thewhitemage13.hibernate.test;

import entity.*;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import java.time.LocalDate;

public class HibernateRunnerTest {
    @Test
    public void checkOneToOne() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        var company = session.get(Company.class, 1);

        User user = User.builder()
                .username("borisfonarist")
                .company(company)
                .build();
        Profile profile = Profile.builder()
                .language("UK")
                .street("Tarasa")
                .build();

        session.save(user);
        profile.setUser(user);
        session.save(profile);

        session.getTransaction().commit();
    }

//    @Test
//    public void checkOrphalRemoval() {
//        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
//        @Cleanup var session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Company company = session.get(Company.class, 1);
//        company.getUsers().removeIf(u -> u.getId().equals());
//
//        session.getTransaction().commit();
//    }

    @Test
    public void addNewUserAndCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        Company company = Company.builder()
                .name("Google")
                .build();

        User user = User.builder()
                .username("thewhitemage13")
                .build();

        company.addUser(user);
        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    public void checkOnrToMany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(Company.class, 1);

        session.getTransaction().commit();
    }
}
