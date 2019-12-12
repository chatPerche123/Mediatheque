

public class Main {

    public static void main(String[] args) {
        //création médiathèque
        Mediatheque mediatheque = Mediatheque.getInstance("Mediathèque de Rennes", "n°9 rue De Rennes", "0299555871");
        Emprunteur emprunteur1 = new Emprunteur("Dupond", "Fanille", "Fanille@domaine.fr");
        Emprunteur emprunteur2 = new Emprunteur("Dupond", "Mariano", "Mariano@domaine.fr");

        Livre livre1 = new Livre("2-7177-2113-4", "Dubosk", "Livre de Toto", "Enfant", "MaisonDesEnfants", 50, 3);
        Cd cd1 = new Cd(6546456, "Les Inconnus", "Les Inconnus font du skie", "Music", "MaisonDesInconnus", 30, 2);
        Dvd dvd1 = new Dvd(8979, "Micheal Bay", "Les saucoupes de l'espace", "Humour", "MaisonDeMichealBay", 120, 1);
        //System.out.println(livre1.descriptionMedia());
        //System.out.println(livre1.getNombreExemplaire());
        
        //System.out.println(emprunteur1.getIdEmprunteur());
        //System.out.println(emprunteur2.getIdEmprunteur());
        
        //emprunteur1.afficherEmprunt();
        
        mediatheque.ajouterNouveauMedia(livre1);
        mediatheque.ajouterNouveauMedia(cd1);
        mediatheque.ajouterNouveauMedia(dvd1);
        mediatheque.ajouterNouveauMedia(livre1);
        
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(dvd1);
        emprunteur1.souhaiteEmprunter(livre1);
        emprunteur1.souhaiteEmprunter(livre1);
        
        emprunteur2.souhaiteEmprunter(livre1);
        emprunteur2.souhaiteEmprunter(cd1);
        
        //mediatheque.getListEmprunt();

        mediatheque.getListEmprunt();

        
        mediatheque.getListEmprunteur();
        
        //System.out.println(emprunteur1.getNbMediaEmprunter());
        emprunteur1.souhaiteRendreMedia(livre1);
        //System.out.println(emprunteur1.getNbMediaEmprunter());
        //emprunteur1.souhaiteRendreMedia(livre1);
        
        //System.out.println(emprunteur1.getNbMediaEmprunter());
        //emprunteur1.souhaiteRendreMedia(dvd1);
        //System.out.println(emprunteur1.getNbMediaEmprunter());
        //emprunteur1.souhaiteRendreMedia(dvd1);
        //System.out.println(emprunteur1.getNbMediaEmprunter());
        //emprunteur1.souhaiteRendreMedia(livre1);
        
        //mediatheque.getListEmprunteur();
        
        mediatheque.getListEmprunt();
        
        //emprunteur1.addEmprunt(livre1);
        //emprunteur1.afficherEmprunt();

        //emprunteur1.souhaiteEmprunter(livre1);
    }
    
}
