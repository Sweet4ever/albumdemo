package se.group4.springalbum.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class albumControllerTest {

    @Test
    void findOneReturnsOneAlbum(){
        AlbumController albumController = new AlbumController(new TestService());

        var album = albumController.findOne(1);

        assertThat(album.getId()).isEqualTo(1);
        assertThat(album.getName()).isEqualTo("Test");
        assertThat(album.getArtist()).isEqualTo("Test");
    }

    @Test
    void findOneWrongIdReturns404(){
        AlbumController albumController = new AlbumController(new TestService());

        var exception = assertThrows(ResponseStatusException.class, ()-> albumController.findOne(2));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}