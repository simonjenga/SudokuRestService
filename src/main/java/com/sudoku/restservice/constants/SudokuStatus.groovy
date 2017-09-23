package com.sudoku.restservice.constants

/**
 * This class {@code SudokuStatus} contains several constants for various "STATUS" used within this
 * Sudoku rest service project.
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
     * Invalid move.
     */
    public static final String INVALID_MOVE = "INVALID_MOVE";

    /**
     * Invalid input.
     */
    public static final String INVALID_INPUT = "INVALID_INPUT";

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
     * Only three arguments are allowed.
     */
    public static final String ONLY_THREE_PARAMETERS_ARE_ALLOWED = "ONLY_THREE_PARAMETERS_ARE_ALLOWED";

    /**
     * Only number parameters are allowed.
     */
    public static final String ONLY_NUMBER_PARAMETERS_ARE_ALLOWED = "ONLY_NUMBER_PARAMETERS_ARE_ALLOWED";

}
