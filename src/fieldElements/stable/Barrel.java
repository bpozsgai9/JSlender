package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * Barrel osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class Barrel extends FieldElement {

    /**
     * Barrel konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public Barrel() {
        super(7, true, true);
    }
}
