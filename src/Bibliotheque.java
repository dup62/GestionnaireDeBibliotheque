import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Bibliotheque {

    private List<Livre> livres;
    private List<Utilisateur> utilisateurs;

    private static final String NOM_FICHIER = "bibliotheque.txt";

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.utilisateurs = new ArrayList<>();
    }

    public Bibliotheque(List<Livre> livres) {
        this();
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

    public void supprimerLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre)) {
                livres.remove(livre);
                return;
            }
        }
    }

    public void afficherLivres() {
        for (Livre livre : this.livres) {
            String disponibilite = livre.isDisponible() ? "Disponible" : "Indisponible";
            System.out.println(livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getAnneeParution() + " - " + disponibilite);
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

            Calendar calendar = Calendar.getInstance();

            Date dateActuelle = new Date();

            calendar.setTime(dateActuelle);
            calendar.add(Calendar.DAY_OF_MONTH, 14);

            Date dateRetourPrevue = calendar.getTime();

            livre.setDateRetourPrevue(dateRetourPrevue);
        }
    }

    public void rendreLivre(Livre livre) {
        livre.setDisponible(true);
        livre.setDateRetourPrevue(null);
    }

    public void emprunterLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre) && livre.isDisponible()) {
                livre.setDisponible(false);

                Calendar calendar = Calendar.getInstance();

                Date dateActuelle = new Date();

                calendar.setTime(dateActuelle);
                calendar.add(Calendar.DAY_OF_MONTH, 14);

                Date dateRetourPrevue = calendar.getTime();

                livre.setDateRetourPrevue(dateRetourPrevue);

                livre.setEmprunteur(null);

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
                livre.setDateRetourPrevue(null);
                livre.setEmprunteur(null);
                System.out.println("Vous avez retourné le livre : " + livre.getTitre());
                return;
            }
        }
        System.out.println("Vous ne pouvez pas retourner ce livre car il n'a pas été emprunté.");
    }

    // Méthode pour charger les livres depuis le fichier
    public void chargerLivresDepuisFichier() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOM_FICHIER))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                Livre livre = Livre.fromCSVString(ligne);
                livres.add(livre);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Méthode pour enregistrer les livres dans le fichier
    public void enregistrerLivresDansFichier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOM_FICHIER))) {
            for (Livre livre : livres) {
                writer.write(livre.toCSVString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    public void afficherStatistiques() {
        int totalLivres = livres.size();
        int livresDisponibles = 0;
        int livresEmpruntes = 0;

        for (Livre livre : livres) {
            if (livre.isDisponible()) {
                livresDisponibles++;
            } else {
                livresEmpruntes++;
            }
        }

        System.out.println("Statistiques de la Bibliothèque :");
        System.out.println("Nombre total de livres : " + totalLivres);
        System.out.println("Nombre de livres disponibles : " + livresDisponibles);
        System.out.println("Nombre de livres empruntés : " + livresEmpruntes);
    }

    public void afficherDatesRetourPrevue() {
        System.out.println("\nDates de retour prévues pour les livres empruntés :");
        for (Livre livre : livres) {
            if (!livre.isDisponible()) {
                System.out.println(livre.getTitre() + " - " + livre.getAuteur());
                livre.afficherDateRetourPrevue();
            }
        }
    }

    public void exporterDonnees(String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            for (Livre livre : livres) {
                writer.write(livre.toCSVString());
                writer.newLine();
            }
            System.out.println("Données exportées avec succès dans le fichier : " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'export des données : " + e.getMessage());
        }
    }

    public void importerDonnees(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                Livre livre = Livre.fromCSVString(ligne);
                livres.add(livre);
            }
            System.out.println("Données importées avec succès depuis le fichier : " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'import des données : " + e.getMessage());
        }
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public Utilisateur chercherUtilisateurParIdentifiant(int identifiant) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getIdentifiant() == identifiant) {
                return utilisateur;
            }
        }
        return null;
    }
}
