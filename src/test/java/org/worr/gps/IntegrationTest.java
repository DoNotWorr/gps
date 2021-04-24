package org.worr.gps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.worr.gps.model.Gps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUnit_ShouldReturnUnit() {
        //Arrange
        Long expectedId = 1L;
        String expectedDescription = "Attached to red tractor ABC-123";

        //Act
        ResponseEntity<Gps> response = restTemplate.getForEntity("/units/1", Gps.class);

        //Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(expectedId);
        assertThat(response.getBody().getDescription()).isEqualTo(expectedDescription);
    }
}
