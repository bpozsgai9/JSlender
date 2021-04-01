package fieldElements.movable;

import gameElements.Field;

public class Player extends MovableFigure {

    public Player(Field position) {
        super(9, false, false, position);
    }

    @Override
    public void move(Field from, Field to) {
        //lépés
    }
}
