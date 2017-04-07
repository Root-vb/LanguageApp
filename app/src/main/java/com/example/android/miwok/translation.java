package com.example.android.miwok;

/**
 * Created by bhasin on 28-Sep-16.
 */

public class translation {

        String translatedWord,DefaultWord;
        int imageID,audioID;

        public

        translation(String a,String b,int c,int d)
        {
            DefaultWord=b;
            translatedWord=a;
            imageID=c;
            audioID=d;
        }
        String gettranslatedWord()
        {
            return translatedWord;
        }
        String getDefaultWord()
        {
            return DefaultWord;
        }
        int getImageID()
        {
            return imageID;
        }
        int getAudioID()
        {
            return audioID;
        }

}
