package by.kravts.concerts_affiche.services.iService;

import by.kravts.concerts_affiche.model.User;

import java.util.List;

public interface IUsersService {
    List<User> findAll();
    User findByLogin(String login);
}
