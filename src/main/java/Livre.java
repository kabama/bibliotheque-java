
public class Livre {
  private String titre;
  private String auteur;
  private int nombrePages;


  public Livre(String titre, String auteur, int nombrePages) {
    this.titre = titre;
    this.auteur = auteur;
    this.nombrePages = nombrePages;
  }
  
  public String getTitre() {
    return titre;
  }
  public String getAuteur() {
    return auteur;
  }
  public int getNombrePages() {
    return nombrePages;
  }

  public boolean  estLong() {
    return nombrePages >= 300;
  }
  public String getCategorie(){
    if (nombrePages <  100){
      return "court";

    }
     if ((nombrePages >= 100) && (nombrePages < 300)){
      return "moyen";
      
    }

     return "long";
  }

  public boolean  estPlusLongQue(Livre autreLivre){
   
     return nombrePages > autreLivre.getNombrePages();

  }
}
