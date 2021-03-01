package se.group4.springalbum.mappers;

import se.group4.springalbum.Dto.AlbumDto;
import se.group4.springalbum.entities.Album;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Albummapper {

    public Albummapper(){}

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
