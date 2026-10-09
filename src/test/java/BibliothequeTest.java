import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BibliothequeTest {
   // ...existing code...
    @Test
    void refuserLivreNull() {
        Bibliotheque bibliotheque = new Bibliotheque(new ArrayList<>());

        boolean resultat = bibliotheque.ajouterLivre(null);

        assertFalse(resultat);
        assertEquals(0, bibliotheque.getNombreLivres());
    }
// ...existing code...
    @Test
      void ajouterLivreValid(){
        Bibliotheque bibliotheque = new Bibliotheque(new ArrayList<>());
        Livre livre1 = new Livre("1984", "George Orwell", 328);
        boolean result = bibliotheque.ajouterLivre(livre1);
         assertTrue(result);
         assertEquals(1, bibliotheque.getNombreLivres());


      } 
      
      @Test
    void refuserTitreEnDoublon() {
        Bibliotheque bibliotheque = new Bibliotheque(new ArrayList<>());
        Livre livre = new Livre("1984", "George Orwell", 328);

         boolean premierAjout = bibliotheque.ajouterLivre(livre);
        assertTrue(premierAjout);

        boolean resultat = bibliotheque.ajouterLivre(
                new Livre(" 1984 ", "George Orwell", 328));

        assertFalse(resultat);
        assertEquals(1, bibliotheque.getNombreLivres());
    }

    
    @Test
    void retournerNullPourBibliothequeVide(){
        ArrayList<Livre> livresVide = new ArrayList<>();
        Bibliotheque bibliotheque = new Bibliotheque(livresVide);
        
        assertNull(bibliotheque.trouverLivreLePlusLong());


    }
    @Test 
    void retournerLivreAvecLePlusDePages(){
        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(new Livre("1984", "George Orwell", 96));
        livres.add(new Livre("Seigneur des anneaux", "peter", 481));
        livres.add(new Livre("Henry potter", "mbemba", 328));
        Bibliotheque bibliotheque = new Bibliotheque(livres);
        assertEquals(481, bibliotheque.trouverLivreLePlusLong().getNombrePages());

    }
     @Test
    void supprimerLivreExistant() {
        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(new Livre("1984", "George Orwell", 328));
        Bibliotheque bibliotheque = new Bibliotheque(livres);

        boolean resultat = bibliotheque.supprimerLivre("1984");

        assertTrue(resultat);
        assertEquals(0, bibliotheque.getNombreLivres());
        assertFalse(bibliotheque.rechercherUnTitre("1984"));
    }

    
    @Test
    void nePasModifierBibliothequeSiLivreAbsent() {
        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(new Livre("1984", "George Orwell", 328));
        Bibliotheque bibliotheque = new Bibliotheque(livres);

        boolean resultat = bibliotheque.supprimerLivre("Avatar");

        assertFalse(resultat);
        assertEquals(1, bibliotheque.getNombreLivres());
        assertTrue(bibliotheque.rechercherUnTitre("1984"));
    }

  

       @Test
    void conserverLivresApresVidageListeSource() {
        ArrayList<Livre> livresSource = new ArrayList<>();
        Livre livre = new Livre("1984", "George Orwell", 328);
        livresSource.add(livre);

        Bibliotheque bibliotheque = new Bibliotheque(livresSource);
        livresSource.clear();

        assertEquals(1, bibliotheque.getNombreLivres());
        assertTrue(bibliotheque.rechercherUnTitre("1984"));
    }

    @Test
    void rechercherUniquementLivresLongs() {
        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(new Livre("Livre court", "Auteur 1", 96));
        livres.add(new Livre("Livre moyen", "Auteur 2", 328));
        livres.add(new Livre("Livre long", "Auteur 3", 481));

        Bibliotheque bibliotheque = new Bibliotheque(livres);
        List<Livre> livresLongs = bibliotheque.rechercherParCategorie("long");

        assertEquals(2, livresLongs.size());

        for (Livre livre : livresLongs) {
            assertTrue(livre.estLong());
            
        }
    }

    @Test 
    void retournerListeVidePourCategorieInconnue(){
        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(new Livre("Livre court", "Auteur 1", 96));
        Bibliotheque bibliotheque = new Bibliotheque(livres);
        List<Livre> livresInconnue = bibliotheque.rechercherParCategorie("inconnue");
        assertTrue(livresInconnue.isEmpty());

    }

}
