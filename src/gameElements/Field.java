package gameElements;

import fieldElements.FieldElement;

/**
 * Field osztály
 *
 * Adattagjai:
 *
 * - row : int
 *  > Adott sor a mátrixban
 *
 * - column : int
 *  > Adott oszlop a mátrixban
 *
 * - isReserved : boolean
 *  > Foglalt-e a mező
 *
 * - containPaper : boolean
 *  > Tartalmaz-e az adott mező papírt
 *
 * - ownerId : int
 *  > Mező tulajdonosa
 *
 * - elementOnTop : FieldElement
 * > Mezőn lévő tulajdonos
 *
 * Feladat:
 *
 * @see GameMap
 * - A GameMap osztályban található areaMatrix adattag felépítő eleme
 * - A teljes pálya alapja
 * - Tartalmazza és kezeli a helyszíni adatokat
 */
public class Field {

    private int row;
    private int column;
    private boolean isReserved;
    private boolean containPaper;
    private int ownerId;
    private FieldElement elementOnTop;

    /**
     * Field konstruktor
     *
     * @param row : int
     * @param column : int
     * @param elementOnTop : FieldElement
     *
     * Feladat:
     *
     * - Értéket ad az osztály adattagjainak
     */
    public Field(int row, int column, FieldElement elementOnTop) {

        this.row = row;
        this.column = column;
        this.elementOnTop = elementOnTop;
        this.isReserved = !this.elementOnTop.isInteroperable;
        this.containPaper = false;
        this.ownerId = this.elementOnTop.id;
    }

    /**
     * Getter és Setter típusú függvények
     *
     * Feladat:
     *
     * - Általános get/set funkció
     * */
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public boolean isContainPaper() {
        return containPaper;
    }

    public void setContainPaper(boolean containPaper) {
        this.containPaper = containPaper;
    }

    public FieldElement getElementOnTop() {
        return elementOnTop;
    }


    /**
     * toString
     *
     * @return Tulajdonos id : String
     *
     * Feladat:
     *
     * - Osztály kiíratásakor az ownerId kiíratása
     */
    @Override
    public String toString() {

        return "" + this.ownerId;

    }
}
