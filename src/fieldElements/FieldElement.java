package fieldElements;

/**
 * FieldElement osztály
 *
 * Adattagjai:
 *
 * -
 *
 * Feladat:
 *
 * -
 */
public class FieldElement {

    public int id;
    public boolean canContainPaper;
    public boolean isInteroperable;

    public FieldElement(int id, boolean canContainPaper, boolean isInteroperable) {
        this.id = id;
        this.canContainPaper = canContainPaper;
        this.isInteroperable = isInteroperable;
    }
}
