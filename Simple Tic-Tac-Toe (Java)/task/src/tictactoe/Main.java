package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = "_________";
        displayGrid(input);


        boolean xTurn = true;
// Prompt the user to make a move
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                int index = (3 - x) * 3 + y - 1;

                if (input.charAt(index) != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                input = input.substring(0, index) + (xTurn ? 'X' : 'O') + input.substring(index + 1);
                displayGrid(input);

                String gameState = analyzeGameState(input);
                if (gameState.equals("X wins") || gameState.equals("O wins") || gameState.equals("Draw")) {
                    printGameState(gameState);
                    break;
                }

                xTurn = !xTurn;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    public static void displayGrid(String symbols) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char symbol = symbols.charAt(i * 3 + j);
                System.out.print(symbol + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static String analyzeGameState(String symbols) {
        int countX = 0;
        int countO = 0;
        int countEmpty = 0;
        boolean xWins = false;
        boolean oWins = false;

        // Count X, O, and empty cells
        for (int i = 0; i < 9; i++) {
            char symbol = symbols.charAt(i);
            if (symbol == 'X') {
                countX++;
            } else if (symbol == 'O') {
                countO++;
            } else if (symbol == '_') {
                countEmpty++;
            }
        }

        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (symbols.charAt(i * 3) == symbols.charAt(i * 3 + 1) && symbols.charAt(i * 3) == symbols.charAt(i * 3 + 2)) {
                if (symbols.charAt(i * 3) == 'X') {
                    xWins = true;
                } else if (symbols.charAt(i * 3) == 'O') {
                    oWins = true;
                }
            }

            // Check columns
            if (symbols.charAt(i) == symbols.charAt(i + 3) && symbols.charAt(i) == symbols.charAt(i + 6)) {
                if (symbols.charAt(i) == 'X') {
                    xWins = true;
                } else if (symbols.charAt(i) == 'O') {
                    oWins = true;
                }
            }
        }

        // Check diagonals
        if ((symbols.charAt(0) == symbols.charAt(4) && symbols.charAt(0) == symbols.charAt(8)) ||
                (symbols.charAt(2) == symbols.charAt(4) && symbols.charAt(2) == symbols.charAt(6))) {
            if (symbols.charAt(4) == 'X') {
                xWins = true;
            } else if (symbols.charAt(4) == 'O') {
                oWins = true;
            }
        }

        // Analyze the game state
        if (xWins && oWins || Math.abs(countX - countO) > 1) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (countEmpty > 0) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    public static void printGameState(String result) {
        System.out.println(result);
    }
}