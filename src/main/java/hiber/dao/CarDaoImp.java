package hiber.dao;

import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").getResultList();
    }

    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Car> query = session.createQuery("from Car where model = :model and series = :series", Car.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }
}