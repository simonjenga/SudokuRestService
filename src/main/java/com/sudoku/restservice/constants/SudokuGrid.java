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
     * Contains integers representing the matrix values in a Sudoku grid puzzle used during production.
     * This grid puzzle is INCOMPLETE and the values with '0' are the one to be filled to make it full.
     */
    public static final int[][] GRID_PROD = {
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
    
    /**
     * Contains integers representing the TEST matrix values in a Sudoku grid puzzle used during test.
     * This grid puzzle is COMPLETE with all the values. This grid puzzle represents the full Sudoku.
     */
    public static final int[][] GRID_TEST = {
    	{ 7, 9, 2, 1, 4, 6, 5, 3, 8 },
		{ 4, 6, 5, 2, 3, 8, 7, 1, 9 },
		{ 3, 1, 8, 5, 7, 9, 6, 4, 2 },
		{ 5, 3, 9, 8, 6, 4, 2, 7, 1 },
		{ 2, 7, 6, 9, 1, 3, 4, 8, 5 },
		{ 8, 4, 1, 7, 2, 5, 9, 6, 3 },
		{ 9, 5, 7, 4, 8, 1, 3, 2, 6 },
		{ 1, 2, 3, 6, 5, 7, 8, 9, 4 },
		{ 6, 8, 4, 3, 9, 2, 1, 5, 7 }
    };
}