package se.group4.springalbum.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springalbum.repositories.AlbumRepository;
import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.entities.Album;
import se.group4.springalbum.mappers.Albummapper;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements se.group4.springalbum.services.Service {

    private final AlbumRepository albumRepository;
    Albummapper albummapper = new Albummapper();
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumDto> getAllAlbums(){
        return albummapper.mapp(albumRepository.findAll());
    }

    @Override
    public Optional<AlbumDto> findOne(int id){
        return albummapper.mapp(albumRepository.findById(id));
    }

    @Override
    public AlbumDto createAlbum(AlbumDto album){
        if(album.getName().isEmpty()){
            System.out.printf("Det blev fel i create ");
            throw new RuntimeException();
        }
        //Mapp from Dto to album
        return albummapper.mapp(albumRepository.save(albummapper.mapp(album)));
    }

    @Override
    public List<AlbumDto> search(String name){
        return  albummapper.mapp(albumRepository.findAllByNameContains(name));
    }



    @Override
    public void delete(int id) {
        albumRepository.deleteById(id);
    }

    @Override
    public AlbumDto replace(int id, AlbumDto albumDto) {
        Optional<Album> album = albumRepository.findById(id);
        if(album.isPresent()){
            Album updatedAlbum = album.get();
            updatedAlbum.setName(albumDto.getName());
            updatedAlbum.setArtist(albumDto.getArtist());
            return albummapper.mapp(albumRepository.save(updatedAlbum));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id: "+id+" not found");
        }
    }

    @Override
    public AlbumDto update(int id, AlbumDto albumDto) {
        Optional<Album> album = albumRepository.findById(id);
        if(album.isPresent()){
            Album updatedAlbum = album.get();
            if(albumDto.getName() != null)
                updatedAlbum.setName(albumDto.getName());
            if(albumDto.getArtist() != null)
                updatedAlbum.setArtist(albumDto.getArtist());
            return albummapper.mapp(albumRepository.save(updatedAlbum));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id: "+id+" not found");
        }
    }
}

