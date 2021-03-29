package fieldElements.movable;

import gameElements.Field;

public class SlenderMan extends MovableFigure {

    public SlenderMan(int id, Field position) {
        super(8, position);
    }

    @Override
    public void move(Field from, Field to) {
        //teleportálás
    }
}
