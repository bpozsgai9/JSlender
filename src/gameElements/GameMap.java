package gameElements;

import java.util.Scanner;

public class GameMap {

    private int remainingPaperNumber;
    private Field areaMatrix [][];
    private String lastDirection;

    public GameMap() {

        this.remainingPaperNumber = 8;
        this.areaMatrix = new Field[15][15];
        this.lastDirection = "w";
        generateMap(this.areaMatrix);
        printMap(this.areaMatrix);
        System.out.println(
                "\nA holdfény alig szűrődött a sűrű lombos fákon keresztül, az erdő sötét volt és magányos." +
                "\nA távolból csak némi moraj hallatszott a csenden túl, a szél susogása, a levelek zaja..."
        );
        System.out.println("\nFennmaradó papírok száma: " + this.remainingPaperNumber);
    }

    public int getRemainingPaperNumber() {
        return remainingPaperNumber;
    }

    public void setRemainingPaperNumber(int remainingPaperNumber) {
        this.remainingPaperNumber = remainingPaperNumber;
    }

    public Field[][] getAreaMatrix() {
        return areaMatrix;
    }

    public void setAreaMatrix(Field[][] areaMatrix) {
        this.areaMatrix = areaMatrix;
    }

    public String getLastDirection() { return lastDirection; }

    public void setLastDirection(String lastDirection) { this.lastDirection = lastDirection; }

