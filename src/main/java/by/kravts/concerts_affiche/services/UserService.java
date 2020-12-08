package by.kravts.concerts_affiche.services;

import by.kravts.concerts_affiche.dto.UserDto;
import by.kravts.concerts_affiche.entity.User;
import by.kravts.concerts_affiche.exceptions.IncorrectPasswordException;
import by.kravts.concerts_affiche.exceptions.UserNameNotFoundException;

public interface UserService {
    User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException; //throws UserNameNotFoundException, IncorrectPasswordException
    void register(UserDto userDto) throws Exception;
    boolean isAdmin(String username);
    User getUserByUsername(String username);
}
