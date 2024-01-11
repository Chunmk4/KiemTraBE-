package com.example.demo3.service;

import com.example.demo3.model.City;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityService implements ICityService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> findAll() {
        String query = "select c from City as c";
        TypedQuery<City> sql = entityManager.createQuery(query,City.class);
        return sql.getResultList();
    }
    @Override
    public void save(City city) {
        Transaction transaction = null;
        City origin;
        if (city.getId() == 0) {
            origin = new City();
        } else {
            origin = findById(city.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setName(city.getName());
            origin.setNation(city.getNation());
            origin.setDescribee(city.getDescribee());
            origin.setAcreage(city.getAcreage());
            origin.setGdp(city.getGdp());
            origin.setPopulation(city.getPopulation());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
        public City findById(int id) {
        String queryStr = "SELECT c FROM City AS c WHERE c.id = :id";
        TypedQuery<City> query = entityManager.createQuery(queryStr, City.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(int id, City city) {
        Transaction transaction = null;
        City origin;
        if (city.getId() == 0) {
            origin = new City();
        } else {
            origin = findById(city.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setName(city.getName());
            origin.setNation(city.getNation());
            origin.setDescribee(city.getDescribee());
            origin.setAcreage(city.getAcreage());
            origin.setGdp(city.getGdp());
            origin.setPopulation(city.getPopulation());
            session.update(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void remove(int id) {
        City city = findById(id);
        if (city != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(city);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
}
