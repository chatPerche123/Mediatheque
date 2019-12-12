import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Emprunt {
    Mediatheque mediatheque = Mediatheque.uniqueInstance;
    //idEmprunt unique
    private static int idIncrement = 0;
    private int idEmprunt;
    private Emprunteur emprunteur;
    private Media media;
    
    private Date dateEmprunt;
    private Date dateLimitEmprunt;
    
    HashMap<Emprunteur, Media> listEmprunt = new HashMap<>();
    
    public Emprunt() {     
    }
    public Emprunt(Emprunteur emprunteur, Media media) { 
        this.idEmprunt = Emprunt.idIncrement++;
        this.emprunteur = emprunteur;
        this.media = media;
        
        //instanciation de date d'emprunt et de remise avant retard
        this.dateEmprunt = new Date();
        this.dateLimitEmprunt = this.setDateLimite(dateEmprunt);
        
        //System.out.println("Date actuelle: "+this.dateEmprunt);
        //System.out.println("Date limite: "+this.dateLimitEmprunt);
        
        System.out.println("Je crée un emprunt");
        this.listEmprunt.put(emprunteur, media);
        //mediatheque.listEmprunt.put(emprunteur, media);
    }

    private Date setDateLimite(Date date) {
        int nombreJoursLimite = 21; //3 semaines
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);            
        calendar.add(Calendar.DAY_OF_YEAR, nombreJoursLimite);
        Date dateLimite = calendar.getTime();
        
        return dateLimite;
    }
    
    public Emprunteur getEmprunteur() {
        return this.emprunteur;
    }
    public Media getMedia() {
        return this.media;
    }
    
    public String getInformation() {
        return this.emprunteur.getNomPrenomEmprunteur()+" "+this.media.descriptionMedia();
    }
}

