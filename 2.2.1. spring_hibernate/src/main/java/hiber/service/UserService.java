package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
//В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера,
// владеющего машиной по ее модели и серии.
    void add(User user);
    List<User> listUsers();
    User getUserByCarSeriesAndModel(int series, String model);
}
