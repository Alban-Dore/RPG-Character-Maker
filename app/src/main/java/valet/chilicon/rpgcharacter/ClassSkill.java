package valet.chilicon.rpgcharacter;

public class ClassSkill {
    private String nom;
    private String value;

    public ClassSkill(String nom, String value) {
        this.nom = nom;
        this.value = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Skill{" + nom + ", value='" + value +'}';
    }
}
