import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/*
Class qui permet la gestion des emprunts et de faire la jonction entre l'Emprunteur et la Mediatheque
*/
public class Emprunt {
    //Variables
    Mediatheque mediatheque = Mediatheque.uniqueInstance;
    //idEmprunt unique
    private static int idIncrement = 0;
    private int idEmprunt;
    //true: pas en retard; false: en retard
    private boolean etatEmprunt;
    private Emprunteur emprunteur;
    private Media media;
    
    private Date dateEmprunt;
    private Date dateLimitEmprunt;
    
    HashMap<Emprunteur, Media> listEmprunt = new HashMap<>();
    //////////////////////////////////////////////
    
    //Constructeurs
    public Emprunt() {     
    }
    public Emprunt(Emprunteur emprunteur, Media media) { 
        this.idEmprunt = Emprunt.idIncrement++;
        this.emprunteur = emprunteur;
        this.media = media;
        this.etatEmprunt = true;
        //instanciation de date d'emprunt et de remise avant retard
        this.dateEmprunt = new Date();
        this.dateLimitEmprunt = this.setDateLimite(dateEmprunt);
          
        System.out.println("Je crée un emprunt");
        this.listEmprunt.put(emprunteur, media);
    }
    //////////////////////////////////////////////
    
    //Getter and Setter
    private Date setDateLimite(Date date) {
        int nombreJoursLimite = 21; //3 semaines
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);            
        calendar.add(Calendar.DAY_OF_YEAR, nombreJoursLimite);
        Date dateLimite = calendar.getTime();
        
        return dateLimite;
    }
    public void setEtat(Boolean value) {
        this.etatEmprunt = value;
    }
    public Emprunteur getEmprunteur() {
        return this.emprunteur;
    }
    public Media getMedia() {
        return this.media;
    }
    public Date getDate() {
        return this.dateEmprunt;
    }
    public Date getDateLimite() {
        return this.dateLimitEmprunt;
    }
    public boolean getEtat() {
        return this.etatEmprunt;
    }
    public String getInformation() {
        return this.emprunteur.getNomPrenomEmprunteur()+
                " "+this.media.descriptionMedia()+
                " Date de l'emprunt: "+this.dateEmprunt+" Date limite: "+this.dateLimitEmprunt;
    }
    
}

