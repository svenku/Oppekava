/**
 * Created by Sven on 5/18/2017.
 */
public class EbasobivSemesterErind extends Exception{

    private Oppeaine oppeaine;

    public EbasobivSemesterErind(String message, Oppeaine oppeaine) {
        super(message);
        this.oppeaine = oppeaine;
    }

    public Oppeaine getOppeaine() {
        return oppeaine;
    }
}
