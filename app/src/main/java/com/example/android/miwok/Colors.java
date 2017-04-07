package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<translation> numberArray = new ArrayList<translation>();

        numberArray.add(new translation("Red", "लाल", R.drawable.color_red, R.raw.laal));
        numberArray.add(new translation("Green", "हरा", R.drawable.color_green,R.raw.hara));
        numberArray.add(new translation("Black", "काला", R.drawable.color_black,R.raw.kaala));
        numberArray.add(new translation("Yellow", "पीला", R.drawable.color_mustard_yellow,R.raw.peela));
        numberArray.add(new translation("White", "सफेद", R.drawable.color_white,R.raw.safed));
        numberArray.add(new translation("Light Brown", "हल्का भूरा", R.drawable.color_dusty_yellow,R.raw.halka_bhoora));
        numberArray.add(new translation("Brown", "भूरा", R.drawable.color_brown,R.raw.bhoora));
        translationAdapter itemsAdapter = new translationAdapter(this, numberArray, R.color.category_colors);


        ListView listview = (ListView) findViewById(R.id.list_colors);


        listview.setAdapter(itemsAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                translation tr = numberArray.get(position);
                releaseMediaPlayer();
                mp = MediaPlayer.create( Colors.this,tr.getAudioID());
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    private MediaPlayer mp;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    private void releaseMediaPlayer()
    {
        if(mp!=null)
        {
            mp.release();
            mp = null;
        }
    }
}
