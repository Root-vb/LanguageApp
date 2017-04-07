package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);
        final ArrayList<translation> numberArray = new ArrayList<translation>();

        numberArray.add(new translation("Father","पापा",R.drawable.family_father,R.raw.paapa));
        numberArray.add(new translation("Mother","माता / मां",R.drawable.family_mother,R.raw.maa));
        numberArray.add(new translation("Sister","बहन",R.drawable.family_younger_sister,R.raw.behan));
        numberArray.add(new translation("Brother","भाई",R.drawable.family_younger_brother,R.raw.bhai));
        numberArray.add(new translation("Friend","दोस्त",R.drawable.family_younger_brother,R.raw.doughst));
        numberArray.add(new translation("Son","बेटा",R.drawable.family_son,R.raw.beta));
        numberArray.add(new translation("Daughter","बेटी",R.drawable.family_daughter,R.raw.betee));
        numberArray.add(new translation("Grand Father(Paternal) ","दादा",R.drawable.family_grandfather,R.raw.dada));
        numberArray.add(new translation("Grand Mother(Paternal) ","दादी",R.drawable.family_grandmother,R.raw.dadi));
        numberArray.add(new translation("Grand Father(Maternal) ","नाना",R.drawable.family_grandfather,R.raw.nana));
        numberArray.add(new translation("Grand Mother(Maternal) ","नानी",R.drawable.family_grandmother,R.raw.naani));
        numberArray.add(new translation("Father's younger brother","चाचा",R.drawable.family_older_brother,R.raw.chacha));
        numberArray.add(new translation("Father's elder brother","ताया",R.drawable.family_father,R.raw.taaya));
        numberArray.add(new translation("Father's Sister ","बुआ",R.drawable.family_older_sister,R.raw.booaa));
        numberArray.add(new translation("Mother's Brother ","मामा ",R.drawable.family_older_brother,R.raw.mama));
        numberArray.add(new translation("Mother's Sister ","मासी",R.drawable.family_older_sister,R.raw.massi));


        translationAdapter itemsAdapter = new translationAdapter(this,numberArray,R.color.category_family);


        ListView listview = (ListView) findViewById(R.id.list_familyMembers);

        listview.setAdapter(itemsAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                translation tr = numberArray.get(position);
                releaseMediaPlayer();
                mp = MediaPlayer.create( FamilyMembers.this,tr.getAudioID());
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
