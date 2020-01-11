/*
Livre est un Media (héritage)
*/
public class Livre extends Media {
    //Variables
    private final int nombrePageLivre;
    private final String auteurLivre;
    //////////////////////////////////////////////
    
    //Constructeurs
    public Livre() {
        super();    
        this.nombrePageLivre = 0;
        this.auteurLivre = "";
    }
    public Livre(String ISBNLivre, String auteurLivre, String nomLivre, String genreLivre, 
            String maisonProductionLivre, int nombrePageLivre, int nombreExemplaireLivre) {
        
        super(ISBNLivre, nomLivre, genreLivre, maisonProductionLivre, nombreExemplaireLivre);
        
        this.nombrePageLivre = nombrePageLivre;
        this.auteurLivre = auteurLivre;
    }
    //////////////////////////////////////////////
    
    //Getters and setters
    public int getNombrePage() {
        return this.nombrePageLivre;
    }
   
}
