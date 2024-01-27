/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Utilisateur {

    private String nom;
    private int identifiant;

    public Utilisateur(String nom, int identifiant) {
        this.nom = nom;
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public int getIdentifiant() {
        return identifiant;
    }
}
