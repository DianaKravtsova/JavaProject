package by.kravts.concerts_affiche.model;

import javax.persistence.*;

@Entity
public class Comments {
    public Comments(){}

    public Comments(int commentID, Users userID, String message, Concert concertID){
        this.commentID = commentID;
        this.userID = userID;
        this.message = message;
        this.concertID = concertID;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int commentID;

    @OneToOne
    private Users userID;

    private String message;

    @OneToOne
    private  Concert concertID;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Concert getConcertID() {
        return concertID;
    }

    public void setConcertID(Concert concertID) {
        this.concertID = concertID;
    }
}
