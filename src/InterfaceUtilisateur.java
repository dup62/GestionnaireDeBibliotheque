import java.util.Scanner;

/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class InterfaceUtilisateur {

    public static void main(String[] args) {

        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.chargerLivresDepuisFichier();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des livres disponibles");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre");
            System.out.println("4. Ajouter un livre");
            System.out.println("5. Supprimer un livre");
            System.out.println("6. Afficher la liste des livres");
            System.out.println("7. Afficher la liste des livres indisponibles");
            System.out.println("8. Afficher la liste des livres d'un auteur");
            System.out.println("9. Statistiques");
            System.out.println("10. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    bibliotheque.afficherLivresDisponibles();
                    break;
                case 2:
                    System.out.print("Entrez le titre du livre que vous souhaitez emprunter : ");
                    scanner.nextLine(); // pour consommer le retour à la ligne
                    String titreEmprunt = scanner.nextLine();
                    bibliotheque.emprunterLivre(titreEmprunt);
                    break;
                case 3:
                    System.out.print("Entrez le titre du livre que vous souhaitez retourner : ");
                    scanner.nextLine(); // pour consommer le retour à la ligne
                    String titreRetour = scanner.nextLine();
                    bibliotheque.retournerLivre(titreRetour);
                    break;
                case 4:
                    System.out.print("Entrez le titre du livre que vous souhaitez ajouter : ");
                    scanner.nextLine(); // pour consommer le retour à la ligne
                    String titreAjout = scanner.nextLine();
                    System.out.print("Entrez l'auteur du livre que vous souhaitez ajouter : ");
                    String auteurAjout = scanner.nextLine();
                    System.out.print("Entrez l'année de parution du livre que vous souhaitez ajouter : ");
                    int anneeParutionAjout = scanner.nextInt();
                    bibliotheque.ajouterLivre(new Livre(titreAjout, auteurAjout, anneeParutionAjout));
                    break;
                case 5:
                    System.out.print("Entrez le titre du livre que vous souhaitez supprimer : ");
                    scanner.nextLine(); // pour consommer le retour à la ligne
                    String titreSuppression = scanner.nextLine();
                    bibliotheque.supprimerLivre(titreSuppression);
                    break;
                case 6:
                    System.out.println("\nListe des livres : \n");
                    bibliotheque.afficherLivres();
                    break;
                case 7:
                    bibliotheque.afficherLivresIndisponibles();
                    break;
                case 8:
                    System.out.print("Entrez le nom de l'auteur dont vous souhaitez afficher les livres : ");
                    scanner.nextLine(); // pour consommer le retour à la ligne
                    String auteur = scanner.nextLine();
                    System.out.print("Entrez l'année de parution des livres que vous souhaitez afficher : ");
                    int anneeParution = scanner.nextInt();
                    bibliotheque.afficherLivresAuteurAnneeParution(auteur, anneeParution);
                    break;
                case 9:
                    bibliotheque.afficherStatistiques();
                    break;
                case 10:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                bibliotheque.enregistrerLivresDansFichier();
                System.out.println("Données enregistrées dans le fichier.");
            }));
        }

    }

}
