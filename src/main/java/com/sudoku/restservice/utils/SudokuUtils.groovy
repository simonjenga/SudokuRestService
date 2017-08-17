package com.sudoku.restservice.utils

import org.springframework.stereotype.Component

/**
 * This utility class {@code SudokuUtils} contains methods used within this project.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Component("sudokuUtils")
public class SudokuUtils {

    /**
     * Check only the first character of the {@code String} input parameter on whether it is a digit.
     * @param input the input parameter to be tested.
     * @return Returns {@code true} if the character is a digit; {@code false} otherwise.
     */
    public boolean isDigit(String input) {
        return Character.isDigit(input.toCharArray()[0]);
    }
}
