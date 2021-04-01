package fieldElements.stable;

import gameElements.Field;

public class Car extends FieldObject {

    public Car(boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        super(4, containsPaper, isInteroperable, reservedFieldArray);
    }
}
