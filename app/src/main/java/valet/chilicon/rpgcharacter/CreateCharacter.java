package valet.chilicon.rpgcharacter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateCharacter extends AppCompatActivity {

    private EditText name, race, classe, element, level,
            hp, mp, physical, social, mental,
            power, fineness, aura, instinct, relation, knowledge,
            trait1, trait2, trait3, bonus1, bonus2, bonus3,
            skill1, skill2, skill3, skill4, skill5,
            valueSkill1, valueSkill2, valueSkill3, valueSkill4, valueSkill5,
            valueBonus1, valueBonus2, valueBonus3;

    private Button btnSave;
    private Context ctx;

    ArrayList<String> characterTraits = new ArrayList<>();
    ArrayList<ClassPiece> pieceArrayList = new ArrayList<>();
    ArrayList<ClassBonus> bonus = new ArrayList<>();
    ArrayList<ClassSkill> skills = new ArrayList<>();
    static ArrayList<ClassCharacter> characterList = new ArrayList<>();
    ArrayList<ClassInventory> inventaire = new ArrayList<>();
    ArrayList<ClassStuff> stuff = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);

        String jsonList = sharedPreferences.getString("listePerso",null);

        if(jsonList != null){

        }else{
            characterList = new ArrayList<>();
        }

        ctx = getApplicationContext();

        name = findViewById(R.id.name);
        race = findViewById(R.id.race);
        classe = findViewById(R.id.classe);
        element = findViewById(R.id.element);
        level = findViewById(R.id.level);
        hp = findViewById(R.id.hp);
        mp = findViewById(R.id.mp);
        physical = findViewById(R.id.physical);
        social = findViewById(R.id.social);
        mental = findViewById(R.id.mental);
        power = findViewById(R.id.power);
        fineness = findViewById(R.id.fineness);
        aura = findViewById(R.id.aura);
        instinct = findViewById(R.id.instinct);
        relation = findViewById(R.id.relation);
        knowledge = findViewById(R.id.knowledge);
        trait1 = findViewById(R.id.trait1);
        trait2 = findViewById(R.id.trait2);
        trait3 = findViewById(R.id.trait3);
        bonus1 = findViewById(R.id.bonus1);
        bonus2 = findViewById(R.id.bonus2);
        bonus3 = findViewById(R.id.bonus3);
        skill1 = findViewById(R.id.skill1);
        skill2 = findViewById(R.id.skill2);
        skill3 = findViewById(R.id.skill3);
        skill4 = findViewById(R.id.skill4);
        skill5 = findViewById(R.id.skill5);
        valueSkill1 = findViewById(R.id.valueSkill1);
        valueSkill2 = findViewById(R.id.valueSkill2);
        valueSkill3 = findViewById(R.id.valueSkill3);
        valueSkill4 = findViewById(R.id.valueSkill4);
        valueSkill5 = findViewById(R.id.valueSkill5);
        valueBonus1 = findViewById(R.id.valuebonus1);
        valueBonus2 = findViewById(R.id.valuebonus2);
        valueBonus3 = findViewById(R.id.valuebonus3);
        btnSave = findViewById(R.id.save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassCharacter Perso = new ClassCharacter();
                Perso.setName(name.getText().toString());
                Perso.setRace(race.getText().toString());
                Perso.setLevel(Integer.parseInt(level.getText().toString()));
                Perso.setElement(element.getText().toString());
                Perso.setClasse(classe.getText().toString());
                characterTraits.add(trait1.getText().toString());
                characterTraits.add(trait2.getText().toString());
                characterTraits.add(trait3.getText().toString());
                Perso.setTraits(characterTraits);
                Perso.setMpMax(Integer.parseInt(mp.getText().toString()));
                Perso.setPvMax(Integer.parseInt(hp.getText().toString()));
                Perso.setMp(Integer.parseInt(mp.getText().toString()));
                Perso.setPv(Integer.parseInt(hp.getText().toString()));
                Perso.setPhysical(Integer.parseInt(physical.getText().toString()));
                Perso.setSocial(Integer.parseInt(social.getText().toString()));
                Perso.setMental(Integer.parseInt(mental.getText().toString()));
                Perso.setPower(Integer.parseInt(power.getText().toString()));
                Perso.setFineness(Integer.parseInt(fineness.getText().toString()));
                Perso.setAura(Integer.parseInt(aura.getText().toString()));
                Perso.setRelation(Integer.parseInt(relation.getText().toString()));
                Perso.setInstinct(Integer.parseInt(instinct.getText().toString()));
                Perso.setKnowledge(Integer.parseInt(knowledge.getText().toString()));
                skills.add(new ClassSkill(skill1.getText().toString(),valueSkill1.getText().toString()));
                skills.add(new ClassSkill(skill2.getText().toString(),valueSkill2.getText().toString()));
                skills.add(new ClassSkill(skill3.getText().toString(),valueSkill3.getText().toString()));
                skills.add(new ClassSkill(skill4.getText().toString(),valueSkill4.getText().toString()));
                skills.add(new ClassSkill(skill5.getText().toString(),valueSkill5.getText().toString()));
                Perso.setSkills(skills);
                bonus.add(new ClassBonus(bonus1.getText().toString(), valueBonus1.getText().toString()));
                bonus.add(new ClassBonus(bonus2.getText().toString(), valueBonus2.getText().toString()));
                bonus.add(new ClassBonus(bonus3.getText().toString(), valueBonus3.getText().toString()));
                Perso.setBonus(bonus);
                inventaire.add(new ClassInventory(3,"Torches"));
                inventaire.add(new ClassInventory(1,"Paillasse"));
                inventaire.add(new ClassInventory(3,"Ration de nourriture"));
                Perso.setInventory(inventaire);
                pieceArrayList.add(new ClassPiece("Po",5));
                pieceArrayList.add(new ClassPiece("Pa",0));
                pieceArrayList.add(new ClassPiece("Pb",0));
                Perso.setMoney(pieceArrayList);
                Perso.setStuff(stuff);



                Perso.getImage().setImageDrawable(getResources().getDrawable(R.drawable.profil));


                characterList.add(Perso);


                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);
                final Gson gson = new Gson();
                final String json = gson.toJson(Perso);
                sharedPreferences.edit()
                        .putString("character",json)
                        .apply();

                sharedPreferences.edit()
                        .putString("listePerso",gson.toJson(characterList))
                        .apply();
                Intent Test = new Intent(getApplicationContext(), PlayActivity.class);
                Test.putExtra("namePerso", Perso.getName());
                startActivity(Test);
                finish();
            }
        });

    }
}
