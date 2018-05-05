package e.gebruiker.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.ImageView;

import java.io.Serializable;

public class JournalEntry implements Serializable {

    private int _id;
    private String title;
    private String content;
    private String mood;
    private String timeStamp;
    private boolean favorite;

    public JournalEntry(String title, String content, String mood) {
//        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
//        this.timeStamp = timeStamp;
        this.favorite = false;
    }

    public int getId() {
        return _id;
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
