/*
Interface Observer qui implement Emprunteur et informe celui-ci de ses retards
*/

public interface EmprunterObserver {
    void update(String email, String Subject, String media);
}
