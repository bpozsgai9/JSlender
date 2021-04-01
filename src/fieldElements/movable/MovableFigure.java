package fieldElements.movable;

import fieldElements.FieldElement;
import gameElements.Field;

public abstract class MovableFigure extends FieldElement {

    private Field position;

    public MovableFigure(int id, boolean canContainPaper, boolean isInteroperable, Field position) {
        super(id, canContainPaper, isInteroperable);
        this.position = position;
    }

    public void reserveField(Field reservable) {

    }

    public void freeField(Field freeable) {

    }

    public abstract void move(Field from, Field to);
}
