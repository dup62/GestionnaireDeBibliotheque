import java.util.Date;

/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Livre {

    private String titre;
    private String auteur;
    private int anneeParution;
    private Boolean disponible;
    private Date dateRetourPrevue;

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

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnneeParution(int anneeParution) {
        this.anneeParution = anneeParution;
    }

    public void setDateRetourPrevue(Date dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public void afficherDateRetourPrevue() {
        if (dateRetourPrevue != null) {
            System.out.println("Date de retour prévue : " + dateRetourPrevue);
        } else {
            System.out.println("Pas de date de retour prévue.");
        }
    }

    // Méthode pour convertir un livre en une chaîne de caractères pour l'enregistrement dans le fichier
    public String toCSVString() {
        return titre +
                "," +
                auteur +
                "," +
                anneeParution +
                "," +
                (disponible ? "1" : "0") +
                "," +
                (dateRetourPrevue != null ? dateRetourPrevue.getTime() : "");
    }

    // Méthode pour créer un livre à partir d'une chaîne de caractères lue depuis le fichier
    public static Livre fromCSVString(String ligne) {
        String[] champs = ligne.split(",");
        Livre livre = new Livre();
        livre.setTitre(champs[0]);
        livre.setAuteur(champs[1]);
        livre.setAnneeParution(Integer.parseInt(champs[2]));
        livre.setDisponible("1".equals(champs[3])); // Si le champ vaut "1", le livre est disponible, sinon non

        if ("0".equals(champs[3]) && !champs[4].isEmpty()) {
            livre.setDateRetourPrevue(new Date(Long.parseLong(champs[4])));
        }

        return livre;
    }
}
