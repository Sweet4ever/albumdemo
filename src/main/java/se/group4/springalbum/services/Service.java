package se.group4.springalbum.services;

import se.group4.springalbum.Dto.AlbumDto;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<AlbumDto> getAllAlbums();

    Optional<AlbumDto> findOne(int id);

    AlbumDto createAlbum(AlbumDto album);

    void delete(int id);

    AlbumDto replace(int id, AlbumDto albumDto);

    AlbumDto update(int id, AlbumDto albumDto);
}
