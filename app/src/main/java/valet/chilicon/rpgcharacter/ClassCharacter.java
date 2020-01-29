package valet.chilicon.rpgcharacter;

import android.widget.ImageView;

import java.util.ArrayList;

public class ClassCharacter {

    private String name;
    private String race;
    private String classe;
    private String element;
    private int level;
    private ArrayList<String> traits;
    private ImageView image;
    private ArrayList<ClassPiece> money;
    private int mp;
    private int mpMax;
    private int pv;
    private int pvMax;
    private int physical;
    private int social;
    private int mental;
    private int power;
    private int fineness;
    private int aura;
    private int relation;
    private int instinct;
    private int knowledge;
    private ArrayList<ClassSkill> skills;
    private ArrayList<ClassBonus> bonus;
    private ArrayList<ClassInventory> inventory;
    private ArrayList<ClassStuff> stuff;

    public ClassCharacter(){
        this.pv = pvMax;
        this.mp = mpMax;
    }

    public ClassCharacter(String name, String race, String classe, String element, int level, ArrayList<String> traits, ArrayList<ClassPiece> money, int mp, int mpMax, int pv, int pvMax, int physical, int social, int mental, int power, int fineness, int aura, int relation, int instinct, int knowledge, ArrayList<ClassSkill> skills, ArrayList<ClassBonus> bonus) {
        this.name = name;
        this.race = race;
        this.classe = classe;
        this.element = element;
        this.level = level;
        this.traits = traits;
        this.money = money;
        this.mp = mp;
        this.mpMax = mpMax;
        this.pv = pv;
        this.pvMax = pvMax;
        this.physical = physical;
        this.social = social;
        this.mental = mental;
        this.power = power;
        this.fineness = fineness;
        this.aura = aura;
        this.relation = relation;
        this.instinct = instinct;
        this.knowledge = knowledge;
        this.skills = skills;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getClasse() {
        return classe;
    }

    public String getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getTraits() {
        return traits;
    }

    public ImageView getImage() {
        return image;
    }

    public ArrayList<ClassPiece> getMoney() {
        return money;
    }

    public int getMp() {
        return mp;
    }

    public int getMpMax() {
        return mpMax;
    }

    public int getPv() {
        return pv;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getPhysical() {
        return physical;
    }

    public int getSocial() {
        return social;
    }

    public int getMental() {
        return mental;
    }

    public int getPower() {
        return power;
    }

    public int getFineness() {
        return fineness;
    }

    public int getAura() {
        return aura;
    }

    public int getRelation() {
        return relation;
    }

    public int getInstinct() {
        return instinct;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public ArrayList<ClassSkill> getSkills() {
        return skills;
    }

    public ArrayList<ClassBonus> getBonus() {
        return bonus;
    }

    public ArrayList<ClassInventory> getInventory() {
        return inventory;
    }

    public ArrayList<ClassStuff> getStuff() {
        return stuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTraits(ArrayList<String> traits) {
        this.traits = traits;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public void setMoney(ArrayList<ClassPiece> money) {
        this.money = money;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setFineness(int fineness) {
        this.fineness = fineness;
    }

    public void setAura(int aura) {
        this.aura = aura;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public void setInstinct(int instinct) {
        this.instinct = instinct;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public void setSkills(ArrayList<ClassSkill> skills) {
        this.skills = skills;
    }

    public void setBonus(ArrayList<ClassBonus> bonus) {
        this.bonus = bonus;
    }

    public void setInventory(ArrayList<ClassInventory> inventory) {
        this.inventory = inventory;
    }

    public void setStuff(ArrayList<ClassStuff> stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "ClassCharacter{" + "name='" + name + '\'' + ", race='" + race + '\'' + ", classe='" + classe + '\'' + ", element='" + element + '\'' + ", level=" + level + ", traits=" + traits + ", image=" + image + ", mp=" + mp + ", mpMax=" + mpMax + ", pv=" + pv + ", pvMax=" + pvMax + ", physical=" + physical + ", social=" + social + ", mental=" + mental + ", power=" + power + ", fineness=" + fineness + ", aura=" + aura + ", relation=" + relation + ", instinct=" + instinct + ", knowledge=" + knowledge + ", skills=" + skills + ", bonus=" + bonus + ", inventory=" + inventory + ", stuff=" + stuff + '}';
    }
}
