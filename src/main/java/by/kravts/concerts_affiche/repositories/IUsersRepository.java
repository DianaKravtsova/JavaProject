package by.kravts.concerts_affiche.repositories;

import by.kravts.concerts_affiche.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
