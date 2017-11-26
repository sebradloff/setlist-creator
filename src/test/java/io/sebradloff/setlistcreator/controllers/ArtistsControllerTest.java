package io.sebradloff.setlistcreator.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class ArtistsControllerTest {
    private ArtistsController rest;
    private MockMvc endpoint;

    @Before
    public void setup() {
        rest = new ArtistsController();
        endpoint = standaloneSetup(rest).build();
    }

    @Test
    public void sayHello() throws Exception {
        endpoint
            .perform(post("/artists").header("X-API-Version", "v1")
                .contentType(APPLICATION_JSON)
                .content("{\"artist\": \"John Bon Jovi\"}"))
            .andExpect(status().is(200))
            .andExpect(jsonPath("$[0]").value("John Bon Jovi"));
    }
}
