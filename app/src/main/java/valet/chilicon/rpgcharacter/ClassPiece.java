package valet.chilicon.rpgcharacter;

public class ClassPiece {
    String nom;
    int quantité;

    public ClassPiece(String nom, int quantité) {
        this.nom = nom ;
        this.quantité = quantité;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    @Override
    public String toString() {
        return "Piece{" + nom + ", quantité='" + quantité +'}';
    }
}
