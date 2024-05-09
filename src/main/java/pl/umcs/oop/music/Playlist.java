package pl.umcs.oop.music;


import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {

    public Song atSecond(int seconds) {
        for(Song song : this){
            seconds = seconds - song.duration();
            if(seconds <= 0){
                return song;
            }
        }
       throw new IndexOutOfBoundsException();
    }
}
