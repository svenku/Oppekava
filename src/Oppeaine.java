/**
 * Created by Sven on 5/18/2017.
 */
public class Oppeaine {

    private String kood;
    private String nimetus;
    private int EAP;
    private String semester;

    public String getKood() {
        return kood;
    }

    public String getNimetus() {
        return nimetus;
    }

    public int getEAP() {
        return EAP;
    }

    public String getSemester() {
        return semester;
    }

    public Oppeaine(String kood, String nimetus, int EAP, String semester) {
        this.kood = kood;
        this.nimetus = nimetus;
        this.EAP = EAP;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return kood + " " + nimetus + " " + EAP + " " + semester;
    }
}
