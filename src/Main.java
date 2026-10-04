import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupery", 96);
    Livre livre2 = new Livre("1984", "George Orwell", 328);
    Livre livre3 = new Livre("To Kill a Mockingbird", "Harper Lee", 481);
    Livre livre4 = new Livre("Henry Potter", "Arafan", 481);
    Livre doublon = new Livre(" 1984 ", "George Orwell", 328);
    Livre doublonMajuscules = new Livre("LE PETIT PRINCE", "Antoine de Saint-Exupery", 96);

    ArrayList<Livre> livresSource = new ArrayList<>();
    livresSource.add(livre1);
    livresSource.add(livre2);
    livresSource.add(livre3);

    Bibliotheque bibliotheque = new Bibliotheque(livresSource);
    livresSource.clear();
    System.out.println("Copie defensive, livres conserves apres vidage de la liste source : "
        + bibliotheque.getNombreLivres());

    System.out.println("Recherche de 1984 : " + bibliotheque.rechercherUnTitre("1984"));
    System.out.println("Recherche d'Avatar : " + bibliotheque.rechercherUnTitre("Avatar"));
    System.out.println("Recherche avec titre null : " + bibliotheque.rechercherUnTitre(null));
    System.out.println("Recherche avec titre vide : " + bibliotheque.rechercherUnTitre(""));
    System.out.println("Recherche avec espaces : " + bibliotheque.rechercherUnTitre("   "));

    System.out.println("Nombre de livres longs : " + bibliotheque.compterLivreLong());
    Livre plusLong = bibliotheque.trouverLivreLePlusLong();
    System.out.println(plusLong == null
        ? "La bibliotheque est vide"
        : "Le livre le plus long est : " + plusLong.getTitre());

    System.out.println("Ajout d'un nouveau titre : " + bibliotheque.ajouterLivre(livre4));
    System.out.println("Ajout d'un doublon avec espaces : " + bibliotheque.ajouterLivre(doublon));
    System.out.println("Ajout d'un doublon avec casse differente : "
        + bibliotheque.ajouterLivre(doublonMajuscules));
    System.out.println("Ajout avec titre null : "
        + bibliotheque.ajouterLivre(new Livre(null, "Auteur", 100)));
    System.out.println("Ajout avec titre vide : "
        + bibliotheque.ajouterLivre(new Livre("", "Auteur", 100)));
    System.out.println("Ajout avec titre blanc : "
        + bibliotheque.ajouterLivre(new Livre("   ", "Auteur", 100)));
    System.out.println("Ajout d'un objet Livre null : " + bibliotheque.ajouterLivre(null));
    System.out.println("Nombre de livres apres tests d'ajout : " + bibliotheque.getNombreLivres());

    System.out.println("\nLivres dans la bibliotheque :");
    bibliotheque.afficher();

    System.out.println("\nSuppression de 1984 : " + bibliotheque.supprimerLivre("1984"));
    System.out.println("Suppression d'Avatar : " + bibliotheque.supprimerLivre("Avatar"));
    System.out.println("Suppression avec titre null : " + bibliotheque.supprimerLivre(null));
    System.out.println("Suppression avec titre vide : " + bibliotheque.supprimerLivre(""));
    System.out.println("Suppression avec espaces : " + bibliotheque.supprimerLivre("   "));
    System.out.println("Nombre de livres apres tests de suppression : "
        + bibliotheque.getNombreLivres());

    Bibliotheque bibliothequeVide = new Bibliotheque(new ArrayList<>());
    Livre plusLongBibliothequeVide = bibliothequeVide.trouverLivreLePlusLong();
    System.out.println(plusLongBibliothequeVide == null
        ? "La bibliotheque vide ne contient aucun livre"
        : plusLongBibliothequeVide.getTitre());
  }
}
