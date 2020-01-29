package valet.chilicon.rpgcharacter;

public class ClassBonus {

    private String nom;
    private String value;

    public ClassBonus(String nom, String value) {
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
        return "Bonus{" + nom + ", value='" + value +'}';
    }
}
