package com.dog.example.bootstrap.web;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() {
        restTemplate = restTemplate
                .withBasicAuth("admin", "password");
    }

    @Test
    public void getDogs() {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:" + port + "/dogs", List.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllBreeds() {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:" + port + "/dog-breeds", List.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
    }
}
