import java.util.ArrayList;
import java.util.List;

/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Bibliotheque {

    private List<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    public Bibliotheque(List<Livre> livres) {
        this.livres = livres;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void ajouterLivre(Livre livre) {
        this.livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        this.livres.remove(livre);
    }

    public void afficherLivres() {
        for (Livre livre : this.livres) {
            System.out.println(livre.getTitre());
        }
    }

    public void afficherLivresDisponibles() {
        for (Livre livre : this.livres) {
            if (livre.isDisponible()) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresIndisponibles() {
        for (Livre livre : this.livres) {
            if (!livre.isDisponible()) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresAuteur(String auteur) {
        for (Livre livre : this.livres) {
            if (livre.getAuteur().equals(auteur)) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresTitre(String titre) {
        for (Livre livre : this.livres) {
            if (livre.getTitre().equals(titre)) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresAnneeParution(int anneeParution) {
        for (Livre livre : this.livres) {
            if (livre.getAnneeParution() == anneeParution) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresAuteurAnneeParution(String auteur, int anneeParution) {
        for (Livre livre : this.livres) {
            if (livre.getAuteur().equals(auteur) && livre.getAnneeParution() == anneeParution) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void afficherLivresTitreAnneeParution(String titre, int anneeParution) {
        for (Livre livre : this.livres) {
            if (livre.getTitre().equals(titre) && livre.getAnneeParution() == anneeParution) {
                System.out.println(livre.getTitre());
            }
        }
    }

    public void empunterLivre(Livre livre) {
        if (livre.isDisponible()) {
            livre.setDisponible(false);
        }
    }

    public void rendreLivre(Livre livre) {
        livre.setDisponible(true);
    }

    public void emprunterLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre) && livre.isDisponible()) {
                livre.setDisponible(false);
                System.out.println("Vous avez emprunté le livre : " + livre.getTitre());
                return;
            }
        }
        System.out.println("Le livre demandé n'est pas disponible.");
    }

    public void retournerLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre) && !livre.isDisponible()) {
                livre.setDisponible(true);
                System.out.println("Vous avez retourné le livre : " + livre.getTitre());
                return;
            }
        }
        System.out.println("Vous ne pouvez pas retourner ce livre car il n'a pas été emprunté.");
    }
}
