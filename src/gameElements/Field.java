package gameElements;

import fieldElements.FieldElement;

public class Field {

    private int row;
    private int column;
    private boolean isReserved;
    private boolean containPaper;
    private int ownerId;
    private FieldElement elementOnTop;

    public Field(int row, int column, FieldElement elementOnTop) {

        this.row = row;
        this.column = column;
        this.elementOnTop = elementOnTop;
        this.isReserved = !this.elementOnTop.isInteroperable;
        this.containPaper = false;
        this.ownerId = this.elementOnTop.id;
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

    public boolean isContainPaper() {
        return containPaper;
    }

    public void setContainPaper(boolean containPaper) {
        this.containPaper = containPaper;
    }

    public FieldElement getElementOnTop() {
        return elementOnTop;
    }

    @Override
    public String toString() {

        return "" + this.ownerId;

    }
}
