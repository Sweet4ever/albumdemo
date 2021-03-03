package se.group4.springalbum.Controllers;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.group4.springalbum.services.Service;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(AlbumController.class)
@Import(TestService.class)
public class MvcTest {

    @Autowired
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void callingAlbumShouldAlbumsAsJson() throws Exception {
        var result = mockMvc
                .perform(MockMvcRequestBuilders.get("/albums")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }



}
