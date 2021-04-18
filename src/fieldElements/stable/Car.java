package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * Car osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class Car extends FieldElement {

    /**
     * Car konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public Car() {
        super(4, true, true);
    }
}
