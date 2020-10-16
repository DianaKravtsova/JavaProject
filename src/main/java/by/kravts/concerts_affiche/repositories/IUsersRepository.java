package by.kravts.concerts_affiche.repositories;

import by.kravts.concerts_affiche.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);
}
