package com.sudoku.restservice.service;

import org.springframework.stereotype.Service;

import com.sudoku.restservice.constants.SudokuStatus;

/**
 * This service class {@code SudokuService} contains the logic for solving the Sudoku puzzle.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@Service("sudokuService")
public class SudokuService {

    /**
     * Inserts the specified value on the Sudoku grid puzzle.
     *
     * @param row, the specified row in the Sudoku grid puzzle.
     * @param column, the specified column in the Sudoku grid puzzle.
     * @param value, the value to be inserted in the Sudoku grid puzzle.
     * @param grid, the Sudoku grid puzzle.
     * @return the status result of the action that has been performed.
     */
    public String insertValuesOnSudokuPuzzle(int row, int column, int value, int[][] grid) {
        if ((row < 0 || row > 8) || (column < 0 || column > 8) || (value < 1 || value > 9)) {
            return SudokuStatus.INVALID_INPUT;
        } else {
            if (this.validateMovesOnSudokuPuzzle(row, column, value, grid).equals(SudokuStatus.VALID_MOVE)) {
                // insert that valid value/move into the Sudoku puzzle
                grid[row][column] = value;

                //check if the Sudoku puzzle has been filled up with values
                if (this.getFreeCellList(grid) == 0) {
                    // Sudoku puzzle is complete because there are no more empty/free cells
                    return SudokuStatus.VALID_MOVE_SUDOKU_COMPLETE;
                } else {
                    // Sudoku puzzle is still not yet complete! because there are more empty/free cells
                    return SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
                }
            } else {
                return SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
            }
        }
    }

    /**
     * Validate moves on the Sudoku grid puzzle.
     *
     * @param row, the specified row in the Sudoku grid puzzle.
     * @param column, the specified column in the Sudoku grid puzzle.
     * @param value, the value to be inserted in the Sudoku grid puzzle.
     * @param grid, the Sudoku grid puzzle.
     * @return the status result of the action that has been performed.
     */
    private String validateMovesOnSudokuPuzzle(int row, int column, int value, int[][] grid) {
        if (this.isValid(grid, row, column, value)) {
            return SudokuStatus.VALID_MOVE;
        } else {
            return SudokuStatus.INVALID_MOVE;
        }
    }

    /**
     * Obtain the number of free cells from the Sudoku grid puzzle.
     *
     * @param grid, the Sudoku grid puzzle.
     * @return the number of free cells in the Sudoku grid puzzle.
     */
    private int getFreeCellList(int[][] grid) {
        // Determine the number of free cells
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String cellValue = String.valueOf(grid[i][j]);
                if (cellValue.isEmpty() || cellValue.equals("0")) {
                    numberOfFreeCells++;
                }
            }
        }
        // return the number of free cells from the Sudoku puzzle
        return numberOfFreeCells;
    }

    /**
     * Is the specified value valid in the specified row and column in the Sudoku grid puzzle?
     *
     * @param grid, the Sudoku grid puzzle.
     * @param row, the specified row in the Sudoku grid puzzle.
     * @param column, the specified column in the Sudoku grid puzzle.
     * @param value, the value to be checked if it is valid in the Sudoku grid puzzle.
     * @return {@code true} if the value is valid; {@code false} otherwise
     */
    private boolean isValid(int[][] grid, int row, int column, int value) {
        // Check whether grid[i][j] is valid at the i's row
        for (int inColumn = 0; inColumn < 9; inColumn++) {
            if (inColumn != column && grid[row][inColumn] == value) {
                // The current value at grid[i][j] is invalid
                return false;
            }
        }

        // Check whether grid[i][j] is valid at the j's column
        for (int inRow = 0; inRow < 9; inRow++) {
            if (inRow != row && grid[inRow][column] == value) {
                // The current value at grid[i][j] is invalid
                return false;
            }
        }

        // Check whether grid[i][j] is valid in the 3 by 3 box
        for (int inRow = (row / 3) * 3; inRow < (row / 3) * 3 + 3; inRow++) {
            for (int inColumn = (column / 3) * 3; inColumn < (column / 3) * 3 + 3; inColumn++) {
                if (inRow != row && inColumn != column && grid[inRow][inColumn] == value) {
                    // The current value at grid[i][j] is invalid
                    return false;
                }
            }
        }
        // The current value at grid[i][j] is valid
        return true;
    }
}
