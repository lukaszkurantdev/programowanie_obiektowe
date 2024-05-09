package pl.umcs.oop.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    public void testIfNewPlaylistIsEmpty() {
        Playlist playlist = new Playlist();

        assertTrue(playlist.isEmpty());
    }
    @Test
    public void testIfPlaylistHasOneSong(){
        Song song1 = new Song("artist","title",320);

        Playlist playlist = new Playlist();
        playlist.add(song1);

        assertEquals(playlist.size(),1);


    }

    @Test
    public void ifHasSameSong(){
        Song song = new Song("artist","title", 10);
        Playlist playlist = new Playlist();
        playlist.add(song);

        assertTrue(playlist.contains(song));
    }

    @Test
    void atSecond() {
        Song song1 = new Song("artist1", "title1", 50);
        Song song2 = new Song("artist2", "title2", 40);
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(song2);
        int testtimestamp = 70;
        assertEquals(playlist.atSecond(testtimestamp), song2);
    }

    @Test
    public void atSecondThrowException() {
        Song song1 = new Song("artist1", "title1", 50);
        Song song2 = new Song("artist2", "title2", 40);
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(song2);
        int testtimestamp = 100;
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    playlist.atSecond(testtimestamp);
                }
        );
    }
}