import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96);
    Livre livre2 = new Livre("1984", "George Orwell", 328);
    Livre livre3 = new Livre("To Kill a Mockingbird", "Harper Lee", 481);
    Livre livre4 = new Livre("Henry Potter", "Arafan", 481);
    Livre livre5 = new Livre(" 1984 ", "George Orwell", 328);
    Livre livre6 = new Livre("Le PEtit PriNce", "Antoine de Saint-Exupéry", 96);
 
    ArrayList<Livre> livres = new ArrayList<>();
    
    livres.add(livre1);
    livres.add(livre2);
    livres.add(livre3);
    Bibliotheque bibl = new Bibliotheque(livres);
    livres.clear();
    System.out.println("Le nombre de livres apres creation de la bibliotheque est : "+ bibl.getNombreLivres());
    ArrayList<Livre> emptyBooks = new ArrayList<>();
Bibliotheque vide = new Bibliotheque(emptyBooks);

    // System.out.println("Titre: " + livre1.getTitre() + ", Auteur: " + livre1.getAuteur() + ", Nombre de pages: " + livre1.getNombrePages());
    // System.out.println("Titre: " + livre2.getTitre() + ", Auteur: " + livre2.getAuteur() + ", Nombre de pages: " + livre2.getNombrePages());
    // System.out.println("Titre: " + livre3.getTitre() + ", Auteur: " + livre3.getAuteur() + ", Nombre de pages: " + livre3.getNombrePages());
    // System.out.println("Le livre '" + livre1.getTitre() + "' est-il long? " + livre1.estLong());
    // System.out.println("Le livre '" + livre2.getTitre() + "' est-il long? " + livre2.estLong());
    // System.out.println("Le livre '" + livre3.getTitre() + "' est-il long? " + livre3.estLong());
    // System.out.println("Categorie: " + livre1.getTitre() +", "+ livre1.getCategorie());
    // System.out.println("Categorie: " + livre2.getTitre() +", "+ livre2.getCategorie());
    // System.out.println("Categorie: " + livre3.getTitre() +", "+ livre3.getCategorie());

    // System.out.println("Le livre :" + livre1.getTitre() + " a plus  de pages que " + "Le livre :"+ livre2.getTitre() +", "+ livre1.estPlusLongQue(livre2) );
    // System.out.println("Le livre :" + livre2.getTitre() + " a plus  de pages que " + "Le livre : "+ livre3.getTitre() +", "+ livre2.estPlusLongQue(livre3) );
    // System.out.println();
    bibl.afficher();
    System.out.println("1984"+" Est présent dans bibliotheque ?: " + bibl.rechercherUnTitre("1984"));
    System.out.println("Avatar"+" Est présent dans bibliotheque ?: " + bibl.rechercherUnTitre("Avatar"));
    System.out.println("Recherche avec null ?: " + bibl.rechercherUnTitre(null));
    System.out.println("Recherche avec une chaîne vide ?: " + bibl.rechercherUnTitre(""));
    System.out.println("Recherche avec des espaces ?: " + bibl.rechercherUnTitre("   "));
    System.out.println("Le nombre de livre long dans Bibliotheque est : " + bibl.compterLivreLong());
    Livre plusLong = bibl.trouverLivreLePlusLong();
    System.out.println( plusLong== null? "La Bibliotheque est vide" : "Le livre le plus long est : "+ plusLong.getTitre() );
    if(bibl.ajouterLivre(livre4)){
      System.out.println("Le livre "+ livre4.getTitre() + " est bien ajoute");
    }else{
      System.out.println("Echec, Ajout impossible : le livre "+ livre4.getTitre() + " existe deja");

    }
    if(bibl.ajouterLivre(livre5)){
      System.out.println("Le "+ livre5.getTitre() + " est bien ajoute");
    }else{
      System.out.println("Echec, Ajout impossible : le livre "+ livre2.getTitre() +" existe deja");

    }
    if(bibl.ajouterLivre(livre6)){
      System.out.println("Le "+ livre5.getTitre() + " est bien ajoute");
    }else{
      System.out.println("Echec, Ajout impossible : le livre "+ livre5.getTitre() +" existe deja");

    }
    System.out.println("Ajout d'un livre avec titre null : " + bibl.ajouterLivre(new Livre(null, "Auteur", 100)));
    System.out.println("Ajout d'un livre avec titre vide : " + bibl.ajouterLivre(new Livre("", "Auteur", 100)));
    System.out.println("Ajout d'un livre avec titre blanc : " + bibl.ajouterLivre(new Livre("   ", "Auteur", 100)));
    if (bibl.ajouterLivre(null)) {
      System.out.println("Le livre null a ete ajoute");
    } else {
      System.out.println("Ajout impossible : le livre est null");
    }
        System.out.println("Le nombre de livres apres ajout dans la bibliotheque est : "+ bibl.getNombreLivres());

    Livre plusLong2 = vide.trouverLivreLePlusLong();
    System.out.println( plusLong2== null? "La Bibliotheque vide est vide" : plusLong2.getTitre() );
    
    
    System.out.println("La nouvelle liste de la Bibliotheque: " );

    bibl.afficherTitre();

    if(bibl.supprimerLivre("1984")){
      System.out.println("Le livre  \"1984\"  a ete supprimer");
    }else {
       System.out.println("Le livre introuvable");
    }
        System.out.println("Le nomnbre de livres apres suppression dans la bibliotheque est : "+ bibl.getNombreLivres());

    if(bibl.supprimerLivre("Avatar")){
      System.out.println("Le livre a ete supprimer");
    }else {
       System.out.println("Le livre \"Avatar\" introuvable");
    }
   if (bibl.supprimerLivre(null)) {
    System.out.println("Livre supprimé");
} else {
    System.out.println("Suppression impossible : titre null");
}

if (bibl.supprimerLivre("")) {
    System.out.println("Livre supprimé");
} else {
    System.out.println("Suppression impossible : titre vide");
}

if (bibl.supprimerLivre("  ")) {
    System.out.println("Livre supprimé");
} else {
    System.out.println("Suppression impossible : titre composé d'espace");
}
        System.out.println("Le nomnbre de livres apres suppression dans la bibliotheque es : "+ bibl.getNombreLivres());

  }
}
