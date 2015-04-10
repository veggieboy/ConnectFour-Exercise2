public class BoardBase {
    
    // constants to track player's checkers on the boark
    public static final char 
        MARK_RED = 'X',   // black checker
        MARK_BLACK = 'O', // red checker
        UNMARKED = ' ',   // unoccupied cell
        MARK_PINK = 'P',  // winning red checkers
        MARK_GRAY = 'G';  // winning black checkers
    
    // constants to display plyer
    public static final String 
        RED = "Red", 
        BLACK = "Black";
    
    // constants to control board size - VERY HELPFUL in for loops
    public static final int 
        ROWS = 6, 
        COLUMNS = 7;
    
    // used to compute heuristic values to determine next best move
    public static final int[] INCREMENT = {0, 1, 4, 32, 128, 512}; 
    
    // the game board
    protected final char[][] board;
    
    // used to track move numbers (SAME SIZE AS BOARD)
    protected final int[][] moveNumbers;
    
    // used to track the the first unoccupied row in each column
    protected final int[] firstAvailableRow;
    
    // used to swap the colors to display the winning checkers - size should be ???
    protected final Cell[] winningCells;
    
    // flags to determine the winner
    protected boolean 
        winnerFound, 
        redWinFound, 
        blackWinFound;
    
    // a counter to track the number of moves
    protected int moveNumber;
    
    /** CONSTRUCTOR
     * Initilize board, moveNumbers, firstAvailableRow and winningCells
     * call the reset method
     * */
    public BoardBase() {
        
        
        
    }
    
    /** Used to reset the the board and other variables between games
     * set each element in board to UNMARKED and each element in moveNumbers to 0
     * set each element of firstAvailableRow to ROWS - 1
     * set each element of winningCells to new Cell(0, 0)
     * set winnerFound to false
     * set moveNumber to 1
     * */
    public void reset() {

        
        
        
        
        
        
    }
    
    /** Returns a copy of the board
     *  create a new 2-D array the same size as the board
     *  copy each element from board into the new copy
     *  return the new copy
     * */
    public char[][] getGrid() {

        
        
    }
    
    public boolean isColumnAvailable(int column) {
        return firstAvailableRow[column] != -1;
    }
    
    public int getFirstAvailableRow(int column) {
        return firstAvailableRow[column];
    }
    
    public char get(int row, int column) {
        return board[row][column];
    }
    
    public void display() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("|" + board[row][col]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }
    
    public int mark(int col, char mark) throws IllegalArgumentException {
        int row = firstAvailableRow[col];
        if (row < 0) {
            throw new IllegalArgumentException(
              "Column " + (col + 1) + " is already full.");
        }
        board[row][col] = mark;
        --firstAvailableRow[col];
        return row;
    }
    
    public void set(int col, char mark) throws IllegalArgumentException {
        int row = mark(col, mark);
        moveNumbers[row][col] = moveNumber++;
    }
    
    public void unset(int col) throws IllegalArgumentException {
        int row = firstAvailableRow[col];
        if (row >= ROWS) {
            throw new IllegalArgumentException(
               "Column " + (col + 1) + " is already empty.");
        }
        row = ++firstAvailableRow[col];
        board[row][col] = UNMARKED;
    }
    
    public static String getColorOfPlayer(char player)
        throws IllegalArgumentException {
        
        if (player == MARK_RED) {
            return RED;
        } else if (player == MARK_BLACK) {
            return BLACK;
        } else {
            throw new IllegalArgumentException(
               "Unknown player " + player + " received.");
        }
    }
    
}
