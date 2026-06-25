package com.mycompany.aplikasistreaming.film;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieJUnitTest {

    @Test
    void testMovieTitle() {

        Movie movie = new Movie(
                "M001",
                "Avengers",
                "Action",
                2019,
                181,
                8.4,
                "url",
                true
        );

        assertEquals("Avengers", movie.getTitle()); //Continues testing gagal
    }
}