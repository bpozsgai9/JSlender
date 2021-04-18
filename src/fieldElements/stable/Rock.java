package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * Rock osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class Rock extends FieldElement {

    /**
     * Rock konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public Rock() {
        super(6, true, true);
    }
}
