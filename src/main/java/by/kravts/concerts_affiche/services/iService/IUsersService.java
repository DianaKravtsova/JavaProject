package by.kravts.concerts_affiche.services.iService;

import by.kravts.concerts_affiche.model.Users;

import java.util.List;

public interface IUsersService {
    List<Users> findAll();
    Users findByLogin(String login);
}
