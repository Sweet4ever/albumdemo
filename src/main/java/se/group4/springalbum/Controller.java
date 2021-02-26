package se.group4.springalbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller{

    private AlbumRepository albumRepository;

    @Autowired
    public Controller(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albums")
    public List<Album> all(){
       return albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Optional<Album> findOne(@PathVariable int id){
        return albumRepository.findById(id);
    }
}