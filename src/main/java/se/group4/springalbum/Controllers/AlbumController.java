package se.group4.springalbum.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.services.Service;

import java.util.List;

@RestController
public class AlbumController{

    private Service service;
    public AlbumController(Service service){
        this.service = service;
    }

    @GetMapping("/albums")
    public List<AlbumDto> all(){
       return service.getAllAlbums();
    }

    @GetMapping("/albums/{id}")
    public AlbumDto findOne(@PathVariable int id){
        return service.findOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id: "+id+" not found"));
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumDto create(@RequestBody AlbumDto album){
        return service.createAlbum(album);
    }

    @DeleteMapping("/albums/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/albums/{id}")
    public AlbumDto replace(@RequestBody AlbumDto albumDto, @PathVariable int id){
        return service.replace(id, albumDto);
    }

    @PatchMapping("/albums/{id}")
    public AlbumDto update(@RequestBody AlbumDto albumDto, @PathVariable int id){
        return service.update(id, albumDto);
    }
}