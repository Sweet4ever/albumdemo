package se.group4.springalbum.Controllers;

import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<AlbumDto> getAllAlbums() {
        return List.of(new AlbumDto(1, "Album1", "Album1"), new AlbumDto(2, "Album2", "Album2"));
    }

    @Override
    public Optional<AlbumDto> findOne(int id) {
        if(id==1){
            return Optional.of(new AlbumDto(1, "Test", "Test"));
        }
        return Optional.empty();
    }

    @Override
    public AlbumDto createAlbum(AlbumDto album) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public AlbumDto replace(int id, AlbumDto albumDto) {
        return null;
    }

    @Override
    public AlbumDto update(int id, AlbumDto albumDto) {
        return null;
    }
}
