
import java.util.ArrayList;


public class Emprunteur implements EmprunterObserver{   
    //Accès à l'instance unique de la mediathèque
    Mediatheque mediatheque = Mediatheque.uniqueInstance;
    //Permet d'incrémenter un identifiant unique (idEmprunteur) en static
    private static int idIncrement = 1;
    private int idEmprunteur;
    //Connaître le nb de média emprunter
    private int nbMediaEmprunter;
    //liste des emprunts
    private ArrayList<Media> listEmprunt;
    //informations de base
    private String nomEmprunteur;
    private String prenomEmprunteur;
    private String adresseEmailEmprunteur;
    
    public Emprunteur() { 
    }
    public Emprunteur(String nomEmprunteur, String prenomEmprunteur, String adresseEmailEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
        this.prenomEmprunteur = prenomEmprunteur;
        this.adresseEmailEmprunteur = adresseEmailEmprunteur;
        
        //initialise la liste et le nb des emprunts à zéro
        this.listEmprunt = new ArrayList<>();
        this.nbMediaEmprunter = 0;
        //incrémente l'identifiant unique
        this.idEmprunteur = Emprunteur.idIncrement++;
    }
    
    
    protected String getNomEmprunteur() {
        return this.nomEmprunteur;
    }
    protected String getPrenomEmprunteur() {
        return this.prenomEmprunteur;
    }
    protected String getNomPrenomEmprunteur() {
        return this.getNomEmprunteur()+"-"+this.getPrenomEmprunteur();
    }
    protected int getNbMediaEmprunter() {
        return this.nbMediaEmprunter;
    }
    protected int getIdEmprunteur() {
        return this.idEmprunteur;
    }
    protected void setNombreMediaEmprunter(boolean value) {
        if(value) {
            this.nbMediaEmprunter++;
        
        }else {
            this.nbMediaEmprunter--;
        }
    }
    
    
    protected void afficherEmprunt() {
        if(this.getNbMediaEmprunter() == 0) {
            System.out.println(this.getNomPrenomEmprunteur()+" n'a rien encore emprunter.");  
        }else {
            for(Media media : listEmprunt) {
                System.out.println(media.descriptionMedia());
            }
        }
    }
    
    
    protected void souhaiteEmprunter(Media media) {
            //Vérifie que l'emprunteur n'a pas plus de 3 médias
            if(this.getNbMediaEmprunter() >= 3) {
                System.out.println(this.getNomPrenomEmprunteur()+" a atteint le nombre maximum de média");

            //vérifie que le média est disponible
            }else if(mediatheque.mediaDisponile(media)) {
                mediatheque.ajouterEmprunt(this, media);
                
                System.out.println("Emprunt ("+media.getTitreMedia()+") accepter.");
                //incrémente le nombre de média emprunter
                this.setNombreMediaEmprunter(true);
                //ajoute le média à la liste de l'emprunteur
                this.listEmprunt.add(media);
                //ajoute l'emprunteur à la liste de la médiatheque
                mediatheque.ajouterEmprunteur(this);
                //réduit le nombre d'exemplaire disponible
                mediatheque.retirerExemplaireMedia(media);
                

            }else {
                System.out.println("Media ("+media.getTitreMedia()+") non disponible ou ne faisant pas partie de la liste");
            }
    }
    protected void souhaiteRendreMedia(Media media) {
        //vérifie si l'emprunteur possède bien le média qu'il veut rendre
        if(this.listEmprunt.contains(media)) {
            //décrémente le nombre de média emprunter
            this.setNombreMediaEmprunter(false);
            //supprime l'emprunteur s'il n'a plus de média
            mediatheque.supprimerEmprunteur(this);
            //rendre le media
            mediatheque.rendreMedia(media);
            //supprimer un emprunt
            mediatheque.supprimerEmprunt(this, media);

        }else {
            System.out.println("L'emprunteur essaie de rendre un média qu'il ne possède pas");
        }
    }
  
}
