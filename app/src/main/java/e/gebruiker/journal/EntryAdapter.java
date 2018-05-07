package e.gebruiker.journal;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends android.widget.ResourceCursorAdapter {

//    private LayoutInflater cursorInflater;

    public EntryAdapter(Context context, Cursor c) {
        super(context, R.layout.entry_row, c);

    }

    @Override
    public void bindView(View view, Context context, Cursor c) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = inflater.inflate(R.layout.entry_row, null);



        TextView textViewTitle = view.findViewById(R.id.titles);

        String title = c.getString(c.getColumnIndex(EntryDatabase.columnTitle));
        textViewTitle.setText(title);

//        TextView textViewContent = view.findViewById(R.id.content);
//        String content = c.getString(c.getColumnIndex(EntryDatabase.columnContent));
//        textViewContent.setText(content);

        TextView textViewTimeStamp = view.findViewById(R.id.timeStamp);
        String timeStamp = c.getString(c.getColumnIndex(EntryDatabase.columnTimeStap));
        textViewTimeStamp.setText(timeStamp);

        ImageView imageViewMoods = view.findViewById(R.id.moods);
        String moods = c.getString(c.getColumnIndex(EntryDatabase.columnMood));

        try {
            switch (moods){
                case "like":
                    imageViewMoods.setImageResource(R.drawable.like);
                    break;
                case "love":
                    imageViewMoods.setImageResource(R.drawable.love);
                    break;
                case "haha":
                    imageViewMoods.setImageResource(R.drawable.haha);
                    break;
                case "wow":
                    imageViewMoods.setImageResource(R.drawable.wow);
                    break;
                case "sad":
                    imageViewMoods.setImageResource(R.drawable.sad);
                    break;
                case "angry":
                    imageViewMoods.setImageResource(R.drawable.angry);
                    break;
            }
        } catch (NullPointerException e) {
            Log.d("Exception", "NullPointerException");
            imageViewMoods.setImageResource(R.drawable.like);
        }
    }
}
