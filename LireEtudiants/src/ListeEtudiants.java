import java.io.*;
import java.util.ArrayList;

/**
 * Représente une liste d'étudiants et fournit des méthodes pour lire, trier, modifier et écrire leurs informations.
 */
public class ListeEtudiants {
    // On déclare le caractère de séparation (peut changer selon le système d'exploitation)
    private static final char fSep = File.separatorChar;

    // Chemins des fichiers pour lire et écrire les données des étudiants
    private static final String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnees" + fSep + "etudiants.csv";
    private static final String pathOut = System.getProperty("user.dir") + fSep + "src" + fSep + "donnees" + fSep + "etudiantsOut.csv";

    // Liste des étudiants
    private ArrayList<Etudiant> etudiants;

    /**
     * Constructeur de ListeEtudiants qui initialise une liste vide.
     */
    public ListeEtudiants() {
        etudiants = new ArrayList<>();
    }

    /**
     * Lit les étudiants à partir d'un fichier CSV et les stocke dans la liste.
     * Chaque ligne du fichier doit être au format : matricule;prenom;nom;moyenne
     */
    public void lireEtudiants() {
        String ligne;

        etudiants = new ArrayList<>();

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(pathIn));
            // On lit la première ligne (en-têtes de colonnes)
            ligne = fichier.readLine();

            // On commence la lecture des lignes contenant des étudiants
            ligne = fichier.readLine();
            // Lecture des lignes contenant des étudiants
            while (ligne != null) {
                // TODO: Utiliser la méthode split de String pour séparer les mots d'une ligne

                // TODO: Créer un Etudiant avec les attributs identifiés dans la ligne

                // TODO: Ajouter l'étudiant au ArrayList etudiants

                // On lit la prochaine ligne
                ligne = fichier.readLine();
            }

            fichier.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e);
        }
    }

    /**
     * Écrit la liste des étudiants dans un fichier CSV.
     * Format d'écriture : matricule;prenom;nom;moyenne
     */
    public void ecrireEtudiants() {
        try {
            PrintWriter fichier = new PrintWriter(new FileWriter(pathOut));

            for (Etudiant etudiant : etudiants) {
                fichier.print(etudiant.getMatricule());
                fichier.print(";");
                fichier.print(etudiant.getPrenom());
                // TODO: Ajouter le nom et la moyenne de chaque étudiant au fichier de sortie
            }

            fichier.flush();
            fichier.close();
        } catch (IOException e) {
            System.out.println("Écriture du fichier impossible : " + e);
        }
    }

    /**
     * Augmente la moyenne de chaque étudiant d'une valeur donnée, sans dépasser 100 ni descendre en dessous de 0.
     *
     * @param noteAAjouter Nombre de points à ajouter à la moyenne de chaque étudiant.
     */
    public void bonifierNotes(int noteAAjouter) {
        // TODO: Itérer sur tous les étudiants pour modifier leur moyenne et valider la nouvelle moyenne (0-100)
    }

    /**
     * Trie la liste des étudiants selon l'ordre naturel défini dans la classe {@code Etudiant}.
     * Assure que la classe {@code Etudiant} implémente {@code Comparable<Etudiant>}.
     */
    public void trier() {
        etudiants.sort(null); // Utilise compareTo() par défaut
    }

    /**
     * Retourne une représentation textuelle de la liste des étudiants.
     *
     * @return Chaîne de caractères contenant les étudiants ligne par ligne.
     */
    @Override
    public String toString() {
        StringBuilder retour = new StringBuilder();
        for (Etudiant etudiant : etudiants) {
            retour.append(etudiant.toString()).append("\n");
        }
        return retour.toString();
    }
}
