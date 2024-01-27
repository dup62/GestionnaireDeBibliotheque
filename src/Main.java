/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class Main {

    public static void main(String[] args) {

        Bibliotheque bibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("Titre1", "Auteur1", 2020, true);
        Livre livre2 = new Livre("Titre2", "Auteur2", 2018, true);

        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        bibliotheque.afficherLivresDisponibles();

        bibliotheque.emprunterLivre("Titre1");

        bibliotheque.afficherLivresDisponibles();

        bibliotheque.retournerLivre("Titre1");

        bibliotheque.afficherLivresDisponibles();

    }

}
