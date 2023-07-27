package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> getListUsers();
   User getUserByCar(String model, int series);
   void addCarToUser(Car car, Long userId);
}