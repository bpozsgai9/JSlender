package fieldElements.movable;

import fieldElements.FieldElement;

/**
 * Player osztály
 *
 * Feladat:
 *
 * @see FieldElement
 * - FieldElement leszármazottja, egyedi értékek tárolása a játék helyes működéséhez
 */
public class Player extends FieldElement {

    /**
     * Player konstruktor
     *
     * Feladat:
     *
     * - Ősosztály konstruktorának meghívása, egyedi értékekkel
     */
    public Player() {
        super(9, false, false);
    }
}
