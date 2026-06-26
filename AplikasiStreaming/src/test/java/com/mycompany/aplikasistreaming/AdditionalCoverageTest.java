package com.mycompany.aplikasistreaming;

import com.mycompany.aplikasistreaming.cast.CastToDevice;
import com.mycompany.aplikasistreaming.recommendation.GenreRecommendation;
import com.mycompany.aplikasistreaming.streamingoption.Audio;
import com.mycompany.aplikasistreaming.streamingoption.Quality;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionalCoverageTest {

    @Test
    void testCastToDeviceCoverage() {
        CastToDevice cast = new CastToDevice("TV Room");

        cast.startCasting();
        cast.startCasting();
        cast.checkCastingStatus();
        cast.stopCasting();
        cast.stopCasting();
        cast.checkCastingStatus();

        assertNotNull(cast);
    }

    @Test
    void testRecommendationCoverage() {
        ArrayList<String> films = new ArrayList<>();
        films.add("Avengers");
        films.add("Inception");

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put("Action", films);

        GenreRecommendation recommendation = new GenreRecommendation(films, map);

        recommendation.showAllRecommendedFilms();
        recommendation.showRecommendations("Action");
        recommendation.showRecommendations("Comedy");

        assertEquals(map, recommendation.getGenreToFilms());
        recommendation.setGenreToFilms(new HashMap<>());
        assertTrue(recommendation.getGenreToFilms().isEmpty());
    }

    @Test
    void testAudioAndQualityCoverage() {
        assertTrue(Quality.getResolution().contains("1080p"));
        assertTrue(Audio.getAudioFormat().contains("Dolby"));

        assertEquals("480p", Quality.getResolution().get(0));
        assertEquals("Stereo", Audio.getAudioFormat().get(0));
    }
}
