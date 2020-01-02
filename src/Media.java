
import java.util.Map;


public class Media<A> implements AfficherInformation{
    //Variables
        //Un identifiant unique dont le format diffère selon le type
    protected A idMedia;
    //Etat du média (dispo ou non)
    protected boolean Etat;
    
    protected String titreMedia;
    protected String genreMedia;
    protected String maisonProductionMedia; 
    protected int nombreExemplaire;
    //////////////////////////////////////////////
    
    //Constructeurs
    public Media() {     
        this.titreMedia = "";
        this.genreMedia = "";
        this.maisonProductionMedia = "";
    }
    public Media(A idMedia, String titreMedia, String genreMedia, String maisonProductionMedia, int nombreExemplaire) {
        this.idMedia = idMedia;
        this.titreMedia = titreMedia;
        this.genreMedia = genreMedia;
        this.maisonProductionMedia = maisonProductionMedia;
        this.nombreExemplaire = nombreExemplaire;
    }
    //////////////////////////////////////////////
    
    //Getters and setters
    protected A getIdMedia() {
        return this.idMedia;
    }
    protected String getTitreMedia() {
        return this.titreMedia;
    }
    protected String getGenreMedia() {
        return this.genreMedia;
    }
    protected String getMaisonProductionMedia() {
        return this.maisonProductionMedia;
    }
    protected int getNombreExemplaire() {
        return this.nombreExemplaire;
    }
    protected void setNombreExemplaire(boolean value) {
        if(value) {
            this.nombreExemplaire++;
        
        }else {
            this.nombreExemplaire--;
        }
    } 
    //////////////////////////////////////////////
    
    @Override
    public String descriptionMedia() {
        return this.getIdMedia()+" "+this.getTitreMedia()+" "+this.genreMedia+" "+this.getMaisonProductionMedia();
    }
    @Override
    public int nombreMedia() {
        return this.getNombreExemplaire();
    }
    
    /*
    protected void prochaineDispo(String nomMedia) {
        Emprunt emprunt = new Emprunt();
        
	for(Map.Entry<Emprunteur, Media> entry : emprunt.listEmprunt.entrySet()) {
		Emprunteur emprunteur = entry.getKey();
		Media media = entry.getValue();
                
                if(media.getTitreMedia().equals(nomMedia)) {
                    if(media.getNombreExemplaire() > 0) {
                        System.out.println("Le média est disponile");
                    
                    }else {
                        
                    }
                }
                EmprunterObserver o = (EmprunterObserver)emprunteur;
                
                o.update(media.getTitreMedia());
		//System.out.println("Key: " + emprunteur.getNomEmprunteur() + ", Value: " + media.getTitreMedia());
	}        
    }
    */
}
