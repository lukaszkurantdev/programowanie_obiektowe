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
}