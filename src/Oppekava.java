import java.io.*;
import java.util.*;

/**
 * Created by Sven on 5/18/2017.
 */
public class Oppekava {
    public static void main(String[] args) throws EbasobivSemesterErind, IOException {
        Queue<Oppeaine> oppeained = loeOppeained("oppeained.txt");
        List<Semester> semestrid = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            semestrid.add(new Semester(i+1));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!oppeained.isEmpty()) {

            while (true) {
                System.out.print("Kas soovid ainet lisada (L), vaadata (V) või lõpetada töö (P)? ");
                String vastus = br.readLine();
                int sem;

                if ("L".equals(vastus)) {

                    Oppeaine oppeaine = oppeained.remove();

                    while (true) {

                        System.out.println("Aine: " + oppeaine);
                        System.out.print("Sisesta semestri number: ");
                        try {
                            sem = Integer.parseInt(br.readLine());
                            semestrid.get(sem - 1).lisaOppeaine(oppeaine, sem);
                            break;
                        } catch (EbasobivSemesterErind e) {
                            System.out.print(e.getMessage());
                            oppeaine = e.getOppeaine();
                        }
                    }
                }

                else if ("V".equals(vastus)) {
                    System.out.println("Sisesta semestri number: ");
                    sem = Integer.parseInt(br.readLine());
                    System.out.println(semestrid.get(sem - 1).toString());
                }

                else if ("P".equals(vastus)) {
                        System.out.println("Programm lõpetab töö. Head päeva!");
                        break;

                }

                else System.out.println("Vale sisend!");
            }
        }
        br.close();
    }

    private static Queue<Oppeaine> loeOppeained(String failiNimi) {
        Queue<Oppeaine> oppeained = new LinkedList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(failiNimi))))){
            String rida = br.readLine();
            while (rida != null){
                String[] tykid = rida.split(";");
                Oppeaine oppeaine = new Oppeaine(tykid[0], tykid[1], Integer.parseInt(tykid[2]), tykid[3]);
                oppeained.add(oppeaine);
                rida = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Viga õppeainete lugemisel failist!");
        }
        return oppeained;

    }

}
