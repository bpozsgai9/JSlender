package fieldElements.stable;

import fieldElements.FieldElement;
import gameElements.Field;

public class FieldObject extends FieldElement {

    protected boolean canContainPaper;
    protected boolean isInteroperable;

    public FieldObject(int id, boolean canContainPaper, boolean isInteroperable) {
        super(id);
    }
}
