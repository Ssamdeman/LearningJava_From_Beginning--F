package pa3;

/**
 * Skeleton Class for a Path in the Dynamic Programming sequence alignment algorithm
 */


public class Path {
    private int row, col;          // the row and column this node represents
    private int cost;              // the matching cost from this point on
    private Path next;             // the next node in the optimal path


    public Path() {
    }

    public Path(int cost, int row, int col) {
        this.cost = cost;
        this.row = row;
        this.col = col;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int c) {
        this.cost = c;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int c) {
        this.col = c;
    }

    public Path getNext() {
        return next;
    }

    public void setNext(Path p) {
        this.next = p;
    }


}
