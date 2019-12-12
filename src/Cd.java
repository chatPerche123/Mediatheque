

public class Cd extends Media {
    private final int dureeMinuteDisc;
    private final String groupeCD;
    
    public Cd() {
        super();
        
        this.dureeMinuteDisc = 0;
        this.groupeCD = "";
    }
    public Cd(int idDisc, String groupeCD, String titreDisc, String genreDisc, 
            String maisonProductionDisc, int dureeMinuteDisc, int nombreExemplaireCD) {
        
        super(idDisc, titreDisc, genreDisc, maisonProductionDisc, nombreExemplaireCD);
        
        this.dureeMinuteDisc = dureeMinuteDisc;
        this.groupeCD = groupeCD;
    }

    public int getDureeMinuteDisc() {
        return this.dureeMinuteDisc;
    }
    
}
