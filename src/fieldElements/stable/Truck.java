package fieldElements.stable;

import gameElements.Field;

public class Truck extends FieldObject {

    public Truck(boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(5, containsPaper, isInteroperable, reservedFieldArray);
    }
}
