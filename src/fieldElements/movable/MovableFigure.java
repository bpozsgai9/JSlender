package fieldElements.movable;

import gameElements.Field;

public abstract class MovableFigure {

    private int id;
    private Field position;

    public MovableFigure(int id, Field position) {
        this.id = id;
        this.position = position;
    }

    public void reserveField(Field reservable) {

    }

    public void freeField(Field freeable) {

    }

    public abstract void move(Field from, Field to);
}
