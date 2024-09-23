package com.csc;

import java.util.Scanner;

import static java.lang.Character.isDigit;

public class TicTacToe {

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
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

    public static boolean isGameFinished(char[][] board) {

        if (hasPlayerWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player one wins!");
            return true;
        }

        if (hasPlayerWon(board, 'O')) {
            printBoard(board);
            System.out.println("Player two wins!");
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

    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            playerTurn(board, scanner, 'X');

            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            playerTurn(board, scanner, 'O');
        }
        scanner.close();
    }
}
