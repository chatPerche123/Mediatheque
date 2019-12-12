
import java.util.Date;



public class Media<A> implements AfficherInformation{
    //Un identifiant unique dont le format diffère selon le type
    protected A idMedia;
    //Etat du média (dispo ou non)
    protected boolean Etat;
    
    protected String titreMedia;
    protected String genreMedia;
    protected String maisonProductionMedia; 
    protected int nombreExemplaire;
    
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

    @Override
    public String descriptionMedia() {
        return this.getIdMedia()+" "+this.getTitreMedia()+" "+this.genreMedia+" "+this.getMaisonProductionMedia();
    }
    @Override
    public int nombreMedia() {
        return this.getNombreExemplaire();
    }
    /*
    Date prochaineDispo() {
        
    }
    */

}
