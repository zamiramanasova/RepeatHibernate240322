package org.example.config;

import org.example.packageEight.Pupil;
import org.example.packageFive.City;
import org.example.packageFour.Tree;
import org.example.packageNine.Planet;
import org.example.packageOne.Student;
import org.example.packageSeven.Phone;
import org.example.packageSix.Fish;
import org.example.packageTen.Shop;
import org.example.packageThree.Country;
import org.example.packageTwo.Continent;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "stulchik");
                properties.put(Environment.HBM2DDL_AUTO, "create");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                properties.put(Environment.SHOW_SQL, true);
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Pupil.class);
                configuration.addAnnotatedClass(Tree.class);
                configuration.addAnnotatedClass(Planet.class);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(Fish.class);
                configuration.addAnnotatedClass(Shop.class);
                configuration.addAnnotatedClass(Country.class);
                configuration.addAnnotatedClass(Continent.class);
                configuration.addAnnotatedClass(City.class);

                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory((org.hibernate
                        .service.ServiceRegistry) serviceRegistry);

            } catch (Exception e) {
                e.getMessage();
            }
        }return sessionFactory;
    }
}
