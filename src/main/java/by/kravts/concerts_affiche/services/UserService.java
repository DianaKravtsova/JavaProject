package by.kravts.concerts_affiche.services;

import by.kravts.concerts_affiche.model.User;

import java.util.List;


public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByLogin(String login);

    User findById(Integer id);

    void delete(Integer id);
}