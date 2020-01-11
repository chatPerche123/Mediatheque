
import java.io.FileNotFoundException;
/*
Class de test
LIEN GITHUB: https://github.com/chatPerche123/Mediatheque
*/

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //création médiathèque
        Mediatheque mediatheque = Mediatheque.getInstance("Mediathèque de Rennes", "n°9 rue De Rennes", "0299555871");

        //création d'1 média par type
        Livre livre1 = new Livre("2-7177-2113-4", "Test", "Livre de Toto", "Enfant", "MaisonDesEnfants", 50, 3);
        Cd cd1 = new Cd(6546456, "Les Inconnus", "Les Inconnus font du skie", "Music", "MaisonDesInconnus", 30, 2);
        Dvd dvd1 = new Dvd(8979, "Micheal Bay", "Les saucoupes de l'espace", "Humour", "MaisonDeMichealBay", 120, 1);

        //création d'1 emprunteur
        Emprunteur emprunteur1 = new Emprunteur("Dupond", "Fanille", "Fanille@domaine.fr");
        //Emprunteur emprunteur2 = new Emprunteur("Dupond", "Mariano", "Mariano@domaine.fr");
        
        //Ajout des médias à la médiatheque
        System.out.println("DEBUT AJOUT MEDIA");
        mediatheque.ajouterNouveauMedia(livre1);
        mediatheque.ajouterNouveauMedia(cd1);
        mediatheque.ajouterNouveauMedia(dvd1); 
        mediatheque.ajouterNouveauMedia(livre1); 
        System.out.println("\n");
        
        System.out.println("DEBUT EMPRUNT EMPRUNTEUR 1");
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(livre1);
        System.out.println("\n");
        //System.out.println("DEBUT EMPRUNT EMPRUNTEUR 2");
        //emprunteur2.souhaiteEmprunter(livre1);
        //emprunteur2.souhaiteEmprunter(cd1);
        //System.out.println("\n");
        
        

        mediatheque.getListEmprunt();
        System.out.println("\n");
        
        mediatheque.getListEmprunteur();
        System.out.println("\n");
        
        //l'emprunteur veut rendre un media
        emprunteur1.souhaiteRendreMedia(livre1);

        
        mediatheque.getListEmprunt();
        System.out.println("\n");
        
        //informe d'un mail
        mediatheque.informerRetardEmprunteur();
        
        mediatheque.sauvegardeMediatheque();
    }
    
}
