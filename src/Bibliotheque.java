
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
  private List<Livre> tab;

  public Bibliotheque(List<Livre> livres) {
    ArrayList<Livre> livreTemp = new ArrayList<>();
    for(Livre livre : livres){
      livreTemp.add(livre);
    }
    this.tab = livreTemp;
  }

  public void afficher() {
    for (int i = 0; i < tab.size(); i++) {
      System.out.println("Titre : " + tab.get(i).getTitre());
      System.out.println("Categorie : " + tab.get(i).getCategorie());
      System.out.println();
    }
  }

  public boolean rechercherUnTitre(String titre) {
    if (!estTitreValide(titre)) {
      return false;
    }
    for (int i = 0; i < tab.size(); i++) {
      if (tab.get(i).getTitre().equalsIgnoreCase(titre.trim())) {
        return true;
      }
    }
    return false;
  }

  public int compterLivreLong(){
    int count =0;
     for(int i= 0; i < tab.size(); i++){
      if(tab.get(i).estLong()){
        count +=1;
      }
     }
    return count;
  }

  public Livre  trouverLivreLePlusLong(){
    int index =0 ;
    if(tab.isEmpty()){
        return null;
    }
    int max =tab.get(0).getNombrePages();
    for(int i= 1; i < tab.size(); i++){
      if (max < tab.get(i).getNombrePages()){
        max = tab.get(i).getNombrePages();
        index = i;
      }
    }
    return tab.get(index) ;
  }

  public boolean ajouterLivre(Livre nouveauLivre){
    if(nouveauLivre == null){
      return false;
    }
    if(!estTitreValide(nouveauLivre.getTitre())){
      return false;
    }
    if(rechercherUnTitre(nouveauLivre.getTitre())){
        return  false;
    }else{  
      tab.add(nouveauLivre);
      return true;
    }
  }
  //Affiche chaque titre de chaque  Livre
  public void afficherTitre(){
    for(Livre liv :tab){
      System.out.println("Titre : "+liv.getTitre());
    }
  }
  public boolean supprimerLivre(String titre){
    if(!estTitreValide(titre)){
      return false;
    }
    for(int i = 0; i < tab.size(); i++){
      if(tab.get(i).getTitre().equalsIgnoreCase(titre.trim())){
        tab.remove(i);
        return true;
      }
    }

    return false;

  }

  public  int getNombreLivres(){
    return tab.size();

  }

  private boolean estTitreValide(String titre){
    
  if( titre==null || titre.isBlank()){
    return false;
  }
  return true;
  }
}

