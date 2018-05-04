package e.gebruiker.journal;

import android.content.Context;

import java.io.Serializable;

public class JournalEntry implements Serializable {

    private int id;
    private String title;
    private String content;
    private String mood;
    private String timeStamp;
    private boolean favorite;

    private static EntryDatabase instance;

    public static EntryDatabase getInstance(Context context) {
        switch instance.


        return instance;



    };



    private JournalEntry(String title, String content, String mood) {
//        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
//        this.timeStamp = timeStamp;
        this.favorite = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

}
