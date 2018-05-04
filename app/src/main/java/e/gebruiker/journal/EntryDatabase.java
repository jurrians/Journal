package e.gebruiker.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Entries (_id INT PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT," +
                                        " mood TEXT, timeStamp DATETIME DEFAULT CURRENT_TIMESTAMP, favorite BIT);");

        // test input
        db.execSQL("INSERT INTO Entries (title, content, mood, favorite) VALUES ('title', 'was chill vandaag', 'like', 0), ('Title2', 'was kut vandaag', 'angry', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Entries");
        onCreate(db);
    }

    public EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
