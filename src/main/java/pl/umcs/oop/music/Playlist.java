package pl.umcs.oop.music;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Playlist extends ArrayList<Song> {

    public Song atSecond(int seconds) {
        if(seconds < 0) {
            throw new IndexOutOfBoundsException("negative number");
        }

        for(Song song : this){
            seconds = seconds - song.duration();
            if(seconds <= 0){
                return song;
            }
        }
       throw new IndexOutOfBoundsException("out of songs");
    }
}
