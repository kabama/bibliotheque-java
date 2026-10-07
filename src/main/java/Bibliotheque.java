
import java.util.ArrayList;
import java.util.List;

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

  public int compterLivreLong() {
    int count = 0;
    for (Livre livre : tab) {
      if (livre.estLong()) {
        count++;
      }
    }
    return count;
  }

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

  public int getNombreLivres() {
    return tab.size();
  }

  private boolean estTexteValide(String texte) {
    return texte != null && !texte.isBlank();
  }

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
