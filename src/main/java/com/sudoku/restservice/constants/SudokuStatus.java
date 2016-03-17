package com.sudoku.restservice.constants;

/**
 * This class contains constants for "STATUSes" used within the Sudoku rest service project.
 *
 * @author Simon Njenga
 * @since 0.1
 */
public class SudokuStatus {

    /**
     * Private constructor.
     */
    private SudokuStatus() {
        throw new IllegalStateException("Utility class - cannot instantiate!");
    }

    /**
     * Valid move.
     */
    public static final String VALID_MOVE = "VALID_MOVE";

    /**
     * Valid move sudoku complete.
     */
    public static final String VALID_MOVE_SUDOKU_COMPLETE = "VALID_MOVE_SUDOKU_COMPLETE";

    /**
     * Valid move sudoku not complete.
     */
    public static final String VALID_MOVE_SUDOKU_NOT_COMPLETE = "VALID_MOVE_SUDOKU_NOT_COMPLETE";

    /**
     * Valid move sudoku not complete.
     */
    public static final String INVALID_MOVE_SUDOKU_NOT_COMPLETE = "INVALID_MOVE_SUDOKU_NOT_COMPLETE";

    /**
     * Invalid move.
     */
    public static final String INVALID_MOVE = "INVALID_MOVE";

    /**
     * Invalid input.
     */
    public static final String INVALID_INPUT = "INVALID_INPUT";

    /**
     * Solution found.
     */
    public static final String SOLUTION_FOUND = "SOLUTION_FOUND";

    /**
     * Solution not found.
     */
    public static final String SOLUTION_NOT_FOUND = "SOLUTION_NOT_FOUND";
}