
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Mediatheque implements MediathequeSubject{
    //Singleton
    public static Mediatheque uniqueInstance;
    private String nomMediatheque;
    private String adresseMediatheque;
    private String telMediatheque;
    
    ArrayList<Emprunt> empruntArrayList = new ArrayList<>();

    
    HashMap<Emprunteur, Media> listEmprunt;
    List<Media> listMedia;
    List<Emprunteur> listEmprunteur;
    
    private Mediatheque(){
    }
    private Mediatheque(String nomMediatheque, String adresseMediatheque, String telMediatheque){
        System.out.println("Création de la médiathèque");
        
        this.nomMediatheque = nomMediatheque;
        this.adresseMediatheque = adresseMediatheque;
        this.telMediatheque = telMediatheque;
        
        //Instancie nos liste à blanc
        this.listMedia = new ArrayList<>();
        this.listEmprunteur = new ArrayList<>();
        this.listEmprunt = new HashMap<>(); 
    }
    //Instancie une classe unique
    public static Mediatheque getInstance(String nomMediatheque, String adresseMediatheque, String telMediatheque) {
        if(uniqueInstance == null) {
            System.out.println("Unique instance created");
            uniqueInstance = new Mediatheque(nomMediatheque, adresseMediatheque, telMediatheque);
        
        }else {
            System.out.println("Instance already exist");
        }
        
        return uniqueInstance;
    }
    
    
    public void ajouterEmprunt(Emprunteur e, Media m) {
        Emprunt emprunt = new Emprunt(e, m);
        this.empruntArrayList.add(emprunt);
    }
    public void supprimerEmprunt(Emprunteur emprunter, Media media) {
        
        Iterator<Emprunt> it = this.empruntArrayList.iterator();
        while(it.hasNext()) {
            Emprunt emprunt = it.next();
            if(emprunt.getEmprunteur().getIdEmprunteur() == emprunter.getIdEmprunteur()) {
                if(emprunt.getMedia().getIdMedia() == media.getIdMedia()) {
                    it.remove();
                    
                }
            }
        }
    }
    
    @Override
    public void ajouterEmprunteur(Object o) {
        if(!this.listEmprunteur.contains((Emprunteur)o)) { 
            System.out.println("Ajout du nouvelle emprunteur "+((Emprunteur)o).getNomPrenomEmprunteur()+" à la liste");
            this.listEmprunteur.add((Emprunteur)o);
        
        }else {
            System.out.println("Emprunteur "+((Emprunteur)o).getNomPrenomEmprunteur()+" existait déjà dans la liste");
        }
    }
    @Override
    public void supprimerEmprunteur(Emprunteur o) {
       if(o.getNbMediaEmprunter() == 0) {
           System.out.println("0 emprunt, suppression de "+o.getNomPrenomEmprunteur()+" de la liste");
           //suppression d'emprunteur de la liste des emprunteurs
           this.listEmprunteur.remove(o);        
       }
    }
    @Override
    public void informerRetardEmprunteur() {
    }
    @Override
    public void ajouterNouveauMedia(Object o) {
        if(!this.listMedia.contains((Media)o)) {
            System.out.println("Ajout d'un nouveau média:\n"+((Media)o).descriptionMedia());
            this.listMedia.add((Media)o);
        
        }else {
            System.out.println("Le média ne sera pas rajouté, il existe déjà");
        }
        
    }
    @Override
    public void rendreMedia(Object o) {
        this.listMedia.add((Media)o);
        ((Media)o).setNombreExemplaire(true);
    }
    @Override
    //réduit le nombre d'exemplaire disponible
    public void retirerExemplaireMedia(Object o) {
        ((Media)o).setNombreExemplaire(false);
    }
    @Override
    public boolean mediaDisponile(Object o) {
        //Si le média est disponible
        if(((Media)o).getNombreExemplaire() == 0) {
            ((Media)o).Etat = false;
            return false;
        }
        //si le média existe dans la liste
        return this.listMedia.contains((Media)o);
    }
    
    
    protected void getListMedia(){
        System.out.println("La liste des médias de la médiathèque: ");
        for(Media item : this.listMedia) {
            System.out.println(item.descriptionMedia());
        }
    }
    /*
    protected void getListEmprunt() {
        System.out.println("Liste des emprunteurs et des médias emprunter: ");
        for(Emprunteur emprunteur : this.listEmprunt.keySet()) {
            for(Media media : this.listEmprunt.values()) {
                System.out.println(emprunteur.getNomPrenomEmprunteur()+" "+media.descriptionMedia());
            }
        }
    }
    */
    protected void getListEmprunt() {
        System.out.println("La liste des emprunts de la médiathèque: ");
        for(Emprunt item : this.empruntArrayList) {
            System.out.println( item.getInformation());
        }  
    }
    protected void getListEmprunteur(){
        System.out.println("La liste des emprunteurs de la médiathèque: ");
        for(Emprunteur item : this.listEmprunteur) {
            System.out.println(item.getNomPrenomEmprunteur());
        }
    } 

}
