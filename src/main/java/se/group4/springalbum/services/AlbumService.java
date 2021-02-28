package se.group4.springalbum.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springalbum.repositories.AlbumRepository;
import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.entities.Album;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public List<AlbumDto> getAllAlbums(){
        return mapp(albumRepository.findAll());
    }

    public AlbumDto getOne(int id){
        return mapp(albumRepository.findById(id))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Id: "+id+" not found"));
    }

    public AlbumDto createAlbum(AlbumDto album){
        if(album.getName().isEmpty()){
            System.out.printf("Det blev fel i create ");
            throw new RuntimeException();
        }
        //Mapp from Dto to album
        return mapp(albumRepository.save(mapp(album)));
    }

    public AlbumDto mapp(Album album){
        return new AlbumDto(album.getId(), album.getName(), album.getArtist());
    }

    public Album mapp(AlbumDto albumDto){
        return new Album(albumDto.getId(), albumDto.getName(), albumDto.getArtist());
    }

    public Optional<AlbumDto> mapp(Optional<Album> optionalAlbum){
        if(optionalAlbum.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(mapp(optionalAlbum.get()));
    }

    public List<AlbumDto> mapp(List<Album> all){
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

}
