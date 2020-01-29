package valet.chilicon.rpgcharacter;

public class ClassInventory {
    private int quantite;
    private String nom;

    public ClassInventory(int quantite, String nom) {
        this.quantite = quantite;
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Inventory{" + quantite + ", nom='" + nom +'}';
    }
}
