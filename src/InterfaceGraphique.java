import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Desnyder Rémi
 * Date: 27/01/2024
 */

public class InterfaceGraphique extends JFrame {

    private Bibliotheque bibliotheque;

    public InterfaceGraphique(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        bibliotheque.chargerLivresDepuisFichier();

        setTitle("Gestion de Bibliothèque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        initUI();

        setVisible(true);
    }

    private void initUI() {
        // Crée un panneau
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Bouton pour afficher la liste des livres
        JButton btnAfficherLivres = new JButton("Afficher la liste des livres");
        btnAfficherLivres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupère la liste des livres depuis la bibliothèque
                List<Livre> livres = bibliotheque.getLivres();

                // Construit une chaîne pour afficher la liste des livres
                StringBuilder livresTexte = new StringBuilder("Liste des Livres :\n\n");
                for (Livre livre : livres) {
                    livresTexte.append("Titre : ").append(livre.getTitre()).append("\n");
                    livresTexte.append("Auteur : ").append(livre.getAuteur()).append("\n");
                    livresTexte.append("Disponible : ").append(livre.isDisponible() ? "Oui" : "Non").append("\n\n");
                }

                // Affiche la liste des livres dans une boîte de dialogue
                JOptionPane.showMessageDialog(null, livresTexte.toString(), "Liste des Livres", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Bouton pour emprunter un livre
        JButton btnEmprunterLivre = new JButton("Emprunter un livre");
        btnEmprunterLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code pour emprunter un livre
                // (peut-être une boîte de dialogue pour saisir le titre)
            }
        });

        // Bouton pour retourner un livre
        JButton btnRetournerLivre = new JButton("Retourner un livre");
        btnRetournerLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici le code pour retourner un livre
                // (peut-être une boîte de dialogue pour saisir le titre)
            }
        });

        // Ajoute les boutons au panneau
        panel.add(btnAfficherLivres);
        panel.add(btnEmprunterLivre);
        panel.add(btnRetournerLivre);

        // Ajoute le panneau à la fenêtre
        add(panel);
    }

    public static void main(String[] args) {
        // Crée une instance de Bibliothèque
        Bibliotheque bibliotheque = new Bibliotheque();

        // Crée une instance de l'interface graphique
        SwingUtilities.invokeLater(() -> new InterfaceGraphique(bibliotheque));
    }

}
