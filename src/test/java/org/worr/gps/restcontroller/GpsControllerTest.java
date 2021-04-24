package org.worr.gps.restcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.worr.gps.model.Gps;
import org.worr.gps.services.UnitService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UnitController.class)
public class GpsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UnitService unitService;


    @Test
    public void getUnit_ShouldReturnUnit() throws Exception {
        String url = "/units/1";
        Long expectedId = 1L;
        String expectedDescription = "Attached to red tractor ABC-123";

        //Arrange
        given(unitService.getUnitById(expectedId))
                .willReturn(new Gps(expectedId, expectedDescription));

        //Act, assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(expectedId))
                .andExpect(jsonPath("description").value(expectedDescription));
    }
}
