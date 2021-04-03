package fieldElements.movable;

import fieldElements.FieldElement;
import gameElements.Field;

public abstract class MovableFigure extends FieldElement {

    private Field position;
    protected boolean canContainPaper;
    protected boolean isInteroperable;

    public MovableFigure(int id, boolean canContainPaper, boolean isInteroperable) {
        super(id);
    }

    public void reserveField(Field reservable) {

    }

    public void freeField(Field freeable) {

    }

    public abstract void move(Field from, Field to);
}
