package fieldElements.stable;

import gameElements.Field;

public class Rock extends FieldObject {

    public Rock(int id, boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(id, containsPaper, isInteroperable, reservedFieldArray);
    }
}
