/**
 * 
 * @author Yosra Alim
 * @version 1.0
 * @since June 29th, 2023
 * 
 * 
 * The Player class represents a player in the Bridge Builder game.
 * The player has a score that is calculated based on the game board and grid size.
 * The player can make a move on the game board by marking a position with a '+' symbol.
 * The player's score is determined by different bridge formations on the game board.
 * 
 */




package BridgeBuilderAdv;

public class Player {
    private int score;

    public Player() {
        this.score = 0;
    }

    
    
    
    /**
     * Makes a move on the game board by marking the specified position with a '+' symbol.
     * 
     * @param gameBoard the game board on which the move is made
     * @param row the row index of the position
     * @param col the column index of the position
     */
    public void makeMove(GameBoard gameBoard, int row, int col) {
        gameBoard.placeToken(row, col, '+');
    }

    
    
    
    /**
     * Calculates the player's score based on the game board and grid size.
     * The score is updated according to different bridge formations on the game board.
     * 
     * @param gameBoard the game board used for score calculation
     * @param gridSize the size of the grid
     */
    public void calculateScore(GameBoard gameBoard, int gridSize) {
        if (gameBoard.isBoardFull()) {
            score += 1; // Tie
        } else {
            char token = gameBoard.getTokenAtPosition(gridSize - 1, gridSize - 1);
            if (token == '+') {
                score += 5; // Left to Right bridge
            } else if (token == '0') {
                score = 0; // Engineer completed their bridge, player loses
            } else if (isBottomToTopBridge(gameBoard)) {
                score += 7; // Bottom to Top bridge
            } else if (isDiagonalBridge(gameBoard)) {
                score += 10; // Top left to bottom right diagonal bridge
            }
            // Add bonus points for grid size larger than 3x3
            if (gridSize > 3) {
                score += gridSize - 3;
            }
        }
    }

    
    
    
    /**
     * Checks if there is a bottom to top bridge formation on the game board.
     * 
     * @param gameBoard the game board to check
     * @return true if a bottom to top bridge is found, false otherwise
     */
    private boolean isBottomToTopBridge(GameBoard gameBoard) {
        for (int col = 0; col < gameBoard.getSize(); col++) {
            if (gameBoard.getTokenAtPosition(0, col) != '+') {
                return false;
            }
        }
        return true;
    }

    
    
    
    /**
     * Checks if there is a top left to bottom right diagonal bridge formation on the game board.
     * 
     * @param gameBoard the game board to check
     * @return true if a diagonal bridge is found, false otherwise
     */
    private boolean isDiagonalBridge(GameBoard gameBoard) {
        for (int row = 0; row < gameBoard.getSize(); row++) {
            if (gameBoard.getTokenAtPosition(row, row) != '+') {
                return false;
            }
        }
        return true;
    }

    
    
    // Get the player's score
    public int getScore() {
        return score;
    }

    
    // Add points to the player's score
    public void addScore(int points) {
        score += points;
    }
}


