package mother.hackers.gallery.photo.dto;

import lombok.Getter;
import lombok.Setter;
import mother.hackers.gallery.comment.dto.CommentDto;
import mother.hackers.gallery.user.dto.UserDto;

import java.util.List;

@Getter
@Setter
public class PhotoDto {

    private long id;
    private ImageData data;
    private String description;
    private boolean isPublic;
    private UserDto owner;
    private List<CommentDto> comments;
}
