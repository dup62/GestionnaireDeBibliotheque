/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Livre {

    private String titre;
    private String auteur;
    private int anneeParution;
    private Boolean disponible;

    public Livre() {
        this.titre = "";
        this.auteur = "";
        this.anneeParution = Integer.MIN_VALUE;
        this.disponible = true;
    }

    public Livre(String titre, String auteur, int anneeParution) {
        this();
        this.titre = titre;
        this.auteur = auteur;
        this.anneeParution = anneeParution;
    }

    public Livre(String titre, String auteur, int anneeParution, Boolean disponible) {
        this(titre, auteur, anneeParution);
        this.disponible = disponible;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnneeParution() {
        return anneeParution;
    }

    public Boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
