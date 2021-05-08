package com.ccomision.moviedb;

import com.ccomision.moviedb.config.DatabaseInitializer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class MovieDbTestConfiguration {

    @MockBean
    private DatabaseInitializer databaseInitializer;
}
