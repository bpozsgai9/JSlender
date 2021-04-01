package fieldElements.movable;

import gameElements.Field;

public class SlenderMan extends MovableFigure {

    public SlenderMan(Field position) {
        super(8, false, false, position);
    }

    @Override
    public void move(Field from, Field to) {
        //teleportálás
    }
}
