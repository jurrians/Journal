package e.gebruiker.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;


public class InputActivity extends AppCompatActivity {

    public String moodString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void addEntry(View v) {
        Log.d("addEntry", "entryClick");

        EditText editTitle = findViewById(R.id.Title);
        String titleString = editTitle.getText().toString();

        EditText editContent = findViewById(R.id.Content);
        String contentString = editContent.getText().toString();

        JournalEntry entry = new JournalEntry(titleString,contentString,moodString);
        EntryDatabase db = EntryDatabase.getInstance(getBaseContext());
        db.insert(entry);

        editTitle.setText("");
        editContent.setText("");
    }

    public void onMoodClick (View v) {

        ImageView imageMood = findViewById(R.id.imageMood);


        switch (v.getId()) {
            case R.id.buttonLike:
                // set image resource to buttonX
                Log.d("onMoodClick", "Like");
                imageMood.setImageResource(R.drawable.like);
                moodString = "like";
                break;
            case R.id.buttonLove:
                Log.d("onMoodClick", "Love");
                imageMood.setImageResource(R.drawable.love);
                moodString = "love";
                break;
            case R.id.buttonHaha:
                Log.d("onMoodClick", "Haha");
                imageMood.setImageResource(R.drawable.haha);
                moodString = "haha";
                break;
            case R.id.buttonWow:
                Log.d("onMoodClick", "Wow");
                imageMood.setImageResource(R.drawable.wow);
                moodString = "wow";
                break;
            case R.id.buttonSad:
                Log.d("onMoodClick", "Sad");
                imageMood.setImageResource(R.drawable.sad);
                moodString = "sad";
                break;
            case R.id.buttonAngry:
                Log.d("onMoodClick", "Angry");
                imageMood.setImageResource(R.drawable.angry);
                moodString = "angry";
                break;
        }
    }





}
