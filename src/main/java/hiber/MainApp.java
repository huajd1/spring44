package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService =  context.getBean(CarService.class);

      User user = new User("User1", "Lastname1", "user1@mail.ru");
      Car car = new Car("Lada", 2106);

      carService.addCar(car);
      user.setCar(car);

      userService.addUser(user);
      userService.addCarToUser(car, user.getId());

      System.out.println(user);
      System.out.println(car);

      System.out.println(carService.getCars());

      User userByCar = userService.getUserByCar("Lada", 2106);
      System.out.println(userByCar);


      context.close();
   }
}
