package com.sharar;


public class Song {
    private String title;
    private int duration; //seconds

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        String hours = "0";
        String minutes = "00";
        String seconds = "00";
        int duration = this.duration; //seconds
        if ((duration % 3600 == 0) || (duration >= 3600)) {
            hours = "" + duration / 3600;
            if (duration % 3600 == 0) duration = 0;
            else duration = duration - (duration / 3600) * 3600;
        }

        if (duration >= 60) {
            int minutesInt = duration / 60;
            if (minutesInt < 10)
                minutes = "0" + minutesInt;
            else
                minutes = "" + minutesInt;
            if (duration % 60 == 0)
                duration = 0;
            else
                duration = duration - (duration / 60) * 60;

        }
        if (duration < 10)
            seconds = "0" + duration;
        else
            seconds = "" + duration;


        return hours + ":" + minutes + ":" + seconds;
    }

}
