package e.gebruiker.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private static int dbVersion = 1;
    private static String dbName = "entries.db";

    public static String columnId = "_id";
    public static String columnTitle = "title";
    public static String columnContent = "content";
    public static String columnMood = "mood";
    public static String columnFavorite = "favorite";
    public static String columnTimeStap = "timeStamp";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS entries( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT," +
                " mood TEXT, timeStamp DATETIME DEFAULT CURRENT_TIMESTAMP, favorite BIT);");

        // test input
        db.execSQL("INSERT INTO entries (title, content, mood, favorite) VALUES ('title', 'was chill vandaag', 'like', 0), ('Title2', 'was kut vandaag', 'angry', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + dbName);
        onCreate(db);
    }

    public Cursor selectAll() {
        Cursor cursor = instance.getWritableDatabase().rawQuery("SELECT * FROM entries", null);
        return cursor;
    }

    public static void insert(JournalEntry entry) {
        SQLiteDatabase db = instance.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", entry.getTitle());
        contentValues.put("content", entry.getContent());
        contentValues.put("mood", entry.getMood());

        db.insert("entries", null, contentValues);
    }

    public void delete(long id) {
        SQLiteDatabase db = instance.getWritableDatabase();
        db.execSQL("DELETE FROM entries WHERE _id = "+id+" ");
    }


    public EntryDatabase(Context context) {
        super(context, dbName, null, dbVersion);
    }

    public static EntryDatabase getInstance(Context context) {
        if (instance == null) {

            instance = new EntryDatabase(context);
        }
        return instance;
    }

}
