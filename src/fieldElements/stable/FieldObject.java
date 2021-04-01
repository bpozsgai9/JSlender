package fieldElements.stable;

import fieldElements.FieldElement;
import gameElements.Field;

public class FieldObject extends FieldElement {

    public Field[][] reservedFieldArray;

    public FieldObject(int id, boolean canContainPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(id, canContainPaper, isInteroperable);
        this.reservedFieldArray = reservedFieldArray;
    }
}
