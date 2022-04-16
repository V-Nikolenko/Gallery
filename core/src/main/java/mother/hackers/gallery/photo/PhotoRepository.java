package mother.hackers.gallery.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT p FROM Photo p where p.id IN (SELECT a.photos FROM Album a WHERE a.id = :albumId)")
    List<Photo> findAllPhotosByAlbumId(@Param("albumId") long albumId);

    @Query("SELECT p FROM Photo p where p.id IN (SELECT a.photos FROM Album a WHERE a.id = :albumId) and p.isPublic = true")
    List<Photo> findAllPublicPhotosByAlbumId(@Param("albumId") long albumId);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM Photo p WHERE p.id = :photoId and p.author.id = :userId")
    boolean isOwner(@Param("photoId") long photoId, @Param("userId") long userId);

    @Query("SELECT p.isPublic FROM Photo p WHERE p.id = :photoId")
    boolean isPublic(@Param("photoId") long photoId);
}
