package by.kravts.concerts_affiche.services.impl;

import by.kravts.concerts_affiche.aspect.Loggable;
import by.kravts.concerts_affiche.config.Mapper;
import by.kravts.concerts_affiche.dto.CommentDto;
import by.kravts.concerts_affiche.entity.Comment;
import by.kravts.concerts_affiche.repository.CommentRepository;
import by.kravts.concerts_affiche.repository.FileRepository;
import by.kravts.concerts_affiche.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${upload.path}")
    private String path;

    private final CommentRepository commentRepository;
    private final FileRepository fileRepository;
    private final UserServiceImpl userService;
    private final ConcertServiceImpl concertService;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              FileRepository fileRepository,
                              UserServiceImpl userService,
                              ConcertServiceImpl concertService) {
        this.commentRepository = commentRepository;
        this.fileRepository = fileRepository;
        this.userService = userService;
        this.concertService = concertService;
    }

    @Override
    @Loggable
    public Collection<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    @Loggable
    public Optional<Collection<Comment>> getAllCommentsByConcertId(Long id) {
        return commentRepository
                .getCommentByConcertId(id);
    }

    @Override
    @Loggable
    public void addComment(CommentDto commentDto,
                           Collection<MultipartFile> files,
                           HttpServletRequest req) throws Exception {
        commentDto.setFilename(new HashSet<>());

        for (var file : files) {
            if (file.getOriginalFilename()
                    .equals("")) continue;

            if (!file.getOriginalFilename()
                    .matches("^(?:.*\\.(?=(jpg|jpeg|png|bmp)$))?[^.]*$") && !file.
                    getOriginalFilename()
                    .equals("")) {
            }

            java.io.File fileDir = new java.io.File(path);

            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            String UUID = java.util.UUID.randomUUID().toString();
            String finalPath = UUID + "." + file.getOriginalFilename();
            file.transferTo(new java.io.File(path + "/" + finalPath));

            by.kravts.concerts_affiche.entity.File commentImg = new by.kravts.concerts_affiche.entity.File();

            commentImg.setComment(new Comment());
            commentImg.setFilename(finalPath);
            commentDto.getFilename().add(commentImg);
        }

        Comment comment = Mapper.map(commentDto, Comment.class);
        comment.setFile(new HashSet<>());

        for (var x : commentDto.getFilename()) {
            comment.getFile().add(x);
            x.setComment(comment);
        }

        comment.setConcert(concertService
                .getConcertById(commentDto
                        .getConcertId()));
        comment.setUser(userService
                .getUserByUsername("denisario"));



        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentsByConcertId(Long concertId) {
        commentRepository.deleteCommentsByConcertId(concertId);
    }
}
