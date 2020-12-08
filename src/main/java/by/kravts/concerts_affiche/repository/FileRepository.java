package by.kravts.concerts_affiche.repository;

import by.kravts.concerts_affiche.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    void deleteFilesByCommentId(Long id);
}