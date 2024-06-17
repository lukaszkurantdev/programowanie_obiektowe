package org.example.k2_client;

import java.time.LocalTime;

public class Word
{
    String string;
    LocalTime time;

    public Word(String string, LocalTime time) {
        this.string = string;
        this.time = time;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}
