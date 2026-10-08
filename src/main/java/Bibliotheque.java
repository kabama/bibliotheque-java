
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une bibliothèque de livres.
 *
 * Cette classe gère la liste des livres et les opérations de recherche,
 * d'ajout, de suppression et de calcul.
 */

public class Bibliotheque {
  
  private final List<Livre> tab;

  public Bibliotheque(List<Livre> livres) {
    this.tab = new ArrayList<>(livres);
  }

  public void afficher() {
    for (Livre livre : tab) {
      System.out.println("Titre : " + livre.getTitre());
      System.out.println("Categorie : " + livre.getCategorie());
      System.out.println();
    }
  }
  
    /**
     * Recherche un livre par titre, sans tenir compte de la casse.
     *
     * @param titre Le titre à rechercher
     * @return true si le livre existe, sinon false
     */

  public boolean rechercherUnTitre(String titre) {
    if (!estTexteValide(titre)) {
      return false;
    }
    for (Livre livre : tab) {
      if (livre.getTitre().equalsIgnoreCase(titre.trim())) {
        return true;
      }
    }
    return false;
  }

  /**
     * Compte les livres ayant un nombre de pages supérieur à 300.
     *
     * @return Le nombre de livres longs
     */

  public int compterLivreLong() {
    int count = 0;
    for (Livre livre : tab) {
      if (livre.estLong()) {
        count++;
      }
    }
    return count;
  }


/**
     * Recherche le livre avec le plus de pages.
     *
     * @return Le livre le plus long, ou null si la bibliothèque est vide
     */

  public Livre trouverLivreLePlusLong() {
    if (tab.isEmpty()) {
      return null;
    }

    Livre plusLong = tab.get(0);
    for (int i = 1; i < tab.size(); i++) {
      if (tab.get(i).getNombrePages() > plusLong.getNombrePages()) {
        plusLong = tab.get(i);
      }
    }
    return plusLong;
  }

   /**
     * Ajoute un livre à la bibliothèque si le titre est valide
     * et que le livre n'existe pas déjà.
     *
     * @param nouveauLivre Le livre à ajouter
     * @return true si le livre a été ajouté, sinon false
     */

  public boolean ajouterLivre(Livre nouveauLivre) {
    if (nouveauLivre == null || !estTexteValide(nouveauLivre.getTitre())) {
      return false;
    }
    if (rechercherUnTitre(nouveauLivre.getTitre())) {
      return false;
    }
    tab.add(nouveauLivre);
    return true;
  }

  /**
     * Supprime un livre à partir de son titre.
     *
     * La recherche ignore la casse et les espaces en début et en fin.
     *
     * @param titre Le titre du livre à supprimer
     * @return true si le livre a été supprimé, sinon false
     */

  public boolean supprimerLivre(String titre) {
    if (!estTexteValide(titre)) {
      return false;
    }
    for (int i = 0; i < tab.size(); i++) {
      if (tab.get(i).getTitre().equalsIgnoreCase(titre.trim())) {
        tab.remove(i);
        return true;
      }
    }
    return false;
  }

   /**
     * Retourne le nombre de livres contenus dans la bibliothèque.
     *
     * @return Le nombre de livres
     */

  public int getNombreLivres() {
    return tab.size();
  }

   /**
 * Vérifie que le texte n'est ni null, ni vide,
 * ni composé uniquement de caractères blancs.
 *
 * @param texte Le texte à vérifier
 * @return true si le texte est valide, sinon false
 */

  private boolean estTexteValide(String texte) {
    return texte != null && !texte.isBlank();
  }

  /**
     * Recherche tous les livres appartenant à une catégorie.
     *
     * La recherche ignore la casse et les espaces en début et en fin.
     *
     * @param categorie La catégorie à rechercher
     * @return La liste des livres correspondant à la catégorie
     */

  public List<Livre> rechercherParCategorie(String categorie) {
    List<Livre> livresParCategorie = new ArrayList<>();
    if (!estTexteValide(categorie)) {
      return livresParCategorie;
    }
    for (Livre livre : tab) {
      if (livre.getCategorie().equalsIgnoreCase(categorie.trim())) {
        livresParCategorie.add(livre);
      }
    }
    return livresParCategorie;
  }
}
