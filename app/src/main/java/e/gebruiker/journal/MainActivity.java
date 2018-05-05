package e.gebruiker.journal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EntryDatabase db;
    EntryAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        adapter = new EntryAdapter(this, cursor);
        listView.setAdapter(adapter);

        ListItemClickListener listItemClickListener = new ListItemClickListener();
        listView.setOnItemClickListener(listItemClickListener);

        ListItemLongClickListener listItemLongClickListener = new ListItemLongClickListener();
        listView.setOnItemLongClickListener(listItemLongClickListener);
    }
    @Override
    public void onResume() {
        super.onResume();
        updateData();
    }

    private void updateData() {
        Cursor cursor = db.selectAll();
        adapter.swapCursor(cursor);
    }


    public class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            JournalEntry clickedEntry = (JournalEntry) parent.getItemAtPosition(position);
            Log.d("onListClick", "listClick");
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clickedEntry", clickedEntry);
            startActivity(intent);
        }
    }

    public class ListItemLongClickListener implements AdapterView.OnItemLongClickListener {

    @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("onListLongCLick", "listCliiiick");

            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            int _id = cursor.getInt(cursor.getColumnIndex(EntryDatabase.columnId));

            EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
            db.delete(_id);
            updateData();
            return true;
        }
    }

    public void onFloatClick(View v) {
        Log.d("onFLoatClick", "Click");
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
//        intent.putExtra()
        startActivity(intent);
    }
}
