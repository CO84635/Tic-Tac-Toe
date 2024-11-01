package com.csc;

import java.util.Scanner;
import java.util.Random;

import static java.lang.Character.isDigit;

public class TicTacToe {

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public static void resetBoard(char[][] board){
        char count = '1';
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = count++;
            }
        }
    }

    public static void playerTurn(char[][] board, Scanner scanner, char playerSymbol) {
        String userInput;
        while (true) {
            if (playerSymbol == 'X') {
                System.out.print("Player one");
            } else if (playerSymbol == 'O') {
                System.out.print("Player two");
            }
            System.out.println(" - where would you like to move? (1-9)");
            userInput = scanner.nextLine();

            if (!userInput.matches("[1-9]")) {
                System.out.println("That move is invalid! Please choose a number between 1 and 9.");
                continue;
            }

            int position = Integer.parseInt(userInput);
            if (isValidMove(board, position)) {
                switch (position) {
                    case 1:
                        board[0][0] = playerSymbol;
                        break;
                    case 2:
                        board[0][1] = playerSymbol;
                        break;
                    case 3:
                        board[0][2] = playerSymbol;
                        break;
                    case 4:
                        board[1][0] = playerSymbol;
                        break;
                    case 5:
                        board[1][1] = playerSymbol;
                        break;
                    case 6:
                        board[1][2] = playerSymbol;
                        break;
                    case 7:
                        board[2][0] = playerSymbol;
                        break;
                    case 8:
                        board[2][1] = playerSymbol;
                        break;
                    case 9:
                        board[2][2] = playerSymbol;
                        break;
                }
                break;
            } else {
                System.out.println(userInput + " is not a valid move. Cell is already taken!");
            }
        }
    }

    public static void AiTurn(char[][] board, char aiSymbol) {
        Random rand = new Random();
        int position;

        while (true) {
            position= rand.nextInt(9) + 1;

            if (isValidMove(board, position)) {
                switch (position) {
                    case 1 -> board[0][0] = aiSymbol;
                    case 2 -> board[0][1] = aiSymbol;
                    case 3 -> board[0][2] = aiSymbol;
                    case 4 -> board[1][0] = aiSymbol;
                    case 5 -> board[1][1] = aiSymbol;
                    case 6 -> board[1][2] = aiSymbol;
                    case 7 -> board[2][0] = aiSymbol;
                    case 8 -> board[2][1] = aiSymbol;
                    case 9 -> board[2][2] = aiSymbol;
                }
                System.out.println("The computer player moved in space " + position +  ".");
                break;
            }
        }
    }

    public static boolean isValidMove(char[][] board, int position) {
        return switch (position) {
            case 1 -> (board[0][0] == '1');
            case 2 -> (board[0][1] == '2');
            case 3 -> (board[0][2] == '3');
            case 4 -> (board[1][0] == '4');
            case 5 -> (board[1][1] == '5');
            case 6 -> (board[1][2] == '6');
            case 7 -> (board[2][0] == '7');
            case 8 -> (board[2][1] == '8');
            case 9 -> (board[2][2] == '9');
            default -> false;
        };
    }

    public static boolean isGameFinished(char[][] board, String playerOneName, String playerTwoName) {
        if (hasPlayerWon(board, 'X')) {
            printBoard(board);
            System.out.println(playerOneName + " wins!");
            return true;
        }

        if (hasPlayerWon(board, 'O')) {
            printBoard(board);
            System.out.println(playerTwoName + " wins!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isDigit(board[i][j])) {
                    return false;
                }
            }
        }

        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    public static boolean hasPlayerWon(char[][] board, char playerSymbol) {
        if ((board[0][0] == playerSymbol && board[0][1] == playerSymbol && board[0][2] == playerSymbol) ||
                (board[1][0] == playerSymbol && board[1][1] == playerSymbol && board[1][2] == playerSymbol) ||
                (board[2][0] == playerSymbol && board[2][1] == playerSymbol && board[2][2] == playerSymbol) ||

                (board[0][0] == playerSymbol && board[1][0] == playerSymbol && board[2][0] == playerSymbol) ||
                (board[0][1] == playerSymbol && board[1][1] == playerSymbol && board[2][1] == playerSymbol) ||
                (board[0][2] == playerSymbol && board[1][2] == playerSymbol && board[2][2] == playerSymbol) ||

                (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
                (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol)) {
            return true;
        }
        return false;
    }

    public static void gameLoop(char[][] board, Scanner scanner){
        boolean isUserDone = false;
        
        System.out.println("Welcome to Tic-Tac-Toe!");

        while(!isUserDone) {
            Integer gameModeInput = 0;

            while(gameModeInput != 1 && gameModeInput != 2) {
                System.out.print("Please choose a game mode:\n \n(1) Human vs. human game.\n(2) Human vs. computer game.\n");
                String input  = scanner.nextLine();

                if (input.matches("-?\\d+")) {
                    int value = Integer.parseInt(input);
                    if (value == 1 || value == 2) {
                        gameModeInput = value;
                    } else {
                        System.out.println("That is not a valid input! Please enter 1 or 2. ");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }

            
            System.out.println("Let's begin!");

            boolean isGameFinished = false;
            String playerOneName = "Player one";
            String playerTwoName = (gameModeInput == 2) ? "Computer" : "Player two";

            while(!isGameFinished){
                printBoard(board);
                playerTurn(board, scanner, 'X');
                


                isGameFinished = isGameFinished(board, playerOneName, playerTwoName);


                if (!isGameFinished) {
                    if (gameModeInput == 2) {
                        AiTurn(board, 'O');
                        isGameFinished = isGameFinished(board, playerOneName, playerTwoName);
                    } else {
                        printBoard(board);
                        playerTurn(board, scanner, 'O');
                        isGameFinished = isGameFinished(board, playerOneName, playerTwoName);
                    }
                }
            }

            resetBoard(board);
            int continueInput = 0;
            while(continueInput != 1 && continueInput != 2) {
                System.out.print("Would you like to play again?\n(1) Yes \n(2) No\n");
                String input  = scanner.nextLine();

                if (input.matches("-?\\d+")) {
                    int value = Integer.parseInt(input);
                    if (value == 1 || value == 2) {
                        continueInput = value;
                    } else {
                        System.out.println("That is not a valid input! Please enter 1 or 2. ");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }
            if (continueInput == 2) {
                isUserDone = true;
            }

        }

        System.out.println("Have a great day! Hope you enjoyed my Tic-Tac-Toe game!");
    }
    

    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        Scanner scanner = new Scanner(System.in);
        gameLoop(board, scanner);
    }
}
