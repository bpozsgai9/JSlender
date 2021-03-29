package gameElements;

public class Field {

    private int row;
    private int column;
    private boolean isReserved;
    private int ownerId;

    public Field(int row, int column, boolean isReserved, int ownerId) {

        this.row = row;
        this.column = column;
        this.isReserved = isReserved;
        this.ownerId = ownerId;
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

        String back = "" + this.ownerId;

        return back;

    }
}
