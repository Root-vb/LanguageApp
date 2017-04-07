package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<translation> numberArray = new ArrayList<translation>();

        numberArray.add(new translation("1 - One","१ - एक",R.drawable.number_one,R.raw.ek));
        numberArray.add(new translation("2 - Two","२ - दो",R.drawable.number_two,R.raw.though));
        numberArray.add(new translation("3 - Three","३ - तीन",R.drawable.number_three,R.raw.teen));
        numberArray.add(new translation("4 - Four","४ - चार",R.drawable.number_four,R.raw.chaar));
        numberArray.add(new translation("5 - Five","५ - पांच",R.drawable.number_five,R.raw.paanch));
        numberArray.add(new translation("6 - Six","६ - छह",R.drawable.number_six,R.raw.chhe));
        numberArray.add(new translation("7 - Seven","७ - सात",R.drawable.number_seven,R.raw.saat));
        numberArray.add(new translation("8 - Eight","८ - आठ",R.drawable.number_eight,R.raw.aath));
        numberArray.add(new translation("9 - Nine","९ - नौ",R.drawable.number_nine,R.raw.naw));
        numberArray.add(new translation("10 - Ten","१० -  दस",R.drawable.number_ten,R.raw.das));

        translationAdapter itemsAdapter = new translationAdapter(this,numberArray,R.color.category_numbers);


        ListView listview = (ListView) findViewById(R.id.list);

        listview.setAdapter(itemsAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                translation tr = numberArray.get(position);
                releaseMediaPlayer();
                mp = MediaPlayer.create( Numbers.this,tr.getAudioID());
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
        });
    }
}
