package e.gebruiker.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {




    public class ListItemClickListener implements AdapterView.OnItemClickListener,
                                                    AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("onListClick", "listClick");
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//            intent.putExtra()
            startActivity(intent);
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("onListLongCLick", "listCliiiick");
            return true;
        }
    }

    public void onFloatClick(View v) {
        Log.d("onFLoatClick", "Click");
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
//        intent.putExtra()
        startActivity(intent);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = ( findViewById(R.id.listView));
        ListItemClickListener listItemClickListener = new ListItemClickListener();

        lv.setOnItemClickListener(listItemClickListener);

    }

    //test
}
