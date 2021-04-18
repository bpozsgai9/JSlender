package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * Truck osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class Truck extends FieldElement {

    /**
     * Truck konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public Truck() {
        super(5, true, true);
    }
}
