package se.group4.springalbum.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.services.AlbumService;

import java.util.List;

@RestController
public class albumController{

    private AlbumService albumService;
    public albumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public List<AlbumDto> all(){
       return albumService.getAllAlbums();
    }

    @GetMapping("/albums/{id}")
    public AlbumDto findOne(@PathVariable int id){
        return albumService.getOne(id);
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumDto create(@RequestBody AlbumDto album){
        return albumService.createAlbum(album);
    }
}