package fieldElements.stable;

import gameElements.Field;

public class House extends FieldObject {

    public House(boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(3, containsPaper, isInteroperable, reservedFieldArray);
    }
}
