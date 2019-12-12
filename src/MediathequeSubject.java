

public interface MediathequeSubject {
        void ajouterEmprunteur(Object o);
        void supprimerEmprunteur(Emprunteur o);
        void ajouterNouveauMedia(Object o);
        void rendreMedia(Object o);
        void retirerExemplaireMedia(Object o);
        boolean mediaDisponile(Object o);
        void informerRetardEmprunteur();
}
