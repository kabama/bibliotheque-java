import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
  
}
