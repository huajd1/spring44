package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car("Lada", 2106);
      User user = new User("User1", "Lastname1", "user1@mail.ru");

      user.setCar(car);
      userService.add(user);

      userService.addCarToUser(new Car("Lada", 2106), user.getId());

      System.out.println(user);
      User userByCar = userService.getUserByCar("Lada", 2106);
      System.out.println(userByCar);


      context.close();
   }
}
