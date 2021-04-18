package fieldElements.stable;

import fieldElements.FieldElement;

/**
 * EmptyField osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class EmptyField extends FieldElement {

    /**
     * EmptyField konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public EmptyField() {
        super(0, true, true);
    }
}
