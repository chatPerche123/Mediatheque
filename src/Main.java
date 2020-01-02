
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        //création médiathèque
        Mediatheque mediatheque = Mediatheque.getInstance("Mediathèque de Rennes", "n°9 rue De Rennes", "0299555871");
        Emprunteur emprunteur1 = new Emprunteur("Dupond", "Fanille", "Fanille@domaine.fr");
        Emprunteur emprunteur2 = new Emprunteur("Dupond", "Mariano", "Mariano@domaine.fr");

        Livre livre1 = new Livre("2-7177-2113-4", "Dubosk", "Livre de Toto", "Enfant", "MaisonDesEnfants", 50, 3);
        Cd cd1 = new Cd(6546456, "Les Inconnus", "Les Inconnus font du skie", "Music", "MaisonDesInconnus", 30, 2);
        Dvd dvd1 = new Dvd(8979, "Micheal Bay", "Les saucoupes de l'espace", "Humour", "MaisonDeMichealBay", 120, 1);


        
        
        System.out.println("DEBUT AJOUT MEDIA");
        mediatheque.ajouterNouveauMedia(livre1);
        mediatheque.ajouterNouveauMedia(cd1);
        mediatheque.ajouterNouveauMedia(dvd1);
        
        mediatheque.sauvegardeMediatheque(); 
       // mediatheque.contenuJson();
        
        /*mediatheque.ajouterNouveauMedia(livre1);
        System.out.println("\n");
        System.out.println("DEBUT EMPRUNT EMPRUNTEUR 1");
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(livre1);
        System.out.println("\n");
        System.out.println("DEBUT EMPRUNT EMPRUNTEUR 2");
        emprunteur2.souhaiteEmprunter(livre1);
        emprunteur2.souhaiteEmprunter(cd1);
        System.out.println("\n");
        
        

        mediatheque.getListEmprunt();
        System.out.println("\n");
        
        mediatheque.getListEmprunteur();
        System.out.println("\n");

        emprunteur1.souhaiteRendreMedia(livre1);

        
        mediatheque.getListEmprunt();
        System.out.println("\n");
        
        emprunteur2.souhaiteRendreMedia(livre1);
        emprunteur2.souhaiteRendreMedia(dvd1);
        mediatheque.getListEmprunt();
        System.out.println("\n");

        mediatheque.getListEmprunt();
        
        mediatheque.miseAjoursEtat();
        mediatheque.getEtatEmprunt();
        
        System.out.println("\n");
        mediatheque.getListEmprunteurEnRetard(); 
        
        System.out.println("\n");
        mediatheque.informerRetardEmprunteur();*/
        
        
        
    }
    
}
