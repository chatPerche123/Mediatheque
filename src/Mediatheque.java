

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*
La classe Mediatheque est unique (Singleton) et a pour rôle de gérer les Emprunts(class) des Emprunteur(Class).
Il est possible de gérer des Medias(class) et d'informer les Emprunteurs sous certains critères.
*/
public class Mediatheque {
    //Variables
        //Singleton
    public static Mediatheque uniqueInstance;
    private String nomMediatheque;
    private String adresseMediatheque;
    private String telMediatheque;
    
    ArrayList<Emprunt> empruntArrayList = new ArrayList<>();
    HashMap<Emprunteur, Media> emprunteurEnRetard = new HashMap<>();
    
    HashMap<Emprunteur, Media> listEmprunt;
    List<Media> listMedia;
    List<Emprunteur> listEmprunteur;
    
    
    
    //////////////////////////////////////////////
    
    //Constructeurs
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
    //////////////////////////////////////////////
    
    //Methodes
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
    protected void miseAjoursEtat() {
        //Date date = new Date();
        
        //Permet de tester avec une date > 0 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());    
        calendar.add(Calendar.DAY_OF_YEAR, 21); // > 0
        //calendar.add(Calendar.DAY_OF_YEAR, 20); < 0
        //calendar.add(Calendar.DAY_OF_YEAR, 21); == 0
        Date date = calendar.getTime();    
          
        for(Emprunt emprunt : empruntArrayList) {
            //si date = dateLimit ou date > dateLimite
            if( (date.compareTo(emprunt.getDateLimite()) == 0) || (date.compareTo(emprunt.getDateLimite()) > 0) ) {
                emprunt.setEtat(false);
                this.emprunteurEnRetard.put(emprunt.getEmprunteur(), emprunt.getMedia());   
                //System.out.println(emprunt.getEmprunteur().getNomPrenomEmprunteur()+" : "+emprunt.getMedia().titreMedia);
            }
        }
    }
    //////////////////////////////////////////////
    
    
    public void ajouterEmprunteur(Object o) {
        if(!this.listEmprunteur.contains((Emprunteur)o)) { 
            System.out.println("Ajout du nouvelle emprunteur "+((Emprunteur)o).getNomPrenomEmprunteur()+" à la liste");
            //ajout emprunteur à la liste
            this.listEmprunteur.add((Emprunteur)o);
        }else {
            System.out.println("Emprunteur "+((Emprunteur)o).getNomPrenomEmprunteur()+" existait déjà dans la liste");
        }
    }
    
    public void supprimerEmprunteur(Emprunteur o) {
       if(o.getNbMediaEmprunter() == 0) {
           System.out.println("0 emprunt, suppression de "+o.getNomPrenomEmprunteur()+" de la liste");
           //suppression d'emprunteur de la liste des emprunteurs
           this.listEmprunteur.remove(o);        
       }else {
           System.out.println("Il lui reste 1 ou plusieurs emprunts");
       }
    }
    
    public void informerRetardEmprunteur() {
        //On met à jours les etats avant d'informer les emprunteurs
        this.miseAjoursEtat();
        
        //Envoi d'un message pour chacun des retardataires suivis du titre du média
	for(Map.Entry<Emprunteur, Media> entry : this.emprunteurEnRetard.entrySet()) {
		Emprunteur emprunteur = entry.getKey();
		Media media = entry.getValue();
                EmprunterObserver o = (EmprunterObserver)emprunteur;
                
      
                o.update(emprunteur.getEmailEmprunteur(), "Médiathèque retard emprunt", media.getTitreMedia());
		//System.out.println("Key: " + emprunteur.getNomEmprunteur() + ", Value: " + media.getTitreMedia());
	}
    } 
    
    public void ajouterNouveauMedia(Object o) {
        if(!this.listMedia.contains((Media)o)) {
            System.out.println("Ajout d'un nouveau média:\n"+((Media)o).descriptionMedia());
            this.listMedia.add((Media)o);
  
        }else {
            System.out.println("Le média ne sera pas rajouté, il existe déjà");
        }   
    }
    
    public void rendreMedia(Object o) {
        this.listMedia.add((Media)o);
        ((Media)o).setNombreExemplaire(true);
    }
    
    //réduit le nombre d'exemplaire disponible
    public void retirerExemplaireMedia(Object o) {
        ((Media)o).setNombreExemplaire(false);
    }
    
    public boolean mediaDisponile(Object o) {
        //Si le média est disponible
        if(((Media)o).getNombreExemplaire() == 0) {
            ((Media)o).Etat = false;
            return false;
        }
        //si le média existe dans la liste
        return this.listMedia.contains((Media)o);
    }
    //////////////////////////////////////////////
    
    //Getters and setters
    protected void getListMedia(){
        System.out.println("La liste des médias de la médiathèque: ");
        for(Media item : this.listMedia) {
            System.out.println(item.descriptionMedia());
        }
    }
    protected void getEtatEmprunt() {
        for(Emprunt emprunt : empruntArrayList) {
            System.out.println(emprunt.getEtat());
        }
    }
    protected void getListEmprunt() {
        System.out.println("La liste des emprunts de la médiathèque: ");
        for(Emprunt item : this.empruntArrayList) {
            System.out.println( item.getInformation() +"");
        }  
    }
    protected void getListEmprunteur(){
        System.out.println("La liste des emprunteurs de la médiathèque: ");
        System.out.println("Taille "+listEmprunteur.size());
        for(Emprunteur item : this.listEmprunteur) {
            System.out.println(item.getNomPrenomEmprunteur());
        }
    } 
    protected void getListEmprunteurEnRetard(){
        System.out.println("La liste des emprunteurs EN RETARD de la médiathèque: ");
        for(Emprunteur emprunteur : this.emprunteurEnRetard.keySet()) {
            System.out.println(emprunteur.getNomPrenomEmprunteur());
        }
    } 
        
    /**
     *
     */
    protected void sauvegardeMediatheque() throws FileNotFoundException  {
        Gson gson = new Gson();     
        gson = new GsonBuilder().setPrettyPrinting().create();
        
        
        String strJson = gson.toJson(this.listMedia);
        //marche pas
        //String d = gson.toJson(this.empruntArrayList);
        
        FileWriter writer = null;
        
        try {
          writer = new FileWriter("gen.json");
          writer.write(strJson);
          
          //writer.write(d);
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (writer != null) {
           try {
            writer.close();
           } catch (IOException e) {
            e.printStackTrace();
           }
          }
         
        /*
        for(Media media : this.listMedia) {
            m.put("idMedia", media.idMedia);
            m.put("titre", media.titreMedia);
            m.put("genre", media.genreMedia);
            m.put("maisonProduction", media.maisonProductionMedia);
            m.put("nbExemplaire", media.nombreExemplaire);
        }
        */
    }
    /*
    protected void contenuJson() {

    }
*/
    }
}
