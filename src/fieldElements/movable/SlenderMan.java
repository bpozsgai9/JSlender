package fieldElements.movable;

import fieldElements.FieldElement;

/**
 * SlenderMan osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class SlenderMan extends FieldElement {

    /**
     * SlenderMan konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public SlenderMan() {
        super(8, false, true);
    }

}
