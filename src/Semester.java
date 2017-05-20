import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven on 5/18/2017.
 */
public class Semester {
    public Semester(int mitmes) {
        this.mitmes = mitmes;
        this.oppeained = new ArrayList<>();
    }

    private int mitmes;
    private List<Oppeaine> oppeained;

    public int getMitmes() {
        return mitmes;
    }

    public List<Oppeaine> getOppeained() {
        return oppeained;
    }

    public void lisaOppeaine(Oppeaine oppeaine, int sem) throws EbasobivSemesterErind {
        if ((oppeaine.getSemester().equals("kevad") && sem % 2 == 0) || (oppeaine.getSemester().equals("sügis") && sem % 2 != 0)) {
            this.oppeained.add(oppeaine);
            System.out.println("Aine lisatud " + sem + ". semestrile.");
            }
        else
            throw new EbasobivSemesterErind("Vale semester! Sisesta korrektne semestrinumber! ", oppeaine);
     }

    public int eapd(){
        int summa = 0;
        for (Oppeaine oppeaine : oppeained) {
            summa += oppeaine.getEAP();
        }
        return summa;
    }


    @Override
    public String toString() {
        return "Semester:   " + mitmes + System.lineSeparator() +
                "Õppeained: " + oppeained + System.lineSeparator() +
                "EAP kokku: " + this.eapd();
    }
}
