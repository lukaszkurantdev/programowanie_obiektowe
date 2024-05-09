package pl.umcs.oop.music;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.umcs.oop.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @BeforeAll
    public static void setup() {
        DatabaseConnection.connect("songs.db");
    }

    @AfterAll
    public static void close() {
        DatabaseConnection.disconnect();
    }

    @Test
    public void testCorrectIndex() throws SQLException {
        Optional<Song> song = Song.Persistence.read(3);
        assertEquals("Stairway to Heaven", song.get().title());
    }

    @Test
    public void testIncorrectIndex() throws SQLException {
        Optional<Song> song = Song.Persistence.read(100);
        assertTrue(song.isEmpty());
    }

    private static Stream<Arguments> songs() {
        return Stream.of(
                Arguments.arguments(1,"The Beatles","Hey Jude",431),
                Arguments.arguments(3,"Led Zeppelin","Stairway to Heaven",482),
                Arguments.arguments(7,"The Doors","Light My Fire",426)
        );
    }

    @ParameterizedTest
    @MethodSource("songs")
    public void streamTest(int index, String artist, String title, int length) throws SQLException {
        Optional<Song> song = Song.Persistence.read(index);
        assertEquals(title, song.get().title());
    }

    @ParameterizedTest
    @CsvFileSource(files = "songs.csv", numLinesToSkip = 1)
    public void csvTest(int index, String artist, String title, int length) throws SQLException {
        Optional<Song> song = Song.Persistence.read(index);
        assertEquals(title, song.get().title());
    }
}