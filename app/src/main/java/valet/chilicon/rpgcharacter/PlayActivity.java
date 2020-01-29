package valet.chilicon.rpgcharacter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    private TextView name, race, classe, element, level, hp, mp, physical, social, mental, power, fineness, aura, instinct, relation, knowledge;

    public static TextView po, pa ,pc;
    private RecyclerView rvTraits, rvMoney, rvSkills, rvBonus, rvStuff, rvinventory;
    private ImageView photo;

    private ArrayList<String> traitArrayList = new ArrayList<>();
    private ArrayList<ClassSkill> skillsArrayList = new ArrayList<>();
    private ArrayList<ClassPiece> pieceClassArrayList = new ArrayList<>();

    private ArrayList<ClassBonus> bonusArrayList = new ArrayList<>();
    private ArrayList<ClassInventory> inventaireList = new ArrayList<>();
    private ArrayList<ClassStuff> stuffList = new ArrayList<>();

    private ClassCharacter perso;
    public static String nom;

    Button addPv, addPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        name = findViewById(R.id.namePerso);
        race = findViewById(R.id.racePerso);
        classe = findViewById(R.id.classePerso);
        element = findViewById(R.id.elementPerso);
        level = findViewById(R.id.levelPerso);
        hp = findViewById(R.id.hpPerso);
        mp = findViewById(R.id.mpPerso);
        physical = findViewById(R.id.physicalPerso);
        social = findViewById(R.id.socialPerso);
        mental = findViewById(R.id.mentalPerso);
        power = findViewById(R.id.powerPerso);
        fineness = findViewById(R.id.finenessPerso);
        aura = findViewById(R.id.auraPerso);
        instinct = findViewById(R.id.instinctPerso);
        relation = findViewById(R.id.relationPerso);
        knowledge = findViewById(R.id.knowledgePerso);
        addPv = findViewById(R.id.incrementLife);
        addPm = findViewById(R.id.incrementMana);

        po = findViewById(R.id.po);
        pa = findViewById(R.id.pa);
        pc = findViewById(R.id.pc);

        rvTraits = findViewById(R.id.rvTraits);
        rvBonus = findViewById(R.id.listBonus);
        rvSkills = findViewById(R.id.listSkills);
        rvinventory = findViewById(R.id.listInventory);
        rvStuff = findViewById(R.id.listStuff);
        photo = findViewById(R.id.imgPerso);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        nom = getIntent().getStringExtra("namePerso");
        String json = sharedPreferences.getString("character", null);
        if (json != null) {
            perso = gson.fromJson(json, ClassCharacter.class);
            remplissageFichePerso(perso);
        }


    }

    public void editMoney(View view){
        if (rvMoney.getVisibility() == View.GONE){
            rvMoney.setVisibility(View.VISIBLE);
        }
        else {
            rvMoney.setVisibility(View.GONE);
        }
    }
    public void getPicture(View v){
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                photo.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    public void initializeRecycler(){
        LinearLayoutManager manager = new LinearLayoutManager(this);

        rvMoney = findViewById(R.id.recyclerMoney);
        rvMoney.setLayoutManager(manager);
        AdapterMoney moneyAdapter = new AdapterMoney(pieceClassArrayList);
        rvMoney.setAdapter(moneyAdapter);

        rvTraits = findViewById(R.id.rvTraits);
        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        rvTraits.setLayoutManager(manager2);
        AdapterTraits adapterTraits = new AdapterTraits(traitArrayList);
        rvTraits.setAdapter(adapterTraits);

        rvSkills = findViewById(R.id.listSkills);
        LinearLayoutManager manager3 = new LinearLayoutManager(this);
        rvSkills.setLayoutManager(manager3);
        AdapterSkills adapterSkills = new AdapterSkills(skillsArrayList);
        rvSkills.setAdapter(adapterSkills);

        rvBonus = findViewById(R.id.listBonus);
        LinearLayoutManager manager4 = new LinearLayoutManager(this);
        rvBonus.setLayoutManager(manager4);
        AdapterBonus adapterBonus = new AdapterBonus(bonusArrayList);
        rvBonus.setAdapter(adapterBonus);

        rvinventory = findViewById(R.id.listInventory);
        LinearLayoutManager manager5 = new LinearLayoutManager(this);
        rvinventory.setLayoutManager(manager5);
        AdapterInventory adapterInventory = new AdapterInventory(inventaireList);
        rvinventory.setAdapter(adapterInventory);

        rvStuff = findViewById(R.id.listStuff);
        LinearLayoutManager manager6 = new LinearLayoutManager(this);
        rvStuff.setLayoutManager(manager6);
        AdapterStuff adapterStuff = new AdapterStuff(stuffList);
        rvStuff.setAdapter(adapterStuff);
    }
    public void addHP(View v) {
        if (perso.getPv() == perso.getPvMax()){
            addPv.setClickable(false);
        }
        else {
            addPv.setClickable(true);

            hp.setText(getResources().getString(R.string.getHPandMAX,perso.getPv() + 1, perso.getPvMax()));
            int pv = perso.getPv() + 1;
            perso.setPv(pv);

            editSharedPref();
        }
    }
    public void removeHP(View v) {
        hp.setText(getResources().getString(R.string.getHPandMAX,perso.getPv() - 1, perso.getPvMax()));
        int pv = perso.getPv() - 1;
        perso.setPv(pv);

        editSharedPref();
        if (perso.getPv() == perso.getPvMax() - (perso.getPvMax() * 2)) {
            final AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setMessage(R.string.die);
            Alert.show();
        }
    }
    public void addMp(View v) {
        if (perso.getMp() == perso.getMpMax()){
            addPm.setClickable(false);
        }
        else {
            addPm.setClickable(true);

            mp.setText(getResources().getString(R.string.getMPandMAX, perso.getMp() + 1, perso.getMpMax()));
            perso.setMp(perso.getMp() + 1);

            editSharedPref();
        }
    }
    public void removeMP(View v) {
        mp.setText(getResources().getString(R.string.getMPandMAX,perso.getMp() - 1, perso.getMpMax()));
        perso.setMp(perso.getMp() - 1);
        editSharedPref();
        if (perso.getMp() == 0) {
            final AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setMessage(R.string.useHP);
            Alert.show();
        }
    }

    public void editSharedPref() {
        ClassCharacter newPerso = perso;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        sharedPreferences.edit().putString(newPerso.getName(), gson.toJson(newPerso)).apply();
    }


    public void remplissageFichePerso(ClassCharacter perso) {
        initializeRecycler();


        name.setText(perso.getName());
        race.setText(perso.getRace());
        classe.setText(perso.getClasse());
        element.setText(getResources().getString(R.string.elem, perso.getElement()));
        level.setText(String.valueOf(perso.getLevel()));

        po.setText(String.valueOf(perso.getMoney().get(0).getQuantité()));
        pa.setText(String.valueOf(perso.getMoney().get(1).getQuantité()));
        pc.setText(String.valueOf(perso.getMoney().get(2).getQuantité()));



        hp.setText(getResources().getString(R.string.getHPandMAX, perso.getPv(), perso.getPvMax()));
        mp.setText(getResources().getString(R.string.getMPandMAX, perso.getMp(), perso.getMpMax()));
        physical.setText(String.valueOf(perso.getPhysical()));
        power.setText(String.valueOf(perso.getPower()));
        fineness.setText(String.valueOf(perso.getFineness()));
        social.setText(String.valueOf(perso.getSocial()));
        aura.setText(String.valueOf(perso.getAura()));
        relation.setText(String.valueOf(perso.getRelation()));
        mental.setText(String.valueOf(perso.getMental()));
        instinct.setText(String.valueOf(perso.getInstinct()));
        knowledge.setText(String.valueOf(perso.getKnowledge()));
    }
//        if (perso != null) {
//            name.setText(perso.getName());
//            race.setText(perso.getRace());
//            classe.setText(perso.getClasse());
//            element.setText(getResources().getString(R.string.elem, perso.getElement()));
//            level.setText(String.valueOf(perso.getLevel()));
//
//            for (int i=0;i<3;i++) {
//                traitArrayList.add(perso.getTraits().get(i));
//            }
//
//            pieceClassArrayList.add(perso.getPo());
//            pieceClassArrayList.add(perso.getPa());
//            pieceClassArrayList.add(perso.getPb());
//
//            po.setText(getResources().getString(R.string.po, perso.getPo()));
//            pa.setText(getResources().getString(R.string.po, perso.getPa()));
//            pc.setText(getResources().getString(R.string.po, perso.getPb()));
//
//
//            hp.setText(getResources().getString(R.string.getHPandMAX, perso.getPv(), perso.getPvMax()));
//            mp.setText(getResources().getString(R.string.getMPandMAX, perso.getMp(), perso.getMpMax()));
//            physical.setText(String.valueOf(perso.getPhysical()));
//            power.setText(String.valueOf(perso.getPower()));
//            fineness.setText(String.valueOf(perso.getFineness()));
//            social.setText(String.valueOf(perso.getSocial()));
//            aura.setText(String.valueOf(perso.getAura()));
//            relation.setText(String.valueOf(perso.getRelation()));
//            mental.setText(String.valueOf(perso.getMental()));
//            instinct.setText(String.valueOf(perso.getInstinct()));
//            knowledge.setText(String.valueOf(perso.getKnowledge()));
//
//            for (int p=1; p<=5; p++){
//                ClassSkill ski = new ClassSkill(perso.getSkills().get(p), perso.getValueSkills().get(p));
//                skillsArrayList.add(ski);
//            }
//            for (int p=1; p<=3; p++){
//                ClassBonus bon = new ClassBonus(perso.getBonus().get(p), perso.getValueBonus().get(p));
//                bonusArrayList.add(bon);
//            }
//        }
//        initializeRecycler();
//    }





}

