package by.kravts.concerts_affiche.repositories;

import by.kravts.concerts_affiche.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
