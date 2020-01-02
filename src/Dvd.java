

public class Dvd extends Media {
    //Variables
    private final int dureeMinuteDVD;
    private final String realisateurDvd;
    //////////////////////////////////////////////
    
    //Constructeurs
    public Dvd() {
        super();    
        this.dureeMinuteDVD = 0;
        this.realisateurDvd = "";
    }
    public Dvd(int EIRDdvd, String realisateurDvd, String titreDvd, String genreDvd, 
            String maisonProductionDvd, int dureeMinuteDVD, int nombreExemplaireDVD) {
        
        super(EIRDdvd, titreDvd, genreDvd, maisonProductionDvd, nombreExemplaireDVD);
        
        this.dureeMinuteDVD = dureeMinuteDVD;
        this.realisateurDvd = realisateurDvd;
    }
    //////////////////////////////////////////////
    
    public int getDureeMinuteDvd() {
        return this.dureeMinuteDVD;
    }

}
