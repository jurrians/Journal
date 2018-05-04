package e.gebruiker.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;


public class InputActivity extends AppCompatActivity {

    public void onInputClick(View v) {
        Log.d("onInputClick", "inputClick");
    }

    public void onMoodClick (View v) {

        ImageView imageMood = findViewById(R.id.imageMood);

        switch (v.getId()) {
            case R.id.buttonLike:
                // set image resource to buttonlike
                Log.d("onMoodClick", "Like");
                imageMood.setImageResource(R.drawable.like);
                break;
            case R.id.buttonLove:
                Log.d("onMoodClick", "Love");
                imageMood.setImageResource(R.drawable.love);
                break;
            case R.id.buttonHaha:
                Log.d("onMoodClick", "Haha");
                imageMood.setImageResource(R.drawable.haha);
                break;
            case R.id.buttonWow:
                Log.d("onMoodClick", "Wow");
                imageMood.setImageResource(R.drawable.wow);
                break;
            case R.id.buttonSad:
                Log.d("onMoodClick", "Sad");
                imageMood.setImageResource(R.drawable.sad);
                break;
            case R.id.buttonAngry:
                Log.d("onMoodClick", "Angry");
                imageMood.setImageResource(R.drawable.angry);
                break;
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
}
