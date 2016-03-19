package com.sudoku.restservice.constants;

/**
 * This class contains the multi-dimensional constant(s) for the Sudoku array matrix
 * grid used within the Sudoku rest service project.
 *
 * @author Simon Njenga
 * @since 0.1
 */
public class SudokuGrid {

    /**
     * Private constructor.
     */
    private SudokuGrid() {
        throw new IllegalStateException("Utility class - cannot instantiate!");
    }

    /**
     * Contains integers representing the matrix values in a Sudoku grid puzzle.
     */
    public static final int[][] GRID = {
        { 7, 0, 0, 0, 4, 0, 5, 3, 0 },
        { 0, 0, 5, 0, 0, 8, 0, 1, 0 },
        { 0, 0, 8, 5, 0, 9, 0, 4, 0 },
        { 5, 3, 9, 0, 6, 0, 0, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 0, 5 },
        { 8, 0, 0, 7, 2, 0, 9, 0, 0 },
        { 9, 0, 7, 4, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 5, 7, 0, 0, 0 },
        { 6, 0, 0, 0, 0, 0, 0, 5, 0 }
    };
}