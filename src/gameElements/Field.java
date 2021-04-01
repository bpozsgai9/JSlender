package gameElements;

import fieldElements.FieldElement;

public class Field {

    private int row;
    private int column;
    private boolean isReserved;
    private boolean canContainPaper;
    private int ownerId;

    public Field(int row, int column, FieldElement element) {

        this.row = row;
        this.column = column;
        this.isReserved = !element.isInteroperable;
        this.canContainPaper = element.canContainPaper;
        this.ownerId = element.id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {

        return "" + this.ownerId;

    }
}
