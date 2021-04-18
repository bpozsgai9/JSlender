package fieldElements;

/**
 * FieldElement osztály
 *
 * Adattagjai:
 *
 * - id : int
 * > Tulajdonos azonosítója
 *
 * - canContainPaper
 *  > Tartalmazhat-e papírt
 *
 * - isInteroperable
 * > Átjárahtó-e
 *
 * Feladat:
 *
 * - A pályán jelenlevő objektumok parent osztálya, ebből származnak le a játékosok és a tereptárgyak is
 */
public class FieldElement {

    public int id;
    public boolean canContainPaper;
    public boolean isInteroperable;

    /**
     * FieldElement konstruktor
     *
     * @param id : int
     * @param canContainPaper : boolean
     * @param isInteroperable : boolean
     *
     * Feladat:
     *
     * - Osztályban jelenelvő adattagok értékadása
     */
    public FieldElement(int id, boolean canContainPaper, boolean isInteroperable) {
        this.id = id;
        this.canContainPaper = canContainPaper;
        this.isInteroperable = isInteroperable;
    }
}
