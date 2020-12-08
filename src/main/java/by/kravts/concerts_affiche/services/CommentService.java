package by.kravts.concerts_affiche.services;


import by.kravts.concerts_affiche.dto.CommentDto;
import by.kravts.concerts_affiche.entity.Comment;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;

public interface CommentService {
    Collection<Comment> getAllComments();
    Optional<Collection<Comment>> getAllCommentsByConcertId(Long id);
    void addComment(CommentDto commentDto,
                    Collection<MultipartFile> files,
                    HttpServletRequest req) throws Exception;

    void deleteCommentsByConcertId(Long concertId);
}
