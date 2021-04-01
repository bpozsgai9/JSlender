package fieldElements.stable;

import gameElements.Field;

public class Barrel extends FieldObject {

    public Barrel(boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(7, containsPaper, isInteroperable, reservedFieldArray);
    }
}
