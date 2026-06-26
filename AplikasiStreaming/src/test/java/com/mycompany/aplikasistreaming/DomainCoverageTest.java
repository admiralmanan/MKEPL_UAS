package com.mycompany.aplikasistreaming;

import com.mycompany.aplikasistreaming.film.Documentary;
import com.mycompany.aplikasistreaming.film.Movie;
import com.mycompany.aplikasistreaming.film.Series;
import com.mycompany.aplikasistreaming.streamingoption.StreamingOption;
import com.mycompany.aplikasistreaming.subscription.PremiumSub;
import com.mycompany.aplikasistreaming.subscription.StandardSub;
import com.mycompany.aplikasistreaming.user.User;
import com.mycompany.aplikasistreaming.watchparty.WatchParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DomainCoverageTest {

    @Test
    void testMovieCoverage() {
        Movie movie = new Movie("M001", "Avengers", "Action", 2019, 181, 8.4, "url", true);

        movie.watch();
        movie.watchingMovie("Avengers", true, "English");

        assertEquals("Avengers", movie.getTitle());
        assertEquals("Film Ditemukan : Avengers", movie.search("av"));
        assertEquals("Film tidak ditemukan", movie.search("zzz"));
    }

    @Test
    void testSeriesCoverage() {
        Series series = new Series("S001", "Breaking Bad", "Crime", 2008, 47, 9.5, "url", 5, 62);

        series.watch();
        series.watchingSeries("Breaking Bad", 1, 1);

        assertEquals("Breaking Bad", series.getTitle());
        assertEquals("Film Ditemukan : Breaking Bad", series.search("bad"));
    }

    @Test
    void testDocumentaryCoverage() {
        Documentary documentary = new Documentary("D001", "Planet Earth", "Nature", 2006, 90, 9.4, "url", "Wildlife", "Narrator");

        documentary.watch();
        documentary.watchingDocumentary("Planet Earth", "Wildlife");

        assertEquals("Planet Earth", documentary.getTitle());
        assertEquals("Film Ditemukan : Planet Earth", documentary.search("planet"));
    }

    @Test
    void testStreamingOptionCoverage() {
        StreamingOption option = new StreamingOption();

        option.chooseQuality("1080p");
        option.chooseAudio("Dolby");
        option.chooseSubtitle("English");

        assertEquals("1080p", option.getQuality());
        assertEquals("Dolby", option.getAudio());
        assertEquals("English", option.getSubtitle());
    }

    @Test
    void testSubscriptionCoverage() {
        PremiumSub premium = new PremiumSub("P1", "Premium", "2024-01-01", "2024-12-31", 150000, "4K", 5);
        StandardSub standard = new StandardSub("S1", "Standard", "2024-01-01", "2024-12-31", 75000, "1080p", 2);

        premium.choosePlan();
        premium.renewSubs();
        premium.cancelSubs();
        premium.price();
        premium.applyPremiumFeatures();

        standard.choosePlan();
        standard.renewSubs();
        standard.cancelSubs();
        standard.price();
        standard.applyStandardFeatures();

        assertEquals("Premium", premium.getPlanType());
        assertEquals("Standard", standard.getPlanType());
    }

    @Test
    void testWatchPartyCoverage() throws Exception {
        WatchParty party = new WatchParty("WP1", "Alice", 49, "19:00");

        party.createWatchParty();
        party.joinParty("Bob");

        assertEquals("WP1", party.getPartyID());
        assertEquals(50, party.getParticipants());
        assertThrows(Exception.class, () -> party.joinParty("Carol"));

        party.endParty();
    }

    @Test
    void testUserCoverage() {
        User user = new User("user@example.com", "alice", "secret");

        assertTrue(user.login("alice", "secret"));
        assertTrue(user.login("user@example.com", "secret"));
        assertFalse(user.login("alice", "wrong"));
        assertEquals("User [email=user@example.com, username=alice]", user.toString());
    }
}
