package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * House osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class House extends FieldElement {

    /**
     * House konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public House() {
        super(3, true, false);
    }
}
