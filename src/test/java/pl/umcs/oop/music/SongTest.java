package pl.umcs.oop.music;

import org.junit.jupiter.api.Test;
import pl.umcs.oop.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    public void testCorrectIndex() throws SQLException {
        DatabaseConnection.connect("songs.db");
        Optional<Song> song = Song.Persistence.read(3);
        assertEquals("Stairway to Heaven", song.get().title());
    }
}