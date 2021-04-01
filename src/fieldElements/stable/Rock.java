package fieldElements.stable;

import gameElements.Field;

public class Rock extends FieldObject {

    public Rock(boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(6, containsPaper, isInteroperable, reservedFieldArray);
    }
}
