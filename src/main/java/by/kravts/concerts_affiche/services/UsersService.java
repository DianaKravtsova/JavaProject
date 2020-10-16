package by.kravts.concerts_affiche.services;

import by.kravts.concerts_affiche.model.Users;
import by.kravts.concerts_affiche.repositories.IUsersRepository;
import by.kravts.concerts_affiche.services.iService.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {
    private IUsersRepository usersRepository;

    @Autowired
   public  UsersService(IUsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return this.usersRepository.findAll();
    }

    @Override
    public Users findByLogin(String login) {
        return this.usersRepository.findByLogin(login);
    }



}
