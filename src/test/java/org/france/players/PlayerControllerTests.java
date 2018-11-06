package org.france.players;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void playersShouldContainsNameOfPlayer() throws Exception {

        this.mockMvc.perform(get("/players")).andDo(print()).andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].nom").value("Kylian Mbappé"));
    }

    @Test
    public void paramPlayerShouldContainNameOfPlayer() throws Exception {

        this.mockMvc.perform(get("/player/1")).andDo(print()).andExpect(status().isOk())
                        .andExpect(jsonPath("$.nom").value("Paul Pgba"));
    }

}
