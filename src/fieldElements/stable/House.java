package fieldElements.stable;

import gameElements.Field;

public class House extends FieldObject {

    public House(int id, boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(id, containsPaper, isInteroperable, reservedFieldArray);
    }
}
