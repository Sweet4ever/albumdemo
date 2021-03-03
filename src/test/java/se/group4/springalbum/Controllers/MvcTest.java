package se.group4.springalbum.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.group4.springalbum.services.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlbumController.class)
@Import(TestService.class)
public class MvcTest {

    @Autowired
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllAlbumsFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/albums")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getOneAlbumFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/albums/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void postOneAlbumToRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/albums")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Test\",\n" +
                        "    \"artist\": \"Test\"\n" +
                        "  }"))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteAlbumOneFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/albums/1"))
                .andExpect(status().isOk());
    }


    @Test
    void putOneAlbumToRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/albums/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Testing\",\n" +
                        "    \"artist\": \"Testing\"\n" +
                        "  }"))
                .andExpect(status().isOk());
    }


    @Test
    void patchAlbumWithNewAlbumnameInRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .patch("/albums/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"is Testing done\"}"))
                .andExpect(status().isOk());
    }
}
