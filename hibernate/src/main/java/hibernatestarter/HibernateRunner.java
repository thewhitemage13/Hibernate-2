package hibernatestarter;

import entity.Company;
import entity.PersonalInfo;
import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("SIEMENS")
                .build();

        User user = User.builder()
                .username("rolling_bi4")
                .role(Role.USER)
                .personalInfo(PersonalInfo.builder()
                        .lastname("Homin")
                        .firstname("Bogdan")
                        .age(20)
                        .birthday(LocalDate.of(2002,6,21))
                        .build())
                .company(company)
                .build();
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()){
            try(Session session = sessionFactory.openSession()){

                session.beginTransaction();

                session.save(user);

                session.getTransaction().commit();
            }
        }
    }
}


























