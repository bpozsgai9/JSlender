package gameElements;

import fieldElements.FieldElement;
import fieldElements.movable.Player;
import fieldElements.movable.SlenderMan;
import fieldElements.stable.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMap {

    private int remainingPaperNumber;
    private final Field[][] areaMatrix;
    private String lastDirection;
    private boolean areyouWon;

    public GameMap() {

        this.remainingPaperNumber = 8;
        this.areaMatrix = new Field[15][15];
        this.lastDirection = "w";
        this.areyouWon = true;
        generateMap(this.areaMatrix);
        //System.out.println(Arrays.deepToString(this.areaMatrix));
        printMap(this.areaMatrix);
        System.out.println(
                "\nA holdfény alig szűrődött a sűrű lombos fákon keresztül, az erdő sötét volt és magányos." +
                "\nA távolból csak némi moraj hallatszott a csenden túl, a szél susogása, a levelek zaja..."
        );
    }

    public GameMap(String fileName) {

        this.remainingPaperNumber = 8;
        this.areaMatrix = new Field[15][15];
        this.lastDirection = "w";
        generateMapViaFile(fileName, this.areaMatrix);
        //System.out.println(Arrays.deepToString(this.areaMatrix));
        printMap(this.areaMatrix);
        System.out.println(
                "\nA holdfény alig szűrődött a sűrű lombos fákon keresztül, az erdő sötét volt és magányos." +
                "\nA távolból csak némi moraj hallatszott a csenden túl, a szél susogása, a levelek zaja..."
        );
    }

    public int getRemainingPaperNumber() {
        return remainingPaperNumber;
    }

    public Field[][] getAreaMatrix() {
        return areaMatrix;
    }

    public String getLastDirection() { return lastDirection; }

    public boolean areyouWon() {
        return areyouWon;
    }

    public void setLastDirection(String lastDirection) { this.lastDirection = lastDirection; }

    public Field getPlayerActualPosition(Field [][] areaMatrix) {
        for (Field[] matrix : areaMatrix) {
            for (Field field : matrix) {
                if (field.getOwnerId() == 9) {
                    return field;
                }
            }
        }
        return null;
    }

    public Field getSlendermanActualPosition(Field [][] areaMatrix) {
        for (Field[] matrix : areaMatrix) {
            for (Field field : matrix) {
                if (field.getOwnerId() == 8) {
                    return field;
                }
            }
        }
        return null;
    }

    private void generateMap(Field [][] areaMatrix) {

        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {
                areaMatrix[row][column] = new Field(row, column, new EmptyField());
            }
        }

        //kiinduló helyzet
        //kis méretű fa
        areaMatrix[0][11] = new Field(0, 11, new SmallSizeTree());
        areaMatrix[1][3] = new Field(1, 3, new SmallSizeTree());
        areaMatrix[1][13] = new Field(1, 13, new SmallSizeTree());
        areaMatrix[4][0] = new Field(4, 0, new SmallSizeTree());
        areaMatrix[5][7] = new Field(5, 7, new SmallSizeTree());
        areaMatrix[5][14] = new Field(5, 14, new SmallSizeTree());
        areaMatrix[10][2] = new Field(10, 2, new SmallSizeTree());
        areaMatrix[12][4] = new Field(12, 4, new SmallSizeTree());
        areaMatrix[12][12] = new Field(12, 12, new SmallSizeTree());
        areaMatrix[13][12] = new Field(13, 12, new SmallSizeTree());

        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {
                if (
                    //nagy méretű fa
                    row > 12 && row <= 14 && /*column >= 0 &&*/ column < 2 ||
                    row > 12 && row <= 14 && column > 3 && column < 6 ||
                    row > 9 && row < 12 && column > 4 && column < 7 ||
                    row > 8 && row < 11 && column > 12 && column <= 14

                ) {
                    areaMatrix[row][column] = new Field(row, column, new LargeSizeTree());
                } else if (
                    //ház
                    row > 1 && row < 9 && column > 7 && column < 14
                ) {
                    areaMatrix[row][column] = new Field(row, column, new House());
                } else if (
                        //autó
                        /*row >= 0 &&*/ row < 2 && column > 5 && column < 9  ||
                        row > 6 && row < 10 && column > 5 &&column < 8
                ) {
                    areaMatrix[row][column] = new Field(row, column, new Car());
                } else if (
                        //teherautó
                        row > 9 && row <= 14 && column > 8 && column < 12
                ) {
                    areaMatrix[row][column] = new Field(row, column, new Truck());
                } else if (
                        //szikla
                        /*row >= 0 &&*/ row < 3 && /*column >= 0 &&*/ column < 3 ||
                        row > 6 && row < 10 && /*column >= 0 &&*/ column < 3
                ) {
                    areaMatrix[row][column] = new Field(row, column, new Rock());
                } else if (
                        //hordó
                        row > 2 && row < 5 && column > 2 && column < 7
                ) {
                    areaMatrix[row][column] = new Field(row, column, new Barrel());
                }
            }
        }

        //slenderman
        areaMatrix[4][1] = new Field(4, 1, new SlenderMan());

        //játékos
        areaMatrix[9][4] = new Field(9, 4, new Player());

        //házon való átjárás
        areaMatrix[8][12] = new Field(8, 12, new EmptyField()); //bejárat
        areaMatrix[7][12] = new Field(7, 12,  new EmptyField());
        areaMatrix[6][12] = new Field(6, 12,  new EmptyField());
        areaMatrix[5][12] = new Field(5, 12,  new EmptyField());
        areaMatrix[4][12] = new Field(4, 12,  new EmptyField());
        areaMatrix[3][12] = new Field(3, 12,  new EmptyField());
        areaMatrix[3][11] = new Field(3, 11,  new EmptyField());
        areaMatrix[3][10] = new Field(3, 10,  new EmptyField());
        areaMatrix[3][9] = new Field(3, 9,  new EmptyField());
        areaMatrix[3][8] = new Field(3, 8,  new EmptyField()); //kijárat

        //papírok helye
        areaMatrix[3][7].setContainPaper(true);
        areaMatrix[6][1].setContainPaper(true);
        areaMatrix[6][7].setContainPaper(true);
        areaMatrix[6][12].setContainPaper(true);
        areaMatrix[8][4].setContainPaper(true);
        areaMatrix[13][2].setContainPaper(true);
        areaMatrix[13][8].setContainPaper(true);
        areaMatrix[13][3].setContainPaper(true);
    }

    private void generateMapViaFile(String fileName, Field [][] areaMatrix) {

        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int i = 0;
            while (line != null) {

                String[] data = line.split(";");
                for (int j = 0; j < data.length; j++) {

                    FieldElement element = null;
                    switch (Integer.parseInt(data[j])) {
                        case 0 : element = new EmptyField(); break;
                        case 1 : element = new SmallSizeTree(); break;
                        case 2 : element = new LargeSizeTree(); break;
                        case 3 : element = new House(); break;
                        case 4 : element = new Car(); break;
                        case 5 : element = new Truck(); break;
                        case 6 : element = new Rock(); break;
                        case 7 : element = new Barrel(); break;
                        case 8 : element = new SlenderMan(); break;
                        case 9 : element = new Player(); break;
                        default:
                            System.out.println("Hiba: Nem megfelelő beolvasott érték!");
                            System.exit(1);
                            break;
                    }
                    areaMatrix[i][j] = new Field(i, j, element);
                }
                line = br.readLine();
                i++;
            }
            br.close();
            fr.close();

        } catch (Exception e) {

            System.out.println("Hiba: " + e);
            e.printStackTrace();
        }

        int counter = 8;
        while (!(counter == 0)) {
            int random = ((int)(15.0 * Math.random()));
            int random2 = ((int)(15.0 * Math.random()));
            if (
                    !(areaMatrix[random][random2].isContainPaper()) &&
                    areaMatrix[random][random2].getElementOnTop().canContainPaper
            ) {
                areaMatrix[random][random2].setContainPaper(true);
                //System.out.println(random + ";" + random2);
                counter--;
            }
        }
    }

    public void printCleanMap(Field [][] areaMatrix) {

        System.out.println("\nTérkép:");
        System.out.println("" +
                "0 - Átjárható terület\n" +
                "1 - Kis méretű fa\n" +
                "2 - Nagy méretű fa\n" +
                "3 - Ház\n" +
                "4 - Autó\n" +
                "5 - Teherautó\n" +
                "6 - Szikla\n" +
                "7 - Hordó\n" +
                "8 - Slenderman\n" +
                "9 - Játekos");

        System.out.println("-----------------------------");
        for (Field[] matrix : areaMatrix) {
            for (Field field : matrix) {
                /*if (field.getOwnerId() == 8) {
                    System.out.print("0 ");
                } else {*/
                    System.out.print(field + " ");
                //}
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public void printMap(Field [][] areaMatrix) {

        boolean w;
        boolean a;
        boolean s;
        boolean d;
        boolean actual = true;
        Field actualPosition = getPlayerActualPosition(areaMatrix);

        //zseblámpa fénye
        System.out.println();
        int actualFieldRow;
        int actualPositionRow;
        int actualFieldColumn;
        int actualPositionColumn;
        boolean actualId;
        for (Field[] matrix : areaMatrix) {
            for (Field field : matrix) {

                actualFieldRow = field.getRow();
                actualPositionRow = actualPosition.getRow();
                actualFieldColumn = field.getColumn();
                actualPositionColumn = actualPosition.getColumn();
                actualId = field.getOwnerId() == actualPosition.getOwnerId();

                w = actualId ||
                        actualFieldRow == actualPositionRow - 1 && actualFieldColumn == actualPositionColumn ||
                        actualFieldRow == actualPositionRow - 2 && actualFieldColumn == actualPositionColumn ||
                        actualFieldRow == actualPositionRow - 2 && actualFieldColumn == actualPositionColumn - 1 ||
                        actualFieldRow == actualPositionRow - 2 && actualFieldColumn == actualPositionColumn + 1;

                a = actualId ||
                        actualFieldRow == actualPositionRow && actualFieldColumn == actualPositionColumn - 1 ||
                        actualFieldRow == actualPositionRow && actualFieldColumn == actualPositionColumn - 2 ||
                        actualFieldRow == actualPositionRow - 1 && actualFieldColumn == actualPositionColumn - 2 ||
                        actualFieldRow == actualPositionRow + 1 && actualFieldColumn == actualPositionColumn - 2;

                s = actualId ||
                        actualFieldRow == actualPositionRow + 1 && actualFieldColumn == actualPositionColumn ||
                        actualFieldRow == actualPositionRow + 2 && actualFieldColumn == actualPositionColumn ||
                        actualFieldRow == actualPositionRow + 2 && actualFieldColumn == actualPositionColumn - 1 ||
                        actualFieldRow == actualPositionRow + 2 && actualFieldColumn == actualPositionColumn + 1;

                d = actualId ||
                        actualFieldRow == actualPositionRow && actualFieldColumn == actualPositionColumn + 1 ||
                        actualFieldRow == actualPositionRow && actualFieldColumn == actualPositionColumn + 2 ||
                        actualFieldRow == actualPositionRow - 1 && actualFieldColumn == actualPositionColumn + 2 ||
                        actualFieldRow == actualPositionRow + 1 && actualFieldColumn == actualPositionColumn + 2;

                switch (this.getLastDirection()) {
                    case "w":
                        actual = w;
                        break;
                    case "a":
                        actual = a;
                        break;
                    case "s":
                        actual = s;
                        break;
                    case "d":
                        actual = d;
                        break;
                }
                if (actual) {
                    System.out.print(field + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public void controlOverMap(Field [][] areaMatrix) {

        System.out.println("\nA te játékosod azonosítója: [9]");
        System.out.println("Merre szeretnél lépni?");
        System.out.println("\tw - felfele\n\ta - balra\n\ts - lefele\n\td - jobbra\n\tm - térkép\n\tk - kilépés");
        System.out.print("Válasz: ");
        Scanner scanner = new Scanner(System.in);
        String readData = scanner.next();
        switch (readData) {
            case "w":
                changeLocation("w", areaMatrix);
                break;
            case "a":
                changeLocation("a", areaMatrix);
                break;
            case "s":
                changeLocation("s", areaMatrix);
                break;
            case "d":
                changeLocation("d", areaMatrix);
                break;
            case "m":
                printCleanMap(areaMatrix);
                break;
            case "k":
                System.exit(0);
                    break;
            default:
                System.out.println("Nincs ilyen opció!");
                break;
        }
    }

    private void changeLocation(String where, Field [][] areaMatrix) {

        String reservedError =
                "------------------------------------------" +
                "\nHiba: Erre nem léphetsz ez a mező foglalt!" +
                "\n------------------------------------------";

        String outOfMapError =
                "-----------------------------------------" +
                "\nHiba: Erre nem léphetsz itt a pálya vége!" +
                "\n-----------------------------------------";

        String paperBeenFound =
                "--------------------------------------------" +
                "\n\t\t\tTaláltál egy papírt!" +
                "\n--------------------------------------------";
        boolean outOfMapTop;
        boolean outOfMapLeft;
        boolean outOfMapBottom;
        boolean outOfMapRight;

        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {

                outOfMapTop = row - 1 == -1;
                outOfMapLeft = column - 1 == -1;
                outOfMapBottom = row + 1 == 15;
                outOfMapRight = column + 1 == 15;
                if (areaMatrix[row][column].getOwnerId() == 9) {
                    System.out.println();
                    switch (where) {
                        case "w":
                            if (outOfMapTop) {
                                System.out.println(outOfMapError);
                            } else {
                                if (areaMatrix[row - 1][column].isReserved()) {
                                    System.out.println(reservedError);
                                } else {
                                    if (areaMatrix[row - 1][column].isContainPaper()) {
                                        System.out.println(paperBeenFound);
                                        this.remainingPaperNumber--;
                                        listenPaperChanges(this.remainingPaperNumber);
                                        changeSlendermanPosition(this.remainingPaperNumber);
                                    }
                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row - 1][column].setOwnerId(9);
                                    areaMatrix[row - 1][column].setReserved(true);
                                    this.setLastDirection("w");
                                }
                            }
                            break;
                        case "a":
                            if (outOfMapLeft) {
                                System.out.println(outOfMapError);
                            } else {
                                if (areaMatrix[row][column - 1].isReserved()) {
                                    System.out.println(reservedError);
                                } else {
                                    if (areaMatrix[row][column - 1].isContainPaper()) {
                                        System.out.println(paperBeenFound);
                                        this.remainingPaperNumber--;
                                        listenPaperChanges(this.remainingPaperNumber);
                                        changeSlendermanPosition(this.remainingPaperNumber);
                                    }
                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row][column - 1].setOwnerId(9);
                                    areaMatrix[row][column - 1].setReserved(true);
                                    this.setLastDirection("a");
                                }
                            }
                            break;
                        case "s":
                            if (outOfMapBottom) {
                                System.out.println(outOfMapError);
                            } else {
                                if (areaMatrix[row + 1][column].isReserved()) {
                                    System.out.println(reservedError);
                                } else {
                                    if (areaMatrix[row + 1][column].isContainPaper()) {
                                        System.out.println(paperBeenFound);
                                        this.remainingPaperNumber--;
                                        listenPaperChanges(this.remainingPaperNumber);
                                        changeSlendermanPosition(this.remainingPaperNumber);
                                    }
                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row + 1][column].setOwnerId(9);
                                    areaMatrix[row + 1][column].setReserved(true);
                                    this.setLastDirection("s");
                                }
                            }
                            break;
                        case "d":
                            if (outOfMapRight) {
                                System.out.println(outOfMapError);
                            } else {
                                if (areaMatrix[row][column + 1].isReserved()) {
                                    System.out.println(reservedError);
                                } else {
                                    if (areaMatrix[row][column + 1].isContainPaper()) {
                                        System.out.println(paperBeenFound);
                                        this.remainingPaperNumber--;
                                        listenPaperChanges(this.remainingPaperNumber);
                                        changeSlendermanPosition(this.remainingPaperNumber);
                                    }
                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row][column + 1].setOwnerId(9);
                                    areaMatrix[row][column + 1].setReserved(true);
                                    this.setLastDirection("d");
                                }
                            }
                            break;
                    }
                    return;
                }
            }
        }
    }

    public void listenPaperChanges(int remainingPaperNumber) {
        switch (remainingPaperNumber) {
            case 7:
                System.out.println(
                        "Mintha valami fénylene a zseblámpalámpa fényében..." +
                        "\nEgy tépet füzetlap, rajta nagy betűkkel írva: SEGÍTSÉG!!!" +
                        "\nKi hagyta ezt itt?"
                );
                break;
            case 6:
                System.out.println("Egy újabb lap, ezen az áll: HAGYJ EGYEDÜL! ");
                break;
            case 5:
                System.out.println(
                        "A távoli bozótban ismét ott egy papírlap." +
                        "\nNE NÉZZ HÁTRA, KÜLÖNBEN ELVISZ!" +
                        "\nMik ezek? Ez annyira nem vicces..."
                );
                break;
            case 4:
                System.out.println("Hirtelen a ez erdő még némábbnak tűnt mint eddig volt, de most valami megváltozott. " +
                        "\nKözeledik..." +
                        "\nFIGYEL TÉGED!");
                break;
            case 3:
                System.out.println(
                        "Na jól van most már elég...egy újabb lap." +
                        "\nEz áll rajta: KÖVETNEK!"
                );
                break;
            case 2:
                System.out.println("NE NÉZZ HÁTRA!!!");
                break;
            case 1:
                System.out.println("TAl\n\táN it\nT A v\tégE ??");
                break;
        }
    }

    //TODO: FIX
    public void changeSlendermanPosition(int remainingPaperNumber) {

        Field slendermanPosition = getSlendermanActualPosition(this.getAreaMatrix());
        Field playerPosition = getPlayerActualPosition(this.getAreaMatrix());
        int random;
        int random2;
        if (remainingPaperNumber == 8 || remainingPaperNumber == 7) {

            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new EmptyField());
            random = ThreadLocalRandom.current().nextInt(5, 14 + 1);
            random2 = ThreadLocalRandom.current().nextInt(5, 14 + 1);
            slendermanPosition.setRow(random);
            slendermanPosition.setColumn(random2);
            if (
                    playerPosition.getRow() == slendermanPosition.getRow() &&
                    playerPosition.getColumn() == slendermanPosition.getColumn()
            ) {
                this.areyouWon = false;
                this.remainingPaperNumber = 0;
            }
            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new SlenderMan());


        } else if (remainingPaperNumber == 6 || remainingPaperNumber == 5) {

            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new EmptyField());
            random = ThreadLocalRandom.current().nextInt(0, 5 + 1);
            random2 = ThreadLocalRandom.current().nextInt(0, 5 + 1);
            slendermanPosition.setRow(random);
            slendermanPosition.setColumn(random2);
            if (
                    playerPosition.getRow() == slendermanPosition.getRow() &&
                            playerPosition.getColumn() == slendermanPosition.getColumn()
            ) {
                this.areyouWon = false;
                this.remainingPaperNumber = 0;
            }
            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new SlenderMan());


        } else if (remainingPaperNumber == 4 || remainingPaperNumber == 3) {

            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new EmptyField());
            random = ThreadLocalRandom.current().nextInt(0, 4 + 1);
            random2 = ThreadLocalRandom.current().nextInt(0, 4 + 1);
            slendermanPosition.setRow(random);
            slendermanPosition.setColumn(random2);
            if (
                    playerPosition.getRow() == slendermanPosition.getRow() &&
                            playerPosition.getColumn() == slendermanPosition.getColumn()
            ) {
                this.areyouWon = false;
                this.remainingPaperNumber = 0;
            }
            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new SlenderMan());


        } else if (remainingPaperNumber == 1 || remainingPaperNumber == 2) {

            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new EmptyField());
            random = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            random2 = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            slendermanPosition.setRow(random);
            slendermanPosition.setColumn(random2);
            if (
                    playerPosition.getRow() == slendermanPosition.getRow() &&
                    playerPosition.getColumn() == slendermanPosition.getColumn()
            ) {
                this.areyouWon = false;
                this.remainingPaperNumber = 0;
            }
            this.areaMatrix[slendermanPosition.getRow()][slendermanPosition.getColumn()] =
                    new Field(slendermanPosition.getRow(), slendermanPosition.getColumn(), new SlenderMan());

        }
    }
}
