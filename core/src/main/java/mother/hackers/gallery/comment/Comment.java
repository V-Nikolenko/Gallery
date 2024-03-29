package mother.hackers.gallery.comment;

import lombok.Getter;
import lombok.Setter;
import mother.hackers.gallery.post.Post;
import mother.hackers.gallery.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User author;
    private String text;
    @ManyToOne
    private Post post;
}
