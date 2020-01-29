package valet.chilicon.rpgcharacter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Intent goPlay, goCreate, newMain;
    String mLanguageCode = "";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Locale locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        pref = getApplicationContext().getSharedPreferences("LANG", MODE_PRIVATE);
//        String x =pref.getString("lang_code", null);
//        if(x!=null){
//            if (x.equals("en")){
//                locale = new Locale(pref.getString("lang_code","en"));
//                Locale.setDefault(locale);
//                mLanguageCode = "en";
//            }
//            else if (x.equals("fr"))
//            {
//                locale = new Locale(pref.getString("lang_code","fr"));
//                Locale.setDefault(locale);
//                mLanguageCode = "fr";
//            }
//        }
//        else {
//            locale = new Locale("en");
//            Locale.setDefault(locale);
//            mLanguageCode = "en";
//        }
//        Configuration config = getBaseContext().getResources().getConfiguration();
//        config.locale= locale;
//        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);



        goPlay = new Intent(this,ChooseCharacter.class);
        goCreate = new Intent(this,CreateCharacter.class);
        newMain = new Intent(this,MainActivity.class);

//        pref = getApplicationContext().getSharedPreferences("LANG", MODE_PRIVATE);
//        editor = pref.edit();
//
//        editor.putString("lang_code", mLanguageCode);
//        editor.apply();
    }
    public void play(View v){
        startActivity(goPlay);
    }
    public void create(View v){
        startActivity(goCreate);
    }
    public void changeLanguage(View v) {
//        if (mLanguageCode.equals("fr")){
//            newMain.putExtra("langage", "en");
//            editor.putString("lang_code", "en");
//            editor.apply();
//            startActivity(newMain);
//            finish();
//        }
//        else if (mLanguageCode.equals("en")){
//            newMain.putExtra("langage", "fr");
//            editor.putString("lang_code", "fr");
//            editor.apply();
//            startActivity(newMain);
//            finish();
//        }

    }

}
