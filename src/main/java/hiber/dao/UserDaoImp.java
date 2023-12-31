package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void addUser(User user) {
      Session session = sessionFactory.getCurrentSession();
      session.save(user);
   }

   @Override
   public List<User> getListUsers() {
      Session session = sessionFactory.getCurrentSession();
      TypedQuery<User> query = session.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      TypedQuery<User> query = session.createQuery("select u from User u inner join u.car c where c.model = :model and c.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }

   @Override
   public void addCarToUser(Car car, Long userId) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.get(User.class, userId);
      user.setCar(car);
      session.update(user);
   }
}