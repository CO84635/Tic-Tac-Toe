package com.csc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestTicTacToe {

    TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void testValidMove() {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        assertTrue(TicTacToe.isValidMove(board, 1));
    }

    @Test
    void testInvalidMoveUnderRange() {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.isValidMove(board, -10));
    }

    @Test
    void testInvalidMoveOverRange() {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.isValidMove(board, 10));
    }

    @Test
    void testInvalidMovePlayer1() {
        char[][] board = {{'X','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.isValidMove(board, 1));
    }

    @Test
    void testInvalidMovePlayer2() {
        char[][] board = {{'O','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.isValidMove(board, 1));
    }

    @Test
    void testPlayerOneWinningRowOne() {
        char[][] board = {{'X','X','X'},{'4','5','6'},{'7','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningRowTwo() {
        char[][] board = {{'1','2','3'},{'X','X','X'},{'7','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningRowThree() {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'X','X','X'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningColumnOne() {
        char[][] board = {{'X','2','3'},{'X','5','6'},{'X','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningColumnTwo() {
        char[][] board = {{'1','X','3'},{'4','X','6'},{'7','X','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningColumnThree() {
        char[][] board = {{'1','2','X'},{'4','5','X'},{'7','8','X'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningDiagonalOne() {
        char[][] board = {{'X','2','3'},{'4','X','6'},{'7','8','X'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerOneWinningDiagonalTwo() {
        char[][] board = {{'1','2','X'},{'4','X','6'},{'X','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerTwoWinningRowOne() {
        char[][] board = {{'O','O','O'},{'4','5','6'},{'7','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningRowTwo() {
        char[][] board = {{'1','2','3'},{'O','O','O'},{'7','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningRowThree() {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'O','O','O'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningColumnOne() {
        char[][] board = {{'O','2','3'},{'O','5','6'},{'O','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningColumnTwo() {
        char[][] board = {{'1','O','3'},{'4','O','6'},{'7','O','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningColumnThree() {
        char[][] board = {{'1','2','O'},{'4','5','O'},{'7','8','O'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningDiagonalOne() {
        char[][] board = {{'O','2','3'},{'4','O','6'},{'7','8','O'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoWinningDiagonalTwo() {
        char[][] board = {{'1','2','O'},{'4','O','6'},{'O','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerOneNotWinning() {
        char[][] board = {{'X','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.hasPlayerWon(board, 'X'));
    }

    @Test
    void testPlayerTwoWinning() {
        char[][] board = {{'O','O','O'},{'4','5','6'},{'7','8','9'}};
        assertTrue(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testPlayerTwoNotWinning() {
        char[][] board = {{'O','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(TicTacToe.hasPlayerWon(board, 'O'));
    }

    @Test
    void testIsGameFinishedGameWon() {
        char[][] board = {{'X','X','X'},{'4','5','6'},{'7','8','9'}};
        assertTrue(ticTacToe.isGameFinished(board));
    }

    @Test
    void testIsGameFinishedGameDraw() {
        char[][] board = {{'X','O','X'},{'O','X','O'},{'O','X','O'}};
        assertTrue(ticTacToe.isGameFinished(board));
    }

    @Test
    void testTheGameIsContinued() {
        char[][] board = {{'X','2','3'},{'4','5','6'},{'7','8','9'}};
        assertFalse(ticTacToe.isGameFinished(board));
    }

}
