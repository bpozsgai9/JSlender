package fieldElements.stable;

import gameElements.Field;

public class FieldObject {

    public int id;
    public boolean containsPaper;
    public boolean isInteroperable;
    public Field[][] reservedFieldArray;

    public FieldObject(int id, boolean containsPaper, boolean isInteroperable, Field[][] reservedFieldArray) {
        this.id = id;
        this.containsPaper = containsPaper;
        this.isInteroperable = isInteroperable;
        this.reservedFieldArray = reservedFieldArray;
    }
}
