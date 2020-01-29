package valet.chilicon.rpgcharacter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;

import static valet.chilicon.rpgcharacter.CreateCharacter.characterList;

public class ChooseCharacter extends AppCompatActivity {

    private RecyclerView rvChoose;
    private ClassCharacter character;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_character);

        refresh();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvChoose = findViewById(R.id.listeDesPersos);
        rvChoose.setLayoutManager(manager);
        AdapterChoosecharacter choosecharacter = new AdapterChoosecharacter(characterList);
        rvChoose.setAdapter(choosecharacter);
    }

    public void refresh(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("listePerso",null);
        Gson gson = new Gson();
        String perso = sharedPreferences.getString("character",null);

        if (json != null) {
            if (perso != null){
                character = new ClassCharacter();
                character = gson.fromJson(perso, ClassCharacter.class);
            }
            characterList.add(character);
        }
        else {
            characterList.add(gson.fromJson(json, ClassCharacter.class));
        }
        Gson gsonList = new Gson();
        sharedPreferences.edit().putString("listePerso",gsonList.toJson(characterList)).apply();

        System.out.println("TAG json choose "+perso);
    }

}
