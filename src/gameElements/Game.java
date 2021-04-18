package gameElements;

import java.util.Scanner;


/**
 * Game osztály
 * - Az osztály felelős a főmenü és játék műveletek lebonyolításáért
 */
public class Game {

    private String slenderPic;

    /**
    * A Game konstruktor
    *
    * Feladat:
    *
    * - A főképernyő megjelenítése
    * - Térkép létrehozásása
    * - Játékmenet legenrálása
    */
    public Game() {

        //fő felirat
        System.out.println("\n");
        String jSlenderLogo = "        (      (               )   (             (    \n" +
                "        )\\ )   )\\ )         ( /(   )\\ )          )\\ ) \n" +
                "   (   (()/(  (()/(   (     )\\()) (()/(    (    (()/( \n" +
                "   )\\   /(_))  /(_))  )\\   ((_)\\   /(_))   )\\    /(_))\n" +
                "  ((_) (_))   (_))   ((_)   _((_) (_))_   ((_)  (_))  \n" +
                " _ | | / __|  | |    | __| | \\| |  |   \\  | __| | _ \\ \n" +
                "| || | \\__ \\  | |__  | _|  | .` |  | |) | | _|  |   / \n" +
                " \\__/  |___/  |____| |___| |_|\\_|  |___/  |___| |_|_\\ ";

        //slenderman ábra
        this.slenderPic =
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "░░░░░░░░░▄▄███▄░░░░░░░░░░░░░░░░░░░░░░░░░▄███▄░░░░░░░░\n" +
                "░░░░░░░░░▄▄██▀▀░░░░░░░░▄█▀▀▀▀█▄░░░░░░▄██████▄░░░░░░░░\n" +
                "░░░░░░░█████████▄░░░░░░█░░░░░▀█░░░░░░░▄▄▄▀█▀▀░░░░░░░░\n" +
                "░░░░░░░░░▄███▀▀▀▀░░░░░░█░░░░░░█░░░░░░▀▀▀█████▄▄░░░░░░\n" +
                "░░░░░░░▄▄███████▀░░░░░░█▄░░░░▄█░░░░░░▄█▀███▄██░░░░░░░\n" +
                "░░░░░░░███████░░░░░░░░░░▀█░░█▀░░░░░██████████▄▄░░░░░░\n" +
                "░░░░░░░███▄███▀▀▀░░░░░██▀▀██▀▀██░░░░░░░▀▀█████░░░░░░░\n" +
                "░░░░░░░░░████▄▄▄░░░░░█████░█░████░░░░░▀▀█████░░░░░░░░\n" +
                "░░░░░░░▀▀▀███▄▀▀░░░░███▀███░██▀███░░░░▀▀██████░░░░░░░\n" +
                "░░░░░░░░░▀█████▀░░░░███░██████░███░░░░░░░░█░░░░░░░░░░";

        System.out.println(jSlenderLogo);
        System.out.println(this.slenderPic);
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t\tÜdvözöllek a JSlender-ben!");
        System.out.println("-----------------------------------------------------");
        System.out.println(
                "A feladatod hogy 8 papírt összegyűjts az erdő mélyén. " +
                "\nMagaddal vihetsz egy ZSEBLÁMPÁT ami VILÁGÍTJA neked az utat." +
                "\nHa összegyűjtöd őket, talán sikerül megtudnod a titkot amit az erdő rejt." +
                "\nDe légy óvatos! Lehet, hogy nem vagy egyedül..."
        );
        System.out.println("\nA folytatáshoz válassz egy lehetőséget!");
        System.out.println("Menü:\n\t1 - Új játék\n\t2 - Pálya beolvasása fájlból\n\t3 - Kilépés");
        Scanner scanner = new Scanner(System.in);
        String readData;
        do {
            System.out.print("Válasz: ");
            readData = scanner.next();
            switch (readData) {
                case "1" :
                    play(new GameMap());
                    break;
                case "2":
                    System.out.println("Kérlek adj meg egy elérési útvonalat!\nFigyelj oda hogy a fájlod pontosvesszőkkel legyen elválasztva és a mérete 15x15-ös legyen!");
                    System.out.println("Alapértelmezett /src mappában található - beolvas.txt");
                    System.out.print("Válasz: ");
                    String fileName = scanner.next();
                    play(new GameMap("src/" + fileName));
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Kötelező opció!");
                    break;
            }
        } while (!(readData.equals("1") || readData.equals("2")));
    }

    /**
     * @param actual GameMap típus
     *
     * Feladat:
     *
     * - Térkép frissítése
     * - Végeredmény eldöntése
     */
    public void play(GameMap actual) {

        boolean areYouWon;
        do {
            actual.printMap(actual.getAreaMatrix());
            actual.controlOverMap(actual.getAreaMatrix());
            System.out.println("\nFennmaradó papírok száma: " + actual.getRemainingPaperNumber());
            System.out.println("---------------------------");

        } while (!(actual.getRemainingPaperNumber() == 0));

        areYouWon = actual.areyouWon();
        if (areYouWon) {
            System.out.println("Sikeresen kijutottál az erdőből!\nMost az egyszer...");
        } else {
            System.out.println("Elkapott...\n\n" + this.slenderPic);
        }

    }
}
