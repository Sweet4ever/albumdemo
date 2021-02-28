package se.group4.springalbum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.group4.springalbum.entities.Album;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{
    List<Album> findAllByName(String name);
}