/**
 * 
 * @author Yosra Alim
 * @version 1.0
 * @since June 29th, 2023
 * 
*/


package BridgeBuilderAdv;


/**
 * Represents a game board for the Bridge Builder game.
 */
public class GameBoard {
    private char[][] board;
    private int size;

    
    
    /**
     * Constructs a game board of the specified size.
     *
     * @param size The size of the game board.
     */
    public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    
    
    /**
     * Initializes the game board with empty positions.
     */
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
    }

    
    
    /**
     * Places a token at the specified position on the game board.
     *
     * @param row   The row index of the position.
     * @param col   The column index of the position.
     * @param token The token to be placed.
     */
    public void placeToken(int row, int col, char token) {
        board[row][col] = token;
    }

    
    
    /**
     * Displays the current state of the game board.
     */
    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    
    
    /**
     * Checks if the game board is full.
     *
     * @return {@code true} if the game board is full, {@code false} otherwise.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    
    
    
    /**
     * Checks if the specified position on the game board is empty.
     *
     * @param row The row index of the position.
     * @param col The column index of the position.
     * @return {@code true} if the position is empty, {@code false} otherwise.
     */
    public boolean isPositionEmpty(int row, int col) {
        return board[row][col] == '.';
    }

    
    
    
    /**
     * Retrieves the token at the specified position on the game board.
     *
     * @param row The row index of the position.
     * @param col The column index of the position.
     * @return The token at the specified position.
     */
    public char getTokenAtPosition(int row, int col) {
        return board[row][col];
    }

    
    
    
    /**
     * Gets the size of the game board.
     *
     * @return The size of the game board.
     */
    public int getSize() {
        return size;
    }

    
    
    public int checkForWinDirection(Player player) {
        // Check for left to right bridge
        for (int row = 0; row < size; row++) {
            if (board[row][0] == '+') {
                int col = 1;
                while (col < size && board[row][col] == '+') {
                    col++;
                }
                if (col == size) {
                    return 1; // Left to right bridge
                }
            }
        }

        
        // Check for bottom to top bridge
        for (int col = 0; col < size; col++) {
            if (board[size - 1][col] == '+') {
                int row = size - 2;
                while (row >= 0 && board[row][col] == '+') {
                    row--;
                }
                if (row == -1) {
                    return 2; // Bottom to top bridge
                }
            }
        }

        
        // Check for top left to bottom right diagonal bridge
        if (board[0][0] == '+') {
            int row = 1;
            int col = 1;
            while (row < size && col < size && board[row][col] == '+') {
                row++;
                col++;
            }
            if (row == size && col == size) {
                return 3; // Top left to bottom right diagonal bridge
            }
        }

        return 0; // No bridge found
    }

    
    public boolean checkForTie() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '.')

                {
                	return false; // Found an empty position, not a tie
                	}
                	}
                	}
                	return true; // All positions are filled, it's a tie
                	}
                	}             	
                	
                	
                	
                	