    public Field getPlayerActualPosition(Field [][] areaMatrix) {
        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {
                if (areaMatrix[row][column].getOwnerId() == 9) {
                    return areaMatrix[row][column];
                }
            }
        }
        return null;
    }

    private void generateMap(Field [][] areaMatrix) {

        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {
                areaMatrix[row][column] = new Field(row, column, false, 0);
            }
        }

        //kiinduló helyzet
        //kis méretű fa
        areaMatrix[0][11] = new Field(0, 11,true, 1);
        areaMatrix[1][3] = new Field(1, 3,true, 1);
        areaMatrix[1][13] = new Field(1, 13,true, 1);
        areaMatrix[4][0] = new Field(4, 0,true, 1);
        areaMatrix[5][7] = new Field(5, 7,true, 1);
        areaMatrix[5][14] = new Field(5, 14,true, 1);
        areaMatrix[10][2] = new Field(10, 2,true, 1);
        areaMatrix[12][4] = new Field(12, 4,true, 1);
        areaMatrix[12][12] = new Field(12, 12,true, 1);
        areaMatrix[13][12] = new Field(13, 12,true, 1);

        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {
                if (
                    //nagy méretű fa
                    row > 12 && row <= 14 && column >= 0 && column < 2 ||
                    row > 9 && row < 12 && column > 4 && column < 7 ||
                    row > 8 && row < 11 && column > 12 && column <= 14
                ) {
                    areaMatrix[row][column] = new Field(row, column,true, 2);
                } else if (
                    //ház
                    row > 1 && row < 9 && column > 7 && column < 14
                ) {
                    areaMatrix[row][column] = new Field(row, column,true, 3);
                } else if (
                        //autó
                        row >= 0 && row < 2 && column > 5 && column < 9  ||
                        row > 6 && row < 10 && column > 5 &&column < 8
                ) {
                    areaMatrix[row][column] = new Field(row, column, true, 4);
                } else if (
                        //teherautó
                        row > 9 && row <= 14 && column > 8 && column < 12
                ) {
                    areaMatrix[row][column] = new Field(row, column,true, 5);
                } else if (
                        //szikla
                        row >= 0 && row < 3 && column >= 0 && column < 3 ||
                        row > 6 && row < 10 && column >= 0 && column < 3
                ) {
                    areaMatrix[row][column] = new Field(row, column,true, 6);
                } else if (
                        //hordó
                        row > 2 && row < 5 && column > 2 && column < 7
                ) {
                    areaMatrix[row][column] = new Field(row, column,true, 7);
                }
            }
        }

        //slenderman
        areaMatrix[4][1] = new Field(4, 1,true, 8);

        //játékos
        areaMatrix[9][4] = new Field(9, 4,true, 9);
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
        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {

                w = areaMatrix[row][column].getOwnerId() == actualPosition.getOwnerId() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 1 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 1;

                a = areaMatrix[row][column].getOwnerId() == actualPosition.getOwnerId() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 1 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 2 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 2 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 2;

                s = areaMatrix[row][column].getOwnerId() == actualPosition.getOwnerId() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() - 1 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 2 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 1;

                d = areaMatrix[row][column].getOwnerId() == actualPosition.getOwnerId() ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 1 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 2 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() - 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 2 ||
                    areaMatrix[row][column].getRow() == actualPosition.getRow() + 1 && areaMatrix[row][column].getColumn() == actualPosition.getColumn() + 2;

                switch (this.getLastDirection()) {
                    case "w": actual = w; break;
                    case "a": actual = a; break;
                    case "s": actual = s; break;
                    case "d": actual = d; break;
                }
                if (actual) {
                    System.out.print(areaMatrix[row][column] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public void controlUnder(Field [][] areaMatrix) {

        System.out.println("A te játékosod azonosítója: [9]");
        System.out.println("Merre szeretnél lépni?");
        System.out.println("\tw - felfele\n\ta - balra\n\ts - lefele\n\td - jobbra");
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

        boolean outOfMapTop;
        boolean outOfMapLeft;
        boolean outOfMapBottom;
        boolean outOfMapRight;
        for (int row = 0; row < areaMatrix.length; row++) {
            for (int column = 0; column < areaMatrix[row].length; column++) {

                //TODO: befejezi a térképről való lelépést
                //outOfMap = row - 1 == -1 || row + 1 == 15 || column - 1 == -1 || column + 1 == 15;
                outOfMapTop = row - 1 == -1;
                outOfMapLeft = column - 1 == -1;
                outOfMapBottom = row + 1 == 15;
                outOfMapRight = column + 1 == 15;
                if (areaMatrix[row][column].getOwnerId() == 9) {
                    System.out.println();
                    switch (where) {
                        case "w":
                            if (!outOfMapTop) {
                                if (!(areaMatrix[row - 1][column].isReserved())) {

                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row - 1][column].setOwnerId(9);
                                    areaMatrix[row - 1][column].setReserved(true);
                                    this.setLastDirection("w");
                                } else {
                                    System.out.println(reservedError);
                                }
                            } else {
                                System.out.println(outOfMapError);
                            }
                        break;
                        case "a":
                            if (!outOfMapLeft) {
                                if (!(areaMatrix[row][column - 1].isReserved())) {

                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row][column - 1].setOwnerId(9);
                                    areaMatrix[row][column - 1].setReserved(true);
                                    this.setLastDirection("a");
                                } else {
                                    System.out.println(reservedError);
                                }
                            } else {
                                System.out.println(outOfMapError);
                            }
                        break;
                        case "s":
                            if (!outOfMapBottom) {
                                if (!(areaMatrix[row + 1][column].isReserved())) {

                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row + 1][column].setOwnerId(9);
                                    areaMatrix[row + 1][column].setReserved(true);
                                    this.setLastDirection("s");
                                } else {
                                    System.out.println(reservedError);
                                }
                            } else {
                                System.out.println(outOfMapError);
                            }
                        break;
                        case "d":
                            if (!outOfMapRight) {
                                if (!(areaMatrix[row][column + 1].isReserved())) {

                                    areaMatrix[row][column].setOwnerId(0);
                                    areaMatrix[row][column].setReserved(false);
                                    areaMatrix[row][column + 1].setOwnerId(9);
                                    areaMatrix[row][column + 1].setReserved(true);
                                    this.setLastDirection("d");
                                } else {
                                    System.out.println(reservedError);
                                }
                            } else {
                                System.out.println(outOfMapError);
                            }
                        break;
                    }
                    return;
                }
            }
        }
    }
}
