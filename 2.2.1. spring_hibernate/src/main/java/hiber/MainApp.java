package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User userCar = new User("Nursultan", "Temirkhanov", "tnursi9898@mail.ru");
      Car car = new Car("Hyundai");
      userCar.setCar(car);
      car.setUser(userCar);
      userService.add(userCar);

      User userCar1 = new User("Vanya", "Frolov", "frol@mail.ru");
      Car car1 = new Car("Audi");
      userCar1.setCar(car1);
      car1.setUser(userCar1);
      userService.add(userCar1);

      User userCar2 = new User("Nikolay", "Trubachev", "nik@mail.ru");
      Car car2 = new Car("Mazda");
      userCar2.setCar(car2);
      car2.setUser(userCar2);
      userService.add(userCar2);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = "+user.getCar());
         } else {
            System.out.println("No car");
         }
         System.out.println();
      }

      User user = userService.getUserByCarSeriesAndModel(1, "Hyundai");
      System.out.println(user);

      context.close();
   }
}
